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
	<title>Login V3</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="/login/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100">
				<form:form class="login100-form validate-form" action="" method="post"  modelAttribute="Login" id="form">
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>

					<span class="login100-form-title p-b-34 p-t-27">
						ĐĂNG NHẬP
					</span>
							<c:if test="${not empty param.login_error}">
							<div class="alert alert-danger" role="alert">
							  	Login attempt was not successful, try again.
							</div>
						</c:if>
					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="text" name="username" placeholder="Username" id="userName">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>

					<select id="role" onclick="Check.Role();" class="custom-select">
						<option >Chọn Role...</option>
						<option value="USER">USER</option>
						<option value="ADMIN">ADMIN</option>
						
					</select>

					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn" onclick="Login.check(username);">
							OK
						</button>
					</div>

					<div class="text-center p-t-90">
						<a class="txt1" href="#">
							Forgot Password?
						</a>
					</div>
					
					<script type="text/javascript">
		var Check = {
				Role : function () {
					var rel = null;
					var role = $("#role").val();
					console.log(role);
					if(role=="ADMIN")
						 rel = "/perform_login";
					else if(role=="USER") rel = "/Home";
					
					$("#form").attr('action',rel); 
				}
		}
					
					
					
		var Login = {
				
				check : function(username) {	
					var rel = null;
					var role = $("#role").val();
					console.log(role);
					if(role=="ADMIN")
						 rel = "/perform_login";
					else if(role=="USER") rel = "/Home";
					else alert(" Bạn cần chọn Role");
					$("#form").attr('action',rel); 
				var userName = $('#userName').val();
			 	var dataSendToBackEnd = {};
				dataSendToBackEnd["username"] = userName;
				
				 var jsonString = JSON.stringify(dataSendToBackEnd); 
				
				// call ajax
				$.ajax({
					url: "/api/Login",
					type: "post",
					contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
					data: JSON.stringify(dataSendToBackEnd), // object json -> string json
					
					dataType: "json", // dữ liệu từ web-service trả về là json.
					success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
						
					}
				});
								
			}				
		}
	
	</script>
				</form:form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="/login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="/login/vendor/bootstrap/js/popper.js"></script>
	<script src="/login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="/login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="/login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="/login/js/main.js"></script>

</body>
</html>