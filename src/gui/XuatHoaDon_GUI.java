package gui;

//import DAO.ChiTietHoaDon_DAO;
//import DAO.ChiTietKhuyenMai_DAO;
//import DAO.HoaDon_DAO;
//import Entity.ChiTietHoaDon;
//import Entity.ChiTietKhuyenMai;
//import Entity.HoaDon;
//import Entity.KhachHang;
//import Entity.KhuyenMai;
//import Entity.NhanVien;
//import Entity.SanPham;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;

public class XuatHoaDon_GUI extends JDialog {

	public XuatHoaDon_GUI() {

		initComponents();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		checkBanHang = false;

	}

	private ArrayList<Vector> dsGioHang;
	private double tongTien;
	private String nhanVien;
	private String khachHang;
	private String hoaDon;

	public void GUI_XuatHoaDon(ArrayList<Vector> dsGioHang, double tongTien, Object nhanVien, Object khachHang, String hoaDon) {
//        this();
        this.tongTien = tongTien;
        this.dsGioHang = dsGioHang;
        this.nhanVien = (String) nhanVien;
        this.khachHang = (String) khachHang;
        this.hoaDon = hoaDon;
        DecimalFormat dcf = new DecimalFormat("###,###");
        txtTongTien.setText(dcf.format(tongTien));
        txtTenKhach.setText((String) khachHang);
    }

	private void initComponents() {

		jLabel5 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		btnThanhToan = new javax.swing.JButton();
		btnInHoaDon = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtHoaDon = new javax.swing.JEditorPane();
		txtTenKhach = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		txtMaGiam = new javax.swing.JTextField();
		btnTimMaGiam = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		txtTongTien = new javax.swing.JTextField();
		jPanel3 = new javax.swing.JPanel();

		jLabel5.setText("jLabel5");

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
		jLabel1.setForeground(new Color(255, 0, 0));
		jLabel1.setText("Chi tiết hoá đơn");
		jPanel1.add(jLabel1);

		btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		btnThanhToan.setText("Thanh toán");
		btnThanhToan.setPreferredSize(new java.awt.Dimension(128, 45));
		btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThanhToanActionPerformed(evt);
			}
		});
		jPanel2.add(btnThanhToan);

		btnInHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		btnInHoaDon.setText("In hoá đơn");
		btnInHoaDon.setEnabled(false);
		btnInHoaDon.setPreferredSize(new java.awt.Dimension(128, 45));
		btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnInHoaDonActionPerformed(evt);
			}
		});
		jPanel2.add(btnInHoaDon);

		txtHoaDon.setEditable(false);
		jScrollPane1.setViewportView(txtHoaDon);

		txtTenKhach.setEditable(false);
		txtTenKhach.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel2.setText("Khách hàng");

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel3.setText("Mã giảm");

		txtMaGiam.setEditable(false);
		txtMaGiam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

		btnTimMaGiam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		btnTimMaGiam.setText("...");
		btnTimMaGiam.setPreferredSize(new java.awt.Dimension(40, 28));
		btnTimMaGiam.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTimMaGiamActionPerformed(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel4.setText("Tổng tiền");

		txtTongTien.setEditable(false);
		txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(31, 31, 31)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel4).addComponent(jLabel3))
										.addGap(40, 40, 40))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addContainerGap().addComponent(jLabel2)
												.addGap(18, 18, 18)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
								.addComponent(txtTenKhach).addComponent(txtMaGiam))
						.addGap(18, 18, 18)
						.addComponent(btnTimMaGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtMaGiam, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTimMaGiam, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
						.addGap(38, 38, 38)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public static boolean checkBanHang = false;

	private void btnTimMaGiamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTimMaGiamActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnTimMaGiamActionPerformed

	private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {
		checkBanHang = false;
		xuLyHienThiHoaDon();
		btnInHoaDon.setEnabled(true);
		String[] parts = khachHang.split("-");
		String kh = "";
		if (parts.length > 0) {
			kh = parts[0].trim(); // Lấy phần tử đầu tiên và loại bỏ khoảng trắng
		}
//		luuHoaDon(hoaDon, LocalDate.now(), kh, nhanVien);
		for (Vector vec : dsGioHang) {
			String maSP = vec.get(0) + "";
			int sl = Integer.parseInt(vec.get(3) + "");
			double dg = Double.parseDouble(vec.get(4) + "");
//			luuCTHoaDon(hoaDon, maSP, sl, dg);
		}
		btnThanhToan.setEnabled(false);
		checkBanHang = true;
	}

	private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			if (!txtHoaDon.getText().equals("")) {
				txtHoaDon.print();
				this.dispose();
			}
		} catch (PrinterException ex) {
		}
	}

	private void btnTimKhachActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void xuLyHienThiHoaDon() {
		txtHoaDon.setContentType("text/html");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		DecimalFormat dcf = new DecimalFormat("###,### VND");
//		ChiTietKhuyenMai_DAO cTKMDao = new ChiTietKhuyenMai_DAO();
//		ChiTietKhuyenMai_DAO chiTietKhuyenMaiDAO = new ChiTietKhuyenMai_DAO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		double tongTien = 0;
		String hd = "<style> " + "table {" + "border: 1px solid;" + "border-bottom: none" + "}" + "tr {"
				+ "border-bottom: 1px solid;" + "}" + "td {" + "padding: 8px;" + "} " + "th {" + "font-size:16pt" + "}"
				+ "</style>";
		hd += "<h1 style='text-align:center;'>HOÁ ĐƠN THANH TOÁN</h1>";
		hd += "Mã hóa đơn: " + hoaDon + "<br/>";
		hd += "Nhân viên: " + nhanVien + "<br/>";
		hd += "Ngày lập: " + dtf.format(now) + "<br/>";
		hd += "Khách hàng: " + txtTenKhach.getText() + "<br/>";
		hd += "<div style='text-align:center;'>==========================================</div><br/>";
		hd += "<div style='text-align:center'>";
		hd += "<table style='max-width:100%'>";
		hd += "<tr>" + "<th>Mã SP</th>" + "<th>Tên SP</th>" + "<th>Số lượng</th>" + "<th>Đơn giá</th>"
				+ "<th>Khuyến Mãi</th>" + "<th>Thành tiền</th>" + "</tr>";
		for (Vector vec : dsGioHang) {
			String maSP = vec.get(0).toString();
			double gia = Double.parseDouble(vec.get(4).toString());
			int soLg = Integer.parseInt(vec.get(3).toString());
			double thanhTien = 0;
//			KhuyenMai kMai = chiTietKhuyenMaiDAO.getKhuyenMaiByMaSP(maSP);
			double discountAmount = 0.0;
//
//			if (kMai != null) {
//				LocalDate currentDate = LocalDate.now();
//				if (!currentDate.isBefore(kMai.getNgayBatDau()) && !currentDate.isAfter(kMai.getNgayKetThuc())) {
//					if (kMai.getlGG().getTenLoaiGG().equals("Giảm giá theo %")) {
//						discountAmount = gia * (kMai.getGiaTriGiam() / 100.0);
//					} else if (kMai.getlGG().getTenLoaiGG().equals("Giảm giá theo số tiền")) {
//						discountAmount = kMai.getGiaTriGiam();
//					}
//					// Calculate the total price with discount
//					thanhTien = (gia - discountAmount) * soLg;
//					tongTien += thanhTien;
//				} else {
//					// Promotion dates are not valid or not in the active period, no discount
//					thanhTien = gia * soLg;
//					tongTien += thanhTien;
//				}
//			} else {
				// No promotion found, no discount
				thanhTien = gia * soLg;
				tongTien += thanhTien;
			}

			// Thêm thông tin sản phẩm vào hóa đơn
//			hd += "<tr>";
//			hd += "<td style='text-align:center;'>" + maSP + "</td>";
//			hd += "<td style='text-align:left;'>" + vec.get(1) + "</td>";
//			hd += "<td style='text-align:center;'>" + soLg + "</td>";
//			hd += "<td style='text-align:center;'>" + dcf.format(gia) + "</td>"; // Use 'price' variable here
//			hd += "<td style='text-align:center;'>" + dcf.format(discountAmount) + "</td>"; // Use 'discountAmount'
//																							// variable here
//			hd += "<td style='text-align:center;'>" + dcf.format(thanhTien) + "</td>"; // Use 'lineTotal' variable here
//			hd += "</tr>";
//		}
		hd += "<tr>";
		hd += "<td style='text-align:center;'>" + "</td>";
		hd += "<td style='text-align:left;'>" + "</td>";
		hd += "<td style='text-align:center;'>" + "</td>";
		hd += "<td style='text-align:center;font-weight:bold'>Thành tiền</td>";
		hd += "<td style='text-align:center;'>" + dcf.format(tongTien) + "</td>";
		hd += "</tr>";
		hd += "</table>";
		hd += "</div>";
		hd += "<div style='text-align:center;'>==========================================</div><br/>";
		txtHoaDon.setText(hd);
		txtTongTien.setText(dcf.format(tongTien));
	}

