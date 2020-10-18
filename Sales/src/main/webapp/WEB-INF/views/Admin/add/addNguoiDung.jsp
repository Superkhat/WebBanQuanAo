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
                        <h4 class="page-title">Thêm người dùng</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="#">Trang Chủ</a></li>
                            <li class="active">Thêm người dùng</li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row row-main">
                   
                    <div class="col-md-12 col-xs-12">
                        <div class="white-box">
                            <form:form class="form-horizontal form-material" method="post" modelAttribute="addND" action="/Admin/addNguoiDung" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="col-md-12">Tên Người dùng</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="Tên người dùng" class="form-control form-control-line" path="tenND"></form:input> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Địa Chỉ</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="Địa chi" class="form-control form-control-line" path="diaChi"></form:input> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Số điện thoại</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="sdt" class="form-control form-control-line" path="sdt"></form:input> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Email</label>
                                    <div class="col-md-12">
                                        <form:input type="email" placeholder="email" class="form-control form-control-line" path="email"></form:input> </div>
                                </div>
                              <div class="form-group">
                                    <label class="col-md-12">ảnh</label>
                                    <div class="col-md-12">
                                   <input type="file" name="anhND">
                                        </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">userName</label>
                                    <div class="col-md-12">
                                        <form:input type="text" id="userName" placeholder="userName" class="form-control form-control-line" path="userName"></form:input> </div>
                                </div><div class="form-group">
                                    <label class="col-md-12">Password</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="Password" class="form-control form-control-line" path="passWord"></form:input> </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Status</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="status" class="form-control form-control-line" path="status"></form:input> </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success" >Thêm</button>
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
   
</body>

</html>
