
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 style="background: chartreuse;color: red">

        鼓足勇气拼一把，不仅是为了当下的野心和梦想，
        还为了把这份从容的日子延长。运气更不是托词，
        你要敢于在别人说“你努力了也不行”的时候，马力全开。
        想要步入优秀，就不可不尝试。眼界，气质以及未来的优势取决于
        你选择在这段时间如何投资自己。

    </h1><br>

    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        请传统选择文件<input type="file" name="upload"><br>
        <input type="submit" value="上传文件"><%--submit提交之后，会封装到request域中--%>
    </form><br>

    <form action="user/fileupload2" method="post" enctype="multipart/form-data">
        springmvc方式请选择文件<input type="file" name="upload"><br>
        <input type="submit" value="上传文件"><%--submit提交之后，会封装到request域中--%>
    </form>

</body>
</html>
