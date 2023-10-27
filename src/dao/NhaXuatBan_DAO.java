package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connect.ConnectDB;
import entity.NhaXuatBan;
public class NhaXuatBan_DAO {

    public List<NhaXuatBan> getAllNhaXuatBan() {
        List<NhaXuatBan> ds = new ArrayList<>();
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
 				nhaXuatBan.setMaNXB(resultSet.getString(1));
 				nhaXuatBan.setTenNXB(resultSet.getString(2));
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
}