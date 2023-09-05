package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
							ds.add(new Sach(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getInt(8)));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return ds;
		}
		
}
