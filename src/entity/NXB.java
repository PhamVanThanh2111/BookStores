package entity;

import java.util.Objects;

public class NXB {
	private String maNXB;
	private String tenNXB;
	private String diaChi;
	private String soDienThoai;
	private String email;
	public NXB() {
		super();
	}
	
	public NXB(String maNXB) {
		super();
		this.maNXB = maNXB;
	}

	public NXB(String maNXB, String tenNXB, String diaChi, String soDienThoai, String email) {
		super();
		this.maNXB = maNXB;
		this.tenNXB = tenNXB;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}
	public String getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(String maNXB) {
		this.maNXB = maNXB;
	}
	public String getTenNXB() {
		return tenNXB;
	}
	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(diaChi, email, maNXB, soDienThoai, tenNXB);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NXB other = (NXB) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(maNXB, other.maNXB) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenNXB, other.tenNXB);
	}

	@Override
	public String toString() {
		return "NXB [maNXB=" + maNXB + ", tenNXB=" + tenNXB + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + "]";
	}
	
	
}
