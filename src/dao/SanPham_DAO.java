package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.SanPham;
import gui.Sach_GUI;

public class SanPham_DAO {
//	  private Sach_GUI sach_GUI; 
	  
	  public static List<SanPham> getAllSanPham() {
	        List<SanPham> ds = new ArrayList<SanPham>();
	        ConnectDB.getInstance(); 
	        Connection con = ConnectDB.getConnection(); 
	        try {
	            PreparedStatement preparedStatement = con.prepareStatement("select * from SanPham");
	            ResultSet result = preparedStatement.executeQuery();

//	            while (result.next()) {
//	                SanPham sanPham = new SanPham();
//	                sanPham.setMaSanPham(result.getString(1));
//	                sanPham.setTenSanPham(result.getString(2));
//	                sanPham.setXuatXu(result.getString(3));
//	                sanPham.setGiaNhap(result.getFloat(4));
//	                sanPham.setGiaBan(result.getFloat(5));
//	                sanPham.setSoLuongTon(result.getInt(6));
//	                sanPham.setHinhAnh(result.getString(7));
//	                sanPham.setMaNXB(result.getString(8));
//	                sanPham.setMaTheLoaiSach(result.getString(9));
//	                sanPham.setTacGia(result.getString(10));
//	                sanPham.setSoTrang(result.getString(11));
//	                sanPham.setNamXuatBan(result.getInt(12));
//	                sanPham.setMaNhaCungCap(result.getString(13));
//
//	                ds.add(sanPham);
//	            }
	            while (result.next()) {
					ds.add(new SanPham(result.getString(1),result.getString(2),result.getString(3),result.getFloat(4),result.getFloat(5),result.getInt(6),result.getString(7),
							result.getString(8),result.getString(9),result.getString(10),result.getString(11),result.getInt(12),result.getString(13)));
				}	
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return ds;
	    }
}
