package entity;

import java.util.Objects;

public class SachTonKho {
	private CuaHang maCH;
	private Sach maSach;
	private int soLuong;
	
	
	public SachTonKho() {
		super();
	}
	
	public SachTonKho(CuaHang maCH) {
		super();
		this.maCH = maCH;
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
	public int hashCode() {
		return Objects.hash(maCH, maSach, soLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SachTonKho other = (SachTonKho) obj;
		return Objects.equals(maCH, other.maCH) && Objects.equals(maSach, other.maSach) && soLuong == other.soLuong;
	}

	@Override
	public String toString() {
		return "SachTonKho [maCH=" + maCH + ", maSach=" + maSach + ", soLuong=" + soLuong + "]";
	}

}
