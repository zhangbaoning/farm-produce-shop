<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangbaoning
  Date: 2017/5/29
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>

    <link href="./css/common.css" rel="stylesheet" type="text/css">
    <link href="./css/cart.css" rel="stylesheet" type="text/css">


</head>
<body>
<div class="container header">
    <jsp:include page="menue.jsp"/>
</div>	<div class="container cart">
    <div class="span24">
        <div class="step step1">

        </div>
        <table>
            <tbody><tr>
                <th>图片</th>
                <th>商品</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            <s:iterator value="#session.all_item" var="item">
                <tr>
                    <td width="60">
                        <input type="hidden" name="id" value="22">
                        <img src="${pageContext.request.contextPath}/<s:property value="#item.product.image"/> ">
                    </td>
                    <td>
                        <a target="_blank"><s:property value="#item.product.pname"/> </a>
                    </td>
                    <td>
                        ￥<s:property value="#item.product.shopPrice"/>
                    </td>
                    <td class="quantity" width="60">
                        <s:property value="#item.count"/>
                    </td>
                    <td width="140">
                        <span class="subtotal">￥<s:property value="#item.item_total"/></span>
                    </td>
                    <td>
                        <a href="javascript:;" class="delete">删除</a>
                    </td>
                </tr>
            </s:iterator>
            </tbody></table>
        <dl id="giftItems" class="hidden" style="display: none;">
        </dl>
        <div class="total">
            <em id="promotion"></em>
            <em>
                登录后确认是否享有优惠
            </em>
            赠送积分: <em id="effectivePoint">596</em>
            商品金额: <strong id="effectivePrice">￥<s:property value="#session.cart.cart_total"/> </strong>
        </div>
        <div class="bottom">
            <a href="cart_clear.action" id="clear" class="clear">清空购物车</a>
            <a href="order_page.action" id="submit" class="submit">提交订单</a>
        </div>
    </div>
</div>
<div class="container footer">
    <div class="span24">
        <div class="footerAd">
            <img src="./image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
        </div>	</div>
    <div class="span24">
        <ul class="bottomNav">
            <li>
                <a >关于我们</a>
                |
            </li>
            <li>
                <a>联系我们</a>
                |
            </li>
            <li>
                <a>招贤纳士</a>
                |
            </li>
            <li>
                <a>法律声明</a>
                |
            </li>
            <li>
                <a>友情链接</a>
                |
            </li>
            <li>
                <a target="_blank">支付方式</a>
                |
            </li>
            <li>
                <a  target="_blank">配送方式</a>
                |
            </li>
            <li>
                <a>服务声明</a>
                |
            </li>
            <li>
                <a>广告声明</a>

            </li>
        </ul>
    </div>
    <div class="span24">
        <div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
    </div>
</div>
</body></html>