<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<form action="<c:url value='/admin/category/update'></c:url>" method="post" enctype="multipart/form-data">
    <input type="hidden" id="categoryid" name="categoryid" value="${cate.categoryid}"><br>
    <label for="categoryname">Category Name:</label><br>
    <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br>
    
    <label for="image">Image:</label><br>
    <c:if test="${cate.images.substring(0,5) != 'https' }">
        <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
    </c:if> 
    <c:if test="${cate.images.substring(0,5) == 'https' }">
        <c:url value="${cate.images}" var="imgUrl"></c:url>
    </c:if> 
    <img id="images" height="150" width="200" src="${imgUrl}" /><br>
    <input type="file" onchange="chooseFile(this)" id="image" name="image" value="${cate.images}"><br>
    <p>Status:</p>
    <input type="radio" id="ston" name="status" value="1" ${cate.status == 1 ? 'checked' : ''}>
    <label for="ston">Đang hoạt động</label><br>
    <input type="radio" id="stoff" name="status" value="0" ${cate.status != 1 ? 'checked' : ''}>
    <label for="stoff">Khóa</label><br>
    
    <input type="submit" value="Update">
</form>

