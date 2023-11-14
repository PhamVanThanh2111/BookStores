package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.apache.poi.ss.usermodel.CellType;

import dao.NhaCungCap_DAO;
import dao.PhatSinhMa_DAO;
import dao.SanPham_DAO;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.SanPham;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JDesktopPane;

public class DungCuHocTap_GUI extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtmaDCHT;
	private JTextField txttenDCHT;
	private JTextField txtsoLuong;
	private JTextField txtgiaBan;
	private JTextField txtgiaNhap;
	private JTable table;
	private JTableHeader tableHeader;
	private DefaultTableModel model;
	private SanPham_DAO sanPham_DAO;
	private JButton btnAdd, btnlamMoi, btnUpdate, btnDelete;
	private PhatSinhMa_DAO phatSinhMa_DAO;
	private JTextField txtXuatXu;
	private NhaCungCap_DAO nhaCC_DAO;
	private NhaCungCap nhacc;
	private JFileChooser fileChooser;
	private File selectedFile;
	private String relativePath;
	private JLabel lblHinhAnh;
	private ArrayList<SanPham> ds;
	private JButton btnTim;
	private JDesktopPane desktopPane;
	private TimKiemDungCuHoctap timKiemDungCuHoctap;
	private JButton btnChonHinhAnh;
	private Border borderDefault;
	private JComboBox<String> cbNhaCC;
	private KhoiPhucDungCuHocTap_GUI khoiPhucDuLieu;
	private JButton btnXuatFile;
	private JButton btnKhoiPhuc;
	private XSSFWorkbook wordkbook;

	/**
	 * Create the panel.
	 */
	public DungCuHocTap_GUI(NhanVien nhanVien) {

		// khai bao DAO
		sanPham_DAO = new SanPham_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();
		nhaCC_DAO = new NhaCungCap_DAO();
		ds = new ArrayList<SanPham>();

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1300, 720);
		add(panel);
		panel.setLayout(null);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1300, 720);
		panel.add(desktopPane);

		JPanel pMain = new JPanel();
		pMain.setBounds(0, 0, 1300, 720);
		pMain.setLayout(null);
		desktopPane.add(pMain);

		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1300, 370);
		pMain.add(pThongTin);

		JLabel lblthongTinDCHT = new JLabel("Thông Tin Dụng Cụ Học Tập");
		lblthongTinDCHT.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthongTinDCHT.setBounds(20, 15, 260, 40);
		pThongTin.add(lblthongTinDCHT);

		JLabel lblmaDCHT = new JLabel("Mã DCHT:");
		lblmaDCHT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmaDCHT.setBounds(40, 70, 90, 40);
		pThongTin.add(lblmaDCHT);

		JLabel lbltenDCHT = new JLabel("Tên DCHT:");
		lbltenDCHT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltenDCHT.setBounds(40, 115, 90, 40);
		pThongTin.add(lbltenDCHT);

		JLabel lblnhaCC = new JLabel("Nhà CC:");
		lblnhaCC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnhaCC.setBounds(40, 160, 90, 40);
		pThongTin.add(lblnhaCC);

		txtmaDCHT = new JTextField();
		txtmaDCHT.setToolTipText("Mã Sách");
		txtmaDCHT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtmaDCHT.setEditable(false);
		txtmaDCHT.setColumns(10);
		txtmaDCHT.setBackground(Color.WHITE);
		txtmaDCHT.setBounds(145, 70, 255, 40);
		txtmaDCHT.setFocusable(false);
		txtmaDCHT.setEditable(false);

		pThongTin.add(txtmaDCHT);

		txttenDCHT = new JTextField();
		txttenDCHT.setToolTipText("Tên Sách");
		txttenDCHT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txttenDCHT.setEditable(false);
		txttenDCHT.setColumns(10);
		txttenDCHT.setBackground(Color.WHITE);
		txttenDCHT.setBounds(145, 115, 255, 40);
		borderDefault = txttenDCHT.getBorder();
		pThongTin.add(txttenDCHT);

		JLabel lblgia = new JLabel("Giá Nhập:");
		lblgia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgia.setBounds(450, 115, 130, 40);
		pThongTin.add(lblgia);

		JLabel lblnhaXuatBan = new JLabel("Giá Bán:");
		lblnhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnhaXuatBan.setBounds(450, 160, 130, 40);
		pThongTin.add(lblnhaXuatBan);

		JLabel lblgiaNhap = new JLabel("Số Lượng:");
		lblgiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgiaNhap.setBounds(450, 205, 98, 40);
		pThongTin.add(lblgiaNhap);

		txtsoLuong = new JTextField();
		txtsoLuong.setToolTipText("Giá nhập");
		txtsoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtsoLuong.setEditable(false);
		txtsoLuong.setColumns(10);
		txtsoLuong.setBackground(Color.WHITE);
		txtsoLuong.setBounds(550, 205, 255, 40);
		pThongTin.add(txtsoLuong);

		btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(70, 298, 135, 40);
		pThongTin.add(btnAdd);

		btnDelete = new JButton("Xóa");
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(275, 298, 135, 40);
		pThongTin.add(btnDelete);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(480, 298, 135, 40);
		pThongTin.add(btnUpdate);

		btnlamMoi = new JButton("Làm mới");
		btnlamMoi.setOpaque(true);
		btnlamMoi.setForeground(Color.WHITE);
		btnlamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnlamMoi.setBackground(new Color(73, 129, 158));
		btnlamMoi.setBounds(685, 298, 135, 40);
		pThongTin.add(btnlamMoi);

		btnChonHinhAnh = new JButton("Choose");
		btnChonHinhAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFile();
			}
		});
		btnChonHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonHinhAnh.setBounds(1003, 226, 90, 19);
		pThongTin.add(btnChonHinhAnh);

		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setBounds(857, 70, 397, 146);
		pThongTin.add(lblHinhAnh);

		txtgiaBan = new JTextField();
		txtgiaBan.setToolTipText("Giá nhập");
		txtgiaBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtgiaBan.setEditable(false);
		txtgiaBan.setColumns(10);
		txtgiaBan.setBackground(Color.WHITE);
		txtgiaBan.setBounds(550, 160, 255, 40);
		pThongTin.add(txtgiaBan);

		txtgiaNhap = new JTextField();
		txtgiaNhap.setToolTipText("Giá nhập");
		txtgiaNhap.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtgiaNhap.setEditable(false);
		txtgiaNhap.setColumns(10);
		txtgiaNhap.setBackground(Color.WHITE);
		txtgiaNhap.setBounds(550, 115, 255, 40);
		pThongTin.add(txtgiaNhap);

		JLabel lblXutX = new JLabel("Xuất Xứ:");
		lblXutX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXutX.setBounds(40, 205, 94, 40);
		pThongTin.add(lblXutX);

		txtXuatXu = new JTextField();
		txtXuatXu.setToolTipText("Giá nhập");
		txtXuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtXuatXu.setEditable(false);
		txtXuatXu.setColumns(10);
		txtXuatXu.setBackground(Color.WHITE);
		txtXuatXu.setBounds(145, 205, 255, 40);
		pThongTin.add(txtXuatXu);

		btnTim = new JButton("Tìm");
		btnTim.setOpaque(true);
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(890, 298, 135, 40);
		pThongTin.add(btnTim);

		cbNhaCC = new JComboBox<String>();
		cbNhaCC.setToolTipText("Nhà Xuất Bản");
		cbNhaCC.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbNhaCC.setBorder(null);
		cbNhaCC.setBounds(145, 160, 255, 40);
		cbNhaCC.setBorder(borderDefault);
		cbNhaCC.setEnabled(false);
		loadCBNhaCC();
		cbNhaCC.setSelectedIndex(-1);
		pThongTin.add(cbNhaCC);

		btnKhoiPhuc = new JButton("Khôi Phục");
		btnKhoiPhuc.setOpaque(true);
		btnKhoiPhuc.setForeground(Color.WHITE);
		btnKhoiPhuc.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnKhoiPhuc.setBackground(new Color(73, 129, 158));
		btnKhoiPhuc.setBounds(1095, 298, 135, 40);
		pThongTin.add(btnKhoiPhuc);

		JPanel pDanhSach = new JPanel();
		pDanhSach.setLayout(null);
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBackground(Color.WHITE);
		pDanhSach.setBounds(0, 380, 1300, 340);
		pMain.add(pDanhSach);

		JScrollPane scrollPaneDungCuHocTap = new JScrollPane();
		scrollPaneDungCuHocTap.setToolTipText("Chọn vào Dụng cụ học tập cần hiển thị thông tin");
		scrollPaneDungCuHocTap.setBorder(null);
		scrollPaneDungCuHocTap.setBackground(Color.WHITE);
		scrollPaneDungCuHocTap.setBounds(30, 65, 1259, 250);
		pDanhSach.add(scrollPaneDungCuHocTap);

		String cols[] = { "Mã Dụng Cụ Học Tập", "Tên Dụng Cụ Học Tập ", "Xuất Xứ", "Giá Nhập", "Giá Bán",
				"Số Lượng Tồn", "Nhà Cung Cấp" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setToolTipText("Chọn vào dụng cụ học tập cần hiển thị thông tin");
		table.setRowHeight(30);
		table.setDefaultEditor(Object.class, null);
		table.setShowGrid(true);
		table.setShowHorizontalLines(true);
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(141, 208, 229));
		table.setSelectionForeground(new Color(0, 0, 0));

		scrollPaneDungCuHocTap.setViewportView(table);
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
		desktopPane.setLayout(null);

		JLabel lblChiTeitDungCuHocTap = new JLabel("Chi Tiết Dụng Cụ Học Tập");
		lblChiTeitDungCuHocTap.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTeitDungCuHocTap.setBounds(20, 15, 246, 40);
		pDanhSach.add(lblChiTeitDungCuHocTap);

		loadData(sanPham_DAO.getAllDungCuHocTap());

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		btnXuatFile = new JButton("Xuất File");
		btnXuatFile.setOpaque(true);
		btnXuatFile.setForeground(Color.WHITE);
		btnXuatFile.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXuatFile.setBackground(new Color(73, 129, 158));
		btnXuatFile.setBounds(1095, 15, 135, 40);
		pDanhSach.add(btnXuatFile);
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

				int r = table.getSelectedRow();
				SanPham dungCuHocTap = sanPham_DAO.getSanPhamTheoMaSanPham((String) model.getValueAt(r, 0).toString());
				txtmaDCHT.setText((String) model.getValueAt(r, 0));
				txttenDCHT.setText((String) model.getValueAt(r, 1));
				txtXuatXu.setText((String) model.getValueAt(r, 2));
				txtgiaNhap.setText((String) model.getValueAt(r, 3).toString());
				txtgiaBan.setText((String) model.getValueAt(r, 4).toString());
				txtsoLuong.setText((String) model.getValueAt(r, 5).toString());
				cbNhaCC.setSelectedItem((String) model.getValueAt(r, 6));
				lblHinhAnh.setIcon(new ImageIcon(DungCuHocTap_GUI.class.getResource(dungCuHocTap.getHinhAnh())));
				relativePath = dungCuHocTap.getHinhAnh();
			}
		});
		;

		if (nhanVien.getChucVu().equals("Bán hàng")) {
			btnAdd.setEnabled(false);
			btnDelete.setEnabled(false);
			btnUpdate.setEnabled(false);
			btnChonHinhAnh.setEnabled(false);
		}

		btnlamMoi.addActionListener(this);
		btnAdd.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnTim.addActionListener(this);
		btnKhoiPhuc.addActionListener(this);
		btnXuatFile.addActionListener(this);
		closeText();
	}

	public DungCuHocTap_GUI() {

		// khai bao DAO
		sanPham_DAO = new SanPham_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();
		nhaCC_DAO = new NhaCungCap_DAO();
		ds = new ArrayList<SanPham>();

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1300, 720);
		add(panel);
		panel.setLayout(null);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1300, 720);
		panel.add(desktopPane);

		JPanel pMain = new JPanel();
		pMain.setBounds(0, 0, 1300, 720);
		pMain.setLayout(null);
		desktopPane.add(pMain);

		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1300, 311);
		pMain.add(pThongTin);

		JLabel lblthongTinDCHT = new JLabel("Thông Tin Dụng Cụ Học Tập");
		lblthongTinDCHT.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthongTinDCHT.setBounds(20, 15, 260, 40);
		pThongTin.add(lblthongTinDCHT);

		JLabel lblmaDCHT = new JLabel("Mã DCHT:");
		lblmaDCHT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmaDCHT.setBounds(40, 70, 90, 40);
		pThongTin.add(lblmaDCHT);

		JLabel lbltenDCHT = new JLabel("Tên DCHT:");
		lbltenDCHT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltenDCHT.setBounds(448, 70, 90, 40);
		pThongTin.add(lbltenDCHT);

		JLabel lblnhaCC = new JLabel("Nhà CC:");
		lblnhaCC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnhaCC.setBounds(40, 115, 90, 40);
		pThongTin.add(lblnhaCC);

		txtmaDCHT = new JTextField();
		txtmaDCHT.setToolTipText("Mã Sách");
		txtmaDCHT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtmaDCHT.setEditable(false);
		txtmaDCHT.setColumns(10);
		txtmaDCHT.setBackground(Color.WHITE);
		txtmaDCHT.setBounds(145, 70, 255, 40);
		txtmaDCHT.setFocusable(false);
		txtmaDCHT.setEditable(false);

		pThongTin.add(txtmaDCHT);

		txttenDCHT = new JTextField();
		txttenDCHT.setToolTipText("Tên Sách");
		txttenDCHT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txttenDCHT.setEditable(false);
		txttenDCHT.setColumns(10);
		txttenDCHT.setBackground(Color.WHITE);
		txttenDCHT.setBounds(550, 70, 255, 40);
		pThongTin.add(txttenDCHT);

		JLabel lblnhaXuatBan = new JLabel("Giá Bán:");
		lblnhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnhaXuatBan.setBounds(448, 115, 130, 40);
		pThongTin.add(lblnhaXuatBan);

		JLabel lblgiaNhap = new JLabel("Số Lượng:");
		lblgiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgiaNhap.setBounds(448, 160, 98, 40);
		pThongTin.add(lblgiaNhap);

		txtsoLuong = new JTextField();
		txtsoLuong.setToolTipText("Giá nhập");
		txtsoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtsoLuong.setEditable(false);
		txtsoLuong.setColumns(10);
		txtsoLuong.setBackground(Color.WHITE);
		txtsoLuong.setBounds(550, 160, 255, 40);
		pThongTin.add(txtsoLuong);

		btnlamMoi = new JButton("Làm mới");
		btnlamMoi.setOpaque(true);
		btnlamMoi.setForeground(Color.WHITE);
		btnlamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnlamMoi.setBackground(new Color(73, 129, 158));
		btnlamMoi.setBounds(909, 255, 135, 40);
		btnlamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadCBNhaCC();
				lamMoi();
			}
		});
		pThongTin.add(btnlamMoi);

		btnChonHinhAnh = new JButton("Choose");
		btnChonHinhAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFile();
			}
		});
		btnChonHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonHinhAnh.setBounds(1003, 226, 90, 19);
		pThongTin.add(btnChonHinhAnh);

		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setBounds(857, 70, 397, 130);
		pThongTin.add(lblHinhAnh);

		txtgiaBan = new JTextField();
		txtgiaBan.setToolTipText("Giá nhập");
		txtgiaBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtgiaBan.setEditable(false);
		txtgiaBan.setColumns(10);
		txtgiaBan.setBackground(Color.WHITE);
		txtgiaBan.setBounds(550, 115, 255, 40);
		pThongTin.add(txtgiaBan);

		JLabel lblXutX = new JLabel("Xuất Xứ:");
		lblXutX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXutX.setBounds(40, 160, 94, 40);
		pThongTin.add(lblXutX);

		txtXuatXu = new JTextField();
		txtXuatXu.setToolTipText("Giá nhập");
		txtXuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtXuatXu.setEditable(false);
		txtXuatXu.setColumns(10);
		txtXuatXu.setBackground(Color.WHITE);
		txtXuatXu.setBounds(145, 160, 255, 40);
		pThongTin.add(txtXuatXu);

		cbNhaCC = new JComboBox<String>();
		cbNhaCC.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbNhaCC.setBounds(145, 115, 255, 40);
		loadCBNhaCC();
		cbNhaCC.setSelectedIndex(-1);
		pThongTin.add(cbNhaCC);
		btnTim = new JButton("Tìm");
		btnTim.setOpaque(true);
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(1060, 255, 135, 40);
		btnTim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (timKiemDungCuHoctap == null || timKiemDungCuHoctap.isClosed()) {
					timKiemDungCuHoctap = new TimKiemDungCuHoctap(ds);
					timKiemDungCuHoctap.addInternalFrameListener(new InternalFrameAdapter() {
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
							btnlamMoi.setEnabled(false);
						}

						@Override
						public void internalFrameClosed(InternalFrameEvent e) {
//			                System.out.println("Internal frame is closed.");
							loadData(ds);
							ds.removeAll(ds);
							btnlamMoi.setEnabled(true);
						}
					});
					desktopPane.add(timKiemDungCuHoctap).setVisible(true);
				}
			}
		});
		pThongTin.add(btnTim);

		JPanel pDanhSach = new JPanel();
		pDanhSach.setLayout(null);
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBackground(Color.WHITE);
		pDanhSach.setBounds(0, 329, 1300, 391);
		pMain.add(pDanhSach);

		JScrollPane scrollPaneDungCuHocTap = new JScrollPane();
		scrollPaneDungCuHocTap.setToolTipText("Chọn vào Dụng cụ học tập cần hiển thị thông tin");
		scrollPaneDungCuHocTap.setBorder(null);
		scrollPaneDungCuHocTap.setBackground(Color.WHITE);
		scrollPaneDungCuHocTap.setBounds(20, 65, 1259, 304);
		pDanhSach.add(scrollPaneDungCuHocTap);

		String cols[] = { "Mã Dụng Cụ Học Tập", "Tên Dụng Cụ Học Tập ", "Xuất Xứ", "Giá Bán",
				"Số Lượng Tồn", "Nhà Cung Cấp" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setToolTipText("Chọn vào dụng cụ học tập cần hiển thị thông tin");
		table.setRowHeight(30);
		table.setDefaultEditor(Object.class, null);
		table.setShowGrid(true);
		table.setShowHorizontalLines(true);
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(141, 208, 229));
		table.setSelectionForeground(new Color(0, 0, 0));

		scrollPaneDungCuHocTap.setViewportView(table);
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
//		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		desktopPane.setLayout(null);

		JLabel lblChiTeitDungCuHocTap = new JLabel("Chi Tiết Dụng Cụ Học Tập");
		lblChiTeitDungCuHocTap.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTeitDungCuHocTap.setBounds(20, 15, 246, 40);
		pDanhSach.add(lblChiTeitDungCuHocTap);

		loadDataDCHTChoKhachHang(sanPham_DAO.getAllDungCuHocTap());

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

				int r = table.getSelectedRow();
				SanPham dungCuHocTap = sanPham_DAO.getSanPhamTheoMaSanPham((String) model.getValueAt(r, 0).toString());
				txtmaDCHT.setText((String) model.getValueAt(r, 0));
				txttenDCHT.setText((String) model.getValueAt(r, 1));
				txtXuatXu.setText((String) model.getValueAt(r, 2));
				txtgiaBan.setText((String) model.getValueAt(r, 3).toString());
				txtsoLuong.setText((String) model.getValueAt(r, 4).toString());
				cbNhaCC.setSelectedItem((String) model.getValueAt(r, 5));
				lblHinhAnh.setIcon(new ImageIcon(DungCuHocTap_GUI.class.getResource(dungCuHocTap.getHinhAnh())));
				relativePath = dungCuHocTap.getHinhAnh();
			}
		});
		;
	}



	public void loadData(ArrayList<SanPham> ds) {
		// Xóa dữ liệu cũ trước khi nạp dữ liệu mới
		model.setRowCount(0);

		for (SanPham sanPham : ds) {
			Object[] object = { sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getXuatXu(),
					sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getSoLuongTon(),
					nhaCC_DAO.getNhaCCTheoMa(sanPham.getMaNhaCungCap()).getTenNCC() };
			model.addRow(object);
			table.setRowHeight(25);
		}
	}
	
	public void loadDataDCHTChoKhachHang(ArrayList<SanPham> ds) {
		// Xóa dữ liệu cũ trước khi nạp dữ liệu mới
		model.setRowCount(0);

		for (SanPham sanPham : ds) {
			Object[] object = { sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getXuatXu(),
					sanPham.getGiaBan(), sanPham.getSoLuongTon(),
					nhaCC_DAO.getNhaCCTheoMa(sanPham.getMaNhaCungCap()).getTenNCC() };
			model.addRow(object);
			table.setRowHeight(25);
		}
	}

	public void loadCBNhaCC() {
		for (NhaCungCap nhaCC : nhaCC_DAO.getAllNhaCungCap()) {
			cbNhaCC.addItem(nhaCC.getTenNCC());
		}
	}

	public void lamMoi() {
		txtmaDCHT.setText("");
		txttenDCHT.setText("");
		txtgiaNhap.setText("");
		txtXuatXu.setText("");
		txtgiaBan.setText("");
		txtsoLuong.setText("");
		cbNhaCC.setSelectedIndex(-1);
		lblHinhAnh.removeAll();
	}

	public void refresh() {
		loadData(sanPham_DAO.getAllDungCuHocTap());
	}

	public void closeText() {
		txttenDCHT.setEditable(false);
		txtXuatXu.setEditable(false);
		txtgiaNhap.setEditable(false);
		txtgiaBan.setEditable(false);
		txtsoLuong.setEditable(false);

		txttenDCHT.setFocusable(false);
		txtXuatXu.setFocusable(false);
		txtgiaNhap.setFocusable(false);
		txtgiaBan.setFocusable(false);
		txtsoLuong.setFocusable(false);
		cbNhaCC.setEnabled(false);

	}

	public void openText() {
		txttenDCHT.setEditable(true);
		txtXuatXu.setEditable(true);
		txtgiaNhap.setEditable(true);
		txtgiaBan.setEditable(true);
		txtsoLuong.setEditable(true);

		txttenDCHT.setFocusable(true);
		txtXuatXu.setFocusable(true);
		txtgiaNhap.setFocusable(true);
		txtgiaBan.setFocusable(true);
		txtsoLuong.setFocusable(true);
		cbNhaCC.setEnabled(true);

		cbNhaCC.setBorder(borderDefault);

	}

	public void themDCHT() {
		if (txtmaDCHT.getText().equalsIgnoreCase("") || txttenDCHT.getText().equalsIgnoreCase("")
				|| txtgiaNhap.getText().equalsIgnoreCase("") || txtgiaBan.getText().equalsIgnoreCase("")
				|| txtXuatXu.getText().equalsIgnoreCase("") || txtsoLuong.getText().equalsIgnoreCase("")
				|| cbNhaCC.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Thông Tin Rỗng !");
		} else {
			SanPham sanPham = new SanPham();

			try {
				sanPham.setMaSanPham(phatSinhMa_DAO.getMaDCHT());
				sanPham.setTenSanPham(txttenDCHT.getText());
				sanPham.setXuatXu(txtXuatXu.getText());
				sanPham.setGiaNhap(Float.parseFloat(txtgiaNhap.getText()));
				sanPham.setGiaBan(Float.parseFloat(txtgiaBan.getText()));
				sanPham.setSoLuongTon(Integer.parseInt(txtsoLuong.getText()));

				//
				if (cbNhaCC.getSelectedIndex() != -1) {
					nhacc = nhaCC_DAO.getNhaCungCapTheoTen(cbNhaCC.getSelectedItem().toString());
				}
				sanPham.setMaNhaCungCap(nhacc.getMaNCC());
				sanPham.setHinhAnh(relativePath);
				sanPham_DAO.themSanPham(sanPham);
				JOptionPane.showMessageDialog(null, "Thêm Sản Phẩm Thành Công !");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean xoaDungCuHocTap() {
		int row = table.getSelectedRow();
		if (row != -1) {
			int tb = JOptionPane.showConfirmDialog(null, "Bạn Muốn Xóa Sản Phẩm? ", "Delete",
					JOptionPane.YES_NO_OPTION);
			if (tb == JOptionPane.YES_OPTION) {
				try {
					SanPham sanPham = new SanPham();
					sanPham.setMaSanPham(txtmaDCHT.getText());
					sanPham.setTenSanPham(txttenDCHT.getText());
					sanPham.setXuatXu(txtXuatXu.getText());
					sanPham.setGiaNhap(Float.parseFloat(txtgiaNhap.getText()));
					sanPham.setGiaBan(Float.parseFloat(txtgiaBan.getText()));
					sanPham.setSoLuongTon(Integer.parseInt(txtsoLuong.getText()));
					sanPham.setHinhAnh(relativePath);
					sanPham.setMaNXB(null);
					sanPham.setMaTheLoaiSach(null);
					sanPham.setSoTrang(0);
					sanPham.setTacGia(null);
					sanPham.setNamXuatBan(0);
					sanPham.setMaNhaCungCap(
							nhaCC_DAO.getNhaCungCapTheoTen(cbNhaCC.getSelectedItem().toString()).getMaNCC());
					sanPham_DAO.suaMaDCHT(sanPham);
					JOptionPane.showMessageDialog(null, "Xóa Thành Công !");
					refresh();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Sản Phẩm Tồn Tại Trong Hóa Đơn !");
				}
			}
		}
		return false;
	}

	public boolean suaDCHT() throws SQLException {
		if (txtmaDCHT.getText().equalsIgnoreCase("") || txttenDCHT.getText().equalsIgnoreCase("")
				|| txtgiaNhap.getText().equalsIgnoreCase("") || txtgiaBan.getText().equalsIgnoreCase("")
				|| txtXuatXu.getText().equalsIgnoreCase("") || txtsoLuong.getText().equalsIgnoreCase("")
				|| cbNhaCC.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Thông Tin Rỗng !");
		} else {
			SanPham sanPham = new SanPham();
			sanPham.setMaSanPham(txtmaDCHT.getText());
			sanPham.setTenSanPham(txttenDCHT.getText());
			sanPham.setXuatXu(txtXuatXu.getText());
			sanPham.setGiaNhap(Float.parseFloat(txtgiaNhap.getText()));
			sanPham.setGiaBan(Float.parseFloat(txtgiaBan.getText()));
			sanPham.setSoLuongTon(Integer.parseInt(txtsoLuong.getText()));
			sanPham.setHinhAnh(relativePath);
			sanPham.setMaNXB(null);
			sanPham.setMaTheLoaiSach(null);
			sanPham.setSoTrang(0);
			sanPham.setTacGia(null);
			sanPham.setNamXuatBan(0);
			sanPham.setMaNhaCungCap(nhaCC_DAO.getNhaCungCapTheoTen(cbNhaCC.getSelectedItem().toString()).getMaNCC());
			sanPham_DAO.suaSanPhamTheoMa(sanPham);
			JOptionPane.showMessageDialog(null, "Cập Nhập Sản Phẩm Thành Công !");
		}
		return false;
	}

	private void ghiFileExcel(ArrayList<SanPham> ds) {
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
				cell.setCellValue("Nhà Cung Cấp");
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
					cell.setCellValue(ds.get(i).getGiaNhap());

					cell = row.createCell(6, CellType.STRING);
					cell.setCellValue(ds.get(i).getGiaBan());

					cell = row.createCell(7, CellType.STRING);
					cell.setCellValue(ds.get(i).getMaNhaCungCap());
				}
				FileOutputStream fis = new FileOutputStream(excelFilePath);
				wordkbook.write(fis);
				fis.close();
				JOptionPane.showMessageDialog(null, "Xuất File Thành Công !");
			} catch (Exception e) {
				
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
			lblHinhAnh.setIcon(new ImageIcon(NhanVien_GUI.class.getResource(relativePath)));
			return true;
		} else // JFileChooser.CANCEL_OPTION
			return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnlamMoi)) {
			lamMoi();
		} else {
			if (o.equals(btnAdd)) {
				if (btnAdd.getText().equalsIgnoreCase("Thêm")) {
					btnAdd.setText("Xác Nhận");
					btnDelete.setText("Hủy");
					btnUpdate.setEnabled(false);
					openText();
					try {
						txtmaDCHT.setText(phatSinhMa_DAO.getMaDCHT().toString());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					if (btnAdd.getText().equalsIgnoreCase("Xác Nhận")) {
						int tb = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thêm Dụng Cụ Học Tập ? ", "Delete",
								JOptionPane.YES_NO_OPTION);
						if (tb == JOptionPane.YES_OPTION) {
							themDCHT();
							btnAdd.setText("Thêm");
							btnDelete.setText("Xóa");
							btnUpdate.setEnabled(true);
							closeText();
							loadData(sanPham_DAO.getAllDungCuHocTap());
						}
					}
				}
			} else {
				if (o.equals(btnUpdate)) {

					if (btnUpdate.getText().equalsIgnoreCase("Sửa")) {
						int r = table.getSelectedRow();
						if (r == -1) {
							JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Sản Phẩm !");
						} else {
							openText();
							btnAdd.setEnabled(false);
							btnUpdate.setText("Xác Nhận");
							btnDelete.setText("Hủy");
						}
					} else {
						if (btnUpdate.getText().equalsIgnoreCase("Xác Nhận")) {
							closeText();
							btnAdd.setEnabled(true);
							btnUpdate.setText("Sửa");
							btnDelete.setText("Xóa");
							try {
								suaDCHT();
								loadData(sanPham_DAO.getAllDungCuHocTap());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				} else {
					if (o.equals(btnDelete)) {
						if (btnDelete.getText().equalsIgnoreCase("Hủy")) {
							btnAdd.setEnabled(true);
							closeText();
							btnDelete.setText("Xóa");
							btnUpdate.setText("Sửa");
							btnUpdate.setEnabled(true);
							btnAdd.setText("Thêm");
							lamMoi();
						} else {
							if (btnDelete.getText().equalsIgnoreCase("Xóa")) {
								int r = table.getSelectedRow();
								if (r == -1) {
									JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Sản Phẩm !");
								} else {
									xoaDungCuHocTap();
									lamMoi();
								}
							}
						}
					} else {
						if (o.equals(btnlamMoi)) {
							loadCBNhaCC();
							lamMoi();
						} else {
							if (o.equals(btnTim)) {
								btnAdd.setEnabled(false);
								btnDelete.setEnabled(false);
								btnUpdate.setEnabled(false);
								btnlamMoi.setEnabled(false);
								if (timKiemDungCuHoctap == null || timKiemDungCuHoctap.isClosed()) {
									timKiemDungCuHoctap = new TimKiemDungCuHoctap(ds);
									timKiemDungCuHoctap.addInternalFrameListener(new InternalFrameAdapter() {
										@Override
										public void internalFrameActivated(InternalFrameEvent e) {
//							                System.out.println("Internal frame is activated.");
										}

										@Override
										public void internalFrameDeactivated(InternalFrameEvent e) {
//							                System.out.println("Internal frame is deactivated.");
										}

										@Override
										public void internalFrameOpened(InternalFrameEvent e) {
//							                System.out.println("Internal frame is opened.");
//							            	disableButton();
										}

										@Override
										public void internalFrameClosed(InternalFrameEvent e) {
//							                System.out.println("Internal frame is closed.");
											loadData(ds);
											ds.removeAll(ds);
											btnAdd.setEnabled(true);
											btnDelete.setEnabled(true);
											btnUpdate.setEnabled(true);
											btnlamMoi.setEnabled(true);
										}
									});
									desktopPane.add(timKiemDungCuHoctap).setVisible(true);
								}
							} else {
								if (o.equals(btnKhoiPhuc)) {
									btnAdd.setEnabled(false);
									btnDelete.setEnabled(false);
									btnUpdate.setEnabled(false);
									btnlamMoi.setEnabled(false);
									btnlamMoi.setEnabled(false);
									btnTim.setEnabled(false);
									if (khoiPhucDuLieu == null || khoiPhucDuLieu.isClosed()) {
										khoiPhucDuLieu = new KhoiPhucDungCuHocTap_GUI(ds);
										khoiPhucDuLieu.addInternalFrameListener(new InternalFrameAdapter() {
											@Override
											public void internalFrameActivated(InternalFrameEvent e) {
//								                System.out.println("Internal frame is activated.");
											}

											@Override
											public void internalFrameDeactivated(InternalFrameEvent e) {
//								                System.out.println("Internal frame is deactivated.");
											}

											@Override
											public void internalFrameOpened(InternalFrameEvent e) {
//								                System.out.println("Internal frame is opened.");
//								            	disableButton();
											}

											@Override
											public void internalFrameClosed(InternalFrameEvent e) {
//								                System.out.println("Internal frame is closed.");
												loadData(ds);
												ds.removeAll(ds);
												btnAdd.setEnabled(true);
												btnDelete.setEnabled(true);
												btnUpdate.setEnabled(true);
												btnlamMoi.setEnabled(true);
												btnTim.setEnabled(true);
											}
										});
										desktopPane.add(khoiPhucDuLieu).setVisible(true);
									}
								} else {
									if (o.equals(btnXuatFile)) {
										ghiFileExcel(sanPham_DAO.getAllDungCuHocTap());
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
