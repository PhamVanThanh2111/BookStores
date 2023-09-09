package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
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

import connect.ConnectDB;
import dao.LoaiSach_DAO;
import dao.Sach_DAO;
import entity.LoaiSach;
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
	private JTextField txtTimKiem;
	private JTextField txtGia;
	private JTextField txtXuatXu;
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtMaNXB;
	private JTextField txtSoTrang;
	private JTextField txtTacGia;
	private JLabel lblMaSach;
	private JLabel lblTenSach;
	private JLabel lblMaNXB;
	private JLabel lbMaLoaiSach;
	private JLabel lblXuatXu;
	private JLabel lblGia;
	private JLabel lblTacGia;
	private JLabel lblSoTrang;
	private JScrollPane scrollPaneSach;
	private JTable table;
	private DefaultTableModel model;
	private Sach_DAO sach_DAO;
	private LoaiSach_DAO loaiSach_DAO;
	private JTableHeader tableHeader;
	private JComboBox<String> cbMaLoaiSach;

	/**
	 * Create the panel.
	 */
	public Sach_GUI() {

		// connect
		ConnectDB.getInstance();
		ConnectDB.getConnection();

		setLayout(null);
		// Khai bao DAO
		sach_DAO = new Sach_DAO();
		loaiSach_DAO = new LoaiSach_DAO();
		JPanel mMain = new JPanel();

		mMain.setBackground(new Color(77, 77, 77));
		mMain.setBounds(10, 10, 1162, 667);
		add(mMain);
		mMain.setLayout(null);

		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setBounds(10, 53, 1128, 212);
		pNhapThongTin.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)),
				"Th\u00F4ng tin chi ti\u1EBFt:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		mMain.add(pNhapThongTin);
		pNhapThongTin.setLayout(null);

		lblMaSach = new JLabel("Mã Sách:");
		lblMaSach.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaSach.setBounds(49, 30, 90, 33);
		pNhapThongTin.add(lblMaSach);

		txtMaSach = new JTextField();
		txtMaSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaSach.setColumns(10);
		txtMaSach.setBounds(161, 30, 297, 33);
		txtMaSach.setEditable(false);
		pNhapThongTin.add(txtMaSach);

		txtTenSach = new JTextField();
		txtTenSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(161, 73, 297, 33);
		pNhapThongTin.add(txtTenSach);

		lblTenSach = new JLabel("Tên Sách:");
		lblTenSach.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenSach.setBounds(49, 73, 90, 33);
		pNhapThongTin.add(lblTenSach);

		lblMaNXB = new JLabel("Nhà Xuất Bản:");
		lblMaNXB.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaNXB.setBounds(49, 116, 121, 33);
		pNhapThongTin.add(lblMaNXB);

		txtMaNXB = new JTextField();
		txtMaNXB.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaNXB.setColumns(10);
		txtMaNXB.setBounds(161, 116, 297, 33);
		pNhapThongTin.add(txtMaNXB);

		lblGia = new JLabel("Giá:");
		lblGia.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGia.setBounds(651, 116, 121, 33);
		pNhapThongTin.add(lblGia);

		lblXuatXu = new JLabel("Xuất Xứ:");
		lblXuatXu.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblXuatXu.setBounds(651, 73, 124, 33);
		pNhapThongTin.add(lblXuatXu);

		lbMaLoaiSach = new JLabel("Mã Loại Sách:");
		lbMaLoaiSach.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbMaLoaiSach.setBounds(651, 30, 111, 33);
		pNhapThongTin.add(lbMaLoaiSach);

