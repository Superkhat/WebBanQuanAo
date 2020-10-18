<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="/images/icons/favicon.png" />
<!--===============================================================================================-->

<script type="text/javascript" src="/vendor/jquery/jquery-3.4.1.min.js"></script>



<link href="/bootstrap-rating-master/bootstrap-rating.css" rel="stylesheet">
<script type="text/javascript" src="/bootstrap-rating-master/	bootstrap-rating.js"></script>

	  <%@ include file="/WEB-INF/views/layout/include-css.jsp"%>

<!--===============================================================================================-->
</head>
<body class="animsition">

	  <%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<!-- Slider -->
	<section class="section-slide">
		<div class="wrap-slick1">
		
			<div class="slick1"><c:forEach items="${ListSlide}" var="slide">
				<div class="item-slick1"
					style="background-image: url(images/${slide.anh});">
					<div class="container h-full">
						<div class="flex-col-l-m h-full p-t-100 p-b-30 respon5">
							<div class="layer-slick1 animated visible-false"
								data-appear="fadeInDown" data-delay="0">
								<span class="ltext-101 cl2 respon2"> ${slide.moTa}</span>
							</div>

							<div class="layer-slick1 animated visible-false"
								data-appear="fadeInUp" data-delay="800">
								<h2 class="ltext-201 cl2 p-t-19 p-b-43 respon1">${slide.tenSlide}
								</h2>
							</div>

							<div class="layer-slick1 animated visible-false"
								data-appear="zoomIn" data-delay="1600">
								<a href="Home"
									class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04">
									Mua ngay </a>
							</div>
						</div>
					</div>
				</div>
