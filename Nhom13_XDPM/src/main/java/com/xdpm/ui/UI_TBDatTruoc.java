package com.xdpm.ui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.xdpm.dao.ReservationDAO;
import com.xdpm.entity.ReservationRecord;
import com.xdpm.util.FormatString;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UI_TBDatTruoc extends JDialog{
	
	private DefaultTableModel modelDatTruoc;
	private JTable tblDatTruoc;
	private ReservationDAO reservationDAO = new ReservationDAO();

	public UI_TBDatTruoc(HashMap<Integer, Integer> map) {
		super();
		setTitle("Thông tin đặt trước");
		setSize(550, 400);
		setLocationRelativeTo(null);
		setModal(rootPaneCheckingEnabled);
		setIconImage(null);
		getContentPane().setLayout(null);
		
		JLabel lblDatTruoc = new JLabel("Danh sách đĩa vừa được giữ cho khách");
		lblDatTruoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatTruoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatTruoc.setBounds(120, 31, 315, 25);
		getContentPane().add(lblDatTruoc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 516, 275);
		getContentPane().add(scrollPane);
		
		String[] title = { "STT", "Mã đĩa", "Tựa đĩa","Tên khách hàng", "Số điện thoại"};
		modelDatTruoc = new DefaultTableModel(title, 0);
		tblDatTruoc = new JTable(modelDatTruoc) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tblDatTruoc.getTableHeader().setReorderingAllowed(false);
		tblDatTruoc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tblDatTruoc.setBounds(10, 45, 678, 247);
		scrollPane.setViewportView(tblDatTruoc);
		
		loadTable(map);
	}

	private void loadTable(HashMap<Integer, Integer> map) {
		ReservationRecord record;
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			//diskID-customerID
			int diskID = entry.getKey();
			int customerID = entry.getValue();
			int i = tblDatTruoc.getRowCount();
			
			record = reservationDAO.getRecordByCusIDAndDiskID(customerID, diskID);
			String[] rowData = {i+1+"", record.getDisk().getId()+"", record.getDisk().getTitle().getName(),
					record.getCustomer().getName(), record.getCustomer().getPhoneNumber()};
			modelDatTruoc.addRow(rowData);
		}
		tblDatTruoc.setModel(modelDatTruoc);
	}
}
