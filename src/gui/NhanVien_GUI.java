package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.NhanVien_DAO;
import entity.NhanVien;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class NhanVien_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTim;
	private JDateChooser dateChooserNgaySinh;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtCCCD;
	private JTextField txtEmail;
	private Date dateNow;
	private DefaultTableModel model;
	private JTable table;
	private JTableHeader tableHeader;
	private NhanVien_DAO nhanVien_DAO;
	private SimpleDateFormat simpleDateFormat;
	private JComboBox<String> cbGioiTinh;
	private JComboBox<String> cbChucVu;
	private JTextField txtLuong;

	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public NhanVien_GUI() throws SQLException {
		// connect
		ConnectDB.getInstance();
		ConnectDB.connect();

		// khai bao DAO
		nhanVien_DAO = new NhanVien_DAO();
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		setLayout(null);
		JPanel pMain = new JPanel();
		pMain.setBackground(new Color(77, 77, 77));
		pMain.setBounds(0, 0, 1162, 667);
		add(pMain);
		pMain.setLayout(null);

		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setBounds(10, 53, 1142, 219);
		pNhapThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "Th\u00F4ng tin:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pMain.add(pNhapThongTin);
		pNhapThongTin.setLayout(null);

		JLabel lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaNV.setBounds(39, 30, 90, 33);
		pNhapThongTin.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(119, 30, 151, 33);
		txtMaNV.setEditable(false);
		pNhapThongTin.add(txtMaNV);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(119, 116, 151, 33);
		pNhapThongTin.add(txtTenNV);

		JLabel lblTenNV = new JLabel("Tên NV:");
		lblTenNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenNV.setBounds(39, 116, 90, 33);
		pNhapThongTin.add(lblTenNV);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDiaChi.setBounds(291, 116, 90, 33);
		pNhapThongTin.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(406, 116, 163, 33);
		pNhapThongTin.add(txtDiaChi);

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

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(710, 73, 149, 33);
		pNhapThongTin.add(txtSoDienThoai);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbGioiTinh.setBounds(406, 30, 163, 33);
		cbGioiTinh.addItem("");
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
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

		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(710, 30, 149, 33);
		pNhapThongTin.add(txtCCCD);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(710, 116, 149, 33);
		pNhapThongTin.add(txtEmail);

		cbChucVu = new JComboBox<String>();
		cbChucVu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbChucVu.setBounds(959, 30, 146, 33);
		cbChucVu.addItem("");
		cbChucVu.addItem("Bán hàng");
		cbChucVu.addItem("Nhập hàng");
		cbChucVu.addItem("Quản trị hệ thống");
		pNhapThongTin.add(cbChucVu);

		txtTim = new JTextField();
		txtTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTim.setBounds(409, 10, 257, 33);
		pMain.add(txtTim);
		txtTim.setColumns(10);

		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(782, 10, 114, 33);
		pMain.add(btnNewButton);

		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(676, 10, 96, 33);
		cbTim.addItem("Tên NV");
		cbTim.addItem("Mã NV");
		cbTim.addItem("SĐT");
		cbTim.addItem("CCCD");
		pMain.add(cbTim);

		JLabel lblTim = new JLabel("Tìm kiếm:");
		lblTim.setForeground(new Color(255, 255, 255));
		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(303, 10, 96, 33);
		pMain.add(lblTim);
		
		JPanel pDanhSach = new JPanel();
		pDanhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "Danh s\u00E1ch:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pDanhSach.setBounds(10, 282, 1142, 375);
		pMain.add(pDanhSach);
		pDanhSach.setLayout(null);
		
		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(10, 20, 1122, 345);
		scrollPaneNV.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneNV.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneNV.setBackground(new Color(80, 80, 80));
		pDanhSach.add(scrollPaneNV);
	
		String cols[] = {"Mã NV", "Mã CH", "Tên NV", "Địa chỉ","Giới tính","Ngày sinh","Ngày vào làm","CCCD","Email","SĐT","Chức vụ","Lương"};
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
				txtMaNV.setText((String) model.getValueAt(row, 0));
				txtTenNV.setText((String) model.getValueAt(row, 2));
				txtDiaChi.setText((String) model.getValueAt(row, 3));
				try {
					dateChooserNgaySinh.setDate(
							new java.sql.Date(simpleDateFormat.parse((String) model.getValueAt(row, 5)).getTime()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtSoDienThoai.setText((String) model.getValueAt(row, 9));
				txtCCCD.setText((String) model.getValueAt(row, 7));
				txtEmail.setText((String) model.getValueAt(row, 8));
				txtLuong.setText(model.getValueAt(row, 11).toString());
				if (model.getValueAt(row, 10).toString().equalsIgnoreCase("Bán hàng"))
					cbChucVu.setSelectedIndex(1);
				else if (model.getValueAt(row, 10).toString().equalsIgnoreCase("Nhập hàng"))
					cbChucVu.setSelectedIndex(2);
				else if (model.getValueAt(row, 10).toString().equalsIgnoreCase("Quản trị hệ thống"))
					cbChucVu.setSelectedIndex(3);
				else
					cbChucVu.setSelectedIndex(0);
				if (model.getValueAt(row, 4).toString().equalsIgnoreCase("Nam"))
					cbGioiTinh.setSelectedIndex(1);
				else if (model.getValueAt(row, 4).toString().equalsIgnoreCase("Nữ"))
					cbGioiTinh.setSelectedIndex(2);
				else
					cbGioiTinh.setSelectedIndex(0);
			}
		});
		scrollPaneNV.setViewportView(table);
		
		// header of table
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(46, 46, 46));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		// set width of table
		table.getColumnModel().getColumn(0).setPreferredWidth(102);
		table.getColumnModel().getColumn(1).setPreferredWidth(102);
		table.getColumnModel().getColumn(2).setPreferredWidth(102);
		table.getColumnModel().getColumn(3).setPreferredWidth(102);
		table.getColumnModel().getColumn(4).setPreferredWidth(102);
		table.getColumnModel().getColumn(5).setPreferredWidth(102);
		table.getColumnModel().getColumn(6).setPreferredWidth(102);
		table.getColumnModel().getColumn(7).setPreferredWidth(102);
		table.getColumnModel().getColumn(8).setPreferredWidth(102);
		table.getColumnModel().getColumn(9).setPreferredWidth(102);
		table.getColumnModel().getColumn(10).setPreferredWidth(102);
		table.getColumnModel().getColumn(11).setPreferredWidth(102);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.setBounds(406, 73, 163, 33);
		pNhapThongTin.add(dateChooserNgaySinh);
		dateChooserNgaySinh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateChooserNgaySinh.setBorder(new LineBorder(new Color(28, 28, 28), 1, true));
		dateChooserNgaySinh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		dateChooserNgaySinh.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserNgaySinh.getCalendarButton().setBackground(new Color(46, 46, 46));
		dateNow = new Date(new java.util.Date().getTime());
		dateChooserNgaySinh.setDate(dateNow);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(142, 167, 108, 33);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		pNhapThongTin.add(btnAdd);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(392, 167, 108, 33);
		pNhapThongTin.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(642, 167, 108, 33);
		pNhapThongTin.add(btnSua);
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setBounds(892, 167, 108, 33);
		btnXoaTrang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xoaTrang();
			}
		});
		pNhapThongTin.add(btnXoaTrang);
		
		JLabel lblMaCH = new JLabel("Mã CH:");
		lblMaCH.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaCH.setBounds(39, 73, 90, 33);
		pNhapThongTin.add(lblMaCH);
		
		JComboBox<String> cbMaCH = new JComboBox<String>();
		cbMaCH.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbMaCH.setBounds(119, 73, 151, 33);
		pNhapThongTin.add(cbMaCH);
		
		JLabel lblLuong = new JLabel("Lương:");
		lblLuong.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLuong.setBounds(879, 73, 56, 33);
		pNhapThongTin.add(lblLuong);
		
		txtLuong = new JTextField();
		txtLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtLuong.setColumns(10);
		txtLuong.setBounds(959, 73, 146, 33);
		pNhapThongTin.add(txtLuong);

		// loadData
		loadDataIntoTable();
	}

	public void loadDataIntoTable() {
		for (NhanVien nhanVien : nhanVien_DAO.getAllListNhanVien()) {
			Object[] objects = {nhanVien.getMaNV(), nhanVien.getMaCH(), nhanVien.getTenNV(), nhanVien.getDiaChi(), nhanVien.getGioiTinh(), simpleDateFormat.format(nhanVien.getNgaySinh()), simpleDateFormat.format(nhanVien.getNgayVaoLam()), nhanVien.getCCCD(), nhanVien.getEmail(), nhanVien.getSoDienThoai(), nhanVien.getChucVu(), nhanVien.getLuong()};
			model.addRow(objects);
		}
	}
	
	public void xoaTrang() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtDiaChi.setText("");
		dateChooserNgaySinh.setDate(null);
		txtSoDienThoai.setText("");
		cbGioiTinh.setSelectedIndex(0);
		txtCCCD.setText("");
		txtEmail.setText("");
		cbChucVu.setSelectedIndex(0);
	}
}
