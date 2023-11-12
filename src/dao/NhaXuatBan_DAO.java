package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connect.ConnectDB;
import entity.NhaXuatBan;
public class NhaXuatBan_DAO {

	// get all nhà xuất bản
    public ArrayList<NhaXuatBan> getAllListNhaXuatBan() {
    	ArrayList<NhaXuatBan> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM NhaXuatBan");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                ds.add(new NhaXuatBan(result.getString(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }
    
 // get NXB theo ma
 	public NhaXuatBan getnhaXuatBanTheoMa(String maNhaXuatBan) {
 		NhaXuatBan nhaXuatBan = new NhaXuatBan();
 		ConnectDB.getInstance();
 		Connection connection = ConnectDB.getConnection();
 		try {
 			PreparedStatement preparedStatement = connection
 					.prepareStatement("select * from NhaXuatBan where maNhaXuatBan = '" + maNhaXuatBan + "'");
 			ResultSet resultSet = preparedStatement.executeQuery();

 			while (resultSet.next()) {
 				nhaXuatBan.setMaNhaXuatBan(resultSet.getString(1));
 				nhaXuatBan.setTenNhaXuatBan(resultSet.getString(2));
 				nhaXuatBan.setDiaChi(resultSet.getString(3));
 				nhaXuatBan.setSoDienThoai(resultSet.getString(4));
 				nhaXuatBan.setEmail(resultSet.getString(5));
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return nhaXuatBan;
 	}
 // get NXB theo tên
  	public NhaXuatBan getnhaXuatBanTheoTen(String tenNhaXuatBan ) {
  		NhaXuatBan nhaXuatBan = new NhaXuatBan();
  		ConnectDB.getInstance();
  		Connection connection = ConnectDB.getConnection();
  		try {
  			PreparedStatement preparedStatement = connection
  					.prepareStatement("select * from NhaXuatBan where tenNhaXuatBan = N'" + tenNhaXuatBan + "'");
  			ResultSet resultSet = preparedStatement.executeQuery();

  			while (resultSet.next()) {
  				nhaXuatBan.setMaNhaXuatBan(resultSet.getString(1));
  				nhaXuatBan.setTenNhaXuatBan(resultSet.getString(2));
  				nhaXuatBan.setDiaChi(resultSet.getString(3));
  				nhaXuatBan.setSoDienThoai(resultSet.getString(4));
  				nhaXuatBan.setEmail(resultSet.getString(5));
  			}
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return nhaXuatBan;
  	}
 // thêm nhà xuất bản
 	public boolean themNhaXuatBan(NhaXuatBan nhaXuatBan) throws SQLException {
 	    ConnectDB.getInstance();
 	    Connection connection = ConnectDB.getConnection();
 	    try {
 	        PreparedStatement preparedStatement = null;
 	        preparedStatement = connection.prepareStatement("INSERT INTO NhaXuatBan VALUES (?,?,?,?,?)");
 	        preparedStatement.setString(1, nhaXuatBan.getMaNhaXuatBan());
 	        preparedStatement.setString(2, nhaXuatBan.getTenNhaXuatBan());
 	        preparedStatement.setString(3, nhaXuatBan.getDiaChi());
 	        preparedStatement.setString(4, nhaXuatBan.getSoDienThoai());
 	        preparedStatement.setString(5, nhaXuatBan.getEmail());
 	        return preparedStatement.executeUpdate() > 0;
 	    } catch (SQLException e) {
 	        e.printStackTrace();
 	    } 
 	    return false;
 	}
 // xóa nhà xuất bản theo mã
 	public boolean xoaNhaXuatBanTheoMa(String maNhaXuatBan) throws SQLException {
 		ConnectDB.getInstance();
 		Connection connection = ConnectDB.getConnection();
 		PreparedStatement preparedStatement = connection
 					.prepareStatement("delete from NhaXuatBan where maNhaXuatBan = '" + maNhaXuatBan + "'");
// 		preparedStatement.close();
 		return preparedStatement.executeUpdate() > 0;
 	}
 	// sửa nhà xuất bản theo mã
 	public boolean suaNhaXuatBanTheoMa(NhaXuatBan nhaXuatBan) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update NhaXuatBan set tenNhaXuatBan = ?,diaChi =  ?,soDienThoai = ?, email =? where maNhaXuatBan = '"
							+ nhaXuatBan.getMaNhaXuatBan() + "'");
			preparedStatement.setString(1, nhaXuatBan.getTenNhaXuatBan());
			preparedStatement.setString(2, nhaXuatBan.getDiaChi());
			preparedStatement.setString(3, nhaXuatBan.getSoDienThoai() );
			preparedStatement.setString(4, nhaXuatBan.getEmail());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		connection.close();
		return false;
	}
}