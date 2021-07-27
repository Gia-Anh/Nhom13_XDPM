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
import java.awt.Color;

public class UI_Main extends JFrame{

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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnThueDia = new JMenu("Thuê - Trả đĩa");
		mnThueDia.setFont(font);
		menuBar.add(mnThueDia);
		
		JMenu mnDatTruoc = new JMenu("Đặt trước");
		mnDatTruoc.setFont(font);
		menuBar.add(mnDatTruoc);
		
		JMenu mnTraTre = new JMenu("Trả trễ");
		mnTraTre.setFont(font);
		menuBar.add(mnTraTre);
		
		JMenu mnQuanLy = new JMenu("Quản lý");
		mnQuanLy.setFont(font);
		menuBar.add(mnQuanLy);

		JMenu mnBaoCao = new JMenu("Báo cáo");
		mnBaoCao.setFont(font);
		menuBar.add(mnBaoCao);
		
		JMenu mnKhac = new JMenu("Khác");
		mnKhac.setFont(font);
		menuBar.add(mnKhac);
		
		//==========================================================
		JMenuItem jmiThueDia = new JMenuItem("Thuê đĩa", new ImageIcon("image/disk.png"));
		jmiThueDia.setFont(font2);
		mnThueDia.add(jmiThueDia);
		
		JMenuItem jmiTraDia = new JMenuItem("Trả đĩa", new ImageIcon("image/disk.png"));
		jmiTraDia.setFont(font2);
		mnThueDia.add(jmiTraDia);
		
		JMenuItem jmiKTTTDia = new JMenuItem("Kiểm tra trạng thái đĩa", new ImageIcon("image/disk.png"));
		jmiKTTTDia.setFont(font2);
		mnThueDia.add(jmiKTTTDia);
		
		JMenuItem jmiThemDatTruoc = new JMenuItem("Thêm đặt trước", new ImageIcon("image/disk.png"));
		jmiThemDatTruoc.setFont(font2);
		mnDatTruoc.add(jmiThemDatTruoc);
		
		JMenuItem jmiHuyDatTruoc = new JMenuItem("Hủy đặt trước", new ImageIcon("image/disk.png"));
		jmiHuyDatTruoc.setFont(font2);
		mnDatTruoc.add(jmiHuyDatTruoc);
		
		JMenuItem jmiThanhToan = new JMenuItem("Thanh toán phí trễ", new ImageIcon("image/disk.png"));
		jmiThanhToan.setFont(font2);
		mnTraTre.add(jmiThanhToan);
		
		JMenuItem jmiQLTuaDe = new JMenuItem("Quản lý tựa đề", new ImageIcon("image/disk.png"));
		jmiQLTuaDe.setFont(font2);
		mnQuanLy.add(jmiQLTuaDe);
		
		JMenuItem jmiQLDia = new JMenuItem("Quản lý đĩa", new ImageIcon("image/disk.png"));
		jmiQLDia.setFont(font2);
		mnQuanLy.add(jmiQLDia);
		
		JMenuItem jmiQLKhachHang = new JMenuItem("Quản lý khách hàng", new ImageIcon("image/disk.png"));
		jmiQLKhachHang.setFont(font2);
		mnQuanLy.add(jmiQLKhachHang);

		JMenuItem jmiBCKhachHang = new JMenuItem("Báo cáo khách hàng", new ImageIcon("image/disk.png"));
		jmiBCKhachHang.setFont(font2);
		mnBaoCao.add(jmiBCKhachHang);
		

		JMenuItem jmiBCTuaDe = new JMenuItem("Báo cáo tựa đề", new ImageIcon("image/disk.png"));
		jmiBCTuaDe.setFont(font2);
		mnBaoCao.add(jmiBCTuaDe);
		
		JMenuItem jmiCapNhatGiaThue = new JMenuItem("Cập nhật giá thuê", new ImageIcon("image/disk.png"));
		jmiCapNhatGiaThue.setFont(font2);
		mnKhac.add(jmiCapNhatGiaThue);
		
		JMenuItem jmiCapNhatNgayThue = new JMenuItem("Cập nhật số ngày thuê", new ImageIcon("image/disk.png"));
		jmiCapNhatNgayThue.setFont(font2);
		mnKhac.add(jmiCapNhatNgayThue);
		//==========================================================
		mnThueDia.setPreferredSize(new Dimension(165, 40));
		mnDatTruoc.setPreferredSize(new Dimension(165, 40));
		mnTraTre.setPreferredSize(new Dimension(165, 40));
		mnQuanLy.setPreferredSize(new Dimension(165, 40));
		mnBaoCao.setPreferredSize(new Dimension(165, 40));
		mnKhac.setPreferredSize(new Dimension(165, 40));
		//==========================================================
		mnThueDia.setIcon(new ImageIcon("image/disk.png"));
		mnDatTruoc.setIcon(new ImageIcon("image/disk.png"));
		mnTraTre.setIcon(new ImageIcon("image/disk.png"));
		mnQuanLy.setIcon(new ImageIcon("image/disk.png"));
		mnBaoCao.setIcon(new ImageIcon("image/disk.png"));
		mnKhac.setIcon(new ImageIcon("image/disk.png"));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 561, 1066, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnDangNhap = new JButton("Đăng nhập quản lý");
		btnDangNhap.setBounds(896, 10, 142, 30);
		panel.add(btnDangNhap);
		
	}
}
