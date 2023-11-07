package gui;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
import java.time.format.DateTimeFormatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JPanel pnlThongKeDoanhThu;
	private HoaDon_DAO hoaDon_DAO;
	private JPanel pnlThongKeSoLuong;
	private ChiTietHoaDon_DAO chiTietHoaDon_DAO;
	private JPanel panel;
	private JLabel lblTuNgay;
	private JLabel lblDenNgay;
	private JDateChooser dateChooserTuNgay;
	private JDateChooser dateChooserDenNgay;

	/**
	 * Create the panel.
	 */
	public ThongKe_GUI() {
		// khai bao DAO
		hoaDon_DAO = new HoaDon_DAO();
		chiTietHoaDon_DAO = new ChiTietHoaDon_DAO();
		
		setLayout(null);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBounds(0, 0, 1300, 720);
		add(pnlMain);
		pnlMain.setLayout(null);
		
		pnlThongKeDoanhThu = new JPanel();
		pnlThongKeDoanhThu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlThongKeDoanhThu.setBounds(0, 0, 890, 350);
		pnlMain.add(pnlThongKeDoanhThu);
		
		pnlThongKeSoLuong = new JPanel();
		pnlThongKeSoLuong.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlThongKeSoLuong.setBounds(0, 370, 890, 350);
		pnlMain.add(pnlThongKeSoLuong);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(910, 0, 390, 720);
		pnlMain.add(panel);
		panel.setLayout(null);
		
		JLabel lblChonNgay = new JLabel("Chọn Ngày");
		lblChonNgay.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChonNgay.setBounds(20, 20, 255, 40);
		panel.add(lblChonNgay);
		
		lblTuNgay = new JLabel("Từ Ngày:");
		lblTuNgay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTuNgay.setBounds(35, 80, 90, 40);
		panel.add(lblTuNgay);
		
		lblDenNgay = new JLabel("Đến Ngày:");
		lblDenNgay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDenNgay.setBounds(35, 140, 90, 40);
		panel.add(lblDenNgay);
		
		dateChooserTuNgay = new JDateChooser();
		dateChooserTuNgay = new JDateChooser();
//		dateChooserTuNgay.addPropertyChangeListener(new PropertyChangeListener() {
//			public void propertyChange(PropertyChangeEvent evt) {
//				Date tuNgay = dateChooserTuNgay.getDate();
//				if (tuNgay.after(new Date())) {
//					JOptionPane.showMessageDialog(null, "Không được chọn sau ngày hiện tại!");
//				}
//			}
//		});
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
		panel.add(dateChooserTuNgay);
		
		dateChooserDenNgay = new JDateChooser();
//		dateChooserDenNgay.addPropertyChangeListener(new PropertyChangeListener() {
//			public void propertyChange(PropertyChangeEvent evt) {
//				Date tuNgay = dateChooserTuNgay.getDate();
//				Date denNgay = dateChooserDenNgay.getDate();
//				if (tuNgay.after(denNgay)) {
//					JOptionPane.showMessageDialog(null, "Thứ tự ngày không hợp lệ!");
//				}
//				else if (denNgay.after(new Date())) {
//					JOptionPane.showMessageDialog(null, "Không được chọn sau ngày hiện tại!");
//				}
//				else if (getKhoangCachGiuaHaiNgay(tuNgay, denNgay) > 7) {
//					JOptionPane.showMessageDialog(null, "Tối đa 7 ngày!");
//				}
//				else {
//					
//				}
//			}
//		});
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
		panel.add(dateChooserDenNgay);
		
		JButton btnXacNhan = new JButton("Xác Nhận");
		btnXacNhan.setForeground(Color.WHITE);
		btnXacNhan.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXacNhan.setBackground(new Color(73, 129, 158));
		btnXacNhan.setBounds(122, 209, 135, 40);
		btnXacNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(btnXacNhan);
		
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
		pnlThongKeDoanhThu.setLayout(new BorderLayout(0, 0));
		
		LegendTitle legendTitle = chartDoanhThu.getLegend();
		legendTitle.setVisible(false);
		
		chartPanelDoanhThu = new ChartPanel(chartDoanhThu);
		pnlThongKeDoanhThu.add(chartPanelDoanhThu);
		pnlThongKeDoanhThu.validate();
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
		pnlThongKeSoLuong.setLayout(new BorderLayout(0, 0));
		
		chartPanelSoLuong = new ChartPanel(chartSoLuong);
		pnlThongKeSoLuong.add(chartPanelSoLuong);
		pnlThongKeSoLuong.validate();
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
