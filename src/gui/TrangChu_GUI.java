package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.NhanVien;

public class TrangChu_GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LocalDate now;
	private int ngay;
	private int thang;
	private int nam;
	private JLabel lblHeaderTen;
	private JLabel lblSubMa;
	private JButton btnDangXuat;
	private JLabel lblHeaderMaNV;
	private JButton btnHeaderInfo;
	private JPanel pContent;
	private CardLayout cardLayout;

	/**
	 * Create the frame.
	 */
	public TrangChu_GUI(NhanVien nhanVien) {
		setForeground(new Color(255, 255, 255));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setBounds(0, 0, 1280, 520);
		setSize(1280, 720);
		setResizable(false);
		setTitle("Quản lý sách");
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 54);
		panel.setBackground(new Color(0, 41, 111));
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TrangChu_GUI.class.getResource("/image/logo.jpg")));
		lblLogo.setBounds(30, 0, 217, 55);
		panel.add(lblLogo);

		now = LocalDate.now();
		ngay = now.getDayOfMonth();
		thang = now.getMonthValue();
		nam = now.getYear();

		JLabel lblHeaderDate = new JLabel("Hiện tại:");
		lblHeaderDate.setToolTipText("Ngày hiện tại");
		lblHeaderDate.setForeground(Color.WHITE);
		lblHeaderDate.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblHeaderDate.setBounds(488, 23, 66, 21);
		panel.add(lblHeaderDate);

		JLabel lblNgayHienTai = new JLabel(ngay + " / " + thang + " / " + nam);
		lblNgayHienTai.setToolTipText("Ngày hiện tại");
		lblNgayHienTai.setForeground(Color.WHITE);
		lblNgayHienTai.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNgayHienTai.setBounds(564, 20, 151, 21);
		panel.add(lblNgayHienTai);

		lblHeaderTen = new JLabel(nhanVien.getTenNV());
		lblHeaderTen.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblHeaderTen.setForeground(Color.WHITE);
		lblHeaderTen.setBounds(840, 5, 170, 20);
		panel.add(lblHeaderTen);

		lblSubMa = new JLabel("Mã nhân viên:");
		lblSubMa.setForeground(Color.WHITE);
		lblSubMa.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblSubMa.setBounds(840, 26, 110, 20);
		panel.add(lblSubMa);

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setToolTipText("Đăng xuất");
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDangXuat.setBounds(1110, 10, 132, 35);
		btnDangXuat.setBackground(new Color(0xE91940));
//		Icon iconDangXuat = IconFontSwing.buildIcon(FontAwesome.SIGN_OUT, 25, new Color(255, 255 ,255));
//		btnDangXuat.setIcon(iconDangXuat);
		btnDangXuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát ứng dụng?", "Thoát?", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		panel.add(btnDangXuat);

		lblHeaderMaNV = new JLabel();
		lblHeaderMaNV.setText(nhanVien.getMaNV());
		lblHeaderMaNV.setForeground(Color.WHITE);
		lblHeaderMaNV.setFont(new Font("SansSerif", Font.ITALIC, 15));
		lblHeaderMaNV.setBounds(950, 26, 60, 20);
		panel.add(lblHeaderMaNV);

		btnHeaderInfo = new JButton();

//		if (nv.getChucVu().equalsIgnoreCase("Quản lý"))
//			btnHeaderInfo.setText("QL");
//		else
//			btnHeaderInfo.setText("NV");

		btnHeaderInfo.setForeground(Color.WHITE);
		btnHeaderInfo.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnHeaderInfo.setBounds(1020, 5, 60, 44);
		btnHeaderInfo.setBackground(new Color(57, 210, 247));
		panel.add(btnHeaderInfo);
		
		// menu
		JPanel pMenu = new JPanel();
		pMenu.setBackground(new Color(17, 103, 177));
		pMenu.setBounds(0, 54, 1280, 31);
		getContentPane().add(pMenu);
		pMenu.setLayout(null);
		
		JButton btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setToolTipText("Quản lý nhân viên");
		btnNhanVien.setBounds(47, 0, 127, 31);
		btnNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardLayout.show(pContent, "1");
			}
		});
		pMenu.add(btnNhanVien);
		
		JButton btnSach = new JButton("Sách");
		btnSach.setToolTipText("Quản lý sách");
		btnSach.setBounds(743, 0, 127, 31);
		pMenu.add(btnSach);
		
		JButton btnNXB = new JButton("NXB");
		btnNXB.setToolTipText("Quản lý NXB");
		btnNXB.setBounds(917, 0, 127, 31);
		pMenu.add(btnNXB);
		
		JButton btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setToolTipText("Quản lý hóa đơn");
		btnHoaDon.setBounds(1091, 0, 127, 31);
		btnHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardLayout.show(pContent, "7");
			}
		});
		pMenu.add(btnHoaDon);
		
		JButton btnCuaHang = new JButton("Cửa hàng");
		btnCuaHang.setToolTipText("Quản lý cửa hàng");
		btnCuaHang.setBounds(395, 0, 127, 31);
		pMenu.add(btnCuaHang);
		
		JButton btnLoaiSach = new JButton("Loại sách");
		btnLoaiSach.setToolTipText("Quản lý loại sách");
		btnLoaiSach.setBounds(569, 0, 127, 31);
		pMenu.add(btnLoaiSach);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setToolTipText("Quản lý khách hàng");
		btnKhachHang.setBounds(221, 0, 127, 31);
		pMenu.add(btnKhachHang);
		
		pContent = new JPanel();
		pContent.setBounds(10, 90, 1256, 583);
		getContentPane().add(pContent);
		
		cardLayout = new CardLayout();
		pContent.setLayout(cardLayout);
		pContent.add(new NhanVien_GUI(), "1");
//		pContent.add(new HoaDon_GUI(), "2");
		// 3
		// 4
		// 5
		// 6Xj
		pContent.add(new HoaDon_GUI(), "7");
		cardLayout.show(pContent, "1");
	}	
	
	public static void main(String[] args) {
		try {
			new DangNhap_GUI().setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
