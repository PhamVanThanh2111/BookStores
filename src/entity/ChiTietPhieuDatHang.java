package entity;

public class ChiTietPhieuDatHang {
	private String maPhieuDatHang;
	private String maSanPham;
	private int soLuong;
	private float donGia;

	public ChiTietPhieuDatHang() {
		super();
	}

	public ChiTietPhieuDatHang(String maPhieuDatHang, String maSanPham, int soLuong, long donGia) {
		super();
		this.maPhieuDatHang = maPhieuDatHang;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public String getMaPhieuDatHang() {
		return maPhieuDatHang;
	}

	public void setMaPhieuDatHang(String maPhieuDatHang) {
		this.maPhieuDatHang = maPhieuDatHang;
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
		return "ChiTietPhieuDatHang [maPhieuDatHang=" + maPhieuDatHang + ", maSanPham=" + maSanPham + ", soLuong=" + soLuong + ", donGia="
				+ donGia + "]";
	}

}
