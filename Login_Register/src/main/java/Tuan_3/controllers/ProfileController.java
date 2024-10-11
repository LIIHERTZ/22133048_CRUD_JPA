package Tuan_3.controllers;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import Tuan_3.dao.impl.UserDaoImpl;
import Tuan_3.services.impl.UserServiceImpl;
import Tuan_3.models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


@WebServlet("/profile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ProfileController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
        UserModel user = (UserModel) session.getAttribute("account");

        req.setAttribute("user", user);
        req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		
		String alertMsg = "";
		
		//Lấy thông tin từ sesssion
		HttpSession session = request.getSession();
	    Integer userId = (Integer) session.getAttribute("userId");
	    
	    
	    // Lấy thông tin từ form
//	    int userId = Integer.parseInt(request.getParameter("id"));
	    String fullName = request.getParameter("fullName");
	    String phone = request.getParameter("phone");

	    // Xử lý upload file
	    Part filePart = request.getPart("images");
	    if (filePart == null || filePart.getSize() == 0) {
	        response.sendRedirect("views/profile.jsp?error=No file uploaded");
	        return;
	    }
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	    String images = "uploads/" + fileName;
	    
	    // Lưu file vào server
	    String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) uploadDir.mkdir();
	    
	    filePart.write(uploadPath + File.separator + fileName);

	    // Cập nhật thông tin người dùng
	    UserDaoImpl userDAO = new UserDaoImpl();
	    UserModel user = new UserModel();
	    user.setId(userId);
	    user.setFullName(fullName);
	    user.setPhone(phone);
	    user.setImages(images);
	    
	    boolean updateSuccess = userDAO.updateUserInfo(user);

	    if (updateSuccess) {
	    	alertMsg = "Cập nhật thông tin thành công";
			request.setAttribute("alert", alertMsg);
			request.setAttribute("user", user);
	        request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
	    } else {
	    	alertMsg = "Cập nhật thông tin thất bại";
			request.setAttribute("alert", alertMsg);
			response.sendRedirect(request.getContextPath() + "/profile.jsp");
	    }
	}
}