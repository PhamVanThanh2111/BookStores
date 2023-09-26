package entity;

public class ChiTietHoaDon {
	private String maHoaDon;
	private String maSach;
	private String maDungCuHocTap;
	private int soLuong;
	private long donGia;

	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(String maHoaDon, String maSach, String maDungCuHocTap, int soLuong, long donGia) {
		super();
		this.maHoaDon = maHoaDon;
		this.maSach = maSach;
		this.maDungCuHocTap = maDungCuHocTap;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getMaDungCuHocTap() {
		return maDungCuHocTap;
	}

	public void setMaDungCuHocTap(String maDungCuHocTap) {
		this.maDungCuHocTap = maDungCuHocTap;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public long getDonGia() {
		return donGia;
	}

	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}
	
	@Override
	public String toString() {
		return "ChiTietHoaDon [maHoaDon=" + maHoaDon + ", maSach=" + maSach + ", maDungCuHocTap=" + maDungCuHocTap
				+ ", soLuong=" + soLuong + ", donGia=" + donGia + "]";
	}
	
	
}
