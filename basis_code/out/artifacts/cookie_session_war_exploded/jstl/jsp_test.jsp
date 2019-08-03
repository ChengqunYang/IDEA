<%@ page import="domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
    <%
        List list = new ArrayList();
        list.add(new User("张三",22,new Date()));
        list.add(new User("李四",21,new Date()));
        list.add(new User("王五",20,new Date()));
        request.setAttribute("list",list);
    %>

<table border="1" width="500" align="center">
    <tr>
       <th>编号</th>
       <th>姓名</th>
       <th>年龄</th>
       <th>生日</th>
    </tr>
    <%--数据行--%>
    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count%2 == 0}">
            <tr bgcolor="aqua">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birthday}</td>
            </tr>
        </c:if>
        <c:if test="${s.count%2 != 0}">
            <tr bgcolor="#7fffd4">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birthday}</td>
            </tr>
        </c:if>


    </c:forEach>
</table>
</body>
</html>
