package Tuan_3.controllers;
import java.io.IOException;

import Tuan_3.utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		Cookie[] cookies = req.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals(Constant.COOKIE_REMEMBER)) {
	                // Chỉ xóa cookie nếu người dùng không chọn "Remember Me"
	                String rememberMeValue = cookie.getValue();
	                if (rememberMeValue == null || rememberMeValue.equals("")) {
	                    Cookie usernameCookie = new Cookie("username", "");
	                    usernameCookie.setMaxAge(0); // Xóa cookie username
	                    usernameCookie.setPath("/"); // Đảm bảo đường dẫn khớp
	                    resp.addCookie(usernameCookie);
	                }
	            }
	        }
	    }
		
	    resp.sendRedirect(req.getContextPath() + "/login");
	}
}