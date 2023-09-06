package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.LoaiSach;
import entity.Sach;

public class LoaiSach_DAO {
	// get all loai sách //lấy
			public List<LoaiSach> getAllListLoaiSach() {
				ConnectDB.getInstance();
				Connection connection = ConnectDB.getConnection();
				List<LoaiSach> ds = new ArrayList<LoaiSach>();
				try {
					PreparedStatement preparedStatement = connection.prepareStatement("select * from LoaiSach");
					ResultSet resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
								ds.add(new LoaiSach(resultSet.getString(1),resultSet.getString(2)));
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				return ds;
			}

}
