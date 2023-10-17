package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.DungCuHocTap_DAO;
import dao.Sach_DAO;
import entity.DungCuHocTap;
import entity.Sach;

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
	private DefaultTableModel model;
	private JTable tableTT;
	private DefaultTableModel modelTT;
	private JTextField txtSoLuong;
	private JComboBox<String> cbTenSP;
	private JComboBox<String> cbLoaiSP;
	private DefaultComboBoxModel<String> cbModelTenSP;
	private Sach_DAO sach_DAO;
	private DungCuHocTap_DAO dungCuHocTap_DAO;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtDiaChi;

	/**
	 * Create the panel.
	 */
	public HoaDon_GUI(String maNV) {
		// khai bao DAO
		sach_DAO = new Sach_DAO();

		// connect
		ConnectDB.getInstance();
		ConnectDB.getConnection();

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
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenKhachHang.setBounds(32, 30, 120, 33);
		pTenKhachHang.add(lblTenKhachHang);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(164, 30, 282, 33);
		txtTenKhachHang.setEditable(false);
		pTenKhachHang.add(txtTenKhachHang);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoDienThoai.setBounds(32, 73, 120, 33);
		pTenKhachHang.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(164, 73, 282, 33);
		pTenKhachHang.add(txtSoDienThoai);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGioiTinh.setBounds(32, 116, 120, 33);
		pTenKhachHang.add(lblGioiTinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDiaChi.setBounds(32, 159, 120, 33);
		pTenKhachHang.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(164, 159, 282, 33);
		txtDiaChi.setEditable(false);
		pTenKhachHang.add(txtDiaChi);
		
		JComboBox<String> cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbGioiTinh.setBounds(164, 116, 284, 33);
		cbGioiTinh.setEditable(false);
		pTenKhachHang.add(cbGioiTinh);

		String cols[] = { "Tên KH" };
		model = new DefaultTableModel(cols, 0);

		JPanel pChiTietHoaDon = new JPanel();
		pChiTietHoaDon.setToolTipText("");
		pChiTietHoaDon.setLayout(null);
		pChiTietHoaDon.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pChiTietHoaDon.setBounds(526, 53, 626, 604);
		pMain.add(pChiTietHoaDon);

		JScrollPane scrollPaneTT;
		scrollPaneTT = new JScrollPane();
		scrollPaneTT.setBounds(10, 20, 606, 574);
		scrollPaneTT.setToolTipText("");
		scrollPaneTT.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneTT.setBackground(new Color(80, 80, 80));
		pChiTietHoaDon.add(scrollPaneTT);

		String colsTT[] = { "Tên mặt hàng", "Tên loại", "Số lượng", "Đơn giá", "Thành tiền" };
		modelTT = new DefaultTableModel(colsTT, 0);
		tableTT = new JTable(modelTT);
		tableTT.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		tableTT.setRowHeight(25);
		scrollPaneTT.setViewportView(tableTT);

		JPanel pThongTinKH = new JPanel();
		pThongTinKH.setBorder(
				new TitledBorder(null, "S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

		cbLoaiSP = new JComboBox<String>();
		cbLoaiSP.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbLoaiSP.setBounds(160, 30, 284, 33);
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
		cbTenSP.setBounds(160, 70, 284, 33);
		loadTenSachIntoComboboxTenSP();
		pThongTinKH.add(cbTenSP);

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
		
		JPanel pNhanVien = new JPanel();
		pNhanVien.setLayout(null);
		pNhanVien.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "Nh\u00E2n vi\u00EAn:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pNhanVien.setBounds(10, 561, 506, 96);
		pMain.add(pNhanVien);

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
