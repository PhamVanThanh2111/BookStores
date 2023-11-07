package entity;

public class Ca {
	private String maCa;
	private String tenCa;
	private String thoiGian;
	public Ca(String maCa, String tenCa, String thoiGian) {
		super();
		this.maCa = maCa;
		this.tenCa = tenCa;
		this.thoiGian = thoiGian;
	}
	public Ca() {
		super();
	}
	public String getMaCa() {
		return maCa;
	}
	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}
	public String getTenCa() {
		return tenCa;
	}
	public void setTenCa(String tenCa) {
		this.tenCa = tenCa;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	@Override
	public String toString() {
		return "Ca [maCa=" + maCa + ", tenCa=" + tenCa + ", thoiGian=" + thoiGian + "]";
	}
}
