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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.Sach_DAO;
import entity.NhanVien;
import entity.Sach;

import javax.swing.JScrollPane;

import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.Box;

public class Sach_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtMaSach;
	private JTextField txtMaNXB;
	private JTextField txtMaLoaiSach;
	private JTextField txtTenSach;
	private JTextField txtXuatXu;
	private JTextField txtTacGia;
	private JTextField txtSoTrang;
	private JTextField txtGia;
	private JScrollPane scrollPaneSach; 
	private JTable table;
	private DefaultTableModel model;
	private Sach_DAO sach_DAO;
	private JTableHeader tableHeader;

	/**
	 * Create the panel.
	 */
	public Sach_GUI() {
		
		setLayout(null);
		//Khai bao Sach_DAO
		sach_DAO = new Sach_DAO();
	
		JPanel mMain = new JPanel();
		mMain.setBounds(10, 10, 1162, 667);
		add(mMain);
		mMain.setLayout(null);
	
		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setBounds(10, 53, 1142, 167);
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
		txtMaNV.setBounds(161, 30, 297, 33);
		txtMaNV.setEditable(false);
		pNhapThongTin.add(txtMaNV);
		
		JTextField txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(161, 73, 297, 33);
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
		txtDiaChi.setBounds(161, 116, 297, 33);
		pNhapThongTin.add(txtDiaChi);
		
		JLabel lblGioiTinh = new JLabel("Giá:");
		lblGioiTinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGioiTinh.setBounds(651, 116, 121, 33);
		pNhapThongTin.add(lblGioiTinh);
		
		JLabel lblSoDienThoai = new JLabel("Xuất Xứ:");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoDienThoai.setBounds(651, 73, 124, 33);
		pNhapThongTin.add(lblSoDienThoai);
		
		JLabel lbmaLoaiSach = new JLabel("Mã Loại Sách:");
		lbmaLoaiSach.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbmaLoaiSach.setBounds(651, 30, 111, 33);
		pNhapThongTin.add(lbmaLoaiSach);
		
		JTextField txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(756, 73, 320, 33);
		pNhapThongTin.add(txtSoDienThoai);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(756, 30, 320, 33);
		pNhapThongTin.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(756, 116, 320, 33);
		pNhapThongTin.add(textField_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(457, 40, 193, 23);
		pNhapThongTin.add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(457, 83, 193, 23);
		pNhapThongTin.add(horizontalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setBounds(457, 126, 193, 23);
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
		pnSouth_1.setBounds(10, 216, 1142, 58);
		mMain.add(pnSouth_1);
		pnSouth_1.setLayout(null);
		pnSouth_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 162, 197)), "Ch\u1EE9c n\u0103ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		
		JButton btnThmSch = new JButton("Thêm Sách");
		btnThmSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThmSch.setBounds(93, 14, 121, 34);
		pnSouth_1.add(btnThmSch);
		
		JButton btnXaSch = new JButton("Xóa Sách");
		btnXaSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXaSch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXaSch.setBounds(307, 14, 121, 34);
		pnSouth_1.add(btnXaSch);
		
		JButton btnSua = new JButton("Sửa Thông Tin");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(521, 14, 129, 34);
		pnSouth_1.add(btnSua);
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaTrang.setBounds(743, 14, 121, 34);
		pnSouth_1.add(btnXoaTrang);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(957, 14, 92, 34);
		pnSouth_1.add(btnThoat);
		
		JPanel pnSouth_2 = new JPanel();
		pnSouth_2.setBounds(10, 278, 1142, 283);
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
		scrollPaneSach.setBounds(22, 22, 1099, 239);
		scrollPaneSach.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneSach.setBorder(new LineBorder(new Color(0, 162, 197), 1, true));
		scrollPaneSach.setBackground(new Color(0, 162, 197));
		pnSouth_2.add(scrollPaneSach);
		
		
		String cols[] = {"Mã Sách", "Mã NXB", "Mã Loại Sách ", "Tên Sách","Xuất Xứ","Tác Giả","Số Trang","Giá"};
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setRowHeight(25);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				txtMaSach.setText(table.getValueAt(row, 0).toString());
				txtMaNXB.setText((String) model.getValueAt(row, 1));
				txtMaLoaiSach.setText((String) model.getValueAt(row, 2));
				txtTenSach.setText((String) model.getValueAt(row, 3));
				txtXuatXu.setText((String) model.getValueAt(row, 4));
				txtTacGia.setText((String) model.getValueAt(row, 5));
				txtSoTrang.setText((String) model.getValueAt(row, 6));
				txtGia.setText((String) model.getValueAt(row, 7));
				System.out.println("ueuc");
			}
		});
		scrollPaneSach.add(table);
		scrollPaneSach.setViewportView(table);
		
		
		loadDataIntoTable();
		
		// header of table
				tableHeader = table.getTableHeader();
				tableHeader.setBackground(new Color(46, 46, 46));
				tableHeader.setForeground(Color.white);
				tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
	}
	public void loadDataIntoTable() {
		for (Sach sach : sach_DAO.getAllListSach()) {
			Object [] objects = {sach.getMaSach(),sach.getMaNXB(),sach.getMaLoaiSach(),sach.getTenSach(),sach.getXuatXu(),sach.getTacGia(),sach.getSoTrang(),sach.getGia()};
			model.addRow(objects);
			
		}
		
	}
}
