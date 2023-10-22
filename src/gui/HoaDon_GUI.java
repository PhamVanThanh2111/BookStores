package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connect.ConnectDB;
import dao.DungCuHocTap_DAO;
import dao.Sach_DAO;
import entity.DungCuHocTap;
import entity.Sach;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class HoaDon_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableTT;
	private DefaultTableModel modelTT;
	private JTextField txtSoLuong;
	private JComboBox<String> cbTenSP;
	private JComboBox<String> cbLoaiSP;
	private DefaultComboBoxModel<String> cbModelTenSP;
	private Sach_DAO sach_DAO;
	private DungCuHocTap_DAO dungCuHocTap_DAO;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtDiaChi;
	private JTextField txtConLai;
	private JTableHeader tableHeader;
	/**
	 * Create the panel.
	 */
	public HoaDon_GUI(String maNV) {
		setBackground(new Color(255, 255, 255));
		// khai bao DAO
		sach_DAO = new Sach_DAO();

		// connect
		ConnectDB.getInstance();
		ConnectDB.getConnection();

		setLayout(null);

		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(null);
		pnlMain.setBackground(new Color(241, 245, 249));
		pnlMain.setBounds(0, 0, 1300, 720);
		add(pnlMain);

		JPanel pTenKhachHang = new JPanel();
		pTenKhachHang.setBackground(new Color(255, 255, 255));
		pTenKhachHang.setLayout(null);
		pTenKhachHang.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pTenKhachHang.setBounds(0, 0, 530, 280);
		pnlMain.add(pTenKhachHang);
		
		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng:");
		lblMaKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaKhachHang.setBounds(23, 70, 141, 40);
		pTenKhachHang.add(lblMaKhachHang);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(174, 70, 336, 40);
		txtMaKhachHang.setEditable(false);
		pTenKhachHang.add(txtMaKhachHang);
		
		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng:");
		lblTenKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTenKhachHang.setBounds(23, 120, 141, 40);
		pTenKhachHang.add(lblTenKhachHang);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(174, 120, 336, 40);
		pTenKhachHang.add(txtTenKhachHang);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSoDienThoai.setBounds(23, 170, 141, 40);
		pTenKhachHang.add(lblSoDienThoai);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblDiaChi.setBounds(23, 220, 141, 40);
		pTenKhachHang.add(lblDiaChi);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(174, 170, 336, 40);
		pTenKhachHang.add(txtSoDienThoai);
		
		JLabel lblThongTinKhachHang = new JLabel("Thông Tin Khách Hàng");
		lblThongTinKhachHang.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinKhachHang.setBounds(20, 20, 219, 40);
		pTenKhachHang.add(lblThongTinKhachHang);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(174, 220, 336, 40);
		pTenKhachHang.add(txtDiaChi);

		JPanel pChiTietHoaDon = new JPanel();
		pChiTietHoaDon.setBackground(new Color(255, 255, 255));
		pChiTietHoaDon.setToolTipText("");
		pChiTietHoaDon.setLayout(null);
		pChiTietHoaDon.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pChiTietHoaDon.setBounds(0, 300, 1298, 420);
		pnlMain.add(pChiTietHoaDon);

		JScrollPane scrollPaneTT;
		scrollPaneTT = new JScrollPane();
		scrollPaneTT.setBounds(40, 70, 1218, 296);
		scrollPaneTT.setToolTipText("");
		scrollPaneTT.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneTT.setBackground(new Color(80, 80, 80));
		pChiTietHoaDon.add(scrollPaneTT);

		String colsTT[] = { "Tên Mặt Hàng", "Tên Loại", "Số Lượng", "Đơn Giá", "Thành Tiền" };
		modelTT = new DefaultTableModel(colsTT, 0);
		tableTT = new JTable(modelTT);
		tableTT.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		tableTT.setRowHeight(25);
		
		tableHeader = tableTT.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
		scrollPaneTT.setViewportView(tableTT);
		
		JLabel lblThngTinHoaDon = new JLabel("Thông Tin Hóa Đơn");
		lblThngTinHoaDon.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThngTinHoaDon.setBounds(20, 20, 203, 40);
		pChiTietHoaDon.add(lblThngTinHoaDon);
		
		JLabel lblTongTien = new JLabel("Tổng Tiền:");
		lblTongTien.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTongTien.setBounds(70, 373, 110, 40);
		pChiTietHoaDon.add(lblTongTien);
		
		JLabel lblTongTienValue = new JLabel("147.000 VND");
		lblTongTienValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTienValue.setForeground(new Color(255, 0, 0));
		lblTongTienValue.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTongTienValue.setBounds(175, 373, 166, 40);
		lblTongTienValue.setBorder(new LineBorder(new Color(0, 0, 0)));
		pChiTietHoaDon.add(lblTongTienValue);
		
		JButton btnLapHoaDon = new JButton("Lập HD");
		btnLapHoaDon.setIcon(new ImageIcon(HoaDon_GUI.class.getResource("/image/wallet.png")));
		btnLapHoaDon.setBackground(new Color(73, 129, 158));
		btnLapHoaDon.setForeground(new Color(255, 255, 255));
		btnLapHoaDon.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLapHoaDon.setBounds(1093, 373, 135, 40);
		pChiTietHoaDon.add(btnLapHoaDon);
		
		JButton btntHng = new JButton("Đặt Hàng");
		btntHng.setIcon(new ImageIcon(HoaDon_GUI.class.getResource("/image/clipboard.png")));
		btntHng.setBackground(new Color(73, 129, 158));
		btntHng.setForeground(new Color(255, 255, 255));
		btntHng.setFont(new Font("SansSerif", Font.BOLD, 14));
		btntHng.setBounds(948, 373, 135, 40);
		pChiTietHoaDon.add(btntHng);

		JPanel pThongTinKH = new JPanel();
		pThongTinKH.setBackground(new Color(255, 255, 255));
		pThongTinKH.setBorder(
				new LineBorder(new Color(0, 0, 0), 2));
		pThongTinKH.setBounds(550, 0, 748, 280);
		pnlMain.add(pThongTinKH);
		pThongTinKH.setLayout(null);

		JLabel lblLoaiSP = new JLabel("Loại Sản Phẩm:");
		lblLoaiSP.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblLoaiSP.setBounds(23, 70, 134, 40);
		pThongTinKH.add(lblLoaiSP);

		JLabel lblTenSP = new JLabel("Tên Sản Phẩm:");
		lblTenSP.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTenSP.setBounds(23, 120, 134, 40);
		pThongTinKH.add(lblTenSP);

		JLabel lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSoLuong.setBounds(23, 220, 134, 40);
		pThongTinKH.add(lblSoLuong);


		cbLoaiSP = new JComboBox<String>();
		cbLoaiSP.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbLoaiSP.setBounds(170, 70, 284, 40);
		cbLoaiSP.addItem("Sách");
		cbLoaiSP.addItem("Dụng cụ học tập");
		cbLoaiSP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cbLoaiSP.getSelectedItem().toString().equals("Sách")) {
					loadTenSachIntoComboboxTenSP();
				} else {
					loadTenDCHTIntoComboboxTenSP();
				}
			}
		});
		pThongTinKH.add(cbLoaiSP);

		cbTenSP = new JComboBox<String>();
		cbTenSP.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTenSP.setBounds(170, 120, 284, 40);
		loadTenSachIntoComboboxTenSP();
		pThongTinKH.add(cbTenSP);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoLuong.setBounds(170, 220, 282, 40);
		pThongTinKH.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(HoaDon_GUI.class.getResource("/image/cart.png")));
		btnThem.setBackground(new Color(73, 129, 158));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnThem.setBounds(462, 170, 135, 40);
		pThongTinKH.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(HoaDon_GUI.class.getResource("/image/trash-can.png")));
		btnXoa.setBackground(new Color(73, 129, 158));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBounds(608, 170, 130, 40);
		pThongTinKH.add(btnXoa);

		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(HoaDon_GUI.class.getResource("/image/refresh.png")));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoi.setBounds(462, 221, 135, 40);
		pThongTinKH.add(btnLamMoi);
		
		JLabel lblThongTinSanPham = new JLabel("Thông Tin Sản Phẩm");
		lblThongTinSanPham.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinSanPham.setBounds(20, 20, 192, 40);
		pThongTinKH.add(lblThongTinSanPham);
		
		JLabel lblConLai = new JLabel("Còn Lại:");
		lblConLai.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblConLai.setBounds(23, 170, 134, 40);
		pThongTinKH.add(lblConLai);
		
		txtConLai = new JTextField();
		txtConLai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtConLai.setColumns(10);
		txtConLai.setBounds(170, 170, 282, 40);
		pThongTinKH.add(txtConLai);

	}

	// load data ten sach vao combobox
	private void loadTenSachIntoComboboxTenSP() {
		cbModelTenSP = new DefaultComboBoxModel<String>();
		cbModelTenSP.removeAllElements();
		for (Sach sach : sach_DAO.getAllListSach()) {
			cbModelTenSP.addElement(sach.getTenSach());
		}
		cbTenSP.setModel(cbModelTenSP);
	}

	private void loadTenDCHTIntoComboboxTenSP() {
		cbModelTenSP = new DefaultComboBoxModel<String>();
		cbModelTenSP.removeAllElements();
		for (DungCuHocTap dungCuHocTap : dungCuHocTap_DAO.getAllListDungCuHocTap()) {
			cbModelTenSP.addElement(dungCuHocTap.getTenDungCuHocTap());
		}
		cbTenSP.setModel(cbModelTenSP);
	}
}
