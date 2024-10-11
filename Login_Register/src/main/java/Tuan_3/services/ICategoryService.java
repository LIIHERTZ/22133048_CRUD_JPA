package Tuan_3.services;

import java.util.List;

import Tuan_3.models.CategoryModel;

public interface ICategoryService {
	void insert(CategoryModel category);
	void edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	CategoryModel get(String name);
	List<CategoryModel> getAll();
	List<CategoryModel> findAll();
	CategoryModel findById(int id);
	void update(CategoryModel category);
}
