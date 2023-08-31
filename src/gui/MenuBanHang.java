//package gui;
//
//import javax.swing.JPanel;
//import javax.swing.border.LineBorder;
//
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//
//public class MenuBanHang extends JPanel {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private CardLayout cardLayoutContent;
//
//	/**
//	 * Create the panel.
//	 */
//	public MenuBanHang() {
//		setLayout(null);
//		
//		JPanel pMenu = new JPanel();
//		pMenu.setBounds(0, 0, 1280, 31);
//		pMenu.setBackground(new Color(17, 103, 177));
//		pMenu.setLayout(null);
//		add(pMenu);
//		
//		JButton btnNhanVien = new JButton("Nhân viên");
//		btnNhanVien.setToolTipText("Quản lý nhân viên");
//		btnNhanVien.setBounds(29, 0, 127, 31);
//		btnNhanVien.setBackground(new Color(255, 240, 245));
//		btnNhanVien.setBorder(new LineBorder(new Color(0, 146, 182), 2, false));
//		btnNhanVien.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				cardLayoutContent.show(Tr, "NhanVien_GUI");
//			}
//		});
//		pMenu.add(btnNhanVien);
//		
//		JButton btnSach = new JButton("Sách");
//		btnSach.setToolTipText("Quản lý sách");
//		btnSach.setBounds(743, 0, 127, 31);
//		btnSach.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				cardLayoutContent.show(pContent, "Sach_GUI");
//			}
//		});
//		btnSach.setBounds(653, 0, 127, 31);
//		pMenu.add(btnSach);
//		
//		JButton btnNXB = new JButton("NXB");
//		btnNXB.setToolTipText("Quản lý NXB");
//		btnNXB.setBounds(965, 0, 127, 31);
//		pMenu.add(btnNXB);
//		
//		JButton btnHoaDon = new JButton("Hóa đơn");
//		btnHoaDon.setToolTipText("Quản lý hóa đơn");
//		btnHoaDon.setBounds(497, 0, 127, 31);
//		btnHoaDon.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				cardLayoutContent.show(pContent, "HoaDon_GUI");
//			}
//		});
//		pMenu.add(btnHoaDon);
//		
//		JButton btnCuaHang = new JButton("Cửa hàng");
//		btnCuaHang.setToolTipText("Quản lý cửja hàng");
//		btnCuaHang.setBounds(185, 0, 127, 31);
//		pMenu.add(btnCuaHang);
//		
//		JButton btnLoaiSach = new JButton("Loại sách");
//		btnLoaiSach.setToolTipText("Quản lý loại sách");
//		btnLoaiSach.setBounds(809, 0, 127, 31);
//		pMenu.add(btnLoaiSach);
//		
//		JButton btnKhachHang = new JButton("Khách hàng");
//		btnKhachHang.setToolTipText("Quản lý khách hàng");
//		btnKhachHang.setBounds(341, 0, 127, 31);
//		pMenu.add(btnKhachHang);
//		
//		JButton btnThongKe = new JButton("Thống kê");
//		btnThongKe.setBounds(1121, 0, 127, 31);
//		pMenu.add(btnThongKe);
//		btnThongKe.setToolTipText("Quản lý khách hàng");
//
//	}
//
//}
