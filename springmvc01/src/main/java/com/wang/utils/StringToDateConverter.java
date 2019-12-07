package com.wang.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 一个字符串转换成日期
 *
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     *  source是字符串的
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {
        if (source == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型出现错误");
        }

    }
}
