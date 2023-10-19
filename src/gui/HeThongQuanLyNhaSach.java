package gui;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import entity.NhanVien;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JSeparator;

public class HeThongQuanLyNhaSach extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pContent;
	private CardLayout cardLayoutContent;
	private JLabel lblNhanVien;
	private JLabel lblTrangChu;
	private JLabel lblKhachHang;
	private JLabel lblHoaDon;
	private JLabel lblSach;
	private JLabel lblHoSo;
	private JLabel lblDangXuat;
	private JLabel lblDungCuHocTap;
	private JLabel lblIconTrangChu;
	private JLabel lblIconNhanVien;
	private JLabel lblIconKhachHang;
	private JLabel lblIconSach;
	private JLabel lblIconDCHT;
	private JLabel lblIconHoaDon;
	private JLabel lblIconHoSo;
	private JLabel lblIconDangXuat;
	private JLabel lblSubMenu2;
	private JSeparator sprDoc2;
	private JLabel lblSubMenu3;
	private JSeparator sprDoc1;
	private JLabel lblSubMenu1;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public HeThongQuanLyNhaSach(NhanVien nhanVien) throws SQLException {

		setIconImage(Toolkit.getDefaultToolkit().getImage(HeThongQuanLyNhaSach.class.getResource("/image/favicon.jpg")));
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1560, 882);
		setResizable(false);
		setTitle("Quản lý sách");
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane.setLayout(null);
		
		// menu
		JPanel pMenu1 = new JPanel();
		pMenu1.setBackground(new Color(255, 255, 255));
		pMenu1.setBounds(0, 85, 200, 568);
		pMenu1.setLayout(null);

		getContentPane().add(pMenu1);

		lblNhanVien = new JLabel("Nhân Viên");
		lblNhanVien.setBorder(null);
		lblNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNhanVien.setBackground(new Color(24, 39, 60));
				lblNhanVien.setOpaque(true);
				lblIconNhanVien.setBackground(new Color(24, 39, 60));
				lblIconNhanVien.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNhanVien.setBackground(new Color(39, 63, 96));
				lblIconNhanVien.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "NhanVien_GUI");
				lblSubMenu1.setVisible(true);
				lblSubMenu1.setText("Nhân Viên");
				lblSubMenu2.setVisible(true);
				lblSubMenu2.setText("Thống Kê");
				lblSubMenu3.setVisible(false);
				sprDoc2.setVisible(false);
				sprDoc1.setVisible(true);
			}
		});
		
				lblTrangChu = new JLabel("Trang Chủ");
				lblTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
				lblTrangChu.setForeground(Color.WHITE);
				lblTrangChu.setFont(new Font("SansSerif", Font.BOLD, 20));
				lblTrangChu.setBorder(null);
				lblTrangChu.setBackground(new Color(39, 63, 96));
				lblTrangChu.setBounds(62, 0, 138, 86);
				lblTrangChu.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						lblTrangChu.setBackground(new Color(24, 39, 60));
						lblTrangChu.setOpaque(true);
						lblIconTrangChu.setBackground(new Color(24, 39, 60));
						lblIconTrangChu.setOpaque(true);
					}

					@Override
					public void mouseExited(MouseEvent e) {
						lblTrangChu.setBackground(new Color(39, 63, 96));
						lblIconTrangChu.setBackground(new Color(39, 63, 96));
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						cardLayoutContent.show(pContent, "TrangChu_GUI");
						lblSubMenu1.setVisible(false);
						lblSubMenu2.setVisible(false);
						lblSubMenu3.setVisible(false);
						sprDoc1.setVisible(false);
						sprDoc2.setVisible(false);
					}
				});
				pMenu1.add(lblTrangChu);
		lblNhanVien.setForeground(new Color(255, 255, 255));
		lblNhanVien.setBackground(new Color(39, 63, 96));
		lblNhanVien.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhanVien.setBounds(62, 96, 138, 86);
		pMenu1.add(lblNhanVien);

		lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblKhachHang.setForeground(Color.WHITE);
		lblKhachHang.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblKhachHang.setBorder(null);
		lblKhachHang.setBackground(new Color(39, 63, 96));
		lblKhachHang.setBounds(62, 192, 138, 86);
		lblKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblKhachHang.setBackground(new Color(24, 39, 60));
				lblKhachHang.setOpaque(true);
				lblIconKhachHang.setBackground(new Color(24, 39, 60));
				lblIconKhachHang.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblKhachHang.setBackground(new Color(39, 63, 96));
				lblIconKhachHang.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "KhachHang_GUI");
				lblSubMenu1.setVisible(false);
				lblSubMenu2.setVisible(false);
				lblSubMenu3.setVisible(false);
				sprDoc1.setVisible(false);
				sprDoc2.setVisible(false);
			}
		});
		pMenu1.add(lblKhachHang);

		lblHoaDon = new JLabel("Hóa Đơn");
		lblHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoaDon.setForeground(Color.WHITE);
		lblHoaDon.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblHoaDon.setBorder(null);
		lblHoaDon.setBackground(new Color(39, 63, 96));
		lblHoaDon.setBounds(62, 480, 138, 86);
		lblHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHoaDon.setBackground(new Color(24, 39, 60));
				lblHoaDon.setOpaque(true);
				lblIconHoaDon.setBackground(new Color(24, 39, 60));
				lblIconHoaDon.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHoaDon.setBackground(new Color(39, 63, 96));
				lblIconHoaDon.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "HoaDon_GUI");
				lblSubMenu1.setVisible(true);
				lblSubMenu1.setText("Hóa Đơn");
				lblSubMenu2.setVisible(true);
				lblSubMenu2.setText("Danh Sách Đặt Hàng");
				lblSubMenu3.setVisible(true);
				lblSubMenu3.setText("Danh Sách Hóa Đơn");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(true);
			}
		});
		pMenu1.add(lblHoaDon);

		lblSach = new JLabel("Sách");
		lblSach.setHorizontalAlignment(SwingConstants.LEFT);
		lblSach.setForeground(Color.WHITE);
		lblSach.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblSach.setBorder(null);
		lblSach.setBackground(new Color(39, 63, 96));
		lblSach.setBounds(62, 288, 138, 86);
		lblSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSach.setBackground(new Color(24, 39, 60));
				lblSach.setOpaque(true);
				lblIconSach.setBackground(new Color(24, 39, 60));
				lblIconSach.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSach.setBackground(new Color(39, 63, 96));
				lblIconSach.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "Sach_GUI");
				lblSubMenu1.setVisible(true);
				lblSubMenu1.setText("Sách");
				lblSubMenu2.setVisible(true);
				lblSubMenu2.setText("Loại Sách");
				lblSubMenu3.setVisible(true);
				lblSubMenu3.setText("Nhà Xuất Bản");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(true);
			}
		});
		pMenu1.add(lblSach);
		
		lblDungCuHocTap = new JLabel("DCHT");
		lblDungCuHocTap.setToolTipText("Dụng cụ học tập");
		lblDungCuHocTap.setHorizontalAlignment(SwingConstants.LEFT);
		lblDungCuHocTap.setForeground(Color.WHITE);
		lblDungCuHocTap.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblDungCuHocTap.setBorder(null);
		lblDungCuHocTap.setBackground(new Color(39, 63, 96));
		lblDungCuHocTap.setBounds(62, 384, 138, 86);
		lblDungCuHocTap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(24, 39, 60));
				lblDungCuHocTap.setOpaque(true);
				lblIconDCHT.setBackground(new Color(24, 39, 60));
				lblIconDCHT.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(39, 63, 96));
				lblIconDCHT.setBackground(new Color(39, 63, 96));
			}
		});
		pMenu1.add(lblDungCuHocTap);
		if (nhanVien.getChucVu().equalsIgnoreCase("Bán hàng")) {
			// menu cac chuc nang danh cho nhân viên bán hàng
			lblHoSo.setVisible(true);
			lblNhanVien.setVisible(false);
			lblTrangChu.setVisible(false);
			lblKhachHang.setBounds(10, 40, 160, 64);
			lblHoaDon.setBounds(10, 144, 160, 64);
			lblSach.setBounds(10, 248, 160, 64);
			lblHoSo.setBounds(10, 352, 160, 64);
		}

		pContent = new JPanel();
		pContent.setBorder(null);
		pContent.setBackground(new Color(77, 77, 77));
		pContent.setBounds(220, 105, 1300, 720);
		getContentPane().add(pContent);

		cardLayoutContent = new CardLayout();
		pContent.setLayout(cardLayoutContent);
		pContent.add(new TrangChu_GUI(nhanVien.getMaNhanVien()), "TrangChu_GUI");
		pContent.add(new NhanVien_GUI(), "NhanVien_GUI");
		pContent.add(new KhachHang_GUI(), "KhachHang_GUI");
		//thong ke
		pContent.add(new Sach_GUI(), "Sach_GUI");
		//dung cu hoc tap
		pContent.add(new NXB_GUI(), "NXB_GUI");
		pContent.add(new HoaDon_GUI(nhanVien.getMaNhanVien()), "HoaDon_GUI");
		pContent.add(new TheLoaiSach_GUI(), "LoaiSach_GUI");
		cardLayoutContent.show(pContent, "TrangChu_GUI");
		
		JPanel pMenu2 = new JPanel();
		pMenu2.setBackground(new Color(255, 255, 255));
		pMenu2.setBounds(0, 673, 200, 172);
		contentPane.add(pMenu2);
		pMenu2.setLayout(null);
		
		lblDangXuat = new JLabel("Đăng Xuất");
		lblDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblDangXuat.setBorder(null);
		lblDangXuat.setBackground(new Color(39, 63, 96));
		lblDangXuat.setBounds(62, 86, 138, 86);
		lblDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDangXuat.setBackground(new Color(24, 39, 60));
				lblDangXuat.setOpaque(true);
				lblIconDangXuat.setBackground(new Color(24, 39, 60));
				lblIconDangXuat.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDangXuat.setBackground(new Color(39, 63, 96));
				lblIconDangXuat.setBackground(new Color(39, 63, 96));
			}
		});
		pMenu2.add(lblDangXuat);
		
		// set mau cho menu
		lblTrangChu.setOpaque(true);
		lblNhanVien.setOpaque(true);
		lblKhachHang.setOpaque(true);
		lblSach.setOpaque(true);
		lblDungCuHocTap.setOpaque(true);
		lblHoaDon.setOpaque(true);
		
		lblIconTrangChu = new JLabel("");
		lblIconTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconTrangChu.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/home.png")));
		lblIconTrangChu.setBounds(0, 0, 64, 86);
		lblIconTrangChu.setOpaque(true);
		lblIconTrangChu.setBackground(new Color(39, 63, 96));
		lblIconTrangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTrangChu.setBackground(new Color(24, 39, 60));
				lblTrangChu.setOpaque(true);
				lblIconTrangChu.setBackground(new Color(24, 39, 60));
				lblIconTrangChu.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblTrangChu.setBackground(new Color(39, 63, 96));
				lblIconTrangChu.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "TrangChu_GUI");
				lblSubMenu1.setVisible(false);
				lblSubMenu2.setVisible(false);
				lblSubMenu3.setVisible(false);
				sprDoc1.setVisible(false);
				sprDoc2.setVisible(false);
			}
		});
		pMenu1.add(lblIconTrangChu);
		
		lblIconNhanVien = new JLabel("");
		lblIconNhanVien.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/staff.png")));
		lblIconNhanVien.setOpaque(true);
		lblIconNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconNhanVien.setBackground(new Color(39, 63, 96));
		lblIconNhanVien.setBounds(0, 96, 64, 86);
		lblIconNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNhanVien.setBackground(new Color(24, 39, 60));
				lblNhanVien.setOpaque(true);
				lblIconNhanVien.setBackground(new Color(24, 39, 60));
				lblIconNhanVien.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNhanVien.setBackground(new Color(39, 63, 96));
				lblIconNhanVien.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "NhanVien_GUI");
				lblSubMenu1.setVisible(true);
				lblSubMenu1.setText("Nhân Viên");
				lblSubMenu2.setVisible(true);
				lblSubMenu2.setText("Thống Kê");
				lblSubMenu3.setVisible(false);
				sprDoc2.setVisible(false);
				sprDoc1.setVisible(true);
			}
		});
		pMenu1.add(lblIconNhanVien);
		
		lblIconKhachHang = new JLabel("");
		lblIconKhachHang.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/customer.png")));
		lblIconKhachHang.setOpaque(true);
		lblIconKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconKhachHang.setBackground(new Color(39, 63, 96));
		lblIconKhachHang.setBounds(0, 192, 64, 86);
		lblIconKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblKhachHang.setBackground(new Color(24, 39, 60));
				lblKhachHang.setOpaque(true);
				lblIconKhachHang.setBackground(new Color(24, 39, 60));
				lblIconKhachHang.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblKhachHang.setBackground(new Color(39, 63, 96));
				lblIconKhachHang.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "KhachHang_GUI");
				lblSubMenu1.setVisible(false);
				lblSubMenu2.setVisible(false);
				lblSubMenu3.setVisible(false);
				sprDoc1.setVisible(false);
				sprDoc2.setVisible(false);
			}
		});
		pMenu1.add(lblIconKhachHang);
		
		lblIconSach = new JLabel("");
		lblIconSach.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/book.png")));
		lblIconSach.setOpaque(true);
		lblIconSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSach.setBackground(new Color(39, 63, 96));
		lblIconSach.setBounds(0, 288, 64, 86);
		lblIconSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSach.setBackground(new Color(24, 39, 60));
				lblSach.setOpaque(true);
				lblIconSach.setBackground(new Color(24, 39, 60));
				lblIconSach.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSach.setBackground(new Color(39, 63, 96));
				lblIconSach.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "Sach_GUI");
				lblSubMenu1.setVisible(true);
				lblSubMenu1.setText("Sách");
				lblSubMenu2.setVisible(true);
				lblSubMenu2.setText("Loại Sách");
				lblSubMenu3.setVisible(true);
				lblSubMenu3.setText("Nhà Xuất Bản");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(true);
			}
		});
		pMenu1.add(lblIconSach);
		
		lblIconDCHT = new JLabel("");
		lblIconDCHT.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/pen.png")));
		lblIconDCHT.setOpaque(true);
		lblIconDCHT.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDCHT.setBackground(new Color(39, 63, 96));
		lblIconDCHT.setBounds(0, 384, 64, 86);
		lblIconDCHT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(24, 39, 60));
				lblDungCuHocTap.setOpaque(true);
				lblIconDCHT.setBackground(new Color(24, 39, 60));
				lblIconDCHT.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(39, 63, 96));
				lblIconDCHT.setBackground(new Color(39, 63, 96));
			}
		});
		pMenu1.add(lblIconDCHT);
		
		lblIconHoaDon = new JLabel("");
		lblIconHoaDon.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/bill.png")));
		lblIconHoaDon.setOpaque(true);
		lblIconHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHoaDon.setBackground(new Color(39, 63, 96));
		lblIconHoaDon.setBounds(0, 480, 64, 86);
		lblIconHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHoaDon.setBackground(new Color(24, 39, 60));
				lblHoaDon.setOpaque(true);
				lblIconHoaDon.setBackground(new Color(24, 39, 60));
				lblIconHoaDon.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHoaDon.setBackground(new Color(39, 63, 96));
				lblIconHoaDon.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutContent.show(pContent, "HoaDon_GUI");
				lblSubMenu1.setVisible(true);
				lblSubMenu1.setText("Hóa Đơn");
				lblSubMenu2.setVisible(true);
				lblSubMenu2.setText("Danh Sách Đặt Hàng");
				lblSubMenu3.setVisible(true);
				lblSubMenu3.setText("Danh Sách Hóa Đơn");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(true);
			}
		});
		pMenu1.add(lblIconHoaDon);
		
		lblDangXuat.setOpaque(true);
		lblHoSo = new JLabel("Hồ Sơ");
		lblHoSo.setBounds(62, 0, 138, 86);
		pMenu2.add(lblHoSo);
		lblHoSo.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoSo.setForeground(Color.WHITE);
		lblHoSo.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblHoSo.setBorder(null);
		lblHoSo.setBackground(new Color(39, 63, 96));
		lblHoSo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHoSo.setBackground(new Color(24, 39, 60));
				lblHoSo.setOpaque(true);
				lblIconHoSo.setBackground(new Color(24, 39, 60));
				lblIconHoSo.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHoSo.setBackground(new Color(39, 63, 96));
				lblIconHoSo.setBackground(new Color(39, 63, 96));
			}
		});
		lblHoSo.setOpaque(true);
		
		lblIconHoSo = new JLabel("");
		lblIconHoSo.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/user.png")));
		lblIconHoSo.setOpaque(true);
		lblIconHoSo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHoSo.setBackground(new Color(39, 63, 96));
		lblIconHoSo.setBounds(0, 0, 64, 86);
		lblIconHoSo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHoSo.setBackground(new Color(24, 39, 60));
				lblHoSo.setOpaque(true);
				lblIconHoSo.setBackground(new Color(24, 39, 60));
				lblIconHoSo.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHoSo.setBackground(new Color(39, 63, 96));
				lblIconHoSo.setBackground(new Color(39, 63, 96));
			}
		});
		pMenu2.add(lblIconHoSo);
		
		lblIconDangXuat = new JLabel("");
		lblIconDangXuat.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/logout.png")));
		lblIconDangXuat.setOpaque(true);
		lblIconDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDangXuat.setBackground(new Color(39, 63, 96));
		lblIconDangXuat.setBounds(0, 86, 64, 86);
		lblIconDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDangXuat.setBackground(new Color(24, 39, 60));
				lblDangXuat.setOpaque(true);
				lblIconDangXuat.setBackground(new Color(24, 39, 60));
				lblIconDangXuat.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDangXuat.setBackground(new Color(39, 63, 96));
				lblIconDangXuat.setBackground(new Color(39, 63, 96));
			}
		});
		pMenu2.add(lblIconDangXuat);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/logo.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogo.setBounds(58, 0, 93, 85);
		contentPane.add(lblLogo);
		
		Rectangle viTriMenuCon1 = new Rectangle(220, 15, 275, 55);
		Rectangle viTriMenuCon2 = new Rectangle(544, 15, 275, 55);
		Rectangle viTriMenuCon3 = new Rectangle(864, 15, 275, 55);
		
		lblSubMenu1 = new JLabel();
		lblSubMenu1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubMenu1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubMenu1.setBounds(viTriMenuCon1.getBounds());
		lblSubMenu1.setVisible(false);
		contentPane.add(lblSubMenu1);
		
		sprDoc1 = new JSeparator();
		sprDoc1.setForeground(new Color(60, 60, 60));
		sprDoc1.setOrientation(SwingConstants.VERTICAL);
		sprDoc1.setBounds(520, 15, 2, 55);
		sprDoc1.setVisible(false);
		contentPane.add(sprDoc1);
		
		lblSubMenu2 = new JLabel();
		lblSubMenu2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubMenu2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubMenu2.setBounds(viTriMenuCon2.getBounds());
		lblSubMenu2.setVisible(false);
		contentPane.add(lblSubMenu2);
		
		sprDoc2 = new JSeparator();
		sprDoc2.setForeground(new Color(60, 60, 60));
		sprDoc2.setOrientation(SwingConstants.VERTICAL);
		sprDoc2.setBounds(842, 15, 2, 55);
		sprDoc2.setVisible(false);
		contentPane.add(sprDoc2);
		
		lblSubMenu3 = new JLabel();
		lblSubMenu3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubMenu3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubMenu3.setBounds(viTriMenuCon3.getBounds());
		lblSubMenu3.setVisible(false);
		contentPane.add(lblSubMenu3);
		
		JSeparator sprNgang = new JSeparator();
		sprNgang.setForeground(new Color(60, 60, 60));
		contentPane.add(sprNgang);
	}

	public static void main(String[] args) {
		try {
		    UIManager.setLookAndFeel(new FlatMacLightLaf());
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
		try {
			DangNhap_GUI dangNhap_GUI = new DangNhap_GUI();
			dangNhap_GUI.setVisible(true);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
