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
import javax.swing.border.LineBorder;
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
	private JTable tableTT;
	private DefaultTableModel modelTT;
	private JScrollPane scrollPaneTenKH;
	private JTextField txtSoLuong;

	/**
	 * Create the panel.
	 */
	public HoaDon_GUI(String maNV) {
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
		pTenKhachHang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)),
				"T\u00EAn kh\u00E1ch h\u00E0ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pTenKhachHang.setBounds(10, 53, 221, 604);
		pMain.add(pTenKhachHang);
		
		JScrollPane scrollPaneNV;

		scrollPaneTenKH = new JScrollPane();
		scrollPaneTenKH.setBounds(10, 20, 201, 574);
		scrollPaneTenKH.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneTenKH.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneTenKH.setBackground(new Color(80, 80, 80));
		pTenKhachHang.add(scrollPaneTenKH);

		String cols[] = { "Tên KH" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		table.setRowHeight(25);
		scrollPaneTenKH.setViewportView(table);

		JPanel pSanPham = new JPanel();
		pSanPham.setLayout(null);


		pSanPham.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)),
				"S\u1EA3n ph\u1EA9m:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pSanPham.setBounds(241, 53, 275, 604);
		pSanPham.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "S\u1EA3n ph\u1EA9m:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pSanPham.setBounds(241, 53, 275, 279);

		pMain.add(pSanPham);

		JLabel lblLoaiSanPham = new JLabel("Loại sản phẩm:");
		lblLoaiSanPham.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblLoaiSanPham.setBounds(10, 51, 103, 33);
		pSanPham.add(lblLoaiSanPham);


		JComboBox cbLoaiSanPham = new JComboBox();

		
		JComboBox<String> cbLoaiSanPham1 = new JComboBox<String>();

		cbLoaiSanPham1.setBounds(123, 51, 142, 33);
		cbLoaiSanPham1.addItem("");
		cbLoaiSanPham1.addItem("Sách");
		cbLoaiSanPham1.addItem("Dụng cụ học tập");
		pSanPham.add(cbLoaiSanPham1);

		JLabel lblTen = new JLabel("Tên sản phẩm:");
		lblTen.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTen.setBounds(10, 103, 103, 33);
		pSanPham.add(lblTen);

		JComboBox cbTenSanPham = new JComboBox();
		cbTenSanPham.setBounds(123, 103, 142, 33);
		pSanPham.add(cbTenSanPham);

		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblSLng.setBounds(10, 155, 103, 33);
		pSanPham.add(lblSLng);

		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(123, 155, 142, 33);
		pSanPham.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		JPanel pThongTin = new JPanel();
		pThongTin.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		pThongTin.setLayout(null);
		pThongTin.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)),
				"Th\u00F4ng tin chung", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pThongTin.setBounds(526, 53, 626, 604);
		pMain.add(pThongTin);

		JScrollPane scrollPaneTT;
		scrollPaneTT = new JScrollPane();
		scrollPaneTT.setBounds(10, 20, 606, 574);
		scrollPaneTT.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneTT.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneTT.setBackground(new Color(80, 80, 80));
		pThongTin.add(scrollPaneTT);

		String colsTT[] = { "Tên mặt hàng", "Tên loại", "Số lượng", "Đơn giá", "Thành tiền" };
		modelTT = new DefaultTableModel(colsTT, 0);
		tableTT = new JTable(modelTT);
		tableTT.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		tableTT.setRowHeight(25);
		scrollPaneTT.setViewportView(tableTT);
		
		JPanel pNhanVien = new JPanel();
		pNhanVien.setLayout(null);
		pNhanVien.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "Nh\u00E2n vi\u00EAn:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pNhanVien.setBounds(241, 342, 275, 315);
		pMain.add(pNhanVien);

	}
}
