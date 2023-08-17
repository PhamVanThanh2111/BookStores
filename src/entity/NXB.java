package entity;

public class NXB {
	private String maNXB;
	private String tenNXB;
	private String diaChi;
	private String soDienThoai;
	private String email;
	public NXB() {
		super();
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
	public String toString() {
		return "NXB [maNXB=" + maNXB + ", tenNXB=" + tenNXB + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + "]";
	}
	
	
}
