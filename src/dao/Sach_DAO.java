package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.NhanVien;
import entity.Sach;
import entity.TaiKhoan;

public class Sach_DAO {
	// get all sách //lấy
	public List<Sach> getAllListSach() {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		List<Sach> ds = new ArrayList<Sach>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from Sach");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ds.add(new Sach(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getInt(9),resultSet.getInt(10)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}

	// thêm sách
	public boolean themSach(Sach sach) throws SQLException {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(
					"INSERT INTO Sach VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, sach.getMaSach());
			preparedStatement.setString(2, sach.getMaNXB());
			preparedStatement.setString(3, sach.getMaLoaiSach());
			preparedStatement.setString(4, sach.getTenSach());
			preparedStatement.setString(5, sach.getXuatXu());
			preparedStatement.setString(6, sach.getTacGia());
			preparedStatement.setInt(7, sach.getSoTrang());
			preparedStatement.setInt(8, sach.getGia());
			preparedStatement.setInt(9, sach.getSoLuong());
			preparedStatement.setInt(10,sach.getNamXuatBan());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return false;
	}
	//xóa Sách theo mã
	public boolean xoaSachTheoMa(String maSach) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Sach WHERE MaSach = ?");
	        preparedStatement.setString(1, maSach);
			return preparedStatement.executeUpdate() > 0;
		} catch  (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		connection.close();
		return false;	
	}

}
