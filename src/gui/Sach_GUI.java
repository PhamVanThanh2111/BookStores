package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dao.NhaXuatBan_DAO;
import dao.PhatSinhMa_DAO;
import dao.SanPham_DAO;
import dao.TheLoaiSach_DAO;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.SanPham;
import entity.TheLoaiSach;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;

public class Sach_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtXuatXu;
	private JTextField txtTacGia;
	private JTextField txtGiaNhap;
	private JTextField txtGiaBan;
	private JTextField txtSoTrang;
	private JTextField txtSoLuong;
	private JTextField txtNamXuatBan;

	private JLabel lblthongTinSach;
	private JLabel lblMaSach;
	private JLabel lblTenSach;
	private JLabel lblXuatXu;
	private JLabel lblTacGia;
	private JLabel lblLoaiSach;
	private JLabel lblNhaXuatBan;
	private JLabel lblGiaNhap;
	private JLabel lblGiaBan;
	private JLabel lblSoTrang;
	private JLabel lblSoLuong;
	private JLabel lblHinhAnh;
	private JLabel lblNamXuatBan;

	private JComboBox<String> cmbTenLoaiSach;
	private JComboBox<String> cmbTenNhaXuatBan;

	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnLamMoi;
	// private JButton btnChonHinhAnh;
	private JTableHeader tableHeader;
	private DefaultTableModel model;
	private JTable table;

	private JPanel pDanhSach;

	private JScrollPane scrollPaneSach;

	private NhaXuatBan_DAO nhaXuatBan_DAO;
	private TheLoaiSach_DAO theLoaiSach_DAO;
	private SanPham_DAO sanPham_DAO;
	private PhatSinhMa_DAO phatSinhMa_DAO;
	private TimKiemSach_GUI timKiemSach_GUI;
	private NhaXuatBan nhaXuatBan;
	private TheLoaiSach theLoaiSach;
	private ArrayList<SanPham> ds;
	private Border borderDefault;
	private JButton btnXuatFile;

	private JButton btnTim;
	private JButton btnChonHinhAnh;
	private JButton btnKhoiPhuc;
	private String relativePath;

	private JFileChooser fileChooser;
	private File selectedFile;
	private XSSFWorkbook wordkbook;

	private KhoiPhucSach_GUI khoiPhucSach_GUI;

	// private JButton btnChonHinhAnh;
	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public Sach_GUI(NhanVien nhanVien) {

		// Khai báo Dao
		nhaXuatBan_DAO = new NhaXuatBan_DAO();
		theLoaiSach_DAO = new TheLoaiSach_DAO();
		sanPham_DAO = new SanPham_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();

		ds = new ArrayList<SanPham>();
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1300, 720);
		add(panel);
		panel.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1300, 720);
		panel.add(desktopPane);
		// pMain.add(desktopPane);

		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBounds(0, 0, 1300, 720);
		// add(pMain);
		desktopPane.add(pMain);

		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1299, 358);
		pMain.add(pThongTin);

		lblthongTinSach = new JLabel("Thông Tin Sách");
		lblthongTinSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthongTinSach.setBounds(20, 15, 200, 40);
		pThongTin.add(lblthongTinSach);

		lblMaSach = new JLabel("Mã Sách:");
		lblMaSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaSach.setBounds(30, 67, 90, 40);
		pThongTin.add(lblMaSach);

		lblTenSach = new JLabel("Tên Sách:");
		lblTenSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenSach.setBounds(30, 112, 90, 40);
		pThongTin.add(lblTenSach);

		lblXuatXu = new JLabel("Xuất Xứ:");
		lblXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXuatXu.setBounds(30, 157, 90, 40);
		pThongTin.add(lblXuatXu);

		lblTacGia = new JLabel("Tác Giả:");
		lblTacGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTacGia.setBounds(30, 202, 90, 40);
		pThongTin.add(lblTacGia);

		txtMaSach = new JTextField();
		txtMaSach.setToolTipText("Mã Sách");
		txtMaSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaSach.setEditable(false);
		txtMaSach.setColumns(10);
//		txtMaSach.setBorder(null);
		txtMaSach.setBackground(Color.WHITE);
		txtMaSach.setBounds(135, 67, 200, 40);
//		txtMaSach.setEditable(false);
		pThongTin.add(txtMaSach);

		txtTenSach = new JTextField();
		txtTenSach.setToolTipText("Tên Sách");
		txtTenSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenSach.setEditable(false);
		txtTenSach.setColumns(10);
//		txtTenSach.setBorder(null);
		txtTenSach.setBackground(Color.WHITE);
		txtTenSach.setBounds(135, 112, 200, 40);
		pThongTin.add(txtTenSach);

		txtXuatXu = new JTextField();
		txtXuatXu.setToolTipText("Xuất xứ");
		txtXuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtXuatXu.setEditable(false);
//		txtXuatXu.setBorder(null);
		txtXuatXu.setColumns(10);
		txtXuatXu.setBackground(Color.WHITE);
		txtXuatXu.setBounds(135, 157, 200, 40);
		pThongTin.add(txtXuatXu);

		txtTacGia = new JTextField();
		txtTacGia.setToolTipText("Tác giả");
		txtTacGia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTacGia.setEditable(false);
		txtTacGia.setColumns(10);
//		txtTacGia.setBorder(null);
		txtTacGia.setBackground(Color.WHITE);
		txtTacGia.setBounds(135, 204, 200, 40);
		pThongTin.add(txtTacGia);

		lblLoaiSach = new JLabel("Loại Sách:");
		lblLoaiSach.setToolTipText("thể loại sách ");
		lblLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoaiSach.setBounds(360, 67, 130, 40);

		pThongTin.add(lblLoaiSach);

		lblNhaXuatBan = new JLabel("Nhà Xuất Bản:");
		lblNhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNhaXuatBan.setBounds(360, 112, 130, 40);
		pThongTin.add(lblNhaXuatBan);

		lblGiaNhap = new JLabel("Giá Nhập:");
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaNhap.setBounds(360, 157, 130, 40);
		pThongTin.add(lblGiaNhap);

		lblGiaBan = new JLabel("Giá Bán:");
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaBan.setBounds(360, 202, 130, 40);
		pThongTin.add(lblGiaBan);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setToolTipText("Giá nhập");
		txtGiaNhap.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtGiaNhap.setEditable(false);
		txtGiaNhap.setColumns(10);
//		txtGiaNhap.setBorder(null);
		txtGiaNhap.setBackground(Color.WHITE);
		txtGiaNhap.setBounds(476, 157, 200, 40);
		pThongTin.add(txtGiaNhap);

		txtGiaBan = new JTextField();
		txtGiaBan.setToolTipText("Giá bán");
		txtGiaBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtGiaBan.setEditable(false);
		txtGiaBan.setColumns(10);
