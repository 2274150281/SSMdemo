<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/test.do">测试</a>
    <br><br>
    新增用户:<br>
<form action="${pageContext.request.contextPath}/user/add.do">
    name:<input type="text" name="name" id="name"><br>
    age:<input type="text" name="age" id="age"><br>
    <input type="submit" value="提交">
</form><br><br>
删除用户:<form action="${pageContext.request.contextPath}/user/del.do">
        <input type="text" name="id"><input type="submit" value="提交">
    </form><br><br>
查找用户:<br><br>
<form action="${pageContext.request.contextPath}/user/get.do" method="post">
    ID:<input type="text" name="id"><br>
    name:<input type="text" name="name"><br>
    age:<input type="text" name="age"><<br>
    <input type="submit" value="提交">
</form><br><br>
修改用户:<br>
<form action="${pageContext.request.contextPath}/user/update.do" method="post">
    ID:<input type="text" name="id"><br>
    name:<input type="text" name="name"><br>
    age:<input type="text" name="age"><<br>
    <input type="submit" value="提交">
</form>

</body>
</html>
