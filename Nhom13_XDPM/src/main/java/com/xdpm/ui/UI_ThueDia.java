package com.xdpm.ui;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class UI_ThueDia extends JPanel{
	private JTextField tfCusID;
	private JTextField tfCusName;
	private JTextField tfAddress;
	private JTextField tfPhoneNumber;
	private JTextField tfDiskID;
	private JTable tblCart;
	private Vector<?> title;
	private DefaultTableModel modelCart;
	private DefaultTableModel modelDisk;
	private JTable tblDisk;
	private JTextField tfTienNoPhi;
	private JTextField tfTienThue;
	private JTextField tfNoPhi;
	private JTextField tfTongTien;
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
		tfCusName.setBounds(121, 70, 213, 25);
		pnlKhachHang.add(tfCusName);
		tfCusName.setColumns(40);
		
		JLabel lblAddress = new JLabel("Địa chỉ");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setBounds(10, 115, 100, 25);
		pnlKhachHang.add(lblAddress);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(121, 115, 213, 25);
		pnlKhachHang.add(tfAddress);
		tfAddress.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Số điện thoại");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(10, 160, 84, 25);
		pnlKhachHang.add(lblPhoneNumber);
		
		tfPhoneNumber = new JTextField();
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
		tfTienNoPhi.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTienNoPhi.setBackground(Color.WHITE);
		tfTienNoPhi.setBounds(121, 205, 213, 25);
		pnlKhachHang.add(tfTienNoPhi);
		tfTienNoPhi.setColumns(10);
		
		JButton btnTTTreHan = new JButton("Thanh toán trễ hạn");
		btnTTTreHan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTTTreHan.setBounds(121, 240, 150, 25);
		pnlKhachHang.add(btnTTTreHan);
		
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
		pnlDiaTreHan.setBorder(new TitledBorder(null, "Đĩa đang trễ hạn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDiaTreHan.setBounds(10, 297, 698, 193);
		add(pnlDiaTreHan);
		pnlDiaTreHan.setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 20, 678, 163);
		pnlDiaTreHan.add(scrollPane2);

		String[] title2 = { "STT", "Mã đĩa", "Tựa đề", "Hạn trả", "Phí trễ"};
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
		
		tfNoPhi = new JTextField();
		tfNoPhi.setBackground(Color.WHITE);
		tfNoPhi.setEditable(false);
		tfNoPhi.setBounds(121, 70, 213, 25);
		pnlThanhToan.add(tfNoPhi);
		tfNoPhi.setColumns(10);
		
		tfTongTien = new JTextField();
		tfTongTien.setEditable(false);
		tfTongTien.setBackground(Color.WHITE);
		tfTongTien.setBounds(121, 115, 213, 25);
		pnlThanhToan.add(tfTongTien);
		tfTongTien.setColumns(10);
		
		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBounds(60, 155, 100, 25);
		pnlThanhToan.add(btnThanhToan);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(200, 155, 100, 25);
		pnlThanhToan.add(btnHuy);
	}
}
