package com.xdpm.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.xdpm.dao.CategoryDAO;
import com.xdpm.entity.Category;

public class UI_CapNhat_NgayThue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6651440241729494153L;
	private JPanel contentPane;
	private DefaultComboBoxModel<Category> model;
	private JComboBox<Category> cboLoaiTieuDe;
	private CategoryDAO CategoryDAO;
	private JTextField txtNgayThueToiDa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_CapNhat_NgayThue frame = new UI_CapNhat_NgayThue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_CapNhat_NgayThue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		JLabel lbltGiThu = new JLabel("ĐẶT NGÀY THUÊ TỐI ĐA");
		lbltGiThu.setHorizontalAlignment(SwingConstants.CENTER);
		lbltGiThu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbltGiThu.setBounds(84, 46, 292, 29);
		getContentPane().add(lbltGiThu);

		JLabel lblLoiTiu = new JLabel("Loại tiêu đề");
		lblLoiTiu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoiTiu.setBounds(27, 112, 112, 16);
		getContentPane().add(lblLoiTiu);

		model = new DefaultComboBoxModel<Category>();
		cboLoaiTieuDe = new JComboBox<Category>(model);
		cboLoaiTieuDe.setBounds(179, 111, 167, 25);
		getContentPane().add(cboLoaiTieuDe);

		JLabel lblGiThu = new JLabel("Số ngày tối đa");
		lblGiThu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiThu.setBounds(28, 156, 127, 25);
		getContentPane().add(lblGiThu);

		txtNgayThueToiDa = new JTextField();
		txtNgayThueToiDa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgayThueToiDa.setColumns(10);
		txtNgayThueToiDa.setBackground(Color.WHITE);
		txtNgayThueToiDa.setBounds(179, 152, 167, 25);
		getContentPane().add(txtNgayThueToiDa);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(207, 206, 100, 29);
		getContentPane().add(btnCapNhat);
		/**
		 * Xử lý sự kiện
		 */
//		cboLoaiTieuDe.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				selectItemComboBox();
//			}
//		});
//		btnCapNhat.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String strNgayThue = txtNgayThueToiDa.getText();
//
//				if (strNgayThue.length() == 0 || strNgayThue == null) {
//					txtNgayThueToiDa.requestFocus();
//					JOptionPane.showMessageDialog(DatNgayThueToiDaUI.this, "Giá thuê không được để rỗng.");
//					return;
//				}
//				try {
//					int ngayThue = Integer.parseInt(strNgayThue);
//					LoaiTieuDe loaiTieuDe = (LoaiTieuDe) model.getSelectedItem();
//					loaiTieuDe.setSoNgayThueToiDa(ngayThue);
//					if (loaiTieuDeDAO.update(loaiTieuDe) != null) {
//						JOptionPane.showMessageDialog(DatNgayThueToiDaUI.this, "Thành công.");
//					} else
//						JOptionPane.showMessageDialog(DatNgayThueToiDaUI.this, "Thất bại.");
//				} catch (NumberFormatException ex) {
//					JOptionPane.showMessageDialog(DatNgayThueToiDaUI.this, "Chỉ chấp nhận số.");
//				}
//			}
//		});
//		loadDanhSachLoaiTieuDe();
//		selectItemComboBox();
	}

//	private void loadDanhSachLoaiTieuDe() {
//		for (LoaiTieuDe loaiTieuDe : loaiTieuDeDAO.layTatCaLoaiTieuDe()) {
//			cboLoaiTieuDe.addItem(loaiTieuDe);
//		}
//	}
//
//	private void selectItemComboBox() {
//		LoaiTieuDe loaiTieuDe = (LoaiTieuDe) model.getSelectedItem();
//		if(loaiTieuDe!=null) {
//			txtNgayThueToiDa.setText(loaiTieuDe.getSoNgayThueToiDa()+"");
//		}
//	}

}
