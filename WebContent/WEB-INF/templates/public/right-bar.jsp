<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
<div class="clearfix sidebar">
    <div class="clearfix single_sidebar category_items">
        <h2>Danh mục bất động sản</h2>
        <ul>
        	<c:if test="${not empty listCat}">
    			<c:forEach items="${listCat}" var="objCat">
    				<c:set var="numberLand" value="${landDAO.countItemByCatId(objCat.cid)}"></c:set>
            		<li class="cat-item"><a href="${pageContext.request.contextPath}/danh-muc/${SlugUtil.makeSlug(objCat.cname)}-${objCat.cid}">${objCat.cname}</a>(${numberLand})</li>
            	</c:forEach>
            </c:if>
        </ul>
    </div>

    <div class="clearfix single_sidebar">
        <div class="popular_post">
            <div class="sidebar_title">
                <h2>Xem nhiều</h2>
            </div>
            <ul>
            	<c:if test="${not empty listHotNews}">
    				<c:forEach items="${listHotNews}" var="objLand">
                		<li><a href="${pageContext.request.contextPath}/news/${SlugUtil.makeSlug(objLand.lname)}-${objLand.lid}.html">${objLand.lname} </a></li>
            		</c:forEach>
            	</c:if>
            </ul>
        </div>
    </div>

    <!-- <div class="clearfix single_sidebar">
        <h2>Danh mục hot</h2>
        <ul>
            <li><a href="">Category Name <span>(12)</span></a></li>
            <li><a href="">Category Name <span>(12)</span></a></li>
            <li><a href="">Category Name <span>(12)</span></a></li>
            <li><a href="">Category Name <span>(12)</span></a></li>
        </ul>
    </div> -->
</div>
