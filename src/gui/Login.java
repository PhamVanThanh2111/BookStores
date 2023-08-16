package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import javax.swing.JCheckBox;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField taiKhoanTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	public void addPlaceholderStyle(JTextField textField) {
		Font font = textField.getFont();
		font = font.deriveFont(Font.ITALIC);
		textField.setFont(font);
		textField.setForeground(Color.GRAY);
	}
	
	public void removePlaceholderStyle(JTextField textField) {
		Font font = textField.getFont();
		font = font.deriveFont(Font.PLAIN|Font.BOLD);
		textField.setFont(font);
		textField.setForeground(Color.BLACK);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		taiKhoanTextField = new JTextField("Tài khoản");
		taiKhoanTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (taiKhoanTextField.getText().equals("Tài khoản")) {
					taiKhoanTextField.setText(null);
					taiKhoanTextField.requestFocus();
					removePlaceholderStyle(taiKhoanTextField);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (taiKhoanTextField.getText().length() == 0) {
					addPlaceholderStyle(taiKhoanTextField);
					taiKhoanTextField.setText("Tài khoản");
				}
			}
		});
		taiKhoanTextField.setForeground(Color.GRAY);
		taiKhoanTextField.setBounds(330, 185, 290, 63);
		contentPane.add(taiKhoanTextField);
		taiKhoanTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField.getText().equals("Mật khẩu")) {
					passwordField.setText(null);
					passwordField.requestFocus();
					// set password character
					passwordField.setEchoChar('*');
					removePlaceholderStyle(passwordField);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField.getText().length() == 0) {
					addPlaceholderStyle(passwordField);
					passwordField.setText("Mật khẩu");
//					passwordField.setEchoChar('\u0000');
					
				}
			}
		});
		passwordField.setBounds(330, 276, 290, 63);
		passwordField.setEchoChar('*');
		passwordField.setText("Mật khẩu");
		passwordField.setForeground(Color.GRAY);
		contentPane.add(passwordField);
		addPlaceholderStyle(taiKhoanTextField);
		addPlaceholderStyle(passwordField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(330, 364, 93, 21);
		contentPane.add(chckbxNewCheckBox);
	}
}
