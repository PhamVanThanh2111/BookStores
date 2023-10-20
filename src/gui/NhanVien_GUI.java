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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.NhanVien_DAO;
import dao.PhatSinhMa_DAO;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class NhanVien_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDateChooser dateChooserNgaySinh;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtcCCD;
	private JTextField txtEmail;
	private DefaultTableModel model;
	private JTable table;
	private JTableHeader tableHeader;
	private NhanVien_DAO nhanVien_DAO;
	private PhatSinhMa_DAO phatSinhMa_DAO;
	private TaiKhoan_DAO taiKhoan_DAO;
	private SimpleDateFormat simpleDateFormat;
	private JComboBox<String> cbGioiTinh;
	private JComboBox<String> cbCa;
	private JTextField txtLuong;
	private JComboBox<String> cbChucVu;
	private JTextField txtTenNhanVien;
	private JLabel lblHinhAnh;
	private JLabel lblMaNhanVienValue;
	private JLabel lblChucVu;
	private JButton btnChonHinhAnh;

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
		phatSinhMa_DAO = new PhatSinhMa_DAO();
		taiKhoan_DAO = new TaiKhoan_DAO();

		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		setLayout(null);
		JPanel pMain = new JPanel();
		pMain.setBackground(new Color(241, 245, 249));
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);
		pMain.setLayout(null);

		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setBackground(new Color(255, 255, 255));
		pNhapThongTin.setBounds(869, 0, 430, 720);
		pNhapThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pMain.add(pNhapThongTin);
		pNhapThongTin.setLayout(null);
		
		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBounds(20, 20, 64, 64);
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		pNhapThongTin.add(lblHinhAnh);

		txtDiaChi = new JTextField();
		txtDiaChi.setBackground(new Color(255, 255, 255));
		txtDiaChi.setEditable(false);
		txtDiaChi.setToolTipText("Địa chỉ");
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(170, 652, 240, 40);
		pNhapThongTin.add(txtDiaChi);

		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setToolTipText("Số điện thoại");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSoDienThoai.setBounds(40, 145, 120, 40);
		pNhapThongTin.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBackground(new Color(255, 255, 255));
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setToolTipText("Số điện thoại");
		txtSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(170, 145, 240, 40);
		pNhapThongTin.add(txtSoDienThoai);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setToolTipText("Giới tính");
		cbGioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbGioiTinh.setBounds(170, 607, 240, 40);
		cbGioiTinh.setBorder(null);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		pNhapThongTin.add(cbGioiTinh);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setToolTipText("Email");
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblEmail.setBounds(40, 190, 56, 40);
		pNhapThongTin.add(lblEmail);

		txtcCCD = new JTextField();
		txtcCCD.setBackground(new Color(255, 255, 255));
		txtcCCD.setEditable(false);
		txtcCCD.setToolTipText("Căn cước công dân");
		txtcCCD.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtcCCD.setColumns(10);
		txtcCCD.setBounds(170, 562, 240, 40);
		pNhapThongTin.add(txtcCCD);

		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(255, 255, 255));
		txtEmail.setEditable(false);
		txtEmail.setToolTipText("Email");
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(170, 190, 240, 40);
		pNhapThongTin.add(txtEmail);

		PanelRound pDanhSach = new PanelRound();
		pDanhSach.setBackground(new Color(255, 255, 255));
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBounds(0, 0, 850, 720);
		pDanhSach.setRoundTopLeft(16);
		pMain.add(pDanhSach);
		pDanhSach.setLayout(null);

		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(20, 82, 810, 557);
		scrollPaneNV.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneNV.setBorder(null);
		scrollPaneNV.setBackground(new Color(255, 255, 255));
		pDanhSach.add(scrollPaneNV);

		String cols[] = { "Mã NV", "Họ Và Tên", "Giới Tính", "Ngày Vào Làm",
				"Số Điện Thoại", "Địa Chỉ" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		table.setRowHeight(30);
		table.setDefaultEditor(Object.class, null);
		table.setShowGrid(true);
		table.setShowHorizontalLines(true);
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(141,208,229));
		table.setSelectionForeground(new Color(0,0,0));
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
				txtDiaChi.setText((String) model.getValueAt(row, 2));
				try {
					dateChooserNgaySinh.setDate(
							new java.sql.Date(simpleDateFormat.parse((String) model.getValueAt(row, 4)).getTime()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtSoDienThoai.setText((String) model.getValueAt(row, 8));
				txtcCCD.setText((String) model.getValueAt(row, 6));
				txtEmail.setText((String) model.getValueAt(row, 7));
				txtLuong.setText(model.getValueAt(row, 10).toString());
				if (model.getValueAt(row, 3).toString().equalsIgnoreCase("Nam"))
					cbGioiTinh.setSelectedIndex(1);
				else if (model.getValueAt(row, 2).toString().equalsIgnoreCase("Nữ"))
					cbGioiTinh.setSelectedIndex(2);
				else
					cbGioiTinh.setSelectedIndex(0);
				cbCa.setSelectedItem(nhanVien_DAO.getNhanVienTheoMa((String) model.getValueAt(row, 0)).getCa());
			}
		});
		scrollPaneNV.setViewportView(table);

		// header of table
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

		
		// set width of table
