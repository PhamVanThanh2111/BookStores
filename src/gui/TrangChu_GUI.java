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
import javax.swing.border.LineBorder;

import entity.NhanVien;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

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
	private CardLayout cardLayoutContent;
	private JLabel lblNhanVien;
	private JLabel lblCuaHang;
	private JLabel lblKhachHang;
	private JLabel lblHoaDon;
	private JLabel lblSach;
	private JLabel lblThongKe;
	private JLabel lblShowHideMenu;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public TrangChu_GUI(NhanVien nhanVien) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TrangChu_GUI.class.getResource("/image/favicon.jpg")));
		setForeground(new Color(255, 255, 255));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setBounds(0, 0, 1280, 520);
		setSize(1366, 768);
		setResizable(false);
		setTitle("Quản lý sách");
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblShowHideMenu = new JLabel("-");
		lblShowHideMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblShowHideMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowHideMenu.setForeground(new Color(255, 255, 255));
		lblShowHideMenu.setBackground(new Color(240, 240, 240));
		lblShowHideMenu.setBounds(150, 65, 30, 30);
		contentPane.add(lblShowHideMenu);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1352, 54);
		panel.setBackground(new Color(46, 46, 46));
		getContentPane().add(panel);
		panel.setLayout(null);
						
								lblSubMa = new JLabel("Mã nhân viên:");
								lblSubMa.setForeground(Color.WHITE);
								lblSubMa.setFont(new Font("SansSerif", Font.BOLD, 15));
								lblSubMa.setBounds(940, 26, 110, 20);
								panel.add(lblSubMa);
				
						lblHeaderMaNV = new JLabel();
						lblHeaderMaNV.setText(nhanVien.getMaNV());
						lblHeaderMaNV.setForeground(Color.WHITE);
						lblHeaderMaNV.setFont(new Font("SansSerif", Font.ITALIC, 15));
						lblHeaderMaNV.setBounds(1050, 26, 60, 20);
						panel.add(lblHeaderMaNV);
		
				lblHeaderTen = new JLabel(nhanVien.getTenNV());
				lblHeaderTen.setFont(new Font("SansSerif", Font.BOLD, 15));
				lblHeaderTen.setForeground(new Color(255, 255, 255));
				lblHeaderTen.setBounds(940, 5, 170, 20);
				panel.add(lblHeaderTen);

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

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setToolTipText("Đăng xuất");
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDangXuat.setBounds(1210, 10, 132, 35);
		btnDangXuat.setBackground(new Color(0xE91940));
		btnDangXuat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát ứng dụng?", "Thoát?",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					DangNhap_GUI dangNhap_GUI;
					try {
						dangNhap_GUI = new DangNhap_GUI();
						dangNhap_GUI.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);
				}
			}
		});
		panel.add(btnDangXuat);

		btnHeaderInfo = new JButton();

		btnHeaderInfo.setForeground(Color.WHITE);
		btnHeaderInfo.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnHeaderInfo.setBounds(1120, 5, 60, 44);
		btnHeaderInfo.setBackground(new Color(57, 210, 247));
		panel.add(btnHeaderInfo);

		// menu
		JPanel pMenu = new JPanel();
		pMenu.setBackground(new Color(42, 42, 42));
		pMenu.setBounds(0, 64, 180, 667);
		pMenu.setLayout(null);

