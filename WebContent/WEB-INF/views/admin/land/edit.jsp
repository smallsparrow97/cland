<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp"%>
<div class="row">
	<form class="form" action="${pageContext.request.contextPath}/admin/land/edit/${objLand.lid}/${page}" method="post" 
		enctype="multipart/form-data">
         <div class="col-md-12 panel-info">
             <div class="content-box-header panel-heading">
                 <div class="panel-title ">Sửa tin tức</div>
             </div>
             <c:if test="${not empty msg}">
			    <div class="alert alert-warning" role="alert">
			  		${msg}
				</div>
			 </c:if>
             <div class="content-box-large box-with-header">
                 <div>
                     <div class="row mb-10"></div>
					 <c:if test="${objLand ne null}">
	                     <div class="row">
	                         <div class="col-sm-8">
	                             <div class="form-group">
	                                 <label for="lname">Tên tin tức</label>
	                                 <form:errors path="objLand.lname" cssClass="error"></form:errors>
	                                 <input type="text" name="lname" id="lname" value="${objLand.lname}" class="form-control" placeholder="Nhập tên tin">
	                             </div>
	
	                             <div class="form-group">
	                                 <label for="category">Danh mục tin</label>
	                                 <select class="form-control" name="cid">
	                                 	<c:if test="${not empty listCat}">
	                                 		<c:forEach items="${listCat}" var="objCat">
	                                 			<c:set var="selected" value=""></c:set>
	                                 			<c:if test="${objLand.cid == objCat.cid}">
	                                 				<c:set var="selected" value="selected"></c:set>
	                                 			</c:if>
											   	<option ${selected} value="${objCat.cid}">${objCat.cname}</option>
										   	</c:forEach>
										</c:if>
									 </select>
	                             </div>
	
								 <div class="row">
								 	<div class="col-sm-8">
		                         		<label>Thêm hình ảnh</label>
		                                <input type="file" name="hinhanh" onchange="readURL(this);" class="btn btn-default" id="exampleInputFile1">
		                                <p class="help-block"><em>Định dạng: jpg, png, jpeg,...</em></p>
		                                <img id="img" alt="" src="" width="150" />
		                            </div>
		                            <div class="col-sm-4">
		                            	<label>Hình ảnh cũ</label>
		                            	<p id="deleteCheckBox" hidden="true"><input type="checkbox" name="deleteImage" id="checkbox" /> Xóa</p>
		                            	<p><img alt="" src="${pageContext.request.contextPath}/pathUrl/files/${objLand.picture}" width="150" /></p>
		                            </div>
								 </div>
	                             
	                             
	                             <div class="form-group">
	                                 <label for="area">Diện tích</label>
	                                 <form:errors path="objLand.area" cssClass="error"></form:errors>
	                                 <input type="text" value="${objLand.area}" name="area" id="area" class="form-control" placeholder="Nhập diện tích">
	                             </div>
	                             
	                             <div class="form-group">
	                                 <label for="address">Địa chỉ</label>
	                                 <form:errors path="objLand.address" cssClass="error"></form:errors>
	                                 <input type="text" value="${objLand.address}" name="address" id="address" class="form-control" placeholder="Nhập địa chỉ">
	                             </div>
	
	                             <div class="form-group">
	                                 <label for="description">Mô tả</label>
	                                 <form:errors path="objLand.description" cssClass="error"></form:errors>
	                                 <textarea name="description" id="description" class="form-control" rows="3">${objLand.description}</textarea>
	                             </div>
	                         </div>
	
	                         <div class="col-sm-6"></div>
	
	                         <div class="col-sm-8">
	                             <div class="form-group">
	                                 <label for="detail">Chi tiết</label>
	                                 <form:errors path="objLand.detail" cssClass="error"></form:errors>
	                                 <textarea name="detail" id="detail" class="form-control" rows="7">${objLand.detail}</textarea>
	                             </div>
	                         </div>
	                     </div>
                     </c:if>

                     <hr>

                     <div class="row">
                         <div class="col-sm-12">
                             <input type="submit" value="Cập nhật" class="btn btn-success" />
                             <input type="reset" value="Nhập lại" class="btn btn-default" />
                         </div>
                     </div>

                 </div>
             </div>
         </div>
         </form>
     </div>
     <!-- /.row col-size -->
<script>
	var editor = CKEDITOR.replace("detail");
	CKFinder.setupCKEditor(editor, '${pageContext.request.contextPath}/adminUrl/js/ckfinder');
</script>
<script>
	$().ready(function () {
		// validate form when it submited
		$('.form').validate({
			errorPlacement: function(error, element) {
				$(element).closest("form").find("label[for='"+ element.attr("id") + "']").append(error); 
			},
			ignore: [],
			rules:{
				lname: {
					required: true,
					maxlength: 100,
				},
				area: {
					required: true,
					number: true,
				},
				address: {
					required: true,
				},
				description: {
					required: true,
				},
				detail:{
	               required: function() 
	               {
	                	CKEDITOR.instances.detail.updateElement();
	               },

	               minlength: 10
	           }
			},
			messages:{
				lname: {
					required: " (Vui lòng nhập trường này)",
					maxlength:" (Vui lòng nhập không quá 20 ký tự)",
				},
				area: {
					required: " (Vui lòng nhập trường này)",
					number:" (Vui lòng nhập diện tích hợp lệ)"
				},
				address: {
					required: " (Vui lòng nhập trường này)",
				},
				description: {
					required: " (Vui lòng nhập trường này)",
				},
				detail: {
	                required:" (Vui lòng nhập trường này)",
	                minlength:" (Vui lòng nhập ít nhất 10 ký tự)"
	            },
			},
		});
	});
</script>
<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#img').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
            // checked checkbox
            document.getElementById("deleteCheckBox").hidden = false;
            document.getElementById("checkbox").checked = true;
        }
    }
</script>