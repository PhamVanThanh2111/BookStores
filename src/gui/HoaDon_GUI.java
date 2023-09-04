package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class HoaDon_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaHD;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public HoaDon_GUI() {
		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBackground(new Color(77, 77, 77));
		pMain.setBounds(0, 0, 1162, 667);
		add(pMain);
		
		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setLayout(null);
		pNhapThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "Th\u00F4ng tin:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pNhapThongTin.setBounds(10, 53, 1142, 219);
		pMain.add(pNhapThongTin);
		
		JLabel lblMaHD = new JLabel("Mã HĐ:");
		lblMaHD.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaHD.setBounds(39, 30, 90, 33);
		pNhapThongTin.add(lblMaHD);
		
		txtMaHD = new JTextField();
		txtMaHD.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaHD.setEditable(false);
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(119, 30, 151, 33);
		pNhapThongTin.add(txtMaHD);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(119, 116, 151, 33);
		pNhapThongTin.add(textField_1);
		
		JLabel lblTenNV = new JLabel("Tên NV:");
		lblTenNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenNV.setBounds(39, 116, 90, 33);
		pNhapThongTin.add(lblTenNV);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDiaChi.setBounds(291, 116, 90, 33);
		pNhapThongTin.add(lblDiaChi);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(406, 116, 163, 33);
		pNhapThongTin.add(textField_2);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGioiTinh.setBounds(291, 30, 90, 33);
		pNhapThongTin.add(lblGioiTinh);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoDienThoai.setBounds(597, 73, 103, 33);
		pNhapThongTin.add(lblSoDienThoai);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNgaySinh.setBounds(291, 73, 90, 33);
		pNhapThongTin.add(lblNgaySinh);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(710, 73, 149, 33);
		pNhapThongTin.add(textField_3);
		
		JComboBox<String> cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbGioiTinh.setBounds(406, 30, 163, 33);
		pNhapThongTin.add(cbGioiTinh);
		
		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblChucVu.setBounds(879, 30, 70, 33);
		pNhapThongTin.add(lblChucVu);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmail.setBounds(597, 116, 56, 33);
		pNhapThongTin.add(lblEmail);
		
		JLabel lblCCCD = new JLabel("CCCD:");
		lblCCCD.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCCCD.setBounds(597, 30, 62, 33);
		pNhapThongTin.add(lblCCCD);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(710, 30, 149, 33);
		pNhapThongTin.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(710, 116, 149, 33);
		pNhapThongTin.add(textField_5);
		
		JComboBox<String> cbChucVu = new JComboBox<String>();
		cbChucVu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbChucVu.setBounds(959, 30, 146, 33);
		pNhapThongTin.add(cbChucVu);
		
		JDateChooser dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserNgaySinh.getCalendarButton().setBackground(new Color(46, 46, 46));
		dateChooserNgaySinh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		dateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateChooserNgaySinh.setBorder(new LineBorder(new Color(28, 28, 28), 1, true));
		dateChooserNgaySinh.setBounds(406, 73, 163, 33);
		pNhapThongTin.add(dateChooserNgaySinh);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(142, 167, 108, 33);
		pNhapThongTin.add(btnAdd);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(392, 167, 108, 33);
		pNhapThongTin.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(642, 167, 108, 33);
		pNhapThongTin.add(btnSua);
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setBounds(892, 167, 108, 33);
		pNhapThongTin.add(btnXoaTrang);
		
		JLabel lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaNV.setBounds(39, 73, 90, 33);
		pNhapThongTin.add(lblMaNV);
		
		JComboBox<String> cbMaNV = new JComboBox<String>();
		cbMaNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbMaNV.setBounds(119, 73, 151, 33);
		pNhapThongTin.add(cbMaNV);
		
		JLabel lblLuong = new JLabel("Lương:");
		lblLuong.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLuong.setBounds(879, 73, 56, 33);
		pNhapThongTin.add(lblLuong);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(959, 73, 146, 33);
		pNhapThongTin.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(377, 10, 257, 33);
		pMain.add(textField_7);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(750, 10, 114, 33);
		pMain.add(btnNewButton);
		
		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(644, 10, 96, 33);
		pMain.add(cbTim);
		
		JLabel lblTim = new JLabel("Tìm kiếm:");
		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTim.setForeground(Color.WHITE);
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(271, 10, 96, 33);
		pMain.add(lblTim);
		
		JPanel pDanhSach = new JPanel();
		pDanhSach.setLayout(null);
		pDanhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "Danh s\u00E1ch:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pDanhSach.setBounds(10, 282, 1142, 375);
		pMain.add(pDanhSach);
		
		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneNV.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneNV.setBackground(new Color(80, 80, 80));
		scrollPaneNV.setBounds(10, 20, 1122, 345);
		pDanhSach.add(scrollPaneNV);

	}
}
