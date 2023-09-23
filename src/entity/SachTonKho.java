package entity;

public class SachTonKho {
	private Sach maSach;
	private int soLuong;

	public SachTonKho() {
		super();
	}

	public SachTonKho(Sach maSach, int soLuong) {
		super();
		this.maSach = maSach;
		this.soLuong = soLuong;
	}

	public Sach getMaSach() {
		return maSach;
	}

	public void setMaSach(Sach maSach) {
		this.maSach = maSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "SachTonKho [maSach=" + maSach + ", soLuong=" + soLuong + "]";
	}
}
