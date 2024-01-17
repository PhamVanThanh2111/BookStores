package gui;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.SanPham_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;

import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.beans.PropertyChangeEvent;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ListSelectionModel;

public class ThongKe_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultCategoryDataset datasetDoanhThu;
	private JFreeChart chartDoanhThu;
	private CategoryPlot categoryDoanhThu;
	private ChartPanel chartPanelDoanhThu;
	private DefaultCategoryDataset datasetSoLuong;
	private JFreeChart chartSoLuong;
	private CategoryPlot categorySoLuong;
	private ChartPanel chartPanelSoLuong;
	private JPanel pnlThongKeDoanhThu;
	private HoaDon_DAO hoaDon_DAO;
	private SanPham_DAO sanPham_DAO;
	private JPanel pnlThongKeSoLuong;
	private ChiTietHoaDon_DAO chiTietHoaDon_DAO;
	private JPanel pnlChucNang;
	private JLabel lblTuNgay;
	private JLabel lblDenNgay;
	private JDateChooser dateChooserTuNgay;
	private JDateChooser dateChooserDenNgay;
	private JPanel pnlDoanhThu;
	private JPanel pnlSanPhamBanChay;
	private JPanel pnlSoLuongTonKho;
	private JPanel pnlNangSuatNhanVien;
	private JFreeChart chartSanPhamBanChay;
	private CategoryPlot categorySanPhamBanChay;
	private DefaultCategoryDataset datasetSanPhamBanChay;
	private ChartPanel chartPanelSanPhamBanChay;
	private JPanel pnlKhachHangMuaNhieuNhat;
	private JFreeChart chartKhachHangMuaNhieuNhat;
	private CategoryPlot categoryKhachHangMuaNhieuNhat;
	private DefaultCategoryDataset datasetKhachHangMuaNhieuNhat;
	private ChartPanel chartPanelKhachHangMuaNhieuNhat;
	private JPanel pnlThongKeDoanhThuNhanVien;
	private JPanel pnlThongKeSoLuongHoaDonVaSanPhamNhanVien;
	private JFreeChart chartDoanhThuNhanVien;
	private CategoryPlot categoryDoanhThuNhanVien;
	private DefaultCategoryDataset datasetDoanhThuNhanVien;
	private ChartPanel chartPanelDoanhThuNhanVien;
	private JFreeChart chartSoLuongHoaDonVaSanPhamNhanVien;
	private CategoryPlot categorySoLuongHoaDonVaSanPhamNhanVien;
	private DefaultCategoryDataset datasetSoLuongHoaDonVaSanPhamNhanVien;
	private ChartPanel chartPanelSoLuongHoaDonVaSanPhamNhanVien;
	private JSeparator separator;
	private JLabel lblDanhSachSanPham;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public ThongKe_GUI() {
		// khai bao DAO
		hoaDon_DAO = new HoaDon_DAO();
		sanPham_DAO = new SanPham_DAO();
		chiTietHoaDon_DAO = new ChiTietHoaDon_DAO();
		
		setLayout(null);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBounds(0, 0, 1300, 720);
		add(pnlMain);
		pnlMain.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1300, 720);
		pnlMain.add(tabbedPane);
		
		pnlDoanhThu = new JPanel();
		pnlDoanhThu.setBounds(0, 0, 1300, 720);
		tabbedPane.addTab("Doanh thu", null, pnlDoanhThu, "Doanh thu");
		pnlDoanhThu.setLayout(null);
		
		pnlNangSuatNhanVien = new JPanel();
		tabbedPane.addTab("Năng suất nhân viên", null, pnlNangSuatNhanVien, "Năng suất nhân viên");
		pnlNangSuatNhanVien.setLayout(null);
		
		pnlSanPhamBanChay = new JPanel();
		tabbedPane.addTab("Sản phẩm bán chạy", null, pnlSanPhamBanChay, "Sản phẩm bán chạy");
		pnlSanPhamBanChay.setLayout(new BorderLayout(0, 0));
		
		pnlKhachHangMuaNhieuNhat = new JPanel();
		tabbedPane.addTab("Khách hàng mua nhiều nhất", null, pnlKhachHangMuaNhieuNhat, "Khách hàng mua nhiều nhất");
		pnlKhachHangMuaNhieuNhat.setLayout(new BorderLayout(0, 0));
		
		pnlSoLuongTonKho = new JPanel();
		tabbedPane.addTab("Số lượng tồn kho", null, pnlSoLuongTonKho, "Số lượng tồn kho");
		pnlSoLuongTonKho.setLayout(null);
		
		separator = new JSeparator();
		separator.setForeground(new Color(60, 60, 60));
		separator.setBounds(345, 60, 930, 2);
		pnlSoLuongTonKho.add(separator);
		
		lblDanhSachSanPham = new JLabel("Danh Sách Sản Phẩm Sắp Hết Hàng");
		lblDanhSachSanPham.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblDanhSachSanPham.setBounds(20, 40, 325, 40);
		pnlSoLuongTonKho.add(lblDanhSachSanPham);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(20, 90, 1255, 582);
		pnlSoLuongTonKho.add(scrollPane);
		
		String[] cols = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng Tồn"};
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		table.setRowHeight(30);
		table.setDefaultEditor(Object.class, null);
		table.setShowGrid(true); 
		table.setShowHorizontalLines(true);
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(141, 208, 229));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		loadSanPhamGanHetHang();

		// header of table
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		pnlThongKeDoanhThu = new JPanel();
		pnlThongKeDoanhThu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlThongKeDoanhThu.setBounds(0, 0, 890, 336);
		pnlDoanhThu.add(pnlThongKeDoanhThu);
		
		pnlThongKeSoLuong = new JPanel();
		pnlThongKeSoLuong.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlThongKeSoLuong.setBounds(0, 357, 890, 336);
		pnlDoanhThu.add(pnlThongKeSoLuong);
		
		pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setBounds(910, 0, 385, 693);
		pnlDoanhThu.add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		JLabel lblChonNgay = new JLabel("Chọn Ngày:");
		lblChonNgay.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChonNgay.setBounds(20, 20, 255, 40);
		pnlChucNang.add(lblChonNgay);
		
		lblTuNgay = new JLabel("Từ Ngày:");
		lblTuNgay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTuNgay.setBounds(35, 80, 90, 40);
		pnlChucNang.add(lblTuNgay);
		
		lblDenNgay = new JLabel("Đến Ngày:");
		lblDenNgay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDenNgay.setBounds(35, 140, 90, 40);
		pnlChucNang.add(lblDenNgay);
		
		dateChooserTuNgay = new JDateChooser();
		dateChooserTuNgay.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (dateChooserTuNgay.getDate() != null) {
					if (dateChooserTuNgay.getDate().after(new Date())) {
						JOptionPane.showMessageDialog(null, "Không được chọn sau ngày hôm nay!");
						dateChooserTuNgay.setDate(null);
					}
				}
			}
		});
		dateChooserTuNgay.setBackground(new Color(255, 255, 255));
		dateChooserTuNgay.getCalendarButton().setBounds(210, 0, 30, 40);
		dateChooserTuNgay.getCalendarButton().setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/calendar.png")));
		dateChooserTuNgay.getCalendarButton().setBorder(null);
		dateChooserTuNgay.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserTuNgay.getCalendarButton().setBackground(new Color(255, 255, 255));
		dateChooserTuNgay.setToolTipText("Từ ngày");
		dateChooserTuNgay.setBounds(125, 80, 240, 40);
		dateChooserTuNgay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserTuNgay.setDateFormatString("dd/MM/yyyy");
		dateChooserTuNgay.setFont(new Font("SansSerif", Font.BOLD, 18));
		dateChooserTuNgay.setBorder(null);
		dateChooserTuNgay.getDateEditor().setEnabled(false);
		pnlChucNang.add(dateChooserTuNgay);
		
		dateChooserDenNgay = new JDateChooser();
		dateChooserDenNgay.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (dateChooserDenNgay.getDate() != null) {
					Date tuNgay = dateChooserTuNgay.getDate();
					Date denNgay = dateChooserDenNgay.getDate();
					if (kiemTraNgayHopLe(tuNgay, denNgay)) {
						thongKeTrongKhoang(doiLocalDate(tuNgay), doiLocalDate(denNgay));
//					System.out.println(doiLocalDate(tuNgay));
//					System.out.println(doiLocalDate(denNgay));
					}
				}
			}
		});
		dateChooserDenNgay.setBackground(new Color(255, 255, 255));
		dateChooserDenNgay.getCalendarButton().setBounds(210, 0, 30, 40);
		dateChooserDenNgay.getCalendarButton().setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/calendar.png")));
		dateChooserDenNgay.getCalendarButton().setBorder(null);
		dateChooserDenNgay.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserDenNgay.getCalendarButton().setBackground(new Color(255, 255, 255));
		dateChooserDenNgay.setToolTipText("Đến ngày");
		dateChooserDenNgay.setBounds(125, 140, 240, 40);
		dateChooserDenNgay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserDenNgay.setDateFormatString("dd/MM/yyyy");
		dateChooserDenNgay.setFont(new Font("SansSerif", Font.BOLD, 18));
		dateChooserDenNgay.setBorder(null);
		dateChooserDenNgay.getDateEditor().setEnabled(false);
		pnlChucNang.add(dateChooserDenNgay);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.setBounds(230, 289, 135, 40);
		btnLamMoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showAllChart();
				dateChooserTuNgay.setDate(null);
				dateChooserDenNgay.setDate(null);
			}
		});
		pnlChucNang.add(btnLamMoi);
		
		JLabel lblThngKCui = new JLabel("Thống Kê Cuối Ngày:");
		lblThngKCui.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThngKCui.setBounds(20, 213, 255, 40);
		pnlChucNang.add(lblThngKCui);
		
		JButton btnThongKe = new JButton("Thống Kê");
		btnThongKe.setForeground(Color.WHITE);
		btnThongKe.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnThongKe.setBackground(new Color(73, 129, 158));
		btnThongKe.setBounds(27, 289, 135, 40);
		btnThongKe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thongKeTrongKhoang(LocalDate.now(), LocalDate.now());
			}
		});
		pnlChucNang.add(btnThongKe);
		
		pnlThongKeDoanhThuNhanVien = new JPanel();
		pnlThongKeDoanhThuNhanVien.setBounds(0, 5, 1295, 334);
		pnlNangSuatNhanVien.add(pnlThongKeDoanhThuNhanVien);
		
		pnlThongKeSoLuongHoaDonVaSanPhamNhanVien = new JPanel();
		pnlThongKeSoLuongHoaDonVaSanPhamNhanVien.setBounds(0, 359, 1295, 334);
		pnlNangSuatNhanVien.add(pnlThongKeSoLuongHoaDonVaSanPhamNhanVien);
		
