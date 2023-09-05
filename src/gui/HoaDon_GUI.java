package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class HoaDon_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public HoaDon_GUI() {
		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBackground(new Color(77, 77, 77));
		pMain.setBounds(0, 0, 1162, 667);
		add(pMain);
		
		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setLayout(null);
		pNhapThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "Th\u00F4ng tin:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pNhapThongTin.setBounds(10, 53, 221, 604);
		pMain.add(pNhapThongTin);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(377, 10, 257, 33);
		pMain.add(textField_7);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(750, 10, 114, 33);
		pMain.add(btnNewButton);
		
		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(644, 10, 96, 33);
		pMain.add(cbTim);
		
		JLabel lblTim = new JLabel("Tìm kiếm:");
		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTim.setForeground(Color.WHITE);
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(271, 10, 96, 33);
		pMain.add(lblTim);
		
		JPanel pDanhSach = new JPanel();
		pDanhSach.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		pDanhSach.setLayout(null);
		pDanhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "Danh s\u00E1ch:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pDanhSach.setBounds(526, 53, 626, 604);
		pMain.add(pDanhSach);
		
		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneNV.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneNV.setBackground(new Color(80, 80, 80));
		scrollPaneNV.setBounds(10, 21, 606, 573);
		pDanhSach.add(scrollPaneNV);

	}
}
