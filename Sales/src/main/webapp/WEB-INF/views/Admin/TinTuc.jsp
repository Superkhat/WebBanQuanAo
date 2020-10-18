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
                        <h4 class="page-title">Danh sách tin tức</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="#">Trang chủ</a></li>
                            <li class="active">Tin Tức</li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title">Danh sách tin tức</h3>


                        <button class="add">
                                          <i class="fa fa-plus-square"></i>  <a href="/Admin/addTinTuc" > Thêm bài viết </a></button>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Mã bài viết</th>
                                            <th>Tên bài viết</th>
                                            <th>Mô tả</th>
                                            <th>ảnh</th>
                                             <th>Nội dung</th>
                                            <th>Lượt xem</th>
                                            <th>Lượt Like</th>
                                            <th>Người tạo </th>
                                            <th>Ngày tạo</th>
                                            <th>Người sửa</th>
                                            <th>Ngày sửa</th>
                                            <th>Status</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${ListTinTuc}" var="tintuc">
                                        <tr>
                                            <td>${tintuc.id}</td>
                                            <td>${tintuc.tenTT}</td>
                                            <td>${tintuc.moTa}</td>
                                            <td>${tintuc.anh}</td>
                                            <td>${tintuc.noiDung}</td>
                                            <td>${tintuc.luotXem}</td>
                                            <td>${tintuc.luotLike}</td>
                                        <td>${tintuc.createdby}</td>
                                        <td>${tintuc.createdDate}</td>
                                        <td>${tintuc.modifiedBy}</td>
                                         <td>${tintuc.modifiedDate}</td>
                                              <td>${tintuc.status}</td>
                                            <td>
                                            <div class="table-data-feature">
                                                
                                                     <button class="item" data-toggle="tooltip" data-placement="top" title="Edit">
                                                            <i class="fa fa-edit"></i></i>
                                                        </button>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Delete">
                                                             <a href="/Admin/XoaTinTuc${tintuc.id}" ><i class="fa fa-trash"></i></a>
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
