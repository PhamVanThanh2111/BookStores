package entity;

import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private int tuoi;
	private String gioiTinh;
	private String CCCD;
	private String email;
	private String soDienThoai;
	private String diaChi;

	public KhachHang() {
		super();
	}

	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}

	public KhachHang(String maKH, String tenKH, int tuoi, String gioiTinh, String cCCD, String email,
			String soDienThoai, String diaChi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		CCCD = cCCD;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CCCD, diaChi, email, gioiTinh, maKH, soDienThoai, tenKH, tuoi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(CCCD, other.CCCD) && Objects.equals(diaChi, other.diaChi)
				&& Objects.equals(email, other.email) && Objects.equals(gioiTinh, other.gioiTinh)
				&& Objects.equals(maKH, other.maKH) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenKH, other.tenKH) && tuoi == other.tuoi;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", CCCD="
				+ CCCD + ", email=" + email + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + "]";
	}

}