//		JTextField txtxuatXu = new JTextField();
//		txtxuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
//		txtxuatXu.setColumns(10);
//		txtxuatXu.setBounds(756, 73, 320, 33);
//		pNhapThongTin.add(txtxuatXu);

		txtGia = new JTextField();
		txtGia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtGia.setColumns(10);
		txtGia.setBounds(756, 116, 320, 33);
		pNhapThongTin.add(txtGia);

		cbMaLoaiSach = new JComboBox<String>();
		cbMaLoaiSach.addItem("");
		loadDataIntoCombobox();
		cbMaLoaiSach.setBounds(756, 30, 320, 33);
		pNhapThongTin.add(cbMaLoaiSach);

		txtXuatXu = new JTextField();
		txtXuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtXuatXu.setColumns(10);
		txtXuatXu.setBounds(756, 73, 320, 33);
		pNhapThongTin.add(txtXuatXu);

		lblTacGia = new JLabel("Tác giả:");
		lblTacGia.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTacGia.setBounds(49, 159, 121, 33);
		pNhapThongTin.add(lblTacGia);

		txtTacGia = new JTextField();
		txtTacGia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(161, 159, 297, 33);
		pNhapThongTin.add(txtTacGia);

		lblSoTrang = new JLabel("Số trang:");
		lblSoTrang.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoTrang.setBounds(651, 159, 121, 33);
		pNhapThongTin.add(lblSoTrang);

		txtSoTrang = new JTextField();
		txtSoTrang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoTrang.setColumns(10);
		txtSoTrang.setBounds(756, 159, 320, 33);
		pNhapThongTin.add(txtSoTrang);

		JLabel lblTim = new JLabel("Tìm kiếm:");
		lblTim.setForeground(new Color(255, 255, 255));
		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(130, 9, 96, 33);
		mMain.add(lblTim);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(234, 10, 425, 33);
		mMain.add(txtTimKiem);

		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(669, 10, 246, 33);
		mMain.add(cbTim);

		JPanel pnDanhSach = new JPanel();
		pnDanhSach.setBounds(10, 275, 1128, 382);
		mMain.add(pnDanhSach);
		pnDanhSach.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)), "Danh sách:", // 162,
																													// 197
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		pnDanhSach.setLayout(null);

		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(925, 10, 114, 33);
		mMain.add(btnNewButton);
		scrollPaneSach = new JScrollPane();
		scrollPaneSach.setBounds(10, 22, 1108, 350);
		scrollPaneSach.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneSach.setBorder(new LineBorder(new Color(0, 162, 197), 1, true));
		scrollPaneSach.setBackground(new Color(0, 162, 197));
		pnDanhSach.add(scrollPaneSach);

		// Tạo một DefaultTableModel với các cột
		String cols[] = { "Mã Sách", "Mã NXB", "Mã Loại Sách ", "Tên Sách", "Xuất Xứ", "Tác Giả", "Số Trang", "Giá" };
		model = new DefaultTableModel(cols, 0);
		
		// Tạo một JTable và gắn model vào nó
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
				txtMaSach.setText((String) model.getValueAt(row, 0));
				txtMaNXB.setText((String) model.getValueAt(row, 1));
				cbMaLoaiSach.setSelectedItem((String) model.getValueAt(row, 2));
				txtTenSach.setText((String) model.getValueAt(row, 3));
				txtXuatXu.setText((String) model.getValueAt(row, 4));
				txtTacGia.setText((String) model.getValueAt(row, 5));
				txtSoTrang.setText(model.getValueAt(row, 6) + "");
				txtGia.setText(model.getValueAt(row, 7) + "");
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

	public Sach_GUI(NhanVien nhanVien) {

		// connect
		ConnectDB.getInstance();
		ConnectDB.getConnection();

		setLayout(null);
		// Khai bao DAO
		sach_DAO = new Sach_DAO();
		loaiSach_DAO = new LoaiSach_DAO();
		JPanel mMain = new JPanel();

		mMain.setBackground(new Color(77, 77, 77));
		mMain.setBounds(10, 10, 1162, 667);
		add(mMain);
		mMain.setLayout(null);

		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setBounds(10, 53, 1128, 203);
		pNhapThongTin.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)),
				"Th\u00F4ng tin chi ti\u1EBFt:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		mMain.add(pNhapThongTin);
		pNhapThongTin.setLayout(null);

		lblMaSach = new JLabel("Mã Sách:");
		lblMaSach.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaSach.setBounds(49, 30, 90, 33);
		pNhapThongTin.add(lblMaSach);

		txtMaSach = new JTextField();
		txtMaSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaSach.setColumns(10);
		txtMaSach.setBounds(161, 30, 297, 33);
		txtMaSach.setEditable(false);
		pNhapThongTin.add(txtMaSach);

		txtTenSach = new JTextField();
		txtTenSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(161, 73, 297, 33);
		pNhapThongTin.add(txtTenSach);

		lblTenSach = new JLabel("Tên Sách:");
		lblTenSach.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenSach.setBounds(49, 73, 90, 33);
		pNhapThongTin.add(lblTenSach);

		lblMaNXB = new JLabel("Nhà Xuất Bản:");
		lblMaNXB.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaNXB.setBounds(49, 116, 121, 33);
		pNhapThongTin.add(lblMaNXB);

		txtMaNXB = new JTextField();
		txtMaNXB.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaNXB.setColumns(10);
		txtMaNXB.setBounds(161, 116, 297, 33);
		pNhapThongTin.add(txtMaNXB);

		lblGia = new JLabel("Giá:");
		lblGia.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGia.setBounds(651, 116, 121, 33);
		pNhapThongTin.add(lblGia);

		lblXuatXu = new JLabel("Xuất Xứ:");
		lblXuatXu.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblXuatXu.setBounds(651, 73, 124, 33);
		pNhapThongTin.add(lblXuatXu);

		lbMaLoaiSach = new JLabel("Mã Loại Sách:");
		lbMaLoaiSach.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbMaLoaiSach.setBounds(651, 30, 111, 33);
		pNhapThongTin.add(lbMaLoaiSach);

