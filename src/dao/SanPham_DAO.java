package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.SanPham;

public class SanPham_DAO {
	//Lấy sách
	  
	  public static List<SanPham> getAllSach() {
	        List<SanPham> ds = new ArrayList<SanPham>();
	        ConnectDB.getInstance(); 
	        Connection con = ConnectDB.getConnection(); 
	        try {
	            PreparedStatement preparedStatement = con.prepareStatement("select * from SanPham where maSanPham like 'S%'");
	            ResultSet result = preparedStatement.executeQuery();
	            while (result.next()) {
					ds.add(new SanPham(result.getString(1),result.getString(2),result.getString(3),result.getFloat(4),result.getFloat(5),result.getInt(6),result.getString(7),
							result.getString(8),result.getString(9),result.getString(10),result.getInt(11),result.getInt(12)));
				}	
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return ds;
	    }
	  //Lấy Dụng Cụ Học Tập
	  public static List<SanPham> getAllDungCuHocTap() {
	        List<SanPham> ds = new ArrayList<SanPham>();
	        ConnectDB.getInstance(); 
	        Connection con = ConnectDB.getConnection(); 
	        try {
	            PreparedStatement preparedStatement = con.prepareStatement("select * from SanPham where maSanPham like 'S%'");
	            ResultSet result = preparedStatement.executeQuery();
	            while (result.next()) {
					ds.add(new SanPham(result.getString(1),result.getString(2),result.getString(3),result.getFloat(4),result.getFloat(5),result.getInt(6),result.getString(7),result.getString(13)));
				}	
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return ds;
	    }
}
