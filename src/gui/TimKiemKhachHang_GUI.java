package gui;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JTextField;

import dao.KhachHang_DAO;
import entity.KhachHang;

import javax.swing.JLabel;
import javax.swing.JComboBox;

public class TimKiemKhachHang_GUI extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private ArrayList<KhachHang> ds;
	private JComboBox<String> cbGioiTinh;
	private KhachHang_DAO khachHang_DAO;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TimKiemKhachHang_GUI(ArrayList<KhachHang> ds) {
		khachHang_DAO = new KhachHang_DAO();
		this.ds = ds;
		setBounds(100, 100, 910, 350);
		getContentPane().setLayout(null);
		
		JButton btnquayLai = new JButton("← Quay Lại");
		btnquayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnquayLai)) {
					loadAll();
					try {
						setClosed(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnquayLai.setForeground(Color.WHITE);
		btnquayLai.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnquayLai.setBackground(new Color(73, 129, 158));
		btnquayLai.setBounds(10, 10, 135, 40);
		getContentPane().add(btnquayLai);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(220, 80, 240, 40);
		getContentPane().add(txtMaKH);
		
		JLabel lblMaKH = new JLabel("Mã Khách Hàng:");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaKH.setBounds(70, 80, 140, 40);
		getContentPane().add(lblMaKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(220, 140, 240, 40);
		getContentPane().add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(600, 140, 240, 40);
		getContentPane().add(txtSDT);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenKH.setBounds(70, 140, 161, 40);
		getContentPane().add(lblTenKH);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSDT.setBounds(520, 140, 135, 40);
		getContentPane().add(lblSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(600, 200, 240, 40);
		getContentPane().add(txtDiaChi);
		
		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setSelectedIndex(-1);
		cbGioiTinh.setBounds(220, 200, 240, 40);
		getContentPane().add(cbGioiTinh);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGioiTinh.setBounds(70, 200, 127, 40);
		getContentPane().add(lblGioiTinh);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(750, 270, 135, 40);
		btnTim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchKhachHang();
				try {
					setClosed(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnTim);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiaChi.setBounds(520, 200, 74, 40);
		getContentPane().add(lblDiaChi);

	}
	public void searchKhachHang() {
		for (KhachHang khachHang: khachHang_DAO.getAllKhachHang()) {
			boolean thoaMan = false;
			if (!txtMaKH.getText().isEmpty()) {
				if (khachHang.getMaKhachHang().equalsIgnoreCase(txtMaKH.getText())) {
					thoaMan = true;
				}
			}
			if (!txtTenKH.getText().isEmpty()) {
				if (khachHang.getTenKhachHang().toLowerCase().contains(txtTenKH.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (!txtDiaChi.getText().isEmpty()) {
				if (khachHang.getDiaChi().toLowerCase().contains(txtDiaChi.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (!txtSDT.getText().isEmpty()) {
				if (khachHang.getSoDienThoai().toLowerCase().contains(txtSDT.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (cbGioiTinh.getSelectedIndex()!=-1) {
				if (khachHang.getGioiTinh().toLowerCase().contains(cbGioiTinh.getSelectedItem().toString().toLowerCase())) {
					thoaMan = true;
				}
			
			}
			if (thoaMan) {
				ds.add(khachHang);
			}
		}
	}
	public void loadAll() {
		for(KhachHang khachHang: khachHang_DAO.getAllKhachHang()) {
			ds.add(khachHang);
		}
	}
}
