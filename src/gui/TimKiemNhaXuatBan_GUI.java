package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.NhaXuatBan_DAO;
import entity.NhaXuatBan;

public class TimKiemNhaXuatBan_GUI extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaNhaXuatBan;
	private JTextField txtTenNhaXuatBan;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtEmail;
	private NhaXuatBan_DAO nhaXuatBan_DAO;
	private ArrayList<NhaXuatBan> ds;

	private JButton btnTim;
	/**
	 * Create the frame.
	 */

	public TimKiemNhaXuatBan_GUI(ArrayList<NhaXuatBan> ds) {

		// khai bao DAO
		nhaXuatBan_DAO = new NhaXuatBan_DAO();
		this.ds = ds;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 398);
		getContentPane().setLayout(null);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 833, 405);
		getContentPane().add(contentPane);

		JLabel lblMaNhaXuatBan = new JLabel("Mã NXB:");
		lblMaNhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaNhaXuatBan.setBounds(20, 87, 127, 40);
		contentPane.add(lblMaNhaXuatBan);

		JLabel lblTenNhaXuatBan = new JLabel("Tên NXB:");
		lblTenNhaXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenNhaXuatBan.setBounds(20, 167, 127, 40);
		contentPane.add(lblTenNhaXuatBan);

		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiaChi.setBounds(20, 248, 127, 40);
		contentPane.add(lblDiaChi);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(435, 87, 127, 40);
		contentPane.add(lblEmail);

		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoDienThoai.setBounds(435, 164, 127, 40);
		contentPane.add(lblSoDienThoai);

		txtMaNhaXuatBan = new JTextField();
		txtMaNhaXuatBan.setColumns(10);
		txtMaNhaXuatBan.setBounds(157, 87, 238, 40);
		txtMaNhaXuatBan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		contentPane.add(txtMaNhaXuatBan);

		txtTenNhaXuatBan = new JTextField();
		txtTenNhaXuatBan.setColumns(10);
		txtTenNhaXuatBan.setBounds(157, 167, 238, 40);
		txtTenNhaXuatBan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		contentPane.add(txtTenNhaXuatBan);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(157, 248, 238, 40);
		txtDiaChi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		contentPane.add(txtDiaChi);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(585, 87, 238, 40);
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		contentPane.add(txtEmail);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(585, 168, 238, 40);
		txtSoDienThoai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnTim.doClick();
				}
			}
		});
		contentPane.add(txtSoDienThoai);

		

		JButton btnQuayLai = new JButton("← Quay Lại");
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setMnemonic(KeyEvent.VK_ENTER);
		btnQuayLai.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnQuayLai.setBackground(new Color(73, 129, 158));
		btnQuayLai.setBounds(10, 10, 135, 40);
		btnQuayLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadAll();
				try {
					setClosed(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnQuayLai);
		btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!duLieuRong()) {
					searchNhaXuatBan();
					try {
						setClosed(true);
					} catch (PropertyVetoException e1) {
						e1.printStackTrace();
					}
				}
			}

		});
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(688, 259, 135, 40);
		contentPane.add(btnTim);
	}
	private void searchNhaXuatBan() {
		// TODO Auto-generated method stub
		for (NhaXuatBan nhaXuatBan : nhaXuatBan_DAO.getAllNhaXuatBan()) {
			boolean thoaMan = false;
			if (!txtMaNhaXuatBan.getText().isEmpty()) {
				if (nhaXuatBan.getMaNhaXuatBan().equalsIgnoreCase(txtMaNhaXuatBan.getText().trim())) {
					thoaMan = true;
				}
			}
			if (!txtTenNhaXuatBan.getText().isEmpty()) {
				if (nhaXuatBan.getTenNhaXuatBan().toLowerCase()
						.contains(txtTenNhaXuatBan.getText().toLowerCase().trim())) {
					thoaMan = true;
				}
			}
			if (!txtDiaChi.getText().isEmpty()) {
				if (nhaXuatBan.getDiaChi().toLowerCase().contains(txtDiaChi.getText().toLowerCase().trim())) {
					thoaMan = true;
				}
			}

			if (!txtEmail.getText().isEmpty()) {
				if (nhaXuatBan.getEmail().toLowerCase().contains(txtEmail.getText().toLowerCase().trim())) {
					thoaMan = true;
				}
			}
			if (!txtSoDienThoai.getText().isEmpty()) {
				if (nhaXuatBan.getSoDienThoai().toLowerCase()
						.contains(txtSoDienThoai.getText().toLowerCase().trim())) {
					thoaMan = true;
				}
			}

			if (thoaMan) {
				ds.add(nhaXuatBan);
			}
		}
	}

	private boolean duLieuRong() {
		// TODO Auto-generated method stub
		if (txtMaNhaXuatBan.getText().equals("") && txtTenNhaXuatBan.getText().equals("")
				&& txtDiaChi.getText().equals("") && txtEmail.getText().equals("")
				&& txtSoDienThoai.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải điền ít nhất một thông tin!");
			return true;
		}
		return false;
	}
	public void loadAll() {
		for (NhaXuatBan nhaXuatBan : nhaXuatBan_DAO.getAllNhaXuatBan()) {
			ds.add(nhaXuatBan);
		}
	}	

}
