<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>支付跳转页</title>
    <base href="http://localhost:8080/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: #ff0000;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
    <span class="wel_word"></span>
</div>

<div id="main">

    <h1>对不起!您余额不足，支付失败！ <a href="${pageContext.request.contextPath}/cart/showCart">返回</a></h1>

</div>

<div id="bottom">
		<span>
			欢迎来到CZY书城
		</span>
</div>
</body>
</html>