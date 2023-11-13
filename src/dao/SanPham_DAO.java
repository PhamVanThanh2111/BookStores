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
	// Lấy sách
	private PhatSinhMa_DAO phatSinhMa_DAO;
	public ArrayList<SanPham> getAllSach() {
		ArrayList<SanPham> ds = new ArrayList<SanPham>();
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
	//Lấy tên theo mã sách
	public SanPham getTenSachTheoTenSanPham(String tenSanPham) {
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
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPham;
	}
	// Xóa sách 
	public boolean xoaSachTheoMa(String maSach) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		PreparedStatement preparedStatement = connection
					.prepareStatement("delete from SanPham where maSanPham = '" + maSach + "'");
//		preparedStatement.close();
		return preparedStatement.executeUpdate() > 0;
	}
	// khôi phục Sách
	public ArrayList<SanPham> getAllSachXoa() {
		ArrayList<SanPham> ds = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from SanPham where maSanPham like 'XS%'");
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
	// sửa Mã Sách
	public boolean suaMaSach(SanPham sanPham) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		phatSinhMa_DAO =new PhatSinhMa_DAO();
		try {
			PreparedStatement preparedstaments = connection.prepareStatement(
					"update SanPham set maSanPham= ? where maSanPham = '" + sanPham.getMaSanPham() + "'");
			preparedstaments.setString(1, phatSinhMa_DAO.getMaSachXoa01());
			return preparedstaments.executeUpdate() > 0;
		} catch (SQLException e) {
		}
//		connection.close();
		return false;
	}
	// khôi phục sản phẩm sách
	public boolean khoiPhucSanPham01(SanPham sanPham) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		phatSinhMa_DAO =new PhatSinhMa_DAO();
		try {
			PreparedStatement preparedstaments = connection.prepareStatement(
					"update SanPham set maSanPham= ? where maSanPham = '" + sanPham.getMaSanPham() + "'");
			preparedstaments.setString(1, phatSinhMa_DAO.getMaSach());
			return preparedstaments.executeUpdate() > 0;
		} catch (SQLException e) {
		}
//		connection.close();
		return false;
	}
	// Lấy Dụng Cụ Học Tập
	public ArrayList<SanPham> getAllDungCuHocTap() {
		ArrayList<SanPham> ds = new ArrayList<SanPham>();
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
			PreparedStatement preparedstaments = connection.prepareStatement(
					"update SanPham set tenSanPham=?,xuatXu=?,giaNhap=?,giaBan=?,soLuongTon=?, hinhAnh=? ,maNXB=?,"
							+ " maTheLoaiSach=?,tacGia=?,soTrang=?,namXuatBan=?,maNhaCungCap=? "
							+ " where maSanPham = '" + sanPham.getMaSanPham() + "'");
			preparedstaments.setString(1, sanPham.getTenSanPham());
			preparedstaments.setString(2, sanPham.getXuatXu());
			preparedstaments.setFloat(3, sanPham.getGiaNhap());
			preparedstaments.setFloat(4, sanPham.getGiaBan());
			preparedstaments.setInt(5, sanPham.getSoLuongTon());
			preparedstaments.setString(6, sanPham.getHinhAnh());
			preparedstaments.setString(7, sanPham.getMaNXB());
			preparedstaments.setString(8, sanPham.getMaTheLoaiSach());
			preparedstaments.setString(9, sanPham.getTacGia());
			preparedstaments.setInt(10, sanPham.getSoTrang());
			preparedstaments.setInt(11, sanPham.getNamXuatBan());
			preparedstaments.setString(12, sanPham.getMaNhaCungCap());
			return preparedstaments.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
		}
//		connection.close();
		return false;
	}
	// sửa sản phẩm
	public boolean suaSanPhamTheoMaSach(SanPham sanPham) {
	    ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();

		try {
		    String query = "UPDATE SanPham SET tenSanPham = ?, xuatXu = ?, giaNhap = ?, giaBan = ?, soLuongTon = ?, hinhAnh = ?, maNXB = ?, maTheLoaiSach = ?, tacGia = ?, soTrang = ?, namXuatBan = ? WHERE maSanPham = '" + sanPham.getMaSanPham() + "'";
		    
		    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		        preparedStatement.setString(1, sanPham.getTenSanPham());
		        preparedStatement.setString(2, sanPham.getXuatXu());
		        preparedStatement.setFloat(3, sanPham.getGiaNhap());
		        preparedStatement.setFloat(4, sanPham.getGiaBan());
		        preparedStatement.setInt(5, sanPham.getSoLuongTon());
		        preparedStatement.setString(6, sanPham.getHinhAnh());
		        preparedStatement.setString(7, sanPham.getMaNXB());
		        preparedStatement.setString(8, sanPham.getMaTheLoaiSach());
		        preparedStatement.setString(9, sanPham.getTacGia());
		        preparedStatement.setInt(10, sanPham.getSoTrang());
		        preparedStatement.setInt(11, sanPham.getNamXuatBan());
		        return preparedStatement.executeUpdate() > 0;
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}

	    return false;
	}
	// ban san pham, soLuong là số lượng sản phẩm bán đi
	public boolean banSanPham(String maSanPham, int soLuong) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();

		try {
			PreparedStatement preparedstaments = connection.prepareStatement(
					"update SanPham set soLuongTon = soLuongTon - "+ soLuong +" where maSanPham = '" + maSanPham + "'");
			return preparedstaments.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		connection.close();
		return false;
	}
	
	public boolean suaMaDCHT(SanPham sanPham) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		phatSinhMa_DAO =new PhatSinhMa_DAO();
		try {
			PreparedStatement preparedstaments = connection.prepareStatement(
					"update SanPham set maSanPham= ? where maSanPham = '" + sanPham.getMaSanPham() + "'");
			preparedstaments.setString(1, phatSinhMa_DAO.getMaDCHTXoa());
			return preparedstaments.executeUpdate() > 0;
		} catch (SQLException e) {
			
		}
//		connection.close();
		return false;
	}
	
	public boolean khoiPhucSanPham(SanPham sanPham) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		phatSinhMa_DAO =new PhatSinhMa_DAO();
		try {
			PreparedStatement preparedstaments = connection.prepareStatement(
					"update SanPham set maSanPham= ? where maSanPham = '" + sanPham.getMaSanPham() + "'");
			preparedstaments.setString(1, phatSinhMa_DAO.getMaDCHT());
			return preparedstaments.executeUpdate() > 0;
		} catch (SQLException e) {
			
		}
//		connection.close();
		return false;
	}
	public ArrayList<SanPham> getAllDCHTXoa() {
		ArrayList<SanPham> ds = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from SanPham where maSanPham like 'XDCHT%'");
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
	
}
