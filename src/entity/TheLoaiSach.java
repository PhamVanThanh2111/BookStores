package entity;

import java.util.Objects;

public class TheLoaiSach {
	private String maTheLoaiSach;
	private String tenTheLoaiSach;

	public TheLoaiSach() {
		super();
	}

	public TheLoaiSach(String maTheLoaiSach) {
		super();
		this.maTheLoaiSach = maTheLoaiSach;
	}

	public TheLoaiSach(String maTheLoaiSach, String tenTheLoaiSach) {
		super();
		this.maTheLoaiSach = maTheLoaiSach;
		this.tenTheLoaiSach = tenTheLoaiSach;
	}

	public String getmaTheLoaiSach() {
		return maTheLoaiSach;
	}

	public void setmaTheLoaiSach(String maTheLoaiSach) {
		this.maTheLoaiSach = maTheLoaiSach;
	}

	public String gettenTheLoaiSach() {
		return tenTheLoaiSach;
	}

	public void settenTheLoaiSach(String tenTheLoaiSach) {
		this.tenTheLoaiSach = tenTheLoaiSach;
	}

	@Override
	public String toString() {
		return "LoaiSach [maTheLoaiSach=" + maTheLoaiSach + ", tenTheLoaiSach=" + tenTheLoaiSach + "]";
	}

}
