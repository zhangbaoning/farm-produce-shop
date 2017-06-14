<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangbaoning
  Date: 2017/5/26
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>网上商城</title>
<link href="./css/common.css" rel="stylesheet" type="text/css">
<link href="./css/product.css" rel="stylesheet" type="text/css">
<script>
    function formSubmit() {
        document.getElementById("submit_cart").submit();
    }
    function increaseCount() {  //数量增加
        var num = document.getElementById("quantity");
        num.value = parseInt(num.value) + 1;

    }
    function decreaseCount() {  //数量减小
        var num = document.getElementById("quantity");
        var num1 = num.getAttribute("value");
        document.write(num1);
        if (parseInt(num1)>1){
        num1 = parseInt(num1) - 1;
        }
    }
</script>
</head>
<body>
<div class="container header">
    <jsp:include page="menue.jsp"/>
</div>
<div class="container productContent">
    <div class="span6">
        <div class="hotProductCategory">
            <s:iterator value="#session.all_category" var="all_category">
                <dl>
                    <dt>
                        <a href="./蔬菜分类.htm"><s:property value="#all_category.cname"/></a>
                    </dt>
                    <s:iterator var="secend_category" value="#all_category.categorysecondSet">
                        <dd>
                            <a><s:property value="#secend_category.csname"/> </a>
                        </dd>
                    </s:iterator>
                </dl>
            </s:iterator>
        </div>


    </div>
    <div class="span18 last">

        <div class="productImage">
            <a title="" style="outline-style: none; text-decoration: none;" id="zoom"
               href="${pageContext.request.contextPath}/<s:property value="model.image"/>" rel="gallery">
                <div class="zoomPad"><img style="opacity: 1;" title="" class="medium"
                                          src="${pageContext.request.contextPath}/<s:property value="model.image"/>">
                    <div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;"
                         class="zoomPup"></div>
                    <div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;"
                         class="zoomWindow">
                        <div style="width: 368px;" class="zoomWrapper">
                            <div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div>
                            <div style="width: 0%; height: 0px;" class="zoomWrapperImage"><img
                                    src="%E5%B0%9A%E9%83%BD%E6%AF%94%E6%8B%89%E5%A5%B3%E8%A3%852013%E5%A4%8F%E8%A3%85%E6%96%B0%E6%AC%BE%E8%95%BE%E4%B8%9D%E8%BF%9E%E8%A1%A3%E8%A3%99%20%E9%9F%A9%E7%89%88%E4%BF%AE%E8%BA%AB%E9%9B%AA%E7%BA%BA%E6%89%93%E5%BA%95%E8%A3%99%E5%AD%90%20%E6%98%A5%E6%AC%BE%20-%20Powered%20By%20Mango%20Team_files/6d53c211-2325-41ed-8696-d8fbceb1c199-large.jpg"
                                    style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;">
                            </div>
                        </div>
                    </div>
                    <div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">
                        Loading zoom
                    </div>
                </div>
            </a>

        </div>
        <div class="name"><s:property value="model.pname"/></div>
        <div class="sn">
            <div>编号：<s:property value="model.pid"/></div>
        </div>
        <div class="info">
            <dl>
                <dt>亿家价:</dt>
                <dd>
                    <strong><s:property value="model.shopPrice"/> </strong>
                    参 考 价：
                    <del>￥<s:property value="model.marketPrice"/>元/份</del>
                </dd>
            </dl>
            <dl>
                <dt>促销:</dt>
                <dd>
                    <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
                </dd>
            </dl>
            <dl>
                <dt></dt>
                <dd>
                    <span>    </span>
                </dd>
            </dl>
        </div>
        <div class="action">
            <%--TODO 添加提交action--%>
            <form id="submit_cart" action="cart_addCart.action " method="get">
                <%--将隐藏的文本框传到表单去--%>
                <input name="pid" value="<s:property value="model.pid"/>" hidden>
                <dl class="quantity">
                    <dt>购买数量:</dt>
                    <dd>
                        <input id="quantity" name="count" value="1" maxlength="4" onpaste="return false;"
                               type="text">
                        <div>
                            <span id="increase" class="increase" onclick="increaseCount()">&nbsp;</span>
                            <span id="decrease" class="decrease" onclick="decreaseCount()">&nbsp;</span>
                        </div>
                    </dd>
                    <dd>
                        件
                    </dd>
                </dl>
                <div class="buy">
                    <input id="addCart" onclick="formSubmit()" class="addCart" value="加入购物车" type="button">

                </div>
            </form>
        </div>
        <div id="bar" class="bar">
            <ul>
                <li id="introductionTab">
                    <a href="#introduction">商品介绍</a>
                </li>

            </ul>
        </div>

        <div id="introduction" name="introduction" class="introduction">
            <div class="title">
                <strong><s:property value="model.pdesc"/> </strong>
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/<s:property value="model.image" />"/>
            </div>
        </div>


    </div>
</div>
<div class="container footer">
    <div class="span24">
        <div class="footerAd">
            <img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
        </div>
    </div>
    <div class="span24">
        <ul class="bottomNav">
            <li>
                <a href="#">关于我们</a>
                |
            </li>
            <li>
                <a href="#">联系我们</a>
                |
            </li>
            <li>
                <a href="#">诚聘英才</a>
                |
            </li>
            <li>
                <a href="#">法律声明</a>
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
                <a target="_blank">配送方式</a>
                |
            </li>
            <li>
                <a>SHOP++官网</a>
                |
            </li>
            <li>
                <a>SHOP++论坛</a>

            </li>
        </ul>
    </div>
    <div class="span24">
        <div class="copyright">Copyright © 2017-2017 网上商城 版权所有</div>
    </div>
</div>
</body>
</html>
