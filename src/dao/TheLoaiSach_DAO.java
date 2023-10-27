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
 				theLoaiSach.setMaLoaiSach(resultSet.getString(1));
 				theLoaiSach.setTenLoaiSach(resultSet.getString(2));
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return theLoaiSach;
 	}

}
