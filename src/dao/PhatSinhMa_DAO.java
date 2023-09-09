package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connect.ConnectDB;

public class PhatSinhMa_DAO {

	// ma CuaHang
	public String getMaCuaHang() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery("select CONCAT('CH', RIGHT(CONCAT('000',ISNULL(right(max(maCH),3),0) + 1),3)) from [dbo].[CuaHang] where maCH like 'CH%'");
		String maCH = "";
		while (resultSet.next()) {
			maCH = resultSet.getString(1);
		}
		return maCH;
	}
	
	// ma Nhan Vien
	public String getMaNhanVien() throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery("select CONCAT('NV', RIGHT(CONCAT('000',ISNULL(right(max(maNV),3),0) + 1),3)) from [dbo].[NhanVien] where maNV like 'NV%'");
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
		ResultSet resultSet = statement.executeQuery("select CONCAT('HD', RIGHT(CONCAT('000',ISNULL(right(max(maHD),3),0) + 1),3)) from [dbo].[HoaDon] where maHD like 'HD%'");
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
		ResultSet resultSet = statement.executeQuery("select CONCAT('LS', RIGHT(CONCAT('000',ISNULL(right(max(maLS),3),0) + 1),3)) from [dbo].[LoaiSach] where maLS like 'LS%'");
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
		ResultSet resultSet = statement.executeQuery("select CONCAT('S', RIGHT(CONCAT('000',ISNULL(right(max(maSach),3),0) + 1),3)) from [dbo].[Sach] where maSach like 'S%'");
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
		ResultSet resultSet = statement.executeQuery("select CONCAT('NXB', RIGHT(CONCAT('000',ISNULL(right(max(maNXB),3),0) + 1),3)) from [dbo].[NXB] where maNXB like 'NXB%'");
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
		ResultSet resultSet = statement.executeQuery("select CONCAT('KH', RIGHT(CONCAT('000',ISNULL(right(max(maKH),3),0) + 1),3)) from [dbo].[KhachHang] where maKH like 'KH%'");
		String maKH = "";
		while (resultSet.next()) {
			maKH = resultSet.getString(1);
		}
		return maKH;
	}
	
	// ma tai khoan
		public String getMaTaiKhoan() throws SQLException {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("select CONCAT('NV', RIGHT(CONCAT('000',ISNULL(right(max(taiKhoan),3),0) + 1),3)) from [dbo].[TaiKhoan] where taiKhoan like 'NV%'");
			String maTaiKhoan = "";
			while (resultSet.next()) {
				maTaiKhoan = resultSet.getString(1);
			}
			return maTaiKhoan;
		}
}
