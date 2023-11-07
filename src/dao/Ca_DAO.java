package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.ConnectDB;
import entity.Ca;

public class Ca_DAO {

	// get ca theo ma
	public Ca getCaTheoMa(String maCa) {
		Ca ca = null;
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Ca where UPPER(maCa) = UPPER('" + maCa + "')");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ca = new Ca();
				ca.setMaCa(resultSet.getString(1));
				ca.setTenCa(resultSet.getString(2));
				ca.setThoiGian(resultSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ca;
	}
}
