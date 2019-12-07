<%--
  Created by IntelliJ IDEA.
  User: 15067
  Date: 2019/7/19
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <script src="js/jquery-3.3.1.min.js"></script>
  <script>

    function fun() {
      //发送异步请求
      $.ajax({
        url:"ajaxServlet",
        type:"POST",
        //data:"username=jack&age=23",
        data:{"username":"王一宁","age":23},
        success:function (data) {
          //相映成功后的
          alert("data");
        },
        dataType:"text" //设置接受数据的响应格式
      });


    }
  </script>
</head>
<body>
<input type="button" value="发送异步请求" onclick="fun();">
<input>
