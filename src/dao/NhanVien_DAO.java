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
				ds.add(new NhanVien(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getDate(5), resultSet.getDate(6), resultSet.getString(7),
						resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), taiKhoan,
						resultSet.getString(12), resultSet.getString(13)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}

	// get nhan vien theo ten
	public List<NhanVien> getNhanVienTheoTen(String tenNhanVien) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		List<NhanVien> ds = new ArrayList<NhanVien>();
		TaiKhoan taiKhoan;
		TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from NhanVien where tenNhanVien like '%" + tenNhanVien + "%'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTaiKhoan(resultSet.getString(12));
				ds.add(new NhanVien(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getDate(5), resultSet.getDate(6), resultSet.getString(7),
						resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), taiKhoan,
						resultSet.getString(12), resultSet.getString(13)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}

	// get nhan vien theo ma
	public NhanVien getNhanVienTheoMa(String maNhanVien) {
		NhanVien nhanVien = null;
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		taiKhoan_DAO = new TaiKhoan_DAO();
		TaiKhoan taiKhoan = null;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from NhanVien where UPPER(maNhanVien) = UPPER('" + maNhanVien + "')");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTaiKhoan(resultSet.getString(11));
				nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(resultSet.getString(1));
				nhanVien.setTenNhanVien(resultSet.getString(2));
				nhanVien.setDiaChi(resultSet.getString(3));
				nhanVien.setGioiTinh(resultSet.getString(4));
				nhanVien.setNgaySinh(resultSet.getDate(5));
				nhanVien.setNgayVaoLam(resultSet.getDate(6));
				nhanVien.setcCCD(resultSet.getString(7));
				nhanVien.setEmail(resultSet.getString(8));
				nhanVien.setSoDienThoai(resultSet.getString(9));
				nhanVien.setChucVu(resultSet.getString(10));
				nhanVien.setTaiKhoan(taiKhoan);
				nhanVien.setMaCa(resultSet.getString(12));
				nhanVien.setHinhAnh(resultSet.getString(13));
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
				nhanVien.setMaNhanVien(resultSet.getString(1));
				nhanVien.setTenNhanVien(resultSet.getString(2));
				nhanVien.setDiaChi(resultSet.getString(3));
				nhanVien.setGioiTinh(resultSet.getString(4));
				nhanVien.setNgaySinh(resultSet.getDate(5));
				nhanVien.setNgayVaoLam(resultSet.getDate(6));
				nhanVien.setcCCD(resultSet.getString(7));
				nhanVien.setEmail(resultSet.getString(8));
				nhanVien.setSoDienThoai(resultSet.getString(9));
				nhanVien.setChucVu(resultSet.getString(10));
				nhanVien.setTaiKhoan(taiKhoan);
				nhanVien.setMaCa(resultSet.getString(12));
				nhanVien.setHinhAnh(resultSet.getString(13));
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
				nhanVien.setMaNhanVien(resultSet.getString(1));
				nhanVien.setTenNhanVien(resultSet.getString(2));
				nhanVien.setDiaChi(resultSet.getString(3));
				nhanVien.setGioiTinh(resultSet.getString(4));
				nhanVien.setNgaySinh(resultSet.getDate(5));
				nhanVien.setNgayVaoLam(resultSet.getDate(6));
				nhanVien.setcCCD(resultSet.getString(7));
				nhanVien.setEmail(resultSet.getString(8));
				nhanVien.setSoDienThoai(resultSet.getString(9));
				nhanVien.setChucVu(resultSet.getString(10));
				nhanVien.setTaiKhoan(taiKhoan);
				nhanVien.setMaCa(resultSet.getString(12));
				nhanVien.setHinhAnh(resultSet.getString(13));
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
				nhanVien.setMaNhanVien(resultSet.getString(1));
				nhanVien.setTenNhanVien(resultSet.getString(2));
				nhanVien.setDiaChi(resultSet.getString(3));
				nhanVien.setGioiTinh(resultSet.getString(4));
				nhanVien.setNgaySinh(resultSet.getDate(5));
				nhanVien.setNgayVaoLam(resultSet.getDate(6));
				nhanVien.setcCCD(resultSet.getString(7));
				nhanVien.setEmail(resultSet.getString(8));
				nhanVien.setSoDienThoai(resultSet.getString(9));
				nhanVien.setChucVu(resultSet.getString(10));
				nhanVien.setTaiKhoan(taiKhoan);
				nhanVien.setMaCa(resultSet.getString(12));
				nhanVien.setHinhAnh(resultSet.getString(13));
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
			preparedStatement = connection.prepareStatement("insert into NhanVien values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, nhanVien.getMaNhanVien());
			preparedStatement.setString(2, nhanVien.getTenNhanVien());
			preparedStatement.setString(3, nhanVien.getDiaChi());
			preparedStatement.setString(4, nhanVien.getGioiTinh());
			preparedStatement.setDate(5, nhanVien.getNgaySinh());
			preparedStatement.setDate(6, nhanVien.getNgayVaoLam());
			preparedStatement.setString(7, nhanVien.getcCCD());
			preparedStatement.setString(8, nhanVien.getEmail());
			preparedStatement.setString(9, nhanVien.getSoDienThoai());
			preparedStatement.setString(10, nhanVien.getChucVu());
			preparedStatement.setString(11, nhanVien.getTaiKhoan().getTaiKhoan());
			preparedStatement.setString(12, nhanVien.getMaCa());
			preparedStatement.setString(13, nhanVien.getHinhAnh());
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
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from NhanVien where maNhanVien = '" + maNV + "'");
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
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update NhanVien set tenNhanVien = ?, diaChi = ?, gioiTinh = ?, ngaySinh = ?, ngayVaoLam = ?, CCCD = ?, email = ?, soDienThoai = ?, chucVu = ?, maCa, hinhAnh = ? where maNhanVien = '"
							+ nhanVien.getMaNhanVien() + "'");
			preparedStatement.setString(1, nhanVien.getTenNhanVien());
			preparedStatement.setString(2, nhanVien.getDiaChi());
			preparedStatement.setString(3, nhanVien.getGioiTinh());
			preparedStatement.setDate(4, nhanVien.getNgaySinh());
			preparedStatement.setDate(5, nhanVien.getNgayVaoLam());
			preparedStatement.setString(6, nhanVien.getcCCD());
			preparedStatement.setString(7, nhanVien.getEmail());
			preparedStatement.setString(8, nhanVien.getSoDienThoai());
			preparedStatement.setString(9, nhanVien.getChucVu());
			preparedStatement.setString(10, nhanVien.getMaCa());
			preparedStatement.setString(11, nhanVien.getHinhAnh());
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		connection.close();
		return false;
	}

}