//		table.getColumnModel().getColumn(0).setPreferredWidth(30);
//		table.getColumnModel().getColumn(1).setPreferredWidth(102);
//		table.getColumnModel().getColumn(2).setPreferredWidth(170);
//		table.getColumnModel().getColumn(3).setPreferredWidth(35);
//		table.getColumnModel().getColumn(4).setPreferredWidth(60);
//		table.getColumnModel().getColumn(5).setPreferredWidth(70);
//		table.getColumnModel().getColumn(6).setPreferredWidth(50);
//		table.getColumnModel().getColumn(7).setPreferredWidth(102);
//		table.getColumnModel().getColumn(8).setPreferredWidth(40);
//		table.getColumnModel().getColumn(9).setPreferredWidth(30);
//		table.getColumnModel().getColumn(10).setPreferredWidth(50);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
								
								JLabel lblThongTin = new JLabel("Nhân Viên");
								lblThongTin.setFont(new Font("Tahoma", Font.BOLD, 18));
								lblThongTin.setBounds(20, 40, 133, 32);
								pDanhSach.add(lblThongTin);
								
								JSeparator separator = new JSeparator();
								separator.setForeground(new Color(60, 60, 60));
								separator.setBounds(126, 56, 704, 2);
								pDanhSach.add(separator);
								
										JButton btnXoa = new JButton("Xóa");
										btnXoa.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/remove_person.png")));
										btnXoa.setBackground(new Color(73, 129, 158));
										btnXoa.setForeground(new Color(255, 255, 255));
										btnXoa.setBounds(395, 660, 135, 40);
										pDanhSach.add(btnXoa);
										btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
										
												JButton btnAdd = new JButton("Thêm");
												btnAdd.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/add_person.png")));
												btnAdd.setForeground(new Color(255, 255, 255));
												btnAdd.setBackground(new Color(73, 129, 158));
												btnAdd.setBounds(245, 660, 135, 40);
												btnAdd.setOpaque(true);
												pDanhSach.add(btnAdd);
												btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
												
														JButton btnSua = new JButton("Sửa");
														btnSua.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/update_person.png")));
														btnSua.setBackground(new Color(73, 129, 158));
														btnSua.setForeground(new Color(255, 255, 255));
														btnSua.setBounds(545, 660, 135, 40);
														pDanhSach.add(btnSua);
														btnSua.setFont(new Font("SansSerif", Font.BOLD, 14));
														
														JButton btnTim = new JButton("Tìm");
														btnTim.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/find_person.png")));
														btnTim.setBackground(new Color(73, 129, 158));
														btnTim.setForeground(new Color(255, 255, 255));
														btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
														btnTim.setBounds(695, 660, 135, 40);
														pDanhSach.add(btnTim);
														btnSua.addActionListener(new ActionListener() {

															@Override
															public void actionPerformed(ActionEvent e) {
																// TODO Auto-generated method stub
																update();
															}
														});
												btnAdd.addActionListener(new ActionListener() {

													@Override
													public void actionPerformed(ActionEvent e) {
														// TODO Auto-generated method stub
														add();
													}
												});
										btnXoa.addActionListener(new ActionListener() {

											@Override
											public void actionPerformed(ActionEvent e) {
												// TODO Auto-generated method stub
												delete();
											}
										});

		dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.setToolTipText("Ngày sinh");
		dateChooserNgaySinh.setBounds(170, 517, 240, 40);
		pNhapThongTin.add(dateChooserNgaySinh);
		dateChooserNgaySinh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateChooserNgaySinh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		dateChooserNgaySinh.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserNgaySinh.getCalendarButton().setBackground(new Color(46, 46, 46));
		dateChooserNgaySinh.setBorder(null);

		JLabel lblLuong = new JLabel("Lương:");
		lblLuong.setToolTipText("Lương");
		lblLuong.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLuong.setBounds(880, 70, 56, 33);
		pNhapThongTin.add(lblLuong);

		txtLuong = new JTextField();
		txtLuong.setToolTipText("Lương");
		txtLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtLuong.setColumns(10);
		txtLuong.setBounds(960, 70, 160, 33);
		pNhapThongTin.add(txtLuong);
		
		cbCa = new JComboBox<String>();
		cbCa.setToolTipText("Chức vụ");
		cbCa.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbCa.setBounds(170, 395, 240, 40);
		cbCa.addItem("01");
		cbCa.addItem("02");
		cbCa.setBorder(null);
		pNhapThongTin.add(cbCa);
		
		lblChucVu = new JLabel("Quản lý");
		lblChucVu.setToolTipText("Mã nhân viên");
		lblChucVu.setHorizontalAlignment(SwingConstants.LEFT);
		lblChucVu.setForeground(new Color(28, 28, 28));
		lblChucVu.setFont(new Font("SansSerif", Font.ITALIC, 20));
		lblChucVu.setBounds(94, 50, 177, 40);
		pNhapThongTin.add(lblChucVu);
		
		JLabel lblThongTinLienLac = new JLabel("Thông Tin Liên Lạc:");
		lblThongTinLienLac.setToolTipText("Mã nhân viên");
		lblThongTinLienLac.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinLienLac.setForeground(new Color(28, 28, 28));
		lblThongTinLienLac.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinLienLac.setBounds(20, 100, 189, 40);
		pNhapThongTin.add(lblThongTinLienLac);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(60, 60, 60));
		separator_1.setBounds(20, 245, 390, 2);
		pNhapThongTin.add(separator_1);
		
		JLabel lblThongTinViecLam = new JLabel("Thông Tin Việc Làm:");
		lblThongTinViecLam.setToolTipText("Mã nhân viên");
		lblThongTinViecLam.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinViecLam.setForeground(new Color(28, 28, 28));
		lblThongTinViecLam.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinViecLam.setBounds(20, 260, 189, 40);
		pNhapThongTin.add(lblThongTinViecLam);
		
		JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
		lblMaNV.setToolTipText("Số điện thoại");
		lblMaNV.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaNV.setBounds(40, 305, 120, 40);
		pNhapThongTin.add(lblMaNV);
		
		lblMaNhanVienValue = new JLabel("NV0001");
		lblMaNhanVienValue.setToolTipText("Số điện thoại");
		lblMaNhanVienValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaNhanVienValue.setBounds(170, 305, 120, 40);
		pNhapThongTin.add(lblMaNhanVienValue);
		
		JLabel lblChucVu1 = new JLabel("Chức Vụ:");
		lblChucVu1.setToolTipText("Số điện thoại");
		lblChucVu1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblChucVu1.setBounds(40, 350, 120, 40);
		pNhapThongTin.add(lblChucVu1);
		
		cbChucVu = new JComboBox<String>();
		cbChucVu.setToolTipText("Giới tính");
		cbChucVu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbChucVu.setBounds(170, 350, 240, 40);
		cbChucVu.setBorder(null);
		cbChucVu.setBackground(new Color(255, 255, 255));
		pNhapThongTin.add(cbChucVu);
		
		JLabel lblCa = new JLabel("Ca:");
		lblCa.setToolTipText("Số điện thoại");
		lblCa.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblCa.setBounds(40, 395, 120, 40);
		pNhapThongTin.add(lblCa);
		
		JLabel lblT = new JLabel("Thông tin cá nhân:");
		lblT.setToolTipText("Mã nhân viên");
		lblT.setHorizontalAlignment(SwingConstants.LEFT);
		lblT.setForeground(new Color(28, 28, 28));
		lblT.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblT.setBounds(20, 467, 189, 40);
		pNhapThongTin.add(lblT);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setToolTipText("Số điện thoại");
		lblNgaySinh.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNgaySinh.setBounds(40, 517, 120, 40);
		pNhapThongTin.add(lblNgaySinh);
		
		JLabel lblCccd = new JLabel("CCCD:");
		lblCccd.setToolTipText("Số điện thoại");
		lblCccd.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblCccd.setBounds(40, 562, 120, 40);
		pNhapThongTin.add(lblCccd);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính:");
		lblGiiTnh.setToolTipText("Số điện thoại");
		lblGiiTnh.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblGiiTnh.setBounds(40, 607, 120, 40);
		pNhapThongTin.add(lblGiiTnh);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setToolTipText("Số điện thoại");
		lblDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblDiaChi.setBounds(40, 652, 120, 40);
		pNhapThongTin.add(lblDiaChi);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(60, 60, 60));
		separator_1_1.setBounds(20, 455, 390, 2);
		pNhapThongTin.add(separator_1_1);
		
		btnChonHinhAnh = new JButton("Choose");
		btnChonHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonHinhAnh.setBounds(20, 88, 64, 21);
		pNhapThongTin.add(btnChonHinhAnh);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setText("Phạm Văn Thành");
		txtTenNhanVien.setToolTipText("Số điện thoại");
		txtTenNhanVien.setFont(new Font("SansSerif", Font.BOLD, 20));
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(94, 20, 240, 40);
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setBorder(null);
		txtTenNhanVien.setBackground(new Color(255, 255, 255));
		pNhapThongTin.add(txtTenNhanVien);

		// loadData
		loadDataIntoTable();
	}

	public void loadDataIntoTable() {
		model.setRowCount(0);
		for (NhanVien nhanVien : nhanVien_DAO.getAllListNhanVien()) {
			Object[] objects = { nhanVien.getMaNhanVien(), nhanVien.getTenNhanVien(),
					nhanVien.getGioiTinh(),
					simpleDateFormat.format(nhanVien.getNgayVaoLam()),
					nhanVien.getSoDienThoai(), nhanVien.getDiaChi() };
			model.addRow(objects);
		}
	}

	public void refresh() {
		loadDataIntoTable();
	}

	public boolean add() {
		if (txtTenNhanVien.getText().equals("") || cbGioiTinh.getSelectedItem().equals("") || dateChooserNgaySinh.equals(null)
				|| txtDiaChi.getText().equals("") || txtcCCD.getText().equals("") || txtSoDienThoai.getText().equals("")
				|| txtEmail.getText().equals("") || cbChucVu.getSelectedItem().equals("")
				|| txtLuong.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Phải điền đầy đủ thông tin!");
			return false;
		} else {
			try {
				// Thêm tài khoản mới cho nhân viên mới
				TaiKhoan taiKhoan = new TaiKhoan();
				String taiKhoanString = phatSinhMa_DAO.getMaTaiKhoan();
				taiKhoan.setTaiKhoan(taiKhoanString);
				taiKhoan.setMatKhau(taiKhoanString);
				taiKhoan_DAO.themTaiKhoan(taiKhoan);

				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(phatSinhMa_DAO.getMaNhanVien());
				nhanVien.setTenNhanVien(txtTenNhanVien.getText());
				nhanVien.setDiaChi(txtDiaChi.getText());
				nhanVien.setGioiTinh(cbGioiTinh.getSelectedItem().toString());
				nhanVien.setNgaySinh(new Date(dateChooserNgaySinh.getDate().getTime()));
				nhanVien.setNgayVaoLam(new Date(new java.util.Date().getTime()));
				nhanVien.setcCCD(txtcCCD.getText());
				nhanVien.setEmail(txtEmail.getText());
				nhanVien.setSoDienThoai(txtSoDienThoai.getText());
				nhanVien.setChucVu(cbChucVu.getSelectedItem().toString());
				nhanVien.setTaiKhoan(taiKhoan);
				nhanVien.setCa(cbCa.getSelectedItem() + "");
				nhanVien.setHinhAnh("a");
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
		} else {
			int option = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn xóa nhân viên '" + model.getValueAt(row, 0) + "' chứ?", "Xóa?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				try {
					String maTaiKhoan = nhanVien_DAO.getNhanVienTheoMa((String) model.getValueAt(row, 0))
							.getTaiKhoan().getTaiKhoan();
					nhanVien_DAO.xoaNhanVienTheoMa(model.getValueAt(row, 0).toString());
					// Nếu xóa nhân viên thì xóa luôn tài khoản của nhân viên đó
					taiKhoan_DAO.xoaTaiKhoan(maTaiKhoan);
					JOptionPane.showMessageDialog(null, "Xóa thành công nhân viên '" + model.getValueAt(row, 0) + "'!");
					refresh();
					return true;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,
							"Xóa nhân viên '\" + model.getValueAt(row, 0) + \"' không thành công!");
					return false;
				}
			} else
				return false;
		}
	}

	public boolean update() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showInternalMessageDialog(null, "Bạn phải chọn dòng cần sửa!");
			return false;
		} else {
			int option = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn sửa nhân viên '" + model.getValueAt(row, 0) + "' chứ?", "Xóa?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				try {
					TaiKhoan taiKhoan = nhanVien_DAO.getNhanVienTheoMa(model.getValueAt(row, 0).toString())
							.getTaiKhoan();
					Date ngayVaoLam = nhanVien_DAO.getNhanVienTheoMa(model.getValueAt(row, 0).toString())
							.getNgayVaoLam();
					Date ngaySinh = nhanVien_DAO.getNhanVienTheoMa(model.getValueAt(row, 0).toString()).getNgaySinh();
					NhanVien nhanVien = new NhanVien(lblMaNhanVienValue.getText(), txtTenNhanVien.getText(), txtDiaChi.getText(),
							cbGioiTinh.getSelectedItem().toString(), ngaySinh, ngayVaoLam, txtcCCD.getText(),
							txtEmail.getText(), txtSoDienThoai.getText(), cbChucVu.getSelectedItem().toString(),
							taiKhoan, (int) cbCa.getSelectedItem() + "", "a");
					nhanVien_DAO.suaNhanVienTheoMa(nhanVien);
					JOptionPane.showMessageDialog(null, "Sửa thành công nhân viên '" + model.getValueAt(row, 0) + "'!");
					refresh();
					return true;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,
							"Sửa nhân viên '\" + model.getValueAt(row, 0) + \"' không thành công!");
					return false;
				}
			} else {
				return false;
			}
		}
	}
}
