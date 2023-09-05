package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import connect.ConnectDB;
import entity.CuaHang;

public class CuaHang_DAO {
	public List<CuaHang> getAllCuaHang(){
		List<CuaHang>  ds= new ArrayList<CuaHang>();
		ConnectDB.getInstance(); // luon luon co
		Connection con = ConnectDB.getConnection(); // luon luon co
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement("select * from CuaHang");
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()) {
				ds.add(new CuaHang(result.getString(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ds;
	}
}
