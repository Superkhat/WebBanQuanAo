<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header -->
	<header>
		<!-- Header desktop -->
		<div class="container-menu-desktop">
			<!-- Topbar -->
			<div class="top-bar">
				<div class="content-topbar flex-sb-m h-full container">
					<div class="left-top-bar"></div>

					<div class="right-top-bar flex-w h-full">
						<a href="ThongTinCaNHan" class="flex-c-m trans-04 p-lr-25"> Thông Tin Cá
							Nhân </a> <a href="Register" class="flex-c-m trans-04 p-lr-25"> ĐăngKý </a>

						<a href="Login" class="flex-c-m trans-04 p-lr-25"> Đăng Nhập </a> <a
							href="Login" class="flex-c-m trans-04 p-lr-25"> Đăng Xuất </a>
					</div>
				</div>
			</div>
			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop container">

					<!-- Logo desktop -->
					<a href="#" class="logo"> <img src="images/icons/logo-01.png"
						alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<ul class="main-menu">
							<li ><a href="Home">Trang Chủ</a></li>

							

							<li><a href="GioHang">Giỏ Hàng</a></li>
							
							<li><a href="LichSuGiaoDich">Lịch Sử Giao Dịch</a></li>

							<li><a href="TinTuc">Tin Tức</a></li>



							<li><a href="LienHe">Liên hệ </a></li>
						</ul>
					</div>

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m">
						<div
							class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11   soLuong"
							>
							<a href="GioHang"><i class="zmdi zmdi-shopping-cart" onclick="Show.GioHang();"></i></a>
						</div>
						<c:if test="${ThongTinCaNhan == null}" >
                        <a class="profile-pic" href="Login" >  Đăng Nhập</a> /<a class="profile-pic" href="Register" >  Đăng Ký</a>
               
                        </c:if>
                        <c:if test="${ThongTinCaNhan != null}">
                     
				<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 ">
							<i class="zmdi zmdi-male"></i></i> <span class="ten">${ThongTinCaNhan.tenND}</span>
				</div> </c:if>



						<!-- <a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti" data-notify="0">
							<i class="zmdi zmdi-logout"></i>
						</a> -->
					</div>
				</nav>
			</div>
		</div>

		<!-- Header Mobile -->
		<div class="wrap-header-mobile">
			<!-- Logo moblie -->
			<div class="logo-mobile">
				<a href="index.html"><img src="images/icons/logo-01.png"
					alt="IMG-LOGO"></a>
			</div>

			<!-- Icon header -->
			<div class="wrap-icon-header flex-w flex-r-m m-r-15">


				<div
					class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti js-show-cart"
					data-notify="2">
					<i class="zmdi zmdi-shopping-cart"></i>
				</div>
					<c:if test="${ThongTinCaNhan == null}" >
                        <a class="profile-pic" href="Login">Đăng Nhập</a> 
               
                        </c:if>
                        <c:if test="${ThongTinCaNhan != null}">
                     
				<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 ">
					<i class="zmdi zmdi-male"></i> <span class="ten-mobile	">${ThongTinCaNhan.tenND}</span>
				</div> </c:if>
			</div>

			<!-- Button show menu -->
			<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
				<span class="hamburger-box"> <span class="hamburger-inner"></span>
				</span>
			</div>
		</div>


		<!-- Menu Mobile -->
		<div class="menu-mobile">
			<ul class="topbar-mobile">
				<li>
					<div class="left-top-bar"></div>
				</li>

				<li>
					<div class="right-top-bar flex-w h-full">
						<a href="#" class="flex-c-m p-lr-10 trans-04"> Thông tin cá
							nhân </a> <a href="#" class="flex-c-m p-lr-10 trans-04"> Đăng ký
						</a> <a href="#" class="flex-c-m p-lr-10 trans-04"> Đăng nhập </a> <a
							href="#" class="flex-c-m p-lr-10 trans-04"> Đăng Xuất </a>
					</div>
				</li>
			</ul>

			<ul class="main-menu-m">
				<li><a href="index">Trang Chủ</a> <span
					class="arrow-main-menu-m"> <i class="fa fa-angle-right"
						aria-hidden="true"></i>
				</span></li>

				<li><a href="shoping-cart">Giỏ Hàng</a></li>
				<li><a href="LichSuGiaoDich">Lịch Sử Giao Dịch</a></li>

				<li><a href="blog">Tin Tức</a></li>

			
				<li><a href="contact">Liên Hệ</a></li>
			</ul>
		</div>

		<!-- Modal Search -->
		<div
			class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
			<div class="container-search-header">
				<button
					class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
					<img src="images/icons/icon-close2.png" alt="CLOSE">
				</button>
			</div>
		</div>
	</header>

	<!-- Cart -->
	<div class="wrap-header-cart js-panel-cart">
		<div class="s-full js-hide-cart"></div>

		<div class="header-cart flex-col-l p-l-65 p-r-25">
			<div class="header-cart-title flex-w flex-sb-m p-b-8">
				<span class="mtext-103 cl2"> Giỏ hàng </span>

				<div
					class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-cart">
					<i class="zmdi zmdi-close"></i>
				</div>
			</div>

		<%-- 	<div class="header-cart-content flex-w js-pscroll">
			
				<ul class="header-cart-wrapitem w-full" id="test">
					<c:forEach items="${LGioHang}" var="giohang">
					<li class="header-cart-item flex-w flex-t m-b-12">
						<div class="header-cart-item-img ">
							<img src="images/${giohang.anh}" alt="IMG" id="img_anh">${giohang.tenSP}
						</div>

						<div class="header-cart-item-txt p-t-8">
							<a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04" id="a_tenSP">
								</a>
								 <span class="header-cart-item-info" id="span_gia">${giohang.gia} </span>
						</div>
					</li>
				</c:forEach>
					
				</ul>	

				<div class="w-full">
					<div class="header-cart-total w-full p-tb-40">Total: ${TongTien} VND</div>

					<div class="header-cart-buttons flex-w w-full">
						<a href="shoping-cart"
							class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10">
							Xem giỏ hàng </a>


					</div>
				</div>
			</div> --%>
		</div>
		
	</div>

