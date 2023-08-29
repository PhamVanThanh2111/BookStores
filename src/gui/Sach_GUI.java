package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultButtonModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class Sach_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JScrollPane scrollPaneSach; 
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public Sach_GUI() {
		
		setLayout(null);
	
		JPanel mMain = new JPanel();
		mMain.setBounds(10, 10, 1256, 583);
		add(mMain);
		mMain.setLayout(null);
	
		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setBounds(10, 52, 1204, 167);
		pNhapThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 162, 197)), "Th\u00F4ng tin chi ti\u1EBFt:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		mMain.add(pNhapThongTin);
		pNhapThongTin.setLayout(null);
		

		JLabel lblMaNV = new JLabel("Mã Sách:");
		lblMaNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaNV.setBounds(49, 30, 90, 33);
		pNhapThongTin.add(lblMaNV);
		
		JTextField txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(161, 30, 403, 33);
		txtMaNV.setEditable(false);
		pNhapThongTin.add(txtMaNV);
		
		JTextField txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(161, 73, 403, 33);
		pNhapThongTin.add(txtTenNV);
		
		JLabel lblTenNV = new JLabel("Tên Sách:");
		lblTenNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenNV.setBounds(49, 73, 90, 33);
		pNhapThongTin.add(lblTenNV);
		
		JLabel lblDiaChi = new JLabel("Nhà Xuất Bản:");
		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDiaChi.setBounds(49, 116, 121, 33);
		pNhapThongTin.add(lblDiaChi);
		
		JTextField txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(161, 116, 403, 33);
		pNhapThongTin.add(txtDiaChi);
		
		JLabel lblGioiTinh = new JLabel("Giá:");
		lblGioiTinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGioiTinh.setBounds(675, 116, 121, 33);
		pNhapThongTin.add(lblGioiTinh);
		
		JLabel lblSoDienThoai = new JLabel("Xuất Xứ:");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoDienThoai.setBounds(675, 73, 124, 33);
		pNhapThongTin.add(lblSoDienThoai);
		
		JLabel lbmaLoaiSach = new JLabel("Mã Loại Sách:");
		lbmaLoaiSach.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbmaLoaiSach.setBounds(675, 30, 111, 33);
		pNhapThongTin.add(lbmaLoaiSach);
		
		JTextField txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(817, 73, 362, 33);
		pNhapThongTin.add(txtSoDienThoai);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(817, 30, 362, 33);
		pNhapThongTin.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(817, 116, 362, 33);
		pNhapThongTin.add(textField_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(563, 40, 111, 23);
		pNhapThongTin.add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(563, 83, 111, 23);
		pNhapThongTin.add(horizontalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setBounds(563, 126, 111, 23);
		pNhapThongTin.add(horizontalStrut_2);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		verticalStrut.setBounds(203, 63, 840, -7);
		pNhapThongTin.add(verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		verticalStrut_1.setBounds(203, 63, 840, 10);
		pNhapThongTin.add(verticalStrut_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(10);
		verticalStrut_2.setBounds(203, 106, 840, 10);
		pNhapThongTin.add(verticalStrut_2);
		
		Component verticalStrut_3 = Box.createVerticalStrut(10);
		verticalStrut_3.setBounds(203, 147, 840, 10);
		pNhapThongTin.add(verticalStrut_3);
		
		JLabel lblTim = new JLabel("Tìm kiếm:");
		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(184, 10, 96, 33);
		mMain.add(lblTim);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(290, 9, 406, 33);
		mMain.add(textField_2);
		
		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(706, 10, 246, 33);
		mMain.add(cbTim);
		
		JPanel pnSouth_1 = new JPanel();
		pnSouth_1.setBounds(10, 216, 1204, 58);
		mMain.add(pnSouth_1);
		pnSouth_1.setLayout(null);
		pnSouth_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 162, 197)), "Ch\u1EE9c n\u0103ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		
		JButton btnThmSch = new JButton("Thêm Sách");
		btnThmSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThmSch.setBounds(103, 14, 121, 34);
		pnSouth_1.add(btnThmSch);
		
		JButton btnXaSch = new JButton("Xóa Sách");
		btnXaSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXaSch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXaSch.setBounds(327, 14, 121, 34);
		pnSouth_1.add(btnXaSch);
		
		JButton btnSua = new JButton("Sửa Thông Tin");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(551, 14, 129, 34);
		pnSouth_1.add(btnSua);
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaTrang.setBounds(783, 14, 121, 34);
		pnSouth_1.add(btnXoaTrang);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(1007, 14, 92, 34);
		pnSouth_1.add(btnThoat);
		
		JPanel pnSouth_2 = new JPanel();
		pnSouth_2.setBounds(10, 278, 1204, 283);
		mMain.add(pnSouth_2);
		pnSouth_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 162, 197)), "Danh sách:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		pnSouth_2.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(973, 10, 114, 33);
		mMain.add(btnNewButton);
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThmSch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		scrollPaneSach = new JScrollPane();
		scrollPaneSach.setBounds(10, 22, 1184, 251);
		scrollPaneSach.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneSach.setBorder(new LineBorder(new Color(0, 162, 197), 1, true));
		scrollPaneSach.setBackground(new Color(0, 162, 197));
		pnSouth_2.add(scrollPaneSach);
		
		
		String cols[] = {"Mã Sách", "Mã NXB", "Mã Loại Sách ", "Tên Sách","Xuất Xứ","Giá"};
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		
		scrollPaneSach.add(table);
		scrollPaneSach.setViewportView(table);
		
	}
}
