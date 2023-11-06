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

	// ma Loai Sach
	public String getMaLoaiSach() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select CONCAT('LS', RIGHT(CONCAT('0000',ISNULL(right(max(maLoaiSach),4),0) + 1),4)) from [dbo].[LoaiSach] where maLoaiSach like 'LS%'");
		String maLS = "";
		while (resultSet.next()) {
			maLS = resultSet.getString(1);
		}
		return maLS;
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
	
}
