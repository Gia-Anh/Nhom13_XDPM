package com.xdpm.ui;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.xdpm.dao.CustomerDAO;
import com.xdpm.dao.DiskDAO;
import com.xdpm.dao.RentalDAO;
import com.xdpm.dao.ReservationDAO;
import com.xdpm.entity.Customer;
import com.xdpm.entity.Disk;
import com.xdpm.entity.RentalRecord;
import com.xdpm.entity.ReservationRecord;
import com.xdpm.util.FormatString;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;

public class UI_ThueDia extends JPanel{
	private JTextField tfCusID;
	private JTextField tfCusName;
	private JTextField tfAddress;
	private JTextField tfPhoneNumber;
	private JTextField tfDiskID;
	private JTable tblCart;
	private DefaultTableModel modelCart;
	private DefaultTableModel modelDisk;
	private JTable tblDisk;
	private JTextField tfTienNoPhi;
	private JTextField tfTienThue;
	private JTextField tfNoPhi;
	private JTextField tfTongTien;
	private JButton btnTTTreHan;
	private boolean flag = true;
	
	private DiskDAO diskDAO = new DiskDAO();
	private CustomerDAO customerDAO = new CustomerDAO();
	private RentalDAO rentalDAO = new RentalDAO();
	
	public UI_ThueDia() {
		setLayout(null);
		
		JPanel pnlKhachHang = new JPanel();
		pnlKhachHang.setBorder(new TitledBorder(null, "Khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlKhachHang.setBounds(712, 10, 344, 280);
		add(pnlKhachHang);
		pnlKhachHang.setLayout(null);
		
		JLabel lblID = new JLabel("Mã khách hàng");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblID.setBounds(10, 25, 100, 25);
		pnlKhachHang.add(lblID);
		
		tfCusID = new JTextField();
		tfCusID.setBounds(121, 25, 70, 25);
		pnlKhachHang.add(tfCusID);
		tfCusID.setColumns(10);
		
		JButton btnFindCustomer = new JButton("Tìm");
		btnFindCustomer.setBounds(200, 25, 62, 25);
		pnlKhachHang.add(btnFindCustomer);
		
		JButton btnAddCustomer = new JButton("Thêm");
		btnAddCustomer.setBounds(272, 25, 62, 25);
		pnlKhachHang.add(btnAddCustomer);
		
		JLabel lblCusName = new JLabel("Tên khách hàng");
		lblCusName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCusName.setBounds(10, 70, 100, 25);
		pnlKhachHang.add(lblCusName);
		
		tfCusName = new JTextField();
		tfCusName.setBackground(Color.WHITE);
		tfCusName.setEditable(false);
		tfCusName.setBounds(121, 70, 213, 25);
		pnlKhachHang.add(tfCusName);
		tfCusName.setColumns(40);
		
		JLabel lblAddress = new JLabel("Địa chỉ");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setBounds(10, 115, 100, 25);
		pnlKhachHang.add(lblAddress);
		
		tfAddress = new JTextField();
		tfAddress.setEditable(false);
		tfAddress.setBackground(Color.WHITE);
		tfAddress.setBounds(121, 115, 213, 25);
		pnlKhachHang.add(tfAddress);
		tfAddress.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Số điện thoại");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(10, 160, 84, 25);
		pnlKhachHang.add(lblPhoneNumber);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setEditable(false);
		tfPhoneNumber.setBackground(Color.WHITE);
		tfPhoneNumber.setText("");
		tfPhoneNumber.setBounds(123, 160, 211, 25);
		pnlKhachHang.add(tfPhoneNumber);
		tfPhoneNumber.setColumns(10);
		
		JLabel lblTienNoPhi = new JLabel("Tiền nợ phí");
		lblTienNoPhi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTienNoPhi.setBounds(10, 205, 70, 25);
		pnlKhachHang.add(lblTienNoPhi);
		
		tfTienNoPhi = new JTextField();
		tfTienNoPhi.setEditable(false);
		tfTienNoPhi.setForeground(Color.RED);
		tfTienNoPhi.setBackground(Color.WHITE);
		tfTienNoPhi.setBounds(121, 205, 213, 25);
		pnlKhachHang.add(tfTienNoPhi);
		tfTienNoPhi.setColumns(10);
		
		btnTTTreHan = new JButton("Thanh toán trễ hạn");
		btnTTTreHan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTTTreHan.setBounds(121, 240, 150, 25);
		pnlKhachHang.add(btnTTTreHan);
		btnTTTreHan.setEnabled(false);
		
		JPanel pnlThueDia = new JPanel();
		pnlThueDia.setBorder(new TitledBorder(null, "Thuê đĩa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThueDia.setBounds(10, 10, 698, 280);
		add(pnlThueDia);
		pnlThueDia.setLayout(null);
		
		JLabel lblDiskID = new JLabel("Nhập ID đĩa: ");
		lblDiskID.setBounds(204, 20, 74, 25);
		pnlThueDia.add(lblDiskID);
		
		tfDiskID = new JTextField();
		tfDiskID.setBounds(288, 20, 96, 25);
		pnlThueDia.add(tfDiskID);
		tfDiskID.setColumns(10);
		
		JButton btnAddDisk = new JButton("Thêm");
		btnAddDisk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddDisk.setBounds(394, 20, 85, 25);
		pnlThueDia.add(btnAddDisk);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 678, 215);
		pnlThueDia.add(scrollPane);
		
		String[] title = { "STT", "Mã đĩa", "Tựa đề", "Loại đĩa", "Hạn trả", "Tiền thuê"};
		modelCart = new DefaultTableModel(title, 0);
		tblCart = new JTable(modelCart) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tblCart.getTableHeader().setReorderingAllowed(false);
		tblCart.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tblCart.setBounds(10, 45, 678, 247);
		scrollPane.setViewportView(tblCart);
		
		JPanel pnlDiaTreHan = new JPanel();
		pnlDiaTreHan.setBorder(new TitledBorder(null, "Thông tin phí trễ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiaTreHan.setBounds(10, 297, 698, 193);
		add(pnlDiaTreHan);
		pnlDiaTreHan.setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 20, 678, 163);
		pnlDiaTreHan.add(scrollPane2);

		String[] title2 = { "STT", "Mã đĩa", "Tựa đề", "Hạn trả", "Ngày trả", "Phí trễ"};
		modelDisk = new DefaultTableModel(title2, 0);
		tblDisk = new JTable(modelDisk) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tblDisk.getTableHeader().setReorderingAllowed(false);
		tblDisk.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tblDisk.setBounds(10, 45, 678, 247);
		scrollPane2.setViewportView(tblDisk);
		
		JPanel pnlThanhToan = new JPanel();
		pnlThanhToan.setBorder(new TitledBorder(null, "Thông tin thanh toán", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThanhToan.setBounds(712, 297, 344, 193);
		add(pnlThanhToan);
		pnlThanhToan.setLayout(null);
		
		JLabel lblNoPhi = new JLabel("Tiền nợ phí");
		lblNoPhi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNoPhi.setBounds(10, 70, 70, 25);
		pnlThanhToan.add(lblNoPhi);
		
		JLabel lblTienThue = new JLabel("Tiền thuê");
		lblTienThue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTienThue.setBounds(10, 25, 60, 25);
		pnlThanhToan.add(lblTienThue);
		
		JLabel lblTongTien = new JLabel("Tổng tiền");
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongTien.setBounds(10, 115, 70, 25);
		pnlThanhToan.add(lblTongTien);
		
		tfTienThue = new JTextField();
		tfTienThue.setBackground(Color.WHITE);
		tfTienThue.setForeground(Color.BLACK);
		tfTienThue.setEditable(false);
		tfTienThue.setBounds(121, 25, 213, 25);
		pnlThanhToan.add(tfTienThue);
		tfTienThue.setColumns(10);
		tfTienThue.setText("0 đ");
		
		tfNoPhi = new JTextField();
		tfNoPhi.setBackground(Color.WHITE);
		tfNoPhi.setEditable(false);
		tfNoPhi.setBounds(121, 70, 213, 25);
		pnlThanhToan.add(tfNoPhi);
		tfNoPhi.setColumns(10);
		tfNoPhi.setText("0 đ");
		
		tfTongTien = new JTextField();
		tfTongTien.setEditable(false);
		tfTongTien.setBackground(Color.WHITE);
		tfTongTien.setBounds(121, 115, 213, 25);
		pnlThanhToan.add(tfTongTien);
		tfTongTien.setColumns(10);
		tfTongTien.setText("0 đ");
		
		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBounds(60, 155, 100, 25);
		pnlThanhToan.add(btnThanhToan);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(200, 155, 100, 25);
		pnlThanhToan.add(btnHuy);
		
		//===============================================================
		btnAddDisk.addActionListener(e ->{
			try {
				int diskID = Integer.parseInt(tfDiskID.getText());
				Disk disk = diskDAO.getDiskByID(diskID);
				if (disk != null) {
					if (disk.getStatus().equals("rented")) {
						JOptionPane.showMessageDialog(null, "Đĩa này đang được thuê!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}else if (disk.getStatus().equals("onHold")) {
						JOptionPane.showMessageDialog(null, "Đĩa này đang được giữ!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}else {
						if (!checkExistOnTable(tblCart, diskID)) {
							int i = modelCart.getRowCount();
							String[] rowData = {i+1+"", disk.getId()+"", disk.getTitle().getName(),
									disk.getTitle().getCategory().getName(), FormatString.formatDate(getDueDate(disk.getTitle().getCategory().getRentalPeriod()))
									, disk.getTitle().getCategory().getRentalCharge()+""};
							modelCart.addRow(rowData);
							tblCart.setModel(modelCart);
							
							tfTienThue.setText(FormatString.formatTienVN(totalRentalCharge(tblCart))+" đ");
							tfTongTien.setText(FormatString.formatTienVN(totalCharge())+ " đ");
						}else {
							JOptionPane.showMessageDialog(null, "Đĩa này đã thêm rồi!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy đĩa này!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Mã đĩa không hợp lệ!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnFindCustomer.addActionListener(e ->{
			try {
				int cusID = Integer.parseInt(tfCusID.getText());
				Customer customer = customerDAO.getCustomerByID(cusID);
				if (customer != null) {
					tfCusName.setText(customer.getName());
					tfAddress.setText(customer.getAddress());
					tfPhoneNumber.setText(customer.getPhoneNumber());
					
					clearTableDisk();
					loadTableLateFee(cusID);
				}else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng này!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Mã khách hàng không hợp lệ!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnThanhToan.addActionListener(e ->{
			try {
				if (tfTongTien.getText().equals("0 đ")) {
					JOptionPane.showMessageDialog(null, "Chưa có dữ liệu thanh toán!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}else {
					int rowCount = tblCart.getRowCount();
					String str_cusID = tfCusID.getText().toString();
					int cusID = Integer.parseInt(str_cusID);
					Customer customer = customerDAO.getCustomerByID(cusID);
					for (int i = 0; i < rowCount; i++) {
						int diskID = Integer.parseInt(tblCart.getValueAt(i, 1).toString());
						Disk disk = diskDAO.getDiskByID(diskID);
						RentalRecord record = new RentalRecord();
						record.setCustomer(customer);
						record.setDisk(disk);
						double rentalCharge = Double.parseDouble(tblCart.getValueAt(i, 5).toString());
						record.setRentalCharge(rentalCharge);
						record.setRentDate(new Date());
						
						Date dueDate = convertDate(tblCart.getValueAt(i, 4).toString());
						record.setDueDate(dueDate);
						
						rentalDAO.add(record);
						disk.setStatus("rented");
						diskDAO.update(disk);
					}
					if (!flag) {
						updateRecord(cusID);
					}
					JOptionPane.showMessageDialog(null, "Thanh toán thành công!!", "", JOptionPane.INFORMATION_MESSAGE);
					clearAll();
					btnTTTreHan.setEnabled(false);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Mã khách hàng không hợp lệ!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnHuy.addActionListener(e ->{
			if (JOptionPane.showConfirmDialog(this, "Hủy giao dịch này?", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				clearAll();
				btnTTTreHan.setEnabled(false);
			}
		});
		
		
		btnTTTreHan.addActionListener(e ->{
			if (tfTienNoPhi.getText().equals("0 đ")) {
				JOptionPane.showMessageDialog(null, "Khách hàng này không có phí trễ!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}else {
				if (flag) {
					tfNoPhi.setText(tfTienNoPhi.getText());
					tfTongTien.setText(FormatString.formatTienVN(totalCharge())+ " đ");
					flag = false;
					btnTTTreHan.setText("Hủy thanh toán trễ");
				}else {
					tfNoPhi.setText("0 đ");
					tfTongTien.setText(FormatString.formatTienVN(totalCharge())+ " đ");
					flag = true;
					btnTTTreHan.setText("Thanh toán trễ hạn");
				}
			}
		});
		
		btnAddCustomer.addActionListener(e ->{
			UI_ThemNhanhKH ui_themKH = new UI_ThemNhanhKH();
			ui_themKH.setVisible(true);
		});
	}
	
	private void clearTableCart() {
		while(modelCart.getRowCount()>0) {
			modelCart.removeRow(0);
		}
	}
	
	private void clearTableDisk() {
		while(modelDisk.getRowCount()>0) {
			modelDisk.removeRow(0);
		}
	}
	
	private void clearAll() {
		clearTableCart();
		clearTableDisk();
		tfDiskID.setText("");
		tfCusID.setText("");
		tfAddress.setText("");
		tfCusName.setText("");
		tfPhoneNumber.setText("");
		tfTienNoPhi.setText("");
		tfTienThue.setText("0 đ");
		tfNoPhi.setText("0 đ");
		tfTongTien.setText("0 đ");
		flag = true;
		btnTTTreHan.setText("Thanh toán trễ hạn");
	}

	//Tính ngày trả = ngày thuê(hiện tại) + số ngày thuê
	private Date getDueDate(int rentalPeriod) {
		Date date = new Date();
		
		Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, rentalPeriod);
        
        Date dueDate = c.getTime();
        return dueDate;
	}
	
	private boolean checkExistOnTable(JTable table, int diskID) {
		int rowCount = table.getRowCount();
		String id = diskID+"";
		for (int i = 0; i < rowCount; i++) {
	        if (id.equals(table.getValueAt(i, 1).toString())) {
				return true;
			}
	    }
		return false;
	}
	
	private double totalRentalCharge(JTable table) {
		int rowCount = table.getRowCount();
		double total = 0;
		for (int i = 0; i < rowCount; i++) {
	        total += Double.parseDouble(table.getValueAt(i, 5)+"");
	    }
		return total;
	}
	
	private double totalCharge() {
		double rentalCharge = getDoubleValue(tfTienThue);
		double lateFee = getDoubleValue(tfNoPhi);
		return rentalCharge + lateFee;
	}
	
	//Lấy giá trị tiền từ text field
	private double getDoubleValue(JTextField textField) {
		String string = textField.getText().toString();
		String[] parts = string.split(" ");
		String str_value = parts[0];
		return Double.parseDouble(str_value.replace(",", ""));
	}
	
	private Date convertDate(String str) throws ParseException {
		 SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		 return formatter.parse(str);  
	}
	
	private void loadTableLateFee(int cusID) {
		List<RentalRecord> record = rentalDAO.getListUnpaidRecord(cusID);
		double lateFee = 0;
		for (RentalRecord rentalRecord : record) {
			int i = modelDisk.getRowCount();
			String[] rowData = {i+1+"", rentalRecord.getDisk().getId()+"", rentalRecord.getDisk().getTitle().getName(),
					FormatString.formatDate(rentalRecord.getDueDate()),
					FormatString.formatDate(rentalRecord.getReturnDate()), rentalRecord.getLateFee()+""};
			lateFee += rentalRecord.getLateFee();
			modelDisk.addRow(rowData);
		}
		tblDisk.setModel(modelDisk);
		tfTienNoPhi.setText(FormatString.formatTienVN(lateFee)+" đ");
		
		if (lateFee > 0) {
			btnTTTreHan.setEnabled(true);
		}
	}
	
	private void updateRecord(int cusID) {
		int rowCount = tblDisk.getRowCount();
		RentalRecord record;
		for (int i = 0; i < rowCount; i++) {
			try {
				int diskID = Integer.parseInt(tblDisk.getValueAt(i, 1)+"");
				Date returnDate = convertDate(tblDisk.getValueAt(i, 4)+"");
				record = rentalDAO.getByDiskIDAndCusID(diskID, cusID, returnDate);
				record.setPaid(true);
				rentalDAO.update(record);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
