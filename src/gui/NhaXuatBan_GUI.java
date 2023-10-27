package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhaXuatBan_DAO;
import entity.NhaXuatBan;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;

public class NhaXuatBan_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DefaultTableModel model;
	private JTable table;
	private JTableHeader tableHeader;
	private JTextField txtsoDienThoai;
	private JTextField txtEmail;
	private JTextField txttenNhaXuatBan;
	private JTextField txtdiaChi;

	/**
	 * Create the panel.
	 */
	public NhaXuatBan_GUI() {

		// Khai bao DAO

		setLayout(null);

		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBackground(new Color(241, 245, 249));
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);

		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setLayout(null);
		pNhapThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pNhapThongTin.setBackground(Color.WHITE);
		pNhapThongTin.setBounds(869, 0, 430, 720);
		pMain.add(pNhapThongTin);

		JLabel lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setBounds(20, 20, 90, 90);
		pNhapThongTin.add(lblHinhAnh);

		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setToolTipText("Số điện thoại");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSoDienThoai.setBounds(40, 201, 120, 40);
		pNhapThongTin.add(lblSoDienThoai);

		txtsoDienThoai = new JTextField();
		txtsoDienThoai.setToolTipText("Số điện thoại");
		txtsoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtsoDienThoai.setEditable(false);
		txtsoDienThoai.setColumns(10);
		txtsoDienThoai.setBackground(Color.WHITE);
		txtsoDienThoai.setBounds(170, 201, 240, 40);
		pNhapThongTin.add(txtsoDienThoai);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setToolTipText("Email");
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblEmail.setBounds(40, 246, 56, 40);
		pNhapThongTin.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setToolTipText("Email");
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(170, 246, 240, 40);
		pNhapThongTin.add(txtEmail);

		JLabel lblLuong = new JLabel("Lương:");
		lblLuong.setToolTipText("Lương");
		lblLuong.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLuong.setBounds(880, 70, 56, 33);
		pNhapThongTin.add(lblLuong);

		JLabel lblnNXB = new JLabel("NXB");
		lblnNXB.setToolTipText("Mã nhà xuất bản");
		lblnNXB.setHorizontalAlignment(SwingConstants.LEFT);
		lblnNXB.setForeground(new Color(28, 28, 28));
		lblnNXB.setFont(new Font("SansSerif", Font.ITALIC, 20));
		lblnNXB.setBounds(120, 50, 177, 40);
		pNhapThongTin.add(lblnNXB);

		JLabel lblThongTinLienLac = new JLabel("Thông Tin Liên Lạc:");
		lblThongTinLienLac.setToolTipText("Nhà Xuất Bản");
		lblThongTinLienLac.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinLienLac.setForeground(new Color(28, 28, 28));
		lblThongTinLienLac.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinLienLac.setBounds(20, 156, 189, 40);
		pNhapThongTin.add(lblThongTinLienLac);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(60, 60, 60));
		separator_1.setBounds(20, 310, 390, 2);
		pNhapThongTin.add(separator_1);

		JLabel lblthongTinNXB = new JLabel("Thông Tin Nhà Xuất Bản:");
		lblthongTinNXB.setToolTipText("Mã nhân viên");
		lblthongTinNXB.setHorizontalAlignment(SwingConstants.LEFT);
		lblthongTinNXB.setForeground(new Color(28, 28, 28));
		lblthongTinNXB.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblthongTinNXB.setBounds(20, 322, 270, 40);
		pNhapThongTin.add(lblthongTinNXB);

		JLabel lblmaNXB = new JLabel("Mã NXB:");
		lblmaNXB.setToolTipText("Số điện thoại");
		lblmaNXB.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblmaNXB.setBounds(40, 367, 120, 40);
		pNhapThongTin.add(lblmaNXB);

		JLabel lblMaNXB = new JLabel("NV0001");
		lblMaNXB.setToolTipText("Số điện thoại");
		lblMaNXB.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaNXB.setBounds(170, 367, 120, 40);
		pNhapThongTin.add(lblMaNXB);

		JLabel lbldiaChi = new JLabel("Địa Chỉ:");
		lbldiaChi.setToolTipText("Địa chỉ nhà xuất bản");
		lbldiaChi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbldiaChi.setBounds(40, 412, 120, 40);
		pNhapThongTin.add(lbldiaChi);

		JButton btnChonHinhAnh = new JButton("Choose");
		btnChonHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonHinhAnh.setBounds(30, 116, 64, 21);
		pNhapThongTin.add(btnChonHinhAnh);

		txttenNhaXuatBan = new JTextField();
		txttenNhaXuatBan.setToolTipText("Số điện thoại");
		txttenNhaXuatBan.setText("Nhà Xuất Bản Trẻ");
		txttenNhaXuatBan.setFont(new Font("SansSerif", Font.BOLD, 20));
		txttenNhaXuatBan.setEditable(false);
		txttenNhaXuatBan.setColumns(10);
		txttenNhaXuatBan.setBorder(null);
		txttenNhaXuatBan.setBackground(Color.WHITE);
		txttenNhaXuatBan.setBounds(120, 20, 240, 40);
		pNhapThongTin.add(txttenNhaXuatBan);

		txtdiaChi = new JTextField();
		txtdiaChi.setToolTipText("Email");
		txtdiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtdiaChi.setEditable(false);
		txtdiaChi.setColumns(10);
		txtdiaChi.setBackground(Color.WHITE);
		txtdiaChi.setBounds(170, 412, 240, 40);
		pNhapThongTin.add(txtdiaChi);

		PanelRound pDanhSach = new PanelRound();
		pDanhSach.setLayout(null);
		pDanhSach.setRoundTopLeft(16);
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBackground(Color.WHITE);
		pDanhSach.setBounds(0, 0, 850, 720);
		pMain.add(pDanhSach);

