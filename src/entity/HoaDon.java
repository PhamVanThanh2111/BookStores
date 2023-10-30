package entity;

import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private String maNhanVien;
	private String maKhachHang;
	private java.sql.Date ngayLap;
	private float thanhTien;

	public HoaDon() {
		super();
	}

	public HoaDon(String maHoaDon, String maNhanVien, String maKhachHang, java.sql.Date ngayLap,
			long thanhTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.maNhanVien = maNhanVien;
		this.maKhachHang = maKhachHang;
		this.ngayLap = ngayLap;
		this.thanhTien = thanhTien;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
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
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maNhanVien=" + maNhanVien + ", maKhachHang=" + maKhachHang
				+ ", ngayLap=" + ngayLap + ", thanhTien=" + thanhTien + "]";
	}
	
}
