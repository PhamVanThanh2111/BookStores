package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;

public class NhaXuatBan_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DefaultTableModel model;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public NhaXuatBan_GUI() {

		// Khai bao DAO

		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBackground(new Color(241, 245, 249));
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);
		
		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setLayout(null);
		pNhapThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pNhapThongTin.setBackground(Color.WHITE);
		pNhapThongTin.setBounds(869, 0, 430, 720);
		pMain.add(pNhapThongTin);
		
		JLabel lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setBounds(20, 20, 90, 90);
		pNhapThongTin.add(lblHinhAnh);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setToolTipText("Số điện thoại");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSoDienThoai.setBounds(40, 201, 120, 40);
		pNhapThongTin.add(lblSoDienThoai);
		
		textField = new JTextField();
		textField.setToolTipText("Số điện thoại");
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(170, 201, 240, 40);
		pNhapThongTin.add(textField);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setToolTipText("Email");
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblEmail.setBounds(40, 246, 56, 40);
		pNhapThongTin.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Email");
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(170, 246, 240, 40);
		pNhapThongTin.add(textField_1);
		
		JLabel lblLuong = new JLabel("Lương:");
		lblLuong.setToolTipText("Lương");
		lblLuong.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLuong.setBounds(880, 70, 56, 33);
		pNhapThongTin.add(lblLuong);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Lương");
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(960, 70, 160, 33);
		pNhapThongTin.add(textField_2);
		
		JLabel lblnNXB = new JLabel("NXB");
		lblnNXB.setToolTipText("Mã nhà xuất bản");
		lblnNXB.setHorizontalAlignment(SwingConstants.LEFT);
		lblnNXB.setForeground(new Color(28, 28, 28));
		lblnNXB.setFont(new Font("SansSerif", Font.ITALIC, 20));
		lblnNXB.setBounds(120, 50, 177, 40);
		pNhapThongTin.add(lblnNXB);
		
		JLabel lblThongTinLienLac = new JLabel("Thông Tin Liên Lạc:");
		lblThongTinLienLac.setToolTipText("Mã nhân viên");
		lblThongTinLienLac.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinLienLac.setForeground(new Color(28, 28, 28));
		lblThongTinLienLac.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinLienLac.setBounds(20, 156, 189, 40);
		pNhapThongTin.add(lblThongTinLienLac);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(60, 60, 60));
		separator_1.setBounds(20, 310, 390, 2);
		pNhapThongTin.add(separator_1);
		
		JLabel lblthongTinNXB = new JLabel("Thông Tin Nhà Xuất Bản:");
		lblthongTinNXB.setToolTipText("Mã nhân viên");
		lblthongTinNXB.setHorizontalAlignment(SwingConstants.LEFT);
		lblthongTinNXB.setForeground(new Color(28, 28, 28));
		lblthongTinNXB.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblthongTinNXB.setBounds(20, 322, 270, 40);
		pNhapThongTin.add(lblthongTinNXB);
		
		JLabel lblmaNXB = new JLabel("Mã NXB:");
		lblmaNXB.setToolTipText("Số điện thoại");
		lblmaNXB.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblmaNXB.setBounds(40, 367, 120, 40);
		pNhapThongTin.add(lblmaNXB);
		
		JLabel lblMaNXB = new JLabel("NV0001");
		lblMaNXB.setToolTipText("Số điện thoại");
		lblMaNXB.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaNXB.setBounds(170, 367, 120, 40);
		pNhapThongTin.add(lblMaNXB);
		
		JLabel lbldiaChi = new JLabel("Địa Chỉ:");
		lbldiaChi.setToolTipText("Địa chỉ nhà xuất bản");
		lbldiaChi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbldiaChi.setBounds(40, 412, 120, 40);
		pNhapThongTin.add(lbldiaChi);
		
		JButton btnChonHinhAnh = new JButton("Choose");
		btnChonHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonHinhAnh.setBounds(30, 116, 64, 21);
		pNhapThongTin.add(btnChonHinhAnh);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Số điện thoại");
		textField_3.setText("Nhà Xuất Bản Trẻ");
		textField_3.setFont(new Font("SansSerif", Font.BOLD, 20));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(120, 20, 240, 40);
		pNhapThongTin.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Email");
		textField_4.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(170, 412, 240, 40);
		pNhapThongTin.add(textField_4);
		
		PanelRound pDanhSach = new PanelRound();
		pDanhSach.setLayout(null);
		pDanhSach.setRoundTopLeft(16);
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBackground(Color.WHITE);
		pDanhSach.setBounds(0, 0, 850, 720);
		pMain.add(pDanhSach);
		
		JScrollPane scrollPaneNXB = new JScrollPane();
		scrollPaneNXB.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneNXB.setBorder(null);
		scrollPaneNXB.setBackground(Color.WHITE);
		scrollPaneNXB.setBounds(20, 70, 810, 569);
		pDanhSach.add(scrollPaneNXB);
		
		JLabel lblNh = new JLabel("Nhà Xuất Bản");
		lblNh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNh.setBounds(20, 22, 130, 40);
		pDanhSach.add(lblNh);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(60, 60, 60));
		separator.setBounds(154, 50, 676, 2);
		pDanhSach.add(separator);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBackground(new Color(73, 129, 158));
		btnXoa.setBounds(395, 660, 135, 40);
		pDanhSach.add(btnXoa);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(245, 660, 135, 40);
		pDanhSach.add(btnAdd);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSua.setBackground(new Color(73, 129, 158));
		btnSua.setBounds(545, 660, 135, 40);
		pDanhSach.add(btnSua);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(695, 660, 135, 40);
		pDanhSach.add(btnTim);

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
