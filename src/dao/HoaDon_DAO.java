package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.ConnectDB;
import entity.HoaDon;

public class HoaDon_DAO {
	
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
