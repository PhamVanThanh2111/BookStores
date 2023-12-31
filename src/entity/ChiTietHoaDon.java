package entity;

public class ChiTietHoaDon {
	private String maHoaDon;
	private String maSanPham;
	private int soLuong;
	private float donGia;

	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(String maHoaDon, String maSanPham, int soLuong, long donGia) {
		super();
		this.maHoaDon = maHoaDon;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	
	@Override
	public String toString() {
		return "ChiTietHoaDon [maHoaDon=" + maHoaDon + ", maSanPham=" + maSanPham + ", soLuong=" + soLuong + ", donGia="
				+ donGia + "]";
	}
	
	
}
