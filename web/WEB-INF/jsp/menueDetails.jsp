<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangbaoning
  Date: 2017/5/26
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网上商城</title>
    <link href="./css/common.css" rel="stylesheet" type="text/css"/>
    <link href="./css/product.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container header">
    <jsp:include page="menue.jsp"/>
</div>
<div class="container productList">
    <div class="span6">
        <div class="hotProductCategory">
            <s:iterator var="all_category" value="#session.all_category">
                <dl>
                    <dt>
                        <a href="${pageContext.request.contextPath}/category_menueDetails.action?cid=<s:property value="#all_category.cid"/> "><s:property value="#all_category.cname"/> </a>
                    </dt>
                    <s:iterator value="#all_category.categorysecondSet" var="second">
                        <dd>
                            <a href="cateGorysecond_getProductByCs.action?csid=<s:property value="#second.csid"/> ">
                                <s:property value="#second.csname"/></a>
                        </dd>
                    </s:iterator>
                </dl>
            </s:iterator>
        </div>
    </div>
    <div class="span18 last">

        <form id="productForm" action="./image/蔬菜 - Powered By Mango Team.htm" method="get">
            <input type="hidden" id="brandId" name="brandId" value="">
            <input type="hidden" id="promotionId" name="promotionId" value="">
            <input type="hidden" id="orderType" name="orderType" value="">
            <input type="hidden" id="pageNumber" name="pageNumber" value="1">
            <input type="hidden" id="pageSize" name="pageSize" value="20">

            <div id="result" class="result table clearfix">
                <ul>
                    <s:iterator var="product" value="pageBean.list">
                        <li>
                            <a href="${pageContext.request.contextPath}/product_getById.action?pid=<s:property value="#product.pid"/>"/>
                            <img src="${pageContext.request.contextPath}/<s:property value="#product.image"/> "
                                 width="170"
                                 height="170" style="display: inline-block;">

                            <span style='color:green'>
											 <s:property value="#product.pname"/>
											</span>

                            <span class="price">
												商城价： ￥<s:property value="#product.shopPrice"/>/份
											</span>

                            </a>
                        </li>
                    </s:iterator>
                </ul>
            </div>
            <div class="pagination">
                <s:if test="pageBean.page!=1">
                    <s:if test="pageBean.page!=1">
                        <s:if test="cid!=null">
                            <a class="firstPage"
                               href="${pageContext.request.contextPath}/category_menueDetails.action?cid=<s:property value="cid"/>&page=1">&nbsp;</a>
                            <a class="previousPage"
                               href="${pageContext.request.contextPath}/category_menueDetails.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/> ">&nbsp;</a>
                        </s:if>
                        <s:if test="csid!=null">
                            <a class="firstPage"
                               href="${pageContext.request.contextPath}/cateGorysecond_menueDetails.action?csid=<s:property value="cisd"/>&page=1">&nbsp;</a>
                            <a class="previousPage"
                               href="${pageContext.request.contextPath}/cateGorysecond_menueDetails.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page-1"/> ">&nbsp;</a>
                        </s:if>
                    </s:if>
                </s:if>
                <s:iterator begin="1" end="pageBean.totalPage" var="i">

                    <%--当前页面 不可点击--%>
                    <s:if test="pageBean.page==#i">
                        <span class="currentPage"><s:property value="#i"/> </span>
                    </s:if>
                    <s:else>
                        <%--所有页面的图案--%>
                        <s:if test="cid!=null">
                            <a href="${pageContext.request.contextPath}/category_menueDetails.action?cid=<s:property value="cid"/>&page=<s:property value="#i"/> "><s:property
                                    value="#i"/></a>
                        </s:if>
                        <s:if test="csid!=null">
                            <a href="${pageContext.request.contextPath}/cateGorysecond_menueDetails.action?csid=<s:property value="csid"/>&page=<s:property value="#i"/> "><s:property
                                    value="#i"/></a>
                        </s:if>
                    </s:else>
                </s:iterator>
                <s:if test="pageBean.page!=pageBean.totalPage">
                    <s:if test="cid!=null">
                        <a class="nextPage"
                           href="${pageContext.request.contextPath}/category_menueDetails.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/> ">&nbsp;</a>
                        <a class="lastPage"
                           href="${pageContext.request.contextPath}/category_menueDetails.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.totalPage"/> ">&nbsp;</a>
                    </s:if>
                    <s:if test="csid !=null">
                        <a class="nextPage"
                           href="${pageContext.request.contextPath}/cateGorysecond_menueDetails.action?csid<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/> ">&nbsp;</a>
                        <a class="lastPage"
                           href="${pageContext.request.contextPath}/cateGorysecond_menueDetails.action?csid<s:property value="csid"/>&page=<s:property value="pageBean.totalPage"/> ">&nbsp;</a>

                    </s:if>
                </s:if>
            </div>
        </form>
    </div>
</div>
<div class="container footer">
    <div class="span24">
        <div class="footerAd">
            <img src="./image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
        </div>
    </div>
    <div class="span24">
        <ul class="bottomNav">
            <li>
                <a>关于我们</a>
                |
            </li>
            <li>
                <a>联系我们</a>
                |
            </li>
            <li>
                <a>诚聘英才</a>
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
                <a target="_blank">配送方式</a>
                |
            </li>
            <li>
                <a>官网</a>
                |
            </li>
            <li>
                <a>论坛</a>

            </li>
        </ul>
    </div>
    <div class="span24">
        <div class="copyright">Copyright©2017-2017 网上商城 版权所有</div>
    </div>
</div>
</body>
</html>