//		JScrollPane scrollPaneNXB = new JScrollPane();
//		scrollPaneNXB.setToolTipText("Chọn vào nhà xuất bản cần hiển thị thông tin");
//		scrollPaneNXB.setBorder(null);
//		scrollPaneNXB.setBackground(Color.WHITE);
//		scrollPaneNXB.setBounds(20, 70, 810, 569);
//		pDanhSach.add(scrollPaneNXB);
//
//		scrollPaneNXB.setViewportView(table);
//
//		table = new JTable(model);
//		table.setToolTipText("Chọn vào nhà xuất bản cần hiển thị thông tin");
//		table.setShowHorizontalLines(true);
//		table.setShowGrid(true);
//		table.setSelectionForeground(Color.BLACK);
//		table.setSelectionBackground(new Color(141, 208, 229));
//		table.setRowHeight(30);
//		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		table.setBackground(Color.WHITE);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
//		table.setBounds(20, 649, 810, -577);
//		pDanhSach.add(table);
		JScrollPane scrollPaneNXB = new JScrollPane();
		scrollPaneNXB.setToolTipText("Chọn vào nhà xuất bản cần hiển thị thông tin");
		scrollPaneNXB.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneNXB.setBackground(new Color(80, 80, 80));
		scrollPaneNXB.setBounds(20, 82, 810, 557);
		pDanhSach.add(scrollPaneNXB);
		
		String cols[] = { "Mã Nhà Xuất Bản", "Tên Nhà Xuất Bản", "Địa Chỉ", "Số Điện Thoại", "Email" };
		model = new DefaultTableModel(cols, 0);
		
		table = new JTable(model);
		
		table.setRowHeight(25);
		table.setSelectionBackground(new Color(141, 208, 229));
		table.setSelectionForeground(new Color(0, 0, 0));
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
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
				// TODO Auto-generated method stub
				
			}
		});
		scrollPaneNXB.setViewportView(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		
		
		JLabel lblNh = new JLabel("Nhà Xuất Bản");
		lblNh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNh.setBounds(20, 22, 130, 40);
		pDanhSach.add(lblNh);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(60, 60, 60));
		separator.setBounds(154, 50, 676, 2);
		pDanhSach.add(separator);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBackground(new Color(73, 129, 158));
		btnXoa.setBounds(395, 660, 135, 40);
		pDanhSach.add(btnXoa);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(245, 660, 135, 40);
		pDanhSach.add(btnAdd);

		JButton btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSua.setBackground(new Color(73, 129, 158));
		btnSua.setBounds(545, 660, 135, 40);
		pDanhSach.add(btnSua);

		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(695, 660, 135, 40);
		pDanhSach.add(btnTim);

		loadData();

	}
	// đưa dữ liệu lên bảng
	public void loadData() {
		NhaXuatBan_DAO nhaXuatBan_DAO = new NhaXuatBan_DAO();
		model.setRowCount(0);
		for (NhaXuatBan nhaXuatBan : nhaXuatBan_DAO.getAllNhaXuatBan()) {
			Object[] object = { nhaXuatBan.getMaNXB(), nhaXuatBan.getTenNXB(), nhaXuatBan.getDiaChi(),
					nhaXuatBan.getSoDienThoai(), nhaXuatBan.getEmail()};
			model.addRow(object);
			table.setRowHeight(25);
		}
	}

}
