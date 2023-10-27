package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class TimNhanVien extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimNhanVien frame = new TimNhanVien();
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
	public TimNhanVien() {
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(157, 33, 238, 40);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 124, 238, 40);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(157, 205, 238, 40);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(572, 33, 238, 40);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(572, 113, 238, 40);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(572, 205, 238, 40);
		contentPane.add(textField_5);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(675, 456, 135, 40);
		contentPane.add(btnTim);
		
		JComboBox<String> cmbChucVu = new JComboBox<String>();
		cmbChucVu.setBounds(572, 291, 238, 40);
		contentPane.add(cmbChucVu);
		
		JComboBox<String> cmbCa = new JComboBox<String>();
		cmbCa.setBounds(572, 367, 238, 40);
		contentPane.add(cmbCa);
		
		JComboBox<String> cmbGioiTinh = new JComboBox<String>();
		cmbGioiTinh.setBounds(157, 291, 238, 40);
		contentPane.add(cmbGioiTinh);
	}
}
