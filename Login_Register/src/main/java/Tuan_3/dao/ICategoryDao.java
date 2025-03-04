package Tuan_3.dao;

import java.util.List;

import Tuan_3.models.CategoryModel;

public interface ICategoryDao {
	void insert(CategoryModel CategoryModel);
	void edit(CategoryModel CategoryModel);
	void delete(int id);
	CategoryModel get(int id);
	CategoryModel get(String name);
	List<CategoryModel> getAll();
	void update(CategoryModel category);
	CategoryModel findById(int categoryid);
	List<CategoryModel> findAll();
	List<CategoryModel> findByCategoryName(String keyword);
}
