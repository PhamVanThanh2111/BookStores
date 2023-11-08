package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connect.ConnectDB;
import entity.NhaCungCap;
public class NhaCungCap_DAO {

    public ArrayList<NhaCungCap> getAllNhaCungCap() {
    	ArrayList<NhaCungCap> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM NhaCungCap");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                ds.add(new NhaCungCap(result.getString(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    public NhaCungCap getNhaCCTheoMa(String maNCC) {
    	
    	NhaCungCap nhaCungCap = new NhaCungCap();
 		ConnectDB.getInstance();
 		Connection connection = ConnectDB.getConnection();
 		try {
 			PreparedStatement preparedStatement = connection
 					.prepareStatement("select * from NhaCungCap where maNhaCungCap = '" + maNCC + "'");
 			ResultSet resultSet = preparedStatement.executeQuery();

 			while (resultSet.next()) {
 				nhaCungCap.setMaNCC(resultSet.getString(1));
 				nhaCungCap.setTenNCC(resultSet.getString(2));
 				nhaCungCap.setDiaChi(resultSet.getString(3));
 				nhaCungCap.setSoDienThoai(resultSet.getString(4));
 				nhaCungCap.setEmail(resultSet.getString(5));
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return nhaCungCap;
    }
    
    public NhaCungCap getNhaCungCapTheoTen(String tenNhaCC) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		NhaCungCap nhaCungCap = new NhaCungCap();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from NhaCungCap where tenNhaCungCap = N'" + tenNhaCC + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				nhaCungCap.setMaNCC(resultSet.getString(1));
				nhaCungCap.setTenNCC(resultSet.getString(2));
				nhaCungCap.setDiaChi(resultSet.getString(3));
				nhaCungCap.setSoDienThoai(resultSet.getString(4));
				nhaCungCap.setEmail(resultSet.getString(5));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhaCungCap;
	}
    
    public boolean themNhaCC(NhaCungCap nhaCC) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedstamets =null;
			preparedstamets=connection.prepareStatement("insert into NhaCungCap values (?,?,?,?,?)");
			preparedstamets.setString(1, nhaCC.getMaNCC());
			preparedstamets.setString(2, nhaCC.getTenNCC());
			preparedstamets.setString(3, nhaCC.getDiaChi());
			preparedstamets.setString(4, nhaCC.getSoDienThoai());
			preparedstamets.setString(5, nhaCC.getEmail());
			return preparedstamets.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		connection.close();

		return false;
	}
    
	public boolean xoaNhaCungCapTheoMa(String maNCC) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		
		try {
			PreparedStatement preparedstaments = 
					connection.prepareStatement("delete from NhaCungCap Where maNhaCungCap = '"+maNCC+"'");
				return preparedstaments.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return false;
	}
	
	
    public boolean suaNhaCungCapTheoMa(NhaCungCap nhaCC) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedstaments = 
					connection.prepareStatement("update NhaCungCap set tenNhaCungCap = ?,diaChi = ?,soDienThoai= ?,email= ? where maNhaCungCap ='"+nhaCC.getMaNCC()+"'");
			preparedstaments.setString(1,nhaCC.getTenNCC());
			preparedstaments.setString(2,nhaCC.getDiaChi());
			preparedstaments.setString(3,nhaCC.getSoDienThoai());
			preparedstaments.setString(4,nhaCC.getEmail());
			return preparedstaments.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		connection.close();
		return false;	
	}
}