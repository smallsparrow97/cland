<%@page import="vn.edu.vinaenter.util.StringUtil"%>
<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
 <div class="clearfix slider">
     <ul class="pgwSlider">
     	<c:if test="${not empty listHotLand}">
     		<c:forEach items="${listHotLand}" var="objLand">
     			<li>
		        	<a href="${pageContext.request.contextPath}/news/${SlugUtil.makeSlug(objLand.lname)}-${objLand.lid}.html">
			        	<img src="${pageContext.request.contextPath}/pathUrl/files/${objLand.picture}" 
			        	alt="" data-description="${objLand.lname}" 
			        	data-large-src="${pageContext.request.contextPath}/pathUrl/files/${objLand.picture}" />
		        	</a>
		        </li>
     		</c:forEach>
     	</c:if>
        <%-- <li>
        	<img src="${pageContext.request.contextPath}/publicUrl/images/thumbs/megamind_07.jpg" 
        	alt="Paris, France" 
        	data-description="Eiffel Tower and Champ de Mars" 
        	data-large-src="${pageContext.request.contextPath}/publicUrl/images/slides/megamind_07.jpg" />
        </li>
        <li>
        	<img src="${pageContext.request.contextPath}/publicUrl/images/thumbs/wall-e.jpg" 
        	alt="Montréal, QC, Canada" 
        	data-large-src="${pageContext.request.contextPath}/publicUrl/images/slides/wall-e.jpg" 
        	data-description="Eiffel Tower and Champ de Mars" />
        </li>
        <li>
        	<img src="${pageContext.request.contextPath}/publicUrl/images/thumbs/up-official-trailer-fake.jpg" 
        	alt="Shanghai, China" 
        	data-large-src="${pageContext.request.contextPath}/publicUrl/images/slides/up-official-trailer-fake.jpg" 
        	data-description="Shanghai ,chaina">
        </li> --%>
     </ul>
 </div>

 <div class="clearfix content">
     <div class="content_title">
         <h2>Bài viết mới</h2>
     </div>

	<c:if test="${not empty listLand}">
		<c:forEach items="${listLand}" var="objLand">
			<div class="clearfix single_content">
				<div class="clearfix post_date floatleft">
					<div class="date">
					<% %>
						<h3>${StringUtil.getDay(objLand.date_create)}</h3>
						<p>Tháng ${StringUtil.getMonth(objLand.date_create)}</p>
					</div>
				</div>
				<div class="clearfix post_detail">
					<h2>
						<a href="${pageContext.request.contextPath}/news/${SlugUtil.makeSlug(objLand.lname)}-${objLand.lid}.html">${objLand.lname}</a>
					</h2>
					<div class="clearfix post-meta">
						<p>
							<span><i class="fa fa-clock-o"></i>${objLand.address}</span> 
							<span><i class="fa fa-folder"></i>${objLand.area}</span>
						</p>
					</div>
					<div class="clearfix post_excerpt">
						<img src="${pageContext.request.contextPath}/pathUrl/files/${objLand.picture}" alt="" />
						<p>${objLand.description}</p>
					</div>
					<a href="${pageContext.request.contextPath}/news/${SlugUtil.makeSlug(objLand.lname)}-${objLand.lid}.html">Đọc thêm</a>
				</div>
			</div>
		</c:forEach>
	</c:if>
</div>

<div class="pagination">
	<nav>
		<ul>
			<c:if test="${page > 1}">
				<li><a href="${pageContext.request.contextPath}/${page-1}"> << </a></li>
			</c:if>
			<c:set var="classActive" value=""></c:set>
			<c:forEach begin="1" end="${sumPage}" var="i">
				<c:choose>
					<c:when test="${i eq page}">
						<span><li><a class="currentPage">${i}</a></li></span>
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/${i}">${i}</a></li>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			<c:if test="${page < sumPage}">
				<li><a href="${pageContext.request.contextPath}/${page+1}"> >> </a></li>
			</c:if>
		</ul>
	</nav>
</div>