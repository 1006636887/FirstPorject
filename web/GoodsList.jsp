<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15 0015
  Time: 下午 7:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    function onUpdate(id) {
        window.location.href="goodsLoadServlet?id="+id;

    }
</script>
<body>
<table border="1" width="700px">
    <caption>商品信息查询</caption>
    <thead>
    <tr>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品图片</th>
        <th>商品价格</th>
        <th>商品简介</th>
        <th>商品库存</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="goods" >
    <tr>
        <td>${goods.id}</td>
        <td>${goods.goodsInfoName}</td>
        <td>${goods.goodsInfoPic}</td>
        <td>${goods.goodsInfoPrice}</td>
        <td>${goods.goodsInfoDescription}</td>
        <td>${goods.goodsStock}</td>
        <td>${goods.goodsInfoFlag}</td>
        <th>
            <input type="button" value="修改" onclick="onUpdate('${goods.id}')" />
            <input type="button" value="删除" onclick="onDelete('${stu.stuNo}')" />
        </th>
    </tr>
    </c:forEach>
    <tr>
        <th colspan="8">
            <input type="button" value="增加" onclick="onInsert()" />
        </th>
    </tr>
    </tbody>
</table>
</body>
</html>
