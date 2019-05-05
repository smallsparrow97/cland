<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
<div class="content-box-large">
<div class="row">
    <div class="panel-heading">
        <div class="panel-title ">Quản lý tin tức</div>
    </div>
</div>
<hr>
<div class="row">
    <div class="col-md-8">
    	<c:set var="urlAdd" value="${pageContext.request.contextPath}/admin/land/add"></c:set>
        <a href="${urlAdd}" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>
    </div>
    <div class="col-md-4">
        <div class="input-group form">
            <input type="text" class="form-control" placeholder="Search...">
            <span class="input-group-btn">
     			<button class="btn btn-primary" type="button">Search</button>
   			</span>
        </div>
    </div>
</div>
<c:if test="${not empty msg}">
    <div class="alert alert-success" role="alert">
  		${msg}
	</div>
</c:if>
<div class="row">
    <div class="panel-body">
        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Danh mục</th>
                    <th>Lượt đọc</th>
                    <th>Hình ảnh</th>
                    <th>Chức năng</th>
                </tr>
            </thead>
            <tbody>
            	<c:if test="${not empty listLand}">
            		<c:forEach var="objLand" items="${listLand}">
		                <tr class="odd gradeX">
		                    <td>${objLand.lid}</td>
		                    <td>${objLand.lname}</td>
		                    <td>${objLand.cname}</td>
		                    <td class="center">${objLand.count_views}</td>
		                    <td class="center text-center">
		                    	<c:if test="${not empty objLand.picture}">
		                        <img width="150px" src="${pageContext.request.contextPath}/pathUrl/files/${objLand.picture}" />
		                        </c:if>
		                    </td>
		                    <td class="center text-center">
		                   		<c:set var="urlEdit" value="${pageContext.request.contextPath}/admin/land/edit/${objLand.lid}/${page}"></c:set>
		                    	<c:set var="urlDel" value="${pageContext.request.contextPath}/admin/land/del/${objLand.lid}/${page}"></c:set>
            					
		                        <a href="${urlEdit}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
		                        <a href="${urlDel}" onclick="confirm('Bạn có chắc chắn muốn xóa không?')" title="" class="btn btn-danger">
		                        	<span class="glyphicon glyphicon-trash"></span> Xóa</a>
		                    </td>
		                </tr>
	                </c:forEach>
                </c:if>
            </tbody>
        </table>

    <!-- Pagination -->
    <nav class="text-center" aria-label="...">
        <ul class="pagination">
        	<c:set var="classDisableNext" value=""></c:set>
        	<c:set var="classDisablePrevious" value=""></c:set>
        	<c:choose>
           		<c:when test="${1 eq page}">
           			<c:set var="classDisablePrevious" value="disabled"></c:set>
           		</c:when>
           		<c:when test="${sumPage eq page}">
           			<c:set var="classDisableNext" value="disabled"></c:set>
           		</c:when>
           		<c:otherwise>
           			<c:set var="classDisable" value=""></c:set>
           		</c:otherwise>
            </c:choose>
        	
        	<c:if test="${page > 1}">
            	<li class="${classDisablePrevious}"><a href="${pageContext.request.contextPath}/admin/land/index/${page-1}" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
            </c:if>
            
            <c:set var="classActive" value=""></c:set>
            <c:forEach begin="1" end="${sumPage}" var="i">
            	<c:choose>
            		<c:when test="${i eq page}">
            			<c:set var="classActive" value="active"></c:set>
            		</c:when>
            		<c:otherwise>
            			<c:set var="classActive" value=""></c:set>
            		</c:otherwise>
            	</c:choose>
            	<li class="${classActive}"><a href="${pageContext.request.contextPath}/admin/land/index/${i}">${i}</a></li>
            </c:forEach>
            <c:if test="${page < sumPage}">
            	<li class="${classDisableNext}"><a href="${pageContext.request.contextPath}/admin/land/index/${page+1}" aria-label="Next"><span aria-hidden="true">»</span></a></li>
        	</c:if>
        </ul>
    </nav>
    <!-- /.pagination -->

    </div>
</div>
<!-- /.row -->
</div>
<!-- /.content-box-large -->