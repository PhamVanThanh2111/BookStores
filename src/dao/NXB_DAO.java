package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connect.ConnectDB;

import entity.NXB;

public class NXB_DAO {
	// get all loai sách //lấy
	public List<NXB> getAllListNXB() {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		List<NXB> ds = new ArrayList<NXB>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from NXB");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ds.add(new NXB(resultSet.getString(0), resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4)));
			}

		} catch (Exception e) {
			// TODO: handle exceptiosn
		}
		return ds;
	}
}
