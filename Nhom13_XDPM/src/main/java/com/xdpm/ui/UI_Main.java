package com.xdpm.ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JTabbedPane;

public class UI_Main extends JFrame{
	
	private JMenuBar menuBar;
	private JMenu mnThueDia;
	private JMenu mnDatTruoc;
	private JMenu mnTraTre;
	private JMenu mnQuanLy;
	private JMenu mnBaoCao;
	private JMenu mnKhac;
	private JMenuItem jmiThueDia;
	private JMenuItem jmiTraDia;
	private JMenuItem jmiKTTTDia;
	private JMenuItem jmiThemDatTruoc;
	private JMenuItem jmiHuyDatTruoc;
	private JMenuItem jmiThanhToan;
	private JMenuItem jmiQLTuaDe;
	private JMenuItem jmiQLKhachHang;
	private JMenuItem jmiBCKhachHang;
	private JMenuItem jmiBCTuaDe;
	private JMenuItem jmiCapNhatGiaThue;
	private JMenuItem jmiCapNhatNgayThue;
	private JMenuItem jmiQLDia;
	private JButton btnDangNhap;
	private UI_ThueDia pnlThueDia;
	private UI_TraDia pnlTraDia;

	public UI_Main() {
		Font font = new Font("Tahoma", Font.PLAIN,16);
		Font font2 = new Font("Tahoma", Font.PLAIN,14);
		
		setTitle("Quản lý thuê đĩa");
		setSize(1100, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        ImageIcon mainIcon = new ImageIcon("image/disk.png");
		setIconImage(mainIcon.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnThueDia = new JMenu("Thuê - Trả đĩa");
		mnThueDia.setFont(font);
		menuBar.add(mnThueDia);
		
		mnDatTruoc = new JMenu("Đặt trước");
		mnDatTruoc.setFont(font);
		menuBar.add(mnDatTruoc);
		
		mnTraTre = new JMenu("Trả trễ");
		mnTraTre.setFont(font);
		menuBar.add(mnTraTre);
		
		mnQuanLy = new JMenu("Quản lý");
		mnQuanLy.setFont(font);
		menuBar.add(mnQuanLy);
		
		//==========================================================
		jmiThueDia = new JMenuItem("Thuê đĩa", new ImageIcon("image/disk.png"));
		jmiThueDia.setFont(font2);
		mnThueDia.add(jmiThueDia);
		
		jmiTraDia = new JMenuItem("Trả đĩa", new ImageIcon("image/disk.png"));
		jmiTraDia.setFont(font2);
		mnThueDia.add(jmiTraDia);
		
		jmiKTTTDia = new JMenuItem("Kiểm tra trạng thái đĩa", new ImageIcon("image/disk.png"));
		jmiKTTTDia.setFont(font2);
		mnThueDia.add(jmiKTTTDia);
		
		jmiThemDatTruoc = new JMenuItem("Thêm đặt trước", new ImageIcon("image/disk.png"));
		jmiThemDatTruoc.setFont(font2);
		mnDatTruoc.add(jmiThemDatTruoc);
		
		jmiHuyDatTruoc = new JMenuItem("Hủy đặt trước", new ImageIcon("image/disk.png"));
		jmiHuyDatTruoc.setFont(font2);
		mnDatTruoc.add(jmiHuyDatTruoc);
		
		jmiThanhToan = new JMenuItem("Thanh toán phí trễ", new ImageIcon("image/disk.png"));
		jmiThanhToan.setFont(font2);
		mnTraTre.add(jmiThanhToan);
		
		jmiQLTuaDe = new JMenuItem("Quản lý tựa đề", new ImageIcon("image/disk.png"));
		jmiQLTuaDe.setFont(font2);
		mnQuanLy.add(jmiQLTuaDe);
		
		
		
		jmiQLKhachHang = new JMenuItem("Quản lý khách hàng", new ImageIcon("image/disk.png"));
		jmiQLKhachHang.setFont(font2);
		mnQuanLy.add(jmiQLKhachHang);

		
		//==========================================================
		mnThueDia.setPreferredSize(new Dimension(165, 40));
		mnDatTruoc.setPreferredSize(new Dimension(165, 40));
		mnTraTre.setPreferredSize(new Dimension(165, 40));
		mnQuanLy.setPreferredSize(new Dimension(165, 40));
		
		//==========================================================
		mnThueDia.setIcon(new ImageIcon("image/disk.png"));
		mnDatTruoc.setIcon(new ImageIcon("image/disk.png"));
		mnTraTre.setIcon(new ImageIcon("image/disk.png"));
		mnQuanLy.setIcon(new ImageIcon("image/disk.png"));
		getContentPane().setLayout(null);
		
		JPanel pnlDangNhap = new JPanel();
		pnlDangNhap.setBackground(Color.WHITE);
		pnlDangNhap.setBounds(10, 561, 1066, 50);
		getContentPane().add(pnlDangNhap);
		pnlDangNhap.setLayout(null);
		
		btnDangNhap = new JButton("Đăng nhập quản lý");
		btnDangNhap.setBounds(896, 10, 142, 30);
		pnlDangNhap.add(btnDangNhap);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 1066, 541);
		tabbedPane.setFont(font);
		getContentPane().add(tabbedPane);
		
		pnlThueDia = new UI_ThueDia();
		
		//==========================================================
		btnDangNhap.addActionListener(e ->{
			if (btnDangNhap.getText().equals("Đăng nhập quản lý")) {
				UI_Login loginUI = new UI_Login(this, true);
				loginUI.setVisible(true);
			}else {
				changeUI(false);
				repaint();
				validate();
			}
			
		});
		
		//==========================================================
		jmiThueDia.addActionListener(e ->{
			tabbedPane.removeAll();
			tabbedPane.addTab("Thuê đĩa", new ImageIcon("image/disk.png"), pnlThueDia, "Thuê đĩa");
		});
		
		jmiTraDia.addActionListener(e ->{
			tabbedPane.removeAll();
			tabbedPane.addTab("Trả đĩa", new ImageIcon("image/disk.png"), pnlTraDia, "Trả đĩa");
		});
	}
	
	public void changeUI(boolean isManager) {
		Font font = new Font("Tahoma", Font.PLAIN,16);
		Font font2 = new Font("Tahoma", Font.PLAIN,14);
		if (isManager) {
			mnBaoCao = new JMenu("Báo cáo");
			mnBaoCao.setFont(font);
			menuBar.add(mnBaoCao);
			
			mnKhac = new JMenu("Khác");
			mnKhac.setFont(font);
			menuBar.add(mnKhac);
			
			//==========================================================
			jmiQLDia = new JMenuItem("Quản lý đĩa", new ImageIcon("image/disk.png"));
			jmiQLDia.setFont(font2);
			mnQuanLy.add(jmiQLDia);
			
			jmiBCKhachHang = new JMenuItem("Báo cáo khách hàng", new ImageIcon("image/disk.png"));
			jmiBCKhachHang.setFont(font2);
			mnBaoCao.add(jmiBCKhachHang);
			

			jmiBCTuaDe = new JMenuItem("Báo cáo tựa đề", new ImageIcon("image/disk.png"));
			jmiBCTuaDe.setFont(font2);
			mnBaoCao.add(jmiBCTuaDe);
			
			jmiCapNhatGiaThue = new JMenuItem("Cập nhật giá thuê", new ImageIcon("image/disk.png"));
			jmiCapNhatGiaThue.setFont(font2);
			mnKhac.add(jmiCapNhatGiaThue);
			
			jmiCapNhatNgayThue = new JMenuItem("Cập nhật số ngày thuê", new ImageIcon("image/disk.png"));
			jmiCapNhatNgayThue.setFont(font2);
			mnKhac.add(jmiCapNhatNgayThue);
			
			//==========================================================
			mnBaoCao.setPreferredSize(new Dimension(165, 40));
			mnKhac.setPreferredSize(new Dimension(165, 40));
			mnBaoCao.setIcon(new ImageIcon("image/disk.png"));
			mnKhac.setIcon(new ImageIcon("image/disk.png"));
			
			btnDangNhap.setText("Đăng xuất");
		}else {
			menuBar.remove(mnBaoCao);
			menuBar.remove(mnKhac);
			mnQuanLy.remove(jmiQLDia);
			btnDangNhap.setText("Đăng nhập quản lý");
		}
		
	}
}
