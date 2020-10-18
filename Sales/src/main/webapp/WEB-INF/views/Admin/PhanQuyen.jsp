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
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
    <title>Ample Admin Template - The Ultimate Multipurpose admin template</title>

  <%@ include file="/WEB-INF/views/Admin/layout-ad/include-css.jsp"%>
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
      <%@ include file="/WEB-INF/views/Admin/layout-ad/header.jsp"%>
       <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Danh sách quyền người dùng</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="#">Trang chủ</a></li>
                            <li class="active">Quyền Người Dùng</li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title">Danh sách quyền người dùng</h3>


                        <button class="add">
                                           <i class="fa fa-plus-square"></i>  <a href="/Admin/addPhanQuyen" >  Thêm quền người dùng</a></button> 


                            <!-- <p class="text-muted">Add class <code>.table</code></p> -->
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Mã Quyền</th>
                                            <th>Tên Quyền</th>
                                            <th>Mã Người Dùng </th>
                                            <th>Tên người dùng</th>
                                           
                                            <th>Người tạo </th>
                                            <th>Ngày tạo</th>
                                            <th>Người sửa</th>
                                            <th>Ngày sửa</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${ListPhanQuyen}" var="phanquyen">
                                        <tr>
                                            <td>${phanquyen.getQuyen_phanQuyen().getId()}</td>
                                            <td>${phanquyen.getQuyen_phanQuyen().getTenQuyen()}</td>
                                            <td>${phanquyen.getNguoidung_phanQuyen().getId()}</td>
                                            <td>${phanquyen.getNguoidung_phanQuyen().getTenND()}</td>
                                            <td>${phanquyen.createdby}</td>
                                            <td>${phanquyen.createdDate}</td>
                                            <td>${phanquyen.modifiedBy}</td>
                                            <td>${phanquyen.modifiedDate}</td>
                                            <td>${phanquyen.status} </td>
                                            
                                            <td>
                                            <div class="table-data-feature">
                                                
                                                     <button class="item" data-toggle="tooltip" data-placement="top" title="Edit">
                                                            <i class="fa fa-edit"></i></i>
                                                        </button>
                                                        
                                                       
                                                    </div>
                                             </td>
                                        </tr>
                                        </c:forEach>
                                       
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
           
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
       <%@ include file="/WEB-INF/views/Admin/layout-ad/include-js.jsp"%>
</body>

</html>
