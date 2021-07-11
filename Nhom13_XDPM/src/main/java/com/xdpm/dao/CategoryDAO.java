package com.xdpm.dao;

import java.util.List;

import javax.persistence.Query;

import com.xdpm.entity.Category;

public class CategoryDAO extends AbstractCRUD<Category>{
	
	public List<Category> getAllCategory() {
		Query query = entityManager.createQuery("from Category", Category.class);
		return query.getResultList();
	}
	
	public Category getCategoryByID(int id) {
		return entityManager.find(Category.class, id);
	}
	
	public static void main(String[] args) {
		CategoryDAO dao = new CategoryDAO();
	}
}
