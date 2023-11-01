package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.SanPham_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DanhSachHoaDon_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaHoaDon;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JDateChooser dateChooserTuNgay;
	private JDateChooser dateChooserDenNgay;
	private JTable tableChiTietHoaDon;
	private JTable tableDanhSachHoaDon;
	private DefaultTableModel modelDanhSachHoaDon;
	private DefaultTableModel modelChiTietHoaDon;
	private JTableHeader tableHeaderDanhSachHoaDon;
	private JTableHeader tableHeaderChiTietHoaDon;
	private JScrollPane scrChiTietHoaDon;
	private HoaDon_DAO hoaDon_DAO;
	private ChiTietHoaDon_DAO chiTietHoaDon_DAO;
	private KhachHang_DAO khachHang_DAO;
	private NhanVien_DAO nhanVien_DAO;
	private SanPham_DAO sanPham_DAO;
	
	/**
	 * Create the panel.
	 */
	public DanhSachHoaDon_GUI() {
		
		// khai bao DAO
		hoaDon_DAO = new HoaDon_DAO();
		khachHang_DAO = new KhachHang_DAO();
		nhanVien_DAO = new NhanVien_DAO();
		chiTietHoaDon_DAO = new ChiTietHoaDon_DAO();
		sanPham_DAO = new SanPham_DAO();
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBounds(0, 0, 1300, 720);
		add(pnlMain);
		pnlMain.setLayout(null);
		
		JPanel pnlThongTinTimKiem = new JPanel();
		pnlThongTinTimKiem.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlThongTinTimKiem.setBounds(0, 0, 1299, 180);
		pnlMain.add(pnlThongTinTimKiem);
		pnlThongTinTimKiem.setLayout(null);
		
		JLabel lblThngTinTm = new JLabel("Thông Tin Tìm Kiếm");
		lblThngTinTm.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThngTinTm.setBounds(20, 20, 203, 40);
		pnlThongTinTimKiem.add(lblThngTinTm);
		
		JLabel lblMaHoaDon = new JLabel("Mã Hóa Đơn:");
		lblMaHoaDon.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaHoaDon.setBounds(23, 70, 141, 40);
		pnlThongTinTimKiem.add(lblMaHoaDon);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(174, 70, 250, 40);
		pnlThongTinTimKiem.add(txtMaHoaDon);
		
		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng:");
		lblTenKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTenKhachHang.setBounds(23, 120, 141, 40);
		pnlThongTinTimKiem.add(lblTenKhachHang);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(174, 120, 250, 40);
		pnlThongTinTimKiem.add(txtTenKhachHang);
		
		JLabel lblTuNgay = new JLabel("Từ Ngày:");
		lblTuNgay.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTuNgay.setBounds(450, 70, 141, 40);
		pnlThongTinTimKiem.add(lblTuNgay);
		
		dateChooserTuNgay = new JDateChooser();
		dateChooserTuNgay.setToolTipText("Ngày sinh");
		dateChooserTuNgay.setBounds(601, 70, 250, 40);
		dateChooserTuNgay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserTuNgay.setDateFormatString("dd/MM/yyyy");
		dateChooserTuNgay.setFont(new Font("SansSerif", Font.PLAIN, 14));
		dateChooserTuNgay.getCalendarButton().setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/calendar.png")));
		dateChooserTuNgay.getCalendarButton().setBorder(null);
		dateChooserTuNgay.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserTuNgay.getCalendarButton().setBackground(new Color(255, 255, 255));
		dateChooserTuNgay.setBorder(null);
		pnlThongTinTimKiem.add(dateChooserTuNgay);
		
		JLabel lblnNgy = new JLabel("Đến Ngày:");
		lblnNgy.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblnNgy.setBounds(876, 70, 141, 40);
		pnlThongTinTimKiem.add(lblnNgy);
		
		dateChooserDenNgay = new JDateChooser();
		dateChooserDenNgay.setToolTipText("Ngày sinh");
		dateChooserDenNgay.setBounds(1027, 70, 250, 40);
		dateChooserDenNgay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserDenNgay.setDateFormatString("dd/MM/yyyy");
		dateChooserDenNgay.setFont(new Font("SansSerif", Font.PLAIN, 14));
		dateChooserDenNgay.getCalendarButton().setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/calendar.png")));
		dateChooserDenNgay.getCalendarButton().setBorder(null);
		dateChooserDenNgay.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserDenNgay.getCalendarButton().setBackground(new Color(255, 255, 255));
		dateChooserDenNgay.setBorder(null);
		pnlThongTinTimKiem.add(dateChooserDenNgay);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSoDienThoai.setBounds(450, 120, 141, 40);
		pnlThongTinTimKiem.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(601, 120, 250, 40);
		pnlThongTinTimKiem.add(txtSoDienThoai);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setOpaque(true);
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(876, 120, 135, 40);
		pnlThongTinTimKiem.add(btnTim);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setOpaque(true);
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.setBounds(1142, 120, 135, 40);
		pnlThongTinTimKiem.add(btnLamMoi);
		
		JPanel pnlDanhSachHoaDon = new JPanel();
		pnlDanhSachHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlDanhSachHoaDon.setBounds(0, 200, 1299, 250);
		pnlMain.add(pnlDanhSachHoaDon);
		pnlDanhSachHoaDon.setLayout(null);
		
		JScrollPane scrDanhSachHoaDon = new JScrollPane();
		scrDanhSachHoaDon.setBounds(0, 0, 1299, 250);
		scrDanhSachHoaDon.setToolTipText("Chọn vào hóa đơn cần hiển thị thông tin");
		scrDanhSachHoaDon.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrDanhSachHoaDon.setBackground(new Color(255, 255, 255));
		pnlDanhSachHoaDon.add(scrDanhSachHoaDon);

		String cols[] = { "Mã Hóa Đơn", "Tên Khách Hàng", "Số Điện Thoại",
				 "Tên Nhân Viên" , "Ngày Lập" , "Thành Tiền" };
		modelDanhSachHoaDon = new DefaultTableModel(cols, 0);
		tableDanhSachHoaDon = new JTable(modelDanhSachHoaDon);
		tableDanhSachHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableDanhSachHoaDon.setToolTipText("Chọn vào hóa đơn cần hiển thị thông tin");
		tableDanhSachHoaDon.setRowHeight(30);
		tableDanhSachHoaDon.setDefaultEditor(Object.class, null);
		tableDanhSachHoaDon.setShowGrid(true);
		tableDanhSachHoaDon.setShowHorizontalLines(true);
		tableDanhSachHoaDon.setBackground(new Color(255, 255, 255));
		tableDanhSachHoaDon.setSelectionBackground(new Color(141, 208, 229));
		tableDanhSachHoaDon.setSelectionForeground(new Color(0, 0, 0));
		tableDanhSachHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDanhSachHoaDon.addMouseListener(new MouseListener() {

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
				int row = tableDanhSachHoaDon.getSelectedRow();
				HoaDon hoaDon = hoaDon_DAO.getHoaDonTheoMaHoaDon(modelDanhSachHoaDon.getValueAt(row, 0).toString());
				loadDataIntoTableChiTietHoaDonTheoMaHoaDon(hoaDon.getMaHoaDon());
			}
		});
		scrDanhSachHoaDon.setViewportView(tableDanhSachHoaDon);
		updateTheoThoiGian();

		// header of table
		tableHeaderDanhSachHoaDon = tableDanhSachHoaDon.getTableHeader();
		tableHeaderDanhSachHoaDon.setBackground(new Color(73, 129, 158));
		tableHeaderDanhSachHoaDon.setForeground(Color.white);
		tableHeaderDanhSachHoaDon.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeaderDanhSachHoaDon.setReorderingAllowed(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tableDanhSachHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableDanhSachHoaDon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableDanhSachHoaDon.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableDanhSachHoaDon.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableDanhSachHoaDon.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableDanhSachHoaDon.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tableDanhSachHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		JPanel pnlChiTietHoaDon = new JPanel();
		pnlChiTietHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlChiTietHoaDon.setBounds(0, 470, 1299, 250);
		pnlMain.add(pnlChiTietHoaDon);
		pnlChiTietHoaDon.setLayout(null);
		
		scrChiTietHoaDon = new JScrollPane();
		scrChiTietHoaDon.setBounds(0, 0, 1299, 250);
		scrChiTietHoaDon.setToolTipText("");
		scrChiTietHoaDon.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrChiTietHoaDon.setBackground(new Color(255, 255, 255));
		pnlChiTietHoaDon.add(scrChiTietHoaDon);

		String colsChiTietHoaDon[] = { "Mã Hóa Đơn", "Tên Sản Phẩm", "Số Lượng",
				"Đơn Giá" };
		modelChiTietHoaDon = new DefaultTableModel(colsChiTietHoaDon, 0);
		tableChiTietHoaDon = new JTable(modelChiTietHoaDon);
		tableChiTietHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableChiTietHoaDon.setToolTipText("Chọn vào hóa đơn cần hiển thị thông tin");
		tableChiTietHoaDon.setRowHeight(30);
		tableChiTietHoaDon.setDefaultEditor(Object.class, null);
		tableChiTietHoaDon.setShowGrid(true);
		tableChiTietHoaDon.setShowHorizontalLines(true);
		tableChiTietHoaDon.setBackground(new Color(255, 255, 255));
		tableChiTietHoaDon.setSelectionBackground(new Color(141, 208, 229));
		tableChiTietHoaDon.setSelectionForeground(new Color(0, 0, 0));
		tableChiTietHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableChiTietHoaDon.addMouseListener(new MouseListener() {

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
			}
		});
		scrChiTietHoaDon.setViewportView(tableChiTietHoaDon);

		// header of table
		tableHeaderChiTietHoaDon = tableChiTietHoaDon.getTableHeader();
		tableHeaderChiTietHoaDon.setBackground(new Color(73, 129, 158));
		tableHeaderChiTietHoaDon.setForeground(Color.white);
		tableHeaderChiTietHoaDon.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeaderChiTietHoaDon.setReorderingAllowed(false);
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tableChiTietHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableChiTietHoaDon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableChiTietHoaDon.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableChiTietHoaDon.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableChiTietHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
	}
	
	private void loadDataIntoTableHoaDon(ArrayList<HoaDon> danhSachHoaDons) {
		modelDanhSachHoaDon.setRowCount(0);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (HoaDon hoaDon : danhSachHoaDons) {
			Object[] objects = {hoaDon.getMaHoaDon(), 
								khachHang_DAO.getKhachHangTheoMaKhachHang(hoaDon.getMaKhachHang()).getTenKhachHang(),
								khachHang_DAO.getKhachHangTheoMaKhachHang(hoaDon.getMaKhachHang()).getSoDienThoai(),
								nhanVien_DAO.getNhanVienTheoMa(hoaDon.getMaNhanVien()).getTenNhanVien(), 
								simpleDateFormat.format(hoaDon.getNgayLap()), 
								hoaDon.getThanhTien()};
			modelDanhSachHoaDon.addRow(objects);
		}
	}
	
	private void loadDataIntoTableChiTietHoaDonTheoMaHoaDon(String maHoaDon) {
		modelChiTietHoaDon.setRowCount(0);
		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDon_DAO.getAllChiTietHoaDonTheoMaHoaDon(maHoaDon)) {
			Object[] objects = {chiTietHoaDon.getMaHoaDon(),
								sanPham_DAO.getSanPhamTheoMaSanPham(chiTietHoaDon.getMaSanPham()).getTenSanPham(),
								chiTietHoaDon.getSoLuong(),
								chiTietHoaDon.getDonGia()};
			modelChiTietHoaDon.addRow(objects);
		}
	}
	
	private void updateTheoThoiGian() {
		Timer timer = new Timer(1000, (ActionListener) new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Thực hiện các hoạt động cập nhật giao diện ở đây
		    	loadDataIntoTableHoaDon(hoaDon_DAO.getAllListHoaDon());
		    }
		});
		timer.start();
	}
}
