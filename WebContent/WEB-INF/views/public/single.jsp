<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
<div class="clearfix content">
	<c:if test="${objLand ne null}">
	    <h1>${objLand.lname}</h1>
	    <div class="clearfix post-meta">
	        <p>
		        <span><i class="fa fa-clock-o"></i> Địa chỉ: ${objLand.address}</span> 
		        <span><i class="fa fa-folder"></i> Diện tích: ${objLand.area}</span>
	        </p>
	    </div>
	
	    <div class="vnecontent">
	        <p>${objLand.detail}</p>
	    </div>
    </c:if>
	
    <!-- <a class="btn" href="">Bài trước</a>
    <a class="btn" href="">Bài kế</a> -->

</div>

<div class="more_themes">
    <h2>Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i></h2>
    <div class="more_themes_container">
	    <c:if test="${not empty listRelateLand}">
	    	<c:forEach items="${listRelateLand}" var="objLand">
		        <div class="single_more_themes floatleft">
		            <img src="${pageContext.request.contextPath}/pathUrl/files/${objLand.picture}" alt="" />
		            <a href="${pageContext.request.contextPath}/news/${SlugUtil.makeSlug(objLand.lname)}-${objLand.lid}.html">
		                <h2>${objLand.lname}</h2>
		            </a>
		        </div>
			</c:forEach>
	    </c:if>
    </div>
</div>