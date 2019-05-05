<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
<div class="content-box-large">
<div class="row">
    <div class="panel-heading">
        <div class="panel-title ">Quản lý người dùng</div>
    </div>
</div>
<hr>
<div class="row">
    <div class="col-md-8">
        <a href="${pageContext.request.contextPath}/admin/user/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

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
<c:if test="${not empty msgSuccess}">
    <div class="alert alert-success" role="alert">
  		${msgSuccess}
	</div>
</c:if>
<c:if test="${not empty msgError}">
    <div class="alert alert-warning" role="alert">
  		${msgError}
	</div>
</c:if>
<div class="row">
    <div class="panel-body">
        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên đăng nhập</th>
                    <th>Họ tên</th>
                    <th>Chức năng</th>
                </tr>
            </thead>
            <tbody>
            	<c:if test="${not empty listUser}">
            		<c:forEach var="objUser" items="${listUser}">
            			<c:set var="urlDel" value="${pageContext.request.contextPath}/admin/user/del/${objUser.id}"></c:set>
            			<c:set var="urlEdit" value="${pageContext.request.contextPath}/admin/user/edit/${objUser.id}"></c:set>
		                <tr class="odd gradeX">
		                    <td>${objUser.id}</td>
		                    <td>${objUser.username}</td>
		                    <td>${objUser.fullname}</td>
		                    
		                    <c:choose>
		                    	<c:when test="${'admin' eq objUserLogin.username}">
		                    		<td class="center text-center">
				                        <a href="${urlEdit}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span> Sửa</a>
				                        <c:if test="${'admin' ne objUser.username}">
				                        	<a href="${urlDel}" onclick="return confirm('Bạn có chắc chắn muốn xóa không?')" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
				                    	</c:if>
			                    	</td>
		                    	</c:when>
		                    	<c:when test="${('admin' ne objUserLogin.username) and (objUser.id == objUserLogin.id)}">
		                    		<td class="center text-center">
		                    			<a href="${urlEdit}" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span> Sửa</a>
		                    		</td>
		                    	</c:when>
		                    </c:choose>
		                    
		                   
		                </tr>
		            </c:forEach>
                </c:if>
            </tbody>
        </table>

        <!-- Pagination -->
    <!-- <nav class="text-center" aria-label="...">
        <ul class="pagination">
            <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
            <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
        </ul>
    </nav> -->
    <!-- /.pagination -->

    </div>
</div>
<!-- /.row -->
</div>
<!-- /.content-box-large -->