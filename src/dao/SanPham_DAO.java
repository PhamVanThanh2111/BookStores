package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.KhachHang;
import entity.SanPham;

public class SanPham_DAO {
	// Lấy sách

	public List<SanPham> getAllSach() {
		List<SanPham> ds = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from SanPham where maSanPham like 'S%'");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				ds.add(new SanPham(result.getString(1), result.getString(2), result.getString(3), result.getFloat(4),
						result.getFloat(5), result.getInt(6), result.getString(7), result.getString(8),
						result.getString(9), result.getString(10), result.getInt(11), result.getInt(12)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}

	// Lấy Dụng Cụ Học Tập
	public List<SanPham> getAllDungCuHocTap() {
		List<SanPham> ds = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from SanPham where maSanPham like 'DCHT%'");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				ds.add(new SanPham(result.getString(1), result.getString(2), result.getString(3), result.getFloat(4),
						result.getFloat(5), result.getInt(6), result.getString(7), result.getString(13)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ds;
	}

	public SanPham getSanPhamTheoTenSanPham(String tenSanPham) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		SanPham sanPham = new SanPham();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from SanPham where tenSanPham = N'" + tenSanPham + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				sanPham.setMaSanPham(resultSet.getString(1));
				sanPham.setTenSanPham(resultSet.getString(2));
				sanPham.setXuatXu(resultSet.getString(3));
				sanPham.setGiaNhap(resultSet.getFloat(4));
				sanPham.setGiaBan(resultSet.getFloat(5));
				sanPham.setSoLuongTon(resultSet.getInt(6));
				sanPham.setHinhAnh(resultSet.getString(7));
				sanPham.setMaNXB(resultSet.getString(8));
				sanPham.setMaTheLoaiSach(resultSet.getString(9));
				sanPham.setTacGia(resultSet.getString(10));
				sanPham.setSoTrang(resultSet.getInt(11));
				sanPham.setNamXuatBan(resultSet.getInt(12));
				sanPham.setMaNhaCungCap(resultSet.getString(13));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPham;
	}
	
	public SanPham getSanPhamTheoMaSanPham(String maSanPham) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		SanPham sanPham = new SanPham();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from SanPham where maSanPham = N'" + maSanPham + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				sanPham.setMaSanPham(resultSet.getString(1));
				sanPham.setTenSanPham(resultSet.getString(2));
				sanPham.setXuatXu(resultSet.getString(3));
				sanPham.setGiaNhap(resultSet.getFloat(4));
				sanPham.setGiaBan(resultSet.getFloat(5));
				sanPham.setSoLuongTon(resultSet.getInt(6));
				sanPham.setHinhAnh(resultSet.getString(7));
				sanPham.setMaNXB(resultSet.getString(8));
				sanPham.setMaTheLoaiSach(resultSet.getString(9));
				sanPham.setTacGia(resultSet.getString(10));
				sanPham.setSoTrang(resultSet.getInt(11));
				sanPham.setNamXuatBan(resultSet.getInt(12));
				sanPham.setMaNhaCungCap(resultSet.getString(13));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPham;
	}
	
//	Them DCHT
	public boolean themSanPham(SanPham sanPham) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedstamets =null;
			preparedstamets=connection.prepareStatement("insert into SanPham values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedstamets.setString(1, sanPham.getMaSanPham());
			preparedstamets.setString(2, sanPham.getTenSanPham());
			preparedstamets.setString(3, sanPham.getXuatXu());
			preparedstamets.setFloat(4, sanPham.getGiaNhap());
			preparedstamets.setFloat(5, sanPham.getGiaBan());
			preparedstamets.setInt(6, sanPham.getSoLuongTon());
			preparedstamets.setString(7, sanPham.getHinhAnh());
			preparedstamets.setString(8, sanPham.getMaNXB());
			preparedstamets.setString(9 , sanPham.getMaTheLoaiSach());
			preparedstamets.setString(10, sanPham.getTacGia());
			preparedstamets.setInt(11, sanPham.getSoTrang());
			preparedstamets.setInt(12, sanPham.getNamXuatBan());
			preparedstamets.setString(13, sanPham.getMaNhaCungCap());
			return preparedstamets.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();

		return false;
	}
	
	public boolean suaSanPhamTheoMa(SanPham sanPham) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		
		try {
			PreparedStatement preparedstaments = 
					connection.prepareStatement("update SanPham settenSanPham=?,xuatXu=?,giaNhap=?,giaBan=?,soLuongTon=?,maNXB=?,maTheLoaiSach=?,tacGia=?,soTrang=?,namXuatBan=?,maNhaCungCap=?,hinhAnh=? "
							+ "where maSanPham= '"+sanPham.getMaSanPham()+"' ");
			preparedstaments.setString(1,sanPham.getTenSanPham());
			preparedstaments.setString(2,sanPham.getXuatXu());
			preparedstaments.setFloat(3,sanPham.getGiaNhap());
			preparedstaments.setFloat(4,sanPham.getGiaBan());
			preparedstaments.setInt(5,sanPham.getSoLuongTon());
			preparedstaments.setString(6,sanPham.getMaNXB());
			preparedstaments.setString(7,sanPham.getMaTheLoaiSach());
			preparedstaments.setString(8,sanPham.getTacGia());
			preparedstaments.setInt(9,sanPham.getSoTrang());
			preparedstaments.setInt(10,sanPham.getNamXuatBan());
			preparedstaments.setString(11,sanPham.getMaNhaCungCap());
			preparedstaments.setString(12,sanPham.getHinhAnh());
		} catch (SQLException e) {
			// TODO: handle exception
		}
		connection.close();
		return false;	
	}
	
	
}
