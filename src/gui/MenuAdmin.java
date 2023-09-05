package gui;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;

public class MenuAdmin extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MenuAdmin() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 31);
		add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1280, 31);
		panel.add(menuBar);

		JMenu mnuNhanVien = new JMenu("Nhân Viên |");
		mnuNhanVien.setMnemonic('s');
		mnuNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		mnuNhanVien.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnuNhanVien);

		JMenu mnuCuaHang = new JMenu("Cửa Hàng |");
		mnuCuaHang.setHorizontalAlignment(SwingConstants.CENTER);
		mnuCuaHang.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnuCuaHang);

		JMenu mnuKhachHang = new JMenu("Khách Hàng |");
		mnuKhachHang.setMnemonic('s');
		mnuKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		mnuKhachHang.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnuKhachHang);

		JMenu mnuHoaDon = new JMenu("Hóa Đơn |");
		mnuHoaDon.setMnemonic('s');
		mnuHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		mnuHoaDon.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnuHoaDon);

		JMenu mnuSach = new JMenu("Sách |");
		mnuSach.setMnemonic('s');
		mnuSach.setHorizontalAlignment(SwingConstants.CENTER);
		mnuSach.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnuSach);

		JMenuItem mniSach = new JMenuItem("Sách");
		mniSach.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mnuSach.add(mniSach);

		JMenuItem mniLoaiSach = new JMenuItem("Loại sách");
		mniLoaiSach.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mnuSach.add(mniLoaiSach);

		JMenuItem mniNXB = new JMenuItem("NXB");
		mniNXB.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mnuSach.add(mniNXB);

		JMenu mnuDCHT = new JMenu("Dụng Cụ Học Tập |");
		mnuDCHT.setMnemonic('s');
		mnuDCHT.setHorizontalAlignment(SwingConstants.CENTER);
		mnuDCHT.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnuDCHT);

		JMenu mnuThongKe = new JMenu("Thống Kê |");
		mnuThongKe.setMnemonic('s');
		mnuThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		mnuThongKe.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnuThongKe);

	}
}
