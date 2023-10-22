package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class TheLoaiSach_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtmaTheLoaiSach;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TheLoaiSach_GUI() {
		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setLayout(null);
		pThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBounds(0, 0, 1300, 300);
		pMain.add(pThongTin);
		
		JLabel lblThngTinTh = new JLabel("Thông Tin Thể Loại Sách");
		lblThngTinTh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThngTinTh.setBounds(20, 15, 300, 40);
		pThongTin.add(lblThngTinTh);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(145, 200, 135, 40);
		pThongTin.add(btnAdd);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDelete.setBackground(new Color(73, 129, 158));
		btnDelete.setBounds(432, 200, 135, 40);
		pThongTin.add(btnDelete);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(73, 129, 158));
		btnUpdate.setBounds(719, 200, 135, 40);
		pThongTin.add(btnUpdate);
		
		JButton btnlamMoi = new JButton("Làm mới");
		btnlamMoi.setOpaque(true);
		btnlamMoi.setForeground(Color.WHITE);
		btnlamMoi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnlamMoi.setBackground(new Color(73, 129, 158));
		btnlamMoi.setBounds(1006, 200, 135, 40);
		pThongTin.add(btnlamMoi);
		
		JLabel lblmaTheLoaiSach = new JLabel("Mã Thể Loại Sách:");
		lblmaTheLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmaTheLoaiSach.setBounds(50, 100, 150, 40);
		pThongTin.add(lblmaTheLoaiSach);
		
		JLabel lbltenTheLoaiSach = new JLabel("Tên Thể Loại Sách:");
		lbltenTheLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltenTheLoaiSach.setBounds(680, 100, 175, 40);
		pThongTin.add(lbltenTheLoaiSach);
		
		txtmaTheLoaiSach = new JTextField();
		txtmaTheLoaiSach.setToolTipText("Mã Sách");
		txtmaTheLoaiSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtmaTheLoaiSach.setEditable(false);
		txtmaTheLoaiSach.setColumns(10);
		txtmaTheLoaiSach.setBackground(Color.WHITE);
		txtmaTheLoaiSach.setBounds(220, 100, 400, 40);
		pThongTin.add(txtmaTheLoaiSach);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Mã Sách");
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(850, 100, 400, 40);
		pThongTin.add(textField_1);
		
		JPanel pDanhSach = new JPanel();
		pDanhSach.setLayout(null);
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBackground(Color.WHITE);
		pDanhSach.setBounds(0, 320, 1300, 400);
		pMain.add(pDanhSach);
		
		JScrollPane scrollPaneSach = new JScrollPane();
		scrollPaneSach.setToolTipText("Chọn vào thể loại  Sách cần hiển thị thông tin");
		scrollPaneSach.setBorder(null);
		scrollPaneSach.setBackground(Color.WHITE);
		scrollPaneSach.setBounds(20, 44, 1259, 335);
		pDanhSach.add(scrollPaneSach);
		
		JLabel lblChiTitTh = new JLabel("Chi Tiết Thể Loại Sách");
		lblChiTitTh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChiTitTh.setBounds(22, 10, 291, 40);
		pDanhSach.add(lblChiTitTh);

	}
}