//		if (nhanVien.getChucVu().equalsIgnoreCase("Quản trị hệ thống")) {
//			cardLayoutMenu = new CardLayout();
//			pMenu.setLayout(cardLayoutMenu);
//			pMenu.add(new MenuAdmin(), "MenuAdmin");
//			cardLayoutMenu.show(pMenu, "MenuAdmin");
//		}
//		else
//			pMenu.setLayout(null);

		getContentPane().add(pMenu);

		lblNhanVien = new JLabel("Nhân Viên");
		lblNhanVien.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNhanVien.setBackground(new Color(28, 28, 28));
				lblNhanVien.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNhanVien.setBackground(new Color(38, 38, 38));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "NhanVien_GUI");
			}
		});
		lblNhanVien.setForeground(new Color(255, 255, 255));
		lblNhanVien.setBackground(new Color(28, 28, 28));
		lblNhanVien.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhanVien.setBounds(10, 40, 160, 64);
		pMenu.add(lblNhanVien);

		lblCuaHang = new JLabel("Cửa Hàng");
		lblCuaHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuaHang.setForeground(Color.WHITE);
		lblCuaHang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblCuaHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCuaHang.setBackground(new Color(28, 28, 28));
		lblCuaHang.setBounds(10, 144, 160, 64);
		lblCuaHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCuaHang.setBackground(new Color(28, 28, 28));
				lblCuaHang.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCuaHang.setBackground(new Color(38, 38, 38));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "CuaHang_GUI");
			}
		});
		pMenu.add(lblCuaHang);

		lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhachHang.setForeground(Color.WHITE);
		lblKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblKhachHang.setBackground(new Color(28, 28, 28));
		lblKhachHang.setBounds(10, 248, 160, 64);
		lblKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblKhachHang.setBackground(new Color(28, 28, 28));
				lblKhachHang.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblKhachHang.setBackground(new Color(38, 38, 38));
			}
		});
		pMenu.add(lblKhachHang);

		lblHoaDon = new JLabel("Hóa Đơn");
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setForeground(Color.WHITE);
		lblHoaDon.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHoaDon.setBackground(new Color(28, 28, 28));
		lblHoaDon.setBounds(10, 352, 160, 64);
		lblHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHoaDon.setBackground(new Color(28, 28, 28));
				lblHoaDon.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHoaDon.setBackground(new Color(38, 38, 38));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "HoaDon_GUI");
			}
		});
		pMenu.add(lblHoaDon);

		lblSach = new JLabel("Sách");
		lblSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblSach.setForeground(Color.WHITE);
		lblSach.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblSach.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSach.setBackground(new Color(28, 28, 28));
		lblSach.setBounds(10, 456, 160, 64);
		lblSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSach.setBackground(new Color(28, 28, 28));
				lblSach.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSach.setBackground(new Color(38, 38, 38));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "Sach_GUI");
			}
		});
		pMenu.add(lblSach);

		lblThongKe = new JLabel("Thống Kê");
		lblThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKe.setForeground(Color.WHITE);
		lblThongKe.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblThongKe.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblThongKe.setBackground(new Color(28, 28, 28));
		lblThongKe.setBounds(10, 560, 160, 64);
		lblThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblThongKe.setBackground(new Color(28, 28, 28));
				lblThongKe.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblThongKe.setBackground(new Color(38, 38, 38));
			}
		});
		pMenu.add(lblThongKe);

//		if (nhanVien.getChucVu().equalsIgnoreCase("Bán hàng")) {
//			btnNhanVien.setVisible(false);
//			btnCuaHang.setVisible(false);
//			btnKhachHang.setBounds(74, 0, 127, 31);
//			btnHoaDon.setBounds(275, 0, 127, 31);
//			btnSach.setBounds(476, 0, 127, 31);
//			btnLoaiSach.setBounds(677,  0, 127, 31);
//			btnNXB.setBounds(878, 0, 127, 31);
//			btnThongKe.setBounds(1079, 0, 127, 31);
//			
//			// set show pContent KhachHang
//		}
//		else {
//			// chuc nang nay danh cho quan ly kho
//		}

		pContent = new JPanel();
		pContent.setBackground(new Color(77, 77, 77));
		pContent.setBounds(190, 64, 1162, 667);
		getContentPane().add(pContent);

		cardLayoutContent = new CardLayout();
		pContent.setLayout(cardLayoutContent);
		pContent.add(new NhanVien_GUI(), "NhanVien_GUI");
		pContent.add(new Sach_GUI(), "Sach_GUI");
		pContent.add(new HoaDon_GUI(nhanVien.getMaNV()), "HoaDon_GUI");
		pContent.add(new CuaHang_GUI(), "CuaHang_GUI");
		cardLayoutContent.show(pContent, "NhanVien_GUI");

//		System.out.println(nhanVien.getChucVu());
		lblShowHideMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblShowHideMenu.getText().equals("-")) {
					lblShowHideMenu.setText("+");
					pContent.setBounds(102, 64, 1162, 667);
					lblShowHideMenu.setForeground(new Color(1, 1, 1));
					lblShowHideMenu.setBounds(10, 65, 25, 25);
				} else {
					lblShowHideMenu.setText("-");
					pContent.setBounds(190, 64, 1162, 667);
					lblShowHideMenu.setForeground(new Color(255, 255, 255));
					lblShowHideMenu.setBounds(150, 65, 25, 25);
				}
				pMenu.setVisible(!pMenu.isVisible());
			}
		});
		System.out.println(nhanVien.getTenNV());
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
