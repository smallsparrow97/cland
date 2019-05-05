<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
<div class="content-box-large">
<div class="row">
    <div class="panel-heading">
        <div class="panel-title ">Danh sách liên hệ</div>
    </div>
</div>
<hr>
<div class="row">
    <div class="col-md-8">
        <!-- <a href="" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a> -->
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
                    <th>Tên người gửi</th>
                    <th>Email</th>
                    <th>Chủ đề</th>
                    <th>Nội dung</th>
                    <th>Chức năng</th>
                </tr>
            </thead>
            <tbody>
            	<c:if test="${not empty listContact}">
            		<c:forEach var="objContact" items="${listContact}">
            			<c:set var="urlDel" value="${pageContext.request.contextPath}/admin/contact/del/${objContact.cid}"></c:set>
		                <tr class="odd gradeX">
		                    <td>${objContact.cid}</td>
		                    <td>${objContact.fullname}</td>
		                    <td>${objContact.email}</td>
		                    <td>${objContact.subject}</td>
		                    <td>${objContact.content}</td>
                    		<td class="center text-center">
		                        <a href="${urlDel}" onclick="return confirm('Bạn có chắc chắn muốn xóa không?')" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
	                    	</td>
		                    	
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