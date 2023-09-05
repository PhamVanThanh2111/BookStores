package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;

import dao.CuaHang_DAO;
import entity.CuaHang;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

public class CuaHang_GUI extends JPanel {
	private DefaultTableModel model;
	private JTable table;
	private JTableHeader tableHeader;
	private JTextField txtMaCH,txtTenCH,txtSDT,txtemail,txtDiaChi,txtSoLuongNV,txtGioHD;
	private JTextField txtTimKiem;
	private CuaHang_DAO cuaHang_DAO;
	private JTextField txtMaCHTT;
	private JTextField txtTenCHTT;
	private JTextField txtDiaChiTT;
	private JTextField txtSoLuongNhanVienTT;
	private JTextField txtEmailTT;
	private JTextField txtSDTTT;
	private JTextField txtGioHoatDongTT;
	/**
	 * Create the panel.
	 */
	public CuaHang_GUI() {
		
		cuaHang_DAO = new CuaHang_DAO();
		
		
		setLayout(null);
	    
		JPanel pMain = new JPanel();
		pMain.setBounds(10, 10, 1162, 667);
		add(pMain);
		pMain.setLayout(null);
		
		JPanel pDanhSach = new JPanel();
		pDanhSach.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(28, 28, 28)), "Danh s\u00E1ch:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(28, 28, 28)));
		pDanhSach.setBounds(10, 10, 1142, 318);
		pMain.add(pDanhSach);
		pDanhSach.setLayout(null);
		
		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(10, 20, 1122, 289);
		scrollPaneNV.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneNV.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPaneNV.setBackground(new Color(80, 80, 80));
		pDanhSach.add(scrollPaneNV);
		String cols[] = {"Mã CH","Tên CH","Địa Chỉ","Số Điện Thoại","Email","Số Lượng NV","Giờ Hoạt Động"};
		model = new DefaultTableModel(cols, 1);
		table = new JTable(model);
		table.setRowHeight(25);
		tableHeader= table.getTableHeader();
		scrollPaneNV.setViewportView(table);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnThem.setBounds(10, 358, 103, 38);
		pMain.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnXoa.setBounds(123, 358, 103, 38);
		pMain.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnSua.setBounds(236, 358, 103, 38);
		pMain.add(btnSua);
		
