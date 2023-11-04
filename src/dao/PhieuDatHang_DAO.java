package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.PhieuDatHang;

public class PhieuDatHang_DAO {
	// get all hoa don
	public ArrayList<PhieuDatHang> getAllListPhieuDatHang() {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		ArrayList<PhieuDatHang> ds = new ArrayList<PhieuDatHang>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from PhieuDatHang");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PhieuDatHang phieuDatHang = new PhieuDatHang();
				phieuDatHang.setMaPhieuDatHang(resultSet.getString(1));
				phieuDatHang.setMaNhanVien(resultSet.getString(2));
				phieuDatHang.setMaKhachHang(resultSet.getString(3));
				phieuDatHang.setNgayLap(resultSet.getDate(4));
				phieuDatHang.setThanhTien(resultSet.getFloat(5));
				ds.add(phieuDatHang);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}

	// get hoa don theo ma
	public PhieuDatHang getPhieuDatHangTheoMaPhieuDatHang(String maPhieuDatHang) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		PhieuDatHang PhieuDatHang = new PhieuDatHang();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from PhieuDatHang where maPhieuDatHang = '" + maPhieuDatHang + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PhieuDatHang.setMaPhieuDatHang(resultSet.getString(1));
				PhieuDatHang.setMaNhanVien(resultSet.getString(2));
				PhieuDatHang.setMaKhachHang(resultSet.getString(3));
				PhieuDatHang.setNgayLap(resultSet.getDate(4));
				PhieuDatHang.setThanhTien(resultSet.getFloat(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return PhieuDatHang;
	}

	// them hoa don
	public boolean lapPhieuDatHang(PhieuDatHang phieuDatHang) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("insert into PhieuDatHang values (?,?,?,?,?)");
			preparedStatement.setString(1, phieuDatHang.getMaPhieuDatHang());
			preparedStatement.setString(2, phieuDatHang.getMaNhanVien());
			preparedStatement.setString(3, phieuDatHang.getMaKhachHang());
			preparedStatement.setDate(4, phieuDatHang.getNgayLap());
			preparedStatement.setFloat(5, phieuDatHang.getThanhTien());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		connection.close();
		return false;
	}

}
