package entity;

import java.util.Objects;

public class TheLoaiSach {
	private String maLoaiSach;
	private String tenLoaiSach;

	public TheLoaiSach() {
		super();
	}

	public TheLoaiSach(String maLoaiSach) {
		super();
		this.maLoaiSach = maLoaiSach;
	}

	public TheLoaiSach(String maLoaiSach, String tenLoaiSach) {
		super();
		this.maLoaiSach = maLoaiSach;
		this.tenLoaiSach = tenLoaiSach;
	}

	public String getMaLoaiSach() {
		return maLoaiSach;
	}

	public void setMaLoaiSach(String maLoaiSach) {
		this.maLoaiSach = maLoaiSach;
	}

	public String getTenLoaiSach() {
		return tenLoaiSach;
	}

	public void setTenLoaiSach(String tenLoaiSach) {
		this.tenLoaiSach = tenLoaiSach;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiSach, tenLoaiSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheLoaiSach other = (TheLoaiSach) obj;
		return Objects.equals(maLoaiSach, other.maLoaiSach) && Objects.equals(tenLoaiSach, other.tenLoaiSach);
	}

	@Override
	public String toString() {
		return "LoaiSach [maLoaiSach=" + maLoaiSach + ", tenLoaiSach=" + tenLoaiSach + "]";
	}

}
