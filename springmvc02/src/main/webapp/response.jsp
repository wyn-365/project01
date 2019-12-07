
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script >
        //页面加载
        $(function () {
            $("#btn").click(function () {
                //发送ajax的请求 参数要给哦出地址，和MIME类型
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"zeze","password":"123456","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        //服务器端响应的数据
                        //可以进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                }
                });
            });
        });
    </script>
</head>
<body>
        <a href="user/testString">testString</a> <br>

        <a href="user/testVoid">testVoid</a> <br>

        <a href="user/testModelAndView">testModelAndView</a> <br>

        <button id="btn">发送Ajax异步请求</button>
</body>
</html>
