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

public class FrmManage_Title extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4440702554365484612L;
	private JTextField txtId;
	private JTextField txtLoc;
	private JTable table;
	private JTextField txtName;
	private JTextField txtNumberOfCopies;
	private JTextField txtCategory;
	private JComboBox<String> cbbLoc;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FrmManage_Title() {
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
				new String[] { "Mã tựa đề", "Tên tựa đề", "Số lượng bản sao chép", "Thể loại" });
		table.setModel(dfTable);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setPreferredWidth(340);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		/**
		 * Set combobox
		 */
		cbbLoc = new JComboBox();
		cbbLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbLoc.setModel(new DefaultComboBoxModel(new String[] {"Lọc theo tên", "Lọc theo thể loại"}));
		cbbLoc.setBounds(230, 32, 142, 22);
		panel.add(cbbLoc);

		JLabel lblNewLabel = new JLabel("Mã tựa đề:");
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
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(846, 361, 92, 31);
		panel.add(btnAdd);

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtName.setColumns(10);
		txtName.setBounds(846, 178, 210, 22);
		panel.add(txtName);

		JLabel lblHTn = new JLabel("Tên tựa đề:");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHTn.setBounds(846, 147, 102, 25);
		panel.add(lblHTn);

		txtNumberOfCopies = new JTextField();
		txtNumberOfCopies.setEditable(false);
		txtNumberOfCopies.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumberOfCopies.setColumns(10);
		txtNumberOfCopies.setBounds(846, 241, 210, 22);
		panel.add(txtNumberOfCopies);

		JLabel lblSoBan = new JLabel("Số lượng bản sao chép:");
		lblSoBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSoBan.setBounds(846, 210, 142, 25);
		panel.add(lblSoBan);

		txtCategory = new JTextField();
		txtCategory.setEditable(false);
		txtCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCategory.setColumns(10);
		txtCategory.setBounds(846, 304, 210, 22);
		panel.add(txtCategory);

		JLabel lblSinThoi = new JLabel("Thể loại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSinThoi.setBounds(846, 273, 102, 25);
		panel.add(lblSinThoi);

		JButton btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(964, 361, 92, 31);
		panel.add(btnDelete);

		JButton btnEdit = new JButton("Sửa");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.setBounds(846, 402, 92, 31);
		panel.add(btnEdit);

		JButton btnSave = new JButton("Lưu");
		btnSave.setEnabled(false);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setBounds(846, 443, 92, 31);
		panel.add(btnSave);

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(964, 402, 92, 31);
		panel.add(btnSearch);

	}
}
