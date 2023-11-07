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
import entity.ChiTietHoaDon;
import entity.HoaDon;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

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
		
		JLabel lblChonNgay = new JLabel("Chọn Ngày:");
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
		panel.add(dateChooserTuNgay);
		
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
		panel.add(dateChooserDenNgay);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.setBounds(230, 289, 135, 40);
		btnLamMoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				refresh();
				dateChooserTuNgay.setDate(null);
				dateChooserDenNgay.setDate(null);
			}
		});
		panel.add(btnLamMoi);
		
		JLabel lblThngKCui = new JLabel("Thống Kê Cuối Ngày:");
		lblThngKCui.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThngKCui.setBounds(20, 213, 255, 40);
		panel.add(lblThngKCui);
		
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
		panel.add(btnThongKe);
		
		refresh();
	}
	
	private void showBarChartDoanhThu(LocalDate tuNgay, LocalDate denNgay) {
		datasetDoanhThu = new DefaultCategoryDataset();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int i = 0;
		while (i <= tinhKhoangCachGiuaHaiNgay(doiDate(tuNgay), doiDate(denNgay))) {
			datasetDoanhThu.addValue(tinhDoanhThuTheoNgay(tuNgay.plusDays(i)), "Doanh thu", dateFormat.format(tuNgay.plusDays(i)).toString());
			i++;
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
	
	private void refresh() {
		showBarChartDoanhThu(LocalDate.now().minusDays(6), LocalDate.now());
		showBarChartSoLuong(LocalDate.now().minusDays(6), LocalDate.now());
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
}
