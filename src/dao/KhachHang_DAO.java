	package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
		ConnectDB.getInstance(); // luon luon co
		Connection con = ConnectDB.getConnection(); // luon luon co

		try {
			PreparedStatement preparedStatement = con.prepareStatement("select * from KhachHang");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				ds.add(new KhachHang(result.getString(1), result.getString(2), result.getString(3), result.getString(4),
						result.getString(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}
	
	public KhachHang getKhachHangTheoSoDienThoai(String soDienThoai) {
		KhachHang khachHang = new KhachHang();
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from KhachHang where soDienThoai = '" + soDienThoai + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				khachHang.setMaKhachHang(resultSet.getString(1));
				khachHang.setTenKhachHang(resultSet.getString(2));
				khachHang.setGioiTinh(resultSet.getString(3));
				khachHang.setSoDienThoai(resultSet.getString(4));
				khachHang.setDiaChi(resultSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachHang;
	}
	
	public KhachHang getKhachHangTheoMaKhachHang(String maKhachHang) {
		KhachHang khachHang = new KhachHang();
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from KhachHang where maKhachHang = '" + maKhachHang + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				khachHang.setMaKhachHang(resultSet.getString(1));
				khachHang.setTenKhachHang(resultSet.getString(2));
				khachHang.setGioiTinh(resultSet.getString(3));
				khachHang.setSoDienThoai(resultSet.getString(4));
				khachHang.setDiaChi(resultSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachHang;
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
					connection.prepareStatement("update KhachHang set tenKhachHang = ?,gioiTinh = ?,soDienThoai= ?,diaChi= ? where maKhachHang ='"+khachHang.getMaKhachHang()+"'");
			preparedstaments.setString(1,khachHang.getTenKhachHang());
			preparedstaments.setString(2,khachHang.getGioiTinh());
			preparedstaments.setString(3,khachHang.getSoDienThoai());
			preparedstaments.setString(4,khachHang.getDiaChi());
			return preparedstaments.executeUpdate() > 0;
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