//		showAllChart();
	}
	
	private void showBarChartDoanhThu(LocalDate tuNgay, LocalDate denNgay) {
		datasetDoanhThu = new DefaultCategoryDataset();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int i = 0;
		while (i <= tinhKhoangCachGiuaHaiNgay(doiDate(tuNgay), doiDate(denNgay))) {
			datasetDoanhThu.addValue(tinhDoanhThuTheoNgay(tuNgay.plusDays(i)), "Doanh thu 1", dateFormat.format(tuNgay.plusDays(i)).toString());
			i++;
		}
		chartDoanhThu = ChartFactory.createBarChart("DOANH THU", "NGÀY", "VND", datasetDoanhThu, PlotOrientation.VERTICAL, true, true, false);
		
		categoryDoanhThu = chartDoanhThu.getCategoryPlot();
		categoryDoanhThu.setBackgroundPaint(new Color(255, 255, 255));//change background color

	    //set  bar chart color
	    ((BarRenderer)categoryDoanhThu.getRenderer()).setBarPainter(new StandardBarPainter());

	    BarRenderer rendererDoanhThu = (BarRenderer)chartDoanhThu.getCategoryPlot().getRenderer();
	    rendererDoanhThu.setSeriesPaint(0, new Color(129, 197, 219));
		
		LegendTitle legendTitle = chartDoanhThu.getLegend();
		legendTitle.setVisible(false);
		pnlThongKeDoanhThu.setLayout(null);
		
		chartPanelDoanhThu = new ChartPanel(chartDoanhThu);
		chartPanelDoanhThu.setBounds(2, 2, 886, 332);
		pnlThongKeDoanhThu.add(chartPanelDoanhThu);
		chartPanelDoanhThu.removeAll();
		chartPanelDoanhThu.repaint();
		
	}
	
	private void showBarChartSoLuong(LocalDate tuNgay, LocalDate denNgay) {
		datasetSoLuong = new DefaultCategoryDataset();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		// add value
		int i = 0;
		while (i <= tinhKhoangCachGiuaHaiNgay(doiDate(tuNgay), doiDate(denNgay))) {
			datasetSoLuong.addValue(hoaDon_DAO.getListHoaDonTheoNgay(tuNgay.plusDays(i)).size(), "Hóa đơn", dateFormat.format(tuNgay.plusDays(i)).toString());
			datasetSoLuong.addValue(tinhSoLuongSanPhamBanDuocTheoNgay(tuNgay.plusDays(i)), "Sản phẩm", dateFormat.format(tuNgay.plusDays(i)).toString());
			i++;
		}
		
		chartSoLuong = ChartFactory.createBarChart("SỐ LƯỢNG SẢN PHẨM VÀ SỐ LƯỢNG HÓA ĐƠN BÁN ĐƯỢC", "NGÀY", "SỐ LƯỢNG", datasetSoLuong, PlotOrientation.VERTICAL, true, true, false);
		
		categorySoLuong = chartSoLuong.getCategoryPlot();
		categorySoLuong.setBackgroundPaint(new Color(255, 255, 255)); //change background color

	    //set  bar chart color
	    ((BarRenderer)categorySoLuong.getRenderer()).setBarPainter(new StandardBarPainter());

	    BarRenderer rendererSoLuong = (BarRenderer)chartSoLuong.getCategoryPlot().getRenderer();
	    rendererSoLuong.setSeriesPaint(0, new Color(129, 197, 219));
	    rendererSoLuong.setSeriesPaint(1, new Color(56, 96, 127));
		pnlThongKeSoLuong.setLayout(null);
		
		chartPanelSoLuong = new ChartPanel(chartSoLuong);
		chartPanelSoLuong.setBounds(2, 2, 886, 332);
		pnlThongKeSoLuong.add(chartPanelSoLuong);
		chartPanelSoLuong.removeAll();
		chartPanelSoLuong.repaint();
	}
	
	private void showBarChartSanPhamBanChay() { 
		datasetSanPhamBanChay = new DefaultCategoryDataset();
		
		// add value
		ResultSet resultSet = hoaDon_DAO.getDanhSachSanPhamBanChay();
		try {
			while (resultSet.next()) {
				datasetSanPhamBanChay.addValue(resultSet.getInt(3), "Sản phẩm", resultSet.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		chartSanPhamBanChay = ChartFactory.createBarChart("CÁC SẢN PHẨM BÁN CHẠY", "SẢN PHẨM", "SỐ LƯỢNG", datasetSanPhamBanChay, PlotOrientation.VERTICAL, true, true, false);
	
		categorySanPhamBanChay = chartSanPhamBanChay.getCategoryPlot();
		categorySanPhamBanChay.setBackgroundPaint(new Color(255, 255, 255));
		
		// set bar chart color
		((BarRenderer) categorySanPhamBanChay.getRenderer()).setBarPainter(new StandardBarPainter());
		BarRenderer rendererSanPhamBanChay = (BarRenderer)chartSanPhamBanChay.getCategoryPlot().getRenderer();
	    rendererSanPhamBanChay.setSeriesPaint(0, new Color(129, 197, 219));
	    rendererSanPhamBanChay.setSeriesPaint(1, new Color(56, 96, 127));
		
	    chartPanelSanPhamBanChay = new ChartPanel(chartSanPhamBanChay);
	    pnlSanPhamBanChay.add(chartPanelSanPhamBanChay);
	    pnlSanPhamBanChay.validate();
	}
	
	private void showBarChartKhachHangMuaNhieuNhat() {
		datasetKhachHangMuaNhieuNhat = new DefaultCategoryDataset();
		
		// add value
		ResultSet resultSet = hoaDon_DAO.getDanhSachKhachHangMuaNhieuNhat();
		try {
			while (resultSet.next()) {
				datasetKhachHangMuaNhieuNhat.addValue(resultSet.getFloat(2), "VNĐ", resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		chartKhachHangMuaNhieuNhat = ChartFactory.createBarChart("KHÁCH HÀNG MUA NHIỀU NHẤT", "TÊN KHÁCH HÀNG", "VNĐ", datasetKhachHangMuaNhieuNhat, PlotOrientation.VERTICAL, true, true, false);
		
		categoryKhachHangMuaNhieuNhat = chartKhachHangMuaNhieuNhat.getCategoryPlot();
		categoryKhachHangMuaNhieuNhat.setBackgroundPaint(new Color(255, 255, 255));
		
		// set bar chart color
		((BarRenderer) categoryKhachHangMuaNhieuNhat.getRenderer()).setBarPainter(new StandardBarPainter());
		BarRenderer rendererKhachHangMuaNhieuNhat = (BarRenderer)chartKhachHangMuaNhieuNhat.getCategoryPlot().getRenderer();
	    rendererKhachHangMuaNhieuNhat.setSeriesPaint(0, new Color(129, 197, 219));
	    rendererKhachHangMuaNhieuNhat.setSeriesPaint(1, new Color(56, 96, 127));
		
	    chartPanelKhachHangMuaNhieuNhat = new ChartPanel(chartKhachHangMuaNhieuNhat);
	    pnlKhachHangMuaNhieuNhat.add(chartPanelKhachHangMuaNhieuNhat);
	    pnlKhachHangMuaNhieuNhat.validate();
	}
	
	private void showBarChartThongKeNangSuatNhanVien() { 
		datasetDoanhThuNhanVien = new DefaultCategoryDataset();
		datasetSoLuongHoaDonVaSanPhamNhanVien = new DefaultCategoryDataset();
		
		ResultSet resultSet = hoaDon_DAO.getDanhSachNhanVienTheoDoanhThu();
		// add value
		try {
			while (resultSet.next()) {
				datasetDoanhThuNhanVien.addValue(resultSet.getFloat(5), "Doanh thu", resultSet.getString(2));
				datasetSoLuongHoaDonVaSanPhamNhanVien.addValue(resultSet.getInt(3), "Hóa đơn", resultSet.getString(2));
				datasetSoLuongHoaDonVaSanPhamNhanVien.addValue(resultSet.getInt(4), "Sản phẩm", resultSet.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		// chart 1
		chartDoanhThuNhanVien = ChartFactory.createBarChart("DOANH THU NHÂN VIÊN", "TÊN NHÂN VIÊN", "VNĐ", datasetDoanhThuNhanVien, PlotOrientation.VERTICAL, true, true, false);
		
		categoryDoanhThuNhanVien = chartDoanhThuNhanVien.getCategoryPlot();
		categoryDoanhThuNhanVien.setBackgroundPaint(new Color(255, 255, 255));
		
		// set bar chart color
		((BarRenderer) categoryDoanhThuNhanVien.getRenderer()).setBarPainter(new StandardBarPainter());
		BarRenderer rendererDoanhThuNhanVien = (BarRenderer)chartDoanhThuNhanVien.getCategoryPlot().getRenderer();
	    rendererDoanhThuNhanVien.setSeriesPaint(0, new Color(129, 197, 219));
	    rendererDoanhThuNhanVien.setSeriesPaint(1, new Color(56, 96, 127));
	    pnlThongKeDoanhThuNhanVien.setLayout(new BorderLayout(0, 0));
		
	    chartPanelDoanhThuNhanVien = new ChartPanel(chartDoanhThuNhanVien);
	    pnlThongKeDoanhThuNhanVien.add(chartPanelDoanhThuNhanVien);
	    pnlThongKeDoanhThuNhanVien.validate();
	    
	    // chart 2
		chartSoLuongHoaDonVaSanPhamNhanVien = ChartFactory.createBarChart("SỐ LƯỢNG HÓA ĐƠN VÀ SẢN PHẨM CỦA NHÂN VIÊN BÁN ĐƯỢC", "TÊN NHÂN VIÊN", "SỐ LƯỢNG", datasetSoLuongHoaDonVaSanPhamNhanVien, PlotOrientation.VERTICAL, true, true, false);
		
		categorySoLuongHoaDonVaSanPhamNhanVien = chartSoLuongHoaDonVaSanPhamNhanVien.getCategoryPlot();
		categorySoLuongHoaDonVaSanPhamNhanVien.setBackgroundPaint(new Color(255, 255, 255));
		
		// set bar chart color
		((BarRenderer) categorySoLuongHoaDonVaSanPhamNhanVien.getRenderer()).setBarPainter(new StandardBarPainter());
		BarRenderer rendererSoLuongHoaDonVaSanPhamNhanVien = (BarRenderer)chartSoLuongHoaDonVaSanPhamNhanVien.getCategoryPlot().getRenderer();
	    rendererSoLuongHoaDonVaSanPhamNhanVien.setSeriesPaint(0, new Color(129, 197, 219));
	    rendererSoLuongHoaDonVaSanPhamNhanVien.setSeriesPaint(1, new Color(56, 96, 127));
	    pnlThongKeSoLuongHoaDonVaSanPhamNhanVien.setLayout(new BorderLayout(0, 0));
		
	    chartPanelSoLuongHoaDonVaSanPhamNhanVien = new ChartPanel(chartSoLuongHoaDonVaSanPhamNhanVien);
	    pnlThongKeSoLuongHoaDonVaSanPhamNhanVien.add(chartPanelSoLuongHoaDonVaSanPhamNhanVien);
	    pnlThongKeSoLuongHoaDonVaSanPhamNhanVien.validate();
	}
	
	private float tinhDoanhThuTheoNgay(LocalDate date) {
		float doanhThu = 0;
		for (HoaDon hoaDon : hoaDon_DAO.getListHoaDonTheoNgay(date)) {
			doanhThu += hoaDon.getThanhTien();
		}
		return doanhThu;
	}
	
	private int tinhSoLuongSanPhamBanDuocTheoNgay(LocalDate date) {
		int soLuong = 0;
		for (HoaDon hoaDon : hoaDon_DAO.getListHoaDonTheoNgay(date)) {
			for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDon_DAO.getAllChiTietHoaDonTheoMaHoaDon(hoaDon.getMaHoaDon())) {
				soLuong += chiTietHoaDon.getSoLuong();
			}
		}
		return soLuong;
	}
	
	public void showAllChart() {
		showBarChartDoanhThu(LocalDate.now().minusDays(6), LocalDate.now());
		showBarChartSoLuong(LocalDate.now().minusDays(6), LocalDate.now());
		showBarChartKhachHangMuaNhieuNhat();
		showBarChartSanPhamBanChay();
		showBarChartThongKeNangSuatNhanVien();
	}
	
	private int tinhKhoangCachGiuaHaiNgay(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	private void thongKeTrongKhoang(LocalDate tuNgay, LocalDate denNgay) {
		showBarChartDoanhThu(tuNgay, denNgay);
		showBarChartSoLuong(tuNgay, denNgay);
	}
	
	private LocalDate doiLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	private Date doiDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	private boolean kiemTraNgayHopLe(Date tuNgay, Date denNgay) {
		if (tuNgay.after(denNgay)) {
			JOptionPane.showMessageDialog(null, "Thứ tự ngày không hợp lệ!");
			dateChooserTuNgay.setDate(null);
			dateChooserDenNgay.setDate(null);
			return false;
		}
		else if (denNgay.after(new Date())) {
			JOptionPane.showMessageDialog(null, "Không được chọn sau ngày hiện tại!");
			dateChooserDenNgay.setDate(null);
			return false;
		}
		else if (tinhKhoangCachGiuaHaiNgay(tuNgay, denNgay) >= 7) {
			JOptionPane.showMessageDialog(null, "Tối đa 7 ngày!");
			dateChooserTuNgay.setDate(null);
			dateChooserDenNgay.setDate(null);
			return false;
		}
		return true;
	}
	
	// load danh sách sản phẩm gần hết hàng
	private void loadSanPhamGanHetHang() {
		model.setRowCount(0);
		for (SanPham sanPham : sanPham_DAO.getSanPhamGanHetHang()) {
			Object[] objects = { sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getSoLuongTon()};
			model.addRow(objects);
		}
	}
}
