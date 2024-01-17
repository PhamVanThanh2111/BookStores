package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.HoaDon;

public class HoaDon_DAO {
	// get all hoa don
	public ArrayList<HoaDon> getAllHoaDon() {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from HoaDon");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(resultSet.getString(1));
				hoaDon.setMaNhanVien(resultSet.getString(2));
				hoaDon.setMaKhachHang(resultSet.getString(3));
				hoaDon.setNgayLap(resultSet.getDate(4));
				hoaDon.setThanhTien(resultSet.getFloat(5));
				ds.add(hoaDon);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}

	// get hoa don theo ma
	public HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		HoaDon hoaDon = new HoaDon();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from HoaDon where maHoaDon = '" + maHoaDon + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				hoaDon.setMaHoaDon(resultSet.getString(1));
				hoaDon.setMaNhanVien(resultSet.getString(2));
				hoaDon.setMaKhachHang(resultSet.getString(3));
				hoaDon.setNgayLap(resultSet.getDate(4));
				hoaDon.setThanhTien(resultSet.getFloat(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hoaDon;
	}

	// them hoa don
	public boolean lapHoaDon(HoaDon hoaDon) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement("insert into HoaDon values (?,?,?,?,?)");
			preparedStatement.setString(1, hoaDon.getMaHoaDon());
			preparedStatement.setString(2, hoaDon.getMaNhanVien());
			preparedStatement.setString(3, hoaDon.getMaKhachHang());
			preparedStatement.setDate(4, hoaDon.getNgayLap());
			preparedStatement.setFloat(5, hoaDon.getThanhTien());
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		connection.close();
		return false;
	}

	// get danh sach hoa don cua nhan vien theo ngay
	public ArrayList<HoaDon> getListHoaDonTrongNgayTheoMaNhanVien(String maNhanVien) {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from HoaDon where maNhanVien = '" + maNhanVien
							+ "' and ngayLap = CONVERT(DATE, GETDATE())");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(resultSet.getString(1));
				hoaDon.setMaNhanVien(resultSet.getString(2));
				hoaDon.setMaKhachHang(resultSet.getString(3));
				hoaDon.setNgayLap(resultSet.getDate(4));
				hoaDon.setThanhTien(resultSet.getFloat(5));
				ds.add(hoaDon);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}

	// get danh sach hoa don theo ngay
	public ArrayList<HoaDon> getListHoaDonTheoNgay(LocalDate date) { // i là số ngày cách ngày hiện tại. VD: i = 1 (ngay
																		// hom qua)
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from HoaDon where ngayLap = '" + date + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(resultSet.getString(1));
				hoaDon.setMaNhanVien(resultSet.getString(2));
				hoaDon.setMaKhachHang(resultSet.getString(3));
				hoaDon.setNgayLap(resultSet.getDate(4));
				hoaDon.setThanhTien(resultSet.getFloat(5));
				ds.add(hoaDon);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	
	// thống kê top khách hàng mua nhiều nhất
	public ResultSet getDanhSachKhachHangMuaNhieuNhat() {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		ResultSet resultSet = null;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(
							  "SELECT TOP 10 "
							+ "    KH.tenKhachHang, "
							+ "    SUM(HD.thanhTien) AS TongTienMua "
							+ "FROM "
							+ "    HoaDon HD "
							+ "    INNER JOIN KhachHang KH ON HD.maKhachHang = KH.maKhachHang "
							+ "    INNER JOIN ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon "
							+ "GROUP BY "
							+ "    KH.tenKhachHang "
							+ "ORDER BY "
							+ "    TongTienMua DESC; "
							);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultSet;
	}
	
	// thống kê danh sách các sản phẩm bán chạy nhất
	public ResultSet getDanhSachSanPhamBanChay() {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		ResultSet resultSet = null;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(
							"SELECT TOP 8 "
							+ "    SP.maSanPham, "
							+ "    SP.tenSanPham, "
							+ "    SUM(CTHD.soLuong) AS TongSoLuongBan "
							+ "FROM "
							+ "    SanPham SP "
							+ "    INNER JOIN ChiTietHoaDon CTHD ON SP.maSanPham = CTHD.maSanPham "
							+ "GROUP BY "
							+ "    SP.maSanPham, SP.tenSanPham "
							+ "ORDER BY "
							+ "    TongSoLuongBan DESC; "
							);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultSet;
	}
	
	// thống kê doanh thu và số lượng hóa đơn của các nhân viên có doanh thu cao 
	public ResultSet getDanhSachNhanVienTheoDoanhThu() {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		ResultSet resultSet = null;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(
							  "SELECT TOP 7 "
							  + "    NV.maNhanVien, "
							  + "    NV.tenNhanVien, "
							  + "    COUNT(HD.maHoaDon) AS SoLuongHoaDon, "
							  + "    SUM(CTHD.soLuong) AS SoLuongSanPham, "
							  + "    SUM(HD.thanhTien) AS TongDoanhThu "
							  + "FROM "
							  + "    NhanVien NV "
							  + "    LEFT JOIN HoaDon HD ON NV.maNhanVien = HD.maNhanVien "
							  + "    LEFT JOIN ChiTietHoaDon CTHD ON HD.maHoaDon = CTHD.maHoaDon "
							  + "GROUP BY "
							  + "    NV.maNhanVien, NV.tenNhanVien "
							  + "ORDER BY "
							  + "    TongDoanhThu DESC; "
							);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultSet;
	}
}
