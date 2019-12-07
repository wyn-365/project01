
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--请求参数的绑定--%>
<%--<a href="param/testParam?username=zeze&&password=123456">请求参数的绑定</a>--%>

<%--数据封装到account对象中--%>
    <%--<form action="param/saveAccount" method="post">
        &lt;%&ndash;数据必须和JavaBean中的属性名称一样&ndash;%&gt;
        姓名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        金额：<input type="text" name="money"><br>
        <input type="submit" value="提交">
    </form>--%>


<%--类中存在list 和 map 集合 --%>
<%--<form action="param/saveAccount" method="post">
    &lt;%&ndash;数据必须和JavaBean中的属性名称一样&ndash;%&gt;
    姓名：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    金额：<input type="text" name="money"><br>

        用户姓名：<input type="text"  name="list[0].uname"><br>
        用户年龄：<input type="text"  name="list[0].age"><br>

        用户姓名：<input type="text"  name="map['one'].uname"><br>
        用户年龄：<input type="text"  name="map['one'].age"><br>
    <input type="submit" value="提交">
</form>--%>

<form action="param/saveUser" method="post">
    <%--数据必须和JavaBean中的属性名称一样--%>

    <%--自定义类型转换器--%>
    用户姓名：<input type="text"  name="uname"><br>
    用户年龄：<input type="text"  name="age"><br>
    用户生日：<input type="text"  name="date"><br>

    <input type="submit" value="提交">
</form>

</body>
</html>
