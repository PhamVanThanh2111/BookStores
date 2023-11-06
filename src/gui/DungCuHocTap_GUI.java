package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhaCungCap_DAO;
import dao.PhatSinhMa_DAO;
import dao.SanPham_DAO;
import entity.NhaCungCap;
import entity.SanPham;
import javax.swing.JComboBox;

public class DungCuHocTap_GUI extends JPanel  implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtmaDCHT;
	private JTextField txttenDCHT;
	private JTextField txtsoLuong;
	private JTextField txtgiaBan;
	private JTextField txtgiaNhap;
	private JTable table;
	private JTableHeader tableHeader;
	private DefaultTableModel model;
	private SanPham_DAO sanPham_DAO;
	private JButton btnAdd,btnlamMoi,btnUpdate,btnDelete;
	private PhatSinhMa_DAO phatSinhMa_DAO;
	private JTextField txtXuatXu;
	private NhaCungCap_DAO nhaCC_DAO;
	private NhaCungCap nhacc;
	private JComboBox<String> cbNhaCC;
	/**
	 * Create the panel.
	 */
	public DungCuHocTap_GUI() {
		
		// khai bao DAO
		sanPham_DAO = new SanPham_DAO();
		phatSinhMa_DAO = new PhatSinhMa_DAO();
		nhaCC_DAO = new NhaCungCap_DAO();
		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1300, 320);
		pMain.add(pThongTin);
		
		JLabel lblthongTinDCHT = new JLabel("Thông Tin Dụng Cụ Học Tập");
		lblthongTinDCHT.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthongTinDCHT.setBounds(20, 15, 260, 40);
		pThongTin.add(lblthongTinDCHT);
		
		JLabel lblmaDCHT = new JLabel("Mã DCHT:");
		lblmaDCHT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmaDCHT.setBounds(40, 70, 90, 40);
		pThongTin.add(lblmaDCHT);
		
		JLabel lbltenDCHT = new JLabel("Tên DCHT:");
		lbltenDCHT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltenDCHT.setBounds(40, 115, 90, 40);
		pThongTin.add(lbltenDCHT);
		
		JLabel lblnhaCC = new JLabel("Nhà CC:");
		lblnhaCC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnhaCC.setBounds(40, 160, 90, 40);
		pThongTin.add(lblnhaCC);
		
		txtmaDCHT = new JTextField();
		txtmaDCHT.setToolTipText("Mã Sách");
		txtmaDCHT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtmaDCHT.setEditable(false);
		txtmaDCHT.setColumns(10);
		txtmaDCHT.setBackground(Color.WHITE);
		txtmaDCHT.setBounds(145, 70, 255, 40);
		txtmaDCHT.setFocusable(false);
		txtmaDCHT.setEditable(false);
		
		pThongTin.add(txtmaDCHT);
		
		txttenDCHT = new JTextField();
		txttenDCHT.setToolTipText("Tên Sách");
		txttenDCHT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txttenDCHT.setEditable(false);
		txttenDCHT.setColumns(10);
		txttenDCHT.setBackground(Color.WHITE);
		txttenDCHT.setBounds(145, 115, 255, 40);
		pThongTin.add(txttenDCHT);
		
		JLabel lblgia = new JLabel("Giá Nhập:");
		lblgia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgia.setBounds(450, 70, 130, 40);
		pThongTin.add(lblgia);
		
		JLabel lblnhaXuatBan = new JLabel("Giá Bán:");
		lblnhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnhaXuatBan.setBounds(450, 115, 130, 40);
		pThongTin.add(lblnhaXuatBan);
		
		JLabel lblgiaNhap = new JLabel("Số Lượng:");
		lblgiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgiaNhap.setBounds(450, 160, 98, 40);
		pThongTin.add(lblgiaNhap);
		
		txtsoLuong = new JTextField();
		txtsoLuong.setToolTipText("Giá nhập");
		txtsoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtsoLuong.setEditable(false);
		txtsoLuong.setColumns(10);
		txtsoLuong.setBackground(Color.WHITE);
		txtsoLuong.setBounds(550, 160, 255, 40);
		pThongTin.add(txtsoLuong);
		
		JLabel lblanh = new JLabel("Ảnh DCHT:");
		lblanh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblanh.setBounds(853, 160, 94, 40);
		pThongTin.add(lblanh);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(145, 250, 135, 40);
		pThongTin.add(btnAdd);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(432, 250, 135, 40);
		pThongTin.add(btnDelete);
		
		btnUpdate = new JButton("Sửa");
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(719, 250, 135, 40);
		pThongTin.add(btnUpdate);
		
		btnlamMoi = new JButton("Làm mới");
		btnlamMoi.setOpaque(true);
		btnlamMoi.setForeground(Color.WHITE);
		btnlamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnlamMoi.setBackground(new Color(73, 129, 158));
		btnlamMoi.setBounds(1006, 250, 135, 40);
		pThongTin.add(btnlamMoi);
		
		JButton btnChonHinhAnh = new JButton("Choose");
		btnChonHinhAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChonHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonHinhAnh.setBounds(971, 174, 90, 19);
		pThongTin.add(btnChonHinhAnh);
		
		JLabel lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setBounds(957, 160, 303, 40);
		pThongTin.add(lblHinhAnh);
		
		txtgiaBan = new JTextField();
		txtgiaBan.setToolTipText("Giá nhập");
		txtgiaBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtgiaBan.setEditable(false);
		txtgiaBan.setColumns(10);
		txtgiaBan.setBackground(Color.WHITE);
		txtgiaBan.setBounds(550, 115, 255, 40);
		pThongTin.add(txtgiaBan);
		
		txtgiaNhap = new JTextField();
		txtgiaNhap.setToolTipText("Giá nhập");
		txtgiaNhap.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtgiaNhap.setEditable(false);
		txtgiaNhap.setColumns(10);
		txtgiaNhap.setBackground(Color.WHITE);
		txtgiaNhap.setBounds(550, 70, 255, 40);
		pThongTin.add(txtgiaNhap);
		
		JLabel lblXutX = new JLabel("Xuất Xứ:");
		lblXutX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXutX.setBounds(853, 115, 94, 40);
		pThongTin.add(lblXutX);
		
		txtXuatXu = new JTextField();
		txtXuatXu.setToolTipText("Giá nhập");
		txtXuatXu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtXuatXu.setEditable(false);
		txtXuatXu.setColumns(10);
		txtXuatXu.setBackground(Color.WHITE);
		txtXuatXu.setBounds(957, 115, 303, 40);
		pThongTin.add(txtXuatXu);
		
		cbNhaCC = new JComboBox<String>();
		cbNhaCC.setSelectedIndex(-1);
		cbNhaCC.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbNhaCC.setBounds(144, 160, 255, 40);
		
		// Load Nhà Cung Cấp lên CB
		loadCBNhaCC();
		
		
		
		pThongTin.add(cbNhaCC);
		
		JPanel pDanhSach = new JPanel();
		pDanhSach.setLayout(null);
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBackground(Color.WHITE);
		pDanhSach.setBounds(0, 330, 1300, 380);
		pMain.add(pDanhSach);
		
		JScrollPane scrollPaneDungCuHocTap = new JScrollPane();
		scrollPaneDungCuHocTap.setToolTipText("Chọn vào Dụng cụ học tập cần hiển thị thông tin");
		scrollPaneDungCuHocTap.setBorder(null);
		scrollPaneDungCuHocTap.setBackground(Color.WHITE);
		scrollPaneDungCuHocTap.setBounds(20, 51, 1259, 319);
		pDanhSach.add(scrollPaneDungCuHocTap);
		
		String cols[] = { "Mã Dụng Cụ Học Tập", "Tên Dụng Cụ Học Tập ", "Xuất Xứ", "Giá Nhập",
				"Giá Bán", "Số Lượng Tồn","Nhà Cung Cấp" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setToolTipText("Chọn vào dụng cụ học tập cần hiển thị thông tin");
		table.setRowHeight(30);
		table.setDefaultEditor(Object.class, null);
		table.setShowGrid(true); 
		table.setShowHorizontalLines(true);
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(141, 208, 229));
		table.setSelectionForeground(new Color(0, 0, 0));
	
		scrollPaneDungCuHocTap.setViewportView(table);
		// header of table
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		
		
		JLabel lblChiTitDng = new JLabel("Chi Tiết Dụng Cụ Học Tập");
		lblChiTitDng.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTitDng.setBounds(20, 15, 246, 40);
		pDanhSach.add(lblChiTitDng);
		loadData();
		btnlamMoi.addActionListener(this);
		btnAdd.addActionListener(this);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
				txtmaDCHT.setText((String)model.getValueAt(r, 0));
				txttenDCHT.setText((String)model.getValueAt(r, 1));
				txtXuatXu.setText((String)model.getValueAt(r, 2));
				txtgiaNhap.setText((String)model.getValueAt(r, 3).toString());
				txtgiaBan.setText((String)model.getValueAt(r, 4).toString());
				txtsoLuong.setText((String)model.getValueAt(r, 5).toString());
				cbNhaCC.setSelectedItem(model.getValueAt(r, 6).toString());
			}
		});;
		
	}
	public void loadData() {
	    // Xóa dữ liệu cũ trước khi nạp dữ liệu mới
	    model.setRowCount(0);
	    // Lấy danh sách sản phẩm từ DAO 
	    List<SanPham> sanPhamList = null;
		try {
			sanPhamList = sanPham_DAO.getAllDungCuHocTap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    // Nạp dữ liệu sản phẩm lên bảng
	    for (SanPham sanPham : sanPhamList) {
	        Object[] object = {sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getXuatXu(),
	                sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getSoLuongTon(),nhaCC_DAO.getNhaCCTheoMa(sanPham.getMaNhaCungCap()).getTenNCC()};
	        model.addRow(object);
	        table.setRowHeight(25);
	    }
	}
	public void loadCBNhaCC() {
		for(NhaCungCap nhaCC : nhaCC_DAO.getAllNhaCungCap()) {
			cbNhaCC.addItem(nhaCC.getTenNCC());
		}
	}
	
	public void lamMoi() {
		txtmaDCHT.setText("");
		txttenDCHT.setText("");
		txtgiaNhap.setText("");
		txtXuatXu.setText("");
		txtgiaBan.setText("");
		txtsoLuong.setText("");
		cbNhaCC.setSelectedIndex(-1);
	}
	
	public void refresh() {
		loadData();
	}
	public void closeText() {
		txttenDCHT.setEditable(false);
		txtXuatXu.setEditable(false);
		txtgiaNhap.setEditable(false);
		txtgiaBan.setEditable(false);
		txtsoLuong.setEditable(false);

	}
	
	public void openText() {
		txttenDCHT.setEditable(true);
		txtXuatXu.setEditable(true);
		txtgiaNhap.setEditable(true);
		txtgiaBan.setEditable(true);
		txtsoLuong.setEditable(true);
	}
	
	public void themDCHT() {
		if(txtmaDCHT.getText().equalsIgnoreCase("")||
				txttenDCHT.getText().equalsIgnoreCase("")||
				txtgiaNhap.getText().equalsIgnoreCase("")||
				txtgiaBan.getText().equalsIgnoreCase("")||
				txtXuatXu.getText().equalsIgnoreCase("")||
				txtsoLuong.getText().equalsIgnoreCase("")||
				cbNhaCC.getSelectedIndex()==-1 ) {
			JOptionPane.showMessageDialog(null, "Thông Tin Rỗng !");
		}else {
			SanPham sanPham = new SanPham();
			
			try {
				sanPham.setMaSanPham(phatSinhMa_DAO.getMaDCHT());
				sanPham.setTenSanPham(txttenDCHT.getText());
				sanPham.setXuatXu(txtXuatXu.getText());
				sanPham.setGiaNhap(Float.parseFloat(txtgiaNhap.getText()));
				sanPham.setGiaBan(Float.parseFloat(txtgiaBan.getText()));
				sanPham.setSoLuongTon(Integer.parseInt(txtsoLuong.getText()));
				
				
				//
				if (cbNhaCC.getSelectedIndex() != -1) {
					nhacc  = nhaCC_DAO.getNhaCungCapTheoTen(cbNhaCC.getSelectedItem().toString());
				}
				sanPham.setMaNhaCungCap(nhacc.getMaNCC());
				sanPham.setHinhAnh("a");
				sanPham_DAO.themSanPham(sanPham);
				JOptionPane.showMessageDialog(null, "Thêm Sản Phẩm Thành Công !");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o  = e.getSource();
		if(o.equals(btnlamMoi)) {
			lamMoi();
		}else {
			if(o.equals(btnAdd)) {
				if(btnAdd.getText().equalsIgnoreCase("Thêm")) {
					btnAdd.setText("Xác Nhận");
					btnDelete.setText("Hủy");
					btnUpdate.setEnabled(false);
					openText();
					try {
						txtmaDCHT.setText(phatSinhMa_DAO.getMaDCHT().toString());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {
					if(btnAdd.getText().equalsIgnoreCase("Xác Nhận")) {
						int tb = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thêm Dụng Cụ Học Tập ? ", "Delete", JOptionPane.YES_NO_OPTION);
						if(tb==JOptionPane.YES_OPTION) {
							themDCHT();
							btnAdd.setText("Thêm");
							btnDelete.setText("Xóa");
							btnUpdate.setEnabled(true);
							closeText();
							loadData();
						}
					}
				}
			}
		}
	}
}
