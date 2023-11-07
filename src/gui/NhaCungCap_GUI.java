package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhaCungCap_DAO;
import entity.NhaCungCap;

public class NhaCungCap_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtnhaCungCap;
	private JTextField txtdiaChi;
	private JTable table;
	private DefaultTableModel model;
	private JTableHeader tableHeader;

	/**
	 * Create the panel.
	 */
	public NhaCungCap_GUI() {
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
		
		textField = new JTextField();
		textField.setToolTipText("Số điện thoại");
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(170, 201, 240, 40);
		pNhapThongTin.add(textField);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setToolTipText("Email");
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblEmail.setBounds(40, 246, 56, 40);
		pNhapThongTin.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Email");
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(170, 246, 240, 40);
		pNhapThongTin.add(textField_1);
		
		JLabel lblLuong = new JLabel("Lương:");
		lblLuong.setToolTipText("Lương");
		lblLuong.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLuong.setBounds(880, 70, 56, 33);
		pNhapThongTin.add(lblLuong);
		
		JLabel lblnnhaCungCap = new JLabel("NCC0001");
		lblnnhaCungCap.setToolTipText("Mã Nhà Cung Cấp");
		lblnnhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
		lblnnhaCungCap.setForeground(new Color(28, 28, 28));
		lblnnhaCungCap.setFont(new Font("SansSerif", Font.ITALIC, 20));
		lblnnhaCungCap.setBounds(120, 50, 177, 40);
		pNhapThongTin.add(lblnnhaCungCap);
		
		JLabel lblThongTinLienLac = new JLabel("Thông Tin Liên Lạc:");
		lblThongTinLienLac.setToolTipText("Nhà cung cấp");
		lblThongTinLienLac.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinLienLac.setForeground(new Color(28, 28, 28));
		lblThongTinLienLac.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinLienLac.setBounds(20, 156, 189, 40);
		pNhapThongTin.add(lblThongTinLienLac);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(60, 60, 60));
		separator_1.setBounds(20, 310, 390, 2);
		pNhapThongTin.add(separator_1);
		
		JLabel lblThngTinNh = new JLabel("Thông Tin Nhà Cung Cấp:");
		lblThngTinNh.setToolTipText("Mã nhân viên");
		lblThngTinNh.setHorizontalAlignment(SwingConstants.LEFT);
		lblThngTinNh.setForeground(new Color(28, 28, 28));
		lblThngTinNh.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThngTinNh.setBounds(20, 322, 270, 40);
		pNhapThongTin.add(lblThngTinNh);
		
		JLabel lblmaNhaCungCap = new JLabel("Mã NCC:");
		lblmaNhaCungCap.setToolTipText("Số điện thoại");
		lblmaNhaCungCap.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblmaNhaCungCap.setBounds(40, 367, 169, 40);
		pNhapThongTin.add(lblmaNhaCungCap);
		
		JLabel lblNcc = new JLabel("NCC0001");
		lblNcc.setToolTipText("Số điện thoại");
		lblNcc.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNcc.setBounds(170, 367, 120, 40);
		pNhapThongTin.add(lblNcc);
		
		JLabel lbldiaChi = new JLabel("Địa Chỉ:");
		lbldiaChi.setToolTipText("Địa chỉ nhà cung cấp");
		lbldiaChi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbldiaChi.setBounds(40, 412, 120, 40);
		pNhapThongTin.add(lbldiaChi);
		
		JButton btnChonHinhAnh = new JButton("Choose");
		btnChonHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonHinhAnh.setBounds(30, 116, 64, 21);
		pNhapThongTin.add(btnChonHinhAnh);
		
		txtnhaCungCap = new JTextField();
		txtnhaCungCap.setToolTipText("Số điện thoại");
		txtnhaCungCap.setText("Thiên Long");
		txtnhaCungCap.setFont(new Font("SansSerif", Font.BOLD, 20));
		txtnhaCungCap.setEditable(false);
		txtnhaCungCap.setColumns(10);
		txtnhaCungCap.setBorder(null);
		txtnhaCungCap.setBackground(Color.WHITE);
		txtnhaCungCap.setBounds(120, 20, 240, 40);
		pNhapThongTin.add(txtnhaCungCap);
		
		txtdiaChi = new JTextField();
		txtdiaChi.setToolTipText("Email");
		txtdiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtdiaChi.setEditable(false);
		txtdiaChi.setColumns(10);
		txtdiaChi.setBackground(Color.WHITE);
		txtdiaChi.setBounds(170, 412, 240, 40);
		pNhapThongTin.add(txtdiaChi);
		
		JPanel pDanhSach = new JPanel();
		pDanhSach.setLayout(null);
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBackground(Color.WHITE);
		pDanhSach.setBounds(0, 0, 850, 720);
		pMain.add(pDanhSach);
		
		JScrollPane scrollPaneNCC = new JScrollPane();
		scrollPaneNCC.setToolTipText("Chọn vào nhà cung cấp cần hiển thị thông tin");
		scrollPaneNCC.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneNCC.setBackground(new Color(80, 80, 80));
		scrollPaneNCC.setBounds(20, 100, 810, 545);
		pDanhSach.add(scrollPaneNCC);
		
		String cols[] = { "Mã Nhà Cung Cấp ", "Tên Nhà Cung Cấp", "Địa Chỉ", "Số Điện Thoại", "Email" };
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
		scrollPaneNCC.setViewportView(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		
		JLabel lblnhaCungCap = new JLabel("Nhà Cung Cấp");
		lblnhaCungCap.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblnhaCungCap.setBounds(20, 40, 130, 40);
		pDanhSach.add(lblnhaCungCap);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(60, 60, 60));
		separator.setBounds(154, 60, 676, 2);
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
			NhaCungCap_DAO nhaCungCap_DAO = new NhaCungCap_DAO();
			model.setRowCount(0);
			for (NhaCungCap NhaCungCap : nhaCungCap_DAO.getAllNhaCungCap()) {
				Object[] object = { NhaCungCap.getMaNCC(), NhaCungCap.getTenNCC(), NhaCungCap.getDiaChi(),
						NhaCungCap.getSoDienThoai(), NhaCungCap.getEmail()};
				model.addRow(object);
				table.setRowHeight(25);
			}
		}
	
}
