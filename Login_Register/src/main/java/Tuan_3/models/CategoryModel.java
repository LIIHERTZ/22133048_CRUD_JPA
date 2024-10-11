package Tuan_3.models;

import java.io.Serializable;

public class CategoryModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int categoryid;
	private String categoryname;
	private String categoryimages;
	private int status;
	public CategoryModel() {
		super();
	}
	

	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}



	public int getStatus() {
		return status;
	}


	public CategoryModel(int categoryid, String categoryname, String categoryimages, int status) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.categoryimages = categoryimages;
		this.status = status;
	}


	public String getCategoryimages() {
		return categoryimages;
	}


	public void setCategoryimages(String categoryimages) {
		this.categoryimages = categoryimages;
	}


	public void setStatus(int status) {
		this.status = status;
		
	}

	
	public String toString() {
		return "Category [categoryid=" + categoryid + ", categoryname=" + categoryname + ", images=" + categoryimages
				+ ", status=" + status + "]";
	}

}
