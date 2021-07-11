package com.xdpm.dao;

import java.util.List;

import javax.persistence.Query;

import com.xdpm.entity.Title;

public class TitleDAO extends AbstractCRUD<Title>{
	
	public List<Title> getAllTitleByCategoryID(int categoryID) {
		Query query = entityManager.createQuery("from Title where categoryID = :categoryID", Title.class);
		query.setParameter("categoryID", categoryID);
		return query.getResultList();
	}
	
	public Title getTitleByID(int id) {
		return entityManager.find(Title.class, id);
	}
}
