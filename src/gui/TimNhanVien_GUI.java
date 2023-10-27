package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhanVien_DAO;
import entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class TimNhanVien_GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JTextField txtDiaChi;
	private JTextField txtCCCD;
	private JTextField txtEmail;
	private JTextField txtSoDienThoai;
	private JComboBox<String> cmbChucVu;
	private JComboBox<String> cmbCa;
	private JComboBox<String> cmbGioiTinh;
	private NhanVien_DAO nhanVien_DAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimNhanVien_GUI frame = new TimNhanVien_GUI();
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
	public TimNhanVien_GUI() {
		
		// khai bao DAO
		nhanVien_DAO = new NhanVien_DAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 560);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Nhân Viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(20, 33, 127, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnNhnVin = new JLabel("Tên Nhân Viên:");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnNhnVin.setBounds(20, 124, 127, 40);
		contentPane.add(lblTnNhnVin);
		
		JLabel lblaCh = new JLabel("Địa Chỉ:");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblaCh.setBounds(20, 205, 127, 40);
		contentPane.add(lblaCh);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiiTnh.setBounds(20, 291, 127, 40);
		contentPane.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ngày Sinh:");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgySinh.setBounds(20, 367, 127, 40);
		contentPane.add(lblNgySinh);
		
		JLabel lblCccd = new JLabel("CCCD:");
		lblCccd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCccd.setBounds(422, 33, 127, 40);
		contentPane.add(lblCccd);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(422, 113, 127, 40);
		contentPane.add(lblEmail);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSinThoi.setBounds(422, 205, 127, 40);
		contentPane.add(lblSinThoi);
		
		JLabel lblChcV = new JLabel("Chức Vụ:");
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChcV.setBounds(422, 291, 127, 40);
		contentPane.add(lblChcV);
		
		JLabel lblTiK = new JLabel("Ca:");
		lblTiK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTiK.setBounds(422, 367, 127, 40);
		contentPane.add(lblTiK);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBounds(157, 33, 238, 40);
		contentPane.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(157, 124, 238, 40);
		contentPane.add(txtTenNhanVien);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(157, 205, 238, 40);
		contentPane.add(txtDiaChi);
		
		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(572, 33, 238, 40);
		contentPane.add(txtCCCD);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(572, 113, 238, 40);
		contentPane.add(txtEmail);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(572, 205, 238, 40);
		contentPane.add(txtSoDienThoai);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(675, 456, 135, 40);
		btnTim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (kiemTraDuLieu()) {
					searchNhanVien();
					setVisible(false);
				}	
			}
		});
		contentPane.add(btnTim);
		
		cmbChucVu = new JComboBox<String>();
		cmbChucVu.setBounds(572, 291, 238, 40);
		contentPane.add(cmbChucVu);
		
		cmbCa = new JComboBox<String>();
		cmbCa.setBounds(572, 367, 238, 40);
		contentPane.add(cmbCa);
		
		cmbGioiTinh = new JComboBox<String>();
		cmbGioiTinh.setBounds(157, 291, 238, 40);
		contentPane.add(cmbGioiTinh);
	}
	
	public boolean kiemTraDuLieu() {
		if (txtMaNhanVien.getText().equals("") && 
				txtTenNhanVien.getText().equals("") && 
				txtDiaChi.getText().equals("") &&
				txtCCCD.getText().equals("") &&
				txtEmail.getText().equals("") &&
				txtSoDienThoai.getText().equals("") &&
				cmbChucVu.getSelectedIndex() == -1 &&
				cmbCa.getSelectedIndex() == -1 &&
				cmbGioiTinh.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn phải điền ít nhất một thông tin!");
			return false;
		}
		return true;
	}
	
	public ArrayList<NhanVien> searchNhanVien() {  
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		for (NhanVien nhanVien : nhanVien_DAO.getAllListNhanVien()) {
			if (nhanVien.getMaNhanVien().equalsIgnoreCase(txtMaNhanVien.getText()) ||
			nhanVien.getTenNhanVien().equalsIgnoreCase(txtTenNhanVien.getText()) ||
			nhanVien.getDiaChi().equalsIgnoreCase(txtDiaChi.getText()) ||
			nhanVien.getcCCD().equalsIgnoreCase(txtCCCD.getText()) ||
			nhanVien.getEmail().equalsIgnoreCase(txtEmail.getText()) ||
			nhanVien.getSoDienThoai().equalsIgnoreCase(txtSoDienThoai.getText()) ||
			nhanVien.getChucVu().equalsIgnoreCase(cmbChucVu.getSelectedItem().toString()) ||
			nhanVien.getMaCa().equalsIgnoreCase("C" + cmbCa.getSelectedItem()) ||
			nhanVien.getGioiTinh().equalsIgnoreCase(cmbGioiTinh.getSelectedItem().toString()))
				ds.add(nhanVien);
		}
		return ds;
	}
}
