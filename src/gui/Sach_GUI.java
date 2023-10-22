package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.NhanVien_DAO;
import dao.PhatSinhMa_DAO;
import dao.Sach_DAO;
import entity.KhachHang;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
public class Sach_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtmaSach;
	private JTextField txttenSach;
	private JTextField txtxuatXu;
	private JTextField txttacGia;
	private JTextField txtloaiSach;
	private JTextField txtnhaXuatBan;
	private JTextField txtgiaNhap;
	private JTextField txtgiaBan;
	private JTextField txtsoTrang;
	private JTextField txtsoLuong;
	private JTextField txtanh;
	
	private JLabel  lblthongTinSach;
	private JLabel	lblmaSach;
	private JLabel 	lbltenSach ;
	private JLabel  lblxuatXu;
	private JLabel 	lbltacGia;
	private JLabel	lblloaiSach;
	private JLabel	lblnhaXuatBan;
	private JLabel	lblgiaNhap;
	private JLabel	lblgiaBan;
	private JLabel	lblsoTrang;
	private JLabel	lblsoLuong;
	private JLabel	lblanh;
	private JComboBox<String> cbloaiSach;
	private JComboBox<String> cbnhaXuatBan;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnlamMoi;
	private Sach_DAO sach_DAO;
	private PhatSinhMa_DAO phatSinhMa_DAO;
	
	private DefaultTableModel model;
	private JTable table;
