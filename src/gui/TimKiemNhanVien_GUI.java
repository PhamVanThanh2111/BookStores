package gui;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import dao.NhanVien_DAO;
import entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TimKiemNhanVien_GUI extends JInternalFrame {

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
	private JButton btnTim;
	
	/**
	 * Create the frame.
	 */
	public TimKiemNhanVien_GUI(ArrayList<NhanVien> ds) {

		// khai bao DAO
		nhanVien_DAO = new NhanVien_DAO();
		
		this.ds = ds;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 552);
		getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 836, 523);
		getContentPane().add(contentPane);
		
		JLabel lblNewLabel = new JLabel("Mã Nhân Viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(20, 87, 127, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnNhnVin = new JLabel("Tên Nhân Viên:");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnNhnVin.setBounds(20, 167, 127, 40);
		contentPane.add(lblTnNhnVin);
		
		JLabel lblaCh = new JLabel("Địa Chỉ:");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblaCh.setBounds(20, 248, 127, 40);
		contentPane.add(lblaCh);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiiTnh.setBounds(20, 330, 127, 40);
		contentPane.add(lblGiiTnh);
		
		JLabel lblNgySinh = new JLabel("Ngày Sinh:");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgySinh.setBounds(20, 406, 127, 40);
		contentPane.add(lblNgySinh);
		
		JDateChooser dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.setBackground(new Color(255, 255, 255));
		dateChooserNgaySinh.getCalendarButton().setBounds(210, 0, 30, 40);
		dateChooserNgaySinh.getCalendarButton().setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/HeThong/calendar.png")));
		dateChooserNgaySinh.getCalendarButton().setBorder(null);
		dateChooserNgaySinh.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		dateChooserNgaySinh.getCalendarButton().setBackground(new Color(255, 255, 255));
		dateChooserNgaySinh.setToolTipText("Ngày sinh");
		dateChooserNgaySinh.setBounds(155, 406, 238, 40);
		dateChooserNgaySinh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateChooserNgaySinh.setFont(new Font("SansSerif", Font.BOLD, 18));
		dateChooserNgaySinh.setBorder(null);
		dateChooserNgaySinh.getDateEditor().setEnabled(false);
		contentPane.add(dateChooserNgaySinh);
		
		JLabel lblCccd = new JLabel("CCCD:");
		lblCccd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCccd.setBounds(422, 87, 127, 40);
		contentPane.add(lblCccd);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(422, 167, 127, 40);
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
		txtMaNhanVien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(157, 87, 238, 40);
		contentPane.add(txtMaNhanVien);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(157, 167, 238, 40);
		contentPane.add(txtTenNhanVien);
		
		txtDiaChi = new JTextField();
		txtDiaChi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(157, 248, 238, 40);
		contentPane.add(txtDiaChi);
		
		txtCCCD = new JTextField();
		txtCCCD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(572, 87, 238, 40);
		contentPane.add(txtCCCD);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		txtEmail.setColumns(10);
		txtEmail.setBounds(572, 167, 238, 40);
		contentPane.add(txtEmail);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(572, 248, 238, 40);
		contentPane.add(txtSoDienThoai);
		
		btnTim = new JButton("Tìm");
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
		btnTim.setBounds(691, 465, 135, 40);
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
		btnquayLai.setBounds(10, 10, 135, 40);
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
		for (NhanVien nhanVien : nhanVien_DAO.getAllListNhanVien()) {
			boolean thoaMan = false;
			if (!txtMaNhanVien.getText().isEmpty()) {
				if (nhanVien.getMaNhanVien().equalsIgnoreCase(txtMaNhanVien.getText().trim())) {
					thoaMan = true;
				}
			}
			if (!txtTenNhanVien.getText().isEmpty()) {
				if (nhanVien.getTenNhanVien().toLowerCase().contains(txtTenNhanVien.getText().toLowerCase().trim())) {
					thoaMan = true;
				}
			}
			if (!txtDiaChi.getText().isEmpty()) {
				if (nhanVien.getDiaChi().toLowerCase().contains(txtDiaChi.getText().toLowerCase().trim())) {
					thoaMan = true;
				}
			}
			if (!txtCCCD.getText().isEmpty()) {
				if (nhanVien.getcCCD().toLowerCase().contains(txtCCCD.getText().toLowerCase().trim())) {
					thoaMan = true;
				}
			}
			if (!txtEmail.getText().isEmpty()) {
				if (nhanVien.getEmail().toLowerCase().contains(txtEmail.getText().toLowerCase().trim())) {
					thoaMan = true;
				}
			}
			if (!txtSoDienThoai.getText().isEmpty()) {
				if (nhanVien.getSoDienThoai().toLowerCase().contains(txtSoDienThoai.getText().toLowerCase().trim())) {
					thoaMan = true;
				}
			}
			if (cmbChucVu.getSelectedIndex() != -1) {
				if (nhanVien.getChucVu().toLowerCase().contains(cmbChucVu.getSelectedItem().toString().toLowerCase().trim())) {
					thoaMan = true;
				}
			}
			if (cmbGioiTinh.getSelectedIndex() != -1) {
				if (nhanVien.getGioiTinh().toLowerCase().contains(cmbGioiTinh.getSelectedItem().toString().toLowerCase().trim())) {
					thoaMan = true;
				}
			}
			if (cmbCa.getSelectedIndex() != -1) {
				if (nhanVien.getMaCa().toLowerCase().contains("C" + cmbCa.getSelectedItem().toString().toLowerCase().trim())) {
					thoaMan = true;
				}
			}
			
			if (thoaMan) {
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
