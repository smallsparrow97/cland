<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
<div class="row">
         <div class="col-md-12 panel-info">
             <div class="content-box-header panel-heading">
                 <div class="panel-title ">Thêm danh mục</div>
             </div>
             <c:if test="${not empty msgError}">
			    <div class="alert alert-warning" role="alert">
			  		${msgError}
				</div>
			</c:if>
             <form action="${pageContext.request.contextPath}/admin/cat/add" method="post" id="form">
	             <div class="content-box-large box-with-header">
	                 <div>
	                     <div class="row mb-10"></div>
	
	                     <div class="row">
	                         <div class="col-sm-6">
	                             <div class="form-group">
	                                 <label for="name">Tên danh mục</label>
	                                 <input type="text" class="form-control" name="cname" placeholder="Nhập tên danh mục" >
	                             	 <form:errors path="objCat.cname" cssClass="error"></form:errors>
	                             </div>
	                         </div>
	                     </div>
	                     <hr>
	                     <div class="row">
	                         <div class="col-sm-12">
	                             <input type="submit" value="Thêm" class="btn btn-success" />
	                         </div>
	                     </div>
	
	                 </div>
	             </div>
             </form>
         </div>
     </div>
     <!-- /.row col-size -->
