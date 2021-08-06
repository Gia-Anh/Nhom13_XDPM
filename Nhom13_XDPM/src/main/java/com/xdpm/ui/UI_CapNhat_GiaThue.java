package com.xdpm.ui;

import java.awt.BorderLayout;
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

public class UI_CapNhat_GiaThue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6651440241729494153L;
	private JPanel contentPane;
	private DefaultComboBoxModel<Category> model;
	private JComboBox<Category> cboLoaiTieuDe;
	private CategoryDAO CategoryDAO;
	private JTextField txtPhiTraTre;
	private JTextField txtGiaThue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_CapNhat_GiaThue frame = new UI_CapNhat_GiaThue();
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
	public UI_CapNhat_GiaThue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		CategoryDAO = new CategoryDAO();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Đặt giá thuê");

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setSize(450, 370);
		getContentPane().setLayout(null);

		JLabel lbltGiThu = new JLabel("ĐẶT GIÁ THUÊ");
		lbltGiThu.setHorizontalAlignment(SwingConstants.CENTER);
		lbltGiThu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbltGiThu.setBounds(0, 30, 440, 36);
		getContentPane().add(lbltGiThu);

		JLabel lblLoiTiu = new JLabel("Thể loại");
		lblLoiTiu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLoiTiu.setBounds(27, 96, 105, 30);
		getContentPane().add(lblLoiTiu);

		model = new DefaultComboBoxModel<Category>();
		cboLoaiTieuDe = new JComboBox<Category>(model);
		cboLoaiTieuDe.setBounds(139, 96, 245, 30);

		getContentPane().add(cboLoaiTieuDe);

		JLabel lblGiThu = new JLabel("Giá thuê");
		lblGiThu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGiThu.setBounds(27, 156, 105, 30);
		getContentPane().add(lblGiThu);

		JLabel lblLoiTiu_1_1 = new JLabel("Phí trả trễ");
		lblLoiTiu_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLoiTiu_1_1.setBounds(27, 216, 105, 30);
		getContentPane().add(lblLoiTiu_1_1);

		txtGiaThue = new JTextField();
		txtGiaThue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGiaThue.setColumns(10);
		txtGiaThue.setBackground(Color.WHITE);
		txtGiaThue.setBounds(140, 156, 244, 30);
		getContentPane().add(txtGiaThue);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(140, 276, 98, 26);
		getContentPane().add(btnCapNhat);

		txtPhiTraTre = new JTextField();
		txtPhiTraTre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhiTraTre.setColumns(10);
		txtPhiTraTre.setBackground(Color.WHITE);
		txtPhiTraTre.setBounds(139, 216, 244, 30);
		getContentPane().add(txtPhiTraTre);

		/**
		 * Bắt sự kiện chưa làm
		 */

//		cboLoaiTieuDe.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				selectItemComboBox();
//			}
//		});
//		btnCapNhat.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String strGaiaThue= txtGiaThue.getText();
//				String strPhiTre= txtPhiTraTre.getText();
//				if(strGaiaThue.length()==0 || strGaiaThue ==null) {
//					txtGiaThue.requestFocus();
//					JOptionPane.showMessageDialog(DatGiaThueUI.this, "Giá thuê không được để rỗng.");
//					return;
//				}else if(strPhiTre.length()==0 || strPhiTre ==null) {
//					txtPhiTraTre.requestFocus();
//					JOptionPane.showMessageDialog(DatGiaThueUI.this, "Phí trả trễ không được để rỗng.");
//					return;
//				}
//				try {
//					double giaThue = Double.parseDouble(strGaiaThue);
//					double phiTre = Double.parseDouble(strPhiTre);
//					LoaiTieuDe loaiTieuDe = (LoaiTieuDe) model.getSelectedItem();
//					loaiTieuDe.setGiaThue(giaThue);
//					loaiTieuDe.setPhiTreHan(phiTre);
//					if(loaiTieuDeDAO.update(loaiTieuDe)!=null) {
//						JOptionPane.showMessageDialog(DatGiaThueUI.this, "Thành công.");						
//					}else
//						JOptionPane.showMessageDialog(DatGiaThueUI.this, "Thất bại.");
//				} catch (NumberFormatException ex) {
//					JOptionPane.showMessageDialog(DatGiaThueUI.this, "Chỉ chấp nhận số.");
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

//	private void selectItemComboBox() {
//		LoaiTieuDe loaiTieuDe = (LoaiTieuDe) model.getSelectedItem();
//		if(loaiTieuDe!=null) {
//			txtGiaThue.setText(String.format("%.0f", loaiTieuDe.getGiaThue()));
//			txtPhiTraTre.setText(String.format("%.0f",loaiTieuDe.getPhiTreHan()));
//		}
//	}
//	}

}
