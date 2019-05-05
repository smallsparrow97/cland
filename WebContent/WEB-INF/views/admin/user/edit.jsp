<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
<div class="row">
         <div class="col-md-12 panel-info">
             <div class="content-box-header panel-heading">
                 <div class="panel-title ">Cập nhật người dùng</div>
             </div>
             <c:if test="${not empty msgError}">
             	<script type="text/javascript">
             		alert("Có lỗi xảy ra!");
             	</script>
             </c:if>
             <form action="${pageContext.request.contextPath}/admin/user/edit" method="post">
	             <div class="content-box-large box-with-header">
	                 <div>
	                     <div class="row mb-10"></div>
						 <c:if test="${objUser ne null}">
		                     <div class="row">
		                         <div class="col-sm-6">
		                             <div class="form-group">
		                             	 <input type="hidden" value="${objUser.id}" class="form-control" name="id">
		                                 <label for="name">Tên đăng nhập</label>
		                                 <input type="text" value="${objUser.username}" class="form-control" name="username" readonly="readonly">
		                             </div>
		                             
		                             <div class="form-group">
		                             	 <label for="name">Họ tên</label>
		                                 <input type="text" value="${objUser.fullname}" class="form-control" name="fullname" required="required">
		                             </div>
		                             
		                             <div class="form-group">
		                             	 <label for="name">Mật khẩu</label>
		                                 <input type="text" value="" class="form-control" name="password">
		                             </div>
		                             
		                             <c:if test="${'admin' eq objUserLogin.username}">
		                             	 <c:if test="${'admin' eq objUser.username}">
			                             	 <input type="text" name="role_id" value="${objUser.role_id}" hidden="true">
			                             </c:if>
		                             	 <c:if test="${'admin' ne objUser.username}">
			                             	 <label>Chức vụ</label>
			                             	 <c:set var="selected" value=""></c:set>
			                                 <c:if test="${objUser.role_id == 3}">
			                                 	<c:set var="selected" value="selected"></c:set>
			                                 </c:if>
			                             	 <select class="form-control" name="role_id">
											 	 <option value="2">Editor</option>
											 	 <option value="3" ${selected}>User</option>
											 </select>
										 </c:if>
		                             </c:if>
		                             <c:if test="${'admin' ne objUserLogin.username}">
		                             	 <input type="text" name="role_id" value="${objUser.role_id}" hidden="true">
		                             	 <label>Chức vụ</label>
		                             	 <c:set var="selected" value=""></c:set>
		                                 <c:if test="${objUser.role_id == 3}">
		                                 	<c:set var="selected" value="selected"></c:set>
		                                 </c:if>
		                             	 <select class="form-control" name="role_id" disabled="disabled">
										 	 <option value="2">Editor</option>
										 	 <option value="3" ${selected}>User</option>
										 </select>
		                             </c:if>
		                             
		                         </div>
		                     </div>
		                 </c:if>
	                     <hr>
	                     <div class="row">
	                         <div class="col-sm-12">
	                             <input type="submit" value="Sửa" class="btn btn-success" />
	                         </div>
	                     </div>
	
	                 </div>
	             </div>
             </form>
         </div>
     </div>
     <!-- /.row col-size -->