//		txtGiaBan.setBorder(null);
		txtGiaBan.setBackground(Color.WHITE);
		txtGiaBan.setBounds(476, 205, 200, 40);
		pThongTin.add(txtGiaBan);

		cmbTenLoaiSach = new JComboBox<String>();
		cmbTenLoaiSach.setForeground(new Color(0, 0, 0));
		cmbTenLoaiSach.setToolTipText("Loại Sách");
		cmbTenLoaiSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cmbTenLoaiSach.setBounds(476, 68, 200, 40);
		cmbTenLoaiSach.setEnabled(false);
//		cmbTenLoaiSach.setBorder(null);
		loadDataIntoComboboxTenLoaiSach();
		cmbTenLoaiSach.setSelectedIndex(-1);
		pThongTin.add(cmbTenLoaiSach);

		cmbTenNhaXuatBan = new JComboBox<String>();
		cmbTenNhaXuatBan.setToolTipText("Nhà Xuất Bản");
		cmbTenNhaXuatBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cmbTenNhaXuatBan.setBounds(476, 113, 200, 40);
		loadDataIntoComboboxTenNhaXuatBan();
//		cmbTenNhaXuatBan.setBorder(null);
		cmbTenNhaXuatBan.setEnabled(false);
		cmbTenNhaXuatBan.setSelectedIndex(-1);
		pThongTin.add(cmbTenNhaXuatBan);

		lblSoTrang = new JLabel("Số Trang:");
		lblSoTrang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoTrang.setBounds(698, 157, 90, 40);
		pThongTin.add(lblSoTrang);

		lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoLuong.setBounds(698, 62, 90, 40);
		pThongTin.add(lblSoLuong);

		txtSoTrang = new JTextField();
		txtSoTrang.setToolTipText("Số Trang Sách");
		txtSoTrang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoTrang.setEditable(false);
		txtSoTrang.setColumns(10);
//		txtSoTrang.setBorder(null);
		txtSoTrang.setBackground(Color.WHITE);
		txtSoTrang.setBounds(798, 157, 200, 40);
		pThongTin.add(txtSoTrang);

		txtSoLuong = new JTextField();
		txtSoLuong.setToolTipText("Số Lượng Sách");
		txtSoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBackground(Color.WHITE);
//		txtSoLuong.setBorder(null);
		txtSoLuong.setBounds(798, 67, 200, 40);
		pThongTin.add(txtSoLuong);

		btnAdd = new JButton("Thêm");
		btnAdd.setIcon(new ImageIcon(Sach_GUI.class.getResource("/image/HeThong/add_person.png")));
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(70, 297, 135, 40);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnAdd.getText().equals("Thêm")) {
//					lamMoi();
//					txtMaSach.setEditable(false);
					enableEdit();
					focusable();
					btnDelete.setText("Hủy");
					btnAdd.setText("Xác nhận");
					btnLamMoi.setEnabled(false);
					btnUpdate.setEnabled(false);
					btnTim.setEnabled(false);
					btnChonHinhAnh.setEnabled(true);
					btnKhoiPhuc.setEnabled(false);
				}else {
					add();
					disableEdit();
					unfocusable();
					btnAdd.setText("Thêm");
					btnDelete.setText("Xóa");
					btnLamMoi.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnTim.setEnabled(true);
					btnChonHinhAnh.setEnabled(true);
					btnKhoiPhuc.setEnabled(true);
				}
				
			}
		});
		pThongTin.add(btnAdd);

		btnDelete = new JButton("Xóa");
		btnDelete.setIcon(new ImageIcon(Sach_GUI.class.getResource("/image/HeThong/remove_person.png")));
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(275, 297, 135, 40);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnDelete.getText().equals("Xóa")) {
					delete();
				} else {
					disableEdit();
					btnAdd.setText("Thêm");
					btnUpdate.setText("Sửa");
					btnDelete.setText("Xóa");
					btnLamMoi.setEnabled(true);
					btnAdd.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnTim.setEnabled(true);
				}
			}
		});
		pThongTin.add(btnDelete);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setIcon(new ImageIcon(Sach_GUI.class.getResource("/image/HeThong/update_person.png")));
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(480, 297, 135, 40);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnUpdate.getText().equals("Sửa")) {
					enableEdit();
					focusable();
					btnDelete.setText("Hủy");
					btnUpdate.setText("Xác nhận");
					btnLamMoi.setEnabled(false);
					btnAdd.setEnabled(false);
					btnTim.setEnabled(false);
					btnChonHinhAnh.setEnabled(true);
					btnKhoiPhuc.setEnabled(false);
				} else {
					update();
					unfocusable();
					btnUpdate.setText("Sửa");
					btnDelete.setText("Xóa");
					disableEdit();
					btnLamMoi.setEnabled(true);
					btnAdd.setEnabled(true);
					btnTim.setEnabled(true);
					btnChonHinhAnh.setEnabled(false);
					btnKhoiPhuc.setEnabled(true);
				}
			}
		});
		pThongTin.add(btnUpdate);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setOpaque(true);
		btnLamMoi.setIcon(new ImageIcon(Sach_GUI.class.getResource("/image/HeThong/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.setBounds(685, 297, 135, 40);
		btnLamMoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lamMoi();
			}
		});

		pThongTin.add(btnLamMoi);

		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhAnh.setBounds(1023, 15, 250, 200);
		pThongTin.add(lblHinhAnh);

		txtNamXuatBan = new JTextField();
		txtNamXuatBan.setToolTipText("năm xuất bản:");
		txtNamXuatBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNamXuatBan.setEditable(false);
		txtNamXuatBan.setColumns(10);
		txtNamXuatBan.setBackground(Color.WHITE);
		txtNamXuatBan.setBounds(798, 112, 200, 40);
