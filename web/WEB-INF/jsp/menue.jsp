<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangbaoning
  Date: 2017/5/23
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:debug/>
<div class="span5">
    <div class="logo">
        <a href="./网上商城/index.htm">
            <img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="传智播客"/>
        </a>
    </div>
</div>
<div class="span9">
    <div class="headerAd">
        <img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
    </div>
</div>
<div class="span10 last">
    <div class="topNav clearfix">
        <ul>
            <s:if test="#session.user==null">
            <li id="headerLogin" class="headerLogin" style="display: list-item;">
                <a href="${pageContext.request.contextPath}/user_loginPage.action">登录</a>|
            </li>
            <li id="headerRegister" class="headerRegister" style="display: list-item;">
                <a href="${pageContext.request.contextPath}/user_registerPage.action">注册</a>|
            </li>
            </s:if>
            <s:else>
            <li id="headerUsername">
                <s:property value="#session.user.username"/>
            </li>
            <li id="headerLogout">
                <a href="user_logout.action">[退出]</a>|
            </li>
            </s:else>
            <li>
                <a>会员中心</a>
                |
            </li>
            <li>
                <a>购物指南</a>
                |
            </li>
            <li>
                <a>关于我们</a>

            </li>
        </ul>
    </div>
    <div class="cart">
        <a href="./购物车.htm">购物车</a>
    </div>
    <div class="phone">
        客服热线:
        <strong>96008/53277764</strong>
    </div>
</div>
<div class="span24">
    <ul class="mainNav">
        <li>
            <a href="./index.htm">首页</a>
            |
        </li>
        <li>
            <a href="./蔬菜分类.htm">定制套餐</a>
            |
        </li>
        <li>
            <a>安全频道</a>
            |
        </li>
        <li>
            <a>商城卡</a>
            |
        </li>
        <li>
            <a>蔬菜基地</a>
            |
        </li>
        <li>
            <a>节气养生</a>
            |
        </li>
        <li>
            <a>便民服务</a>
            |
        </li>

    </ul>
</div>

</div>