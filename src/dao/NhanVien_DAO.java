package dao;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.Region;

import connect.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVien_DAO {
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
				taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTK(resultSet.getString(13));
				ds.add(new NhanVien(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getDate(7), resultSet.getDate(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12), taiKhoan, resultSet.getInt(14)));
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
		TaiKhoan taiKhoan = null;
		TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from NhanVien where maNV = '" + maNV + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTK(resultSet.getString(13));
			nhanVien.setMaNV(maNV);
			nhanVien.setMaCH(resultSet.getString(2));
			nhanVien.setTenNV(resultSet.getString(3));
			nhanVien.setTuoi(resultSet.getInt(4));
			nhanVien.setDiaChi(resultSet.getString(5));
			nhanVien.setGioiTinh(resultSet.getString(6));
			nhanVien.setNgaySinh(resultSet.getDate(7));
			nhanVien.setNgayVaoLam(resultSet.getDate(8));
			nhanVien.setCCCD(resultSet.getString(9));
			nhanVien.setEmail(resultSet.getString(10));
			nhanVien.setSoDienThoai(resultSet.getString(11));
			nhanVien.setChucVu(resultSet.getString(12));
			nhanVien.setTaiKhoan(taiKhoan);
			nhanVien.setLuong(resultSet.getInt(14));
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
			TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoanTheoMaTK(maTK);
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from NhanVien where taiKhoan = '" + maTK + "'");
				while (resultSet.next()) {
					nhanVien.setMaNV(resultSet.getString(1));
					nhanVien.setMaCH(resultSet.getString(2));
					nhanVien.setTenNV(resultSet.getString(3));
					nhanVien.setTuoi(resultSet.getInt(4));
					nhanVien.setDiaChi(resultSet.getString(5));
					nhanVien.setGioiTinh(resultSet.getString(6));
					nhanVien.setNgaySinh(resultSet.getDate(7));
					nhanVien.setNgayVaoLam(resultSet.getDate(8));
					nhanVien.setCCCD(resultSet.getString(9));
					nhanVien.setEmail(resultSet.getString(10));
					nhanVien.setSoDienThoai(resultSet.getString(11));
					nhanVien.setChucVu(resultSet.getString(12));
					nhanVien.setTaiKhoan(taiKhoan);
					nhanVien.setLuong(resultSet.getInt(14));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nhanVien;
		}
}