		txtMaCH = new JTextField();
		txtTenCH = new JTextField();
		txtDiaChi = new JTextField();
		txtSDT = new JTextField();
		txtemail = new JTextField();
		txtSoLuongNV = new JTextField();
		txtGioHD = new JTextField();
        table.getColumnModel().getColumn(0).setCellEditor((TableCellEditor) new DefaultCellEditor(txtMaCH));
        table.getColumnModel().getColumn(1).setCellEditor((TableCellEditor) new DefaultCellEditor(txtTenCH));
        table.getColumnModel().getColumn(2).setCellEditor((TableCellEditor) new DefaultCellEditor(txtDiaChi));
        table.getColumnModel().getColumn(3).setCellEditor((TableCellEditor) new DefaultCellEditor(txtSDT));
        table.getColumnModel().getColumn(4).setCellEditor((TableCellEditor) new DefaultCellEditor(txtemail));
        table.getColumnModel().getColumn(5).setCellEditor((TableCellEditor) new DefaultCellEditor(txtSoLuongNV));
        table.getColumnModel().getColumn(6).setCellEditor((TableCellEditor) new DefaultCellEditor(txtGioHD));

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(453, 361, 248, 37);
		pMain.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JLabel lblTimKiem = new JLabel("Tìm Kiếm: ");
		lblTimKiem.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTimKiem.setBounds(365, 358, 78, 38);
		pMain.add(lblTimKiem);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setBorder(new TitledBorder(null, "Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pThongTin.setBounds(10, 408, 1142, 227);
		pMain.add(pThongTin);
		pThongTin.setLayout(null);
		
		JLabel lblMaCHTT = new JLabel("Mã Cửa Hàng: ");
		lblMaCHTT.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaCHTT.setBounds(59, 20, 104, 32);
		pThongTin.add(lblMaCHTT);
		
		JLabel lblTenCHTT = new JLabel("Tên Cửa Hàng:");
		lblTenCHTT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTenCHTT.setBounds(59, 70, 104, 32);
		pThongTin.add(lblTenCHTT);
		
		JLabel lblDiaChiTT = new JLabel("Địa Chỉ: ");
		lblDiaChiTT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblDiaChiTT.setBounds(511, 70, 104, 32);
		pThongTin.add(lblDiaChiTT);
		
		txtMaCHTT = new JTextField();
		txtMaCHTT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaCHTT.setBounds(232, 20, 128, 32);
		pThongTin.add(txtMaCHTT);
		txtMaCHTT.setColumns(10);
		
		txtTenCHTT = new JTextField();
		txtTenCHTT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenCHTT.setColumns(10);
		txtTenCHTT.setBounds(232, 70, 128, 32);
		pThongTin.add(txtTenCHTT);
		
		txtDiaChiTT = new JTextField();
		txtDiaChiTT.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		txtDiaChiTT.setColumns(10);
		txtDiaChiTT.setBounds(625, 70, 314, 32);
		pThongTin.add(txtDiaChiTT);
		
		JLabel lblsoLuongNVTT = new JLabel("Số Lượng Nhân Viên:");
		lblsoLuongNVTT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblsoLuongNVTT.setBounds(59, 120, 150, 32);
		pThongTin.add(lblsoLuongNVTT);
		
		txtSoLuongNhanVienTT = new JTextField();
		txtSoLuongNhanVienTT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSoLuongNhanVienTT.setColumns(10);
		txtSoLuongNhanVienTT.setBounds(232, 120, 128, 32);
		pThongTin.add(txtSoLuongNhanVienTT);
		
		JLabel lblEmailTT = new JLabel("Email:");
		lblEmailTT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblEmailTT.setBounds(59, 170, 150, 32);
		pThongTin.add(lblEmailTT);
		
		txtEmailTT = new JTextField();
		txtEmailTT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmailTT.setColumns(10);
		txtEmailTT.setBounds(232, 170, 230, 32);
		pThongTin.add(txtEmailTT);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại:");
		lblSinThoi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblSinThoi.setBounds(511, 120, 109, 32);
		pThongTin.add(lblSinThoi);
		
		txtSDTTT = new JTextField();
		txtSDTTT.setForeground(new Color(0, 0, 0));
		txtSDTTT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSDTTT.setColumns(10);
		txtSDTTT.setBounds(625, 120, 314, 32);
		pThongTin.add(txtSDTTT);
		
		JLabel lblGiHotng = new JLabel("Giờ Hoạt Động");
		lblGiHotng.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblGiHotng.setBounds(511, 170, 109, 32);
		pThongTin.add(lblGiHotng);
		
		txtGioHoatDongTT = new JTextField();
		txtGioHoatDongTT.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txtGioHoatDongTT.setColumns(10);
		txtGioHoatDongTT.setBounds(625, 170, 314, 32);
		pThongTin.add(txtGioHoatDongTT);
        txtMaCHTT.setBorder(BorderFactory.createEmptyBorder());
        txtMaCHTT.setBackground(new Color(240,240,240));
        txtTenCHTT.setBorder(BorderFactory.createEmptyBorder());
        txtTenCHTT.setBackground(new Color(240,240,240));
        txtSDTTT.setBorder(BorderFactory.createEmptyBorder());
        txtSDTTT.setBackground(new Color(240,240,240));
        txtDiaChiTT.setBorder(BorderFactory.createEmptyBorder());
        txtDiaChiTT.setBackground(new Color(240,240,240));
        txtEmailTT.setBorder(BorderFactory.createEmptyBorder());
        txtEmailTT.setBackground(new Color(240,240,240));
        txtGioHoatDongTT.setBorder(BorderFactory.createEmptyBorder());
        txtGioHoatDongTT.setBackground(new Color(240,240,240));
        txtSoLuongNhanVienTT.setBorder(BorderFactory.createEmptyBorder());
        txtSoLuongNhanVienTT.setBackground(new Color(240,240,240));
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
				int row = table.getSelectedRow();
				txtMaCHTT.setText((String) model.getValueAt(row, 0));
				txtTenCHTT.setText((String) model.getValueAt(row, 1));
				txtDiaChiTT.setText((String) model.getValueAt(row, 2));
				txtSDTTT.setText((String) model.getValueAt(row, 3));
				txtEmailTT.setText((String) model.getValueAt(row, 4));
				txtSoLuongNhanVienTT.setText((String) model.getValueAt(row, 5).toString());
				txtGioHoatDongTT.setText((String) model.getValueAt(row, 6));
			}
		});
	}
	public void loadData() {
		for (CuaHang cuaHang : cuaHang_DAO.getAllCuaHang()) {
			
			Object[] object = {cuaHang.getMaCH(),cuaHang.getTenCuaHang(),cuaHang.getDiaChi(),cuaHang.getSoDienThoai(),cuaHang.getEmail(),cuaHang.getSoLuongNV(),cuaHang.getGioHD()};
			
			model.addRow(object);
			
		}
	}
}
