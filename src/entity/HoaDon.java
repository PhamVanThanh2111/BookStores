package entity;

import java.util.Date;
public class HoaDon {
	private String maHD;
	private Date ngayXuatHD;
	private KhachHang maKH;
	private CuaHang maCH;
	private NhanVien maNV;
	public HoaDon() {
		super();
	}
	public HoaDon(String maHD, Date ngayXuatHD, KhachHang maKH, CuaHang maCH, NhanVien maNV) {
		super();
		this.maHD = maHD;
		this.ngayXuatHD = ngayXuatHD;
		this.maKH = maKH;
		this.maCH = maCH;
		this.maNV = maNV;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgayXuatHD() {
		return ngayXuatHD;
	}
	public void setNgayXuatHD(Date ngayXuatHD) {
		this.ngayXuatHD = ngayXuatHD;
	}
	public KhachHang getMaKH() {
		return maKH;
	}
	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}
	public CuaHang getMaCH() {
		return maCH;
	}
	public void setMaCH(CuaHang maCH) {
		this.maCH = maCH;
	}
	public NhanVien getMaNV() {
		return maNV;
	}
	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayXuatHD=" + ngayXuatHD + ", maKH=" + maKH + ", maCH=" + maCH + ", maNV="
				+ maNV + "]";
	}
	
	
}