</c:forEach>
				
			</div>
		</div>
	</section>
	<!-- ------------------------------------------------ -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('.a').slick({
				slidesToShow : 3,
				slidesToScroll : 1,
				autoplay : true,
				autoplaySpeed : 1000,
				dots : true,
				arrows : true,
			});
		});
	</script>
	<!-- Banner -->
	<div class="  sec-banner bg0 p-t-80 p-b-50">
		<div class="container">
			<div class="row a">
			<c:forEach items="${HangSX}" var="HangSX">
				<div class="col-md-6 col-xl-4 p-b-30 m-lr-auto">
					<!-- Block1 -->
					<div class="  block1 wrap-pic-w">
						<img src="images/${HangSX.getAnh()}" alt="IMG-BANNER">

						<a href="product.html" class="block1-txt ab-t-l s-full flex-col-l-sb p-lr-38 p-tb-34 trans-03 respon3">
							<div class="block1-txt-child1 flex-col-l">
								<span class="block1-name ltext-102 trans-04 p-b-8">
									${HangSX.getTenHang()}
								</span>

							</div>

							<div class="block1-txt-child2 p-b-4 trans-05">
								<div class="block1-link stext-101 cl0 trans-09">
									XEM NGAY
								</div>
							</div>
						</a>
					</div>
				</div>

				</c:forEach>
			</div>
		</div>
	</div>

	
	


	<!-- Product -->
	<section class="bg0 p-t-23 p-b-140">
		<div class="container">
			<div class="p-b-10">
				<h3 class="title"> SẢN PHẨM MỚI</h3>
			</div>
		

			<div class="row isotope-grid">
				<c:forEach items="${LSanPhamMoi}" var="sanpham">
					<div class="col-sm-6 col-md-3 col-lg-3 p-b-35 isotope-item  ${sanpham.getTheloai().getId()} ">
						<!-- Block2 -->
						<div class="block2">
							<div class="block2-pic hov-img0">
								<img src="images/${sanpham.getAnh1()}" alt="IMG-PRODUCT">
								<a href="#" onclick="SanPham.xemSP(${sanpham.getId()});" 
									class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1 }">
									Xem  </a>
							</div>
							<div class="block2-txt flex-w flex-t p-t-14">
								<div class="block2-txt-child1 flex-col-l ">
									<a href="product-detail.html"
										class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
										${sanpham.getTenSP()} </a> <span class="stext-105 cl3">
										${sanpham.getGia()} </span>
										${sanpham.getHangsx().getTenHang()}
									
										</script>
								</div>
								<div class="block2-txt-child2 flex-r p-t-3">
									<a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
										<img class="icon-heart1 dis-block trans-04"
										src="images/icons/icon-heart-01.png" alt="ICON"> <img
										class="icon-heart2 dis-block trans-04 ab-t-l"
										src="images/icons/icon-heart-02.png" alt="ICON">
									</a>
								</div>
							</div>
						</div>
					</div>
		<script type="text/javascript">
		
		var SanPham = {
				xemSP : function(idSP) {	
			 	var dataSendToBackEnd = {};
				dataSendToBackEnd["id"] = idSP;
				
				 var jsonString = JSON.stringify(dataSendToBackEnd); 
				
				// call ajax
				$.ajax({
					url: "/api/XemSP",
					type: "post",
					contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
					data: JSON.stringify(dataSendToBackEnd), // object json -> string json
					
					dataType: "json", // dữ liệu từ web-service trả về là json.
					success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
						
						$("#add ").attr('onclick',"Add.SanPham("+jsonResult.data.id+");"); 
					
					 	 $(".anh1 ").attr('src',"images/"+jsonResult.data.anh1); 
					 	 $(".anh1 ").attr('href',"images/"+jsonResult.data.anh1); 
					 	 
					 	 $(".anh2 ").attr('src',"images/"+jsonResult.data.anh2); 
					 	 $(".anh2 ").attr('href',"images/"+jsonResult.data.anh2); 
					 	 
					 	 $(".anh3 ").attr('src',"images/"+jsonResult.data.anh3); 
					 	 $(".anh3 ").attr('href',"images/"+jsonResult.data.anh3); 
					 	 
					 	 $(".tenSP").html(jsonResult.data.tenSP);
					 	 $(".gia").html(jsonResult.data.gia +"  VND");
					 	 $(".chatlieu").html(jsonResult.data.chatLieu);
					 	 $(".mota").html(jsonResult.data.moTa);
					 	 
					 	
						
					}
				});
								
			}				
		}
	
	</script>
				
				</c:forEach>
				</div>
			<div class="p-b-10">
				<h3 class="title"> SẢN PHẨM NỔI BẬT</h3>
			</div>
		
			<div class="row isotope-grid">
				<c:forEach items="${LSanPhamHot}" var="sanpham">
					<div class="col-sm-6 col-md-3 col-lg-3 p-b-35 isotope-item  ${sanpham.getTheloai().getId()} ">
						<!-- Block2 -->
						<div class="block2">
							<div class="block2-pic hov-img0">
								<img src="images/${sanpham.getAnh1()}" alt="IMG-PRODUCT">
								<a href="#" onclick="SanPham.xemSP(${sanpham.getId()});" 
									class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1 }">
									Xem  </a>
							</div>
							<div class="block2-txt flex-w flex-t p-t-14">
								<div class="block2-txt-child1 flex-col-l ">
									<a href="product-detail.html"
										class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
										${sanpham.getTenSP()} </a> <span class="stext-105 cl3">
										${sanpham.getGia()} </span>
										${sanpham.getHangsx().getTenHang()}
									
										</script>
								</div>
								<div class="block2-txt-child2 flex-r p-t-3">
									<a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
										<img class="icon-heart1 dis-block trans-04"
										src="images/icons/icon-heart-01.png" alt="ICON"> <img
										class="icon-heart2 dis-block trans-04 ab-t-l"
										src="images/icons/icon-heart-02.png" alt="ICON">
									</a>
								</div>
							</div>
						</div>
					</div>
		<script type="text/javascript">
		
		var SanPham = {
				xemSP : function(idSP) {	
			 	var dataSendToBackEnd = {};
				dataSendToBackEnd["id"] = idSP;
				
				 var jsonString = JSON.stringify(dataSendToBackEnd); 
				
				// call ajax
				$.ajax({
					url: "/api/XemSP",
					type: "post",
					contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
					data: JSON.stringify(dataSendToBackEnd), // object json -> string json
					
					dataType: "json", // dữ liệu từ web-service trả về là json.
					success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
						
						$("#add ").attr('onclick',"Add.SanPham("+jsonResult.data.id+");"); 
					
					 	 $(".anh1 ").attr('src',"images/"+jsonResult.data.anh1); 
					 	 $(".anh1 ").attr('href',"images/"+jsonResult.data.anh1); 
					 	 
					 	 $(".anh2 ").attr('src',"images/"+jsonResult.data.anh2); 
					 	 $(".anh2 ").attr('href',"images/"+jsonResult.data.anh2); 
					 	 
					 	 $(".anh3 ").attr('src',"images/"+jsonResult.data.anh3); 
					 	 $(".anh3 ").attr('href',"images/"+jsonResult.data.anh3); 
					 	 
					 	 $(".tenSP").html(jsonResult.data.tenSP);
					 	 $(".gia").html(jsonResult.data.gia +"  VND");
					 	 $(".chatlieu").html(jsonResult.data.chatLieu);
					 	 $(".mota").html(jsonResult.data.moTa);
					 	 
					 	
						
					}
				});
								
			}				
		}
	
	</script>
				
				</c:forEach>
				</div>
			
			<div class="p-b-10">
				<h3 class="title">DANH SÁCH SẢN PHẨM</h3>
			</div>

			<div class="flex-w flex-sb-m p-b-52">
				<div class="flex-w flex-l-m filter-tope-group m-tb-10">
					<button
						class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5 how-active1"
						data-filter="*">Tất cả</button>
					<c:forEach items="${TheLoai}" var="theloai">
						<button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"
							data-filter=".${theloai.getId()}">
							${theloai.getTenTheLoai() }</button>
							
					</c:forEach>

				</div>

				
	<div class="flex-w flex-sb-m p-b-52">
				

				<div class="flex-w flex-c-m m-tb-10">


					<div
						class="flex-c-m stext-106 cl6 size-105 bor4 pointer hov-btn3 trans-04 m-tb-4 js-show-search">
						<i class="icon-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-search"></i>
						<i
							class="icon-close-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
						Search
					</div>
				</div>

				<!-- Search product -->
				<div class="dis-none panel-search w-full p-t-10 p-b-15">
					<div class="bor8 dis-flex p-l-15">
						<button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04">
							<i class="zmdi zmdi-search"></i>
						</button>

						<input class="mtext-107 cl2 size-114 plh2 p-r-15" type="text"
							name="search-product" placeholder="Search">
					</div>
				</div>


			</div>
				


			</div>

			<div class="row isotope-grid">
				<c:forEach items="${LSanPham}" var="sanpham">
					<div class="col-sm-6 col-md-3 col-lg-3 p-b-35 isotope-item  ${sanpham.getTheloai().getId()} ">
						<!-- Block2 -->
						<div class="block2">
							<div class="block2-pic hov-img0">
								<img src="images/${sanpham.getAnh1()}" alt="IMG-PRODUCT">
								<a href="#" onclick="SanPham.xemSP(${sanpham.getId()});" 
									class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1 }">
									Xem  </a>
							</div>
							<div class="block2-txt flex-w flex-t p-t-14">
								<div class="block2-txt-child1 flex-col-l ">
									<a href="product-detail.html"
										class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
										${sanpham.getTenSP()} </a> <span class="stext-105 cl3">
										${sanpham.getGia()} </span>
										${sanpham.getHangsx().getTenHang()}
									
										</script>
								</div>
								<div class="block2-txt-child2 flex-r p-t-3">
									<a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
										<img class="icon-heart1 dis-block trans-04"
										src="images/icons/icon-heart-01.png" alt="ICON"> <img
										class="icon-heart2 dis-block trans-04 ab-t-l"
										src="images/icons/icon-heart-02.png" alt="ICON">
									</a>
								</div>
							</div>
						</div>
					</div>
		<script type="text/javascript">
		
		var SanPham = {
				xemSP : function(idSP) {	
			 	var dataSendToBackEnd = {};
				dataSendToBackEnd["id"] = idSP;
				
				 var jsonString = JSON.stringify(dataSendToBackEnd); 
				
				// call ajax
				$.ajax({
					url: "/api/XemSP",
					type: "post",
					contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
					data: JSON.stringify(dataSendToBackEnd), // object json -> string json
					
					dataType: "json", // dữ liệu từ web-service trả về là json.
					success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
						
						$("#add ").attr('onclick',"Add.SanPham("+jsonResult.data.id+");"); 
					
					 	 $(".anh1 ").attr('src',"images/"+jsonResult.data.anh1); 
					 	 $(".anh1 ").attr('href',"images/"+jsonResult.data.anh1); 
					 	 
					 	 $(".anh2 ").attr('src',"images/"+jsonResult.data.anh2); 
					 	 $(".anh2 ").attr('href',"images/"+jsonResult.data.anh2); 
					 	 
					 	 $(".anh3 ").attr('src',"images/"+jsonResult.data.anh3); 
					 	 $(".anh3 ").attr('href',"images/"+jsonResult.data.anh3); 
					 	 
					 	 $(".tenSP").html(jsonResult.data.tenSP);
					 	 $(".gia").html(jsonResult.data.gia +"  VND");
					 	 $(".chatlieu").html(jsonResult.data.chatLieu);
					 	 $(".mota").html(jsonResult.data.moTa);
					 	 
					 	
						
					}
				});
								
			}				
		}
	
	</script>
				
				</c:forEach>
			</div>

			<div class="flex-c-m flex-w w-full p-t-45">
				<a href="#"
					class="flex-c-m stext-101 cl5 size-103 bg2 bor1 hov-btn1 p-lr-15 trans-04">
					Xem thêm </a>
			</div>
		</div>
	</section>

 
