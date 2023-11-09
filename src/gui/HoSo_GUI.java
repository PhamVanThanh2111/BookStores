package gui;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import entity.NhanVien;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

public class HoSo_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DoiMatKhau_GUI doiMatKhau_GUI;
	/**
	 * Create the panel.
	 */
	public HoSo_GUI(NhanVien nhanVien) {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1300, 720);
		add(panel);
		panel.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1300, 720);
		panel.add(desktopPane);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBackground(new Color(255, 255, 255));
		pnlMain.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlMain.setBounds(0, 0, 1300, 720);
		desktopPane.add(pnlMain);
		pnlMain.setLayout(null);
		
		JButton btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setForeground(Color.WHITE);
		btnDoiMatKhau.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDoiMatKhau.setBackground(new Color(73, 129, 158));
		btnDoiMatKhau.setBounds(1155, 670, 135, 40);
		btnDoiMatKhau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (doiMatKhau_GUI == null || doiMatKhau_GUI.isClosed()) {
					doiMatKhau_GUI = new DoiMatKhau_GUI(nhanVien);
					doiMatKhau_GUI.addInternalFrameListener(new InternalFrameAdapter() {
			            @Override
			            public void internalFrameActivated(InternalFrameEvent e) {
//			                System.out.println("Internal frame is activated.");
			            }

			            @Override
			            public void internalFrameDeactivated(InternalFrameEvent e) {
//			                System.out.println("Internal frame is deactivated.");
			            }

			            @Override
			            public void internalFrameOpened(InternalFrameEvent e) {
//			                System.out.println("Internal frame is opened.");
			            }
			            
			            @Override
			            public void internalFrameClosed(InternalFrameEvent e) {
//			                System.out.println("Internal frame is closed.");
			            }
			        });
					desktopPane.add(doiMatKhau_GUI).setVisible(true);
//					loadDataIntoTable(doiMatKhau_GUI.searchNhanVien());
				}
			}
		});
		pnlMain.add(btnDoiMatKhau);
		
		JLabel lblBackgroundHoSo = new JLabel("");
		lblBackgroundHoSo.setBackground(new Color(255, 255, 255));
		lblBackgroundHoSo.setIcon(new ImageIcon(HoSo_GUI.class.getResource("/image/HeThong/background_hoso.jpg")));
		lblBackgroundHoSo.setBounds(0, 0, pnlMain.getWidth(), pnlMain.getHeight());
		pnlMain.add(lblBackgroundHoSo);
		
		JLabel lblAnh = new JLabel("");
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setBounds(40, 30, 256, 256);
		Border border = BorderFactory.createLineBorder(Color.BLACK,1);
		lblAnh.setBorder(border);
		lblAnh.setIcon(new ImageIcon(NhanVien_GUI.class.getResource(nhanVien.getHinhAnh().substring(0, nhanVien.getHinhAnh().lastIndexOf(".")) + "_hoso.png/")));
		pnlMain.add(lblAnh);
		
		JLabel lblThongTinCaNhan = new JLabel("Thông Tin Cá Nhân");
		lblThongTinCaNhan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinCaNhan.setBounds(356, 30, 256, 40);
		pnlMain.add(lblThongTinCaNhan);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(336, 80, 924, 2);
		pnlMain.add(separator);
		
		JLabel lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaNV.setBounds(60, 316, 74, 40);
		pnlMain.add(lblMaNV);
		
		JLabel lblTenNV = new JLabel("Tên NV:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenNV.setBounds(60, 366, 74, 40);
		pnlMain.add(lblTenNV);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioiTinh.setBounds(60, 411, 87, 40);
		pnlMain.add(lblGioiTinh);
		
		JLabel lblMaNhanVien = new JLabel();
		lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaNhanVien.setBounds(145, 316, 130, 40);
		lblMaNhanVien.setText(nhanVien.getMaNhanVien());
		pnlMain.add(lblMaNhanVien);
		
		JLabel lblTrnThanhTm = new JLabel("");
		lblTrnThanhTm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTrnThanhTm.setBounds(145, 366, 153, 40);
		lblTrnThanhTm.setText(nhanVien.getTenNhanVien());
		pnlMain.add(lblTrnThanhTm);
		
		JLabel lblGioiTinh1 = new JLabel("");
		lblGioiTinh1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGioiTinh1.setBounds(145, 411, 139, 40);
		lblGioiTinh1.setText(nhanVien.getGioiTinh());
		pnlMain.add(lblGioiTinh1);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgaySinh.setBounds(376, 100, 87, 40);
		pnlMain.add(lblNgaySinh);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiaChi.setBounds(376, 150, 87, 40);
		pnlMain.add(lblDiaChi);
		
		JLabel lblCCCD = new JLabel("CCCD:");
		lblCCCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCCCD.setBounds(376, 200, 87, 40);
		pnlMain.add(lblCCCD);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSDT.setBounds(376, 250, 115, 40);
		pnlMain.add(lblSDT);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		JLabel lblNS = new JLabel("02/10/2003");
		lblNS.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNS.setBounds(501, 100, 153, 40);
		lblNS.setText(dateFormat.format(nhanVien.getNgaySinh()));
		pnlMain.add(lblNS);
		
		JLabel lblDC = new JLabel("");
		lblDC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDC.setBounds(501, 150, 153, 40);
		lblDC.setText(nhanVien.getDiaChi());
		pnlMain.add(lblDC);
		
		JLabel lblCC = new JLabel("");
		lblCC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCC.setBounds(501, 200, 153, 40);
		lblCC.setText(nhanVien.getcCCD());
		pnlMain.add(lblCC);
		
		JLabel lblSDThoai = new JLabel();
		lblSDThoai.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSDThoai.setBounds(501, 250, 153, 40);
		lblSDThoai.setText(nhanVien.getSoDienThoai());
		pnlMain.add(lblSDThoai);
		
		JLabel lblNgayVaoLam = new JLabel("Ngày Vào Làm:");
		lblNgayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayVaoLam.setBounds(810, 100, 115, 40);
		pnlMain.add(lblNgayVaoLam);
		
		JLabel lblCaLam = new JLabel("Ca Làm:");
		lblCaLam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCaLam.setBounds(810, 150, 115, 40);
		pnlMain.add(lblCaLam);
		
		JLabel lblChucVu = new JLabel("Chức Vụ:");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChucVu.setBounds(810, 200, 115, 40);
		pnlMain.add(lblChucVu);
		
		JLabel lblCoSo = new JLabel("Cơ Sở:");
		lblCoSo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCoSo.setBounds(810, 250, 115, 40);
		pnlMain.add(lblCoSo);
		
		JLabel lblNVL = new JLabel();
		lblNVL.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNVL.setBounds(935, 100, 153, 40);
		lblNVL.setText(dateFormat.format(nhanVien.getNgayVaoLam()));
		pnlMain.add(lblNVL);
		
		JLabel lblCL = new JLabel("01");
		lblCL.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCL.setBounds(935, 150, 153, 40);
		lblCL.setText(nhanVien.getMaCa().substring(1));
		pnlMain.add(lblCL);
		
		JLabel lblCV = new JLabel("");
		lblCV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCV.setBounds(935, 200, 219, 40);
		lblCV.setText(nhanVien.getChucVu());
		pnlMain.add(lblCV);
		
		JLabel lblCS = new JLabel("Hồ Chí Minh");
		lblCS.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCS.setBounds(935, 250, 153, 40);
		pnlMain.add(lblCS);

	}
}
