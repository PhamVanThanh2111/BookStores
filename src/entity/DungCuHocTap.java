package entity;

import java.util.Objects;

public class DungCuHocTap {
	private String maDungCuHocTap;
	private String tenDungCuHocTap;
	private long gia;
	private String nhaCungCap;
	private int soLuong;
	private String hinhAnh;

	public DungCuHocTap() {
		super();
	}

	public DungCuHocTap(String maDungCuHocTap) {
		super();
		this.maDungCuHocTap = maDungCuHocTap;
	}

	public DungCuHocTap(String maDungCuHocTap, String tenDungCuHocTap, long gia, String nhaCungCap, int soLuong, String hinhAnh) {
		super();
		this.maDungCuHocTap = maDungCuHocTap;
		this.tenDungCuHocTap = tenDungCuHocTap;
		this.gia = gia;
		this.nhaCungCap = nhaCungCap;
		this.soLuong = soLuong;
		this.hinhAnh = hinhAnh;
	}

	public String getMaDungCuHocTap() {
		return maDungCuHocTap;
	}

	public void setMaDungCuHocTap(String maDungCuHocTap) {
		this.maDungCuHocTap = maDungCuHocTap;
	}

	public String getTenDungCuHocTap() {
		return tenDungCuHocTap;
	}

	public void setTenDungCuHocTap(String tenDungCuHocTap) {
		this.tenDungCuHocTap = tenDungCuHocTap;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(hinhAnh, maDungCuHocTap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DungCuHocTap other = (DungCuHocTap) obj;
		return Objects.equals(hinhAnh, other.hinhAnh) && Objects.equals(maDungCuHocTap, other.maDungCuHocTap);
	}

	@Override
	public String toString() {
		return "DungCuHocTap [maDungCuHocTap=" + maDungCuHocTap + ", tenDungCuHocTap=" + tenDungCuHocTap + ", gia="
				+ gia + ", nhaCungCap=" + nhaCungCap + ", soLuong=" + soLuong + ", hinhAnh=" + hinhAnh + "]";
	}
	
}
