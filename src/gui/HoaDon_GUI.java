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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		lblTim.setBounds(270, 10, 96, 33);
		pMain.add(lblTim);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(375, 10, 255, 33);
		pMain.add(txtTimKiem);

		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(640, 10, 95, 33);
		pMain.add(cbTim);

		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(745, 10, 95, 33);
		pMain.add(btnNewButton);

		JPanel pTenKhachHang = new JPanel();
		pTenKhachHang.setLayout(null);
		pTenKhachHang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)),
				"T\u00EAn kh\u00E1ch h\u00E0ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pTenKhachHang.setBounds(10, 53, 506, 234);
		pMain.add(pTenKhachHang);
		
				scrollPaneTenKH = new JScrollPane();
				scrollPaneTenKH.setBounds(10, 24, 486, 200);
				pTenKhachHang.add(scrollPaneTenKH);
				scrollPaneTenKH.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
				scrollPaneTenKH.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
				scrollPaneTenKH.setBackground(new Color(80, 80, 80));
				table = new JTable(model);
				table.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
				table.setRowHeight(25);
				scrollPaneTenKH.setViewportView(table);

		String cols[] = { "Tên KH" };
		model = new DefaultTableModel(cols, 0);

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
		pNhanVien.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)),
				"Nh\u00E2n vi\u00EAn:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pNhanVien.setBounds(10, 561, 506, 96);
		pMain.add(pNhanVien);
		
		JPanel pThongTinKH = new JPanel();
		pThongTinKH.setBorder(new TitledBorder(null, "S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pThongTinKH.setBounds(10, 297, 506, 254);
		pMain.add(pThongTinKH);
		pThongTinKH.setLayout(null);
		
		JLabel lblLoaiSP = new JLabel("Loại Sản Phẩm:");
		lblLoaiSP.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLoaiSP.setBounds(30, 30, 120, 33);
		pThongTinKH.add(lblLoaiSP);
		
		JLabel lblTenSP = new JLabel("Tên Sản Phẩm:");
		lblTenSP.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenSP.setBounds(30, 70, 120, 33);
		pThongTinKH.add(lblTenSP);
		
		JLabel lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoLuong.setBounds(30, 110, 120, 33);
		pThongTinKH.add(lblSoLuong);
		
		JComboBox<String> cbLoai = new JComboBox<String>();
		cbLoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbLoai.setBounds(160, 30, 284, 33);
		pThongTinKH.add(cbLoai);
		
		JComboBox<String> cbTenSp = new JComboBox<String>();
		cbTenSp.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTenSp.setBounds(160, 70, 284, 33);
		pThongTinKH.add(cbTenSp);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoLuong.setBounds(162, 110, 282, 33);
		pThongTinKH.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnThem.setBounds(36, 195, 120, 33);
		pThongTinKH.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBounds(192, 195, 120, 33);
		pThongTinKH.add(btnXoa);
		
		JButton btnThanhTon = new JButton("Thanh Toán");
		btnThanhTon.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnThanhTon.setBounds(348, 195, 120, 33);
		pThongTinKH.add(btnThanhTon);

	}
}
