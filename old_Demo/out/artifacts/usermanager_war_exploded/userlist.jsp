<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <title>用户订单查询页面</title>
</head>
<body>
<div  align="center">
    <h3>用户订单查询</h3>
    <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
        <div class="form-group">
            <label for="exampleInputName2">身份证号</label>
            <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2" >
        </div>
        <div class="form-group">
            <label for="exampleInputName2">订单号</label>
            <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2" >
        </div>
        <button type="submit" class="btn btn-default">查询</button>
    </form>
</div>
</body>
</html>
