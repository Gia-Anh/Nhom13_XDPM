package com.xdpm.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.xdpm.dao.DiskDAO;
import com.xdpm.dao.RentalDAO;
import com.xdpm.entity.Disk;
import com.xdpm.entity.RentalRecord;
import com.xdpm.util.FormatString;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.SwingConstants;

public class UI_TraDia extends JPanel{
	private DefaultTableModel modelTraDia;
	private JTable tblTraDia;
	private JTextField tfDiskID;
	
	private RentalDAO rentalDAO = new RentalDAO();
	private DiskDAO diskDAO = new DiskDAO();
	private JTextField tfLateFee;
	private boolean isChecked = false;
	private JCheckBox chkPayment;
	
	public UI_TraDia() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 54, 745, 398);
		add(scrollPane);
		
		String[] title = { "STT", "Mã đĩa", "Mã khách hàng", "Tựa đề","Ngày thuê", "Hạn trả", "Trả trễ", "Phí trễ" };
		modelTraDia = new DefaultTableModel(title, 0);
		tblTraDia = new JTable(modelTraDia) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tblTraDia.getTableHeader().setReorderingAllowed(false);
		tblTraDia.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tblTraDia.setBounds(10, 45, 678, 247);
		scrollPane.setViewportView(tblTraDia);
		
		JLabel lnlDiskID = new JLabel("Nhập mã đĩa");
		lnlDiskID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lnlDiskID.setBounds(800, 140, 83, 25);
		add(lnlDiskID);
		
		tfDiskID = new JTextField();
		tfDiskID.setBounds(880, 140, 83, 25);
		add(tfDiskID);
		tfDiskID.setColumns(10);
		
		JButton btnAddDisk = new JButton("Thêm");
		btnAddDisk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddDisk.setBounds(973, 140, 71, 25);
		add(btnAddDisk);
		
		JButton btnReturnDisk = new JButton("Trả đĩa");
		btnReturnDisk.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReturnDisk.setBounds(800, 321, 150, 30);
		add(btnReturnDisk);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancel.setBounds(800, 373, 150, 30);
		add(btnCancel);
		
		chkPayment = new JCheckBox("Thanh toán");
		chkPayment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkPayment.setBounds(800, 221, 100, 25);
		add(chkPayment);
		
		JLabel lblLateFee = new JLabel("Tổng phí trễ");
		lblLateFee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLateFee.setBounds(800, 254, 90, 25);
		add(lblLateFee);
		
		tfLateFee = new JTextField();
		tfLateFee.setHorizontalAlignment(SwingConstants.RIGHT);
		tfLateFee.setForeground(Color.RED);
		tfLateFee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfLateFee.setEditable(false);
		tfLateFee.setBackground(Color.WHITE);
		tfLateFee.setBounds(880, 254, 164, 25);
		add(tfLateFee);
		tfLateFee.setColumns(10);
		
		btnAddDisk.addActionListener(e ->{
			try {
				int diskID = Integer.parseInt(tfDiskID.getText().toString());
				RentalRecord record = rentalDAO.getByDiskID(diskID);
				if (record != null) {
					if (!checkExistOnTable(tblTraDia, diskID)) {
						int i = tblTraDia.getRowCount();
						String traTre = "";
						String phiTre = "";
						
						if (rentalDAO.checkLateReturn(record)) {
							traTre = "x";
							phiTre = rentalDAO.calculateLateFee(record)+"";
						}
						String[] rowData = {i+1+"", record.getDisk().getId()+"", record.getCustomer().getId()+"", record.getDisk().getTitle().getName(),
								FormatString.formatDate(record.getRentDate()), FormatString.formatDate(record.getDueDate())
								, traTre, phiTre};
						modelTraDia.addRow(rowData);
						tblTraDia.setModel(modelTraDia);
					}else {
						JOptionPane.showMessageDialog(null, "Đĩa này đã thêm rồi!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy đĩa này!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Mã đĩa không hợp lệ!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		chkPayment.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					isChecked = true;
					tfLateFee.setText(FormatString.formatTienVN(totalLateFee(tblTraDia))+" đ");
				}else {
					tfLateFee.setText("");
				}
			}
		});
		
		btnReturnDisk.addActionListener(e ->{
			int rowCount = tblTraDia.getRowCount();
			int diskID;
			RentalRecord record;
			Disk disk;
			
			if (rowCount == 0) {
				JOptionPane.showMessageDialog(null, "Chưa nhập đĩa để trả!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}else {
				for (int i = 0; i < rowCount; i++) {
					diskID = Integer.parseInt(tblTraDia.getValueAt(i, 1).toString());
					record = rentalDAO.getByDiskID(diskID);
					disk = diskDAO.getDiskByID(diskID);
					
					record.setReturnDate(new Date());
					
					if (rentalDAO.checkLateReturn(record)) {
						record.setLateFee(rentalDAO.calculateLateFee(record));
						if (isChecked) {
							record.setPaid(true);
						}else {
							record.setPaid(false);
						}
					}else {
						record.setPaid(true);
					}
					disk.setStatus("onShelf");
					
					rentalDAO.update(record);
					diskDAO.update(disk);
				}
				JOptionPane.showMessageDialog(null, "Trả đĩa thành công!!", "", JOptionPane.INFORMATION_MESSAGE);
				clearAll();
			}
		});
		
		btnCancel.addActionListener(e ->{
			if (JOptionPane.showConfirmDialog(this, "Hủy trả đĩa?", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				clearAll();
			}
		});
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
	
	private void clearAll() {
		while(modelTraDia.getRowCount()>0) {
			modelTraDia.removeRow(0);
		}
		tfDiskID.setText("");
		chkPayment.setSelected(false);
		tfLateFee.setText("");
	}
	
	private double totalLateFee(JTable table) {
		int rowCount = table.getRowCount();
		double total = 0;
		for (int i = 0; i < rowCount; i++) {
			if (table.getValueAt(i, 6).toString().equals("x")) {
				total += Double.parseDouble(table.getValueAt(i, 7)+"");
			}
	    }
		return total;
	}
}