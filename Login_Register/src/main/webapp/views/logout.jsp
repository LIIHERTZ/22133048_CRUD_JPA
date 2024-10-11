<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Logout</title>
</head>
<body>
    <%
        // Kết thúc phiên làm việc
        HttpSession ss = request.getSession(false);
        if (ss != null) {
            ss.invalidate();
        }

        // Xóa các cookie liên quan (nếu có)
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    cookie.setMaxAge(0); // Xóa cookie
                    response.addCookie(cookie);
                }
            }
        }

        // Chuyển hướng đến trang đăng nhập
        response.sendRedirect("/Login_Register/login");
    %>
    <p>You have been logged out. Redirecting to login page...</p>
</body>
</html>