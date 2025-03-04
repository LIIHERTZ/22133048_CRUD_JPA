package Tuan_3.dao.impl;

import Tuan_3.configs.DBConnection;
import Tuan_3.dao.ICategoryDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Tuan_3.models.CategoryModel;

public class CategoryDaoImpl extends DBConnection implements ICategoryDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public void insert(CategoryModel category) {
		String sql = "insert into category(categoryname,images,status) Values(?,?,?)";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2,category.getCategoryimages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public void update(CategoryModel category) {
		String sql = "UPDATE category SET categoryname = ?, images = ?, status = ? WHERE categoryid = ?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getCategoryimages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CategoryModel category) {
		String sql = "UPDATE category SET categoryname = ?, images=? WHERE categoryid = ?";
		try {
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, category.getCategoryname());
		ps.setString(2, category.getCategoryimages());
		ps.setInt(3, category.getCategoryid());
		ps.executeUpdate();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM category WHERE categoryid = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		con.close();
		ps.close();
		} catch (Exception e) {
		e.printStackTrace();
		}


	}

	@Override
	public CategoryModel get(int id) {
		String sql = "SELECT * FROM category WHERE categoryid = ? ";
		try {
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		CategoryModel category = new CategoryModel();
		category.setCategoryid(rs.getInt("categoryid"));
		category.setCategoryname(rs.getString("categoryname"));
		category.setCategoryimages(rs.getString("images"));
		return category;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;

	}

	@Override
	public CategoryModel get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> getAll() {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM Category";
		try {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		CategoryModel category = new CategoryModel();
		category.setCategoryid(rs.getInt("categoryid"));
		category.setCategoryname(rs.getString("categoryname"));
		category.setCategoryimages(rs.getString("images"));
		categories.add(category);
		}} catch (Exception e) {
		e.printStackTrace();}
		return categories;

	}

	
	public CategoryModel findById(int id) {
		String sql = "SELECT * FROM category WHERE categoryid = ?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setCategoryimages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				return category;
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<CategoryModel> findByCategoryName(String name) {
		List<CategoryModel> categories = new ArrayList<>();
		String sql = "SELECT * FROM category WHERE categoryname like ?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setCategoryimages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				categories.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<CategoryModel> findAll() {
		List<CategoryModel> categories = new ArrayList<>();
		String sql = "SELECT * FROM category";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setCategoryimages(rs.getString("images"));
				category.setCategoryimages(rs.getString("images"));
				categories.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
