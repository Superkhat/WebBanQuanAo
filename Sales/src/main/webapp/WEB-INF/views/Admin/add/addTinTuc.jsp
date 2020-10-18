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
     <%@ include file="/WEB-INF/views/Admin/layout-ad/header.jsp"%>
     <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Thêm Bài Viết</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="#">Trang Chủ</a></li>
                            <li class="active">Thêm Bài Viết</li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row row-main">
                   
                    <div class="col-md-12 col-xs-12">
                        <div class="white-box">
                            <form:form method="post" action="/Admin/addTinTuc" modelAttribute="addTT" class="form-horizontal form-material" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="col-md-12">Tên bài viết</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="Johnathan Doe" class="form-control form-control-line" path="tenTT"  /> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">ảnh</label>
                                    <div class="col-md-12">
                                        <input type="file" name="imageTT"> </div>
                                </div>
                                  <div class="form-group">
                                    <label class="col-md-12">Mô tả</label>   
                                <div class="col-md-12">
                                        <form:input type="text" class="form-control form-control-line" path="moTa"/> </div>
                                </div>
    
                                 <div class="form-group">
                                    <label class="col-md-12">Nội dung</label>
                                    <div class="col-md-12">
                                        <form:textarea id="noidung"  class="form-control form-control-line" path="noiDung"/> </div>                               
                                         </div>
                                
                                 <div class="form-group">
                                    <label class="col-md-12">Status</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="Johnathan Doe" class="form-control form-control-line" path="status" /> </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Thêm</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
           
        </div>
       
    </div>
    <!-- /#wrapper -->
    <%@ include file="/WEB-INF/views/Admin/add/layout-add/include-js.jsp"%>
    <script type="text/javascript">
    
	 	// ::: for richtext editor
		$(document).ready(function() {
		  $('#noidung').summernote();
		});
    
    </script>
</body>

</html>
