package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.NXB_DAO;
import entity.NhanVien;

import javax.swing.border.EtchedBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class NXB_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTimKiem;
	private JTextField txtmaNXB;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	private JTextField textSoDienThoai;
	private JTextField txtTenNXB;
	
	private DefaultTableModel model;
	private JTable table;
	private	NXB_DAO nxb_DAO;
	/**
	 * Create the panel.
	 */
	public NXB_GUI() {

		//Khai bao DAO
		nxb_DAO = new NXB_DAO();
		
		
		setLayout(null);
		JPanel pMain = new JPanel();
		pMain.setBackground(new Color(77, 77, 77));
		pMain.setBounds(10, 10, 1162, 667);
		add(pMain);
		pMain.setLayout(null);
		
		JLabel lblTim = new JLabel("Tìm kiếm:");
		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTim.setForeground(Color.WHITE);
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(270, 10, 96, 33);
		pMain.add(lblTim);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(375, 10, 255, 33);
		pMain.add(txtTimKiem);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBounds(745, 10, 95, 33);
		pMain.add(btnTim);
		
		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(640, 10, 95, 33);
		pMain.add(cbTim);
		
		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setLayout(null);
		pNhapThongTin.setBorder(new TitledBorder(

						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)),

						"Th\u00F4ng tin chi ti\u1EBFt:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		pNhapThongTin.setBounds(10, 53, 1142, 168);
		pMain.add(pNhapThongTin);
		
		JLabel lblMS = new JLabel("Mã NXB:");
		lblMS.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMS.setBounds(30, 30, 90, 33);
		pNhapThongTin.add(lblMS);
		
		txtmaNXB = new JTextField();
		txtmaNXB.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtmaNXB.setEditable(false);
		txtmaNXB.setColumns(10);
		txtmaNXB.setBounds(125, 30, 333, 33);
		txtmaNXB.setFocusable(false);
		pNhapThongTin.add(txtmaNXB);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(705, 70, 382, 33);
		pNhapThongTin.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmail.setBounds(620, 70, 90, 33);
		pNhapThongTin.add(lblEmail);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDiaChi.setBounds(620, 110, 121, 33);
		pNhapThongTin.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(705, 110, 382, 33);
		pNhapThongTin.add(txtDiaChi);
		
		JLabel lblSoDienThoai = new JLabel("Điện Thoại:");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoDienThoai.setBounds(30, 110, 80, 33);
		pNhapThongTin.add(lblSoDienThoai);
		
		JLabel lblTenNXB = new JLabel("Tên NXB:");
		lblTenNXB.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenNXB.setBounds(30, 70, 66, 33);
		pNhapThongTin.add(lblTenNXB);
		
		textSoDienThoai = new JTextField();
		textSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textSoDienThoai.setColumns(10);
		textSoDienThoai.setBounds(125, 110, 333, 33);
		pNhapThongTin.add(textSoDienThoai);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		verticalStrut.setBounds(203, 63, 840, -7);
		pNhapThongTin.add(verticalStrut);
		
		txtTenNXB = new JTextField();
		txtTenNXB.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenNXB.setColumns(10);
		txtTenNXB.setBounds(125, 70, 333, 33);
		pNhapThongTin.add(txtTenNXB);
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setLayout(null);
		pnChucNang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)), "Ch\u1EE9c n\u0103ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		pnChucNang.setBounds(10, 226, 1142, 62);
		pMain.add(pnChucNang);
		
		JButton btnThemNXB = new JButton("Thêm NXB");
		btnThemNXB.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnThemNXB.setBounds(90, 14, 120, 33);
		pnChucNang.add(btnThemNXB);
		
		JButton btnXaNxb = new JButton("Xóa NXB");
		btnXaNxb.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXaNxb.setBounds(300, 14, 120, 33);
		pnChucNang.add(btnXaNxb);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSua.setBounds(510, 14, 120, 33);
		pnChucNang.add(btnSua);
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoaTrang.setBounds(720, 14, 120, 33);
		pnChucNang.add(btnXoaTrang);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnThoat.setBounds(930, 14, 120, 33);
		pnChucNang.add(btnThoat);
		
		JPanel pnDanhSach = new JPanel();
		pnDanhSach.setLayout(null);
		pnDanhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)), "Danh s\u00E1ch Nh\u00E0 Xu\u1EA5t B\u1EA3n: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		pnDanhSach.setBounds(10, 298, 1142, 354);
		pMain.add(pnDanhSach);
		
		JScrollPane scrollPaneSach = new JScrollPane();
		scrollPaneSach.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneSach.setBorder(new LineBorder(new Color(0, 162, 197), 1, true));
		scrollPaneSach.setBackground(new Color(0, 162, 197));
		scrollPaneSach.setBounds(22, 22, 1097, 311);
		pnDanhSach.add(scrollPaneSach);
		
		

		String cols[] = { "Mã Sách", "Mã NXB", "Mã Loại Sách ", "Tên Sách", "Xuất Xứ", "Tác Giả", "Số Trang", "Giá" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setRowHeight(25);
	}
	
