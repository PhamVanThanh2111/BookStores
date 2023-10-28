package gui;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhanVien_DAO;
import entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TimNhanVien_GUI extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JTextField txtDiaChi;
	private JTextField txtCCCD;
	private JTextField txtEmail;
	private JTextField txtSoDienThoai;
	private JComboBox<String> cmbChucVu;
	private JComboBox<String> cmbCa;
	private JComboBox<String> cmbGioiTinh;
	private ArrayList<NhanVien> ds;
	private NhanVien_DAO nhanVien_DAO;
	
	/**
	 * Create the frame.
	 */
	public TimNhanVien_GUI(ArrayList<NhanVien> ds) {

		// khai bao DAO
		nhanVien_DAO = new NhanVien_DAO();
		
		this.ds = ds;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 549);
		getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 836, 523);
		getContentPane().add(contentPane);
		
		JLabel lblNewLabel = new JLabel("Mã Nhân Viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(20, 72, 127, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnNhnVin = new JLabel("Tên Nhân Viên:");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnNhnVin.setBounds(20, 163, 127, 40);
		contentPane.add(lblTnNhnVin);
		
		JLabel lblaCh = new JLabel("Địa Chỉ:");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblaCh.setBounds(20, 244, 127, 40);
		contentPane.add(lblaCh);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiiTnh.setBounds(20, 330, 127, 40);
		contentPane.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ngày Sinh:");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgySinh.setBounds(20, 406, 127, 40);
		contentPane.add(lblNgySinh);
		
		JLabel lblCccd = new JLabel("CCCD:");
		lblCccd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCccd.setBounds(422, 72, 127, 40);
		contentPane.add(lblCccd);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(422, 152, 127, 40);
		contentPane.add(lblEmail);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSinThoi.setBounds(422, 244, 127, 40);
		contentPane.add(lblSinThoi);
		
		JLabel lblChcV = new JLabel("Chức Vụ:");
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChcV.setBounds(422, 330, 127, 40);
		contentPane.add(lblChcV);
		
		JLabel lblTiK = new JLabel("Ca:");
		lblTiK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTiK.setBounds(422, 406, 127, 40);
		contentPane.add(lblTiK);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(157, 72, 238, 40);
		contentPane.add(txtMaNhanVien);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(157, 163, 238, 40);
		contentPane.add(txtTenNhanVien);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(157, 244, 238, 40);
		contentPane.add(txtDiaChi);
		
		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(572, 72, 238, 40);
		contentPane.add(txtCCCD);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(572, 152, 238, 40);
		contentPane.add(txtEmail);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(572, 244, 238, 40);
		contentPane.add(txtSoDienThoai);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!duLieuRong()) {
					searchNhanVien();
					try {
						setClosed(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(675, 456, 135, 40);
		contentPane.add(btnTim);
		
		cmbChucVu = new JComboBox<String>();
		cmbChucVu.setBounds(572, 330, 238, 40);
		cmbChucVu.addItem("Bán hàng");
		cmbChucVu.addItem("Quản lý");
		cmbChucVu.setSelectedIndex(-1);
		contentPane.add(cmbChucVu);
		
		cmbCa = new JComboBox<String>();
		cmbCa.setBounds(572, 406, 238, 40);
		cmbCa.addItem("01");
		cmbCa.addItem("02");
		cmbCa.setSelectedIndex(-1);
		contentPane.add(cmbCa);
		
		cmbGioiTinh = new JComboBox<String>();
		cmbGioiTinh.setBounds(157, 330, 238, 40);
		cmbGioiTinh.addItem("Nam");
		cmbGioiTinh.addItem("Nữ");
		cmbGioiTinh.setSelectedIndex(-1);
		contentPane.add(cmbGioiTinh);
		
		JButton btnquayLai = new JButton("← Quay Lại");
		btnquayLai.setForeground(Color.WHITE);
		btnquayLai.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnquayLai.setBackground(new Color(73, 129, 158));
		btnquayLai.setBounds(20, 21, 135, 40);
		btnquayLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadAll();
				try {
					setClosed(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnquayLai);
	}

	private boolean duLieuRong() {
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
			return true;
		}
		return false;
	}
	
	public void searchNhanVien() {
		String gioiTinh = "";
		String chucVu = "";
		String ca = "";
		if (cmbGioiTinh.getSelectedIndex() != -1) {
			gioiTinh = cmbGioiTinh.getSelectedItem().toString();
		}
		if (cmbChucVu.getSelectedIndex() != -1) {
			chucVu = cmbChucVu.getSelectedItem().toString();
		}
		if (cmbCa.getSelectedIndex() != -1) {
			ca = cmbCa.getSelectedItem().toString();
		}
		for (NhanVien nhanVien : nhanVien_DAO.getAllListNhanVien()) {
			if (
					nhanVien.getMaNhanVien().equalsIgnoreCase(txtMaNhanVien.getText()) ||
					nhanVien.getTenNhanVien().contains(txtTenNhanVien.getText()) ||
					nhanVien.getDiaChi().contains(txtDiaChi.getText()) ||
					nhanVien.getcCCD().contains(txtCCCD.getText()) ||
					nhanVien.getEmail().contains(txtEmail.getText()) ||
					nhanVien.getSoDienThoai().contains(txtSoDienThoai.getText()) ||
					nhanVien.getGioiTinh().equalsIgnoreCase(gioiTinh) ||
					nhanVien.getChucVu().equalsIgnoreCase(chucVu) ||
					nhanVien.getMaCa().equalsIgnoreCase("C" + ca)) {
				ds.add(nhanVien);
			}	
		}
	}
	
	public void loadAll() {
		for (NhanVien nhanVien : nhanVien_DAO.getAllListNhanVien()) {
			ds.add(nhanVien);	
		}
	}
}
