<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header">
                <div class="top-left-part">
                    <!-- Logo -->
                    <a class="logo" href="index">
                        <!-- Logo icon image, you can use font-icon also --><b>
                        <!--This is dark logo icon--><img src="/plugins/images/admin-logo.png" alt="home" class="dark-logo" /><!--This is light logo icon--><img src="plugins/images/admin-logo-dark.png" alt="home" class="light-logo" />
                     </b>
                        <!-- Logo text image you can use text also --><span class="hidden-xs">
                        <!--This is dark logo text--><img src="/plugins/images/admin-text.png" alt="home" class="dark-logo" /><!--This is light logo text--><img src="plugins/images/admin-text-dark.png" alt="home" class="light-logo" />
                     </span> </a>
                </div>
                <!-- /Logo -->
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li>
                        <form role="search" class="app-search hidden-sm hidden-xs m-r-10">
                            <input type="text" placeholder="Search..." class="form-control"> <a href=""><i class="fa fa-search"></i></a> </form>
                    </li>
                    <li>
                        <a class="profile-pic" href="#"> <img src="/plugins/images/users/varun.jpg" alt="user-img" width="36" class="img-circle"><b class="hidden-xs">Steave</b></a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
        <!-- End Top Navigation -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav slimscrollsidebar">
                <div class="sidebar-head">
                    <h3><span class="fa-fw open-close"><i class="ti-close ti-menu"></i></span> <span class="hide-menu">Navigation</span></h3>
                </div>
                <ul class="nav" id="side-menu">
                    <li style="padding: 70px 0 0;" class="active">
                        <a href="index" class="waves-effect"><i class="fa fa-clock-o fa-fw" aria-hidden="true"></i>Trang Chủ</a>
                    </li>
                    <li>
                        <a href="profile" class="waves-effect"><i class="fa fa-user fa-fw" aria-hidden="true"></i>Thông tin cá nhân</a>

                    </li>
                    <li>
                        <a href="basic-table.html" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>Basic Table</a>
                        <ul class="nav" id="side-menu-child">
                            <li><a href="BinhLuan" >Bình Luận</a></li>
                      <!--     <li><a href="" >Giỏ Hàng</a></li> -->
                              <li><a href="HangSX">Hãng Sản Xuất</a></li>
                               <li><a href="LienHe">Liên Hệ</a></li>
                               <li><a href="MuaHang">Mua Hàng</a></li>
                               <li><a href="NguoiDung">Người Dùng</a></li>
                               <li><a href="PhanQuyen">Phân Quyền</a></li>
                               <li><a href="Quyen">Quyền</a></li>
                               <li><a href="SanPham">Sản Phẩm</a></li>
                               <li><a href="Slide">Slide</a></li>
                               <li><a href="ThanhToan">Phương thức thanh toán </a></li>
                               <li><a href="TheLoai">Thể Loại</a></li>
                               <li><a href="TinTuc">Tin Tức</a></li>
                               <li><a href="TraLoi">Trả lời</a></li>

                        </ul>
                    </li>
                     <li>
                        <a href="doiMK" class="waves-effect"><i class="fa fa-unlock fa-fw"aria-hidden="true"></i>  Đổi mật khẩu</a>
                    </li>
                    <li>
                        <a href="DangNhap" class="waves-effect"><i class="fa fa-sign-out fa-fw" aria-hidden="true"></i> Đăng Xuất</a>
                    </li>
              
                </ul>
                
            </div>
        </div>