package entity;

public class DungCuHocTapTonKho {
	private DungCuHocTap maDCHT;
	private int soLuong;

	public DungCuHocTapTonKho() {
		super();
	}

	public DungCuHocTapTonKho(DungCuHocTap maDCHT, int soLuong) {
		super();
		this.maDCHT = maDCHT;
		this.soLuong = soLuong;
	}

	public DungCuHocTap getMaDCHT() {
		return maDCHT;
	}

	public void setMaDCHT(DungCuHocTap maDCHT) {
		this.maDCHT = maDCHT;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "DungCuHocTapTonKho [maDCHT=" + maDCHT + ", soLuong=" + soLuong + "]";
	}

}
