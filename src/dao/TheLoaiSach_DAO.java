package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connect.ConnectDB;
import entity.TheLoaiSach;

public class TheLoaiSach_DAO {
	// get all loai sách //lấy
	public static List<TheLoaiSach> getAllListTheLoaiSach() {
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

}
