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
									<th class="column-1"></th>
								</tr>
						<c:forEach items="${LGioHang}" var="item">
								<tr class="table_row">
									<td class="column-1">
										<div class="how-itemcart1">
											<img src="images/${item.anh}" alt="IMG">
										</div>
									</td>
									<td class="column-2">${item.tenSP}</td>
									<td class="column-3" class= "gia">${item.gia} VNĐ</td>
									<td class="column-3">${item.size}</td>
									<td class="column-4">
										
											<input type="number"  value="1" onclick="Tinh${item.id}.Tien(${item.gia});" class="soLuong${item.id}" min="0">

										</td>
									<td class="column-3"><span class="giaSP${item.id}">${item.gia}</span> VNĐ </td>
									<td class="column-1"><button type="button" class="btn btn-light"><a href="/XoaSanPham${item.id}" >Xóa</a> </button></td>
								</tr>
	<script type="text/javascript">
		
		var Tinh${item.id} = {
				Tien : function(gia) {	
				var dongia= gia;
				var giaCu = $(".giaSP${item.id}").html();
				var soLuong =$(".soLuong${item.id}").val();
				var tongTienmoi = $("#tongTien").html();
				var tong=tongTienmoi+tongTienbandau;
				var tongTienbandau=${TongTien};
				$("#tongTien").html((tongTienmoi-giaCu)+dongia*soLuong);
				$(".giaSP${item.id}").html(dongia*soLuong);
				var dataSendToBackEnd = {};
				dataSendToBackEnd["id"] = ${item.id};
				dataSendToBackEnd["soLuong"] = soLuong;
				
				 var jsonString = JSON.stringify(dataSendToBackEnd); 
					
					// call ajax
					$.ajax({
						url: "/api/addSoluong",
						type: "post",
						contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
						data: JSON.stringify(dataSendToBackEnd), // object json -> string json
						
						dataType: "json", // dữ liệu từ web-service trả về là json.
						success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
							/* /* $("#img_anh ").attr('src',"Add.SanPham("+jsonResult.data.id+");");  */
							
						}
					});
									
			}				
		}
		
	
	
	</script>
						</c:forEach>
							
							</table>
						</div>

						<div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
							<div class="flex-w flex-m m-r-20 m-tb-5">
								<input class="stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5" type="text" name="coupon" placeholder="mã giảm giá">
									
								<div class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5">
									Mã giảm giá
								</div>
							</div>

							<!-- <div class="flex-c-m stext-101 cl2 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-10">
								Update Cart
							</div> -->
						</div>
					</div>
				</div>

				<div class="col-lg-10 col-xl-10 m-lr-auto m-b-50">
					
						<h4 class="mtext-109 cl2 p-b-30">
							Thanh Toán
						</h4>

						<div class="flex-w flex-t bor12 p-b-13">
							<div class="size-208">
								<span class="stext-110 cl2">
									Tổng tiền:
								</span>
							</div>

							<div class="size-209" >
								<span class="mtext-110 cl2" id="tongTien" value="0">${TongTien}</span>VND
							</div>
						</div>
						<div class="flex-w flex-t bor12 p-b-13">
						<div class="size-208">
							<span class="stext-110 cl2">
									Phương thức thanh toán:
								</span>
								</div>
								<div class="size-209">
								<select id="thanhToan">
								<c:forEach items="${ListThanhToan}" var="thanhtoan">
									<option value="${thanhtoan.id}">${thanhtoan.tenTT}</option>
								</c:forEach>
									
								</select>
								</div>
						</div>
						<div class="flex-w flex-t bor12 p-t-15 p-b-30">
							<div class="size-208 w-full-ssm">
								<span class="stext-110 cl2">
									NGƯỜI NHẬN:
								</span>
							</div>

							<div class="size-209 p-r-18 p-r-0-sm w-full-ssm">
								
								
								<div class="p-t-15">
									<span class="stext-112 cl8">
										Thông tin chi tiết
									</span>

									<div class="bor8 bg0 m-b-12">
										<input class="stext-111 cl8 plh3 size-111 p-lr-15" type="text"  placeholder="Địa chỉ nhận" id="diaChiNhan">
									</div>
									<div class="bor8 bg0 m-b-12">
										<input class="stext-111 cl8 plh3 size-111 p-lr-15" type="text"  placeholder="Số điệm thoại" id="sdt">
									</div>

									<div class="bor8 bg0 m-b-12">
										<input class="stext-111 cl8 plh3 size-111 p-lr-15" type="text"  placeholder="Tên người nhận" id="tenNguoiNhan">
									</div>

									
									
									
										
								</div>
							</div>
						

						
						<button type="button"  class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer" onclick="Mua.SanPham();">
							Mua Hàng
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>
		
	<script type="text/javascript">
		
		var Mua = {
				SanPham : function() {
					var thanhToan = $("#thanhToan").val();
					var diaChiNhan = $("#diaChiNhan").val();
					var sdt = $("#sdt").val();
					var tenNguoiNhan = $("#tenNguoiNhan").val();
					var tongTien = $("#tongTien").html();
					console.log("sdt "+sdt );
					console.log("thanhToan "+thanhToan );
					console.log("diaChiNhan "+diaChiNhan );
					console.log("tenNguoiNhan "+tenNguoiNhan );
					console.log("tongTien "+tongTien );
					
					var dataSendToBackEnd = {};
					dataSendToBackEnd["tongTien"] = tongTien;
					dataSendToBackEnd["thanhToan"] = thanhToan;
					dataSendToBackEnd["diaChiNhan"] = diaChiNhan;
					dataSendToBackEnd["sdtNhan"] = sdt;
					dataSendToBackEnd["tenNguoiNhan"] = tenNguoiNhan;
					 var jsonString = JSON.stringify(dataSendToBackEnd); 
					// call ajax
					$.ajax({
						url: "/api/muaSP",
						type: "post",
						contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
						 data: JSON.stringify(dataSendToBackEnd), // object json -> string json 
						
						dataType: "json", // dữ liệu từ web-service trả về là json.
						success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
							/* /* $("#img_anh ").attr('src',"Add.SanPham("+jsonResult.data.id+");");  */
							if(jsonResult.statusCode == 200) {
							alert(jsonResult.data);
							
							
						} else {
							alert("loi");
						}
						}
					});
									
			}				
		}
		
	
	
	</script>
		

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