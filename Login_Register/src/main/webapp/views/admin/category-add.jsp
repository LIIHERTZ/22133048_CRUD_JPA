<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<form action="${pageContext.request.contextPath}/admin/category/insert" method="post" enctype = "multipart/form-data">
    <label for="fname">Category name:</label><br>
    <input type="text" id="categoryname" name="categoryname"><br>
    <label for="lname">Image:</label><br>
    <img height="150" width="200" src="" id="image" /><br>
    <input type="file" onchange="chooseFile(this)" id="image" name="image"><br>
    <p>Status:</p>
    <input type="radio" id="ston" name="status" value="1" checked>
    <label for="html">Đang hoạt động</label><br>
    <input type="radio" id="stoff" name="status" value="0">
    <label for="css">Khóa</label><br>
    
    <input type="submit" value="Insert">
</form>

