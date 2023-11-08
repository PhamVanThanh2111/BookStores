package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.NhaCungCap_DAO;
import entity.KhachHang;
import entity.NhaCungCap;

import javax.swing.JComboBox;

public class TimKiemNhaCungCap extends JInternalFrame {
	private JTextField txtMaNhaCungCap;
	private JTextField txtTenNhaCungCap;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private NhaCungCap_DAO nhaCungCap_Dao;
	private ArrayList<NhaCungCap> ds;
	
	public TimKiemNhaCungCap(ArrayList<NhaCungCap>ds) {
		nhaCungCap_Dao=new NhaCungCap_DAO();
		this.ds = ds;
		setBounds(100, 100, 910, 350);
		getContentPane().setLayout(null);
		
		JButton btnquayLai = new JButton("← Quay Lại");
		btnquayLai.setBounds(10, 10, 135, 40);
		btnquayLai.setForeground(Color.WHITE);
		btnquayLai.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnquayLai.setBackground(new Color(73, 129, 158));
		getContentPane().add(btnquayLai);
		
		JLabel lblMaNCC = new JLabel("Mã Nhà Cung Cấp:");
		lblMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaNCC.setBounds(70, 80, 161, 40);
		getContentPane().add(lblMaNCC);
		
		txtMaNhaCungCap = new JTextField();
		txtMaNhaCungCap.setColumns(10);
		txtMaNhaCungCap.setBounds(230, 80, 240, 40);
		getContentPane().add(txtMaNhaCungCap);
		
		txtTenNhaCungCap = new JTextField();
		txtTenNhaCungCap.setColumns(10);
		txtTenNhaCungCap.setBounds(230, 140, 240, 40);
		getContentPane().add(txtTenNhaCungCap);
		
		JLabel lblTenNhaCungCap = new JLabel("Tên Nhà Cung Cấp:");
		lblTenNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenNhaCungCap.setBounds(70, 140, 161, 40);
		getContentPane().add(lblTenNhaCungCap);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(70, 200, 127, 40);
		getContentPane().add(lblEmail);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiaChi.setBounds(520, 200, 74, 40);
		getContentPane().add(lblDiaChi);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSDT.setBounds(520, 140, 135, 40);
		getContentPane().add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(600, 140, 240, 40);
		getContentPane().add(txtSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(600, 200, 240, 40);
		getContentPane().add(txtDiaChi);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(750, 270, 135, 40);
		getContentPane().add(btnTim);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(230, 200, 240, 40);
		getContentPane().add(txtEmail);
		
		btnTim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchNhaCungCap();
				try {
					setClosed(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnquayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnquayLai)) {
					loadALL();
					try {
						setClosed(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	public void searchNhaCungCap() {
		for (NhaCungCap nhacc: nhaCungCap_Dao.getAllNhaCungCap()) {
			boolean thoaMan = false;
			if (!txtMaNhaCungCap.getText().isEmpty()) {
				if (nhacc.getMaNCC().equalsIgnoreCase(txtMaNhaCungCap.getText())) {
					thoaMan = true;
				}
			}
			if (!txtTenNhaCungCap.getText().isEmpty()) {
				if (nhacc.getTenNCC().toLowerCase().contains(txtTenNhaCungCap.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (!txtDiaChi.getText().isEmpty()) {
				if (nhacc.getDiaChi().toLowerCase().contains(txtDiaChi.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (!txtSDT.getText().isEmpty()) {
				if (nhacc.getSoDienThoai().toLowerCase().contains(txtSDT.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (!txtEmail.getText().isEmpty()) {
				if (nhacc.getEmail().toLowerCase().contains(txtEmail.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (thoaMan) {
				ds.add(nhacc);
			}
		}
	}
	
	public void loadALL() {
		for(NhaCungCap nhaCC : nhaCungCap_Dao.getAllNhaCungCap()) {
			ds.add(nhaCC);
		}
	}
	
}
