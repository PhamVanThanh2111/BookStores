package gui;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import entity.NhanVien;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;

public class HoSo_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public HoSo_GUI(NhanVien nhanVien) {
		setLayout(null);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBackground(new Color(255, 255, 255));
		pnlMain.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlMain.setBounds(0, 0, 1300, 720);
		add(pnlMain);
		pnlMain.setLayout(null);
		
		JLabel lblBackgroundHoSo = new JLabel("");
		lblBackgroundHoSo.setBackground(new Color(255, 255, 255));
		lblBackgroundHoSo.setIcon(new ImageIcon(HoSo_GUI.class.getResource("/image/background_hoso.jpg")));
		lblBackgroundHoSo.setBounds(0, 0, pnlMain.getWidth(), pnlMain.getHeight());
		pnlMain.add(lblBackgroundHoSo);
		
		JLabel lblAnh = new JLabel("");
		lblAnh.setBounds(40, 30, 256, 256);
		Border border = BorderFactory.createLineBorder(Color.BLACK,1);
		lblAnh.setBorder(border);
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
		
		JLabel lblMaNhanVien = new JLabel("NV0001");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaNhanVien.setBounds(145, 316, 130, 40);
		pnlMain.add(lblMaNhanVien);
		
		JLabel lblTrnThanhTm = new JLabel("Mai Lưu Hữu Vinh");
		lblTrnThanhTm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTrnThanhTm.setBounds(145, 366, 153, 40);
		pnlMain.add(lblTrnThanhTm);
		
		JLabel lblGioiTinh1 = new JLabel("Nam");
		lblGioiTinh1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGioiTinh1.setBounds(145, 411, 139, 40);
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
		
		JLabel lblNS = new JLabel("02/10/2003");
		lblNS.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNS.setBounds(501, 100, 153, 40);
		pnlMain.add(lblNS);
		
		JLabel lblDC = new JLabel("Bình Thạnh");
		lblDC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDC.setBounds(501, 150, 153, 40);
		pnlMain.add(lblDC);
		
		JLabel lblCC = new JLabel("07720300****");
		lblCC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCC.setBounds(501, 200, 153, 40);
		pnlMain.add(lblCC);
		
		JLabel lblSDThoai = new JLabel("0388412884");
		lblSDThoai.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSDThoai.setBounds(501, 250, 153, 40);
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
		
		JLabel lblNVL = new JLabel("27/10/2023");
		lblNVL.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNVL.setBounds(935, 100, 153, 40);
		pnlMain.add(lblNVL);
		
		JLabel lblCL = new JLabel("01");
		lblCL.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCL.setBounds(935, 150, 153, 40);
		pnlMain.add(lblCL);
		
		JLabel lblCV = new JLabel("Nhân Viên Bán Hàng");
		lblCV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCV.setBounds(935, 200, 219, 40);
		pnlMain.add(lblCV);
		
		JLabel lblCS = new JLabel("Hồ Chí Minh");
		lblCS.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCS.setBounds(935, 250, 153, 40);
		pnlMain.add(lblCS);

	}
}
