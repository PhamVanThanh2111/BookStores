package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVien_DAO {
	
	private TaiKhoan_DAO taiKhoan_DAO;
	
	// get all nhan vien
	public List<NhanVien> getAllListNhanVien() {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		List<NhanVien> ds = new ArrayList<NhanVien>();
		TaiKhoan taiKhoan;
		TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from NhanVien");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTaiKhoan(resultSet.getString(12));
				ds.add(new NhanVien(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6),
						resultSet.getDate(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10),
						resultSet.getString(11), taiKhoan, resultSet.getInt(13)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	
	// get nhan vien theo ten
		public List<NhanVien> getNhanVienTheoTen(String tenNV) {
			ConnectDB.getInstance();
			Connection connection = ConnectDB.getConnection();
			List<NhanVien> ds = new ArrayList<NhanVien>();
			TaiKhoan taiKhoan;
			TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("select * from NhanVien where tenNV like '%"+ tenNV +"%'");
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTaiKhoan(resultSet.getString(12));
					ds.add(new NhanVien(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6),
							resultSet.getDate(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10),
							resultSet.getString(11), taiKhoan, resultSet.getInt(13)));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return ds;
		}

	// get nhan vien theo ma
	public NhanVien getNhanVienTheoMa(String maNV) {
		NhanVien nhanVien = new NhanVien();
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		taiKhoan_DAO = new TaiKhoan_DAO();
		TaiKhoan taiKhoan;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from NhanVien where UPPER(maNV) = UPPER('" + maNV + "')");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTaiKhoan(resultSet.getString(12));
				nhanVien.setMaNV(maNV);
				nhanVien.setMaCH(resultSet.getString(2));
				nhanVien.setTenNV(resultSet.getString(3));
				nhanVien.setDiaChi(resultSet.getString(4));
				nhanVien.setGioiTinh(resultSet.getString(5));
				nhanVien.setNgaySinh(resultSet.getDate(6));
				nhanVien.setNgayVaoLam(resultSet.getDate(7));
				nhanVien.setCCCD(resultSet.getString(8));
				nhanVien.setEmail(resultSet.getString(9));
				nhanVien.setSoDienThoai(resultSet.getString(10));
				nhanVien.setChucVu(resultSet.getString(11));
				nhanVien.setTaiKhoan(taiKhoan);
				nhanVien.setLuong(resultSet.getInt(13));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nhanVien;
	}
	
	// get nhan vien theo SDT
	public NhanVien getNhanVienTheoSDT(String sdtNV) {
		NhanVien nhanVien = new NhanVien();
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		taiKhoan_DAO = new TaiKhoan_DAO();
		TaiKhoan taiKhoan;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from NhanVien where soDienThoai = '" + sdtNV + "'");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTaiKhoan(resultSet.getString(12));
				nhanVien.setMaNV(resultSet.getString(1));
				nhanVien.setMaCH(resultSet.getString(2));
				nhanVien.setTenNV(resultSet.getString(3));
				nhanVien.setDiaChi(resultSet.getString(4));
				nhanVien.setGioiTinh(resultSet.getString(5));
				nhanVien.setNgaySinh(resultSet.getDate(6));
				nhanVien.setNgayVaoLam(resultSet.getDate(7));
				nhanVien.setCCCD(resultSet.getString(8));
				nhanVien.setEmail(resultSet.getString(9));
				nhanVien.setSoDienThoai(resultSet.getString(10));
				nhanVien.setChucVu(resultSet.getString(11));
				nhanVien.setTaiKhoan(taiKhoan);
				nhanVien.setLuong(resultSet.getInt(13));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nhanVien;
	}
	
	// get nhan vien theo SDT
	public NhanVien getNhanVienTheoCCCD(String cccdNV) {
		NhanVien nhanVien = new NhanVien();
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		taiKhoan_DAO = new TaiKhoan_DAO();
		TaiKhoan taiKhoan;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from NhanVien where CCCD = '" + cccdNV + "'");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTaiKhoan(resultSet.getString(12));
				nhanVien.setMaNV(resultSet.getString(1));
				nhanVien.setMaCH(resultSet.getString(2));
				nhanVien.setTenNV(resultSet.getString(3));
				nhanVien.setDiaChi(resultSet.getString(4));
				nhanVien.setGioiTinh(resultSet.getString(5));
				nhanVien.setNgaySinh(resultSet.getDate(6));
				nhanVien.setNgayVaoLam(resultSet.getDate(7));
				nhanVien.setCCCD(resultSet.getString(8));
				nhanVien.setEmail(resultSet.getString(9));
				nhanVien.setSoDienThoai(resultSet.getString(10));
				nhanVien.setChucVu(resultSet.getString(11));
				nhanVien.setTaiKhoan(taiKhoan);
				nhanVien.setLuong(resultSet.getInt(13));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nhanVien;
	}

	// get nhan vien theo tai khoan
	public NhanVien getNhanVienTheoTaiKhoan(String maTK) {
		NhanVien nhanVien = new NhanVien();
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
		TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTaiKhoan(maTK);
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from NhanVien where taiKhoan = '" + maTK + "'");
			while (resultSet.next()) {
				nhanVien.setMaNV(resultSet.getString(1));
				nhanVien.setMaCH(resultSet.getString(2));
				nhanVien.setTenNV(resultSet.getString(3));
				nhanVien.setDiaChi(resultSet.getString(4));
				nhanVien.setGioiTinh(resultSet.getString(5));
				nhanVien.setNgaySinh(resultSet.getDate(6));
				nhanVien.setNgayVaoLam(resultSet.getDate(7));
				nhanVien.setCCCD(resultSet.getString(8));
				nhanVien.setEmail(resultSet.getString(9));
				nhanVien.setSoDienThoai(resultSet.getString(10));
				nhanVien.setChucVu(resultSet.getString(11));
				nhanVien.setTaiKhoan(taiKhoan);
				nhanVien.setLuong(resultSet.getInt(13));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nhanVien;
	}

	// them nhan vien
	public boolean themNhanVien(NhanVien nhanVien) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("insert into NhanVien values ( ?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, nhanVien.getMaNV());
			preparedStatement.setString(2, nhanVien.getMaCH());
			preparedStatement.setString(3, nhanVien.getTenNV());
			preparedStatement.setString(4, nhanVien.getDiaChi());
			preparedStatement.setString(5, nhanVien.getGioiTinh());
			preparedStatement.setDate(6, nhanVien.getNgaySinh());
			preparedStatement.setDate(7, nhanVien.getNgayVaoLam());
			preparedStatement.setString(8, nhanVien.getCCCD());
			preparedStatement.setString(9, nhanVien.getEmail());
			preparedStatement.setString(10, nhanVien.getSoDienThoai());
			preparedStatement.setString(11, nhanVien.getChucVu());
			preparedStatement.setString(12, nhanVien.getTaiKhoan().getTaiKhoan());
			preparedStatement.setInt(13, nhanVien.getLuong());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		connection.close();
		return false;
	}
	
	// xoa nhan vien
	public boolean xoaNhanVienTheoMa(String maNV) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from NhanVien where maNV = '"+ maNV +"'");
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		connection.close();
		return false;
	}
	
	public boolean suaNhanVienTheoMa(NhanVien nhanVien) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update NhanVien set maCH = ?, tenNV = ?, diaChi = ?, gioiTinh = ?, ngaySinh = ?, ngayVaoLam = ?, CCCD = ?, email = ?, soDienThoai = ?, chucVu = ?, taiKhoan = ?, luong = ? where maNV = '" + nhanVien.getMaNV() + "'");
			preparedStatement.setString(1, nhanVien.getMaCH());
			preparedStatement.setString(2, nhanVien.getTenNV());
			preparedStatement.setString(3, nhanVien.getDiaChi());
			preparedStatement.setString(4, nhanVien.getGioiTinh());
			preparedStatement.setDate(5, nhanVien.getNgaySinh());
			preparedStatement.setDate(6, nhanVien.getNgayVaoLam());
			preparedStatement.setString(7, nhanVien.getCCCD());
			preparedStatement.setString(8, nhanVien.getEmail());
			preparedStatement.setString(9, nhanVien.getSoDienThoai());
			preparedStatement.setString(10, nhanVien.getChucVu());
			preparedStatement.setString(11, nhanVien.getTaiKhoan().getTaiKhoan());
			preparedStatement.setInt(12, nhanVien.getLuong());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		connection.close();
		return false;
	}

}
