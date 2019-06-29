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
    <center><h3>添加旅客信息页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="wp">工作地点</label>
            <input type="text" class="form-control" id="wp" name="wp" placeholder="请输入工作地点">
        </div>

        <div class="form-group">
            <label for="travellerid">身份证号码</label>
            <input type="text" class="form-control" id="travellerid" name="travellerid" placeholder="请输入身份证号">
        </div>

        <div class="form-group">
            <label for="time">出发时间</label>
            <input type="text" class="form-control" id="time" name="time" placeholder="请输入出发时间">
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
            <label for="level">舱位要求</label>
            <input type="text" class="form-control" id="level" name="level" placeholder="请输入舱位要求">
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