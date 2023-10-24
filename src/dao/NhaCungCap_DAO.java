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

    public List<NhaCungCap> getAllNhaCungCap() {
        List<NhaCungCap> ds = new ArrayList<>();
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
}