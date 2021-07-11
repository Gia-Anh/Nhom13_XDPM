package com.xdpm.dao;

import java.util.List;

import javax.persistence.Query;

import com.xdpm.entity.Disk;

public class DiskDAO extends AbstractCRUD<Disk>{
	
	public List<Disk> getAllDiskByTitleID(int titleID) {
		Query query = entityManager.createQuery("from Disk where titleID = :titleID", Disk.class);
		query.setParameter("titleID", titleID);
		return query.getResultList();
	}
	
	public Disk getDiskByID(int id) {
		return entityManager.find(Disk.class, id);
	}
}
