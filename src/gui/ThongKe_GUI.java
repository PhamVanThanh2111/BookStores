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

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;

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

	/**
	 * Create the panel.
	 */
	public ThongKe_GUI() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1300, 720);
		add(panel);
		showBarChart();
	}
	
	private void showBarChart() {
		dataset = new DefaultCategoryDataset();
		
		dataset.addValue(23, "Nam", "Nam");
		
		dataset.addValue(27, "Nữ", "Nữ");
		
		dataset.addValue(2, "Bê đe", "Bê đê");
		
		chart = ChartFactory.createBarChart("TI LE NAM NU", "GIOI TINH", "SO LUONG", dataset, PlotOrientation.VERTICAL, true, true, false);
		
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
}
