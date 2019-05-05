<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
<div class="row">
         <div class="col-md-12 panel-info">
             <div class="content-box-header panel-heading">
                 <div class="panel-title ">Thêm người dùng</div>
             </div>
             <c:if test="${not empty msgError}">
			    <div class="alert alert-warning" role="alert">
			  		${msgError}
				</div>
			</c:if>
             <form action="${pageContext.request.contextPath}/admin/user/add" method="post">
	             <div class="content-box-large box-with-header">
	                 <div>
	                     <div class="row mb-10"></div>
	
	                     <div class="row">
	                         <div class="col-sm-6">
	                             <div class="form-group">
	                                 <label for="name">Tên đăng nhập</label>
	                                 <input type="text" value="" class="form-control" name="username" required="required">
	                             </div>
	                             
	                             <div class="form-group">
	                             	 <label for="name">Họ tên</label>
	                                 <input type="text" value="" class="form-control" name="fullname" required="required">
	                             </div>
	                             
	                             <div class="form-group">
	                             	 <label for="name">Mật khẩu</label>
	                                 <input type="text" value="" class="form-control" name="password" required="required">
	                             </div>
	                             
	                             <div class="form-group">
	                                 <label>Chức vụ</label>
	                                 <select class="form-control" name="role_id">
									 	 <option value="2">Editor</option>
									 	 <option value="3">User</option>
									 </select>
                             	 </div>
	                         </div>
	                     </div>
	                     <hr>
	                     <div class="row">
	                         <div class="col-sm-12">
	                             <input type="submit" value="Thêm" class="btn btn-success" />
	                             <input type="reset" value="Nhập lại" class="btn btn-default" />
	                         </div>
	                     </div>
	
	                 </div>
	             </div>
             </form>
         </div>
     </div>
     <!-- /.row col-size -->