//		txtNamXuatBan.setBorder(null);
		pThongTin.add(txtNamXuatBan);

		lblNamXuatBan = new JLabel("Năm XB:");
		lblNamXuatBan.setToolTipText("Năm Xuất Bản:");
		lblNamXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNamXuatBan.setBounds(697, 107, 90, 40);
		pThongTin.add(lblNamXuatBan);

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(Sach_GUI.class.getResource("/image/HeThong/find_person.png")));
		btnTim.setOpaque(true);
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(890, 297, 135, 40);
		btnTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (timKiemSach_GUI == null || timKiemSach_GUI.isClosed()) {
					timKiemSach_GUI = new TimKiemSach_GUI(ds);
					timKiemSach_GUI.addInternalFrameListener(new InternalFrameAdapter() {
						@Override
						public void internalFrameActivated(InternalFrameEvent e) {
							// System.out.println("Internal frame is activated.");
						}

						@Override
						public void internalFrameDeactivated(InternalFrameEvent e) {
							// System.out.println("Internal frame is deactivated.");
						}

						@Override
						public void internalFrameOpened(InternalFrameEvent e) {
							// System.out.println("Internal frame is opened.");
							disableButton();
							unfocusable();
						}

						@Override
						public void internalFrameClosed(InternalFrameEvent e) {
							// System.out.println("Internal frame is closed.");
							// model.setRowCount(0);
//			                System.out.println("Internal frame is closed.");
//							model.setRowCount(0);
							btnAdd.setEnabled(true);
							btnDelete.setEnabled(true);
							btnUpdate.setEnabled(true);
							btnUpdate.setEnabled(true);
							model.setRowCount(0);
							loadData(ds);
							ds.removeAll(ds);
							enableButton();
							focusable();
						}
					});
					desktopPane.add(timKiemSach_GUI).setVisible(true);
					// loadDataIntoTable(timKiemSach_GUI.searchSach());
				}
			}
		});
		pThongTin.add(btnTim);

		btnChonHinhAnh = new JButton("Choose");
		btnChonHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonHinhAnh.setBounds(1105, 225, 90, 19);
		btnChonHinhAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFile();
			}
		});

		pThongTin.add(btnChonHinhAnh);

		btnKhoiPhuc = new JButton("Khôi Phục");
		btnKhoiPhuc.setOpaque(true);
		btnKhoiPhuc.setForeground(Color.WHITE);
		btnKhoiPhuc.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnKhoiPhuc.setBackground(new Color(73, 129, 158));
		btnKhoiPhuc.setBounds(1095, 297, 135, 40);
		btnKhoiPhuc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (khoiPhucSach_GUI == null || khoiPhucSach_GUI.isClosed()) {
					khoiPhucSach_GUI = new KhoiPhucSach_GUI(ds);
					khoiPhucSach_GUI.addInternalFrameListener(new InternalFrameAdapter() {
						@Override
						public void internalFrameActivated(InternalFrameEvent e) {
							// System.out.println("Internal frame is activated.");
						}

						@Override
						public void internalFrameDeactivated(InternalFrameEvent e) {
							// System.out.println("Internal frame is deactivated.");
						}

						@Override
						public void internalFrameOpened(InternalFrameEvent e) {
							// System.out.println("Internal frame is opened.");
							disableButton();
							unfocusable();
						}

						@Override
						public void internalFrameClosed(InternalFrameEvent e) {
							// System.out.println("Internal frame is closed.");
							// model.setRowCount(0);
//			                System.out.println("Internal frame is closed.");
//							model.setRowCount(0);
							btnAdd.setEnabled(true);
							btnDelete.setEnabled(true);
							btnUpdate.setEnabled(true);
							btnUpdate.setEnabled(true);
							model.setRowCount(0);
							loadData(ds);
							ds.removeAll(ds);
							enableButton();
							focusable();
						}
					});
					desktopPane.add(khoiPhucSach_GUI).setVisible(true);
					// loadDataIntoTable(timKiemSach_GUI.searchSach());
				}
			}
		});
		pThongTin.add(btnKhoiPhuc);

		offFocus();

		// danh sách sách
		pDanhSach = new JPanel();
		pDanhSach.setBackground(new Color(255, 255, 255));
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBounds(0, 372, 1299, 348);
		pMain.add(pDanhSach);
		pDanhSach.setLayout(null);

		scrollPaneSach = new JScrollPane();
		scrollPaneSach.setBounds(20, 44, 1259, 292);
		scrollPaneSach.setToolTipText("Chọn vào Sách cần hiển thị thông tin");
		scrollPaneSach.setBorder(null);
		scrollPaneSach.setBackground(new Color(255, 255, 255));
		pDanhSach.add(scrollPaneSach);

		String cols[] = { "Mã Sách", "Tên Sách", "Xuất Xứ", "Giá Nhập", "Giá Bán", "Số Lượng Tồn", "Nhà Xuất Bản",
				"Thể Loại Sách", "Tác Giả", "Số Trang", "Năm Xuất Bản" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setToolTipText("Chọn vào sách cần hiển thị thông tin");
		table.setRowHeight(30);
		table.setDefaultEditor(Object.class, null);
		table.setShowGrid(true);
		table.setShowHorizontalLines(true);
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(141, 208, 229));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
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
				SanPham sach = sanPham_DAO.getSanPhamTheoMaSanPham((String) model.getValueAt(row, 0).toString());
				txtMaSach.setText((String) model.getValueAt(row, 0));
				txtTenSach.setText((String) model.getValueAt(row, 1));
				txtXuatXu.setText((String) model.getValueAt(row, 2));
				txtGiaNhap.setText(model.getValueAt(row, 3).toString());
				txtGiaBan.setText(model.getValueAt(row, 4).toString());
				txtSoLuong.setText(model.getValueAt(row, 5).toString());
				cmbTenNhaXuatBan.setSelectedItem(model.getValueAt(row, 6));
				cmbTenLoaiSach.setSelectedItem(model.getValueAt(row, 7));
				txtTacGia.setText(model.getValueAt(row, 8).toString());
				txtSoTrang.setText(model.getValueAt(row, 9).toString());
				txtNamXuatBan.setText(model.getValueAt(row, 10).toString());
				lblHinhAnh.setIcon(new ImageIcon(Sach_GUI.class.getResource(sach.getHinhAnh())));
//					System.out.println(sach.getHinhAnh());
				relativePath = sach.getHinhAnh();
			}
			//
		});
