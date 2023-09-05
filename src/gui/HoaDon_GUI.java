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
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class HoaDon_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTimKiem;
	private JTable table;
	private DefaultTableModel model;

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
		
		JLabel lblTim = new JLabel("Tìm kiếm:");
		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTim.setForeground(Color.WHITE);
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(271, 10, 96, 33);
		pMain.add(lblTim);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(377, 10, 257, 33);
		pMain.add(txtTimKiem);
		
		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(644, 10, 96, 33);
		pMain.add(cbTim);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(750, 10, 114, 33);
		pMain.add(btnNewButton);
		
		JPanel pTenKhachHang = new JPanel();
		pTenKhachHang.setLayout(null);
		pTenKhachHang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "T\u00EAn kh\u00E1ch h\u00E0ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pTenKhachHang.setBounds(10, 53, 221, 604);
		pMain.add(pTenKhachHang);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		pTenKhachHang.add(scrollPane);
		
		String[] colsTenKhachHang = {"Tên khách hàng"};
		model = new DefaultTableModel(colsTenKhachHang, 0);
		table = new JTable(model);
		table.setBounds(0, 0, 1, 1);
		scrollPane.add(table);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		pThongTin.setLayout(null);
		pThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "Th\u00F4ng tin chung", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pThongTin.setBounds(526, 53, 626, 604);
		pMain.add(pThongTin);
		
		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneNV.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneNV.setBackground(new Color(80, 80, 80));
		scrollPaneNV.setBounds(10, 21, 606, 573);
		pThongTin.add(scrollPaneNV);
		
		JPanel pSanPham = new JPanel();
		pSanPham.setLayout(null);
		pSanPham.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "S\u1EA3n ph\u1EA9m:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pSanPham.setBounds(241, 53, 275, 604);
		pMain.add(pSanPham);

	}
}
