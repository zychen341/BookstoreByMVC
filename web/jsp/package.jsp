<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <base href="http://localhost:8080/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">背包</span>
    <div>
        <a href="${pageContext.request.contextPath}/cart/showCart">购物车</a>
        <a href="index.jsp">退出登录</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/book/allbook">返回</a>
    </div>
</div>

<div id="main">

    <table>
        <tr>
            <td>编号</td>
            <td>书名</td>
            <td>价格</td>
            <td>数量</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty packageList}">
            <tr>
                <td colspan="5">当前背包为空！</td>
            </tr>
        </c:if>
        <c:if test="${not empty packageList}">
            <c:forEach items="${packageList}" var="pack">
                <tr>
                    <td>${pack.id}</td>
                    <td>${pack.bookName}</td>
                    <td>${pack.price}</td>
                    <td>${pack.bookQuanities}</td>
                    <td><a href="${pageContext.request.contextPath}/package/deletePackageById?id=${pack.id}&&bookQuanities=${pack.bookQuanities}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

</div>

<div id="bottom">
		<span>
			欢迎来到CZY书城
		</span>
</div>
</body>
</html>