package entity;

import java.util.Date;

public class HoaDon {
	private String maHD;
	private Date ngayXuatHD;
	private KhachHang maKH;
	private NhanVien maNV;

	public HoaDon() {
		super();
	}

	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}

	public HoaDon(String maHD, Date ngayXuatHD, KhachHang maKH, NhanVien maNV) {
		super();
		this.maHD = maHD;
		this.ngayXuatHD = ngayXuatHD;
		this.maKH = maKH;
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

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayXuatHD=" + ngayXuatHD + ", maKH=" + maKH + ", maNV=" + maNV + "]";
	}

}
