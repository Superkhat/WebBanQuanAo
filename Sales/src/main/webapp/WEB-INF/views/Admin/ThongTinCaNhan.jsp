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
                        <h4 class="page-title">Thông tin cá nhân</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="#">Trang Chủ</a></li>
                            <li class="active">Thông tin cá nhân</li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row row-main">
                   
                    <div class="col-md-12 col-xs-12">
                        <div class="white-box">
                            <form:form class="form-horizontal form-material" modelAttribute="thongtin" action="/Admin/ThongTinCaNhan" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="col-md-12">Tên Người Dùng</label>
                                    <div class="col-md-12">
                                        <input type="text"	value="${ThongTinCaNhan.tenND}"  class="form-control form-control-line"  name="tenND"> </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Địa CHỉ</label>
                                    <div class="col-md-12">
                                        <input type="text"	value="${ThongTinCaNhan.diaChi}"  class="form-control form-control-line"  name="diaChi"> </div>
                                </div>
                                  <div class="form-group">
                                    <label class="col-md-12">SỐ điện thoại</label>
                                    <div class="col-md-12">
                                        <input type="text"	value="${ThongTinCaNhan.sdt}"  class="form-control form-control-line"  name="sdt"> </div>
                                </div>
                                  <div class="form-group">
                                    <label class="col-md-12">email</label>
                                    <div class="col-md-12">
                                        <input type="email"	value="${ThongTinCaNhan.email}"  class="form-control form-control-line"  name="email"> </div>
                                </div>
                                  <div class="form-group">
                                    <label class="col-md-12">Ảnh Người Dùng</label>
                                    <div class="col-md-12">
                                        <input type="text"	value="${ThongTinCaNhan.anh}"  class="form-control form-control-line"  name="anh"> </div>
                                </div>
                                <div class="form-group">
                                <input type="file" name="anhND">
                                </div>
                                  <div class="form-group">
                                    <label class="col-md-12">UserNam</label>
                                    <div class="col-md-12">
                                        <input type="text"	value="${ThongTinCaNhan.userName}"  class="form-control form-control-line"  name="userName"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">PassWord</label>
                                    <div class="col-md-12">
                                        <input type="text"	value="${ThongTinCaNhan.passWord}"  class="form-control form-control-line"  name="passWord"> </div>
                                </div>
                               
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button class="btn btn-success" type="submit" >Cập nhật </button>
                                    </div>
                                </div>
                                 </form:form>
                                <script type="text/javascript">
		
		
                           
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
