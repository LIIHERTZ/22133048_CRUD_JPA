package Tuan_3.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import Tuan_3.models.CategoryModel;
import Tuan_3.services.ICategoryService;
import Tuan_3.services.impl.CategoryServiceImpl;
import Tuan_3.utils.Constant;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/categories", "/admin/category/add", "/admin/category/insert",
		"/admin/category/edit", "/admin/category/update", "/admin/category/delete", "/admin/category/search", })
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("categories")) {
			List<CategoryModel> list = cateService.findAll();

			req.setAttribute("listcate", list);

			if (list != null && !list.isEmpty()) {
			    req.setAttribute("message", "Categories found.");
			} else {
			    req.setAttribute("message", "No categories found.");
			}
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		} else if (url.contains("add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		} else if (url.contains("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModel category = cateService.findById(id);
			req.setAttribute("cate", category);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		} else if (url.contains("delete")) {
			String id = req.getParameter("id");
			cateService.delete(Integer.parseInt(id));
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("insert")) {
			String catagoryname = req.getParameter("categoryname");
			String status = req.getParameter("status");
			int statuss = Integer.parseInt(status);
			String fname = "";
			String uploadPath = Constant.UPLOAD_DIRECTORY;
			CategoryModel category = new CategoryModel();
			category.setCategoryname(catagoryname);
			category.setCategoryimages(fname);
			category.setStatus(statuss);

			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("image");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getName()).getFileName().toString();
					// đổi tên file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// upload file vào data
					part.write(uploadPath + "/" + fname);
					// ghi tên file vào data
					category.setCategoryimages(fname);

				} else {
					category.setCategoryimages("avata.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		} else if (url.contains("update")) {
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));
			String catagoryname = req.getParameter("categoryname");
			String status = req.getParameter("status");
			int statuss = Integer.parseInt(status);

			String fname = "";
			String uploadPath = Constant.UPLOAD_DIRECTORY;
			CategoryModel category = new CategoryModel();
			category.setCategoryid(categoryid);
			category.setCategoryname(catagoryname);
			category.setCategoryimages(fname);
			category.setStatus(statuss);
			// lưu hình cũ
			CategoryModel cateoId = cateService.findById(categoryid);
			String fileoId = cateoId.getCategoryimages();
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("image");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getName()).getFileName().toString();
					// đổi tên file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// upload file vào data
					part.write(uploadPath + "/" + fname);
					// ghi tên file vào data
					category.setCategoryimages(fname);

				} else {
					category.setCategoryimages(fname);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			cateService.update(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		} else if (url.contains("delete")) {
			String id = req.getParameter("id");
			if (id != null && !id.isEmpty()) {
				resp.sendRedirect(req.getContextPath() + "/admin/categories?id=" + id);
			} else {
				resp.sendRedirect(req.getContextPath() + "/admin/categories");
			}

		}
	}

}
