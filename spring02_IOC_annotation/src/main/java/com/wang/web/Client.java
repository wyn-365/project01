package com.wang.web;

import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
import com.wang.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 获取spring容器IOC核心容器，并根据id获取对象
 *
 * 读取完配置文件，立马通过反射机制，创建对象【容器中又什么，采用立即加载的机制创建对象】
 * 而beanfactory采用延迟加载的机制，什么时候用，神魔时候创建对象
 *
 *
 * @1用于创建对象的注解
 *     @Component 当前类对象，存入springIOC容器中  一般用下面的
 *  *      key value是id，不懈的时候，默认值是当前类名首字母小写
 *  * 使得三层对象更加清晰
 *     @Controller       一般用于表现层
 *     @Service         一般用于业务层
 *     @Repository      一般用于持久层
 *  *
 *     @2 用于注入数据的注解
 *      Autowired :自动按照类型注入  可是成员便良和方法
 *     @Resource 可以直接使用name属性
 *     @value 用于基本数据类型和String
 *    属性value用于指定属性值，可以使用spEL  Spring 中的EL表达式 ${}
 *
 *      用于改变作用范围的注解
 *      @Scope用于指定bean的作用范围
 *      value： singleton prototype 单例模式和多例模式
 *  * 生命周期的线管的注解
 *
 */
public class Client {
    public static void main(String[] args) {

        //1.获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.根据id 获取bean对象[ 两种方式获取对象]
        AccountService as = (AccountService)ac.getBean("accountServiceImpl");
        AccountDao adao = ac.getBean("accountDaoImpl",AccountDao.class);
        System.out.println(as);
        as.saveAccount();
    }
}
