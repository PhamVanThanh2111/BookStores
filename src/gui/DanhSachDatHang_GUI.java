package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import javax.swing.JButton;

public class DanhSachDatHang_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMaHoaDon,lblTien,lblTenNhanVien,lblSDThoai,lblTenKhachHang;
	private JButton btnLapHD,btnXoa;
	private DefaultTableModel model;
	private JTable table;
	private JTableHeader tableHeader;
	
	/**
	 * Create the panel.
	 */
	public DanhSachDatHang_GUI() {
		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);
		pMain.setLayout(null);
		
		JPanel pDanhSachHoaDon = new JPanel();
		pDanhSachHoaDon.setBackground(new Color(255, 255, 255));
		pDanhSachHoaDon.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSachHoaDon.setBounds(0, 0, 750, 720);
		pMain.add(pDanhSachHoaDon);
		pDanhSachHoaDon.setLayout(null);
		
		JLabel lblThongTinDatHang = new JLabel("Thông Tin Đặt Hàng");
		lblThongTinDatHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinDatHang.setBounds(20, 30, 200, 40);
		pDanhSachHoaDon.add(lblThongTinDatHang);
		
		JScrollPane scrollPane = new JScrollPane();
	
		String cols[]= {"Mã HD","Tên KH","SĐT","Tổng Tiền"};
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
	
		table.setToolTipText("Chọn vào hóa đơn cần hiển thị thông tin");
		table.setRowHeight(30);
		table.setDefaultEditor(Object.class, null);
		table.setShowGrid(true);
		table.setShowHorizontalLines(true);
		
		table.setSelectionBackground(new Color(141,208,229));
		table.setSelectionForeground(new Color(0,0,0));
		scrollPane.setBackground(new Color(80, 80, 80));
		scrollPane.setBounds(20, 82, 710, 500);
		
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
		
		scrollPane.setViewportView(table);
		
		pDanhSachHoaDon.add(scrollPane);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(73, 129, 158));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBounds(595, 640, 135, 40);
		pDanhSachHoaDon.add(btnXoa);
		
		btnLapHD = new JButton("Lập HD");
		btnLapHD.setForeground(Color.WHITE);
		btnLapHD.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLapHD.setBackground(new Color(73, 129, 158));
		btnLapHD.setBounds(445, 640, 135, 40);
		pDanhSachHoaDon.add(btnLapHD);
		
		JPanel pThongTinHoaDon = new JPanel();
		pThongTinHoaDon.setBackground(new Color(255, 255, 255));
		pThongTinHoaDon.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTinHoaDon.setBounds(770, 0, 530, 720);
		pMain.add(pThongTinHoaDon);
		pThongTinHoaDon.setLayout(null);
		
		JLabel lblThongTinHoaDon = new JLabel("Thông Tin Hóa Đơn");
		lblThongTinHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinHoaDon.setBounds(20, 30, 200, 40);
		pThongTinHoaDon.add(lblThongTinHoaDon);
		
		JLabel lblMaHD = new JLabel("Mã Hóa Đơn:");
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaHD.setBounds(40, 120, 113, 40);
		pThongTinHoaDon.add(lblMaHD);
		
		lblMaHoaDon = new JLabel("HD0002");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMaHoaDon.setBounds(210, 120, 150, 40);
		pThongTinHoaDon.add(lblMaHoaDon);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenKH.setBounds(40, 165, 150, 40);
		pThongTinHoaDon.add(lblTenKH);
		
		lblTenKhachHang = new JLabel("Trần Thanh Tâm");
		lblTenKhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenKhachHang.setBounds(210, 165, 282, 40);
		pThongTinHoaDon.add(lblTenKhachHang);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSDT.setBounds(40, 210, 150, 40);
		pThongTinHoaDon.add(lblSDT);
		
		lblSDThoai = new JLabel("0388412884");
		lblSDThoai.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSDThoai.setBounds(210, 210, 282, 40);
		pThongTinHoaDon.add(lblSDThoai);
		
		JLabel lblTenNV = new JLabel("Tên Nhân Viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenNV.setBounds(40, 255, 150, 40);
		pThongTinHoaDon.add(lblTenNV);
		
		lblTenNhanVien = new JLabel("Trịnh Minh Kha");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenNhanVien.setBounds(210, 255, 282, 40);
		pThongTinHoaDon.add(lblTenNhanVien);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 310, 490, 230);
		pThongTinHoaDon.add(scrollPane_1);
		
		JLabel lblTongTien = new JLabel("Tổng Tiền:");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTongTien.setBounds(240, 550, 122, 40);
		pThongTinHoaDon.add(lblTongTien);
		
		lblTien = new JLabel("80.000 VND");
		lblTien.setForeground(new Color(255, 0, 0));
		lblTien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTien.setBounds(360, 550, 150, 40);
		pThongTinHoaDon.add(lblTien);

	}
}
