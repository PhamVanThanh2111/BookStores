package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.Date;

import javax.swing.SwingConstants;
import javax.swing.JTable;

public class NhanVien_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTim;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JDateChooser chooserNgaySinh;
	private Date dNgayHienTai;
	private JTextField txtCCCD;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien_GUI frame = new NhanVien_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhanVien_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1256, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTim = new JLabel("Tìm kiếm");
		lblTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTim.setBounds(328, 22, 92, 27);
		contentPane.add(lblTim);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTim.setBounds(430, 22, 321, 27);
		contentPane.add(txtTim);
		txtTim.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBounds(849, 22, 85, 27);
		contentPane.add(btnTim);
		
		JComboBox<String> cbTim = new JComboBox<String>();
		cbTim.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbTim.setBounds(761, 22, 79, 27);
		cbTim.addItem("Tên nhân viên");
		cbTim.addItem("Mã nhân viên");
		cbTim.addItem("CCCD");
		cbTim.addItem("Số điện thoại");
		contentPane.add(cbTim);
		
		JLabel lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMaNV.setBounds(79, 73, 112, 27);
		contentPane.add(lblMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMaNV.setBounds(201, 73, 119, 27);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblTenNV = new JLabel("Tên NV:");
		lblTenNV.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTenNV.setBounds(79, 117, 112, 27);
		contentPane.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(201, 117, 119, 27);
		contentPane.add(txtTenNV);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDiaChi.setBounds(79, 160, 112, 27);
		contentPane.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(201, 160, 219, 27);
		contentPane.add(txtDiaChi);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBounds(571, 117, 119, 27);
		contentPane.add(txtSDT);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSinThoi.setBounds(449, 117, 112, 27);
		contentPane.add(lblSinThoi);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNgaySinh.setBounds(449, 73, 112, 27);
		contentPane.add(lblNgaySinh);
		java.util.Date date = new java.util.Date();
		dNgayHienTai = new Date(date.getTime());
		chooserNgaySinh = new JDateChooser();
		chooserNgaySinh.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chooserNgaySinh.setBounds(570, 73, 191, 27);
		chooserNgaySinh.setDateFormatString("dd/MM/yyyy");
		chooserNgaySinh.setDate(dNgayHienTai);
		chooserNgaySinh.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
		chooserNgaySinh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		chooserNgaySinh.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		chooserNgaySinh.getCalendarButton().setBackground(new Color(102, 0, 153));
		chooserNgaySinh.getCalendarButton().setToolTipText("Chọn ngày sinh");
		contentPane.add(chooserNgaySinh);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGioiTinh.setBounds(449, 160, 112, 27);
		contentPane.add(lblGioiTinh);
		
		JComboBox<String> cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbGioiTinh.setBounds(571, 160, 119, 27);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		contentPane.add(cbGioiTinh);
		
		JLabel lblCCCD = new JLabel("CCCD:");
		lblCCCD.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCCCD.setBounds(849, 73, 112, 27);
		contentPane.add(lblCCCD);
		
		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(971, 73, 119, 27);
		contentPane.add(txtCCCD);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmail.setBounds(849, 117, 112, 27);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(971, 117, 211, 27);
		contentPane.add(txtEmail);
		
		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblChucVu.setBounds(849, 160, 112, 27);
		contentPane.add(lblChucVu);
		
		JComboBox<String> cbChucVu = new JComboBox<String>();
		cbChucVu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cbChucVu.setBounds(971, 160, 119, 27);
		contentPane.add(cbChucVu);
		
		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setBounds(0, 66, 1242, 182);
		contentPane.add(pNhapThongTin);
	}
}
