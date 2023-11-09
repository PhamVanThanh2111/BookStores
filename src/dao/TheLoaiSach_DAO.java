package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import connect.ConnectDB;
import entity.TheLoaiSach;

public class TheLoaiSach_DAO {
	// get all loai sách //lấy
	public List<TheLoaiSach> getAllListTheLoaiSach() {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		List<TheLoaiSach> ds = new ArrayList<TheLoaiSach>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from TheLoaiSach");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ds.add(new TheLoaiSach(resultSet.getString(1), resultSet.getString(2)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	// get TheLoaiSach theo ma
 	public TheLoaiSach getTheLoaiSachTheoMa(String maTheLoaiSach) {
 		TheLoaiSach theLoaiSach = new TheLoaiSach();
 		ConnectDB.getInstance();
 		Connection connection = ConnectDB.getConnection();
 		try {
 			PreparedStatement preparedStatement = connection
 					.prepareStatement("select * from TheLoaiSach where maTheLoaiSach = '" + maTheLoaiSach + "'");
 			ResultSet resultSet = preparedStatement.executeQuery();

 			while (resultSet.next()) {
 				theLoaiSach.setmaTheLoaiSach(resultSet.getString(1));
 				theLoaiSach.settenTheLoaiSach(resultSet.getString(2));
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch bslock
 			e.printStackTrace();
 		}
 		return theLoaiSach;
 	}
	// get TheLoaiSach theo tên
 	public TheLoaiSach getTheLoaiSachTheoTen(String tenTheLoaiSach) {
 		TheLoaiSach theLoaiSach = new TheLoaiSach();
 		ConnectDB.getInstance();
 		Connection connection = ConnectDB.getConnection();
 		try {
 			PreparedStatement preparedStatement = connection
 					.prepareStatement("select * from TheLoaiSach where tenTheLoaiSach = '" + tenTheLoaiSach + "'");
 			ResultSet resultSet = preparedStatement.executeQuery();

 			while (resultSet.next()) {
 				theLoaiSach.setmaTheLoaiSach(resultSet.getString(1));
 				theLoaiSach.settenTheLoaiSach(resultSet.getString(2));
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch bslock
 			e.printStackTrace();
 		}
 		return theLoaiSach;
 	}
 // Thêm thể loại sách
 	public boolean themTheLoaiSach(TheLoaiSach theLoaiSach) throws SQLException {
 	    ConnectDB.getInstance();
 	    Connection connection = ConnectDB.getConnection();
 	    try {
 	        PreparedStatement preparedStatement = null;
 	        preparedStatement = connection.prepareStatement("INSERT INTO TheLoaiSach VALUES (?, ?)");
 	        preparedStatement.setString(1, theLoaiSach.getmaTheLoaiSach());
 	        preparedStatement.setString(2, theLoaiSach.gettenTheLoaiSach());
 	        return preparedStatement.executeUpdate() > 0;
 	    } catch (SQLException e) {
 	        e.printStackTrace();
 	    }
 	    return false;
 	}
 	// xoa thể loại sách
 		public boolean xoaTheLoaiSachTheoMa(String maTheLoaiSach) throws SQLException {
 			ConnectDB.getInstance();
 			Connection connection = ConnectDB.getConnection();
 			PreparedStatement preparedStatement = connection
 						.prepareStatement("delete from TheLoaiSach where maTheLoaiSach = '" + maTheLoaiSach + "'");
// 			preparedStatement.close();
 			return preparedStatement.executeUpdate() > 0;
 		}
 	// kiểm tra xóa (nếu thể loại sách đã tồn tại sách thì không được xóa)
 	public boolean isTheLoaiSachDaTonTai(String maTheLoaiSach) throws SQLException {
 	    ConnectDB.getInstance();
 	    Connection connection = ConnectDB.getConnection();

 	    try {
 	        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM Sach WHERE MaTheLoaiSach = ?");
 	        preparedStatement.setString(1, maTheLoaiSach);
 	        ResultSet resultSet = preparedStatement.executeQuery();
 	        if (resultSet.next()) {
 	            int count = resultSet.getInt(1);
 	            return count > 0;
 	        }
 	    } catch (SQLException e) {
 	        e.printStackTrace();
 	    } 
 	    finally {
 	        if (connection != null) {
 	            connection.close();
	        }
 	    }
 	    return false;
 	}
 // sửa thể loại sách theo mã
  	public boolean suaTheLoaiSachTheoMa(TheLoaiSach theLoaiSach) throws SQLException {
 		ConnectDB.getInstance();
 		Connection connection = ConnectDB.getConnection();
 		try {
 			PreparedStatement preparedStatement = connection.prepareStatement(
 					"update TheLoaiSach set tenTheLoaiSach = ? where maTheLoaiSach = '"
 							+  theLoaiSach.getmaTheLoaiSach() + "'");
 			preparedStatement.setString(1, theLoaiSach.gettenTheLoaiSach());
 			return preparedStatement.executeUpdate() > 0;
 		} catch (Exception e) {
 			// TODO: handle exception
 			e.printStackTrace();
 		}
 		connection.close();
 		return false;
 	}
}
