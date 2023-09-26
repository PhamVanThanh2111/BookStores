package entity;

import java.util.Objects;

public class Sach {

	private String maSach;
	private String maNXB;
	private String maLoaiSach;
	private String tenSach;
	private String xuatXu;
	private long giaNhap;
	private String tacGia;
	private int soTrang;
	private long gia;
	private int soLuong;
	private String hinhAnh;

	public Sach() {
		super();
	}

	public Sach(String maSach) {
		super();
		this.maSach = maSach;
	}

	public Sach(String maSach, String maNXB, String maLoaiSach, String tenSach, String xuatXu, long giaNhap,
			String tacGia, int soTrang, long gia, int soLuong, String hinhAnh) {
		super();
		this.maSach = maSach;
		this.maNXB = maNXB;
		this.maLoaiSach = maLoaiSach;
		this.tenSach = tenSach;
		this.xuatXu = xuatXu;
		this.giaNhap = giaNhap;
		this.tacGia = tacGia;
		this.soTrang = soTrang;
		this.gia = gia;
		this.soLuong = soLuong;
		this.hinhAnh = hinhAnh;
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

	public long getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(long giaNhap) {
		this.giaNhap = giaNhap;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", maNXB=" + maNXB + ", maLoaiSach=" + maLoaiSach + ", tenSach=" + tenSach
				+ ", xuatXu=" + xuatXu + ", giaNhap=" + giaNhap + ", tacGia=" + tacGia + ", soTrang=" + soTrang
				+ ", gia=" + gia + ", soLuong=" + soLuong + ", hinhAnh=" + hinhAnh + "]";
	}

	
}