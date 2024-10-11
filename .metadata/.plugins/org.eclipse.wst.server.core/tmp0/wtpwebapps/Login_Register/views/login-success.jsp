<%-- <%@page import="Tuan_3.models.UserModel"%>
<%@page import="Tuan_3.controllers.WaitingController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f9;
	margin: 0;
	padding: 0;
	text-align: center;
}

.container {
	max-width: 600px;
	margin: 50px auto;
	padding: 20px;
	background: #fff;
	border-radius: 8px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #333;
}

p {
	font-size: 1.2em;
	color: #555;
}

.button {
    display: inline-block;
    padding: 10px 20px;
    margin-top: 20px;
    border: none;
    border-radius: 5px;
    color: #fff;
    background-color: #007bff;
    text-decoration: none;
    cursor: pointer;
}

.button:hover {
    background-color: #0056b3;
}
</style>
<script>
function confirmLogout() {
    var result = confirm("Bạn có chắc chắn muốn đăng xuất?");
    if (result) {
        window.location.href = 'views/logout.jsp';
    }
}
</script>
</head>
<body>
	<div class="container">
		<h1>Login Success</h1>
		<p>You are successfully logged in!</p>
		<%
		UserModel account = (UserModel) request.getAttribute("account");
		if (account != null) {
			out.print("<p>Welcome, " + account.getFullName() + "</p>");
		} else {
			out.print("<p>Error: Account not found.</p>");
		}
		%>
		<!-- Nút Logout -->
		<button class="button" onclick="confirmLogout()">Logout</button>
		<button type="button" class="btn btn-secondary"
                onclick="window.location.href='${pageContext.request.contextPath}/profile'">Edit
                Info</button>
	</div>
</body>

</html>
 --%>
 
 <%@page import="Tuan_3.models.UserModel"%>
<%@page import="Tuan_3.controllers.WaitingController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    margin: 0;
    padding: 0;
    text-align: center;
}

.container {
    max-width: 600px;
    margin: 50px auto;
    padding: 20px;
    background: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

h1 {
    color: #333;
}

p {
    font-size: 1.2em;
    color: #555;
}

button {
    margin: 10px;
}
</style>
</head>
<body>
    <div class="container">
        <h1>Login Success</h1>
        <p>You are successfully logged in!</p>
        <%
        UserModel account = (UserModel) request.getAttribute("account");
        if (account != null) {
            out.print("<p>Welcome, " + account.getFullName() + "</p>");
        } else {
            out.print("<p>Error: Account not found.</p>");
        }
        %>
        <div class="form-group mt-3" align="center">
            <!-- Nút Đăng xuất -->
            <button type="button" class="btn btn-primary"
                onclick="window.location.href='${pageContext.request.contextPath}/logout'">Đăng
                xuất</button>

            <!-- Nút Edit Info -->
            <button type="button" class="btn btn-secondary"
                onclick="window.location.href='${pageContext.request.contextPath}/profile'">Edit
                Info</button>
        </div>
    </div>
</body>
</html>