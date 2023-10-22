package entity;

import java.util.Objects;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private String xuatXu;
	private float giaNhap;
	private float giaBan;
	private int soLuongTon;
	private String hinhAnh;
	private String maNXB;
	private String maTheLoaiSach;
	private String tacGia;
	private String soTrang;
	private int namXuatBan;
	private String maNhaCungCap;
	
	
	public SanPham() {   
		super();
	}
	public SanPham(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}
	public SanPham(String maSanPham, String tenSanPham, String xuatXu, float giaNhap, float giaBan, int soLuongTon,
			String hinhAnh, String maNXB, String maTheLoaiSach, String tacGia, String soTrang, int namXuatBan,
			String maNhaCungCap) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.xuatXu = xuatXu;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuongTon = soLuongTon;
		this.hinhAnh = hinhAnh;
		this.maNXB = maNXB;
		this.maTheLoaiSach = maTheLoaiSach;
		this.tacGia = tacGia;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.maNhaCungCap = maNhaCungCap;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	public float getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(float giaNhap) {
		this.giaNhap = giaNhap;
	}
	public float getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(String maNXB) {
		this.maNXB = maNXB;
	}
	public String getMaTheLoaiSach() {
		return maTheLoaiSach;
	}
	public void setMaTheLoaiSach(String maTheLoaiSach) {
		this.maTheLoaiSach = maTheLoaiSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(String soTrang) {
		this.soTrang = soTrang;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	@Override
	public int hashCode() {
		return Objects.hash(giaBan, giaNhap, hinhAnh, maNXB, maNhaCungCap, maSanPham, maTheLoaiSach, namXuatBan,
				soLuongTon, soTrang, tacGia, tenSanPham, xuatXu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Float.floatToIntBits(giaBan) == Float.floatToIntBits(other.giaBan)
				&& Float.floatToIntBits(giaNhap) == Float.floatToIntBits(other.giaNhap)
				&& Objects.equals(hinhAnh, other.hinhAnh) && Objects.equals(maNXB, other.maNXB)
				&& Objects.equals(maNhaCungCap, other.maNhaCungCap) && Objects.equals(maSanPham, other.maSanPham)
				&& Objects.equals(maTheLoaiSach, other.maTheLoaiSach) && namXuatBan == other.namXuatBan
				&& soLuongTon == other.soLuongTon && Objects.equals(soTrang, other.soTrang)
				&& Objects.equals(tacGia, other.tacGia) && Objects.equals(tenSanPham, other.tenSanPham)
				&& Objects.equals(xuatXu, other.xuatXu);
	}
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", xuatXu=" + xuatXu + ", giaNhap="
				+ giaNhap + ", giaBan=" + giaBan + ", soLuongTon=" + soLuongTon + ", hinhAnh=" + hinhAnh + ", maNXB="
				+ maNXB + ", maTheLoaiSach=" + maTheLoaiSach + ", tacGia=" + tacGia + ", soTrang=" + soTrang
				+ ", namXuatBan=" + namXuatBan + ", maNhaCungCap=" + maNhaCungCap + "]";
	}
}	
