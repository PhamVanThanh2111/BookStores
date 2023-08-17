package entity;

public class CuaHang {
	private String maCH;
	private String tenCuaHang;
	private String diaChi;
	private String soDienThoai;
	private String email;
	public CuaHang() {
		super();
	}
	public CuaHang(String maCH, String tenCuaHang, String diaChi, String soDienThoai, String email) {
		super();
		this.maCH = maCH;
		this.tenCuaHang = tenCuaHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
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
	@Override
	public String toString() {
		return "CuaHang [maCH=" + maCH + ", tenCuaHang=" + tenCuaHang + ", diaChi=" + diaChi + ", soDienThoai="
				+ soDienThoai + ", email=" + email + "]";
	}
	
	
}	
