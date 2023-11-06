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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Color;

import dao.HoaDon_DAO;
import entity.HoaDon;

public class ThongKe_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultCategoryDataset dataset;
	private JFreeChart chart;
	private CategoryPlot category;
	private ChartPanel chartPanel;
	private JPanel panel;
	private HoaDon_DAO hoaDon_DAO;

	/**
	 * Create the panel.
	 */
	public ThongKe_GUI() {
		// khai bao DAO
		hoaDon_DAO = new HoaDon_DAO();
		
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1300, 720);
		add(panel);
		showBarChart();
	}
	
	private void showBarChart() {
		dataset = new DefaultCategoryDataset();
		LocalDate date = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (int i = 0; i <= 6; i++) {
//			System.out.println(date.minusDays(i));
			dataset.addValue(tinhDoanhThuTheoNgay(date.minusDays(i)), "", dateFormat.format(date.minusDays(i)).toString());
		}
		
//		dataset.addValue(23, "Nam", "Nam");
//		
//		dataset.addValue(27, "Nữ", "Nữ");
//		
//		dataset.addValue(2, "Bê đe", "Bê đê");
		
		chart = ChartFactory.createBarChart("DOANH THU", "NGÀY", "VND", dataset, PlotOrientation.VERTICAL, true, true, false);
		
		category = chart.getCategoryPlot();
		category.setBackgroundPaint(new Color(255, 255, 255));//change background color

	    //set  bar chart color

	    ((BarRenderer)category.getRenderer()).setBarPainter(new StandardBarPainter());

	    BarRenderer r = (BarRenderer)chart.getCategoryPlot().getRenderer();
	    r.setSeriesPaint(0, new Color(129, 197, 219));
	    r.setSeriesPaint(1, new Color(129, 197, 219));
	    r.setSeriesPaint(2, new Color(129, 197, 219));
		panel.setLayout(new BorderLayout(0, 0));
		
		chartPanel = new ChartPanel(chart);
		panel.add(chartPanel);
		panel.validate();
	}
	
	private float tinhDoanhThuTheoNgay(LocalDate date) {
		float doanhThu = 0;
		for (HoaDon hoaDon : hoaDon_DAO.getListHoaDonTheoNgay(date)) {
			doanhThu += hoaDon.getThanhTien();
		}
		return doanhThu;
	}
}
