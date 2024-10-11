<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%-- <html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/
bootstrap.min.css"
	rel="stylesheet">
<title>Đăng nhập tài khoản</title>
</head>
<body>
	<header class="row">
		<div class="col">
			<div class="alert alert-primary col" align="center">
				<h1>Tạo lại mật khẩu </h1>
			</div>
		</div>
	</header>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-12 col-md-5">
				<form action="/Login_Register/forgot-password" method="post">
					<c:if test="${alert != null}">
						<label class="alert alert-danger">${alert}</label>
					</c:if>
					<div class="form-group">
						<label for="username">Username:</label> <input type="text"
							id="username" name="username" class="form-control" />
					</div>
					<div class="form-group">
						<label for="password">Mật khẩu mới: </label> <input type="password"
							id="password" name="password" class="form-control" />
					</div>
					<div class="form-group mt-3" align="center">
						<button type="submit" class="btn btn-primary">Xác nhận</button>
					</div>
					<div class="form-group mt-3" align="center">
						<!-- Link quên mật khẩu -->
						<a href="/Login_Register/login" class="btn btn-link">Đăng nhập?</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html> --%>





<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<!-- Bootstrap container to center the content -->
	<div
		class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card text-center" style="width: 300px;">
			<div class="card-header h5 text-white bg-primary">Password
				Reset</div>
			<div class="card-body px-5">
				<p class="card-text py-2">Enter your username and new password,
					and we’ll update it for you!</p>
				<form action="forgotPassword" method="POST">
					<c:if test="${alert != null}">
						<h6 class="alert alert-danger">${alert}</h6>
					</c:if>
					<div class="form-outline mb-4">
						<input type="text" id="username" name="username"
							class="form-control" required /> <label class="form-label"
							for="username">Username</label>
					</div>
					<div class="form-outline mb-4">
						<input type="password" id="newPassword" name="newPassword"
							class="form-control" required /> <label class="form-label"
							for="newPassword">New Password</label>
					</div>
					<div class="form-outline mb-4">
						<input type="password" id="confirmnewPassword"
							name="confirmnewPassword" class="form-control" required /> <label
							class="form-label" for="newPassword">Confirm New Password</label>
					</div>
					<button type="submit" class="btn btn-primary w-100">Reset
						Password</button>
						<a href="/Login_Register/login" class="btn btn-link">Đăng nhập?</a>
				</form>
			</div>

		</div>
	</div>

	<!-- Bootstrap JS and dependencies (optional) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
