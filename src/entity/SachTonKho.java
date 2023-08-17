package entity;

public class SachTonKho {
	private CuaHang maCH;
	private Sach maSach;
	private int soLuong;
	
	
	public SachTonKho() {
		super();
	}
	public SachTonKho(CuaHang maCH, Sach maSach, int soLuong) {
		super();
		this.maCH = maCH;
		this.maSach = maSach;
		this.soLuong = soLuong;
	}
	public CuaHang getMaCH() {
		return maCH;
	}
	public void setMaCH(CuaHang maCH) {
		this.maCH = maCH;
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
	@Override
	public String toString() {
		return "SachTonKho [maCH=" + maCH + ", maSach=" + maSach + ", soLuong=" + soLuong + "]";
	}

}
