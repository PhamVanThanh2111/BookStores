package gui;

import javax.swing.JPanel;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Color;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;

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
	private JPanel panel;
	private HoaDon_DAO hoaDon_DAO;
	private JPanel panel_2;
	private ChiTietHoaDon_DAO chiTietHoaDon_DAO;

	/**
	 * Create the panel.
	 */
	public ThongKe_GUI() {
		// khai bao DAO
		hoaDon_DAO = new HoaDon_DAO();
		chiTietHoaDon_DAO = new ChiTietHoaDon_DAO();
		
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1300, 720);
		add(panel_1);
		panel_1.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 891, 360);
		panel_1.add(panel);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 360, 891, 360);
		panel_1.add(panel_2);
		showBarChartDoanhThu();
		showBarChartSoLuong();
	}
	
	private void showBarChartDoanhThu() {
		datasetDoanhThu = new DefaultCategoryDataset();
		LocalDate date = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (int i = 0; i <= 6; i++) {
			datasetDoanhThu.addValue(tinhDoanhThuTheoNgay(date.minusDays(i)), "Doanh thu", dateFormat.format(date.minusDays(i)).toString());
		}
		
		chartDoanhThu = ChartFactory.createBarChart("DOANH THU", "NGÀY", "VND", datasetDoanhThu, PlotOrientation.VERTICAL, true, true, false);
		
		categoryDoanhThu = chartDoanhThu.getCategoryPlot();
		categoryDoanhThu.setBackgroundPaint(new Color(255, 255, 255));//change background color

	    //set  bar chart color
	    ((BarRenderer)categoryDoanhThu.getRenderer()).setBarPainter(new StandardBarPainter());

	    BarRenderer rendererDoanhThu = (BarRenderer)chartDoanhThu.getCategoryPlot().getRenderer();
	    rendererDoanhThu.setSeriesPaint(0, new Color(129, 197, 219));
		panel.setLayout(new BorderLayout(0, 0));
		
		chartPanelDoanhThu = new ChartPanel(chartDoanhThu);
		panel.add(chartPanelDoanhThu);
		panel.validate();
	}
	
	private void showBarChartSoLuong() {
		datasetSoLuong = new DefaultCategoryDataset();
		LocalDate date = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		// add value
		for (int i = 0; i <= 6; i++) {
			datasetSoLuong.addValue(hoaDon_DAO.getListHoaDonTheoNgay(date.minusDays(i)).size(), "Hóa đơn", dateFormat.format(date.minusDays(i)).toString());
			datasetSoLuong.addValue(tinhSoLuongSanPhamBanDuocTheoNgay(date.minusDays(i)), "Sản phẩm", dateFormat.format(date.minusDays(i)).toString());
		}
		
		chartSoLuong = ChartFactory.createBarChart("SỐ LƯỢNG SẢN PHẨM VÀ SỐ LƯỢNG HÓA ĐƠN BÁN ĐƯỢC", "NGÀY", "SỐ LƯỢNG", datasetSoLuong, PlotOrientation.VERTICAL, true, true, false);
		
		categorySoLuong = chartSoLuong.getCategoryPlot();
		categorySoLuong.setBackgroundPaint(new Color(255, 255, 255));//change background color

	    //set  bar chart color
	    ((BarRenderer)categorySoLuong.getRenderer()).setBarPainter(new StandardBarPainter());

	    BarRenderer rendererSoLuong = (BarRenderer)chartSoLuong.getCategoryPlot().getRenderer();
	    rendererSoLuong.setSeriesPaint(0, new Color(129, 197, 219));
	    rendererSoLuong.setSeriesPaint(1, new Color(56, 96, 127));
		panel_2.setLayout(new BorderLayout(0, 0));
		
		chartPanelSoLuong = new ChartPanel(chartSoLuong);
		panel_2.add(chartPanelSoLuong);
		panel_2.validate();
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
}
