<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Tuan_3.controllers.LoginController"%>

<!DOCTYPE html>
<html>
<head>
<%
Integer userId = (Integer) session.getAttribute("userId");
if (userId == null) {
	response.sendRedirect("login.jsp?error=sessionExpired");
	return;
}
%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Cập nhật thông tin cá nhân</title>
</head>
<body>
	<header class="row">
		<div class="col">
			<div class="alert alert-primary col" align="center">
				<h1>Cập nhật thông tin cá nhân</h1>
			</div>
		</div>
	</header>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-12 col-md-5">
				<form method="post" enctype="multipart/form-data"
					action="${pageContext.request.contextPath}/profile">
					<c:if test="${alert != null}">
						<h6 class="alert alert-danger">${alert}</h6>
					</c:if>
					<div class="form-group mb-3">
						<label for="fullName">Fullname:</label> <input type="text"
							id="fullName" name="fullName" class="form-control"
							value="${user.fullName}" />
					</div>
					<div class="form-group mb-3">
						<label for="phone">Phone:</label> <input type="text" id="phone"
							name="phone" class="form-control" value="${user.phone}" />
					</div>
					<input type="hidden" name="id" value="${user.id}" />

					<div class="form-group mb-3">
						<label for="images">Image:</label> <input type="file" id="images"
							name="images" class="form-control" accept="image/*"
							onchange="previewImage(event)" /> <img id="imagePreview" src="#"
							alt="Image preview"
							style="display: none; margin-top: 10px; max-width: 100%;" />
					</div>
					<script>
						function previewImage(event) {
							const input = event.target;
							const file = input.files[0];
							const preview = document
									.getElementById('imagePreview');

							if (file) {
								const reader = new FileReader();
								reader.onload = function(e) {
									preview.src = e.target.result;
									preview.style.display = 'block';
								}
								reader.readAsDataURL(file);
							} else {
								preview.src = '#';
								preview.style.display = 'none';
							}
						}
					</script>
					<div class="form-group mt-3" align="center">
						<button type="submit" class="btn btn-primary">Cập nhật</button>
						<button type="button" class="btn btn-secondary"
							onclick="window.location.href='/LTWeb_ST4_22133048/waiting'">Quay
							lại</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>