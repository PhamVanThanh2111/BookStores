package gui;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;

import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyVetoException;
import java.awt.event.FocusAdapter;

public class DoiMatKhau_GUI extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField pwdMatKhauHienTai;
	private JPasswordField pwdNhapLai;
	private JPasswordField pwdMatKhauMoi;
	private TaiKhoan_DAO taiKhoan_DAO;
	private NhanVien nhanVien;
	private String matKhauHienTai;
	private String matKhauMoi;
	private String nhapLaiMatKhau;

	/**
	 * Create the frame.
	 */
	public DoiMatKhau_GUI(NhanVien nhanVien) {
		// khai bao DAO
		taiKhoan_DAO = new TaiKhoan_DAO();
		
		this.nhanVien = nhanVien;
		setBounds(100, 100, 562, 331);
		getContentPane().setLayout(null);
		
		JLabel lblMatKhauHienTai = new JLabel("Mật Khẩu Hiện Tại:");
		lblMatKhauHienTai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMatKhauHienTai.setBounds(69, 38, 165, 40);
		getContentPane().add(lblMatKhauHienTai);
		
		pwdMatKhauHienTai = new JPasswordField();
		pwdMatKhauHienTai.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pwdMatKhauHienTai.setEchoChar((char) 0);
			}
			@Override
			public void focusLost(FocusEvent e) {
				pwdMatKhauHienTai.setEchoChar('*');
			}
		});
		pwdMatKhauHienTai.setColumns(10);
		pwdMatKhauHienTai.setBounds(244, 38, 238, 40);
		getContentPane().add(pwdMatKhauHienTai);
		
		JLabel lblNhapLai = new JLabel("Nhập Lại:");
		lblNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNhapLai.setBounds(69, 158, 165, 40);
		getContentPane().add(lblNhapLai);
		
		pwdNhapLai = new JPasswordField();
		pwdNhapLai.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				trungKhop();
				pwdNhapLai.setEchoChar((char) 0);;
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				pwdNhapLai.setEchoChar('*');
			}
		});
		pwdNhapLai.setColumns(10);
		pwdNhapLai.setBounds(244, 158, 238, 40);
		getContentPane().add(pwdNhapLai);
		
		JLabel lblMatKhauMoi = new JLabel("Mật Khẩu Mới:");
		lblMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMatKhauMoi.setBounds(69, 98, 165, 40);
		getContentPane().add(lblMatKhauMoi);
		
		pwdMatKhauMoi = new JPasswordField();
		pwdMatKhauMoi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pwdMatKhauMoi.setEchoChar((char) 0);
			}
			@Override
			public void focusLost(FocusEvent e) {
				pwdMatKhauMoi.setEchoChar('*');
			}
		});
		pwdMatKhauMoi.setColumns(10);
		pwdMatKhauMoi.setBounds(244, 98, 238, 40);
		getContentPane().add(pwdMatKhauMoi);
		
		JButton btnDoiMatKhau = new JButton("Đổi Mật Khẩu");
		btnDoiMatKhau.setForeground(Color.WHITE);
		btnDoiMatKhau.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDoiMatKhau.setBackground(new Color(73, 129, 158));
		btnDoiMatKhau.setBounds(347, 226, 135, 40);
		btnDoiMatKhau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				doiMatKhau();
			}
		});
		getContentPane().add(btnDoiMatKhau);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnThoat.setBackground(new Color(73, 129, 158));
		btnThoat.setBounds(69, 226, 135, 40);
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					setClosed(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnThoat);

	}
	
	@SuppressWarnings("deprecation")
	private boolean trungKhop() {
		if (pwdMatKhauHienTai.getText().equals(pwdNhapLai.getText())) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Không trùng khớp với mật khẩu hiện tại!");
			return false;
		}
		
	}
	
	private boolean kiemTraRong() {
		matKhauHienTai = new String(pwdMatKhauHienTai.getPassword());
		matKhauMoi = new String(pwdMatKhauMoi.getPassword());
		nhapLaiMatKhau = new String(pwdNhapLai.getPassword());
		if (matKhauHienTai.equals("") && matKhauMoi.equals("") && nhapLaiMatKhau.equals("")) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	private boolean doiMatKhau() {
		if (kiemTraRong()) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin!");
			return false;
		}
		else if (matKhauHienTai.equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu hiện tại!");
			pwdMatKhauHienTai.requestFocus();
			return false;
		}
		else if (matKhauMoi.equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu mới!");
			pwdMatKhauMoi.requestFocus();
			return false;
		}
		else if (nhapLaiMatKhau.equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập lại mật khẩu mới!");
			pwdNhapLai.requestFocus();
			return false;
		}
		else {
			if (trungKhop()) {
				int option = JOptionPane.showConfirmDialog(null,
						"Đổi mật khẩu?", "Đổi mật khẩu",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					if (Regular_expression.validatePassword(pwdMatKhauMoi.getText())) {
						if (taiKhoan_DAO.getTaiKhoanTheoMaTaiKhoan(nhanVien.getTaiKhoan().getTaiKhoan()).getMatKhau().equals(pwdMatKhauHienTai.getText())) {
							TaiKhoan taiKhoan = new TaiKhoan();
							taiKhoan.setTaiKhoan(nhanVien.getTaiKhoan().getTaiKhoan());
							taiKhoan.setMatKhau(pwdMatKhauMoi.getText());
							taiKhoan_DAO.suaTaiKhoan(taiKhoan);
							JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
							setClosable(true);
							return true;
						}
						else {
							JOptionPane.showMessageDialog(null, "Mật khẩu hiện tại không đúng!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Mật khẩu mới phải có ít nhất 8 ký tự. Trong đó có ít nhất 1 chữ cái in thường, 1 chữ cái in hoa, 1 ký tự số và 1 ký tự đặc biệt!");
					}
				}
			}
			return false;
		}
	}
}
