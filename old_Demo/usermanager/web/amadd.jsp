<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>添加机票页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="ticketid">航班号</label>
            <input type="text" class="form-control" id="ticketid" name="ticketid" placeholder="请输入航班号">
        </div>

        <div class="form-group">
            <label for="strat">出发地</label>
            <input type="text" class="form-control" id="strat" name="start" placeholder="请输入出发地">
        </div>

        <div class="form-group">
            <label for="end">目的地</label>
            <input type="text" class="form-control" id="end" name="end" placeholder="请输入目的地">
        </div>


        <div class="form-group">
            <label for="starttime">起飞时间</label>
            <input type="text" class="form-control" id="starttime" name="starttime" placeholder="请输入起飞时间">
        </div>

        <div class="form-group">
            <label for="endtime">落地时间</label>
            <input type="text" class="form-control" id="endtime" name="endtime" placeholder="请输入落地时间">
        </div>

        <div class="form-group">
            <label for="first">头等舱余位</label>
            <input type="text" class="form-control" id="first" name="first" placeholder="请输入头等舱余位">
        </div>

        <div class="form-group">
            <label for="second">商务舱余位</label>
            <input type="text" class="form-control" id="second" name="second" placeholder="请输入商务舱余位">
        </div>

        <div class="form-group">
            <label for="third">经济舱余位</label>
            <input type="text" class="form-control" id="third" name="third" placeholder="请输入经济舱余位">
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>