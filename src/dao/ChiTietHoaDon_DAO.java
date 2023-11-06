package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;

public class ChiTietHoaDon_DAO {
	// them nhan vien
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("insert into ChiTietHoaDon values (?,?,?,?)");
			preparedStatement.setString(1, chiTietHoaDon.getMaHoaDon());
			preparedStatement.setString(2, chiTietHoaDon.getMaSanPham());
			preparedStatement.setInt(3, chiTietHoaDon.getSoLuong());
			preparedStatement.setFloat(4, chiTietHoaDon.getDonGia());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		connection.close();
		return false;
	}

	// get all chi tiet hoa don theo ma hoa don
	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		ArrayList<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from ChiTietHoaDon where maHoaDon = '"+ maHoaDon +"'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
				chiTietHoaDon.setMaHoaDon(resultSet.getString(1));
				chiTietHoaDon.setMaSanPham(resultSet.getString(2));
				chiTietHoaDon.setSoLuong(resultSet.getInt(3));
				chiTietHoaDon.setDonGia(resultSet.getFloat(4));
				ds.add(chiTietHoaDon);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	
//	// get danh sach chi tiet hoa don theo ngay
//		public ArrayList<ChiTietHoaDon> getListChiTietHoaDonTheoNgay(LocalDate date) { 
//			ConnectDB.getInstance();
//			Connection connection = ConnectDB.getConnection();
//			ArrayList<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
//			try {
//				PreparedStatement preparedStatement = connection
//						.prepareStatement("select * from ChiTietHoaDon where ngayLap = '"+ date +"'");
//				ResultSet resultSet = preparedStatement.executeQuery();
//				while (resultSet.next()) {
//					HoaDon hoaDon = new HoaDon();
//					hoaDon.setMaHoaDon(resultSet.getString(1));
//					hoaDon.setMaNhanVien(resultSet.getString(2));
//					hoaDon.setMaKhachHang(resultSet.getString(3));
//					hoaDon.setNgayLap(resultSet.getDate(4));
//					hoaDon.setThanhTien(resultSet.getFloat(5));
//					ds.add(hoaDon);
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			return ds;
//		}
}
