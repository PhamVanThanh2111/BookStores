package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.ChiTietPhieuDatHang_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatHang_DAO;
import dao.SanPham_DAO;
import entity.ChiTietPhieuDatHang;
import entity.PhieuDatHang;

import java.awt.Color;
import javax.swing.JButton;

public class DanhSachDatHang_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMaPhieuDatHangValue,lblTien,lblTenNhanVien,lblSDThoai,lblTenKhachHang;
	private JButton btnLapHD,btnXoa;
	private DefaultTableModel modelDSPD;
	private DefaultTableModel modelCTPD;
	private JTable tableDSPD;
	private JTable tableCTPD;
	private JTableHeader tableHeaderDSPD;
	private JTableHeader tableHeaderCTPD;
	private PhieuDatHang_DAO phieuDatHang_DAO;
	private KhachHang_DAO khachHang_DAO;
	private NhanVien_DAO nhanVien_DAO;
	private ChiTietPhieuDatHang_DAO chiTietPhieuDatHang_DAO;
	private SanPham_DAO sanPham_DAO;
	
	/**
	 * Create the panel.
	 */
	public DanhSachDatHang_GUI() {
		
		// khai bao DAO
		phieuDatHang_DAO = new PhieuDatHang_DAO();
		khachHang_DAO = new KhachHang_DAO();
		nhanVien_DAO = new NhanVien_DAO();
		chiTietPhieuDatHang_DAO = new ChiTietPhieuDatHang_DAO();
		sanPham_DAO = new SanPham_DAO();
		
		setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setBounds(0, 0, 1300, 720);
		add(pMain);
		pMain.setLayout(null);
		
		JPanel pDanhSachDatHang = new JPanel();
		pDanhSachDatHang.setBackground(new Color(255, 255, 255));
		pDanhSachDatHang.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pDanhSachDatHang.setBounds(0, 0, 750, 720);
		pMain.add(pDanhSachDatHang);
		pDanhSachDatHang.setLayout(null);
		
		JLabel lblDanhSachDatHang = new JLabel("Danh Sách Đặt Hàng");
		lblDanhSachDatHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDanhSachDatHang.setBounds(20, 30, 200, 40);
		pDanhSachDatHang.add(lblDanhSachDatHang);
		
		JScrollPane scrDanhSachHoaDon = new JScrollPane();
		scrDanhSachHoaDon.setBounds(20, 82, 710, 500);
		scrDanhSachHoaDon.setToolTipText("Chọn vào hóa đơn cần hiển thị thông tin");
		scrDanhSachHoaDon.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrDanhSachHoaDon.setBackground(new Color(255, 255, 255));
		pDanhSachDatHang.add(scrDanhSachHoaDon);

		String cols[] = { "Mã Phiếu Đặt", "Tên Khách Hàng", "Số Điện Thoại",
				 "Tên Nhân Viên" , "Ngày Đặt" , "Thành Tiền" };
		modelDSPD = new DefaultTableModel(cols, 0);
		tableDSPD = new JTable(modelDSPD);
		tableDSPD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableDSPD.setToolTipText("Chọn vào hóa đơn cần hiển thị thông tin");
		tableDSPD.setRowHeight(30);
		tableDSPD.setDefaultEditor(Object.class, null);
		tableDSPD.setShowGrid(true);
		tableDSPD.setShowHorizontalLines(true);
		tableDSPD.setBackground(new Color(255, 255, 255));
		tableDSPD.setSelectionBackground(new Color(141, 208, 229));
		tableDSPD.setSelectionForeground(new Color(0, 0, 0));
		tableDSPD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDSPD.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tableDSPD.getSelectedRow();
				PhieuDatHang phieuDatHang = phieuDatHang_DAO.getPhieuDatHangTheoMaPhieuDatHang(modelDSPD.getValueAt(row, 0).toString());
				loadDataIntoTableChiTietPhieuDatTheoMaPhieuDat(phieuDatHang.getMaPhieuDatHang());
				lblMaPhieuDatHangValue.setText(modelDSPD.getValueAt(row, 0).toString());
				lblTenKhachHang.setText(modelDSPD.getValueAt(row, 1).toString());
				lblSDThoai.setText(modelDSPD.getValueAt(row, 2).toString());
				lblTenNhanVien.setText(modelDSPD.getValueAt(row, 3).toString());
			}
		});
		scrDanhSachHoaDon.setViewportView(tableDSPD);

		// header of table
		tableHeaderDSPD = tableDSPD.getTableHeader();
		tableHeaderDSPD.setBackground(new Color(73, 129, 158));
		tableHeaderDSPD.setForeground(Color.white);
		tableHeaderDSPD.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeaderDSPD.setReorderingAllowed(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tableDSPD.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableDSPD.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableDSPD.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableDSPD.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableDSPD.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableDSPD.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tableDSPD.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(73, 129, 158));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBounds(595, 640, 135, 40);
		pDanhSachDatHang.add(btnXoa);
		
		btnLapHD = new JButton("Lập HD");
		btnLapHD.setForeground(Color.WHITE);
		btnLapHD.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLapHD.setBackground(new Color(73, 129, 158));
		btnLapHD.setBounds(445, 640, 135, 40);
		pDanhSachDatHang.add(btnLapHD);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLamMoi.setBackground(new Color(73, 129, 158));
		btnLamMoi.setBounds(294, 640, 135, 40);
		btnLamMoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		    	loadDataIntoTableDanhSachPhieuDatHang(phieuDatHang_DAO.getAllListPhieuDatHang());
			}
		});
		pDanhSachDatHang.add(btnLamMoi);
		
		JPanel pThongTinChiTiet = new JPanel();
		pThongTinChiTiet.setBackground(new Color(255, 255, 255));
		pThongTinChiTiet.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pThongTinChiTiet.setBounds(770, 0, 530, 720);
		pMain.add(pThongTinChiTiet);
		pThongTinChiTiet.setLayout(null);
		
		JLabel lblThongTinChiTiet = new JLabel("Thông Tin Chi Tiết");
		lblThongTinChiTiet.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinChiTiet.setBounds(20, 30, 200, 40);
		pThongTinChiTiet.add(lblThongTinChiTiet);
		
		JLabel lblMaPhieuDatHang = new JLabel("Mã Phiếu Đặt:");
		lblMaPhieuDatHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaPhieuDatHang.setBounds(40, 120, 150, 40);
		pThongTinChiTiet.add(lblMaPhieuDatHang);
		
		lblMaPhieuDatHangValue = new JLabel();
		lblMaPhieuDatHangValue.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMaPhieuDatHangValue.setBounds(210, 120, 150, 40);
		pThongTinChiTiet.add(lblMaPhieuDatHangValue);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenKH.setBounds(40, 165, 150, 40);
		pThongTinChiTiet.add(lblTenKH);
		
		lblTenKhachHang = new JLabel();
		lblTenKhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenKhachHang.setBounds(210, 165, 282, 40);
		pThongTinChiTiet.add(lblTenKhachHang);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSDT.setBounds(40, 210, 150, 40);
		pThongTinChiTiet.add(lblSDT);
		
		lblSDThoai = new JLabel();
		lblSDThoai.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSDThoai.setBounds(210, 210, 282, 40);
		pThongTinChiTiet.add(lblSDThoai);
		
		JLabel lblTenNV = new JLabel("Tên Nhân Viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenNV.setBounds(40, 255, 150, 40);
		pThongTinChiTiet.add(lblTenNV);
		
		lblTenNhanVien = new JLabel();
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenNhanVien.setBounds(210, 255, 282, 40);
		pThongTinChiTiet.add(lblTenNhanVien);
		
		JScrollPane scrollPaneCTPD = new JScrollPane();
		scrollPaneCTPD = new JScrollPane();
		scrollPaneCTPD.setBounds(20, 310, 490, 230);
		scrollPaneCTPD.setToolTipText("");
		scrollPaneCTPD.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPaneCTPD.setBackground(new Color(255, 255, 255));
		pThongTinChiTiet.add(scrollPaneCTPD);

		String colsChiTietHoaDon[] = { "Mã Hóa Đơn", "Tên Sản Phẩm", "Số Lượng",
				"Đơn Giá" };
		modelCTPD = new DefaultTableModel(colsChiTietHoaDon, 0);
		tableCTPD = new JTable(modelCTPD);
		tableCTPD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableCTPD.setToolTipText("Chọn vào hóa đơn cần hiển thị thông tin");
		tableCTPD.setRowHeight(30);
		tableCTPD.setDefaultEditor(Object.class, null);
		tableCTPD.setShowGrid(true);
		tableCTPD.setShowHorizontalLines(true);
		tableCTPD.setBackground(new Color(255, 255, 255));
		tableCTPD.setSelectionBackground(new Color(141, 208, 229));
		tableCTPD.setSelectionForeground(new Color(0, 0, 0));
		tableCTPD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCTPD.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		scrollPaneCTPD.setViewportView(tableCTPD);

		// header of table
		tableHeaderCTPD = tableCTPD.getTableHeader();
		tableHeaderCTPD.setBackground(new Color(73, 129, 158));
		tableHeaderCTPD.setForeground(Color.white);
		tableHeaderCTPD.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeaderCTPD.setReorderingAllowed(false);
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tableCTPD.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableCTPD.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableCTPD.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableCTPD.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableCTPD.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		JLabel lblTongTien = new JLabel("Tổng Tiền:");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTongTien.setBounds(240, 550, 122, 40);
		pThongTinChiTiet.add(lblTongTien);
		
		lblTien = new JLabel("80.000 VND");
		lblTien.setForeground(new Color(255, 0, 0));
		lblTien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTien.setBounds(360, 550, 150, 40);
		pThongTinChiTiet.add(lblTien);

    	loadDataIntoTableDanhSachPhieuDatHang(phieuDatHang_DAO.getAllListPhieuDatHang());
	}
	
	private void loadDataIntoTableDanhSachPhieuDatHang(ArrayList<PhieuDatHang> danhSachPhieuDatHangs) {
		modelDSPD.setRowCount(0);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (PhieuDatHang phieuDatHang : danhSachPhieuDatHangs) {
			Object[] objects = {phieuDatHang.getMaPhieuDatHang(), 
								khachHang_DAO.getKhachHangTheoMaKhachHang(phieuDatHang.getMaKhachHang()).getTenKhachHang(),
								khachHang_DAO.getKhachHangTheoMaKhachHang(phieuDatHang.getMaKhachHang()).getSoDienThoai(),
								nhanVien_DAO.getNhanVienTheoMa(phieuDatHang.getMaNhanVien()).getTenNhanVien(), 
								simpleDateFormat.format(phieuDatHang.getNgayLap()), 
								phieuDatHang.getThanhTien()};
			modelDSPD.addRow(objects);
		}
	}
	
	private void loadDataIntoTableChiTietPhieuDatTheoMaPhieuDat(String maPhieuDat) {
		modelCTPD.setRowCount(0);
		for (ChiTietPhieuDatHang chiTietPhieuDatHang : chiTietPhieuDatHang_DAO.getAllChiTietPhieuDatHangTheoMaPhieuDatHang(maPhieuDat)) {
			Object[] objects = {chiTietPhieuDatHang.getMaPhieuDatHang(),
								sanPham_DAO.getSanPhamTheoMaSanPham(chiTietPhieuDatHang.getMaSanPham()).getTenSanPham(),
								chiTietPhieuDatHang.getSoLuong(),
								chiTietPhieuDatHang.getDonGia()};
			modelCTPD.addRow(objects);
		}
	}
}
