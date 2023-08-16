package entity;

import java.util.Date;

public class Sach {
	
	private String maSach;
	private String maNXB;
	private String maLoaiSach;
	private String tenSach;
	private String xuatXu;
	private double gia;
	
	
	
	public Sach() {
		
	}
	public Sach(String maSach, String maNXB, String maLoaiSach, String tenSach, String xuatXu, double gia) {
		super();
		this.maSach = maSach;
		this.maNXB = maNXB;
		this.maLoaiSach = maLoaiSach;
		this.tenSach = tenSach;
		this.xuatXu = xuatXu;
		this.gia = gia;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(String maNXB) {
		this.maNXB = maNXB;
	}
	public String getMaLoaiSach() {
		return maLoaiSach;
	}
	public void setMaLoaiSach(String maLoaiSach) {
		this.maLoaiSach = maLoaiSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", maNXB=" + maNXB + ", maLoaiSach=" + maLoaiSach + ", tenSach=" + tenSach
				+ ", xuatXu=" + xuatXu + ", gia=" + gia + "]";
	}
	
	
	
	

}