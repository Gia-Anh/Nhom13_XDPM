package com.xdpm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.xdpm.entity.Title;

public class TitleDAO extends AbstractCRUD<Title>{
	private DiskDAO diskDAO;
	
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
	
	public List<Title> findTitleByName(String name) {
		List<Title> list = new ArrayList<Title>();
		Query query = entityManager.createQuery("from Title where lower(name) like :titleName and enabled = true", Title.class);
		query.setParameter("titleName", "%" + name.toLowerCase() + "%");
		list = query.getResultList();
		return list;
	}
	
	
}
