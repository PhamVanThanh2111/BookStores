package entity;

import java.sql.Date;
import java.util.Objects;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String diaChi;
	private String gioiTinh;
	private java.sql.Date ngaySinh;
	private java.sql.Date ngayVaoLam;
	private String cCCD;
	private String email;
	private String soDienThoai;
	private String chucVu;
	private TaiKhoan taiKhoan;
	private long luong;
	private int ca;
	private String hinhAnh;

	public NhanVien() {
		super();
	}

	public NhanVien(String maNV) {
		super();
		this.maNhanVien = maNV;
	}

	public NhanVien(String maNV, String tenNV, String diaChi, String gioiTinh, Date ngaySinh, Date ngayVaoLam,
			String cCCD, String email, String soDienThoai, String chucVu, TaiKhoan taiKhoan, long luong, int ca, String hinhAnh) {
		super();
		this.maNhanVien = maNV;
		this.tenNhanVien = tenNV;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
		this.cCCD = cCCD;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.chucVu = chucVu;
		this.taiKhoan = taiKhoan;
		this.luong = luong;
		this.ca = ca;
		this.hinhAnh = hinhAnh;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public java.sql.Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(java.sql.Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public java.sql.Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(java.sql.Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
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

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public long getLuong() {
		return luong;
	}

	public void setLuong(long luong) {
		this.luong = luong;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	
	public String getcCCD() {
		return cCCD;
	}

	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}

	public int getCa() {
		return ca;
	}

	public void setCa(int ca) {
		this.ca = ca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cCCD, email, hinhAnh, maNhanVien, soDienThoai, taiKhoan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(cCCD, other.cCCD) && Objects.equals(email, other.email)
				&& Objects.equals(hinhAnh, other.hinhAnh) && Objects.equals(maNhanVien, other.maNhanVien)
				&& Objects.equals(soDienThoai, other.soDienThoai) && Objects.equals(taiKhoan, other.taiKhoan);
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", diaChi=" + diaChi
				+ ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", ngayVaoLam=" + ngayVaoLam + ", cCCD=" + cCCD
				+ ", email=" + email + ", soDienThoai=" + soDienThoai + ", chucVu=" + chucVu + ", taiKhoan=" + taiKhoan
				+ ", luong=" + luong + ", ca=" + ca + ", hinhAnh=" + hinhAnh + "]";
	}
	

}
