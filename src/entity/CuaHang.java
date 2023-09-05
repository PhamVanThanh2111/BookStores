package entity;

import java.util.Objects;

public class CuaHang {
	private String maCH;
	private String tenCuaHang;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private int soLuongNV;
	private String gioHD;
	public CuaHang() {
		super();
	}
	
	public CuaHang(String maCH) {
		super();
		this.maCH = maCH;
	}

	public CuaHang(String maCH, String tenCuaHang, String diaChi, String soDienThoai, String email,int soLuongNV,String gioHD) {
		super();
		this.maCH = maCH;
		this.tenCuaHang = tenCuaHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.soLuongNV = soLuongNV;
		this.gioHD = gioHD;
	}
	public String getMaCH() {
		return maCH;
	}
	public void setMaCH(String maCH) {
		this.maCH = maCH;
	}
	public String getTenCuaHang() {
		return tenCuaHang;
	}
	public void setTenCuaHang(String tenCuaHang) {
		this.tenCuaHang = tenCuaHang;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getSoLuongNV() {
		return soLuongNV;
	}

	public void setSoLuongNV(int soLuongNV) {
		this.soLuongNV = soLuongNV;
	}

	public String getGioHD() {
		return gioHD;
	}

	public void setGioHD(String gioHD) {
		this.gioHD = gioHD;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, maCH, soDienThoai, tenCuaHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuaHang other = (CuaHang) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(maCH, other.maCH) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenCuaHang, other.tenCuaHang);
	}

	@Override
	public String toString() {
		return "CuaHang [maCH=" + maCH + ", tenCuaHang=" + tenCuaHang + ", diaChi=" + diaChi + ", soDienThoai="
				+ soDienThoai + ", email=" + email +", soLuongNV = "+ soLuongNV+", gioHD"+gioHD + "]";
	}
	
	
}	
