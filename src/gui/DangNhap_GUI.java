package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import connect.ConnectDB;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
//import dao.TaiKhoan_DAO;
import entity.TaiKhoan;
import java.awt.event.KeyAdapter;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class DangNhap_GUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblUser;
	private JLabel lblPwd;
	private JPasswordField txtPwd;
	private JButton btnExit;
	private JButton btnLogin;
	private TaiKhoan_DAO taiKhoan_DAO;
	private NhanVien_DAO nhanVien_DAO;
	private JTextField txtUser;
	private int countSaiMatKhau = 0;
	private JCheckBox chkShow;

	public DangNhap_GUI() throws SQLException {

		// connectDB
		connect();

		// khai bao dao
		taiKhoan_DAO = new TaiKhoan_DAO();
		nhanVien_DAO = new NhanVien_DAO();

		getContentPane().setLayout(null);
		setTitle("Login");
		setSize(755, 541);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		// image
		setIconImage(Toolkit.getDefaultToolkit().getImage(DangNhap_GUI.class.getResource("/image/HeThong/favicon.jpg")));
		// title
		lblTitle = new JLabel("ĐĂNG NHẬP");
		lblTitle.setFont(new Font("Times new roman", Font.BOLD, 40));
		lblTitle.setForeground(Color.blue);

		lblUser = new JLabel("Tài khoản:");
		lblUser.setSize(20, 300);
		lblUser.setFont(new Font("times new roman", Font.TRUETYPE_FONT, 28));

		// iconuser
		lblUser.setIcon(new ImageIcon("image//user.png"));

		// icon btn exit

		btnExit = new JButton("Thoát");

		chkShow = new JCheckBox("Hiển Thị Mật Khẩu");
		chkShow.setFont(new Font("Tahoma", Font.ITALIC, 10));
		chkShow.setBackground(new Color(255, 255, 255));
		chkShow.setForeground(new Color(0, 0, 0));
		chkShow.setBounds(138, 321, 151, 21);
		getContentPane().add(chkShow);

		// Hiển thị mất khẩu
		chkShow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (chkShow.isSelected()) {
					txtPwd.setEchoChar((char) 0);
				} else {
					txtPwd.setEchoChar('*');
				}
			}
		});

		lblUser = new JLabel("Tài khoản:");
		lblUser.setFont(new Font("Arial", Font.BOLD, 16));
		lblUser.setBounds(30, 223, 87, 32);
		lblUser.setForeground(new Color(0, 0, 0));
		getContentPane().add(lblUser);

		txtPwd = new JPasswordField();
		txtPwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnLogin.doClick();
				}
			}
		});

//		txtPwd.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) 
//					login();
//			}
//		});
		txtPwd.setText("NV0001");
		txtPwd.setBorder(BorderFactory.createLineBorder(new Color(117, 128, 134)));
		txtPwd.setBounds(138, 283, 191, 32);
		txtPwd.requestFocus();
		getContentPane().add(txtPwd);

		btnLogin = new JButton("Đăng nhập");
		btnLogin.setMnemonic(KeyEvent.VK_ENTER);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnLogin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnLogin.setBackground(new Color(253, 120, 49));
		btnLogin.setBounds(30, 384, 138, 38);
		getContentPane().add(btnLogin);

		btnExit = new JButton("Thoát");
		btnExit.setMnemonic(KeyEvent.VK_X);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Arial", Font.PLAIN, 16));
		btnExit.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnExit.setBackground(new Color(39, 63, 96));
		btnExit.setBounds(191, 384, 138, 38);
		getContentPane().add(btnExit);

		lblPwd = new JLabel("Mật khẩu:");
		lblPwd.setFont(new Font("Arial", Font.BOLD, 16));
		lblPwd.setBounds(30, 283, 87, 32);
		lblPwd.setForeground(new Color(0, 0, 0));
		getContentPane().add(lblPwd);

		txtUser = new JTextField();
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnLogin.doClick();
				}
			}
		});
		txtUser.setBounds(138, 223, 191, 32);
		txtUser.setBorder(BorderFactory.createLineBorder(new Color(117, 128, 134)));
		txtUser.setText("NV0001");
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnQuayLai = new JButton("← Quay lại");
		btnQuayLai.setMnemonic(KeyEvent.VK_ENTER);
		btnQuayLai.setForeground(new Color(0, 0, 0));
		btnQuayLai.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnQuayLai.setBorder(null);
		btnQuayLai.setBackground(new Color(255, 255, 255));
		btnQuayLai.setBounds(10, 473, 87, 21);
		btnQuayLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HeThongQuanLyNhaSach heThongQuanLyNhaSach = new HeThongQuanLyNhaSach();
				heThongQuanLyNhaSach.setVisible(true);
				setVisible(false);
			}
		});
		getContentPane().add(btnQuayLai);

		JLabel lblBackground = new JLabel("");
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setForeground(new Color(255, 0, 0));
		lblBackground.setBackground(new Color(255, 0, 0));
		lblBackground.setIcon(new ImageIcon(DangNhap_GUI.class.getResource("/image/HeThong/background-login.jpg")));
		lblBackground.setBounds(0, -25, 741, 529);
		getContentPane().add(lblBackground);

		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);

	}

//		  cbxHienThi.addActionListener(new ActionListener() {
//	            @Override
//	            public void actionPerformed(ActionEvent e) {
//	            	if (cbxHienThi.isSelected()) {
//	                	tfMatKhau.setEchoChar((char) 0);
//					} else {
//	                	tfMatKhau.setEchoChar('*');
//					}
//	            }
//	        });

//		lblBackground.setIcon(new ImageIcon(DangNhap_GUI.class.getResource("/image/background-login.jpg")));

	public void connect() throws SQLException {
		ConnectDB.getInstance();
		ConnectDB.connect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnLogin)) {
			try {
				login();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(btnExit)) {
			int option = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn thoát?", "Thoát?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

	}

	public void login() throws SQLException {
		if (countSaiMatKhau > 2) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai tài khoản quá 3 lần. Chương trình sẽ thoát!");
			System.exit(0);
		} else {
			String maTaiKhoan = txtUser.getText().trim();
			@SuppressWarnings("deprecation")
			String matKhau = txtPwd.getText().toString().trim();
			TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTaiKhoan(maTaiKhoan);
			if (taiKhoan.getTaiKhoan() == null) {
				JOptionPane.showMessageDialog(null, "Tài khoản không đúng!");
				countSaiMatKhau++;
			} else if (!taiKhoan.getMatKhau().equals(matKhau)) {
				JOptionPane.showMessageDialog(null, "Mật khẩu không đúng!");
				countSaiMatKhau++;
			} else {
				NhanVien nhanVien = nhanVien_DAO.getNhanVienTheoTaiKhoan(taiKhoan.getTaiKhoan());
				HeThongQuanLyNhaSach trangChu_GUI = new HeThongQuanLyNhaSach(nhanVien);
				trangChu_GUI.setVisible(true);
				this.setVisible(false);
			}
		}
	}
}
