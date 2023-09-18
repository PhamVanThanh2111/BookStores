package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.CuaHang_DAO;
import entity.CuaHang;

import javax.swing.border.EtchedBorder;

import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuaHang_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTableHeader tableHeader;
	private JTextField txtTenCH;
	private CuaHang_DAO cuaHang_DAO;
	private JTextField txtTimKiem;
	private JTextField txtMaCH;
	private JTextField textField;
	private JTextField txtDiaChi;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		String cols[] = { "Mã CH", "Tên CH", "Địa Chỉ", "Số Điện Thoại", "Email", "Số Lượng NV", "Giờ Hoạt Động" };
		model = new DefaultTableModel(cols, 0);
		


		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 53, 1142, 219);
		pMain.add(panel);
		panel.setLayout(null);
		
		JLabel lblMaCH = new JLabel("Mã CH:");
		lblMaCH.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaCH.setBounds(39, 30, 90, 33);
		panel.add(lblMaCH);
		
		JLabel lblTenCH = new JLabel("Tên CH:");
		lblTenCH.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenCH.setBounds(40, 70, 90, 33);
		panel.add(lblTenCH);
		
		txtMaCH = new JTextField();
		txtMaCH.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaCH.setBounds(120, 30, 160, 33);
		panel.add(txtMaCH);
		txtMaCH.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(120, 70, 360, 33);
		panel.add(textField);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDiaChi.setBounds(39, 110, 90, 33);
		panel.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(120, 110, 360, 33);
		panel.add(txtDiaChi);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblemail.setBounds(529, 30, 90, 33);
		panel.add(lblemail);
		
		JLabel lblSDT = new JLabel("SĐT:");
		lblSDT.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSDT.setBounds(529, 70, 90, 33);
		panel.add(lblSDT);
		
		JLabel lblGioHD = new JLabel("Giờ HĐ:");
		lblGioHD.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGioHD.setBounds(529, 110, 90, 33);
		panel.add(lblGioHD);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(607, 30, 300, 33);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(607, 70, 300, 33);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(607, 110, 300, 33);
		panel.add(textField_3);
		
		JLabel lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSoLuong.setBounds(939, 110, 90, 33);
		panel.add(lblSoLuong);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("SansSerif", Font.BOLD, 14));
		textField_4.setBounds(1023, 110, 40, 33);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(140, 165, 108, 33);
		panel.add(btnAdd);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(390, 165, 108, 33);
		panel.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(640, 165, 108, 33);
		panel.add(btnSua);
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaTrang.setBounds(890, 165, 108, 33);
		panel.add(btnXoaTrang);
		
				JLabel lblTimKiem = new JLabel("Tìm Kiếm");
				lblTimKiem.setBounds(270, 10, 96, 33);
				pMain.add(lblTimKiem);
				lblTimKiem.setFont(new Font("SansSerif", Font.BOLD, 14));
				
						txtTimKiem = new JTextField();
						txtTimKiem.setBounds(375, 10, 255, 33);
						pMain.add(txtTimKiem);
						txtTimKiem.setColumns(10);
						
						JComboBox comboBox = new JComboBox();
						comboBox.setBounds(640, 10, 95, 33);
						pMain.add(comboBox);
						
						JButton btnTim = new JButton("Tìm");
						btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
						btnTim.setBounds(745, 10, 95, 33);
						pMain.add(btnTim);

		loadData();
	}

	public void loadData() {
		for (CuaHang cuaHang : cuaHang_DAO.getAllCuaHang()) {

			Object[] object = { cuaHang.getMaCH(), cuaHang.getTenCuaHang(), cuaHang.getDiaChi(),
					cuaHang.getSoDienThoai(), cuaHang.getEmail(), cuaHang.getSoLuongNV(), cuaHang.getGioHD() };

			model.addRow(object);
		

		}
	}
}
