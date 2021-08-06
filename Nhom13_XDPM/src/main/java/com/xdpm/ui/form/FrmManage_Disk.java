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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class FrmManage_Disk extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4440702554365484612L;
	private JTextField txtId;
	private JTextField txtLoc;
	private JTable table;
	private JTextField txtName;
	private JTextField txtTitleName;
	private JComboBox<String> cbbLoc;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FrmManage_Disk() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1066, 500);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 62, 671, 416);
		panel.add(scrollPane);
		/**
		 * Set table
		 */
		table = new JTable();
		DefaultTableModel dfTable = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã đĩa", "Tên tựa đề", "Trạng thái" });
		table.setModel(dfTable);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		table.getColumnModel().getColumn(2).setPreferredWidth(170);
		/**
		 * Set combobox
		 */
		cbbLoc = new JComboBox();
		cbbLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbLoc.setModel(new DefaultComboBoxModel(new String[] {"Lọc theo mã tựa đề", "Lọc theo tên tựa đề", "Lọc theo trạng thái \"On hold\"", "Lọc theo trạng thái \"On Shelft\""}));
		cbbLoc.setBounds(230, 32, 216, 22);
		panel.add(cbbLoc);

		JLabel lblNewLabel = new JLabel("Mã đĩa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(716, 136, 102, 25);
		panel.add(lblNewLabel);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtId.setBounds(828, 138, 210, 22);
		panel.add(txtId);
		txtId.setColumns(10);

		txtLoc = new JTextField();
		txtLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLoc.setColumns(10);
		txtLoc.setBounds(21, 32, 199, 22);
		panel.add(txtLoc);

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setEnabled(false);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtName.setColumns(10);
		txtName.setBounds(828, 170, 210, 22);
		panel.add(txtName);

		JLabel txtStatus = new JLabel("Trạng thái:");
		txtStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtStatus.setBounds(716, 171, 102, 25);
		panel.add(txtStatus);

		txtTitleName = new JTextField();
		txtTitleName.setEditable(false);
		txtTitleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTitleName.setColumns(10);
		txtTitleName.setBounds(828, 103, 210, 22);
		panel.add(txtTitleName);

		JLabel lblTuaDe = new JLabel("Tựa đề:");
		lblTuaDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTuaDe.setBounds(716, 101, 102, 25);
		panel.add(lblTuaDe);

		JButton btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(946, 228, 92, 31);
		panel.add(btnDelete);

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(946, 275, 92, 31);
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00EAm \u0111\u0129a m\u1EDBi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(709, 334, 347, 143);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
				JButton btnSave = new JButton("Lưu");
				btnSave.setBounds(245, 102, 92, 31);
				panel_1.add(btnSave);
				btnSave.setEnabled(false);
				btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel lblMTa = new JLabel("Mã tựa đề:");
				lblMTa.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblMTa.setBounds(22, 36, 80, 25);
				panel_1.add(lblMTa);
				
				textField = new JTextField();
				textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField.setColumns(10);
				textField.setBounds(112, 70, 215, 22);
				panel_1.add(textField);
				
				textField_1 = new JTextField();
				textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField_1.setColumns(10);
				textField_1.setBounds(112, 38, 122, 22);
				panel_1.add(textField_1);
				
				JLabel lblTnTa = new JLabel("Tên tựa đề:");
				lblTnTa.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblTnTa.setBounds(22, 71, 80, 25);
				panel_1.add(lblTnTa);
				
				JButton btnTm = new JButton("Tìm");
				btnTm.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnTm.setBounds(245, 38, 80, 22);
				panel_1.add(btnTm);
				JButton btnAdd = new JButton("Thêm");
				btnAdd.setBounds(828, 275, 92, 31);
				panel.add(btnAdd);
				btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton btnXaRng = new JButton("Xóa rống:");
				btnXaRng.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnXaRng.setBounds(828, 228, 92, 31);
				panel.add(btnXaRng);

	}
}
