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
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txttenNXB;
	private JTextField txtdiaChi;

	/**
	 * Create the panel.
	 */
	public TheLoaiSach_GUI() {
		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setLayout(null);
		pMain.setBackground(new Color(241, 245, 249));
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);
		
		JPanel pNhapThongTin = new JPanel();
		pNhapThongTin.setLayout(null);
		pNhapThongTin.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pNhapThongTin.setBackground(Color.WHITE);
		pNhapThongTin.setBounds(869, 0, 430, 720);
		pMain.add(pNhapThongTin);
		
		JLabel lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHinhAnh.setBounds(20, 20, 90, 90);
		pNhapThongTin.add(lblHinhAnh);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setToolTipText("Số điện thoại");
		lblSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblSoDienThoai.setBounds(40, 201, 120, 40);
		pNhapThongTin.add(lblSoDienThoai);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Số điện thoại");
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(170, 201, 240, 40);
		pNhapThongTin.add(textField_1);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setToolTipText("Email");
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblEmail.setBounds(40, 246, 56, 40);
		pNhapThongTin.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Email");
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(170, 246, 240, 40);
		pNhapThongTin.add(textField_3);
		
		JLabel lblLuong = new JLabel("Lương:");
		lblLuong.setToolTipText("Lương");
		lblLuong.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLuong.setBounds(880, 70, 56, 33);
		pNhapThongTin.add(lblLuong);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Lương");
		textField_4.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(960, 70, 160, 33);
		pNhapThongTin.add(textField_4);
		
		JLabel lblnNXB = new JLabel("NXB");
		lblnNXB.setToolTipText("Mã nhà xuất bản");
		lblnNXB.setHorizontalAlignment(SwingConstants.LEFT);
		lblnNXB.setForeground(new Color(28, 28, 28));
		lblnNXB.setFont(new Font("SansSerif", Font.ITALIC, 20));
		lblnNXB.setBounds(120, 50, 177, 40);
		pNhapThongTin.add(lblnNXB);
		
		JLabel lblThongTinLienLac = new JLabel("Thông Tin Liên Lạc:");
		lblThongTinLienLac.setToolTipText("Mã nhân viên");
		lblThongTinLienLac.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinLienLac.setForeground(new Color(28, 28, 28));
		lblThongTinLienLac.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinLienLac.setBounds(20, 156, 189, 40);
		pNhapThongTin.add(lblThongTinLienLac);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(60, 60, 60));
		separator_1.setBounds(20, 310, 390, 2);
		pNhapThongTin.add(separator_1);
		
		JLabel lblthongTinNXB = new JLabel("Thông Tin Nhà Xuất Bản:");
		lblthongTinNXB.setToolTipText("Mã nhân viên");
		lblthongTinNXB.setHorizontalAlignment(SwingConstants.LEFT);
		lblthongTinNXB.setForeground(new Color(28, 28, 28));
		lblthongTinNXB.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblthongTinNXB.setBounds(20, 322, 270, 40);
		pNhapThongTin.add(lblthongTinNXB);
		
		JLabel lblmaNXB = new JLabel("Mã NXB:");
		lblmaNXB.setToolTipText("Số điện thoại");
		lblmaNXB.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblmaNXB.setBounds(40, 367, 120, 40);
		pNhapThongTin.add(lblmaNXB);
		
		JLabel lblMaNXB = new JLabel("NV0001");
		lblMaNXB.setToolTipText("Số điện thoại");
		lblMaNXB.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblMaNXB.setBounds(170, 367, 120, 40);
		pNhapThongTin.add(lblMaNXB);
		
		JLabel lbldiaChi = new JLabel("Địa Chỉ:");
		lbldiaChi.setToolTipText("Địa chỉ nhà xuất bản");
		lbldiaChi.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbldiaChi.setBounds(40, 412, 120, 40);
		pNhapThongTin.add(lbldiaChi);
		
		JButton btnChonHinhAnh = new JButton("Choose");
		btnChonHinhAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChonHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnChonHinhAnh.setBounds(30, 116, 64, 21);
		pNhapThongTin.add(btnChonHinhAnh);
		
		txttenNXB = new JTextField();
		txttenNXB.setToolTipText("Số điện thoại");
		txttenNXB.setText("Nhà Xuất Bản Trẻ");
		txttenNXB.setFont(new Font("SansSerif", Font.BOLD, 20));
		txttenNXB.setEditable(false);
		txttenNXB.setColumns(10);
		txttenNXB.setBorder(null);
		txttenNXB.setBackground(Color.WHITE);
		txttenNXB.setBounds(120, 20, 240, 40);
		pNhapThongTin.add(txttenNXB);
		
		txtdiaChi = new JTextField();
		txtdiaChi.setToolTipText("Email");
		txtdiaChi.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtdiaChi.setEditable(false);
		txtdiaChi.setColumns(10);
		txtdiaChi.setBackground(Color.WHITE);
		txtdiaChi.setBounds(170, 412, 240, 40);
		pNhapThongTin.add(txtdiaChi);
		
		PanelRound pDanhSach = new PanelRound();
		pDanhSach.setLayout(null);
		pDanhSach.setRoundTopLeft(16);
		pDanhSach.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSach.setBackground(Color.WHITE);
		pDanhSach.setBounds(0, 0, 850, 720);
		pMain.add(pDanhSach);
		
		JScrollPane scrollPaneNXB = new JScrollPane();
		scrollPaneNXB.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneNXB.setBorder(null);
		scrollPaneNXB.setBackground(Color.WHITE);
		scrollPaneNXB.setBounds(20, 70, 810, 569);
		pDanhSach.add(scrollPaneNXB);
		
		JLabel lblNh = new JLabel("Nhà Xuất Bản");
		lblNh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNh.setBounds(20, 22, 130, 40);
		pDanhSach.add(lblNh);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(60, 60, 60));
		separator.setBounds(154, 50, 676, 2);
		pDanhSach.add(separator);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBackground(new Color(73, 129, 158));
		btnXoa.setBounds(395, 660, 135, 40);
		pDanhSach.add(btnXoa);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAdd.setBackground(new Color(73, 129, 158));
		btnAdd.setBounds(245, 660, 135, 40);
		pDanhSach.add(btnAdd);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSua.setBackground(new Color(73, 129, 158));
		btnSua.setBounds(545, 660, 135, 40);
		pDanhSach.add(btnSua);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setBackground(new Color(73, 129, 158));
		btnTim.setBounds(695, 660, 135, 40);
		pDanhSach.add(btnTim);

	}
}
