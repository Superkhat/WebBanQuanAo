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
	<title>Shoping Cart</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.png"/>
 <%@ include file="/WEB-INF/views/layout/include-css.jsp"%>
</head>
<body class="animsition">
	
	<!-- Header -->
	

	
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<!-- Shoping Cart -->
	<form class="bg0 p-t-75 p-b-85">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-xl-10 m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
							<table class="table-shopping-cart">
								<tr class="table_head">
									<th class="column-4">Tên sản phẩm</th>
									<th class="column-2"></th>
									<th class="column-2">Giá</th>
									<th class="column-2">Kích cỡ</th>
									<th class="column-2">Số lượng</th>
									<th class="column-2">Thành Tiền</th>
									<th class="column-2">Ngày Mua</th>
									<th class="column-2">Status</th>
									<th class="column-2"></th>
								</tr>
						<c:forEach items="${LichSuGiaoDich}" var="item">
								<tr class="table_row">
									<td class="column-1">
										<div class="how-itemcart1">
											<img src="images/${item.getMuaHang_sanpham().getAnh1()}" alt="IMG">
										</div>
									</td>
									<td class="column-2">${item.getMuaHang_sanpham().getTenSP()}</td>
									<td class="column-3" class= "gia">${item.getMuaHang_sanpham().getGia()} VNĐ</td>
									<td class="column-3">${item.size}</td>
									<td class="column-2"><span>  ${item.soLuong}</span></td>
									<td class="column-3"><span >${item.getTongTien()}</span> VNĐ </td>
									<td class="column-2">${item.createdDate}</th>
									<td class="column-2">
									 <c:set var = "status" scope = "session" value = "${item.status}" />
									<c:if test = "${status ==1 }"> Đang Xử lý</c:if> 
									<c:if test="${status ==2}"> Đã tiếp nhận</c:if> 
									<c:if test="${status ==3}"> Đang giao</c:if> 
									<c:if test="${status ==4}"> Đã giao</c:if> 
									</td>
									<td class="column-1"><button type="submit" class="btn btn-light"><a href="/XoaLichSu${item.id}" >Xóa</a> </button></td>
								</tr>
	
						</c:forEach>
							
							</table>
						</div>

					</div>
				</div>

		
			</div>
		</div>
	</form>
	

	<!-- Footer -->
	 <%@ include file="/WEB-INF/views/layout/footer.jsp"%>
	</footer>


	<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>

 <%@ include file="/WEB-INF/views/layout/include-js.jsp"%>

</body>
</html>