//	public void luuHoaDon(String maHD, LocalDate ngayTao, String maKh, String maNV) {
//		HoaDon hd = new HoaDon();
//		hd.setMaHD(maHD);
//		hd.setNgayTao(ngayTao);
//		hd.setMaKh(new KhachHang(maKh));
//		hd.setMaNV(new NhanVien(nhanVien));
//		HoaDon_DAO hdd = new HoaDon_DAO();
//		hdd.themHD(hd);
//	}

//	public void luuCTHoaDon(String maHD, String maSP, int soLuong, double donGia) {
//		ChiTietHoaDon cthd = new ChiTietHoaDon();
//		cthd.setMaHD(new HoaDon(maHD));
//		cthd.setMaSP(new SanPham(maSP));
//		cthd.setSoLuong(soLuong);
//		cthd.setDonGia(donGia);
//		ChiTietHoaDon_DAO dao = new ChiTietHoaDon_DAO();
//		dao.themHD(cthd);
//	}
//
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnInHoaDon;
	private javax.swing.JButton btnThanhToan;
	private javax.swing.JButton btnTimMaGiam;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JEditorPane txtHoaDon;
	private javax.swing.JTextField txtMaGiam;
	private javax.swing.JTextField txtTenKhach;
	private javax.swing.JTextField txtTongTien;
	// End of variables declaration//GEN-END:variables
}
