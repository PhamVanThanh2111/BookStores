package gui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

import dao.KhachHang_DAO;
import entity.KhachHang;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class KhachHang_GUI extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTimKiem;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtCCCD;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtTuoi;
	private JTable table;
	private DefaultTableModel model;
	private KhachHang_DAO khachHang_DAO;
	private JComboBox<String> cbGioiTinh;
	private JButton btnXoaTrang;

	/**
	 * Create the panel.
	 */
	public KhachHang_GUI() {
		khachHang_DAO = new KhachHang_DAO();
		setLayout(null);

		JPanel pMain = new JPanel();
		pMain.setBounds(27, 10, 1162, 667);
		add(pMain);
		pMain.setLayout(null);

		JLabel lblTimKiem = new JLabel("Tìm Kiếm ");
		lblTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTimKiem.setBounds(270, 10, 96, 33);
		pMain.add(lblTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimKiem.setBounds(375, 10, 257, 33);
		pMain.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(640, 10, 96, 33);
		pMain.add(cbTim);

		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBounds(745, 10, 114, 33);
		pMain.add(btnTim);

		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setLayout(null);
		pNhapThongTin.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)),
				"Th\u00F4ng tin:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pNhapThongTin.setBounds(10, 53, 1142, 219);
		pMain.add(pNhapThongTin);

		JLabel lblMKh = new JLabel("Mã KH:");
		lblMKh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMKh.setBounds(40, 30, 90, 33);
		pNhapThongTin.add(lblMKh);

		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaKH.setEditable(false);
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(120, 30, 151, 33);
		txtMaKH.setFocusable(false);
		pNhapThongTin.add(txtMaKH);

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(120, 70, 151, 33);
		pNhapThongTin.add(txtTenKH);

		JLabel lblTenKH = new JLabel("Tên KH:");
		lblTenKH.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenKH.setBounds(40, 70, 90, 33);
		pNhapThongTin.add(lblTenKH);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDiaChi.setBounds(40, 110, 90, 33);
		pNhapThongTin.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(120, 110, 450, 33);
		pNhapThongTin.add(txtDiaChi);

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGioiTinh.setBounds(291, 30, 90, 33);
		pNhapThongTin.add(lblGioiTinh);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoDienThoai.setBounds(604, 30, 103, 33);
		pNhapThongTin.add(lblSoDienThoai);

		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(730, 70, 332, 33);
		pNhapThongTin.add(txtCCCD);
		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbGioiTinh.setBounds(406, 30, 163, 33);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		cbGioiTinh.setSelectedIndex(-1);

		pNhapThongTin.add(cbGioiTinh);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmail.setBounds(604, 110, 56, 33);
		pNhapThongTin.add(lblEmail);

		JLabel lblCCCD = new JLabel("CCCD:");
		lblCCCD.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCCCD.setBounds(604, 70, 62, 33);
		pNhapThongTin.add(lblCCCD);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBounds(730, 30, 332, 33);
		pNhapThongTin.add(txtSDT);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(730, 110, 332, 33);
		pNhapThongTin.add(txtEmail);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBounds(132, 165, 120, 33);
		pNhapThongTin.add(btnAdd);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBounds(384, 165, 120, 33);
		pNhapThongTin.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSua.setBounds(636, 165, 120, 33);
		pNhapThongTin.add(btnSua);

		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoaTrang.setBounds(888, 165, 120, 33);
		pNhapThongTin.add(btnXoaTrang);

		JLabel lblTuoi = new JLabel("Tuổi:");
		lblTuoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTuoi.setBounds(291, 70, 56, 33);
		pNhapThongTin.add(lblTuoi);

		txtTuoi = new JTextField();
		txtTuoi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(405, 70, 164, 33);
		pNhapThongTin.add(txtTuoi);

		JPanel pThonTin = new JPanel();
		pThonTin.setBorder(
				new TitledBorder(null, "Danh S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pThonTin.setBounds(10, 282, 1142, 375);
		pMain.add(pThonTin);
		pThonTin.setLayout(null);

		JScrollPane scrollPaneKH = new JScrollPane();
		scrollPaneKH.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneKH.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneKH.setBackground(new Color(80, 80, 80));
		scrollPaneKH.setBounds(10, 20, 1122, 345);
		pThonTin.add(scrollPaneKH);
		String[] cols = { "Mã KH", "Tên KH", "Tuổi", "Giới Tính", "CCCD", "Email", "Số Điện Thoại", "Địa Chỉ" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		scrollPaneKH.setViewportView(table);
		loadData();

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				if (r != -1) {
					txtMaKH.setEditable(false);
					txtMaKH.setText(table.getValueAt(r, 0).toString());
					txtTenKH.setText(table.getValueAt(r, 1).toString());
					if (table.getValueAt(r, 2).toString().equalsIgnoreCase("Nam"))
						cbGioiTinh.setSelectedItem("Nam");
					else
						cbGioiTinh.setSelectedItem("Nữ");

				}
			}
//				String gt = (String)model.getValueAt(0, 3).toString();
//				txtMaKH.setText((String) model.getValueAt(row, 0));
//				txtTenKH.setText((String) model.getValueAt(row, 1));
//				txtTuoi.setText((String) model.getValueAt(row, 2).toString());
//				if(gt.equalsIgnoreCase("Nam")) {
//					cbGioiTinh.setSelectedIndex(1);
//				}else {
//					if(gt.equalsIgnoreCase("Nữ"))
//					cbGioiTinh.setSelectedIndex(0);
//				}
//				txtCCCD.setText((String) model.getValueAt(row, 4));
//				txtEmail.setText((String) model.getValueAt(row, 5));
//				txtSDT.setText((String) model.getValueAt(row, 6));
//				txtDiaChi.setText((String) model.getValueAt(row, 7));
//
//			}
		});

		btnXoaTrang.addActionListener(this);
	}

	public void loadData() {
		for (KhachHang Kh : khachHang_DAO.getAllKhachHang()) {
			Object[] object = { Kh.getMaKhachHang(), Kh.getTenKhachHang(), Kh.getGioiTinh(), Kh.getSoDienThoai(), Kh.getDiaChi() };
			model.addRow(object);
			table.setRowHeight(25);
		}
	}

	public void xoaTrang() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtTuoi.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtSDT.setText("");
		txtCCCD.setText("");
		cbGioiTinh.setSelectedIndex(0);
		txtTenKH.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		}
	}
}