//		if (nhanVien.getChucVu().equals("Bán hàng")) {
//			btnAdd.setEnabled(false);
//			btnDelete.setEnabled(false);
//			btnUpdate.setEnabled(false);
//			btnChonHinhAnh.setEnabled(false);
//		}

		scrollPaneSach.setViewportView(table);
		// header of table
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		desktopPane.setLayout(null);

		JLabel lblChiTitSch = new JLabel("Chi Tiết Sách");
		lblChiTitSch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTitSch.setBounds(22, 10, 200, 40);
		pDanhSach.add(lblChiTitSch);

		btnXuatFile = new JButton("Xuất File");
		btnXuatFile.setOpaque(true);
		btnXuatFile.setForeground(Color.WHITE);
		btnXuatFile.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXuatFile.setBackground(new Color(73, 129, 158));
		btnXuatFile.setBounds(1098, 10, 135, 27);
		btnXuatFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuatFile(sanPham_DAO.getAllSach());
			}
		});
		pDanhSach.add(btnXuatFile);

		loadData(sanPham_DAO.getAllSach());
		// unfocus
		unfocusable();
	}

	public Sach_GUI() {

		// Khai báo DAO
		nhaXuatBan_DAO = new NhaXuatBan_DAO();
		theLoaiSach_DAO = new TheLoaiSach_DAO();
		sanPham_DAO = new SanPham_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();

		ds = new ArrayList<SanPham>();
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1300, 720);
		add(panel);
		panel.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1300, 720);
		panel.add(desktopPane);
		// pMain.add(desktopPane);

		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBounds(0, 0, 1300, 720);
		// add(pMain);
		desktopPane.add(pMain);

		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1300, 352);
		pMain.add(pThongTin);

		lblthongTinSach = new JLabel("Thông Tin Sách");
		lblthongTinSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthongTinSach.setBounds(20, 15, 200, 40);
		pThongTin.add(lblthongTinSach);

		lblMaSach = new JLabel("Mã Sách:");
		lblMaSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaSach.setBounds(30, 67, 90, 40);
		pThongTin.add(lblMaSach);

		lblTenSach = new JLabel("Tên Sách:");
		lblTenSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenSach.setBounds(30, 112, 90, 40);
		pThongTin.add(lblTenSach);

		lblXuatXu = new JLabel("Xuất Xứ:");
		lblXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXuatXu.setBounds(30, 157, 90, 40);
		pThongTin.add(lblXuatXu);

		lblTacGia = new JLabel("Tác Giả:");
		lblTacGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTacGia.setBounds(30, 202, 90, 40);
		pThongTin.add(lblTacGia);

		txtMaSach = new JTextField();
		txtMaSach.setToolTipText("Mã Sách");
		txtMaSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaSach.setEditable(false);
		txtMaSach.setColumns(10);
		txtMaSach.setBorder(null);
		txtMaSach.setBackground(Color.WHITE);
		txtMaSach.setBounds(135, 67, 200, 40);
//		txtMaSach.setEnabled(isEnabled());
		pThongTin.add(txtMaSach);

		txtTenSach = new JTextField();
		txtTenSach.setToolTipText("Tên Sách");
		txtTenSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenSach.setEditable(false);
		txtTenSach.setColumns(10);
		txtTenSach.setBorder(null);
		txtTenSach.setBackground(Color.WHITE);
		txtTenSach.setBounds(135, 112, 200, 40);
		pThongTin.add(txtTenSach);

		txtXuatXu = new JTextField();
		txtXuatXu.setToolTipText("Xuất xứ");
		txtXuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtXuatXu.setEditable(false);
		txtXuatXu.setColumns(10);
		txtXuatXu.setBorder(null);
		txtXuatXu.setBackground(Color.WHITE);
		txtXuatXu.setBounds(135, 157, 200, 40);
		pThongTin.add(txtXuatXu);

		txtTacGia = new JTextField();
		txtTacGia.setToolTipText("Tác giả");
		txtTacGia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTacGia.setEditable(false);
		txtTacGia.setColumns(10);
		txtTacGia.setBackground(Color.WHITE);
		txtTacGia.setBounds(135, 204, 200, 40);
		txtTacGia.setBorder(null);
		borderDefault = txtTacGia.getBorder();
		pThongTin.add(txtTacGia);

		lblLoaiSach = new JLabel("Loại Sách:");
		lblLoaiSach.setToolTipText("thể loại sách ");
		lblLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoaiSach.setBounds(360, 112, 130, 40);
		pThongTin.add(lblLoaiSach);

		lblNhaXuatBan = new JLabel("Nhà Xuất Bản:");
		lblNhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNhaXuatBan.setBounds(360, 157, 130, 40);
		pThongTin.add(lblNhaXuatBan);

//		lblGiaNhap = new JLabel("Giá Nhập:");
//		lblGiaNhap.setBorder(null);
//		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		lblGiaNhap.setBounds(360, 157, 130, 40);
//		pThongTin.add(lblGiaNhap);

		lblGiaBan = new JLabel("Giá Bán:");
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaBan.setBounds(360, 200, 130, 40);
		pThongTin.add(lblGiaBan);

		txtGiaBan = new JTextField();
		txtGiaBan.setToolTipText("Giá bán");
		txtGiaBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtGiaBan.setEditable(false);
		txtGiaBan.setColumns(10);
		txtGiaBan.setBackground(Color.WHITE);
		txtGiaBan.setBorder(null);
		txtGiaBan.setBounds(476, 200, 200, 40);
		pThongTin.add(txtGiaBan);

		cmbTenLoaiSach = new JComboBox<String>();
		cmbTenLoaiSach.setForeground(new Color(0, 0, 0));
		cmbTenLoaiSach.setToolTipText("Loại Sách");
		cmbTenLoaiSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cmbTenLoaiSach.setBounds(476, 112, 200, 40);
		cmbTenLoaiSach.setBorder(null);
		loadDataIntoComboboxTenLoaiSach();
		cmbTenLoaiSach.setSelectedIndex(-1);
		pThongTin.add(cmbTenLoaiSach);

		cmbTenNhaXuatBan = new JComboBox<String>();
		cmbTenNhaXuatBan.setToolTipText("Nhà Xuất Bản");
		cmbTenNhaXuatBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cmbTenNhaXuatBan.setBounds(476, 157, 200, 40);
		cmbTenNhaXuatBan.setBorder(null);
		loadDataIntoComboboxTenNhaXuatBan();
		cmbTenNhaXuatBan.setSelectedIndex(-1);
		pThongTin.add(cmbTenNhaXuatBan);

		lblSoTrang = new JLabel("Số Trang:");
		lblSoTrang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoTrang.setBounds(698, 200, 90, 40);
		pThongTin.add(lblSoTrang);

		lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoLuong.setBounds(698, 112, 90, 40);
		pThongTin.add(lblSoLuong);

