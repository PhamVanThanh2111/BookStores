package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.HoaDon;

public class HoaDon_DAO {
	// get all hoa don
	public ArrayList<HoaDon> getAllListHoaDon() {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from HoaDon");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(resultSet.getString(1));
				hoaDon.setMaNhanVien(resultSet.getString(2));
				hoaDon.setMaKhachHang(resultSet.getString(3));
				hoaDon.setNgayLap(resultSet.getDate(4));
				hoaDon.setThanhTien(resultSet.getFloat(5));
				ds.add(hoaDon);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	
	// get hoa don theo ma
		public HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) {
			ConnectDB.getInstance();
			Connection connection = ConnectDB.getConnection();
			HoaDon hoaDon = new HoaDon();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("select * from HoaDon where maHoaDon = '"+ maHoaDon +"'");
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					hoaDon.setMaHoaDon(resultSet.getString(1));
					hoaDon.setMaNhanVien(resultSet.getString(2));
					hoaDon.setMaKhachHang(resultSet.getString(3));
					hoaDon.setNgayLap(resultSet.getDate(4));
					hoaDon.setThanhTien(resultSet.getFloat(5));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return hoaDon;
		}

	// them hoa don
	public boolean lapHoaDon(HoaDon hoaDon) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("insert into HoaDon values (?,?,?,?,?)");
			preparedStatement.setString(1, hoaDon.getMaHoaDon());
			preparedStatement.setString(2, hoaDon.getMaNhanVien());
			preparedStatement.setString(3, hoaDon.getMaKhachHang());
			preparedStatement.setDate(4, hoaDon.getNgayLap());
			preparedStatement.setFloat(5, hoaDon.getThanhTien());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		connection.close();
		return false;
	}
}
