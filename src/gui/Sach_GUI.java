package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
import javax.swing.JDesktopPane;

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
	private JLabel lblAnh;
	private JLabel lblHinhAnh;
	private JLabel lblNamXuatBan;

	private JComboBox<String> cbTenLoaiSach;
	private JComboBox<String> cbTenNhaXuatBan;

	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnLamMoi;
//	private JButton btnChonHinhAnh;
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

	private JButton btnTim;

//	private String relativePath;
	private Border borderDefault;

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
//		pMain.add(desktopPane);

		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBounds(0, 0, 1300, 720);
//		add(pMain);
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
		lblMaSach.setBounds(40, 70, 90, 40);
		pThongTin.add(lblMaSach);

		lblTenSach = new JLabel("Tên Sách:");
		lblTenSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenSach.setBounds(40, 115, 90, 40);
		pThongTin.add(lblTenSach);

		lblXuatXu = new JLabel("Xuất Xứ:");
		lblXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXuatXu.setBounds(40, 160, 90, 40);
		pThongTin.add(lblXuatXu);

		lblTacGia = new JLabel("Tác Giả:");
		lblTacGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTacGia.setBounds(40, 205, 90, 40);
		pThongTin.add(lblTacGia);

		txtMaSach = new JTextField();
		txtMaSach.setToolTipText("Mã Sách");
		txtMaSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaSach.setEditable(false);
		txtMaSach.setColumns(10);
		txtMaSach.setBackground(Color.WHITE);
		txtMaSach.setBounds(145, 70, 255, 40);
		pThongTin.add(txtMaSach);

		txtTenSach = new JTextField();
		txtTenSach.setToolTipText("Tên Sách");
		txtTenSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenSach.setEditable(false);
		txtTenSach.setColumns(10);
		txtTenSach.setBackground(Color.WHITE);
		txtTenSach.setBounds(145, 115, 255, 40);
		pThongTin.add(txtTenSach);

		txtXuatXu = new JTextField();
		txtXuatXu.setToolTipText("Xuất xứ");
		txtXuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtXuatXu.setEditable(false);
		txtXuatXu.setColumns(10);
		txtXuatXu.setBackground(Color.WHITE);
		txtXuatXu.setBounds(145, 160, 255, 40);
		pThongTin.add(txtXuatXu);

		txtTacGia = new JTextField();
		txtTacGia.setToolTipText("Tác giả");
		txtTacGia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTacGia.setEditable(false);
		txtTacGia.setColumns(10);
		txtTacGia.setBackground(Color.WHITE);
		txtTacGia.setBounds(145, 207, 255, 40);
		pThongTin.add(txtTacGia);

		lblLoaiSach = new JLabel("Loại Sách:");
		lblLoaiSach.setToolTipText("thể loại sách ");
		lblLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoaiSach.setBounds(450, 70, 130, 40);
		pThongTin.add(lblLoaiSach);

		lblNhaXuatBan = new JLabel("Nhà Xuất Bản:");
		lblNhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNhaXuatBan.setBounds(450, 115, 130, 40);
		pThongTin.add(lblNhaXuatBan);

		lblGiaNhap = new JLabel("Giá Nhập:");
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaNhap.setBounds(450, 160, 130, 40);
		pThongTin.add(lblGiaNhap);

		lblGiaBan = new JLabel("Giá Bán:");
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaBan.setBounds(450, 205, 130, 40);
		pThongTin.add(lblGiaBan);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setToolTipText("Giá nhập");
		txtGiaNhap.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtGiaNhap.setEditable(false);
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBackground(Color.WHITE);
		txtGiaNhap.setBounds(600, 160, 255, 40);
		pThongTin.add(txtGiaNhap);

		txtGiaBan = new JTextField();
		txtGiaBan.setToolTipText("Giá bán");
		txtGiaBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtGiaBan.setEditable(false);
		txtGiaBan.setColumns(10);
		txtGiaBan.setBackground(Color.WHITE);
		txtGiaBan.setBounds(600, 205, 255, 40);
		pThongTin.add(txtGiaBan);

		cbTenLoaiSach = new JComboBox<String>();
		cbTenLoaiSach.setForeground(new Color(0, 0, 0));
		cbTenLoaiSach.setToolTipText("Loại Sách");
		cbTenLoaiSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTenLoaiSach.setBorder(null);
		cbTenLoaiSach.setBounds(600, 70, 255, 40);
		pThongTin.add(cbTenLoaiSach);

		cbTenNhaXuatBan = new JComboBox<String>();
		cbTenNhaXuatBan.setToolTipText("Nhà Xuất Bản");
		cbTenNhaXuatBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTenNhaXuatBan.setBorder(null);
		cbTenNhaXuatBan.setBounds(600, 115, 255, 40);
		pThongTin.add(cbTenNhaXuatBan);

		lblSoTrang = new JLabel("Số Trang:");
		lblSoTrang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoTrang.setBounds(900, 115, 90, 40);
		pThongTin.add(lblSoTrang);

		lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoLuong.setBounds(900, 160, 90, 40);
		pThongTin.add(lblSoLuong);

		lblAnh = new JLabel("Ảnh:");
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAnh.setBounds(900, 205, 80, 40);
		pThongTin.add(lblAnh);

		txtSoTrang = new JTextField();
		txtSoTrang.setToolTipText("Số Trang Sách");
		txtSoTrang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoTrang.setEditable(false);
		txtSoTrang.setColumns(10);
		txtSoTrang.setBackground(Color.WHITE);
		txtSoTrang.setBounds(1005, 115, 215, 40);
		pThongTin.add(txtSoTrang);

		txtSoLuong = new JTextField();
		txtSoLuong.setToolTipText("Số Lượng Sách");
		txtSoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBackground(Color.WHITE);
		txtSoLuong.setBounds(1005, 162, 215, 40);
		pThongTin.add(txtSoLuong);

		btnAdd = new JButton("Thêm");
		btnAdd.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/add_person.png")));
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(104, 278, 135, 40);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnAdd.getText().equals("Thêm")) {
					enableEdit();
					btnDelete.setText("Hủy");
					btnAdd.setText("Xác nhận");
					btnLamMoi.setEnabled(false);
					btnUpdate.setEnabled(false);
					btnTim.setEnabled(false);

				} else {
					add();
					disableEdit();
					btnAdd.setText("Thêm");
					btnDelete.setText("Xóa");
					btnLamMoi.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnTim.setEnabled(true);
				}
			}
		});
		pThongTin.add(btnAdd);
		btnDelete = new JButton("Xóa");
		btnDelete.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/remove_person.png")));
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(343, 278, 135, 40);
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
		btnUpdate.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/update_person.png")));
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(582, 278, 135, 40);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnUpdate.getText().equals("Sửa")) {
					enableEdit();
					btnDelete.setText("Hủy");
					btnUpdate.setText("Xác nhận");
					btnLamMoi.setEnabled(false);
					btnAdd.setEnabled(false);
					btnTim.setEnabled(false);
				} else {
					update();
					btnUpdate.setText("Sửa");
					btnDelete.setText("Xóa");
					disableEdit();
					btnLamMoi.setEnabled(true);
					btnAdd.setEnabled(true);
					btnTim.setEnabled(true);
				}
			}
		});
		pThongTin.add(btnUpdate);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setOpaque(true);
		btnLamMoi.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.setBounds(821, 278, 135, 40);
		pThongTin.add(btnLamMoi);

		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setBounds(1005, 205, 215, 40);
		pThongTin.add(lblHinhAnh);

		txtNamXuatBan = new JTextField();
		txtNamXuatBan.setToolTipText("năm xuất bản");
		txtNamXuatBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNamXuatBan.setEditable(false);
		txtNamXuatBan.setColumns(10);
		txtNamXuatBan.setBackground(Color.WHITE);
		txtNamXuatBan.setBounds(1005, 65, 215, 40);
		pThongTin.add(txtNamXuatBan);

		lblNamXuatBan = new JLabel("Năm XB::");
		lblNamXuatBan.setToolTipText("Năm Xuất Bản:");
		lblNamXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNamXuatBan.setBounds(890, 70, 90, 40);
		pThongTin.add(lblNamXuatBan);

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/find_person.png")));
		btnTim.setOpaque(true);
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(1060, 278, 135, 40);
		btnTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (timKiemSach_GUI == null || timKiemSach_GUI.isClosed()) {
					timKiemSach_GUI = new TimKiemSach_GUI(ds);
					timKiemSach_GUI.addInternalFrameListener(new InternalFrameAdapter() {
						@Override
						public void internalFrameActivated(InternalFrameEvent e) {
//			                System.out.println("Internal frame is activated.");
						}

						@Override
						public void internalFrameDeactivated(InternalFrameEvent e) {
//			                System.out.println("Internal frame is deactivated.");
						}

						@Override
						public void internalFrameOpened(InternalFrameEvent e) {
//			                System.out.println("Internal frame is opened.");
							disableButton();
						}

						@Override
						public void internalFrameClosed(InternalFrameEvent e) {
//			                System.out.println("Internal frame is closed.");
//							model.setRowCount(0);
							enableButton();
							loadData(ds);
			            	ds.removeAll(ds);
			            	btnAdd.setEnabled(true);
							btnDelete.setEnabled(true);
							btnUpdate.setEnabled(true);
							btnUpdate.setEnabled(true);
						}
					});
					desktopPane.add(timKiemSach_GUI).setVisible(true);
//					loadDataIntoTable(timKiemSach_GUI.searchSach());
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
				if (row >= 0) {
					txtMaSach.setText((String) model.getValueAt(row, 0));
					txtTenSach.setText((String) model.getValueAt(row, 1));
					txtXuatXu.setText((String) model.getValueAt(row, 2));
					txtGiaNhap.setText(model.getValueAt(row, 3).toString());
					txtGiaBan.setText(model.getValueAt(row, 4).toString());
					txtSoLuong.setText(model.getValueAt(row, 5).toString());
					cbTenNhaXuatBan.setSelectedItem(model.getValueAt(row, 6));

					txtTacGia.setText(model.getValueAt(row, 8).toString());
					txtSoTrang.setText(model.getValueAt(row, 9).toString());
					txtNamXuatBan.setText(model.getValueAt(row, 10).toString());
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
		table.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

		JLabel lblChiTitSch = new JLabel("Chi Tiết Sách");
		lblChiTitSch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTitSch.setBounds(22, 10, 200, 40);
		pDanhSach.add(lblChiTitSch);

		loadData(sanPham_DAO.getAllSach());
		loadDataIntoComboboxTenNhaXuatBan();
		loadDataIntoComboboxTenLoaiSach();
	}

	public Sach_GUI() {

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
//		pMain.add(desktopPane);

		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBounds(0, 0, 1300, 720);
//		add(pMain);
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
		lblMaSach.setBounds(40, 70, 90, 40);
		pThongTin.add(lblMaSach);

		lblTenSach = new JLabel("Tên Sách:");
		lblTenSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenSach.setBounds(40, 115, 90, 40);
		pThongTin.add(lblTenSach);

		lblXuatXu = new JLabel("Xuất Xứ:");
		lblXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXuatXu.setBounds(40, 160, 90, 40);
		pThongTin.add(lblXuatXu);

		lblTacGia = new JLabel("Tác Giả:");
		lblTacGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTacGia.setBounds(40, 205, 90, 40);
		pThongTin.add(lblTacGia);

		txtMaSach = new JTextField();
		txtMaSach.setToolTipText("Mã Sách");
		txtMaSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaSach.setEditable(false);
		txtMaSach.setColumns(10);
		txtMaSach.setBackground(Color.WHITE);
		txtMaSach.setBounds(145, 70, 255, 40);
		pThongTin.add(txtMaSach);

		txtTenSach = new JTextField();
		txtTenSach.setToolTipText("Tên Sách");
		txtTenSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenSach.setEditable(false);
		txtTenSach.setColumns(10);
		txtTenSach.setBackground(Color.WHITE);
		txtTenSach.setBounds(145, 115, 255, 40);
		pThongTin.add(txtTenSach);

		txtXuatXu = new JTextField();
		txtXuatXu.setToolTipText("Xuất xứ");
		txtXuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtXuatXu.setEditable(false);
		txtXuatXu.setColumns(10);
		txtXuatXu.setBackground(Color.WHITE);
		txtXuatXu.setBounds(145, 160, 255, 40);
		pThongTin.add(txtXuatXu);

		txtTacGia = new JTextField();
		txtTacGia.setToolTipText("Tác giả");
		txtTacGia.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTacGia.setEditable(false);
		txtTacGia.setColumns(10);
		txtTacGia.setBackground(Color.WHITE);
		txtTacGia.setBounds(145, 207, 255, 40);
		pThongTin.add(txtTacGia);

		lblLoaiSach = new JLabel("Loại Sách:");
		lblLoaiSach.setToolTipText("thể loại sách ");
		lblLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoaiSach.setBounds(450, 70, 130, 40);
		pThongTin.add(lblLoaiSach);

		lblNhaXuatBan = new JLabel("Nhà Xuất Bản:");
		lblNhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNhaXuatBan.setBounds(450, 115, 130, 40);
		pThongTin.add(lblNhaXuatBan);

		lblGiaNhap = new JLabel("Giá Nhập:");
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaNhap.setBounds(450, 160, 130, 40);
		pThongTin.add(lblGiaNhap);

		lblGiaBan = new JLabel("Giá Bán:");
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaBan.setBounds(450, 205, 130, 40);
		pThongTin.add(lblGiaBan);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setToolTipText("Giá nhập");
		txtGiaNhap.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtGiaNhap.setEditable(false);
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBackground(Color.WHITE);
		txtGiaNhap.setBounds(600, 160, 255, 40);
		pThongTin.add(txtGiaNhap);

		txtGiaBan = new JTextField();
		txtGiaBan.setToolTipText("Giá bán");
		txtGiaBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtGiaBan.setEditable(false);
		txtGiaBan.setColumns(10);
		txtGiaBan.setBackground(Color.WHITE);
		txtGiaBan.setBounds(600, 205, 255, 40);
		pThongTin.add(txtGiaBan);

		cbTenLoaiSach = new JComboBox<String>();
		cbTenLoaiSach.setForeground(new Color(0, 0, 0));
		cbTenLoaiSach.setToolTipText("Loại Sách");
		cbTenLoaiSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTenLoaiSach.setBorder(null);
		cbTenLoaiSach.setBounds(600, 70, 255, 40);
		pThongTin.add(cbTenLoaiSach);

		cbTenNhaXuatBan = new JComboBox<String>();
		cbTenNhaXuatBan.setToolTipText("Nhà Xuất Bản");
		cbTenNhaXuatBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTenNhaXuatBan.setBorder(null);
		cbTenNhaXuatBan.setBounds(600, 115, 255, 40);
		pThongTin.add(cbTenNhaXuatBan);

		lblSoTrang = new JLabel("Số Trang:");
		lblSoTrang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoTrang.setBounds(900, 115, 90, 40);
		pThongTin.add(lblSoTrang);

		lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoLuong.setBounds(900, 160, 90, 40);
		pThongTin.add(lblSoLuong);

		lblAnh = new JLabel("Ảnh:");
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAnh.setBounds(900, 205, 80, 40);
		pThongTin.add(lblAnh);

		txtSoTrang = new JTextField();
		txtSoTrang.setToolTipText("Số Trang Sách");
		txtSoTrang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoTrang.setEditable(false);
		txtSoTrang.setColumns(10);
		txtSoTrang.setBackground(Color.WHITE);
		txtSoTrang.setBounds(1005, 115, 215, 40);
		pThongTin.add(txtSoTrang);

		txtSoLuong = new JTextField();
		txtSoLuong.setToolTipText("Số Lượng Sách");
		txtSoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBackground(Color.WHITE);
		txtSoLuong.setBounds(1005, 162, 215, 40);
		pThongTin.add(txtSoLuong);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setOpaque(true);
		btnLamMoi.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.setBounds(904, 278, 135, 40);
		pThongTin.add(btnLamMoi);

		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setBounds(1005, 205, 215, 40);
		pThongTin.add(lblHinhAnh);

		txtNamXuatBan = new JTextField();
		txtNamXuatBan.setToolTipText("năm xuất bản");
		txtNamXuatBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNamXuatBan.setEditable(false);
		txtNamXuatBan.setColumns(10);
		txtNamXuatBan.setBackground(Color.WHITE);
		txtNamXuatBan.setBounds(1005, 65, 215, 40);
		pThongTin.add(txtNamXuatBan);

		lblNamXuatBan = new JLabel("Năm XB::");
		lblNamXuatBan.setToolTipText("Năm Xuất Bản:");
		lblNamXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNamXuatBan.setBounds(890, 70, 90, 40);
		pThongTin.add(lblNamXuatBan);

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/find_person.png")));
		btnTim.setOpaque(true);
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(1060, 278, 135, 40);
		btnTim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (timKiemSach_GUI == null || timKiemSach_GUI.isClosed()) {
					timKiemSach_GUI = new TimKiemSach_GUI(ds);
					timKiemSach_GUI.addInternalFrameListener(new InternalFrameAdapter() {
						@Override
						public void internalFrameActivated(InternalFrameEvent e) {
//			                System.out.println("Internal frame is activated.");
						}

						@Override
						public void internalFrameDeactivated(InternalFrameEvent e) {
//			                System.out.println("Internal frame is deactivated.");
						}

						@Override
						public void internalFrameOpened(InternalFrameEvent e) {
//			                System.out.println("Internal frame is opened.");
							btnLamMoi.setEnabled(false);
						}

						@Override
						public void internalFrameClosed(InternalFrameEvent e) {
//			                System.out.println("Internal frame is closed.");
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
				if (row >= 0) {
					txtMaSach.setText((String) model.getValueAt(row, 0));
					txtTenSach.setText((String) model.getValueAt(row, 1));
					txtXuatXu.setText((String) model.getValueAt(row, 2));
					txtGiaNhap.setText(model.getValueAt(row, 3).toString());
					txtGiaBan.setText(model.getValueAt(row, 4).toString());
					txtSoLuong.setText(model.getValueAt(row, 5).toString());
					cbTenNhaXuatBan.setSelectedItem(model.getValueAt(row, 6));

					txtTacGia.setText(model.getValueAt(row, 8).toString());
					txtSoTrang.setText(model.getValueAt(row, 9).toString());
					txtNamXuatBan.setText(model.getValueAt(row, 10).toString());
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
		table.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

		JLabel lblChiTitSch = new JLabel("Chi Tiết Sách");
		lblChiTitSch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTitSch.setBounds(22, 10, 200, 40);
		pDanhSach.add(lblChiTitSch);

		loadData(sanPham_DAO.getAllSach());
		loadDataIntoComboboxTenNhaXuatBan();
		loadDataIntoComboboxTenLoaiSach();
	}

	protected void loadDataIntoComboboxTenSP(String string) {
		// TODO Auto-generated method stub

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
	// load cbTenNhaXuatBan
	private void loadDataIntoComboboxTenNhaXuatBan() {

		for (NhaXuatBan nhaXuatBan : nhaXuatBan_DAO.getAllListNhaXuatBan()) {
			cbTenNhaXuatBan.addItem(nhaXuatBan.getTenNhaXuatBan());
		}

	}

	// load cbTenTheLoaiSachs
	private void loadDataIntoComboboxTenLoaiSach() {

		for (TheLoaiSach theLoaiSach : theLoaiSach_DAO.getAllListTheLoaiSach()) {
			cbTenLoaiSach.addItem(theLoaiSach.gettenTheLoaiSach());
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
		cbTenLoaiSach.setSelectedIndex(-1);
		cbTenLoaiSach.setSelectedIndex(-1);
	}

	public void refresh() {
		loadData(sanPham_DAO.getAllSach());
	}

	// thêm sách
	public boolean add() {
		if (txtTenSach.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên sách không được để trống!");
			txtTenSach.requestFocus();
			return false;
		} else if (txtXuatXu.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Xuất xứ sách không được để trống!");
			txtXuatXu.requestFocus();
			return false;
		} else if (txtGiaNhap.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Giá nhập sách không được để trống!");
			txtGiaNhap.requestFocus();
			return false;
		} else if (txtGiaBan.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Giá bán sách không được để trống!");
			txtGiaBan.requestFocus();
			return false;
		} else if (txtSoLuong.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số lượng sách không được để trống!");
			txtSoLuong.requestFocus();
			return false;
		} else if (cbTenNhaXuatBan.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Chưa chọn nhà xuất bản!");
			return false;
		} else if (cbTenLoaiSach.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Chưa chọn loại sách!");
			return false;
		} else if (txtTacGia.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên tác giả không được để trống!");
			txtTacGia.requestFocus();
			return false;
		} else if (txtSoTrang.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số trang sách không được để trống!");
			txtSoTrang.requestFocus();
			return false;
		} else if (txtNamXuatBan.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Năm xuất bản sách không được để trống!");
			txtNamXuatBan.requestFocus();
			return false;
		} else {
			try {
				SanPham sanPham = new SanPham();
				sanPham.setMaSanPham(phatSinhMa_DAO.getMaSach());
				sanPham.setTenSanPham(txtTenSach.getText());
				sanPham.setXuatXu(txtXuatXu.getText());
				sanPham.setGiaNhap(Float.parseFloat(txtGiaNhap.getText()));
				sanPham.setGiaBan(Float.parseFloat(txtGiaBan.getText()));
				sanPham.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
				if (cbTenNhaXuatBan.getSelectedIndex() != -1) {
					nhaXuatBan = nhaXuatBan_DAO.getnhaXuatBanTheoTen(cbTenNhaXuatBan.getSelectedItem().toString());
				}
				sanPham.setMaNXB(nhaXuatBan.getMaNhaXuatBan());
				if (cbTenLoaiSach.getSelectedIndex() != -1) {
					theLoaiSach = theLoaiSach_DAO.getTheLoaiSachTheoTen(cbTenLoaiSach.getSelectedItem().toString());
				}
				sanPham.setMaTheLoaiSach(theLoaiSach.getmaTheLoaiSach());
				sanPham.setTacGia(txtTacGia.getText());
				sanPham.setSoTrang(Integer.parseInt(txtSoTrang.getText()));
				sanPham.setNamXuatBan(Integer.parseInt(txtNamXuatBan.getText()));
				sanPham.setMaNhaCungCap(null);
				sanPham.setHinhAnh("a");

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

	// xóa sách
	public boolean delete() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Bạn phải chọn sách cần xóa!");
			return false;
		} else {
			int option = JOptionPane.showConfirmDialog(null,
					"Bạn có chắc muốn xóa sách '" + model.getValueAt(row, 1) + "' chứ?", "Xóa?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				try {
					sanPham_DAO.xoaSachTheoMa(model.getValueAt(row, 0).toString());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Không thể xóa sách này. Có thể đã có dữ liệu liên quan!");
					return false;
				}
				JOptionPane.showMessageDialog(null, "Xóa sách '" + model.getValueAt(row, 1) + "' thành công!");
				refresh();
				return true;
			} else {
				return false;
			}
		}
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
					sanPham.setHinhAnh("a");
					sanPham.setMaNXB(nhaXuatBan_DAO.getnhaXuatBanTheoTen(cbTenNhaXuatBan.getSelectedItem().toString())
							.getMaNhaXuatBan());
					sanPham.setMaTheLoaiSach(
							theLoaiSach_DAO.getTheLoaiSachTheoTen(cbTenLoaiSach.getSelectedItem().toString().toString())
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
		cbTenLoaiSach.setEnabled(true);
		cbTenLoaiSach.setBorder(null);
		cbTenNhaXuatBan.setEnabled(true);
		cbTenNhaXuatBan.setBorder(null);
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
		cbTenLoaiSach.setEnabled(false);
		cbTenLoaiSach.setBorder(null);
		cbTenNhaXuatBan.setEnabled(false);
		cbTenNhaXuatBan.setBorder(null);
	}

	@SuppressWarnings("unused")
	private void enableButton() {
		btnLamMoi.setEnabled(true);
		btnAdd.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
//		btnChonHinhAnh.setEnabled(true);
	}

	private void disableButton() {
		btnLamMoi.setEnabled(false);
		btnAdd.setEnabled(false);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
//		btnChonHinhAnh.setEnabled(false);
	}
}
