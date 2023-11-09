package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connect.ConnectDB;

public class PhatSinhMa_DAO {

	// ma Nhan Vien
	public String getMaNhanVien() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select CONCAT('NV', RIGHT(CONCAT('0000',ISNULL(right(max(maNhanVien),4),0) + 1),4)) from [dbo].[NhanVien] where maNhanVien like 'NV%'");
		String maNV = "";
		while (resultSet.next()) {
			maNV = resultSet.getString(1);
		}
		return maNV;
	}

	// ma Hoa Don
	public String getMaHoaDon() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select CONCAT('HD', RIGHT(CONCAT('00000',ISNULL(right(max(maHoaDon),5),0) + 1),5)) from [dbo].[HoaDon] where maHoaDon like 'HD%'");
		String maHD = "";
		while (resultSet.next()) {
			maHD = resultSet.getString(1);
		}
		return maHD;
	}

	// ma The Loai Sach
	public String getMaTheLoaiSach() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select CONCAT('TL', RIGHT(CONCAT('0000',ISNULL(right(max(maTheLoaiSach),4),0) + 1),4)) from [dbo].[TheLoaiSach] where maTheLoaiSach like 'TL%'");
		String maTL = "";
		while (resultSet.next()) {
			maTL = resultSet.getString(1);
		}
		return maTL;
	}

	// ma Sach
	public String getMaSach() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select CONCAT('S', RIGHT(CONCAT('0000',ISNULL(right(max(maSach),4),0) + 1),4)) from [dbo].[Sach] where maSach like 'S%'");
		String maSach = "";
		while (resultSet.next()) {
			maSach = resultSet.getString(1);
		}
		return maSach;
	}

	// ma Nha Xuat Ban
	public String getMaNhaXuatBan() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select CONCAT('NXB', RIGHT(CONCAT('0000',ISNULL(right(max(maNhaXuatBan),4),0) + 1),4)) from [dbo].[NhaXuatBan] where maNhaXuatBan like 'NXB%'");
		String maNXB = "";
		while (resultSet.next()) {
			maNXB = resultSet.getString(1);
		}
		return maNXB;
	}
	// mã Sản Phẩm (Sách)
	public String getMaSanPham() throws SQLException {
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    Statement statement = con.createStatement();
	    ResultSet resultSet = statement.executeQuery(
	            "SELECT CONCAT('SP', RIGHT(CONCAT('0000', ISNULL(RIGHT(MAX(maSanPham), 4), 0) + 1), 4)) FROM [dbo].[SanPham] WHERE maSanPham LIKE 'SP%'");
	    String maSanPham = "";
	    while (resultSet.next()) {
	        maSanPham = resultSet.getString(1);
	    }
	    return maSanPham;
	}

	// ma Khach Hang
	public String getMaKhachHang() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select CONCAT('KH', RIGHT(CONCAT('0000',ISNULL(right(max(maKhachHang),4),0) + 1),4)) from [dbo].[KhachHang] where maKhachHang like 'KH%'");
		String maKH = "";
		while (resultSet.next()) {
			maKH = resultSet.getString(1);
		}
		return maKH;
	}

	// tai khoan
	public String getMaTaiKhoan() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select CONCAT('NV', RIGHT(CONCAT('0000',ISNULL(right(max(taiKhoan),4),0) + 1),4)) from [dbo].[TaiKhoan] where taiKhoan like 'NV%'");
		String maTaiKhoan = "";
		while (resultSet.next()) {
			maTaiKhoan = resultSet.getString(1);
		}
		return maTaiKhoan;
	}

	// phieu dat hang
	public String getMaPhieuDatHang() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select CONCAT('PD', RIGHT(CONCAT('00000',ISNULL(right(max(maPhieuDatHang),5),0) + 1),5)) from [dbo].[PhieuDatHang] where maPhieuDatHang like 'PD%'");
		String maTaiKhoan = "";
		while (resultSet.next()) {
			maTaiKhoan = resultSet.getString(1);
		}
		return maTaiKhoan;
	}

	// dung cu hoc tap
	public String getMaDCHT() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select CONCAT('DCHT', RIGHT(CONCAT('00000',ISNULL(right(max(maSanPham),5),0) + 1),5)) from [dbo].[SanPham] where maSanPham like 'DCHT%'");
		String maDCHT = "";
		while (resultSet.next()) {
			maDCHT = resultSet.getString(1);
		}
		return maDCHT;
	}
	
	// nhacungcap
	
	public String getMaNhaCungCap() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select CONCAT('NCC', RIGHT(CONCAT('0000',ISNULL(right(max(maNhaCungCap),4),0) + 1),4)) from [dbo].[NhaCungCap] where maNhaCungCap like 'NCC%'");
		String maNCC = "";
		while (resultSet.next()) {
			maNCC = resultSet.getString(1);
		}
		return maNCC;
	}
	
}
