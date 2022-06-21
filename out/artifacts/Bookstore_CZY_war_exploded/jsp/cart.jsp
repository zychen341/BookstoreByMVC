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
    <span class="wel_word">购物车</span>
    <div>
        <a href="${pageContext.request.contextPath}/package/showPackage">我的背包</a>
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
            <td colspan="2">操作</td>
        </tr>
        <c:if test="${empty carts}">
            <tr>
                <td colspan="5">当前购物车为空！</td>
            </tr>
        </c:if>
        <c:if test="${not empty carts}">
            <c:forEach items="${carts}" var="cart">
                <tr>
                    <td>${cart.id}</td>
                    <td>${cart.bookName}</td>
                    <td>${cart.price}</td>
                    <td>${cart.bookQuanities}</td>
                    <td><a href="${pageContext.request.contextPath}/cart/deleteCartById?id=${cart.id}&&bookQuanities=${cart.bookQuanities}">删除</a></td>
                    <td><a href="${pageContext.request.contextPath}/cart/updateCartById?id=${cart.id}">添加</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <c:if test="${not empty carts}">
    <div class="cart_info">
        <span class="cart_span">当前购物车共有<span class="b_count">${carts.size()}</span>件商品</span>
        <span class="cart_span">总金额为
            <span class="b_price">${allprice}
            </span>元
        </span>
        <span class="cart_span"><a href="${pageContext.request.contextPath}/cart/clearCart">清空购物车</a></span>
        <span class="cart_span"><a href="${pageContext.request.contextPath}/cart/pay">买单</a></span>
    </div>
    </c:if>

</div>

<div id="bottom">
		<span>
			欢迎来到CZY书城
		</span>
</div>
</body>
</html>