<!--	footer   -->

	  <%@ include file="/WEB-INF/views/layout/footer.jsp"%>

	<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top"> <i
			class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>

	<!-- Modal1 -->
	<div class="wrap-modal1 js-modal1 p-t-60 p-b-20">
		<div class="overlay-modal1 js-hide-modal1"></div>

		<div class="container">
			<div class="bg0 p-t-60 p-b-30 p-lr-15-lg how-pos3-parent">
				<button class="how-pos3 hov3 trans-04  js-hide-modal1">
					<img src="images/icons/icon-close.png" alt="CLOSE">
				</button>

				<div class="row">
					<div class="col-md-6 col-lg-7 p-b-30">
						<div class="p-l-25 p-r-30 p-lr-0-lg">
							<div class="wrap-slick3 flex-sb flex-w">
								<div class="wrap-slick3-dots"></div>
								<div class="wrap-slick3-arrows flex-sb-m flex-w"></div>

								<div class="slick3 gallery-lb">
									<div class="item-slick3" >
										<div class="wrap-pic-w pos-relative">
											<img src=""  class="anh1" alt="IMG-PRODUCT">

											<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04 anh1" href="">
												<i class="fa fa-expand"></i>
											</a>
										</div>
									</div>

									<div class="item-slick3" >
										<div class="wrap-pic-w pos-relative">
											<img src="" alt="IMG-PRODUCT" class="anh2">

											<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04 anh2" href="">
												<i class="fa fa-expand"></i>
											</a>
										</div>
									</div>

									<div class="item-slick3" >
										<div class="wrap-pic-w pos-relative">
											<img src="" alt="IMG-PRODUCT" class="anh3">

											<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04 anh3" href="">
												<i class="fa fa-expand"></i>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-6 col-lg-5 p-b-30">
						<div class="p-r-50 p-t-5 p-lr-0-lg">
							<h4 class="mtext-105 cl2 js-name-detail p-b-14 tenSP">
								
							</h4>

							<span class="mtext-106 cl2 gia" >
								
							</span>

							<p class="stext-102 cl3 p-t-23 chatlieu">
								
							</p>
							
							<p class="stext-102 cl3 p-t-23 mota">
								
							</p>
							<!--  -->
							<div class="p-t-33">
								<div class="flex-w flex-r-m p-b-10">
									<div class="size-203 flex-c-m respon6">
										Size
									</div>

									<div class="size-204 respon6-next">
										<div class="rs1-select2 bor8 bg0">
											<select class="js-select2" name="time" id="size">
												<option>Size S</option>
												<option>Size M</option>
												<option>Size L</option>
												<option>Size XL</option>
											</select>
											<div class="dropDownSelect2"></div>
										</div>
									</div>
								</div>

						

								<div class="flex-w flex-r-m p-b-10">
									<div class="size-204 flex-w flex-m respon6-next">
									

										<button type="submit"  id="add" onclick="" class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail">
											Thêm vào giỏ hàng
										</button>
									</div>
								</div>	
							</div>

							<!--  -->
							<div class="flex-w flex-m p-l-100 p-t-40 respon7">
								<div class="flex-m bor9 p-r-10 m-r-11">
									<a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 js-addwish-detail tooltip100" data-tooltip="Add to Wishlist">
										<i class="zmdi zmdi-favorite"></i>
									</a>
								</div>

								<a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100" data-tooltip="Facebook">
									<i class="fa fa-facebook"></i>
								</a>

								<a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100" data-tooltip="Twitter">
									<i class="fa fa-twitter"></i>
								</a>

								<a href="#" class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100" data-tooltip="Google Plus">
									<i class="fa fa-google-plus"></i>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript">
		
		var Add = {
				SanPham : function(idSP) {	
				var size= $("#size").val();
			 	var dataSendToBackEnd = {};
				dataSendToBackEnd["id"] = idSP;
				dataSendToBackEnd["size"] = size;
				 var jsonString = JSON.stringify(dataSendToBackEnd); 
				
				// call ajax
				$.ajax({
					url: "/api/AddSanPham",
					type: "post",
					contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
					data: JSON.stringify(dataSendToBackEnd), // object json -> string json
					
					dataType: "json", // dữ liệu từ web-service trả về là json.
					success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
						/* /* $("#img_anh ").attr('src',"Add.SanPham("+jsonResult.data.id+");");  */
						$(".soLuong ").attr('data-notify',jsonResult.data); 
						
					}
				});
								
			}				
		}
	
	</script>
				
 
	
	  <%@ include file="/WEB-INF/views/layout/include-js.jsp"%>




</body>
</html>