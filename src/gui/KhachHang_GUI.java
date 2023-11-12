package gui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Color;

import dao.KhachHang_DAO;
import dao.PhatSinhMa_DAO;
import entity.KhachHang;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;

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
	private JTableHeader tableHeader;
	private JButton btnThem,btnXoa,btnSua,btnTim;
	private JComboBox<String> cbGioiTinh ;
	private PhatSinhMa_DAO phatSinhMa_DAO;
	private JLabel lblMaKhachHang;
	private Border borderDefault;
	private LayoutManager layoutDefaultCombobox;
	private TimKiemKhachHang_GUI timKiemKhachHang_GUI;
	private ArrayList<KhachHang> ds;
	private JDesktopPane desktopPane;
	
	/**
	 * Create the panel.
	 */
	public KhachHang_GUI() {
		
		khachHang_DAO = new KhachHang_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();
		ds = new ArrayList<KhachHang>();
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1300, 720);
		add(panel);
		panel.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1300, 720);
		panel.add(desktopPane);
		
		JPanel pMain = new JPanel();
		pMain.setBackground(new Color(241, 245, 249));
		pMain.setBounds(0, 0, 1300, 720);
		desktopPane.add(pMain);
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
		scrollPaneKH.setBorder(new LineBorder(new Color(80, 80, 80), 2, true));
		scrollPaneKH.setBackground(new Color(80, 80, 80));
		scrollPaneKH.setBounds(20, 100, 810, 545);
		pDanhSach.add(scrollPaneKH);
		String[] cols = { "Tên KH", "Mã KH", "Giới Tính", "Số Điện Thoại", "Địa Chỉ" };
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
		
		scrollPaneKH.setViewportView(table);

		JLabel lblThongTin = new JLabel("Khách Hàng");
		lblThongTin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTin.setBounds(20, 40, 133, 40);
		pDanhSach.add(lblThongTin);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(60, 60, 60));
		separator.setBounds(142, 60, 688, 2);
		pDanhSach.add(separator);

		btnThem = new JButton("Thêm");
		btnThem.setOpaque(true);
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnThem.setBackground(new Color(73, 129, 158));
		btnThem.setBounds(245, 660, 135, 40);
		pDanhSach.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBackground(new Color(73, 129, 158));
		btnXoa.setBounds(395, 660, 135, 40);
		pDanhSach.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSua.setBackground(new Color(73, 129, 158));
		btnSua.setBounds(545, 660, 135, 40);
		pDanhSach.add(btnSua);
		
		btnTim = new JButton("Tìm");
		btnTim.setOpaque(true);
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(694, 660, 135, 40);
		pDanhSach.add(btnTim);
		
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
		txtTenKH.setText("");
		txtTenKH.setFont(new Font("SansSerif", Font.BOLD, 20));
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBorder(null);
		txtTenKH.setBackground(Color.WHITE);
		txtTenKH.setBounds(94, 20, 261, 40);
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
		txtSDT.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBackground(Color.WHITE);
		txtSDT.setBounds(170, 145, 240, 40);
		borderDefault = txtSDT.getBorder();
		txtSDT.setBorder(null);
	
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

		lblMaKhachHang = new JLabel();
		lblMaKhachHang.setToolTipText("Số điện thoại");
		lblMaKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaKhachHang.setBounds(170, 270, 120, 40);
		pNhapThongTin.add(lblMaKhachHang);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setToolTipText("Giới tính");
		cbGioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 18));
		cbGioiTinh.setBorder(null);
		cbGioiTinh.setBackground(Color.WHITE);
		cbGioiTinh.setBounds(170, 315, 240, 40);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		layoutDefaultCombobox = cbGioiTinh.getLayout();
		cbGioiTinh.setEditable(false);
		cbGioiTinh.setEnabled(false);
		cbGioiTinh.setBorder(null);
		cbGioiTinh.setLayout(null);
		cbGioiTinh.setSelectedIndex(-1);

		pNhapThongTin.add(cbGioiTinh);

		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setToolTipText("Số điện thoại");
		lblDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblDiaChi.setBounds(40, 360, 120, 40);
		pNhapThongTin.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setToolTipText("Số điện thoại");
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBackground(Color.WHITE);
		txtDiaChi.setBounds(170, 360, 240, 40);
		txtDiaChi.setBorder(null);
		pNhapThongTin.add(txtDiaChi);
		loadData(khachHang_DAO.getAllKhachHang());
	
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		closeText();

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
			

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				if (r != -1) {
					lblMaKhachHang.setText(table.getValueAt(r, 1).toString());
					txtTenKH.setText(table.getValueAt(r, 0).toString());
					if (table.getValueAt(r, 2).toString().equalsIgnoreCase("Nam"))
						cbGioiTinh.setSelectedItem("Nam");
					else
						cbGioiTinh.setSelectedItem("Nữ");
					txtSDT.setText(table.getValueAt(r, 3).toString());
					txtDiaChi.setText(table.getValueAt(r, 4).toString());
				}
			}
	
		});
	}
	public void loadData(ArrayList<KhachHang> ds) {
		model.setRowCount(0);
		for (KhachHang Kh : ds) {
			Object[] object = { Kh.getTenKhachHang(), Kh.getMaKhachHang(), Kh.getGioiTinh(), Kh.getSoDienThoai(),
					Kh.getDiaChi() };
			model.addRow(object);
		}
	}
	public void xoaTrang() {
		txtTenKH.setText("");
		txtDiaChi.setText("");
		txtSDT.setText("");
		cbGioiTinh.setSelectedIndex(-1);
		txtTenKH.requestFocus();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(btnThem)) {
			if(btnThem.getText().equalsIgnoreCase("Thêm")) {
			
				try {
					xoaTrang();
					btnThem.setText("Xác Nhận");
					btnXoa.setText("Hủy");
					btnSua.setEnabled(false);
					btnTim.setEnabled(false);
					lblMaKhachHang.setText(phatSinhMa_DAO.getMaKhachHang().toString());
					openText();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			}else {
				if(btnThem.getText().equalsIgnoreCase("Xác Nhận")) {
					try {
						themKhachHang();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					loadData(khachHang_DAO.getAllKhachHang());
					btnSua.setEnabled(true);
					btnTim.setEnabled(true);
					btnThem.setText("Thêm");
					btnXoa.setText("Xóa");
					closeText();
				
				}
			}
		}else {
			if(o.equals(btnXoa)){
				if(btnXoa.getText().equalsIgnoreCase("Hủy")) {
					btnThem.setText("Thêm");
					btnXoa.setText("Xóa");
					btnSua.setEnabled(true);
					btnTim.setEnabled(true);
					xoaTrang();
					closeText();
					
				}else {
					if(btnXoa.getText().equalsIgnoreCase("Xóa")) {
						int r = table.getSelectedRow();
						if(r==-1) {
							JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Khách Hàng !");
						}else {
							try {
								xoaKhachHang();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			}else {
				if(o.equals(btnSua)) {
					int r = table.getSelectedRow();
					if(r==-1) {
						JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Khách Hàng !");
					}else {
						if(btnSua.getText().equalsIgnoreCase("Sửa")) {
							btnSua.setText("Xác Nhận");
							btnTim.setText("Hủy");
							btnThem.setEnabled(false);
							btnXoa.setEnabled(false);
							openText();
						}else {
							if(btnSua.getText().equalsIgnoreCase("Xác Nhận")) {
								btnSua.setText("Sửa");
								btnTim.setText("Tìm");
								suaKhachHang();
								closeText();
								btnThem.setEnabled(true);
								btnXoa.setEnabled(true);
							}
						}
					}
				}else {
					if(o.equals(btnTim)) {
						if(btnTim.getText().equalsIgnoreCase("Hủy")) {
							btnSua.setText("Sửa");
							btnTim.setText("Tìm");
							btnThem.setEnabled(true);
							btnXoa.setEnabled(true);
							xoaTrang();	
							closeText();
						}else {
							if(btnTim.getText().equalsIgnoreCase("Tìm")){
								btnThem.setEnabled(false);
								btnXoa.setEnabled(false);
								btnSua.setEnabled(false);
								if (timKiemKhachHang_GUI == null || timKiemKhachHang_GUI.isClosed()) {
									timKiemKhachHang_GUI = new TimKiemKhachHang_GUI(ds);
									timKiemKhachHang_GUI.addInternalFrameListener(new InternalFrameAdapter() {
							            @Override
							            public void internalFrameActivated(InternalFrameEvent e) {
//							                System.out.println("Internal frame is activated.");
							            }

							            @Override
							            public void internalFrameDeactivated(InternalFrameEvent e) {
//							                System.out.println("Internal frame is deactivated.");
							            }

							            @Override
							            public void internalFrameOpened(InternalFrameEvent e) {
//							                System.out.println("Internal frame is opened.");
//							            	disableButton();
							            }
							            
							            @Override
							            public void internalFrameClosed(InternalFrameEvent e) {
//							                System.out.println("Internal frame is closed.");
							            	loadData(ds);
							            	ds.removeAll(ds);
							            	btnThem.setEnabled(true);
											btnXoa.setEnabled(true);
											btnSua.setEnabled(true);
							            }
							        });
									desktopPane.add(timKiemKhachHang_GUI).setVisible(true);
								}
							}
						}
					}
					
				}
			}
		}
	}
	private void themKhachHang() throws SQLException {
		if(txtTenKH.getText().equalsIgnoreCase("")||txtSDT.getText().equalsIgnoreCase("")||cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("")||txtDiaChi.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Thông Tin Rỗng !");
		}
		if(!txtTenKH.getText().equalsIgnoreCase("")&&!txtSDT.getText().equalsIgnoreCase("")&&!cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("")&&!txtDiaChi.getText().equalsIgnoreCase("")) {
			KhachHang khachHang = new KhachHang();
			khachHang.setMaKhachHang(phatSinhMa_DAO.getMaKhachHang());
			khachHang.setTenKhachHang(txtTenKH.getText());
			khachHang.setGioiTinh(cbGioiTinh.getSelectedItem().toString());
			khachHang.setSoDienThoai(txtSDT.getText());
			khachHang.setDiaChi(txtDiaChi.getText());
			if(!kiemTraTrungSDT(txtSDT.getText())) {
				khachHang_DAO.themKhachHang(khachHang);
				JOptionPane.showMessageDialog(null, "Thêm Khách Hàng Thành Công");
			}else{
				JOptionPane.showMessageDialog(null, "Số Điện Thoại Đã Tồn Tại");

			}
		}
	}
	public void xoaKhachHang() throws SQLException {
		int row = table.getSelectedRow();
		if(row !=-1) {
			int tb = JOptionPane.showConfirmDialog(null, "Bạn Muốn Xóa Khách Hàng ? ", "Delete", JOptionPane.YES_NO_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				try {
					khachHang_DAO.xoaKhachHangTheoMa((String)model.getValueAt(row,1));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Khách Hàng Đang Có Hóa Đơn Trong Cửa Hàng !");
				}
			
			}
		}
	}
	public void closeText() {
		cbGioiTinh.setEditable(false);
		cbGioiTinh.setEnabled(false);
		cbGioiTinh.setBorder(null);
		cbGioiTinh.setLayout(null);
		txtTenKH.setEditable(false);
		txtSDT.setEditable(false);
		txtDiaChi.setEditable(false);
		txtTenKH.setBorder(null);
		txtSDT.setBorder(null);
		txtDiaChi.setBorder(null);
		
		txtDiaChi.setFocusable(false);
		txtTenKH.setFocusable(false);
		txtSDT.setFocusable(false);
		txtDiaChi.setFocusable(false);
		
	}
	
	public void openText() {
		txtTenKH.setEditable(true);
		txtSDT.setEditable(true);
		cbGioiTinh.setEditable(true);
		txtDiaChi.setEditable(true);
		cbGioiTinh.setLayout(layoutDefaultCombobox);
		cbGioiTinh.setBorder(borderDefault);
		cbGioiTinh.setEnabled(true);
		txtDiaChi.setEditable(true);
		txtTenKH.setBorder(borderDefault);
		txtSDT.setBorder(borderDefault);
		txtDiaChi.setBorder(borderDefault);
		
		
		txtDiaChi.setFocusable(true);
		txtTenKH.setFocusable(true);
		txtSDT.setFocusable(true);
		txtDiaChi.setFocusable(true);
		
	}
	
	private boolean kiemTraTrungSDT(String sDT) {
		for(KhachHang khachHang : khachHang_DAO.getAllKhachHang()) {
			if(khachHang.getSoDienThoai().equalsIgnoreCase(sDT.trim())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean suaKhachHang() {
		
		if(txtTenKH.getText().equalsIgnoreCase("")||txtSDT.getText().equalsIgnoreCase("")||cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("")||txtDiaChi.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Thông Tin Rỗng !");
			
			
		}
		if(!txtTenKH.getText().equalsIgnoreCase("")&&!txtSDT.getText().equalsIgnoreCase("")&&!cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("")&&!txtDiaChi.getText().equalsIgnoreCase("")){
			KhachHang khachHang = new KhachHang();
			khachHang.setMaKhachHang(lblMaKhachHang.getText());
			khachHang.setTenKhachHang(txtTenKH.getText());
			khachHang.setSoDienThoai(txtSDT.getText());
			JOptionPane.showMessageDialog(null, "Số Điện Thoại Đã Tồn Tại !");
			khachHang.setDiaChi(txtDiaChi.getText());
			khachHang.setGioiTinh(cbGioiTinh.getSelectedItem().toString());
			try {
				khachHang_DAO.suaKhachHangTheoMa(khachHang);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Cập Nhập Khách Hàng Thành Công");
			loadData(khachHang_DAO.getAllKhachHang());
		}
		return false;
	}
}
