package entity;

public class ChiTietHoaDon {
	private HoaDon maHD;
	private Sach maSach;
	private int soLuong;
	private int thanhTien;
	public ChiTietHoaDon() {
		super();
	}
	public ChiTietHoaDon(HoaDon maHD, Sach maSach, int soLuong, int thanhTien) {
		super();
		this.maHD = maHD;
		this.maSach = maSach;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	public HoaDon getMaHD() {
		return maHD;
	}
	public void setMaHD(HoaDon maHD) {
		this.maHD = maHD;
	}
	public Sach getMaSach() {
		return maSach;
	}
	public void setMaSach(Sach maSach) {
		this.maSach = maSach;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [maHD=" + maHD + ", maSach=" + maSach + ", soLuong=" + soLuong + ", thanhTien="
				+ thanhTien + "]";
	}
	
	
}
