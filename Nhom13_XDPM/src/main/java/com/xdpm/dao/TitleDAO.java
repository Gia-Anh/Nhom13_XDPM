package com.xdpm.dao;

import java.util.List;

import javax.persistence.Query;

import com.xdpm.entity.Title;

public class TitleDAO extends AbstractCRUD<Title>{
	
	public List<Title> getAllTitleByCategoryID(int categoryID) {
		Query query = entityManager.createQuery("from Title where categoryID = :categoryID and enabled = true", Title.class);
		query.setParameter("categoryID", categoryID);
		return query.getResultList();
	}
	
	public Title getTitleByID(int id) {
		Title title = entityManager.find(Title.class, id);
		if (title != null && title.isEnabled()) {
			return title;
		}
		return null;
	}
	
	public void deleteTitle(int id) {
		Title title = entityManager.find(Title.class, id);
		title.setEnabled(false);
		update(title);
	}
}
