package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.DungCuHocTap;

public class DungCuHocTap_DAO {

	// get all sách //lấy
	public List<DungCuHocTap> getAllListDungCuHocTap() {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		List<DungCuHocTap> ds = new ArrayList<DungCuHocTap>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from DungCuHocTap");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ds.add(new DungCuHocTap(resultSet.getString(1), resultSet.getString(2), resultSet.getLong(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}

}
