package com.wang.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jedis.util.JedisPoolUtils;
import com.wang.dao.ProvinceDao;
import com.wang.dao.impl.ProvinceDaoImpl;
import com.wang.domin.Province;
import com.wang.service.ProvinceService;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();


    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     *     使用redis的缓存【不经常变动的数据】
     *     如果变化了数据，需要更新缓存
     */

    @Override
    public String findAllJson() {

        //先从redis中查询数据

        //获取jedis的客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        //判断province——json是否为null,null =null
        if (province_json == null || province_json.length() == 0){
            //缓存中没有数据
            System.out.println("redis缓存中没有数据，请先查询数据库");
            //查询数据库
            List<Province> ps = dao.findAll();

            //list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //将json数据存入到redis缓存中
            jedis.set("province",province_json);

            //归还连接
            jedis.close();

        }else{
            System.out.println("redis有数据，查询的是redis缓存，不用查询数据库了");
        }
        return province_json;
    }
}
