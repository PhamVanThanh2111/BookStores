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

import javax.swing.border.EtchedBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class NhaXuatBan_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DefaultTableModel model;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public NhaXuatBan_GUI() {

		// Khai bao DAO

		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1300, 300);
		pMain.add(pThongTin);
		
		JLabel lblthongTinNhaXuatBan = new JLabel("Thông Tin Nhà Xuất Bản");
		lblthongTinNhaXuatBan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthongTinNhaXuatBan.setBounds(20, 15, 300, 40);
		pThongTin.add(lblthongTinNhaXuatBan);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(145, 200, 135, 40);
		pThongTin.add(btnAdd);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(432, 200, 135, 40);
		pThongTin.add(btnDelete);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(719, 200, 135, 40);
		pThongTin.add(btnUpdate);
		
		JButton btnlamMoi = new JButton("Làm mới");
		btnlamMoi.setOpaque(true);
		btnlamMoi.setForeground(Color.WHITE);
		btnlamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnlamMoi.setBackground(new Color(73, 129, 158));
		btnlamMoi.setBounds(1006, 200, 135, 40);
		pThongTin.add(btnlamMoi);
		
		JLabel lblmaTheLoaiSach = new JLabel("Mã Thể Loại Sách:");
		lblmaTheLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmaTheLoaiSach.setBounds(50, 100, 150, 40);
		pThongTin.add(lblmaTheLoaiSach);
		
		JLabel lbltenTheLoaiSach = new JLabel("Tên Thể Loại Sách:");
		lbltenTheLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltenTheLoaiSach.setBounds(680, 100, 175, 40);
		pThongTin.add(lbltenTheLoaiSach);
		
		textField = new JTextField();
		textField.setToolTipText("Mã Sách");
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(220, 100, 400, 40);
		pThongTin.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Mã Sách");
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(850, 100, 400, 40);
		pThongTin.add(textField_1);
		
		JPanel pDanhSach = new JPanel();
		pDanhSach.setLayout(null);
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBackground(Color.WHITE);
		pDanhSach.setBounds(0, 320, 1300, 400);
		pMain.add(pDanhSach);
		
		JScrollPane scrollPaneSach = new JScrollPane();
		scrollPaneSach.setToolTipText("Chọn vào Sách cần hiển thị thông tin");
		scrollPaneSach.setBorder(null);
		scrollPaneSach.setBackground(Color.WHITE);
		scrollPaneSach.setBounds(20, 44, 1259, 335);
		pDanhSach.add(scrollPaneSach);
		
		JLabel lblchiTietNhaXuatBan = new JLabel("Chi Tiết Nhà Xuất Bản");
		lblchiTietNhaXuatBan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblchiTietNhaXuatBan.setBounds(22, 10, 291, 40);
		pDanhSach.add(lblchiTietNhaXuatBan);

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
