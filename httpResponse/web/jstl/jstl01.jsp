
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签choose</title>
</head>
<body>
//test接受一些布尔类型的值, true显示if标签体内容，如果false不显示标签体内容
  没有else情况，可以在顶一个
    <c:if test="true">
        <h1>我是真的</h1>
    </c:if>

    完成数字编号对应星期几的案例
        choose相当于 switch
        when相当于case
        OTHERWISE 相当于default
    <%
        request.setAttribute("number",3);
    %>

    <c:choose><%--父标签--%>
        <c:when test="${number == 1}">星期一</c:when>
        <c:when test="${number == 2}">星期二</c:when>
        <c:when test="${number == 3}">星期三</c:when>
        <c:when test="${number == 4}">星期四</c:when>
        <c:when test="${number == 5}">星期五</c:when>
        <c:when test="${number == 6}">星期六</c:when>
        <c:when test="${number == 7}">星期日</c:when>

        <c:otherwise>输入有误</c:otherwise>
    </c:choose>


<%--forEach相当于for循环--%>

<c:forEach begin="1" end="10" step="1" var="i" >
    ${i}<br>
</c:forEach>
</body>
</html>
