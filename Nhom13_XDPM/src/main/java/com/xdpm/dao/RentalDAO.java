package com.xdpm.dao;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Query;

import com.xdpm.entity.RentalRecord;

public class RentalDAO extends AbstractCRUD<RentalRecord>{

	//lấy record của đĩa chưa trả
	public RentalRecord getByDiskID(int diskID) {
		Query query = entityManager.createQuery("from RentalRecord where diskID = :id and returnDate is null", RentalRecord.class);
		query.setParameter("id", diskID);
		return (RentalRecord) query.getSingleResult();
	}
	
	//Kiểm tra trả trễ
	public boolean checkLateReturn(RentalRecord record) {
		Date present = new Date();
		//Kiểm tra hiện tại vs ngày trả, i > 0 => quá hạn trả
		int i = present.compareTo(record.getDueDate());
		return i>0 ? true:false;
	}
	
	//Tính phí trễ
	public double calculateLateFee(RentalRecord record) {
		Date present = new Date();
		double totalLateFee = 0;
		
		//Tính khoảng cách 2 ngày
		long getDiff = present.getTime() - record.getDueDate().getTime();
		long daysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
		
		double lateFee = record.getDisk().getTitle().getCategory().getLateFee();
		totalLateFee = daysDiff * lateFee;
		
		return totalLateFee;
	}
	
	
}
