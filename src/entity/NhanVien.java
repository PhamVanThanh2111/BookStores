package entity;

import java.util.Date;

public class NhanVien {
	 private String maNV;
	    private String tenNV;
		private int tuoi;
		private String diaChi;
	    private String gioiTinh;
	    private Date ngaySinh;
	    private Date ngayVaoLam;
	    private String CCCD;
	    private String email;
	    private String soDienThoai;
	    private	String chucVu;
	    private TaiKhoan taiKhoan;
	    private String maCH;
		public NhanVien() {
			super();
		}
		public NhanVien(String maNV, String tenNV, int tuoi, String diaChi, String gioiTinh, Date ngaySinh,
				Date ngayVaoLam, String cCCD, String email, String soDienThoai, String chucVu, TaiKhoan taiKhoan,
				String maCH) {
			super();
			this.maNV = maNV;
			this.tenNV = tenNV;
			this.tuoi = tuoi;
			this.diaChi = diaChi;
			this.gioiTinh = gioiTinh;
			this.ngaySinh = ngaySinh;
			this.ngayVaoLam = ngayVaoLam;
			CCCD = cCCD;
			this.email = email;
			this.soDienThoai = soDienThoai;
			this.chucVu = chucVu;
			this.taiKhoan = taiKhoan;
			this.maCH = maCH;
		}
		public String getMaNV() {
			return maNV;
		}
		public void setMaNV(String maNV) {
			this.maNV = maNV;
		}
		public String getTenNV() {
			return tenNV;
		}
		public void setTenNV(String tenNV) {
			this.tenNV = tenNV;
		}
		public int getTuoi() {
			return tuoi;
		}
		public void setTuoi(int tuoi) {
			this.tuoi = tuoi;
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
		public Date getNgaySinh() {
			return ngaySinh;
		}
		public void setNgaySinh(Date ngaySinh) {
			this.ngaySinh = ngaySinh;
		}
		public Date getNgayVaoLam() {
			return ngayVaoLam;
		}
		public void setNgayVaoLam(Date ngayVaoLam) {
			this.ngayVaoLam = ngayVaoLam;
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
		public String getMaCH() {
			return maCH;
		}
		public void setMaCH(String maCH) {
			this.maCH = maCH;
		}
		@Override
		public String toString() {
			return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", tuoi=" + tuoi + ", diaChi=" + diaChi
					+ ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", ngayVaoLam=" + ngayVaoLam + ", CCCD="
					+ CCCD + ", email=" + email + ", soDienThoai=" + soDienThoai + ", chucVu=" + chucVu + ", taiKhoan="
					+ taiKhoan + ", maCH=" + maCH + "]";
		}   
}
