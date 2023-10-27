package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	public List<KhachHang> getAllKhachHang() {
		List<KhachHang> ds = new ArrayList<KhachHang>();
		ConnectDB.getInstance(); // luon luon co
		Connection con = ConnectDB.getConnection(); // luon luon co

		try {
			PreparedStatement preparedStatement = con.prepareStatement("select * from KhachHang");
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				ds.add(new KhachHang(result.getString(1), 
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
	
	public boolean xoaKhachHangTheoMa(String maKH) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		
		try {
			PreparedStatement preparedstaments = 
					connection.prepareStatement("delete from KhachHang Where maKhachHang = '"+maKH+"'");
				return preparedstaments.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return false;
	}
	
	public boolean suaKhachHangTheoMa(KhachHang khachHang) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		
		try {
			PreparedStatement preparedstaments = 
					connection.prepareStatement("update KhachHang settenKhachHang=?,gioiTinh=?,soDienThoai=?,diaChi=? "
							+ "where maKhachHang = '"+khachHang.getMaKhachHang()+"' ");
			preparedstaments.setString(1,khachHang.getTenKhachHang());
			preparedstaments.setString(2,khachHang.getGioiTinh());
			preparedstaments.setString(3,khachHang.getSoDienThoai());
			preparedstaments.setString(4,khachHang.getDiaChi());
		} catch (SQLException e) {
			// TODO: handle exception
		}
		connection.close();
		return false;	
	}
	
	public boolean themKhachHang(KhachHang khachHang) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedstamets =null;
			preparedstamets=connection.prepareStatement("insert into KhachHang values (?,?,?,?,?)");
			preparedstamets.setString(1, khachHang.getMaKhachHang());
			preparedstamets.setString(2, khachHang.getTenKhachHang());
			preparedstamets.setString(3, khachHang.getGioiTinh());
			preparedstamets.setString(4, khachHang.getSoDienThoai());
			preparedstamets.setString(5, khachHang.getDiaChi());
			return preparedstamets.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		connection.close();

		return false;
	}
}
