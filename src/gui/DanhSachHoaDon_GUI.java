package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DanhSachHoaDon_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaHoaDon;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JDateChooser dateChooserTuNgay;
	private JDateChooser dateChooserDenNgay;

	/**
	 * Create the panel.
	 */
	public DanhSachHoaDon_GUI() {
		setBackground(new Color(128, 128, 192));
		setLayout(null);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBounds(0, 0, 1300, 720);
		add(pnlMain);
		pnlMain.setLayout(null);
		
		JPanel pnlThongTinTimKiem = new JPanel();
		pnlThongTinTimKiem.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlThongTinTimKiem.setBounds(0, 0, 1300, 180);
		pnlMain.add(pnlThongTinTimKiem);
		pnlThongTinTimKiem.setLayout(null);
		
		JLabel lblThngTinTm = new JLabel("Thông Tin Tìm Kiếm");
		lblThngTinTm.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThngTinTm.setBounds(20, 20, 203, 40);
		pnlThongTinTimKiem.add(lblThngTinTm);
		
		JLabel lblMaHoaDon = new JLabel("Mã Hóa Đơn:");
		lblMaHoaDon.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaHoaDon.setBounds(23, 70, 141, 40);
		pnlThongTinTimKiem.add(lblMaHoaDon);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(174, 70, 250, 40);
		pnlThongTinTimKiem.add(txtMaHoaDon);
		
		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng:");
		lblTenKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTenKhachHang.setBounds(23, 120, 141, 40);
		pnlThongTinTimKiem.add(lblTenKhachHang);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(174, 120, 250, 40);
		pnlThongTinTimKiem.add(txtTenKhachHang);
		
		JLabel lblTuNgay = new JLabel("Từ Ngày:");
		lblTuNgay.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTuNgay.setBounds(450, 70, 141, 40);
		pnlThongTinTimKiem.add(lblTuNgay);
		
		dateChooserTuNgay = new JDateChooser();
		dateChooserTuNgay.setToolTipText("Ngày sinh");
		dateChooserTuNgay.setBounds(601, 70, 250, 40);
		dateChooserTuNgay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserTuNgay.setDateFormatString("dd/MM/yyyy");
		dateChooserTuNgay.setFont(new Font("SansSerif", Font.PLAIN, 14));
		dateChooserTuNgay.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserTuNgay.getCalendarButton().setBackground(new Color(46, 46, 46));
		dateChooserTuNgay.setBorder(null);
		pnlThongTinTimKiem.add(dateChooserTuNgay);
		
		JLabel lblnNgy = new JLabel("Đến Ngày:");
		lblnNgy.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblnNgy.setBounds(876, 70, 141, 40);
		pnlThongTinTimKiem.add(lblnNgy);
		
		dateChooserDenNgay = new JDateChooser();
		dateChooserDenNgay.setToolTipText("Ngày sinh");
		dateChooserDenNgay.setBounds(1027, 70, 250, 40);
		dateChooserDenNgay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserDenNgay.setDateFormatString("dd/MM/yyyy");
		dateChooserDenNgay.setFont(new Font("SansSerif", Font.PLAIN, 14));
		dateChooserDenNgay.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserDenNgay.getCalendarButton().setBackground(new Color(46, 46, 46));
		dateChooserDenNgay.setBorder(null);
		pnlThongTinTimKiem.add(dateChooserDenNgay);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSoDienThoai.setBounds(450, 120, 141, 40);
		pnlThongTinTimKiem.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(601, 120, 250, 40);
		pnlThongTinTimKiem.add(txtSoDienThoai);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setOpaque(true);
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(876, 120, 135, 40);
		pnlThongTinTimKiem.add(btnTim);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setOpaque(true);
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.setBounds(1142, 120, 135, 40);
		pnlThongTinTimKiem.add(btnLamMoi);
		
	}
}