//		lblAnh = new JLabel("Ảnh:");
//		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		lblAnh.setBounds(890, 205, 90, 40);
//		pThongTin.add(lblAnh);

		txtSoTrang = new JTextField();
		txtSoTrang.setToolTipText("Số Trang Sách");
		txtSoTrang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoTrang.setEditable(false);
		txtSoTrang.setColumns(10);
		txtSoTrang.setBackground(Color.WHITE);
		txtSoTrang.setBounds(798, 200, 200, 40);
		txtSoTrang.setBorder(null);
		pThongTin.add(txtSoTrang);

		txtSoLuong = new JTextField();
		txtSoLuong.setToolTipText("Số Lượng Sách");
		txtSoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBackground(Color.WHITE);
		txtSoLuong.setBounds(798, 112, 200, 40);
		txtSoLuong.setBorder(null);
		pThongTin.add(txtSoLuong);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setOpaque(true);
		btnLamMoi.setIcon(new ImageIcon(Sach_GUI.class.getResource("/image/HeThong/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.setBounds(821, 297, 135, 40);
		btnLamMoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lamMoi();
			}
		});
		pThongTin.add(btnLamMoi);

		lblHinhAnh = new JLabel("");
		lblHinhAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setBounds(1023, 15, 200, 200);
		pThongTin.add(lblHinhAnh);

		txtNamXuatBan = new JTextField();
		txtNamXuatBan.setToolTipText("năm xuất bản");
		txtNamXuatBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNamXuatBan.setEditable(false);
		txtNamXuatBan.setColumns(10);
		txtNamXuatBan.setBackground(Color.WHITE);
		txtNamXuatBan.setBounds(798, 157, 200, 40);
		txtNamXuatBan.setBorder(null);
		pThongTin.add(txtNamXuatBan);

		lblNamXuatBan = new JLabel("Năm XB:");
		lblNamXuatBan.setToolTipText("Năm Xuất Bản:");
		lblNamXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNamXuatBan.setBounds(697, 157, 90, 40);
		pThongTin.add(lblNamXuatBan);

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(Sach_GUI.class.getResource("/image/HeThong/find_person.png")));
		btnTim.setOpaque(true);
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(1060, 297, 135, 40);
		btnTim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (timKiemSach_GUI == null || timKiemSach_GUI.isClosed()) {
					timKiemSach_GUI = new TimKiemSach_GUI(ds);
					timKiemSach_GUI.addInternalFrameListener(new InternalFrameAdapter() {
						@Override
						public void internalFrameActivated(InternalFrameEvent e) {
							// System.out.println("Internal frame is activated.");
						}

						@Override
						public void internalFrameDeactivated(InternalFrameEvent e) {
							// System.out.println("Internal frame is deactivated.");
						}

						@Override
						public void internalFrameOpened(InternalFrameEvent e) {
							// System.out.println("Internal frame is opened.");
							btnLamMoi.setEnabled(false);
						}

						@Override
						public void internalFrameClosed(InternalFrameEvent e) {
							// System.out.println("Internal frame is closed.");
							model.setRowCount(0);
							loadData(ds);
							ds.removeAll(ds);
							btnLamMoi.setEnabled(true);
						}
					});
					desktopPane.add(timKiemSach_GUI).setVisible(true);
				}
			}
		});
		pThongTin.add(btnTim);

		// danh sách sách
		pDanhSach = new JPanel();
		pDanhSach.setBackground(new Color(255, 255, 255));
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBounds(0, 362, 1300, 348);
		pMain.add(pDanhSach);
		pDanhSach.setLayout(null);

		scrollPaneSach = new JScrollPane();
		scrollPaneSach.setBounds(20, 44, 1259, 292);
		scrollPaneSach.setToolTipText("Chọn vào Sách cần hiển thị thông tin");
		scrollPaneSach.setBorder(null);
		scrollPaneSach.setBackground(new Color(255, 255, 255));
		pDanhSach.add(scrollPaneSach);

		String cols[] = { "Mã Sách", "Tên Sách", "Xuất Xứ", "Giá Bán", "Số Lượng Tồn", "Nhà Xuất Bản",
				"Thể Loại Sách", "Tác Giả", "Số Trang", "Năm Xuất Bản" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setToolTipText("Chọn vào sách cần hiển thị thông tin");
		table.setRowHeight(30);
		table.setDefaultEditor(Object.class, null);
		table.setShowGrid(true);
		table.setShowHorizontalLines(true);
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(141, 208, 229));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
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
				if (row >= 0) {
					txtMaSach.setText((String) model.getValueAt(row, 0));
					txtTenSach.setText((String) model.getValueAt(row, 1));
					txtXuatXu.setText((String) model.getValueAt(row, 2));
					txtGiaBan.setText(model.getValueAt(row, 3).toString());
					txtSoLuong.setText(model.getValueAt(row, 4).toString());
					cmbTenNhaXuatBan.setSelectedItem(model.getValueAt(row, 5));
					cmbTenLoaiSach.setSelectedItem(model.getValueAt(row, 6));
					txtTacGia.setText(model.getValueAt(row, 7).toString());
					txtSoTrang.setText(model.getValueAt(row, 8).toString());
					txtNamXuatBan.setText(model.getValueAt(row, 9).toString());
					SanPham sach = sanPham_DAO.getSanPhamTheoMaSanPham((String) model.getValueAt(row, 0).toString());
					relativePath = sach.getHinhAnh();
					lblHinhAnh.setIcon(new ImageIcon(Sach_GUI.class.getResource(sach.getHinhAnh())));
//					System.out.println(sach.getHinhAnh());

				}
			}
			//
		});
		scrollPaneSach.setViewportView(table);
		// header of table
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
//		table.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

		JLabel lblChiTitSch = new JLabel("Chi Tiết Sách");
		lblChiTitSch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTitSch.setBounds(22, 10, 200, 40);
		pDanhSach.add(lblChiTitSch);

		// loadData
		loadDataSachChoKhachHang(sanPham_DAO.getAllSach());
		// unfocus
		txtMaSach.setFocusable(false);
		txtTenSach.setFocusable(false);
		txtXuatXu.setFocusable(false);
		txtTacGia.setFocusable(false);
		txtGiaBan.setFocusable(false);
		txtSoLuong.setFocusable(false);
		txtSoTrang.setFocusable(false);
		txtNamXuatBan.setFocusable(false);

	}

	// load Data lên bảng
	public void loadData(ArrayList<SanPham> ds) {
		model.setRowCount(0);
		for (SanPham sanPham : ds) {
			Object[] object = { sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getXuatXu(),
					sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getSoLuongTon(),
					nhaXuatBan_DAO.getnhaXuatBanTheoMa(sanPham.getMaNXB()).getTenNhaXuatBan(),
					theLoaiSach_DAO.getTheLoaiSachTheoMa(sanPham.getMaTheLoaiSach()).gettenTheLoaiSach(),
					sanPham.getTacGia(), sanPham.getSoTrang(), sanPham.getNamXuatBan(), };
			model.addRow(object);
			table.setRowHeight(25);
		}
	}
	
	// loadData sach cho khachhang
	public void loadDataSachChoKhachHang(ArrayList<SanPham> ds) {
		model.setRowCount(0);
		for (SanPham sanPham : ds) {
			Object[] object = { sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getXuatXu(),
					sanPham.getGiaBan(), sanPham.getSoLuongTon(),
					nhaXuatBan_DAO.getnhaXuatBanTheoMa(sanPham.getMaNXB()).getTenNhaXuatBan(),
					theLoaiSach_DAO.getTheLoaiSachTheoMa(sanPham.getMaTheLoaiSach()).gettenTheLoaiSach(),
					sanPham.getTacGia(), sanPham.getSoTrang(), sanPham.getNamXuatBan(), };
			model.addRow(object);
			table.setRowHeight(25);
		}
	}

	// load cbTenNhaXuatBan
	private void loadDataIntoComboboxTenNhaXuatBan() {
		cmbTenNhaXuatBan.removeAllItems();
		for (NhaXuatBan nhaXuatBan : nhaXuatBan_DAO.getAllListNhaXuatBan()) {
			cmbTenNhaXuatBan.addItem(nhaXuatBan.getTenNhaXuatBan());
		}
	}
	// load cbTenTheLoaiSachs
	private void loadDataIntoComboboxTenLoaiSach() {
		cmbTenLoaiSach.removeAllItems();
		for (TheLoaiSach theLoaiSach : theLoaiSach_DAO.getAllListTheLoaiSach()) {
			cmbTenLoaiSach.addItem(theLoaiSach.gettenTheLoaiSach());
		}
	}

	// làm mới dữ liệu trên bảng
	public void lamMoi() {
		txtMaSach.setText("");
		txtTenSach.setText("");
		txtGiaNhap.setText("");
		txtXuatXu.setText("");
		txtGiaBan.setText("");
		txtSoLuong.setText("");
		txtSoTrang.setText("");
		txtNamXuatBan.setText("");
		txtTacGia.setText("");
		cmbTenLoaiSach.setSelectedIndex(-1);
		cmbTenNhaXuatBan.setSelectedIndex(-1);
		lblHinhAnh.setIcon(null);
		lblHinhAnh.removeAll();
	}
	public void refresh() {
		loadData(sanPham_DAO.getAllSach());
	}
	// Thêm sách
	public boolean add() {
		if (kiemTraRong()) {
			JOptionPane.showMessageDialog(null, "Bạn phải điền đầy đủ thông tin!");
			return false;
		}
		else {
			if (txtTenSach.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Tên sách không được để trống!");
				txtTenSach.requestFocus();
				return false;
			} 
			else if (txtXuatXu.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Xuất xứ sách không được để trống!");
				txtXuatXu.requestFocus();
				return false;
			} 
			else if (txtGiaNhap.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Giá nhập sách không được để trống!");
				txtGiaNhap.requestFocus();
				return false;
			}
			else if (!Regular_expression.validateGiaNhap(txtGiaNhap.getText())) {
				JOptionPane.showMessageDialog(null, "c");
				txtGiaNhap.requestFocus();
				return false;
			}
			else if (txtGiaBan.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Giá bán sách không được để trống!");
				txtGiaBan.requestFocus();
				return false;
			} 
			else if (!Regular_expression.validateGiaBan(txtGiaBan.getText())) {
				JOptionPane.showMessageDialog(null, "Giá bán phải là chữ số > 0 và không phải là ký tự đặc biệt!");
				txtGiaBan.requestFocus();
				return false;
			}
			else if (txtSoLuong.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Số lượng sách không được để trống!");
				txtSoLuong.requestFocus();
				return false;
			}
			else if (!Regular_expression.validateSoLuongSach(txtSoLuong.getText())) {
				JOptionPane.showMessageDialog(null, "Số lượng sách phải là chữ số > 0 và không phải là ký tự đặc biệt !!");
				txtSoLuong.requestFocus();
				return false;
			}
			else if (cmbTenNhaXuatBan.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "Chưa chọn nhà xuất bản!");
				return false;
			} 
			else if (cmbTenLoaiSach.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "Chưa chọn loại sách!");
				return false;
			} 
			else if (txtTacGia.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Tên tác giả không được để trống!");
				txtTacGia.requestFocus();
				return false;
			} 
			else if (txtSoTrang.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Số trang sách không được để trống!");
				txtSoTrang.requestFocus();
				return false;
			}
			else if (!Regular_expression.validateSoLuongSach(txtSoTrang.getText())) {
				JOptionPane.showMessageDialog(null, "Số trang phải là chữ số > 0 và không phải là ký tự đặc biệt !!");
				txtSoTrang.requestFocus();
				return false;
			}
			else if (txtNamXuatBan.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Năm xuất bản sách không được để trống!");
				txtNamXuatBan.requestFocus();
				return false;
			} 
			else if (! Regular_expression.validateNamXuatBan(txtNamXuatBan.getText())) {
				JOptionPane.showMessageDialog(null, "Năm xuất bản phải trước năm hiện tại!");
				return false;
			}
			else {
				try {
					SanPham sanPham = new SanPham();
					sanPham.setMaSanPham(phatSinhMa_DAO.getMaSach());
					sanPham.setTenSanPham(txtTenSach.getText());
					sanPham.setXuatXu(txtXuatXu.getText());
					sanPham.setGiaNhap(Float.parseFloat(txtGiaNhap.getText()));
					sanPham.setGiaBan(Float.parseFloat(txtGiaBan.getText()));
					sanPham.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
					sanPham.setHinhAnh(relativePath);
					nhaXuatBan = nhaXuatBan_DAO.getnhaXuatBanTheoTen(cmbTenNhaXuatBan.getSelectedItem().toString());
					sanPham.setMaNXB(nhaXuatBan.getMaNhaXuatBan());
					theLoaiSach = theLoaiSach_DAO.getTheLoaiSachTheoTen(cmbTenLoaiSach.getSelectedItem().toString());
					sanPham.setMaTheLoaiSach(theLoaiSach.getmaTheLoaiSach());
					sanPham.setTacGia(txtTacGia.getText());
					sanPham.setSoTrang(Integer.parseInt(txtSoTrang.getText()));
					sanPham.setNamXuatBan(Integer.parseInt(txtNamXuatBan.getText()));
					sanPham.setMaNhaCungCap(null);
					sanPham_DAO.themSanPham(sanPham);
					JOptionPane.showMessageDialog(null, "Thêm sách thành công!");
					refresh();
					return true;
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Thêm sách thất bại!");
					e1.printStackTrace();
					return false;
				}
			}
		}
	}
	// Kiểm tra rỗng cho sách 
	private boolean kiemTraRong() {
	    if (txtTenSach.getText().equals("") ||
	        txtXuatXu.getText().equals("") ||
	        txtGiaNhap.getText().equals("") ||
	        txtGiaBan.getText().equals("") ||
	        txtSoLuong.getText().equals("") ||
	        cmbTenNhaXuatBan.getSelectedIndex() == -1 ||
	        cmbTenLoaiSach.getSelectedIndex() == -1 ||
	        txtTacGia.getText().equals("") ||
	        txtSoTrang.getText().equals("") ||
	        txtNamXuatBan.getText().equals("") ||
	        lblHinhAnh.getIcon() == null) {
	        return true;
	    }
	    return false;
	}
	// xóa sách
	public boolean delete() {
		int row = table.getSelectedRow();
		if (row != -1) {
			int tb = JOptionPane.showConfirmDialog(null, "Bạn Muốn Xóa Sản Phẩm? ", "Delete",
					JOptionPane.YES_NO_OPTION);
			if (tb == JOptionPane.YES_OPTION) {
				if (tb == JOptionPane.YES_OPTION) {
					try {
						SanPham sanPham = new SanPham();
						sanPham.setMaSanPham(txtMaSach.getText());
						sanPham.setTenSanPham(txtTenSach.getText());
						sanPham.setXuatXu(txtXuatXu.getText());
						sanPham.setGiaNhap(Float.parseFloat(txtGiaNhap.getText()));
						sanPham.setGiaBan(Float.parseFloat(txtGiaBan.getText()));
						sanPham.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
						sanPham.setHinhAnh(relativePath);
						sanPham.setMaNXB(nhaXuatBan_DAO
								.getnhaXuatBanTheoTen(cmbTenNhaXuatBan.getSelectedItem().toString()).getMaNhaXuatBan());
						sanPham.setMaTheLoaiSach(theLoaiSach_DAO
								.getTheLoaiSachTheoTen(cmbTenLoaiSach.getSelectedItem().toString().toString())
								.getmaTheLoaiSach());
						sanPham.setTacGia(txtTacGia.getText());
						sanPham.setSoTrang(Integer.parseInt(txtSoTrang.getText()));
						sanPham.setNamXuatBan(Integer.parseInt(txtNamXuatBan.getText()));
						sanPham.setMaNhaCungCap("");

//				            sanPham_DAO.suaSanPhamTheoMa(sanPham);
						sanPham_DAO.suaMaSach(sanPham);
						JOptionPane.showMessageDialog(null, "Xóa Thành Công !");
						refresh();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Sản Phẩm Tồn Tại Trong Hóa Đơn !");
					}
				}
			}
		}
		return false;
	}
	
	// sửa sách
	public boolean update() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Bạn phải chọn sách cần sửa!");
			return false;
		} else if (txtXuatXu.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Xuất xứ của sách không được để trống!");
			txtXuatXu.requestFocus();
			return false;
		} else if (txtTacGia.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tác giả của sách không được để trống!");
			txtTacGia.requestFocus();
			return false;
		} else if (txtGiaNhap.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Giá nhập của sách không được để trống!");
			txtGiaNhap.requestFocus();
			return false;
		} else if (txtGiaBan.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Giá bán của sách không được để trống!");
			txtGiaBan.requestFocus();
			return false;
		} else if (txtNamXuatBan.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Năm xuất bản của sách không được để trống!");
			txtNamXuatBan.requestFocus();
			return false;
		} else if (txtSoTrang.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số trang của sách không được để trống!");
			txtSoTrang.requestFocus();
			return false;
		} else if (txtSoLuong.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số lượng của sách không được để trống!");
			txtSoLuong.requestFocus();
			return false;
		} else {
			int option = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn sửa sách ? '" + model.getValueAt(row, 0) + "' chứ?", "Sửa?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				SanPham sanPham = new SanPham();
				sanPham.setMaSanPham(txtMaSach.getText());
				sanPham.setTenSanPham(txtTenSach.getText());
				sanPham.setXuatXu(txtXuatXu.getText());
				sanPham.setGiaNhap(Float.parseFloat(txtGiaNhap.getText()));
				sanPham.setGiaBan(Float.parseFloat(txtGiaBan.getText()));
				sanPham.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
				sanPham.setHinhAnh(relativePath);
				sanPham.setMaNXB(nhaXuatBan_DAO.getnhaXuatBanTheoTen(cmbTenNhaXuatBan.getSelectedItem().toString())
						.getMaNhaXuatBan());
				sanPham.setMaTheLoaiSach(
						theLoaiSach_DAO.getTheLoaiSachTheoTen(cmbTenLoaiSach.getSelectedItem().toString().toString())
								.getmaTheLoaiSach());
				sanPham.setTacGia(txtTacGia.getText());
				sanPham.setSoTrang(Integer.parseInt(txtSoTrang.getText()));
				sanPham.setNamXuatBan(Integer.parseInt(txtNamXuatBan.getText()));
				sanPham.setMaNhaCungCap("");

//		            sanPham_DAO.suaSanPhamTheoMa(sanPham);
				sanPham_DAO.suaSanPhamTheoMaSach(sanPham);
				JOptionPane.showMessageDialog(null, "Sửa thành công sách '" + model.getValueAt(row, 0) + "'!");
				refresh();
				return true;
			} else {
				return false;
			}
		}
	}

	private boolean chooseFile() {
		fileChooser = new JFileChooser();
		// Chỉ cho phép chọn tệp hình ảnh
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png");
		fileChooser.setFileFilter(filter);
		// Thiết lập thư mục mặc định khi mở
		File defaultDirectory = new File(System.getProperty("user.dir") + "/data/image");
		fileChooser.setCurrentDirectory(defaultDirectory);

		// chon file
		int returnValue = fileChooser.showOpenDialog(null);
		selectedFile = fileChooser.getSelectedFile();

		try {
			String absolutePath = selectedFile.getAbsolutePath();
			absolutePath = absolutePath.replace("\\", "/");
			// cắt chuỗi từ /image về sau
			relativePath = absolutePath.substring(absolutePath.indexOf("/image"));
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn file!");
		}

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			// Nhấn Open file
			lblHinhAnh.setIcon(new ImageIcon(Sach_GUI.class.getResource(relativePath)));
			return true;
		} else // JFileChooser.CANCEL_OPTION
			return false;
	}

	public boolean xuatFile(ArrayList<SanPham> ds) {
		fileChooser = new JFileChooser();
		int userSelection = fileChooser.showSaveDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			String excelFilePath = fileToSave.getAbsolutePath();
			// Đảm bảo tệp có đuôi
			if (!excelFilePath.endsWith(".xlsx")) {
				excelFilePath += ".xlsx";
			}
			try {
				wordkbook = new XSSFWorkbook();
				XSSFSheet sheet = wordkbook.createSheet("Danh Sách");
				XSSFRow row = null;
				XSSFCell cell = null;
				row = (XSSFRow) sheet.createRow(2);
				cell = row.createCell(0, CellType.STRING);
				cell.setCellValue("STT");

				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue("Mã SP");

				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue("Tên SP");

				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue("Xuất Xứ");

				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue("Giá Nhập");

				cell = row.createCell(5, CellType.STRING);
				cell.setCellValue("Giá Bán");

				cell = row.createCell(6, CellType.STRING);
				cell.setCellValue("Số Lượng Tồn");

				cell = row.createCell(7, CellType.STRING);
				cell.setCellValue("Nhà Xuất Bản");

				cell = row.createCell(8, CellType.STRING);
				cell.setCellValue("Thể Loại Sách");

				cell = row.createCell(9, CellType.STRING);
				cell.setCellValue("Tác Giả");

				cell = row.createCell(10, CellType.STRING);
				cell.setCellValue("Số Trang");

				cell = row.createCell(11, CellType.STRING);
				cell.setCellValue("Năm Xuất Bản");
				for (int i = 0; i < ds.size(); i++) {

					row = (XSSFRow) sheet.createRow(3 + i);
					cell = row.createCell(0, CellType.NUMERIC);
					cell.setCellValue(i + 1);

					cell = row.createCell(1, CellType.STRING);
					cell.setCellValue(ds.get(i).getMaSanPham());

					cell = row.createCell(2, CellType.STRING);
					cell.setCellValue(ds.get(i).getTenSanPham());

					cell = row.createCell(3, CellType.STRING);
					cell.setCellValue(ds.get(i).getXuatXu());

					cell = row.createCell(4, CellType.STRING);
					cell.setCellValue(ds.get(i).getGiaNhap());

					cell = row.createCell(5, CellType.STRING);
					cell.setCellValue(ds.get(i).getGiaBan());

					cell = row.createCell(6, CellType.STRING);
					cell.setCellValue(ds.get(i).getSoLuongTon());

					cell = row.createCell(7, CellType.STRING);
					cell.setCellValue(ds.get(i).getMaNXB());

					cell = row.createCell(8, CellType.STRING);
					cell.setCellValue(ds.get(i).getMaTheLoaiSach());

					cell = row.createCell(9, CellType.STRING);
					cell.setCellValue(ds.get(i).getTacGia());

					cell = row.createCell(10, CellType.STRING);
					cell.setCellValue(ds.get(i).getSoTrang());

					cell = row.createCell(11, CellType.STRING);
					cell.setCellValue(ds.get(i).getNamXuatBan());

				}
				FileOutputStream fis = new FileOutputStream(excelFilePath);
				wordkbook.write(fis);
				fis.close();
				JOptionPane.showMessageDialog(null, "Xuất File Thành Công !");
			} catch (Exception e) {

			}
		}
		return false;
	}

	private void enableEdit() {
		txtMaSach.setEditable(true);
		txtMaSach.setBorder(borderDefault);
		txtTenSach.setEditable(true);
		txtTenSach.setBorder(null);
		txtXuatXu.setEditable(true);
		txtXuatXu.setBorder(null);
		txtTacGia.setEditable(true);
		txtTacGia.setBorder(null);
		txtGiaNhap.setEditable(true);
		txtGiaNhap.setBorder(null);
		txtGiaBan.setEditable(true);
		txtGiaBan.setBorder(null);
		txtSoTrang.setEditable(true);
		txtSoTrang.setBorder(null);
		txtSoLuong.setEditable(true);
		txtSoLuong.setBorder(null);
		txtNamXuatBan.setEditable(true);
		txtNamXuatBan.setBorder(null);
		cmbTenLoaiSach.setEnabled(true);
		cmbTenLoaiSach.setBorder(null);
		cmbTenNhaXuatBan.setEnabled(true);
		cmbTenNhaXuatBan.setBorder(null);
	}

	private void disableEdit() {
		txtMaSach.setEditable(false);
		txtMaSach.setBorder(borderDefault);
		txtTenSach.setEditable(false);
		txtTenSach.setBorder(null);
		txtXuatXu.setEditable(false);
		txtXuatXu.setBorder(null);
		txtTacGia.setEditable(false);
		txtTacGia.setBorder(null);
		txtGiaNhap.setEditable(false);
		txtGiaNhap.setBorder(null);
		txtGiaBan.setEditable(false);
		txtGiaBan.setBorder(null);
		txtSoTrang.setEditable(false);
		txtSoTrang.setBorder(null);
		txtSoLuong.setEditable(false);
		txtSoLuong.setBorder(null);
		txtNamXuatBan.setEditable(false);
		txtNamXuatBan.setBorder(null);
		cmbTenLoaiSach.setEnabled(false);
		cmbTenLoaiSach.setBorder(null);
		cmbTenNhaXuatBan.setEnabled(false);
		cmbTenNhaXuatBan.setBorder(null);
	}

	private void enableButton() {
		btnLamMoi.setEnabled(true);
		btnAdd.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
		btnChonHinhAnh.setEnabled(true);
		btnKhoiPhuc.setEnabled(true);
	}

	private void offFocus() {
		txtMaSach.setFocusable(false);
		txtTenSach.setFocusable(false);
		txtXuatXu.setFocusable(false);
		txtTacGia.setFocusable(false);
		txtGiaNhap.setFocusable(false);
		txtGiaBan.setFocusable(false);
		txtNamXuatBan.setFocusable(false);
		txtSoTrang.setFocusable(false);
		txtSoLuong.setFocusable(false);
	}

	@SuppressWarnings("unused")
	private void openFocus() {
		txtMaSach.setFocusable(false);
		txtTenSach.setFocusable(true);
		txtXuatXu.setFocusable(true);
		txtTacGia.setFocusable(true);
		txtGiaNhap.setFocusable(true);
		txtGiaBan.setFocusable(true);
		txtNamXuatBan.setFocusable(true);
		txtSoTrang.setFocusable(true);
		txtSoLuong.setFocusable(true);
	}

	private void disableButton() {
		btnLamMoi.setEnabled(false);
		btnAdd.setEnabled(false);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnChonHinhAnh.setEnabled(false);
		btnKhoiPhuc.setEnabled(false);
	}

	private void focusable() {
		txtMaSach.setFocusable(true);
		txtTenSach.setFocusable(true);
		txtXuatXu.setFocusable(true);
		txtTacGia.setFocusable(true);
		txtGiaNhap.setFocusable(true);
		txtGiaBan.setFocusable(true);
		txtSoLuong.setFocusable(true);
		txtSoTrang.setFocusable(true);
		txtNamXuatBan.setFocusable(true);
	}

	private void unfocusable() {
		txtMaSach.setFocusable(false);
		txtTenSach.setFocusable(false);
		txtXuatXu.setFocusable(false);
		txtTacGia.setFocusable(false);
		txtGiaNhap.setFocusable(false);
		txtGiaBan.setFocusable(false);
		txtSoLuong.setFocusable(false);
		txtSoTrang.setFocusable(false);
		txtNamXuatBan.setFocusable(false);
	}
}