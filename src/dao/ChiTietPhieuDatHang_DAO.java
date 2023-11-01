package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.ChiTietPhieuDatHang;

public class ChiTietPhieuDatHang_DAO {
	// them nhan vien
	public boolean themChiTietPhieuDatHang(ChiTietPhieuDatHang chiTietPhieuDatHang) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("insert into ChiTietPhieuDatHang values (?,?,?,?)");
			preparedStatement.setString(1, chiTietPhieuDatHang.getMaPhieuDatHang());
			preparedStatement.setString(2, chiTietPhieuDatHang.getMaSanPham());
			preparedStatement.setInt(3, chiTietPhieuDatHang.getSoLuong());
			preparedStatement.setFloat(4, chiTietPhieuDatHang.getDonGia());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		connection.close();
		return false;
	}

	// get all chi tiet hoa don theo ma hoa don
	public ArrayList<ChiTietPhieuDatHang> getAllChiTietPhieuDatHangTheoMaPhieuDatHang(String maPhieuDatHang) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		ArrayList<ChiTietPhieuDatHang> ds = new ArrayList<ChiTietPhieuDatHang>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from ChiTietPhieuDatHang where maPhieuDatHang = '"+ maPhieuDatHang +"'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ChiTietPhieuDatHang ChiTietPhieuDatHang = new ChiTietPhieuDatHang();
				ChiTietPhieuDatHang.setMaPhieuDatHang(resultSet.getString(1));
				ChiTietPhieuDatHang.setMaSanPham(resultSet.getString(2));
				ChiTietPhieuDatHang.setSoLuong(resultSet.getInt(3));
				ChiTietPhieuDatHang.setDonGia(resultSet.getFloat(4));
				ds.add(ChiTietPhieuDatHang);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
}
