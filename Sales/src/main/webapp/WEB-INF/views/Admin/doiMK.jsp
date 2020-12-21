<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- tag-libs -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
   
         <%@ include file="/WEB-INF/views/Admin/add/layout-add/inlude-css.jsp"%>
    </style>
</head>

<body class="fix-header">
    <!-- ============================================================== -->
    <!-- Preloader -->
    <!-- ============================================================== -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
        </svg>
    </div>
    <!-- ============================================================== -->
    <!-- Wrapper -->
    <!-- ============================================================== -->
    <div id="wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
       <%@ include file="/WEB-INF/views/Admin/layout-ad/header.jsp"%>
<div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Đổi mật khẩu</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="#">Trang Chủ</a></li>
                            <li class="active">Đổi mật khẩu</li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row row-main">
                   
                    <div class="col-md-12 col-xs-12">
                        <div class="white-box">
                            <form:form class="form-horizontal form-material" modelAttribute="DoiMK" action="/Admin/doiMK" method="post" >
                                <div class="form-group">
                                    <label class="col-md-12">Tên tài khoản</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="User Name" id="UserName" class="form-control form-control-line" path="userName" /> </div>
                                </div>
                               
                                <div class="form-group">
                                    <label class="col-md-12">Mật khẩu cũ </label>
                                    <div class="col-md-12">
                                        <form:input type="password" id="OldPassWord"  class="form-control form-control-line" path="passWord" /> </div>
                                </div>
                               
                               <div class="form-group">
                                    <label class="col-md-12">Mật khẩu mới</label>
                                    <div class="col-md-12">
                                        <form:input type="password" id="NewPassWord1" class="form-control form-control-line" path="newPassWord"/> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Nhập lại mật khẩu</label>
                                    <div class="col-md-12">
                                        <form:input type="password" id="NewPassWord2"  class="form-control form-control-line" path="confirmPassWord"/></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button class="btn btn-success" type="button" onclick="Update.MatKhau();">Cập nhật</button>
                                    </div>
                                </div>
                                 </form:form>
                                <script type="text/javascript">
		
		var Update = {
				MatKhau : function() {	
				var UserName = $('#UserName').val();
				var OldPassWord = $('#OldPassWord').val();
				var NewPassWord1 = $('#NewPassWord1').val();
				var NewPassWord2 = $('#NewPassWord2').val();
				
			 	var dataSendToBackEnd = {};
				dataSendToBackEnd["userName"] = UserName;
				dataSendToBackEnd["passWord"] = OldPassWord;
				dataSendToBackEnd["newPassWord"] = NewPassWord1;
				dataSendToBackEnd["confirmPassWord"] = NewPassWord2;
				
				 var jsonString = JSON.stringify(dataSendToBackEnd); 
				
				// call ajax
				$.ajax({
					url: "/api/DoiMK",
					type: "post",
					contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
					data: JSON.stringify(dataSendToBackEnd), // object json -> string json
					
					dataType: "json", // dữ liệu từ web-service trả về là json.
					success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
	
						if(jsonResult.statusCode == 200) {
							alert(jsonResult.data);
							
							
						} else {
							alert("Thất bại");
						}
					}
				});
								
			}				
		}
	
	</script>
                           
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
           
        </div>
       
    </div>
    <!-- /#wrapper -->
        <%@ include file="/WEB-INF/views/Admin/layout-ad/include-js.jsp"%>
</body>

</html>
