package com.xdpm.ui.form;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class FrmManage_Customer extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4440702554365484612L;
	private JTextField txtId;
	private JTextField txtLoc;
	private JTable table;
	private JTextField txtHoTen;
	private JTextField textField_2;
	private JTextField txtSdt;
	private JComboBox<String> cbbLoc;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FrmManage_Customer() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1066, 500);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 62, 803, 416);
		panel.add(scrollPane);
		/**
		 * Set table
		 */
		table = new JTable();
		DefaultTableModel dfTable = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã khách hàng", "Họ tên khách hàng", "Địa chỉ", "Số điện thoại" });
		table.setModel(dfTable);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		/**
		 * Set combobox
		 */
		cbbLoc = new JComboBox();
		cbbLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbLoc.setModel(new DefaultComboBoxModel(new String[] { "Lọc theo tên", "Lọc theo địa chỉ" }));
		cbbLoc.setBounds(230, 32, 142, 22);
		panel.add(cbbLoc);

		JLabel lblNewLabel = new JLabel("Mã khách hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(846, 84, 102, 25);
		panel.add(lblNewLabel);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtId.setBounds(846, 115, 210, 22);
		panel.add(txtId);
		txtId.setColumns(10);

		txtLoc = new JTextField();
		txtLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLoc.setColumns(10);
		txtLoc.setBounds(21, 32, 199, 22);
		panel.add(txtLoc);
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThem.setBounds(846, 361, 92, 31);
		panel.add(btnThem);

		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(846, 178, 210, 22);
		panel.add(txtHoTen);

		JLabel lblHTn = new JLabel("Họ tên:");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHTn.setBounds(846, 147, 102, 25);
		panel.add(lblHTn);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(846, 241, 210, 22);
		panel.add(textField_2);

		JLabel txtDiaChi = new JLabel("Địa chỉ:");
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiaChi.setBounds(846, 210, 102, 25);
		panel.add(txtDiaChi);

		txtSdt = new JTextField();
		txtSdt.setEditable(false);
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSdt.setColumns(10);
		txtSdt.setBounds(846, 304, 210, 22);
		panel.add(txtSdt);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSinThoi.setBounds(846, 273, 102, 25);
		panel.add(lblSinThoi);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(964, 361, 92, 31);
		panel.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSua.setBounds(846, 402, 92, 31);
		panel.add(btnSua);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBounds(846, 443, 92, 31);
		panel.add(btnLuu);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimKiem.setBounds(964, 402, 92, 31);
		panel.add(btnTimKiem);

	}
}
