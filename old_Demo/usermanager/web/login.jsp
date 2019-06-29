<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>用户首页</title>
</head>
<body>
<div  align="center">
        <a
                href="${pageContext.request.contextPath}/userlist.jsp" style="text-decoration:none;font-size:33px">查询个人订单
        </a><br>
        <a
            href="${pageContext.request.contextPath}/pay.jsp" style="text-decoration:none;font-size:33px">支付订单,打印取票通知和账单
        </a><br>
        <a
            href="${pageContext.request.contextPath}/get.jsp" style="text-decoration:none;font-size:33px">凭取票通知交款取票
        </a>
</div>
</body>
</html>