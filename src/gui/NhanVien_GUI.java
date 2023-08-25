package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
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

	/**
	 * Create the panel.
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
		JPanel mMain = new JPanel();
		mMain.setBounds(0, 0, 1256, 583);
		add(mMain);
		mMain.setLayout(null);
		
		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setBounds(10, 53, 1236, 219);
		pNhapThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 162, 197)), "Th\u00F4ng tin:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		mMain.add(pNhapThongTin);
		pNhapThongTin.setLayout(null);
		
		JLabel lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaNV.setBounds(96, 30, 90, 33);
		pNhapThongTin.add(lblMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(196, 30, 156, 33);
		txtMaNV.setEditable(false);
		pNhapThongTin.add(txtMaNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(196, 73, 203, 33);
		pNhapThongTin.add(txtTenNV);
		
		JLabel lblTenNV = new JLabel("Tên NV:");
		lblTenNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenNV.setBounds(96, 73, 90, 33);
		pNhapThongTin.add(lblTenNV);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDiaChi.setBounds(96, 116, 90, 33);
		pNhapThongTin.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(196, 116, 203, 33);
		pNhapThongTin.add(txtDiaChi);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGioiTinh.setBounds(432, 116, 90, 33);
		pNhapThongTin.add(lblGioiTinh);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoDienThoai.setBounds(432, 73, 103, 33);
		pNhapThongTin.add(lblSoDienThoai);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNgaySinh.setBounds(432, 30, 90, 33);
		pNhapThongTin.add(lblNgaySinh);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(545, 73, 156, 33);
		pNhapThongTin.add(txtSoDienThoai);
		
		JComboBox<String> cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbGioiTinh.setBounds(545, 116, 96, 33);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		pNhapThongTin.add(cbGioiTinh);
		
		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblChucVu.setBounds(814, 116, 90, 33);
		pNhapThongTin.add(lblChucVu);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmail.setBounds(814, 73, 103, 33);
		pNhapThongTin.add(lblEmail);
		
		JLabel lblCCCD = new JLabel("CCCD:");
		lblCCCD.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCCCD.setBounds(814, 30, 90, 33);
		pNhapThongTin.add(lblCCCD);
		
		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(890, 30, 156, 33);
		pNhapThongTin.add(txtCCCD);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(890, 73, 238, 33);
		pNhapThongTin.add(txtEmail);
		
		JComboBox<String> cbChucVu = new JComboBox<String>();
		cbChucVu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbChucVu.setBounds(890, 116, 96, 33);
		cbChucVu.addItem("Bán hàng");
		cbChucVu.addItem("Nhập hàng");
		cbChucVu.addItem("Quản trị hệ thống");
		pNhapThongTin.add(cbChucVu);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTim.setBounds(409, 10, 257, 33);
		mMain.add(txtTim);
		txtTim.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(782, 10, 114, 33);
		mMain.add(btnNewButton);
		
		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(676, 10, 96, 33);
		cbTim.addItem("Tên NV");
		cbTim.addItem("Mã NV");
		cbTim.addItem("SĐT");
		cbTim.addItem("CCCD");
		mMain.add(cbTim);
		
		JLabel lblTim = new JLabel("Tìm kiếm");
		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(303, 10, 96, 33);
		mMain.add(lblTim);
		
		JPanel pDanhSach = new JPanel();
		pDanhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 162, 197)), "Danh s\u00E1ch:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		pDanhSach.setBounds(10, 282, 1236, 291);
		mMain.add(pDanhSach);
		pDanhSach.setLayout(null);
		
		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(10, 20, 1216, 305);
		scrollPaneNV.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneNV.setBorder(new LineBorder(new Color(0, 162, 197), 1, true));
		scrollPaneNV.setBackground(new Color(0, 162, 197));
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
					dateChooserNgaySinh.setDate(new java.sql.Date(simpleDateFormat.parse((String) model.getValueAt(row, 5)).getTime()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtSoDienThoai.setText((String) model.getValueAt(row, 9));
				txtCCCD.setText((String) model.getValueAt(row, 7));
				txtEmail.setText((String) model.getValueAt(row, 8));
				if (model.getValueAt(row, 10).toString().equalsIgnoreCase("Bán hàng"))
					cbChucVu.setSelectedIndex(0);
				else if (model.getValueAt(row, 10).toString().equalsIgnoreCase("Nhập hàng"))
					cbChucVu.setSelectedIndex(1);
				else
					cbChucVu.setSelectedIndex(2);
				if (model.getValueAt(row, 4).toString().equalsIgnoreCase("Nam"))
					cbGioiTinh.setSelectedIndex(0);
				else 
					cbGioiTinh.setSelectedIndex(1);
			}
		});
		scrollPaneNV.setViewportView(table);
		
		// header of table
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(1, 98, 156));
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
		dateChooserNgaySinh.setBounds(545, 35, 170, 28);
		pNhapThongTin.add(dateChooserNgaySinh);
		dateChooserNgaySinh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateChooserNgaySinh.setBorder(new LineBorder(new Color(0, 162, 197), 1, true));
		dateChooserNgaySinh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		dateChooserNgaySinh.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserNgaySinh.getCalendarButton().setBackground(new Color(0, 162, 197));
		dateNow = new Date(new java.util.Date().getTime());
		dateChooserNgaySinh.setDate(dateNow);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(160, 167, 108, 33);
		pNhapThongTin.add(btnAdd);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(428, 167, 108, 33);
		pNhapThongTin.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(696, 167, 108, 33);
		pNhapThongTin.add(btnSua);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(964, 167, 108, 33);
		pNhapThongTin.add(btnLamMoi);

		// loadData
		loadDataIntoTable();
	}
	
	public void loadDataIntoTable() {
		for (NhanVien nhanVien : nhanVien_DAO.getAllListNhanVien()) {
			Object[] objects = {nhanVien.getMaNV(), nhanVien.getMaCH(), nhanVien.getTenNV(), nhanVien.getDiaChi(), nhanVien.getGioiTinh(), simpleDateFormat.format(nhanVien.getNgaySinh()), simpleDateFormat.format(nhanVien.getNgayVaoLam()), nhanVien.getCCCD(), nhanVien.getEmail(), nhanVien.getSoDienThoai(), nhanVien.getChucVu(), nhanVien.getLuong()};
			model.addRow(objects);
		}
	}
}
