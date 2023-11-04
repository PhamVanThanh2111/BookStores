package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.SanPham;

public class SanPham_DAO {
	// Lấy sách

	public List<SanPham> getAllSach() {
		List<SanPham> ds = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from SanPham where maSanPham like 'S%'");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				ds.add(new SanPham(result.getString(1), result.getString(2), result.getString(3), result.getFloat(4),
						result.getFloat(5), result.getInt(6), result.getString(7), result.getString(8),
						result.getString(9), result.getString(10), result.getInt(11), result.getInt(12)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}

	// Lấy Dụng Cụ Học Tập
	public List<SanPham> getAllDungCuHocTap() {
		List<SanPham> ds = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from SanPham where maSanPham like 'DCHT%'");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				ds.add(new SanPham(result.getString(1), result.getString(2), result.getString(3), result.getFloat(4),
						result.getFloat(5), result.getInt(6), result.getString(7), result.getString(13)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}

	public SanPham getSanPhamTheoTenSanPham(String tenSanPham) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		SanPham sanPham = new SanPham();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from SanPham where tenSanPham = N'" + tenSanPham + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				sanPham.setMaSanPham(resultSet.getString(1));
				sanPham.setTenSanPham(resultSet.getString(2));
				sanPham.setXuatXu(resultSet.getString(3));
				sanPham.setGiaNhap(resultSet.getFloat(4));
				sanPham.setGiaBan(resultSet.getFloat(5));
				sanPham.setSoLuongTon(resultSet.getInt(6));
				sanPham.setHinhAnh(resultSet.getString(7));
				sanPham.setMaNXB(resultSet.getString(8));
				sanPham.setMaTheLoaiSach(resultSet.getString(9));
				sanPham.setTacGia(resultSet.getString(10));
				sanPham.setSoTrang(resultSet.getInt(11));
				sanPham.setNamXuatBan(resultSet.getInt(12));
				sanPham.setMaNhaCungCap(resultSet.getString(13));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPham;
	}
	
	public SanPham getSanPhamTheoMaSanPham(String maSanPham) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		SanPham sanPham = new SanPham();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from SanPham where maSanPham = N'" + maSanPham + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				sanPham.setMaSanPham(resultSet.getString(1));
				sanPham.setTenSanPham(resultSet.getString(2));
				sanPham.setXuatXu(resultSet.getString(3));
				sanPham.setGiaNhap(resultSet.getFloat(4));
				sanPham.setGiaBan(resultSet.getFloat(5));
				sanPham.setSoLuongTon(resultSet.getInt(6));
				sanPham.setHinhAnh(resultSet.getString(7));
				sanPham.setMaNXB(resultSet.getString(8));
				sanPham.setMaTheLoaiSach(resultSet.getString(9));
				sanPham.setTacGia(resultSet.getString(10));
				sanPham.setSoTrang(resultSet.getInt(11));
				sanPham.setNamXuatBan(resultSet.getInt(12));
				sanPham.setMaNhaCungCap(resultSet.getString(13));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPham;
	}
}
