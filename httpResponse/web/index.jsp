<%--
  Created by IntelliJ IDEA.
  User: 15067
  Date: 2019/7/16
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <p>
响应行：

    状态码都是三位数字：
       1、1xx 没有接收完毕，发送这个状态码
       2、2xx 代表成功，请求是ok的，最常见的状态码
       3、3xx  重定向，302，资源跳转的一种方式，服务器给浏览器的咋混个泰马，告诉他重定向
               304 缓存，例如缓存图片【不会变化，缓存到浏览器的本地，不用交互数据，减轻服务器压力】
       4、客户端错误 404 代表资源位没有找到【请求路径中没有找到资源】
                    405 请求方式没有对应的方法，例如doget或者dopost方法
       5、服务端错误 500 服务器端异常，服务器代码错误

    响应头：
      content-type 服务器告诉浏览器编码格式，解决中文乱码
    响应体：

      字符输出流
      字节输出流


  </p>
  hello,response!
  </body>
</html>
