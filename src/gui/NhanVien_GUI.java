package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import dao.CuaHang_DAO;
import dao.NhanVien_DAO;
import dao.PhatSinhMa_DAO;
import dao.TaiKhoan_DAO;
import entity.CuaHang;
import entity.NhanVien;
import entity.TaiKhoan;

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
	private DefaultTableModel model;
	private JTable table;
	private JTableHeader tableHeader;
	private NhanVien_DAO nhanVien_DAO;
	private CuaHang_DAO cuaHang_DAO;
	private PhatSinhMa_DAO phatSinhMa_DAO;
	private TaiKhoan_DAO taiKhoan_DAO;
	private SimpleDateFormat simpleDateFormat;
	private JComboBox<String> cbGioiTinh;
	private JComboBox<String> cbChucVu;
	private JComboBox<String> cbMaCH;
	private JComboBox<String> cbTim;
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
		cuaHang_DAO = new CuaHang_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();
		taiKhoan_DAO = new TaiKhoan_DAO();
		
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		setLayout(null);
		JPanel pMain = new JPanel();
		pMain.setBackground(new Color(77, 77, 77));
		pMain.setBounds(0, 0, 1162, 667);
		add(pMain);
		pMain.setLayout(null);

		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setBounds(10, 53, 1142, 219);
		pNhapThongTin.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)),
				"Th\u00F4ng tin:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pMain.add(pNhapThongTin);
		pNhapThongTin.setLayout(null);

		JLabel lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaNV.setBounds(40, 30, 90, 33);
		pNhapThongTin.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(120, 30, 160, 33);
		txtMaNV.setEditable(false);
		txtMaNV.setFocusable(false);
		pNhapThongTin.add(txtMaNV);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(120, 110, 160, 33);
		pNhapThongTin.add(txtTenNV);

		JLabel lblTenNV = new JLabel("Tên NV:");
		lblTenNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenNV.setBounds(40, 110, 90, 33);
		pNhapThongTin.add(lblTenNV);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDiaChi.setBounds(295, 110, 90, 33);
		pNhapThongTin.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(400, 110, 160, 33);
		pNhapThongTin.add(txtDiaChi);

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGioiTinh.setBounds(295, 30, 90, 33);
		pNhapThongTin.add(lblGioiTinh);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoDienThoai.setBounds(600, 70, 103, 33);
		pNhapThongTin.add(lblSoDienThoai);

		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNgaySinh.setBounds(295, 70, 90, 33);
		pNhapThongTin.add(lblNgaySinh);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(710, 70, 160, 33);
		pNhapThongTin.add(txtSoDienThoai);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbGioiTinh.setBounds(400, 30, 160, 33);
		cbGioiTinh.addItem("");
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		pNhapThongTin.add(cbGioiTinh);

		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblChucVu.setBounds(880, 30, 70, 33);
		pNhapThongTin.add(lblChucVu);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmail.setBounds(600, 110, 56, 33);
		pNhapThongTin.add(lblEmail);

		JLabel lblCCCD = new JLabel("CCCD:");
		lblCCCD.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCCCD.setBounds(600, 30, 62, 33);
		pNhapThongTin.add(lblCCCD);

		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(710, 30, 160, 33);
		pNhapThongTin.add(txtCCCD);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(710, 110, 410, 33);
		pNhapThongTin.add(txtEmail);

		cbChucVu = new JComboBox<String>();
		cbChucVu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbChucVu.setBounds(960, 30, 160, 33);
		cbChucVu.addItem("");
		cbChucVu.addItem("Bán hàng");
		cbChucVu.addItem("Nhập hàng");
		cbChucVu.addItem("Quản trị hệ thống");
		pNhapThongTin.add(cbChucVu);

		txtTim = new JTextField();
		txtTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTim.setBounds(375, 10, 255, 33);
		pMain.add(txtTim);
		txtTim.setColumns(10);

		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBounds(745, 10, 95, 33);
		btnTim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cbTim.getSelectedItem().equals("Mã NV")) {
					model.setRowCount(0);
					NhanVien nhanVien = nhanVien_DAO.getNhanVienTheoMa(txtTim.getText());
					Object[] objects = { nhanVien.getMaNV(), nhanVien.getMaCH(), nhanVien.getTenNV(), nhanVien.getDiaChi(),
							nhanVien.getGioiTinh(), simpleDateFormat.format(nhanVien.getNgaySinh()),
							simpleDateFormat.format(nhanVien.getNgayVaoLam()), nhanVien.getCCCD(), nhanVien.getEmail(),
							nhanVien.getSoDienThoai(), nhanVien.getChucVu(), nhanVien.getLuong() };
					model.addRow(objects);
				}
				else if (cbTim.getSelectedItem().equals("Tên NV")) {
					model.setRowCount(0);
					for (NhanVien nhanVien : nhanVien_DAO.getNhanVienTheoTen(txtTim.getText())) {
						Object[] objects = { nhanVien.getMaNV(), nhanVien.getMaCH(), nhanVien.getTenNV(), nhanVien.getDiaChi(),
								nhanVien.getGioiTinh(), simpleDateFormat.format(nhanVien.getNgaySinh()),
								simpleDateFormat.format(nhanVien.getNgayVaoLam()), nhanVien.getCCCD(), nhanVien.getEmail(),
								nhanVien.getSoDienThoai(), nhanVien.getChucVu(), nhanVien.getLuong() };
						model.addRow(objects);
					}
				}
				else if (cbTim.getSelectedItem().equals("SĐT")) {
					
				}
				else {
					
				}
			}
		});
		pMain.add(btnTim);

		cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(640, 10, 95, 33);
		cbTim.addItem("Tên NV");
		cbTim.addItem("Mã NV");
		cbTim.addItem("SĐT");
		cbTim.addItem("CCCD");
		pMain.add(cbTim);

		JLabel lblTim = new JLabel("Tìm kiếm:");
		lblTim.setForeground(new Color(255, 255, 255));
		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(270, 10, 96, 33);
		pMain.add(lblTim);

		JPanel pDanhSach = new JPanel();
		pDanhSach.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)),
				"Danh s\u00E1ch:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pDanhSach.setBounds(10, 282, 1142, 375);
		pMain.add(pDanhSach);
		pDanhSach.setLayout(null);

		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(10, 20, 1122, 335);
		scrollPaneNV.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneNV.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneNV.setBackground(new Color(80, 80, 80));
		pDanhSach.add(scrollPaneNV);

		String cols[] = { "Mã NV", "Mã CH", "Tên NV", "Địa chỉ", "Giới tính", "Ngày sinh", "Ngày vào làm", "CCCD",
				"Email", "SĐT", "Chức vụ", "Lương" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
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
				cbMaCH.setSelectedItem(model.getValueAt(row, 1));
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
		dateChooserNgaySinh.setBounds(400, 70, 160, 33);
		pNhapThongTin.add(dateChooserNgaySinh);
		dateChooserNgaySinh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateChooserNgaySinh.setBorder(new LineBorder(new Color(28, 28, 28), 1, true));
		dateChooserNgaySinh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		dateChooserNgaySinh.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserNgaySinh.getCalendarButton().setBackground(new Color(46, 46, 46));

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBounds(132, 165, 120, 33);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				add();
			}
		});
		pNhapThongTin.add(btnAdd);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBounds(384, 165, 120, 33);
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				delete();
			}
		});
		pNhapThongTin.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSua.setBounds(636, 165, 120, 33);
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				update();
			}
		});
		pNhapThongTin.add(btnSua);

		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoaTrang.setBounds(888, 165, 120, 33);
		btnXoaTrang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeInfo();
			}
		});
		pNhapThongTin.add(btnXoaTrang);

		JLabel lblMaCH = new JLabel("Mã CH:");
		lblMaCH.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaCH.setBounds(40, 70, 90, 33);
		pNhapThongTin.add(lblMaCH);

		cbMaCH = new JComboBox<String>();
		cbMaCH.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbMaCH.setBounds(120, 70, 160, 33);
		cbMaCH.addItem("");
		pNhapThongTin.add(cbMaCH);

		JLabel lblLuong = new JLabel("Lương:");
		lblLuong.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLuong.setBounds(880, 70, 56, 33);
		pNhapThongTin.add(lblLuong);

		txtLuong = new JTextField();
		txtLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtLuong.setColumns(10);
		txtLuong.setBounds(960, 70, 160, 33);
		pNhapThongTin.add(txtLuong);

		// loadData
		loadDataIntoTable();
		loadDataComboboxCuaHang();
	}

	public void loadDataIntoTable() {
		model.setRowCount(0);
		for (NhanVien nhanVien : nhanVien_DAO.getAllListNhanVien()) {
			Object[] objects = { nhanVien.getMaNV(), nhanVien.getMaCH(), nhanVien.getTenNV(), nhanVien.getDiaChi(),
					nhanVien.getGioiTinh(), simpleDateFormat.format(nhanVien.getNgaySinh()),
					simpleDateFormat.format(nhanVien.getNgayVaoLam()), nhanVien.getCCCD(), nhanVien.getEmail(),
					nhanVien.getSoDienThoai(), nhanVien.getChucVu(), nhanVien.getLuong() };
			model.addRow(objects);
		}
	}
	
	public void loadDataComboboxCuaHang() {
		for (CuaHang cuaHang : cuaHang_DAO.getAllCuaHang()) {
			cbMaCH.addItem(cuaHang.getMaCH());
		}
	}
	
	public void refresh() {
		loadDataIntoTable();
	}

	public void removeInfo() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtDiaChi.setText("");
		dateChooserNgaySinh.setDate(null);
		txtSoDienThoai.setText("");
		cbGioiTinh.setSelectedIndex(0);
		txtCCCD.setText("");
		txtEmail.setText("");
		cbChucVu.setSelectedIndex(0);
		cbMaCH.setSelectedIndex(0);
		txtLuong.setText("");
	}
	
	public boolean add() {
		if (cbMaCH.getSelectedItem().equals("") ||
			txtTenNV.getText().equals("") ||
			cbGioiTinh.getSelectedItem().equals("") ||
			dateChooserNgaySinh.equals(null) ||
			txtDiaChi.getText().equals("") ||
			txtCCCD.getText().equals("") ||
			txtSoDienThoai.getText().equals("") ||
			txtEmail.getText().equals("") ||
			cbChucVu.getSelectedItem().equals("") ||
			txtLuong.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Phải điền đầy đủ thông tin!");
			return false;
		}
		else {
			try {
				// Thêm tài khoản mới cho nhân viên mới
				TaiKhoan taiKhoan = new TaiKhoan();
				String taiKhoanString = phatSinhMa_DAO.getMaTaiKhoan();
				taiKhoan.setTaiKhoan(taiKhoanString);
				taiKhoan.setMatKhau(taiKhoanString);
				taiKhoan_DAO.themTaiKhoan(taiKhoan);
				
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNV(phatSinhMa_DAO.getMaNhanVien());
				nhanVien.setMaCH(cbMaCH.getSelectedItem().toString());
				nhanVien.setTenNV(txtTenNV.getText());
				nhanVien.setDiaChi(txtDiaChi.getText());
				nhanVien.setGioiTinh(cbGioiTinh.getSelectedItem().toString());
				nhanVien.setNgaySinh(new Date(dateChooserNgaySinh.getDate().getTime()));
				nhanVien.setNgayVaoLam(new Date(new java.util.Date().getTime()));
				nhanVien.setCCCD(txtCCCD.getText());
				nhanVien.setEmail(txtEmail.getText());
				nhanVien.setSoDienThoai(txtSoDienThoai.getText());
				nhanVien.setChucVu(cbChucVu.getSelectedItem().toString());
				nhanVien.setTaiKhoan(taiKhoan);
				nhanVien.setLuong(Integer.parseInt(txtLuong.getText()));
				nhanVien_DAO.themNhanVien(nhanVien);
				JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");
				refresh();
				return true;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại!");
				e1.printStackTrace();
				return false;
			}
		}
		
	}
	
	public boolean delete() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showInternalMessageDialog(null, "Bạn phải chọn dòng cần xóa!");
			return false;
		}
		else {
			int option = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn xóa nhân viên '" + model.getValueAt(row, 0) + "' chứ?", "Xóa?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				try {
					String maTaiKhoan = nhanVien_DAO.getNhanVienTheoMa(model.getValueAt(row, 0).toString()).getTaiKhoan().getTaiKhoan();
					nhanVien_DAO.xoaNhanVienTheoMa(model.getValueAt(row, 0).toString());
					// Nếu xóa nhân viên thì xóa luôn tài khoản của nhân viên đó
					taiKhoan_DAO.xoaTaiKhoan(maTaiKhoan);
					JOptionPane.showMessageDialog(null,
							"Xóa thành công nhân viên '" + model.getValueAt(row, 0) + "'!");
					refresh();
					return true;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,
							"Xóa nhân viên '\" + model.getValueAt(row, 0) + \"' không thành công!");
					return false;
				}
			}
			else
				return false;
		}
	}
	
	public boolean update() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showInternalMessageDialog(null, "Bạn phải chọn dòng cần sửa!");
			return false;
		}
		else {
			int option = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn sửa nhân viên '" + model.getValueAt(row, 0) + "' chứ?", "Xóa?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				try {
					TaiKhoan taiKhoan = nhanVien_DAO.getNhanVienTheoMa(model.getValueAt(row, 0).toString()).getTaiKhoan();
					Date ngayVaoLam = nhanVien_DAO.getNhanVienTheoMa(model.getValueAt(row, 0).toString()).getNgayVaoLam();
					NhanVien nhanVien = new NhanVien(txtMaNV.getText(), cbMaCH.getSelectedItem().toString(), txtTenNV.getText(), txtDiaChi.getText(), cbGioiTinh.getSelectedItem().toString(), new Date(dateChooserNgaySinh.getDate().getTime()), ngayVaoLam, txtCCCD.getText(), txtEmail.getText(), txtSoDienThoai.getText(), cbChucVu.getSelectedItem().toString(), taiKhoan, Integer.parseInt(txtLuong.getText()));
					nhanVien_DAO.suaNhanVienTheoMa(nhanVien);
					JOptionPane.showMessageDialog(null,
							"Sửa thành công nhân viên '" + model.getValueAt(row, 0) + "'!");
					refresh();
					return true;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,
							"Sửa nhân viên '\" + model.getValueAt(row, 0) + \"' không thành công!");
					return false;
				}
			}
			else {
				return false;
			}
		}
	}
}
