package entity;

import java.util.Objects;

public class DungCuHocTap {
	private String maDCHT;
	private String tenDCHT;
	private double gia;
	private String nhaCungCap;
	public DungCuHocTap() {
		super();
	}
	public DungCuHocTap(String maDCHT) {
		super();
		this.maDCHT = maDCHT;
	}
	public DungCuHocTap(String maDCHT, String tenDCHT, double gia, String nhaCungCap) {
		super();
		this.maDCHT = maDCHT;
		this.tenDCHT = tenDCHT;
		this.gia = gia;
		this.nhaCungCap = nhaCungCap;
	}
	public String getMaDCHT() {
		return maDCHT;
	}
	public void setMaDCHT(String maDCHT) {
		this.maDCHT = maDCHT;
	}
	public String getTenDCHT() {
		return tenDCHT;
	}
	public void setTenDCHT(String tenDCHT) {
		this.tenDCHT = tenDCHT;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	@Override
	public int hashCode() {
		return Objects.hash(gia, maDCHT, nhaCungCap, tenDCHT);
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
		return Double.doubleToLongBits(gia) == Double.doubleToLongBits(other.gia)
				&& Objects.equals(maDCHT, other.maDCHT) && Objects.equals(nhaCungCap, other.nhaCungCap)
				&& Objects.equals(tenDCHT, other.tenDCHT);
	}
	@Override
	public String toString() {
		return "DungCuHocTap [maDCHT=" + maDCHT + ", tenDCHT=" + tenDCHT + ", gia=" + gia + ", nhaCungCap=" + nhaCungCap
				+ "]";
	}
	
	

}
