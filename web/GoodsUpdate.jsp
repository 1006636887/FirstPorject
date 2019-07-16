<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15 0015
  Time: 下午 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="goodsUpdateServlet" method="post">
    <table border="1px">
        <tr>
            <td>商品编号</td>
            <td><input type="text" name="id"  value="${goods.id}"   readonly="readonly" /></td>
        </tr>
        <tr>
            <td>商品名称</td>
            <td> <input type="text" name="goodsInfoName"  value="${goods.goodsInfoName}" /></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <input type="text" name="goodsInfoPic" value="${goods.goodsInfoPic}" />
            </td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td>
                <input type="text" name="goodsInfoPrice" value="${goods.goodsInfoPrice}" />
            </td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td>
                <input type="text" name="goodsInfoDescription" value="${goods.goodsInfoDescription}" />
            </td>
        </tr>
        <tr>
            <td>商品库存</td>
            <td>
                <input type="text" name="goodsStock" value="${goods.goodsStock}" />
            </td>
        </tr>
        <tr>
            <td>商品状态</td>
            <td>
                <input type="text" name="goodsInfoFlag" value="${goods.goodsInfoFlag}" />
            </td>
        </tr>
        <tr>
            <td colspan="7">
                <input type="submit" value="确认修改"  />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
