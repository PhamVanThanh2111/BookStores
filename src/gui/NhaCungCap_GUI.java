package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhaCungCap_DAO;
import dao.PhatSinhMa_DAO;
import entity.NhaCungCap;

public class NhaCungCap_GUI extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtTenNhaCungCap;
	private JTextField txtDiaChi;
	private JTable table;
	private DefaultTableModel model;
	private JTableHeader tableHeader;
	private Border borderDefault;
	private JLabel lblMaNCC;
	private NhaCungCap_DAO nhaCungCap_DAO;
	private PhatSinhMa_DAO phatSinhMa_DAO;
	private JButton btnXoa,btnThem,btnSua,btnTim;
	
	public NhaCungCap_GUI() {
		
		
		nhaCungCap_DAO = new NhaCungCap_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();
		
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
		lblHinhAnh.setBounds(20, 20, 64, 64);
		pNhapThongTin.add(lblHinhAnh);
		
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
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setToolTipText("Email");
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblEmail.setBounds(40, 190, 56, 40);
		pNhapThongTin.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Email");
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(170, 190, 240, 40);
		pNhapThongTin.add(txtEmail);
		
		JLabel lblnnhaCungCap = new JLabel("Nhà Cung Cấp");
		lblnnhaCungCap.setToolTipText("Mã Nhà Cung Cấp");
		lblnnhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
		lblnnhaCungCap.setForeground(new Color(28, 28, 28));
		lblnnhaCungCap.setFont(new Font("SansSerif", Font.ITALIC, 20));
		lblnnhaCungCap.setBounds(94, 50, 261, 40);
		pNhapThongTin.add(lblnnhaCungCap);
		
		JLabel lblThongTinLienLac = new JLabel("Thông Tin Liên Lạc:");
		lblThongTinLienLac.setToolTipText("Nhà cung cấp");
		lblThongTinLienLac.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinLienLac.setForeground(new Color(28, 28, 28));
		lblThongTinLienLac.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinLienLac.setBounds(20, 100, 189, 40);
		pNhapThongTin.add(lblThongTinLienLac);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(60, 60, 60));
		separator_1.setBounds(20, 245, 390, 2);
		pNhapThongTin.add(separator_1);
		
		JLabel lblThngTinNh = new JLabel("Thông Tin Nhà Cung Cấp:");
		lblThngTinNh.setToolTipText("Mã nhân viên");
		lblThngTinNh.setHorizontalAlignment(SwingConstants.LEFT);
		lblThngTinNh.setForeground(new Color(28, 28, 28));
		lblThngTinNh.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThngTinNh.setBounds(20, 257, 270, 40);
		pNhapThongTin.add(lblThngTinNh);
		
		JLabel lblmaNhaCungCap = new JLabel("Mã NCC:");
		lblmaNhaCungCap.setToolTipText("Mã Nhà Cung Cấp");
		lblmaNhaCungCap.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblmaNhaCungCap.setBounds(40, 302, 169, 40);
		pNhapThongTin.add(lblmaNhaCungCap);
		
		lblMaNCC = new JLabel("");
		lblMaNCC.setToolTipText("Mã Nhà Cung Cấp");
		lblMaNCC.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaNCC.setBounds(170, 302, 120, 40);
		pNhapThongTin.add(lblMaNCC);
		
		JLabel lbldiaChi = new JLabel("Địa Chỉ:");
		lbldiaChi.setToolTipText("Địa chỉ nhà cung cấp");
		lbldiaChi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbldiaChi.setBounds(40, 347, 120, 40);
		pNhapThongTin.add(lbldiaChi);
		
		JButton btnChonHinhAnh = new JButton("Choose");
		btnChonHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonHinhAnh.setBounds(20, 86, 64, 21);
		pNhapThongTin.add(btnChonHinhAnh);
		
		txtTenNhaCungCap = new JTextField();
		txtTenNhaCungCap.setToolTipText("Số điện thoại");
		txtTenNhaCungCap.setFont(new Font("SansSerif", Font.BOLD, 20));
		txtTenNhaCungCap.setEditable(false);
		txtTenNhaCungCap.setColumns(10);
		txtTenNhaCungCap.setBorder(null);
		txtTenNhaCungCap.setBackground(Color.WHITE);
		txtTenNhaCungCap.setBounds(94, 20, 261, 40);
		pNhapThongTin.add(txtTenNhaCungCap);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setToolTipText("Email");
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBackground(Color.WHITE);
		txtDiaChi.setBounds(170, 347, 240, 40);
		pNhapThongTin.add(txtDiaChi);
		
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
		
		borderDefault = txtEmail.getBorder();
		
		String cols[] = { "Mã Nhà Cung Cấp ", "Tên Nhà Cung Cấp", "Địa Chỉ", "Số Điện Thoại", "Email" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		
		table.setRowHeight(25);
		table.setSelectionBackground(new Color(141, 208, 229));
		table.setSelectionForeground(new Color(0, 0, 0));
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		
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
				int r  = table.getSelectedRow();
				
				lblMaNCC.setText((String)model.getValueAt(r, 0));
				txtTenNhaCungCap.setText((String)model.getValueAt(r, 1));
				txtDiaChi.setText((String)model.getValueAt(r, 2));
				txtSDT.setText((String)model.getValueAt(r, 3));
				txtEmail.setText((String)model.getValueAt(r, 4));
				
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
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBackground(new Color(73, 129, 158));
		btnXoa.setBounds(395, 660, 135, 40);
		pDanhSach.add(btnXoa);
		
		btnThem = new JButton("Thêm");
		btnThem.setOpaque(true);
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnThem.setBackground(new Color(73, 129, 158));
		btnThem.setBounds(245, 660, 135, 40);
		pDanhSach.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSua.setBackground(new Color(73, 129, 158));
		btnSua.setBounds(545, 660, 135, 40);
		pDanhSach.add(btnSua);
		
		btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(695, 660, 135, 40);
		pDanhSach.add(btnTim);	
		loadData();
		closeFocusTXT();
		
		btnThem.addActionListener(this);
		
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
	public void openFocusTXT() {
		txtTenNhaCungCap.setFocusable(true);
		txtEmail.setFocusable(true);
		txtSDT.setFocusable(true);
		txtDiaChi.setFocusable(true);
		
		txtTenNhaCungCap.setEditable(true);
		txtEmail.setEditable(true);
		txtSDT.setEditable(true);
		txtDiaChi.setEditable(true);
		
		
		
		txtTenNhaCungCap.setBorder(borderDefault);
		txtEmail.setBorder(borderDefault);
		txtSDT.setBorder(borderDefault);
		txtDiaChi.setBorder(borderDefault);
	}
	
	public void closeFocusTXT() {
		txtTenNhaCungCap.setFocusable(false);
		txtEmail.setFocusable(false);
		txtSDT.setFocusable(false);
		txtDiaChi.setFocusable(false);
		
		txtTenNhaCungCap.setBorder(null);
		txtEmail.setBorder(null);
		txtSDT.setBorder(null);
		txtDiaChi.setBorder(null);
		
		txtTenNhaCungCap.setEditable(false);
		txtEmail.setEditable(false);
		txtSDT.setEditable(false);
		txtDiaChi.setEditable(false);
		
	}
	public void xoaTrang() {
		txtTenNhaCungCap.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
		lblMaNCC.setText("");
	}
	
	public void themNhaCungCap() throws SQLException {
		if(txtTenNhaCungCap.getText().equalsIgnoreCase("")
			||txtSDT.getText().equalsIgnoreCase("")
			||txtEmail.getText().equalsIgnoreCase("")
			||txtDiaChi.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Thông Tin Rỗng !");
		}else {
			
			NhaCungCap nhaCC = new NhaCungCap();
			
			nhaCC.setMaNCC(phatSinhMa_DAO.getMaNhaCungCap().toString());
			nhaCC.setTenNCC(txtTenNhaCungCap.getText());
			nhaCC.setSoDienThoai(txtSDT.getText());
			nhaCC.setDiaChi(txtDiaChi.getText());
			nhaCC.setEmail(txtEmail.getText());
			
			nhaCungCap_DAO.themNhaCC(nhaCC);
			JOptionPane.showMessageDialog(null, "Thêm Nhà Cung Cấp Thành Công !");
			loadData();
		}
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(btnThem)) {
			if(btnThem.getText().equalsIgnoreCase("Thêm")) {
				btnTim.setEnabled(false);
				btnSua.setEnabled(false);
				openFocusTXT();
				btnThem.setText("Xác Nhận");
				btnXoa.setText("Hủy");
				xoaTrang();
				try {
					lblMaNCC.setText(phatSinhMa_DAO.getMaNhaCungCap().toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}else {
				if(btnThem.getText().equalsIgnoreCase("Xác Nhận")) {
					btnTim.setEnabled(true);
					btnSua.setEnabled(true);
					closeFocusTXT();
					btnThem.setText("Thêm");
					btnXoa.setText("Xóa");
					try {
						themNhaCungCap();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		}
		
	}
	
	
}
