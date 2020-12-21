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
    <%@ include file="/WEB-INF/views/Admin/layout-ad/include-css.jsp"%>
  
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
                        <h4 class="page-title">Cập nhật Hãng Sản Xuất</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="#">Trang Chủ</a></li>
                            <li class="active">Cập nhật Hãng Sản Xuất</li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row row-main">
                   
                    <div class="col-md-12 col-xs-12">
                        <div class="white-box">
                            <form:form class="form-horizontal form-material" action="/Admin/UpdateHang${HangSX.id}" method="post" modelAttribute="updateHang" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="col-md-12">Tên hãng</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="${HangSX.tenHang}" class="form-control form-control-line" path="tenHang" /> </div>
                                </div>
                               <div class="form-group">
                                    <label class="col-md-12">SĐT</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="${HangSX.sdt}" class="form-control form-control-line" path="sdt"  /></div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Email</label>
                                    <div class="col-md-12">
                                        <form:input type="email" placeholder="${HangSX.email}" class="form-control form-control-line" path="email"/> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Địa Chỉ</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="${HangSX.diaChi}" class="form-control form-control-line" path="diaChi"/> </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">ảnh hãng sản xuất</label>
                                    <div class="col-md-12">
                                        <input type="file" name="anhHangSX">
                                      </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Mô tả</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="${HangSX.moTa}" class="form-control form-control-line" path="moTa"/> </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Status</label>
                                    <div class="col-md-12">
                                        <form:input type="text" placeholder="${HangSX.status}" class="form-control form-control-line" path="status"/> </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Update</button>
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
     <%@ include file="/WEB-INF/views/Admin/update/layout-update/include-js.jsp"%>
</body>

</html>