//		JTextField txtxuatXu = new JTextField();
//		txtxuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
//		txtxuatXu.setColumns(10);
//		txtxuatXu.setBounds(756, 73, 320, 33);
//		pNhapThongTin.add(txtxuatXu);

		txtGia = new JTextField();
		txtGia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtGia.setColumns(10);
		txtGia.setBounds(756, 116, 320, 33);
		pNhapThongTin.add(txtGia);

		Component verticalStrut = Box.createVerticalStrut(10);
		verticalStrut.setBounds(203, 63, 840, -7);
		pNhapThongTin.add(verticalStrut);

		cbMaLoaiSach = new JComboBox<String>();
		cbMaLoaiSach.addItem("");
		loadDataIntoCombobox();
		cbMaLoaiSach.setBounds(756, 30, 320, 33);
		pNhapThongTin.add(cbMaLoaiSach);

		txtXuatXu = new JTextField();
		txtXuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtXuatXu.setColumns(10);
		txtXuatXu.setBounds(756, 73, 320, 33);
		pNhapThongTin.add(txtXuatXu);

		lblTacGia = new JLabel("Tác giả:");
		lblTacGia.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTacGia.setBounds(49, 159, 121, 33);
		pNhapThongTin.add(lblTacGia);

		txtTacGia = new JTextField();
		txtTacGia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(161, 159, 297, 33);
		pNhapThongTin.add(txtTacGia);

		lblSoTrang = new JLabel("Số trang:");
		lblSoTrang.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoTrang.setBounds(651, 159, 121, 33);
		pNhapThongTin.add(lblSoTrang);

		txtSoTrang = new JTextField();
		txtSoTrang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoTrang.setColumns(10);
		txtSoTrang.setBounds(756, 159, 320, 33);
		pNhapThongTin.add(txtSoTrang);

		JLabel lblTim = new JLabel("Tìm kiếm:");
		lblTim.setForeground(new Color(255, 255, 255));
		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(130, 9, 96, 33);
		mMain.add(lblTim);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(234, 10, 425, 33);
		mMain.add(txtTimKiem);

		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(669, 10, 246, 33);
		mMain.add(cbTim);

		JPanel pnChucNang = new JPanel();
		pnChucNang.setBounds(10, 266, 1128, 62);
		mMain.add(pnChucNang);
		pnChucNang.setLayout(null);
		pnChucNang.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)), // 162,
																														// 197
						"Ch\u1EE9c n\u0103ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));

		JButton btnThemSach = new JButton("Thêm Sách");
		btnThemSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemSach.setBounds(93, 14, 121, 34);
		pnChucNang.add(btnThemSach);

		JButton btnXoaSach = new JButton("Xóa Sách");
		btnXoaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaSach.setBounds(307, 14, 121, 34);
		pnChucNang.add(btnXoaSach);

		JButton btnSua = new JButton("Sửa Thông Tin");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(521, 14, 129, 34);
		pnChucNang.add(btnSua);

		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaTrang.setBounds(743, 14, 121, 34);
		btnXoaTrang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xoaTrang();
			}
		});
		pnChucNang.add(btnXoaTrang);
		

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThoat.setBounds(957, 14, 107, 34);
		pnChucNang.add(btnThoat);

		JPanel pnDanhSach = new JPanel();
		pnDanhSach.setBounds(10, 338, 1128, 319);
		mMain.add(pnDanhSach);
		pnDanhSach.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)), "Danh sách:", // 162,
																													// 197
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		pnDanhSach.setLayout(null);

		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(925, 9, 114, 33);
		mMain.add(btnNewButton);
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		scrollPaneSach = new JScrollPane();
		scrollPaneSach.setBounds(10, 22, 1108, 322);
		scrollPaneSach.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneSach.setBorder(new LineBorder(new Color(0, 162, 197), 1, true));
		scrollPaneSach.setBackground(new Color(0, 162, 197));
		pnDanhSach.add(scrollPaneSach);

		String cols[] = { "Mã Sách", "Mã NXB", "Mã Loại Sách ", "Tên Sách", "Xuất Xứ", "Tác Giả", "Số Trang", "Giá" };
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
				txtMaSach.setText((String) model.getValueAt(row, 0));
				txtMaNXB.setText((String) model.getValueAt(row, 1));
				cbMaLoaiSach.setSelectedItem((String) model.getValueAt(row, 2));
				txtTenSach.setText((String) model.getValueAt(row, 3));
				txtXuatXu.setText((String) model.getValueAt(row, 4));
				txtTacGia.setText((String) model.getValueAt(row, 5));
				txtSoTrang.setText(model.getValueAt(row, 6) + "");
				txtGia.setText(model.getValueAt(row, 7) + "");
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

	// Đổ DL vào table Sách
	public void loadDataIntoTable() {
		model.setRowCount(0);
		for (Sach sach : sach_DAO.getAllListSach()) {
			Object[] objects = { sach.getMaSach(), sach.getMaNXB(), sach.getMaLoaiSach(), sach.getTenSach(),
					sach.getXuatXu(), sach.getTacGia(), sach.getSoTrang(), sach.getGia() };
			model.addRow(objects);
			model.fireTableDataChanged();
		}
	}

	// Đổ DL vào comboBox Mã Loại Sách
	public void loadDataIntoCombobox() {
		for (LoaiSach loaiSach : loaiSach_DAO.getAllListLoaiSach()) {
			cbMaLoaiSach.addItem(loaiSach.getMaLoaiSach());
<<<<<<< HEAD
		}		
=======
		}
>>>>>>> 4f8d0be0bfb3ccd206da3bda690301f6862cb08a
	}
	 public void xoaTrang() {
	        txtMaSach.setText("");
	        txtTenSach.setText("");
	        txtMaNXB.setText("");
	        cbMaLoaiSach.setSelectedItem(""); // Set the selected item to an empty string
	        txtXuatXu.setText("");
	        txtTacGia.setText("");
	        txtSoTrang.setText("");
	        txtGia.setText("");
	    }
}
