package entity;

import java.util.Objects;

public class DungCuHocTapTonKho {
	private CuaHang maCuaHang;
	private DungCuHocTap maDCHT;
	private int soLuong;
	public DungCuHocTapTonKho() {
		super();
	}
	public DungCuHocTapTonKho(CuaHang maCuaHang) {
		super();
		this.maCuaHang = maCuaHang;
	}
	public DungCuHocTapTonKho(CuaHang maCuaHang, DungCuHocTap maDCHT, int soLuong) {
		super();
		this.maCuaHang = maCuaHang;
		this.maDCHT = maDCHT;
		this.soLuong = soLuong;
	}
	public CuaHang getMaCuaHang() {
		return maCuaHang;
	}
	public void setMaCuaHang(CuaHang maCuaHang) {
		this.maCuaHang = maCuaHang;
	}
	public DungCuHocTap getMaDCHT() {
		return maDCHT;
	}
	public void setMaDCHT(DungCuHocTap maDCHT) {
		this.maDCHT = maDCHT;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maCuaHang, maDCHT, soLuong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DungCuHocTapTonKho other = (DungCuHocTapTonKho) obj;
		return Objects.equals(maCuaHang, other.maCuaHang) && Objects.equals(maDCHT, other.maDCHT)
				&& soLuong == other.soLuong;
	}
	@Override
	public String toString() {
		return "DungCuHocTapTonKho [maCuaHang=" + maCuaHang + ", maDCHT=" + maDCHT + ", soLuong=" + soLuong + "]";
	}
	
	
}