//	private JButton btnChonHinhAnh;
	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public Sach_GUI() throws SQLException {
		// connect
		ConnectDB.getInstance();
		ConnectDB.connect();
		
		//Khai báo Dao
		sach_DAO = new Sach_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();
		
		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBounds(0, 10, 1300, 720);
		add(pMain);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1300, 375);
		pMain.add(pThongTin);
		
		lblthongTinSach = new JLabel("Thông Tin Sách");
		lblthongTinSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthongTinSach.setBounds(20, 15, 200, 40);
		pThongTin.add(lblthongTinSach);
		
		lblmaSach = new JLabel("Mã Sách:");
		lblmaSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmaSach.setBounds(40, 70, 90, 40);
		pThongTin.add(lblmaSach);
		
		lbltenSach = new JLabel("Tên Sách:");
		lbltenSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltenSach.setBounds(40, 115, 90, 40);
		pThongTin.add(lbltenSach);
		
		lblxuatXu = new JLabel("Xuất Xứ:");
		lblxuatXu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblxuatXu.setBounds(40, 160, 90, 40);
		pThongTin.add(lblxuatXu);
		
		lbltacGia = new JLabel("Tác Giả:");
		lbltacGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltacGia.setBounds(40, 205, 90, 40);
		pThongTin.add(lbltacGia);
		
		txtmaSach = new JTextField();
		txtmaSach.setToolTipText("Mã Sách");
		txtmaSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtmaSach.setEditable(false);
		txtmaSach.setColumns(10);
		txtmaSach.setBackground(Color.WHITE);
		txtmaSach.setBounds(145, 70, 255, 40);
		pThongTin.add(txtmaSach);
		
		txttenSach = new JTextField();
		txttenSach.setToolTipText("Tên Sách");
		txttenSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txttenSach.setEditable(false);
		txttenSach.setColumns(10);
		txttenSach.setBackground(Color.WHITE);
		txttenSach.setBounds(145, 115, 255, 40);
		pThongTin.add(txttenSach);
		
		txtxuatXu = new JTextField();
		txtxuatXu.setToolTipText("Xuất xứ");
		txtxuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtxuatXu.setEditable(false);
		txtxuatXu.setColumns(10);
		txtxuatXu.setBackground(Color.WHITE);
		txtxuatXu.setBounds(145, 160, 255, 40);
		pThongTin.add(txtxuatXu);
		
		txttacGia = new JTextField(); 
		txttacGia.setToolTipText("Tác giả");
		txttacGia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txttacGia.setEditable(false);
		txttacGia.setColumns(10);
		txttacGia.setBackground(Color.WHITE);
		txttacGia.setBounds(145, 205, 255, 40);
		pThongTin.add(txttacGia);
		
		lblloaiSach = new JLabel("Loại Sách:");
		lblloaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblloaiSach.setBounds(450, 70, 130, 40);
		pThongTin.add(lblloaiSach);
		
		lblnhaXuatBan = new JLabel("Nhà Xuất Bản:");
		lblnhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnhaXuatBan.setBounds(450, 115, 130, 40);
		pThongTin.add(lblnhaXuatBan);
		
		lblgiaNhap = new JLabel("Giá Nhập:");
		lblgiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgiaNhap.setBounds(450, 160, 130, 40);
		pThongTin.add(lblgiaNhap);
		
		lblgiaBan = new JLabel("Giá Bán:");
		lblgiaBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgiaBan.setBounds(450, 205, 130, 40);
		pThongTin.add(lblgiaBan);
		
		txtgiaNhap = new JTextField();
		txtgiaNhap.setToolTipText("Giá nhập");
		txtgiaNhap.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtgiaNhap.setEditable(false);
		txtgiaNhap.setColumns(10);
		txtgiaNhap.setBackground(Color.WHITE);
		txtgiaNhap.setBounds(600, 160, 255, 40);
		pThongTin.add(txtgiaNhap);
		
		txtgiaBan = new JTextField();
		txtgiaBan.setToolTipText("Giá bán");
		txtgiaBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtgiaBan.setEditable(false);
		txtgiaBan.setColumns(10);
		txtgiaBan.setBackground(Color.WHITE);
		txtgiaBan.setBounds(600, 205, 255, 40);
		pThongTin.add(txtgiaBan);
		
		cbloaiSach = new JComboBox<String>();
		cbloaiSach.setToolTipText("Giới tính");
		cbloaiSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbloaiSach.setBorder(null);
		cbloaiSach.setBounds(600, 70, 255, 40);
		pThongTin.add(cbloaiSach);
		
		cbnhaXuatBan = new JComboBox<String>();
		cbnhaXuatBan.setToolTipText("Giới tính");
		cbnhaXuatBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbnhaXuatBan.setBorder(null);
		cbnhaXuatBan.setBounds(600, 115, 255, 40);
		pThongTin.add(cbnhaXuatBan);
		
		lblsoTrang = new JLabel("Số Trang:");
		lblsoTrang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblsoTrang.setBounds(900, 115, 90, 40);
		pThongTin.add(lblsoTrang);
		
		lblsoLuong = new JLabel("Số Lượng:");
		lblsoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblsoLuong.setBounds(900, 160, 90, 40);
		pThongTin.add(lblsoLuong);
		
		lblanh = new JLabel("Ảnh:");
		lblanh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblanh.setBounds(900, 205, 80, 40);
		pThongTin.add(lblanh);
		
		txtsoTrang = new JTextField();
		txtsoTrang.setToolTipText("Số Trang Sách");
		txtsoTrang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtsoTrang.setEditable(false);
		txtsoTrang.setColumns(10);
		txtsoTrang.setBackground(Color.WHITE);
		txtsoTrang.setBounds(1005, 115, 215, 40);
		pThongTin.add(txtsoTrang);
		
		txtsoLuong = new JTextField();
		txtsoLuong.setToolTipText("Số Lượng Sách");
		txtsoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtsoLuong.setEditable(false);
		txtsoLuong.setColumns(10);
		txtsoLuong.setBackground(Color.WHITE);
		txtsoLuong.setBounds(1005, 162, 215, 40);
		pThongTin.add(txtsoLuong);
		
		txtanh = new JTextField();
		txtanh.setToolTipText("Ảnh");
		txtanh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtanh.setEditable(false);
		txtanh.setColumns(10);
		txtanh.setBackground(Color.WHITE);
		txtanh.setBounds(1005, 205, 215, 40);
		pThongTin.add(txtanh);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(152, 300, 135, 40);
		pThongTin.add(btnAdd);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(439, 300, 135, 40);
		pThongTin.add(btnDelete);
		
		btnUpdate = new JButton("Sửa");
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(726, 300, 135, 40);
		pThongTin.add(btnUpdate);
		
		btnlamMoi = new JButton("Làm mới");
		btnlamMoi.setOpaque(true);
		btnlamMoi.setForeground(Color.WHITE);
		btnlamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnlamMoi.setBackground(new Color(73, 129, 158));
		btnlamMoi.setBounds(1013, 300, 135, 40);
		pThongTin.add(btnlamMoi);
		
		
		// danh sách sách
		JPanel pDanhSach = new JPanel();
		pDanhSach.setBackground(new Color(255, 255, 255));
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBounds(0, 385, 1300, 335);
		pMain.add(pDanhSach);
		pDanhSach.setLayout(null);
		
		JScrollPane scrollPaneSach = new JScrollPane();
		scrollPaneSach.setBounds(10, 10, 1280, 315);
		scrollPaneSach.setToolTipText("Chọn vào Sách cần hiển thị thông tin");
		scrollPaneSach.setBorder(null);
		scrollPaneSach.setBackground(new Color(255, 255, 255));
		pDanhSach.add(scrollPaneSach);
		
		String[] cols = { "Mã Sách", "Tên Sách", "Xuất Xứ", "Giá Nhập", "Giá Bán","" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
	
		
	}
//	public void loadData() {
//		for (KhachHang Kh : khachHang_DAO.getAllKhachHang()) {
//			Object[] object = { Kh.getTenKhachHang(), Kh.getMaKhachHang(), Kh.getGioiTinh(), Kh.getSoDienThoai(),
//					Kh.getDiaChi() };
//			model.addRow(object);
//			table.setRowHeight(25);
//		}
//	}
	
	
}
