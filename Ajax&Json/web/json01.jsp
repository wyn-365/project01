
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        //定义基本格式
        var person = {"name":"王一宁","age":23,"gender":true}

        /*alert(person);*/
        //嵌套格式
         var persons = {"persons":[
             {"name":"王一宁"},{"age":23},{"gender":true},
             {"name":"泽泽"},{"age":23},{"gender":true},
             {"name":"王一宁"},{"age":23},{"gender":true}
             ]};
         /*alert(persons);*/

         //如何获取json中的数据呢？？？？？？？？？？？？？？？？？
            //var name = person.name;/*第一种方式*/
            var person1 = person["name"];

            /*alert(person1);*/

        //获取数组中的值呢？？？？？？？？？？？？？？？？？？？？？？
        var name1 = persons.persons[2].name;
        alert(name1);

    </script>
</head>
<body>

</body>
</html>