//	public NXB_GUI() {
//
//		//Khai bao DAO
//		nxb_DAO = new NXB_DAO();
//		
//		
//		setLayout(null);
//		JPanel pMain = new JPanel();
//		pMain.setBackground(new Color(77, 77, 77));
//		pMain.setBounds(10, 10, 1162, 667);
//		add(pMain);
//		pMain.setLayout(null);
//		
//		JLabel lblTim = new JLabel("Tìm kiếm:");
//		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTim.setForeground(Color.WHITE);
//		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
//		lblTim.setBounds(101, 10, 96, 33);
//		pMain.add(lblTim);
//		
//		txtTimKiem = new JTextField();
//		txtTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 14));
//		txtTimKiem.setColumns(10);
//		txtTimKiem.setBounds(189, 10, 406, 33);
//		pMain.add(txtTimKiem);
//		
//		JButton btnTim = new JButton("Tìm");
//		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
//		btnTim.setBounds(798, 10, 114, 33);
//		pMain.add(btnTim);
//		
//		JComboBox<String> cbTim = new JComboBox<String>();
//		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
//		cbTim.setBounds(624, 10, 142, 33);
//		pMain.add(cbTim);
//		
//		JPanel pNhapThongTin = new JPanel();
//		pNhapThongTin.setLayout(null);
//		pNhapThongTin.setBorder(new TitledBorder(
//
//						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)),
//
//						"Th\u00F4ng tin chi ti\u1EBFt:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
//		pNhapThongTin.setBounds(10, 53, 1142, 235);
//		pMain.add(pNhapThongTin);
//		
//		JLabel lblMS = new JLabel("Mã NXB:");
//		lblMS.setFont(new Font("SansSerif", Font.BOLD, 14));
//		lblMS.setBounds(49, 39, 90, 33);
//		pNhapThongTin.add(lblMS);
//		
//		txtmaNXB = new JTextField();
//		txtmaNXB.setFont(new Font("SansSerif", Font.PLAIN, 14));
//		txtmaNXB.setEditable(false);
//		txtmaNXB.setColumns(10);
//		txtmaNXB.setBounds(125, 39, 333, 33);
//		pNhapThongTin.add(txtmaNXB);
//		
//		txtEmail = new JTextField();
//		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
//		txtEmail.setColumns(10);
//		txtEmail.setBounds(125, 104, 333, 33);
//		pNhapThongTin.add(txtEmail);
//		
//		JLabel lblEmail = new JLabel("Email:");
//		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
//		lblEmail.setBounds(49, 104, 90, 33);
//		pNhapThongTin.add(lblEmail);
//		
//		JLabel lblDiaChi = new JLabel("Địa chỉ:");
//		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 14));
//		lblDiaChi.setBounds(49, 167, 121, 33);
//		pNhapThongTin.add(lblDiaChi);
//		
//		txtDiaChi = new JTextField();
//		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
//		txtDiaChi.setColumns(10);
//		txtDiaChi.setBounds(125, 167, 980, 33);
//		pNhapThongTin.add(txtDiaChi);
//		
//		JLabel lblSoDienThoai = new JLabel("Điện Thoại:");
//		lblSoDienThoai.setFont(new Font("SansSerif", Font.BOLD, 14));
//		lblSoDienThoai.setBounds(620, 104, 80, 33);
//		pNhapThongTin.add(lblSoDienThoai);
//		
//		JLabel lblTenNXB = new JLabel("Tên NXB:");
//		lblTenNXB.setFont(new Font("SansSerif", Font.BOLD, 14));
//		lblTenNXB.setBounds(620, 39, 66, 33);
//		pNhapThongTin.add(lblTenNXB);
//		
//		textSoDienThoai = new JTextField();
//		textSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
//		textSoDienThoai.setColumns(10);
//		textSoDienThoai.setBounds(730, 104, 375, 33);
//		pNhapThongTin.add(textSoDienThoai);
//		
//		Component verticalStrut = Box.createVerticalStrut(10);
//		verticalStrut.setBounds(203, 63, 840, -7);
//		pNhapThongTin.add(verticalStrut);
//		
//		txtTenNXB = new JTextField();
//		txtTenNXB.setFont(new Font("SansSerif", Font.PLAIN, 14));
//		txtTenNXB.setColumns(10);
//		txtTenNXB.setBounds(730, 39, 375, 33);
//		pNhapThongTin.add(txtTenNXB);
//		
//		JPanel pnDanhSach = new JPanel();
//		pnDanhSach.setLayout(null);
//		pnDanhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)), "Danh s\u00E1ch Nh\u00E0 Xu\u1EA5t B\u1EA3n: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
//		pnDanhSach.setBounds(10, 298, 1142, 354);
//		pMain.add(pnDanhSach);
//		
//		JScrollPane scrollPaneSach = new JScrollPane();
//		scrollPaneSach.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
//		scrollPaneSach.setBorder(new LineBorder(new Color(0, 162, 197), 1, true));
//		scrollPaneSach.setBackground(new Color(0, 162, 197));
//		scrollPaneSach.setBounds(22, 22, 1097, 311);
//		pnDanhSach.add(scrollPaneSach);
//		
//		
//
//		String cols[] = { "Mã Sách", "Mã NXB", "Mã Loại Sách ", "Tên Sách", "Xuất Xứ", "Tác Giả", "Số Trang", "Giá" };
//		model = new DefaultTableModel(cols, 0);
//		table = new JTable(model);
//		table.setRowHeight(25);
//	}
}
