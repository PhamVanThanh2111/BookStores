package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.NhaCungCap_DAO;
import dao.SanPham_DAO;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.SanPham;

import javax.swing.JComboBox;

public class TimKiemDungCuHoctap extends JInternalFrame {
	private JTextField txtMaDCHT;
	private JTextField txtTenDCHT;
	private JTextField txtGiaBan;
	private JTextField txtSoLuong;
	private ArrayList<SanPham> ds;
	private SanPham_DAO sanPham_DAO;
	private JComboBox<String> cbNhaCC;
	private NhaCungCap_DAO nhaCungCap_DAO;
	/**
	 * Launch the application.
	 */

	public TimKiemDungCuHoctap(ArrayList<SanPham> ds) {
		this.ds=ds;
		SanPham_DAO sanPham_DAO = new SanPham_DAO(); 
		nhaCungCap_DAO = new NhaCungCap_DAO();
		setBounds(100, 100, 922, 415);
		getContentPane().setLayout(null);
		
		txtMaDCHT = new JTextField();
		txtMaDCHT.setColumns(10);
		txtMaDCHT.setBounds(220, 80, 240, 40);
		getContentPane().add(txtMaDCHT);
		
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
			}
		});
		getContentPane().add(btnquayLai);
		
		JLabel lblMaDCHT = new JLabel("Mã DCHT:");
		lblMaDCHT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaDCHT.setBounds(70, 80, 140, 40);
		getContentPane().add(lblMaDCHT);
		
		JLabel lblTnDcht = new JLabel("Tên DCHT:");
		lblTnDcht.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnDcht.setBounds(70, 140, 161, 40);
		getContentPane().add(lblTnDcht);
		
		txtTenDCHT = new JTextField();
		txtTenDCHT.setColumns(10);
		txtTenDCHT.setBounds(220, 140, 240, 40);
		getContentPane().add(txtTenDCHT);
		
		cbNhaCC = new JComboBox<String>();
		cbNhaCC.setSelectedIndex(-1);
		cbNhaCC.setBounds(220, 200, 240, 40);
		getContentPane().add(cbNhaCC);
		
		JLabel lblNhaCungCap = new JLabel("Nhà Cung Cấp:");
		lblNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNhaCungCap.setBounds(70, 200, 127, 40);
		getContentPane().add(lblNhaCungCap);
		
		JLabel lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoLuong.setBounds(520, 200, 83, 40);
		getContentPane().add(lblSoLuong);
		
		JLabel lblGiaBan = new JLabel("Giá Bán:");
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiaBan.setBounds(520, 140, 105, 40);
		getContentPane().add(lblGiaBan);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(610, 140, 240, 40);
		getContentPane().add(txtGiaBan);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(610, 200, 240, 40);
		getContentPane().add(txtSoLuong);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(750, 270, 135, 40);
		
		getContentPane().add(btnTim);
		
	}
	
	public void searchKhachHang() {
		for (SanPham sanPham: sanPham_DAO.getAllDungCuHocTap()) {
			boolean thoaMan = false;
			if (!txtMaDCHT.getText().isEmpty()) {
				if (sanPham.getMaSanPham().equalsIgnoreCase(txtMaDCHT.getText())) {
					thoaMan = true;
				}
			}
			if (!txtTenDCHT.getText().isEmpty()) {
				if (sanPham.getTenSanPham().toLowerCase().contains(txtTenDCHT.getText().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (!txtGiaBan.getText().isEmpty()) {
				if (sanPham.getGiaBan()==Integer.parseInt(txtGiaBan.getText())) {
					thoaMan = true;
				}
			}
			if (!txtSoLuong.getText().isEmpty()) {
				if (sanPham.getSoLuongTon()==Integer.parseInt(txtSoLuong.getText())) {
					thoaMan = true;
				}
			}
			NhaCungCap tenNhaCC= nhaCungCap_DAO.getNhaCCTheoMa(sanPham.getMaNhaCungCap().toString());
			
			if (cbNhaCC.getSelectedIndex()!=-1) {
				if (tenNhaCC.getTenNCC().toLowerCase().contains(cbNhaCC.getSelectedItem().toString().toLowerCase())) {
					thoaMan = true;
				}
			}
			if (thoaMan) {
				ds.add(sanPham);
			}
		}
	}
	
	public void loadAll() {
		for (SanPham sanPham: sanPham_DAO.getAllDungCuHocTap()) {
			ds.add(sanPham);
		}
	}
}
