package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import entity.NhanVien;

import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LoaiSach_GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaLoaiSach;
	private JTextField txtTenLoaiSach;

	/**
	 * Create the panel.
	 */
	public LoaiSach_GUI(NhanVien nhanVien) {
		setLayout(null);

		JPanel mMain = new JPanel();
		mMain.setBounds(10, 10, 1162, 667);
		add(mMain);
		mMain.setLayout(null);

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBounds(10, 10, 1142, 42);
		mMain.add(pnTieuDe);
		pnTieuDe.setLayout(null);

		JLabel lblQunLLoi = new JLabel("LOẠI SÁCH");
		lblQunLLoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLLoi.setBounds(421, 10, 240, 22);
		lblQunLLoi.setForeground(Color.RED);
		lblQunLLoi.setFont(new Font("Arial", Font.BOLD, 20));
		pnTieuDe.add(lblQunLLoi);

		JPanel pnThongTin = new JPanel();
		// pnCenN.setBorder(new TitledBorder(null, "Thông Tin: ", TitledBorder.LEADING,
		// TitledBorder.TOP, null, new Color(0, 126, 197)));
		pnThongTin.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0,0)), "Thông Tin:",//162, 197
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 126, 197)));
		pnThongTin.setBounds(10, 62, 1142, 106);
		mMain.add(pnThongTin);
		pnThongTin.setLayout(null);

		Box b = Box.createVerticalBox();
		b.setBounds(73, 10, 897, 74);
		b.setPreferredSize(new Dimension(840, 70));
		pnThongTin.add(b);

		Component verticalStrut = Box.createVerticalStrut(30);
		b.add(verticalStrut);

		Box b1 = Box.createHorizontalBox();
		b.add(b1);

		JLabel lblMaLoaiSach = new JLabel("Mã Loại Sách: ");
		lblMaLoaiSach.setPreferredSize(new Dimension(86, 13));
		b1.add(lblMaLoaiSach);

		txtMaLoaiSach = new JTextField();
		txtMaLoaiSach.setEditable(false);
		b1.add(txtMaLoaiSach);

		JLabel lblTenLoaiSach = new JLabel("Tên Loại Sách:    ");
		b1.add(lblTenLoaiSach);

		txtTenLoaiSach = new JTextField();
		b1.add(txtTenLoaiSach);

		Component verticalStrut_1 = Box.createVerticalStrut(10);
		b.add(verticalStrut_1);

		JPanel pnChucNang = new JPanel();
		pnChucNang.setBounds(10, 167, 1142, 54);
		pnChucNang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0 )), "Chức Năng:", //162, 197
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 126, 197)));
		mMain.add(pnChucNang);
		pnChucNang.setLayout(null);

		JButton btnThem = new JButton("Thêm Loại Sách");
		btnThem.setBounds(92, 10, 127, 34);
		pnChucNang.add(btnThem);

		JButton btnXoa = new JButton("Xóa Loại Sách");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setBounds(311, 10, 133, 34);
		pnChucNang.add(btnXoa);

		JButton btnSua = new JButton("Sửa Thông Tin");
		btnSua.setBounds(536, 10, 121, 34);
		pnChucNang.add(btnSua);

		JButton btnIn = new JButton("In Thông Tin");
		btnIn.setBounds(749, 10, 127, 34);
		pnChucNang.add(btnIn);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(968, 10, 80, 34);
		pnChucNang.add(btnThoat);

		JPanel pnDanhSach = new JPanel();
		pnDanhSach.setBounds(10, 231, 1142, 426);
		pnDanhSach.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0 )), "Danh sách:",//162, 197
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		mMain.add(pnDanhSach);
		pnDanhSach.setLayout(null);

		JScrollPane scrollPaneSach = new JScrollPane();
		scrollPaneSach.setBounds(10, 21, 1122, 395);
		scrollPaneSach.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneSach.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPaneSach.setBackground(new Color(0, 0, 0));
		pnDanhSach.add(scrollPaneSach);

	}
	
	public LoaiSach_GUI() {
		setLayout(null);

		JPanel mMain = new JPanel();
		mMain.setBounds(10, 10, 1162, 667);
		add(mMain);
		mMain.setLayout(null);

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBounds(10, 10, 1142, 42);
		mMain.add(pnTieuDe);
		pnTieuDe.setLayout(null);

		JLabel lblQunLLoi = new JLabel("LOẠI SÁCH");
		lblQunLLoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLLoi.setBounds(421, 10, 240, 22);
		lblQunLLoi.setForeground(Color.RED);
		lblQunLLoi.setFont(new Font("Arial", Font.BOLD, 20));
		pnTieuDe.add(lblQunLLoi);

		JPanel pnThongTin = new JPanel();
		// pnCenN.setBorder(new TitledBorder(null, "Thông Tin: ", TitledBorder.LEADING,
		// TitledBorder.TOP, null, new Color(0, 126, 197)));
		pnThongTin.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0,0)), "Thông Tin:",//162, 197
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 126, 197)));
		pnThongTin.setBounds(10, 62, 1142, 159);
		mMain.add(pnThongTin);
		pnThongTin.setLayout(null);

		Box b = Box.createVerticalBox();
		b.setBounds(135, 36, 897, 74);
		b.setPreferredSize(new Dimension(840, 70));
		pnThongTin.add(b);

		Component verticalStrut = Box.createVerticalStrut(30);
		b.add(verticalStrut);

		Box b1 = Box.createHorizontalBox();
		b.add(b1);

		JLabel lblMaLoaiSach = new JLabel("Mã Loại Sách: ");
		lblMaLoaiSach.setPreferredSize(new Dimension(86, 13));
		b1.add(lblMaLoaiSach);

		txtMaLoaiSach = new JTextField();
		txtMaLoaiSach.setEditable(false);
		b1.add(txtMaLoaiSach);

		JLabel lblTenLoaiSach = new JLabel("Tên Loại Sách:    ");
		b1.add(lblTenLoaiSach);

		txtTenLoaiSach = new JTextField();
		b1.add(txtTenLoaiSach);

		Component verticalStrut_1 = Box.createVerticalStrut(10);
		b.add(verticalStrut_1);

		JPanel pnDanhSach = new JPanel();
		pnDanhSach.setBounds(10, 231, 1142, 426);
		pnDanhSach.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0 )), "Danh sách:",//162, 197
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 162, 197)));
		mMain.add(pnDanhSach);
		pnDanhSach.setLayout(null);

		JScrollPane scrollPaneSach = new JScrollPane();
		scrollPaneSach.setBounds(10, 21, 1122, 395);
		scrollPaneSach.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		scrollPaneSach.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPaneSach.setBackground(new Color(0, 0, 0));
		pnDanhSach.add(scrollPaneSach);

	}
}
