<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Blog</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.png"/>
	
	<script type="text/javascript" src="vendor/slick/slick.min.js"></script>
<script type="text/javascript" src="vendor/jquery/jquery-3.4.1.min.js"></script>
	
  <%@ include file="/WEB-INF/views/layout/include-css.jsp"%>
</head>
<body class="animsition">
	 <%@ include file="/WEB-INF/views/layout/header.jsp"%>
	

	<!-- Title page -->
	<section class="bg-img1 txt-center p-lr-15 p-tb-92" style="background-image: url('images/bg-01.jpg');">
		<h2 class="ltext-105 cl0 txt-center">
			Blog
		</h2>
	</section>	


	<!-- Content page -->
	<section class="bg0 p-t-62 p-b-60">
		<div class="container">
			<div class="row">
				<div class="col-md-12 p-b-20">
					<div class="p-r-45 p-r-0-lg">
					<c:forEach items="${ListTinTuc}" var="tintuc" >
						<!-- item blog -->
						<div class="p-b-80">
							<a href="/Blog${tintuc.id}" class="hov-img0 how-pos5-parent">
								<img src="images/${tintuc.anh}" alt="IMG-BLOG" class="img_tt">

							</a>

							<div class="p-t-32">
								<h4 class="p-b-15">
									<a href="/Blog${tintuc.id}" class="ltext-108 cl2 hov-cl1 trans-04">
										${tintuc.tenTT}
									</a>
								</h4>

								<p class="stext-117 cl6">
									${tintuc.moTa}
								</p>

								<div class="flex-w flex-sb-m p-t-18">
									<span class="flex-w flex-m stext-111 cl2 p-r-30 m-tb-10">
										<span>
											<span class="cl4">By</span> ${NguoiTao}  
											<span class="cl12 m-l-4 m-r-6">|</span>
										</span>

										

										<span >
										${Lcomment}	 Comments
										</span>
									</span>

									<a href="/Blog${tintuc.id}" class="stext-101 cl2 hov-cl1 trans-04 m-tb-10">
										Continue Reading

										<i class="fa fa-long-arrow-right m-l-9"></i>
									</a>
								</div>
							</div>
						</div>

					</c:forEach>

						<!-- Pagination -->
						<div class="clearfix">
						<a class="btn btn-primary float-left" href="/TinTuc?page=${currentPage - 1 }">Quay lại</a>
						<a class="btn btn-primary float-right" href="/TinTuc?page=${currentPage + 1 }">Trang Tiếp</a>
					</div>
					</div>
				</div>

				
			</div>
		</div>
	</section>	
	
		

	
	  <%@ include file="/WEB-INF/views/layout/footer.jsp"%>


	<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>

	  <%@ include file="/WEB-INF/views/layout/include-js.jsp"%>
</body>
</html>