<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
<div class="row">
         <div class="col-md-12 panel-info">
             <div class="content-box-header panel-heading">
                 <div class="panel-title ">Sửa danh mục</div>
             </div>
             <c:if test="${not empty msgError}">
             	<script type="text/javascript">
             		alert("Có lỗi xảy ra!");
             	</script>
             </c:if>
             <form action="${pageContext.request.contextPath}/admin/cat/edit" method="post">
	             <div class="content-box-large box-with-header">
	                 <div>
	                     <div class="row mb-10"></div>
	
	                     <div class="row">
	                         <div class="col-sm-6">
	                             <div class="form-group">
	                             	 <input type="hidden" value="${objCat.cid}" class="form-control" name="cid">
	                                 <label for="name">Tên danh mục</label>
	                                 <input type="text" value="${objCat.cname}" class="form-control" name="cname">
	                             	 <form:errors path="objCat.cname" cssClass="error"></form:errors>
	                             </div>
	                         </div>
	                     </div>
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