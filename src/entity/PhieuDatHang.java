package entity;

import java.sql.Date;
import java.util.Objects;

public class PhieuDatHang {
	private String maPhieuDatHang;
	private String maNhanVien;
	private String maKhachHang;
	private java.sql.Date ngayLap;
	private float thanhTien;
	
	public PhieuDatHang() {
		super();
	}
	
	public PhieuDatHang(String maPhieuDatHang, String maNhanVien, String maKhachHang, Date ngayLap, float thanhTien) {
		super();
		this.maPhieuDatHang = maPhieuDatHang;
		this.maNhanVien = maNhanVien;
		this.maKhachHang = maKhachHang;
		this.ngayLap = ngayLap;
		this.thanhTien = thanhTien;
	}
	
	public String getMaPhieuDatHang() {
		return maPhieuDatHang;
	}
	
	public void setMaPhieuDatHang(String maPhieuDatHang) {
		this.maPhieuDatHang = maPhieuDatHang;
	}
	
	public String getMaNhanVien() {
		return maNhanVien;
	}
	
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	
	public String getMaKhachHang() {
		return maKhachHang;
	}
	
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	
	public java.sql.Date getNgayLap() {
		return ngayLap;
	}
	
	public void setNgayLap(java.sql.Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	
	public float getThanhTien() {
		return thanhTien;
	}
	
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDatHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDatHang other = (PhieuDatHang) obj;
		return Objects.equals(maPhieuDatHang, other.maPhieuDatHang);
	}

	@Override
	public String toString() {
		return "PhieuDatHang [maPhieuDatHang=" + maPhieuDatHang + ", maNhanVien=" + maNhanVien + ", maKhachHang=" + maKhachHang
				+ ", ngayLap=" + ngayLap + ", thanhTien=" + thanhTien + "]";
	}
	
	
}
