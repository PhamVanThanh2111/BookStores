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
import javax.swing.table.JTableHeader;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

import dao.KhachHang_DAO;
import entity.KhachHang;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class KhachHang_GUI extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private KhachHang_DAO khachHang_DAO;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtQuocTich;
	private JTableHeader tableHeader;
	/**
	 * Create the panel.
	 */
	public KhachHang_GUI() {
		khachHang_DAO = new KhachHang_DAO();
		setLayout(null);

		JPanel pMain = new JPanel();
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);
		pMain.setLayout(null);

		JPanel pDanhSach = new JPanel();
		pDanhSach.setBackground(new Color(255, 255, 255));
		pDanhSach.setBorder(
				new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBounds(0, 0, 850, 720);
		pMain.add(pDanhSach);
		pDanhSach.setLayout(null);

		JScrollPane scrollPaneKH = new JScrollPane();
		scrollPaneKH.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneKH.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneKH.setBackground(new Color(80, 80, 80));
		scrollPaneKH.setBounds(20, 82, 810, 557);
		pDanhSach.add(scrollPaneKH);
		String[] cols = { "Tên KH", "Mã KH", "Giới Tính", "Số Điện Thoại", "Địa Chỉ" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		
		table.setSelectionBackground(new Color(141,208,229));
		table.setSelectionForeground(new Color(0,0,0));
		
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
		scrollPaneKH.setViewportView(table);
		
		JLabel lblThongTin = new JLabel("Khách Hàng");
		lblThongTin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTin.setBounds(20, 40, 133, 32);
		pDanhSach.add(lblThongTin);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(60, 60, 60));
		separator.setBounds(142, 56, 688, 2);
		pDanhSach.add(separator);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(395, 660, 135, 40);
		pDanhSach.add(btnAdd);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBackground(new Color(73, 129, 158));
		btnXoa.setBounds(545, 660, 135, 40);
		pDanhSach.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSua.setBackground(new Color(73, 129, 158));
		btnSua.setBounds(695, 660, 135, 40);
		pDanhSach.add(btnSua);
		
		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pNhapThongTin.setBackground(new Color(255, 255, 255));
		pNhapThongTin.setBounds(869, 0, 430, 720);
		pMain.add(pNhapThongTin);
		pNhapThongTin.setLayout(null);
		
		JLabel lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setBounds(20, 20, 64, 64);
		pNhapThongTin.add(lblHinhAnh);
		
		txtTenKH = new JTextField();
		txtTenKH.setToolTipText("Số điện thoại");
		txtTenKH.setText("Phạm Văn Thành");
		txtTenKH.setFont(new Font("SansSerif", Font.BOLD, 20));
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBorder(null);
		txtTenKH.setBackground(Color.WHITE);
		txtTenKH.setBounds(94, 20, 240, 40);
		pNhapThongTin.add(txtTenKH);
		
		JLabel lblKhchHng = new JLabel("Khách Hàng");
		lblKhchHng.setToolTipText("Mã nhân viên");
		lblKhchHng.setHorizontalAlignment(SwingConstants.LEFT);
		lblKhchHng.setForeground(new Color(28, 28, 28));
		lblKhchHng.setFont(new Font("SansSerif", Font.ITALIC, 20));
		lblKhchHng.setBounds(94, 50, 177, 40);
		pNhapThongTin.add(lblKhchHng);
		
		JLabel lblThongTinLienLac = new JLabel("Thông Tin Liên Lạc:");
		lblThongTinLienLac.setToolTipText("Mã nhân viên");
		lblThongTinLienLac.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinLienLac.setForeground(new Color(28, 28, 28));
		lblThongTinLienLac.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinLienLac.setBounds(20, 100, 189, 40);
		pNhapThongTin.add(lblThongTinLienLac);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setToolTipText("Số điện thoại");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSoDienThoai.setBounds(40, 145, 120, 40);
		pNhapThongTin.add(lblSoDienThoai);
		
		txtSDT = new JTextField();
		txtSDT.setToolTipText("Số điện thoại");
		txtSDT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBackground(Color.WHITE);
		txtSDT.setBounds(170, 145, 240, 40);
		pNhapThongTin.add(txtSDT);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(60, 60, 60));
		separator_1.setBounds(20, 200, 390, 2);
		pNhapThongTin.add(separator_1);
		
		JLabel lblThongTinCaNhan = new JLabel("Thông Tin Cá Nhân:");
		lblThongTinCaNhan.setToolTipText("Mã nhân viên");
		lblThongTinCaNhan.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinCaNhan.setForeground(new Color(28, 28, 28));
		lblThongTinCaNhan.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinCaNhan.setBounds(20, 215, 189, 40);
		pNhapThongTin.add(lblThongTinCaNhan);
		
		JLabel lblMaKH = new JLabel("Mã KH:");
		lblMaKH.setToolTipText("Số điện thoại");
		lblMaKH.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaKH.setBounds(40, 270, 120, 40);
		pNhapThongTin.add(lblMaKH);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính");
		lblGioiTinh.setToolTipText("Số điện thoại");
		lblGioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblGioiTinh.setBounds(40, 315, 120, 40);
		pNhapThongTin.add(lblGioiTinh);
		
		JLabel lblMaKhachHang = new JLabel("NV0001");
		lblMaKhachHang.setToolTipText("Số điện thoại");
		lblMaKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaKhachHang.setBounds(170, 270, 120, 40);
		pNhapThongTin.add(lblMaKhachHang);
		
		JComboBox<String> cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setToolTipText("Giới tính");
		cbGioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbGioiTinh.setBorder(null);
		cbGioiTinh.setBackground(Color.WHITE);
		cbGioiTinh.setBounds(170, 315, 240, 40);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		pNhapThongTin.add(cbGioiTinh);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setToolTipText("Số điện thoại");
		lblDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblDiaChi.setBounds(40, 360, 120, 40);
		pNhapThongTin.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setToolTipText("Số điện thoại");
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBackground(Color.WHITE);
		txtDiaChi.setBounds(170, 360, 240, 40);
		pNhapThongTin.add(txtDiaChi);
		
		JLabel lblQuocTich = new JLabel("Quốc Tịch:");
		lblQuocTich.setToolTipText("Số điện thoại");
		lblQuocTich.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblQuocTich.setBounds(40, 405, 120, 40);
		pNhapThongTin.add(lblQuocTich);
		
		txtQuocTich = new JTextField();
		txtQuocTich.setToolTipText("Số điện thoại");
		txtQuocTich.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtQuocTich.setEditable(false);
		txtQuocTich.setColumns(10);
		txtQuocTich.setBackground(Color.WHITE);
		txtQuocTich.setBounds(170, 405, 240, 40);
		pNhapThongTin.add(txtQuocTich);
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
	}

	public void loadData() {
		for (KhachHang Kh : khachHang_DAO.getAllKhachHang()) {
			Object[] object = {Kh.getTenKhachHang(),Kh.getMaKhachHang(), Kh.getGioiTinh(), Kh.getSoDienThoai(), Kh.getDiaChi() };
			model.addRow(object);
			table.setRowHeight(25);
		}
	}

	public void xoaTrang() {
		txtTenKH.setText("");
		
		txtDiaChi.setText("");
	
		txtSDT.setText("");
		
		
		txtTenKH.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
	
	}
}
