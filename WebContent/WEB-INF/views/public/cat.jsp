<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
<div class="clearfix content">
    <div class="content_title">
    	<c:if test="${objCat ne null }">
        	<h2>${objCat.cname}</h2>
        </c:if>
    </div>

    <div class="clearfix single_work_container">
    	<c:if test="${not empty listLand}">
    		<c:forEach items="${listLand}" var="objLand">
		        <div class="clearfix single_work">
		            <img class="img_top" src="${pageContext.request.contextPath}/pathUrl/files/${objLand.picture}" alt="" />
		            <img class="img_bottom" src="${pageContext.request.contextPath}/publicUrl/images/work_bg2.png" alt="" />
		            <h2>${objLand.lname}</h2>
		            <a href="${pageContext.request.contextPath}/news/${SlugUtil.makeSlug(objLand.lname)}-${objLand.lid}.html">
		                <p class="caption">${objLand.description}</p>
		            </a>
		        </div>
		    </c:forEach>
        </c:if>
        

        <div class="clearfix work_pagination">
            <nav>
            	<c:if test="${page > 1}">
                	<a class="newer floatleft" href="${pageContext.request.contextPath}/danh-muc/${SlugUtil.makeSlug(objCat.cname)}-${objCat.cid}/${page-1}">
                		<-- Trang trước
                	</a>
                </c:if>
                <c:if test="${page < sumPage}">
                	<a class="older floatright" href="${pageContext.request.contextPath}/danh-muc/${SlugUtil.makeSlug(objCat.cname)}-${objCat.cid}/${page+1}">
                		Trang kế -->
                	</a>
                </c:if>
            </nav>
        </div>

    </div>
</div>