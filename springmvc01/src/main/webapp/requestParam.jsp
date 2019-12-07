<%--
  Created by IntelliJ IDEA.
  User: 15067
  Date: 2019/7/21
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="requestParam/testRequestParam?name=郑泽">requestparam</a>
    <br>

    <form action="requestParam/testRequestBody" method="post">
        <%--数据必须和JavaBean中的属性名称一样--%>
        <%--自定义类型转换器--%>
        用户姓名：<input type="text"  name="username"><br>
        用户年龄：<input type="text"  name="age"><br>
        <input type="submit" value="提交">
    </form>

    <a href="requestParam/testPathVariable/10">testPathVariable</a>
    <br>

    <a href="requestParam/testRequestHeader">testRequestHeader</a>
    <br>

    <a href="requestParam/testCookieValue">获取cookike的值</a>
    <br>

    <form action="requestParam/testModelAttribute" method="post">
        <%--数据必须和JavaBean中的属性名称一样--%>
        <%--自定义类型转换器--%>
        用户姓名：<input type="text"  name="uname"><br>
        用户年龄：<input type="text"  name="age"><br>
        <input type="submit" value="提交">
    </form>
    <br>

    <a href="requestParam/testSessionAttributes">testSessionAttributes</a>
    <br>

</body>
</html>
