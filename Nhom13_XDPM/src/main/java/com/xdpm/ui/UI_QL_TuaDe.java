package com.xdpm.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.xdpm.dao.CategoryDAO;
import com.xdpm.dao.TitleDAO;
import com.xdpm.entity.Category;
import com.xdpm.entity.Title;
import javax.swing.ComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_QL_TuaDe extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4440702554365484612L;
	private JTextField txtId;
	private JTextField txtLoc;
	private JTable table;
	private JTextField txtName;
	private JTextField txtNumberOfCopies;
	private JComboBox cboLoaiTieuDe;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnSearch;
	private TitleDAO titelDao;
	private DefaultTableModel dfTable;
	private Category category;
	private CategoryDAO categoryDao;
	private DefaultComboBoxModel<Category> model;
	private DefaultComboBoxModel<Category> model2;
	private List<Title> listTitle;
	private List<Category> listCategories;
	private JButton btnAdd;
	private Category listCategoriesByTrend;
	private List<Title> listTitleByTrend;
	private JComboBox cboLoaiTieuDeChoThem;
	private JButton btnTaiLai;

	/**
	 * Create the panel.
	 */
	public UI_QL_TuaDe() {
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
		table = new JTable(){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		dfTable = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M?? t???a ?????", "T??n t???a ?????", "Th??? lo???i", "S??? l?????ng b???n sao ch??p" });
		table.setModel(dfTable);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(340);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(180);
		/**
		 * Set combobox
		 */
		model = new DefaultComboBoxModel<Category>();
		cboLoaiTieuDe = new JComboBox<Category>(model);
		cboLoaiTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboLoaiTieuDe.setBounds(114, 33, 74, 22);
		panel.add(cboLoaiTieuDe);

		model2 = new DefaultComboBoxModel<Category>();
		cboLoaiTieuDeChoThem = new JComboBox<Category>(model2);
		cboLoaiTieuDeChoThem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboLoaiTieuDeChoThem.setBounds(846, 308, 74, 22);
		panel.add(cboLoaiTieuDeChoThem);

		JLabel lblNewLabel = new JLabel("M?? t???a ?????:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(846, 84, 102, 25);
		panel.add(lblNewLabel);

		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtId.setBounds(846, 115, 210, 22);
		panel.add(txtId);
		txtId.setColumns(10);

		txtLoc = new JTextField();
		txtLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLoc.setColumns(10);
		txtLoc.setBounds(21, 32, 199, 22);
//		panel.add(txtLoc);
		btnAdd = new JButton("Th??m");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(846, 361, 92, 31);
		panel.add(btnAdd);

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtName.setColumns(10);
		txtName.setBounds(846, 178, 210, 22);
		panel.add(txtName);

		JLabel lblHTn = new JLabel("T??n t???a ?????:");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHTn.setBounds(846, 147, 102, 25);
		panel.add(lblHTn);

		txtNumberOfCopies = new JTextField();
		txtNumberOfCopies.setEditable(false);
		txtNumberOfCopies.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumberOfCopies.setColumns(10);
		txtNumberOfCopies.setBounds(846, 241, 210, 22);
		panel.add(txtNumberOfCopies);

		JLabel lblSoBan = new JLabel("S??? l?????ng b???n cho thu??:");
		lblSoBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSoBan.setBounds(846, 210, 142, 25);
		panel.add(lblSoBan);

		JLabel lblSinThoi = new JLabel("Th??? lo???i:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSinThoi.setBounds(846, 273, 102, 25);
		panel.add(lblSinThoi);

		btnDelete = new JButton("X??a");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(964, 361, 92, 31);
		panel.add(btnDelete);

		btnSave = new JButton("L??u");
		btnSave.setEnabled(false);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setBounds(846, 402, 92, 31);
		panel.add(btnSave);

		btnSearch = new JButton("T??m ki???m");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(731, 29, 92, 31);
		panel.add(btnSearch);

		JLabel lblNewLabel_1 = new JLabel("Danh s??ch");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 33, 81, 22);
		panel.add(lblNewLabel_1);

		btnTaiLai = new JButton("T???i l???i");
		btnTaiLai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTaiLai.setBounds(638, 29, 92, 31);
		panel.add(btnTaiLai);
		
		tableDesign(table);
		tableRenderer();

		/**
		 * Xu ly
		 */
		titelDao = new TitleDAO();
		categoryDao = new CategoryDAO();
		listTitle = titelDao.getAllTitles();
		listCategories = categoryDao.getAllCategory();
		loadListTitle(listTitle);
		loadComboBox();
		loadComboBoxThem();
		/**
		 * Bat su kien nek
		 */
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listTitle = titelDao.getAllTitles();
				loadListTitle(listTitle);
				cboLoaiTieuDe.setSelectedIndex(0);
			}
		});
		cboLoaiTieuDe.addActionListener(e -> {
			if (cboLoaiTieuDe.getSelectedIndex() > 0) {
				String name = cboLoaiTieuDe.getSelectedItem().toString();
				Category category = categoryDao.getCategoryByName(name);
				listTitleByTrend = titelDao.getAllTitleByCategoryID(category.getId());
				loadListTitle(listTitleByTrend);
			} else
				loadListTitle(listTitle);
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtId.setText((String) table.getValueAt(table.getSelectedRow(), 1));
				txtName.setText((String) table.getValueAt(table.getSelectedRow(), 2));
				txtNumberOfCopies.setText((String) table.getValueAt(table.getSelectedRow(), 4));
				String categoryName = (String) table.getValueAt(table.getSelectedRow(), 3);
				for (int i = 0; i < cboLoaiTieuDeChoThem.getItemCount(); i++) {
					String name = cboLoaiTieuDeChoThem.getItemAt(i).toString();

					if (categoryName.equalsIgnoreCase(name)) {
						cboLoaiTieuDeChoThem.setSelectedIndex(i);
					}

				}
			}
		});
		btnAdd.addActionListener(e -> {
			clear();
			txtName.setEditable(true);
			txtNumberOfCopies.setText("0");
			txtId.setEditable(false);
			openButton(true);
		});
		btnSave.addActionListener(e -> {
			Category category = categoryDao.getCategoryByName(cboLoaiTieuDeChoThem.getSelectedItem().toString());
			Title title = new Title(txtName.getText(), Integer.parseInt(txtNumberOfCopies.getText()),
					new Category(category.getId()));
			if (titelDao.add(title) != null) {
				JOptionPane.showMessageDialog(this, "???? th??m", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon("image/ok.png"));
			} else
				JOptionPane.showMessageDialog(this, "Th??m kh??ng th??nh c??ng", "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
			clear();
			txtName.setEditable(false);
			txtId.setEditable(true);
			openButton(false);
			listTitle = titelDao.getAllTitles();
			loadListTitle(listTitle);

		});
		btnDelete.addActionListener(e -> {
			String tua = txtId.getText();
			if (tua.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "id r???ng", "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (titelDao.getTitleByID(Integer.parseInt(tua)) == null) {
				JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y!", "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
				return;
			}
			int a = titelDao.countOfmaxDisk(Integer.parseInt(tua)).size();
			int b = titelDao.countOfonShelf(Integer.parseInt(tua)).size();

			if (a != b) {
				JOptionPane.showMessageDialog(this, "C?? kh??ch h??ng ??ang thu??, kh??ng x??a ???????c", "Th??ng b??o",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (txtId.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "M?? t???a ????a ??ang r???ng!", "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				String id = txtId.getText();
				int result = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c mu???n x??a kh??ch h??ng m??: '" + id + "' ",
						"X??c nh???n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					titelDao.deleteTitle(Integer.parseInt(id));
					listTitle = titelDao.getAllTitles();
					loadListTitle(listTitle);
					clear();
				} else
					return;
			}
		});
		btnSearch.addActionListener(e -> {
			JFrame frame = new UI_TimKiemTuaDe();
			frame.setVisible(true);
		});
	}

	@SuppressWarnings("unchecked")
	private void loadComboBox() {

		this.cboLoaiTieuDe.addItem("----");
		for (int i = 0; i < listCategories.size(); i++)
			this.cboLoaiTieuDe.addItem(listCategories.get(i).getName());
	}

	@SuppressWarnings("unchecked")
	private void loadComboBoxThem() {
		for (int i = 0; i < listCategories.size(); i++)
			this.cboLoaiTieuDeChoThem.addItem(listCategories.get(i).getName());
	}

	public void openButton(boolean hope) {
		if (hope) {
			btnAdd.setEnabled(false);
			btnSave.setEnabled(true);
			btnDelete.setEnabled(false);
		} else {
			btnAdd.setEnabled(true);
			btnSave.setEnabled(false);
			btnDelete.setEnabled(true);
		}
	}

	private void loadListTitle(List<Title> ds) {
		dfTable.getDataVector().removeAllElements();
		for (int i = 0; i < ds.size(); i++) {
			category = categoryDao.getCategoryByID(ds.get(i).getCategory().getId());
			Vector<String> vt = new Vector<String>();
			vt.addElement(String.valueOf(i + 1));
			vt.addElement(String.valueOf(ds.get(i).getId()));
			vt.addElement(String.valueOf(ds.get(i).getName()));
			vt.addElement(String.valueOf(category.getName()));
			vt.addElement(String.valueOf(ds.get(i).getNumberOfCopies()));
			dfTable.addRow(vt);
		}

	}

	public void clear() {
		cboLoaiTieuDeChoThem.setSelectedIndex(0);
		cboLoaiTieuDe.setSelectedIndex(0);
		txtId.setText("");
		txtName.setText("");
		txtNumberOfCopies.setText("");
	}
	
	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(25);
		tb.setFont(new Font("Segoe UI", Font.PLAIN, 13));
	}
	
	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();
		
		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		
		table.getColumn("STT").setCellRenderer(centerCellRenderer);
		table.getColumn("M?? t???a ?????").setCellRenderer(centerCellRenderer);
		table.getColumn("Th??? lo???i").setCellRenderer(centerCellRenderer);
		table.getColumn("S??? l?????ng b???n sao ch??p").setCellRenderer(centerCellRenderer);
	}
	
}
