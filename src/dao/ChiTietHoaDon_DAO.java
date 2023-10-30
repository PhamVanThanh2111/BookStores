package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.ConnectDB;
import entity.ChiTietHoaDon;

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
}
