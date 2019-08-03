<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>if标签</title>
</head>
<body>

<%--
    c: if标签
        1.属性,
           必须属性:test  接收boolean表达式
                如果表达式为true,则显示if标签体内容,如果为false,则不显示标签体内容
           一般情况下,test属性值会结合el表达式一起使用
--%>
<%
    //判断request域中的一个list集合是否为空,如果不为null,则遍历该集合

    List list = new ArrayList();
    list.add("aaa");
    request.setAttribute("list",list);
%>


    <c:if test="true">
        我是真.....
    </c:if>

<c:if test="${not empty list}">
    遍历集合....
</c:if>
</body>
</html>

