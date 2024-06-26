USE [master]
GO
/****** Object:  Database [BookStores]    Script Date: 08/03/2024 13:15:03 ******/
CREATE DATABASE [BookStores]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookStores', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\BookStores.mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BookStores_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\BookStores_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [BookStores] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookStores].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BookStores] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookStores] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookStores] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookStores] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookStores] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookStores] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BookStores] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookStores] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookStores] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookStores] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookStores] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookStores] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookStores] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookStores] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookStores] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BookStores] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookStores] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookStores] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookStores] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookStores] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookStores] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookStores] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookStores] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BookStores] SET  MULTI_USER 
GO
ALTER DATABASE [BookStores] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookStores] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookStores] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookStores] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BookStores] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BookStores] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [BookStores] SET QUERY_STORE = ON
GO
ALTER DATABASE [BookStores] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [BookStores]
GO
/****** Object:  Table [dbo].[Ca]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ca](
	[maCa] [nvarchar](3) NOT NULL,
	[tenCa] [nvarchar](2) NOT NULL,
	[thoiGian] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Ca] PRIMARY KEY CLUSTERED 
(
	[maCa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHoaDon] [nvarchar](7) NOT NULL,
	[maSanPham] [nvarchar](9) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon_1] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC,
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuDatHang]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuDatHang](
	[maPhieuDatHang] [nvarchar](7) NOT NULL,
	[maSanPham] [nvarchar](9) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietPhieuDat] PRIMARY KEY CLUSTERED 
(
	[maPhieuDatHang] ASC,
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nvarchar](7) NOT NULL,
	[maNhanVien] [nvarchar](6) NOT NULL,
	[maKhachHang] [nvarchar](7) NULL,
	[ngayLap] [date] NOT NULL,
	[thanhTien] [float] NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nvarchar](7) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[gioiTinh] [nvarchar](5) NULL,
	[soDienThoai] [nvarchar](10) NOT NULL,
	[diaChi] [nvarchar](110) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNhaCungCap] [nvarchar](7) NOT NULL,
	[tenNhaCungCap] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](120) NOT NULL,
	[soDienThoai] [nvarchar](10) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[maNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nvarchar](6) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](120) NOT NULL,
	[gioiTinh] [nvarchar](5) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[ngayVaoLam] [date] NOT NULL,
	[cCCD] [nvarchar](12) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[soDienThoai] [nvarchar](10) NOT NULL,
	[chucVu] [nvarchar](10) NOT NULL,
	[taiKhoan] [nvarchar](6) NOT NULL,
	[maCa] [nvarchar](3) NOT NULL,
	[hinhAnh] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaXuatBan]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaXuatBan](
	[maNhaXuatBan] [nvarchar](7) NOT NULL,
	[tenNhaXuatBan] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](120) NULL,
	[soDienThoai] [nvarchar](10) NOT NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_NXB] PRIMARY KEY CLUSTERED 
(
	[maNhaXuatBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatHang]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatHang](
	[maPhieuDatHang] [nvarchar](7) NOT NULL,
	[maNhanVien] [nvarchar](6) NOT NULL,
	[maKhachHang] [nvarchar](7) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[thanhTien] [float] NOT NULL,
 CONSTRAINT [PK_PhieuDat] PRIMARY KEY CLUSTERED 
(
	[maPhieuDatHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [nvarchar](9) NOT NULL,
	[tenSanPham] [nvarchar](50) NOT NULL,
	[xuatXu] [nvarchar](20) NOT NULL,
	[giaNhap] [float] NOT NULL,
	[giaBan] [float] NOT NULL,
	[soLuongTon] [int] NOT NULL,
	[hinhAnh] [nvarchar](50) NOT NULL,
	[maNXB] [nvarchar](7) NULL,
	[maTheLoaiSach] [nvarchar](7) NULL,
	[tacGia] [nvarchar](50) NULL,
	[soTrang] [int] NULL,
	[namXuatBan] [int] NULL,
	[maNhaCungCap] [nvarchar](7) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[taiKhoan] [nvarchar](6) NOT NULL,
	[matKhau] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[taiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TheLoaiSach]    Script Date: 08/03/2024 13:15:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TheLoaiSach](
	[maTheLoaiSach] [nvarchar](7) NOT NULL,
	[tenTheLoaiSach] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LoaiSach] PRIMARY KEY CLUSTERED 
(
	[maTheLoaiSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Ca] ([maCa], [tenCa], [thoiGian]) VALUES (N'C01', N'01', N'09h - 16h')
INSERT [dbo].[Ca] ([maCa], [tenCa], [thoiGian]) VALUES (N'C02', N'02', N'16h - 22h')
GO
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00001', N'S00001', 2, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00002', N'DCHT00001', 2, 4000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00002', N'S00003', 2, 63000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00003', N'S00010', 1, 40000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00004', N'S00008', 2, 160000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00005', N'S00003', 1, 63000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00006', N'S00009', 2, 150000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00007', N'S00008', 1, 160000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00008', N'S00008', 1, 160000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00009', N'DCHT00006', 1, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00009', N'DCHT00008', 2, 7000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00010', N'S00003', 2, 63000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00011', N'S00007', 2, 220000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00012', N'S00001', 1, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00013', N'DCHT00012', 2, 627000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00014', N'DCHT00011', 1, 250000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00014', N'S00001', 2, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00015', N'DCHT00007', 2, 6000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00016', N'S00001', 2, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00017', N'DCHT00009', 2, 720000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00017', N'S00001', 2, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00018', N'S00001', 3, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00019', N'S00001', 2, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00020', N'S00001', 2, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00021', N'S00001', 1, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00022', N'S00001', 2, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00023', N'DCHT00010', 2, 5000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00023', N'S00001', 2, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00023', N'S00006', 2, 310000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00024', N'S00004', 2, 250000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00025', N'S00004', 2, 250000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00026', N'S00004', 10, 230000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00027', N'DCHT00005', 1, 7000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00028', N'DCHT00009', 10, 5500000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00029', N'DCHT00012', 10, 6270000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00030', N'DCHT00002', 1, 7000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00031', N'DCHT00002', 2, 7000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00032', N'S00001', 2, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00033', N'S00004', 10, 2300000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00034', N'S00006', 10, 2700000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00035', N'S00001', 1, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00036', N'S00001', 1, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00037', N'S00001', 2, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00038', N'S00001', 2, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00039', N'DCHT00003', 3, 5000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00039', N'S00007', 2, 220000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00040', N'S00002', 2, 100000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00041', N'DCHT00019', 2, 10000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00042', N'S00010', 1, 40000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00043', N'S00010', 1, 40000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00044', N'S00001', 1, 70000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00045', N'DCHT00005', 1, 7000)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia]) VALUES (N'HD00046', N'S00001', 1, 70000)
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00001', N'NV0001', N'KH00001', CAST(N'2023-12-12' AS Date), 140000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00002', N'NV0001', N'KH00002', CAST(N'2023-12-12' AS Date), 134000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00003', N'NV0001', N'KH00004', CAST(N'2023-12-12' AS Date), 40000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00004', N'NV0001', N'KH00005', CAST(N'2023-12-12' AS Date), 320000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00005', N'NV0001', N'KH00006', CAST(N'2023-12-12' AS Date), 63000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00006', N'NV0001', N'KH00007', CAST(N'2023-12-12' AS Date), 300000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00007', N'NV0001', N'KH00008', CAST(N'2023-12-12' AS Date), 160000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00008', N'NV0002', N'KH00009', CAST(N'2023-12-11' AS Date), 160000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00009', N'NV0002', N'KH00010', CAST(N'2023-12-12' AS Date), 84000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00010', N'NV0002', N'KH00011', CAST(N'2023-12-12' AS Date), 126000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00011', N'NV0002', N'KH00013', CAST(N'2023-12-12' AS Date), 440000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00012', N'NV0002', N'KH00014', CAST(N'2023-12-12' AS Date), 70000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00013', N'NV0002', N'KH00015', CAST(N'2023-12-12' AS Date), 1254000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00014', N'NV0003', N'KH00016', CAST(N'2023-12-12' AS Date), 390000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00015', N'NV0003', N'KH00017', CAST(N'2023-12-12' AS Date), 12000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00016', N'NV0003', N'KH00019', CAST(N'2023-12-12' AS Date), 140000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00017', N'NV0003', N'KH00020', CAST(N'2023-12-12' AS Date), 1580000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00018', N'NV0003', N'KH00021', CAST(N'2023-12-12' AS Date), 210000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00019', N'NV0004', N'KH00021', CAST(N'2023-12-12' AS Date), 140000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00020', N'NV0004', N'KH00012', CAST(N'2023-12-12' AS Date), 140000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00021', N'NV0001', N'KH00001', CAST(N'2023-12-12' AS Date), 70000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00022', N'NV0004', N'KH00001', CAST(N'2023-12-12' AS Date), 140000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00023', N'NV0004', N'KH00001', CAST(N'2023-12-12' AS Date), 770000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00024', N'NV0005', N'KH00001', CAST(N'2023-12-12' AS Date), 500000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00025', N'NV0005', N'KH00001', CAST(N'2023-12-12' AS Date), 500000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00026', N'NV0001', N'KH00001', CAST(N'2023-12-11' AS Date), 2300000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00027', N'NV0001', N'KH00001', CAST(N'2023-12-12' AS Date), 7000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00028', N'NV0002', N'KH00002', CAST(N'2023-12-10' AS Date), 5500000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00029', N'NV0003', N'KH00003', CAST(N'2023-12-09' AS Date), 6270000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00030', N'NV0001', N'KH00001', CAST(N'2023-12-12' AS Date), 7000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00031', N'NV0001', N'KH00001', CAST(N'2023-12-12' AS Date), 14000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00032', N'NV0001', N'KH00015', CAST(N'2023-12-12' AS Date), 140000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00033', N'NV0004', N'KH00004', CAST(N'2023-12-08' AS Date), 2300000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00034', N'NV0005', N'KH00005', CAST(N'2023-12-07' AS Date), 2700000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00035', N'NV0001', N'KH00018', CAST(N'2023-12-12' AS Date), 70000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00036', N'NV0001', N'KH00001', CAST(N'2023-12-12' AS Date), 70000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00037', N'NV0001', N'KH00016', CAST(N'2023-12-12' AS Date), 140000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00038', N'NV0001', N'KH00014', CAST(N'2023-12-13' AS Date), 140000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00039', N'NV0001', N'KH00012', CAST(N'2023-12-13' AS Date), 455000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00040', N'NV0001', N'KH00012', CAST(N'2023-12-13' AS Date), 200000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00041', N'NV0001', N'KH00023', CAST(N'2024-03-07' AS Date), 20000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00042', N'NV0001', N'KH00023', CAST(N'2024-03-07' AS Date), 40000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00043', N'NV0001', N'KH00023', CAST(N'2024-03-07' AS Date), 40000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00044', N'NV0001', NULL, CAST(N'2024-03-07' AS Date), 70000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00045', N'NV0001', NULL, CAST(N'2024-03-07' AS Date), 7000)
INSERT [dbo].[HoaDon] ([maHoaDon], [maNhanVien], [maKhachHang], [ngayLap], [thanhTien]) VALUES (N'HD00046', N'NV0001', NULL, CAST(N'2024-03-08' AS Date), 70000)
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00001', N'Trịnh Minh Kha', N'Nam', N'0123456789', N'Thành phố Vĩnh Long, Tỉnh Vĩnh Long.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00002', N'Võ Văn Bạch', N'Nam', N'0355208069', N'Huyện Giồng Trôm, Tỉnh Bến Tre.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00003', N'Lê Hoàng Bảo', N'Nam', N'0373498729', N'Thị xã La Gi, Tỉnh Bình Thuận.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00004', N'Trương Chí Bảo', N'Nam', N'0774025712', N'Quận 12, Thành phố Hồ Chí Minh.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00005', N'Nguyễn Trọng Đại', N'Nam', N'0987837712', N'Huyện Tây Sơn, Tỉnh Bình Định.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00006', N'Phạm Quốc Đại', N'Nam', N'0834886058', N'Thành phố Châu Đốc, Tỉnh An Giang.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00007', N'Phi Anh Đạt', N'Nam', N'0935531991', N'Quận Gò Vấp, Thành phố Hồ Chí Minh.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00008', N'Lê Trí Đức', N'Nam', N'0703198828', N'Quận 1, Thành phố Hồ Chí Minh.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00009', N'Vũ Nguyễn Minh Đức', N'Nam', N'0369160539', N'Quận Tân Phú, Thành phố Hồ Chí Minh.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00010', N'Bùi Phương Duy', N'Nam', N'0352160178', N'Thành phố Hưng Yên, Tỉnh Hưng Yên.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00011', N'Nguyễn Trường Huy', N'Nam', N'0343806292', N'Huyện Cẩm Mỹ, Tỉnh Đồng Nai.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00012', N'Trần Ngô Bảo', N'Nam', N'0364972537', N'Quận 6, Thành phố Hồ Chí Minh.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00013', N'Đinh Văn Khanh', N'Nam', N'0374490438', N'Huyện Quế Sơn, Tỉnh Quảng Nam.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00014', N'Đinh Quốc Khánh', N'Nam', N'0523323213', N'Quận 3, Thành phố Hồ Chí Minh.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00015', N'Võ Phạm Đăng Khoa', N'Nam', N'0935912495', N'Thành phố Nha Trang, Tỉnh Khánh Hòa.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00016', N'Kiều Nhật Lệ', N'Nam', N'0786597684', N'Thị xã Dĩ An, Tỉnh Bình Dương.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00017', N'Nguyễn Thành Long', N'Nam', N'0834913675', N'Huyện Chợ Gạo, Tỉnh Tiền Giang.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00018', N'Phan Khôi Nguyên', N'Nam', N'0947767934', N'Thành phố Vũng Tàu, Tỉnh Bà Rịa - Vũng Tàu.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00019', N'Đinh Thị Tuyết Nhi', N'Nữ', N'0979294182', N'Quận 12, Thành phố Hồ Chí Minh.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00020', N'Hồ Trường Minh Phú', N'Nam', N'0343989667', N'Huyện Cai lậy, Tỉnh Tiền Giang.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00021', N'Phan Đường Bảo Phúc', N'Nam', N'0365069728', N'Huyện Cai lậy, Tỉnh Tiền Giang.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00022', N'Đinh Thị Ngọc Thanh', N'Nữ', N'0367005956', N'Huyện Hóc Môn, Thành phố Hồ Chí Minh.')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [gioiTinh], [soDienThoai], [diaChi]) VALUES (N'KH00023', N'Phạm Văn Thành', N'Nam', N'0934004524', N'Bình Tân')
GO
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [diaChi], [soDienThoai], [email]) VALUES (N'NCC0001', N'Thiên Long', N'Tầng 10, Sofic Tower, Số 10 Đường Mai Chí Thọ, Phường Thủ Thiêm, Thành Phố Thủ Đức, Thành Phố Hồ Chí Minh, Việt Nam', N'1900866819', N'salesonline@thienlongvn.com

')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [diaChi], [soDienThoai], [email]) VALUES (N'NCC0002', N'Marvy Uchida', N'220/9 Phan Văn Hân, Phường 17, Quận Bình Thạnh, TPHCM', N'0903692603', N'vantaiquocanh@gmail.com')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [diaChi], [soDienThoai], [email]) VALUES (N'NCC0003', N'Việt Tinh Anh', N'33-35 đường D4, khu Đô thị mới Him Lam, Phường Tân Hưng, Quận 7, TP. Hồ Chí Minh', N'0309132354', N'vta@gmail.com')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [diaChi], [soDienThoai], [email]) VALUES (N'NCC0004', N'LAQ', N'115/25/1 đường Lê Văn Sỹ, phường 13, quận Phú Nhuận, Tp. Hồ Chí Minh', N'0239314627', N'hotro@laq.vn')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [diaChi], [gioiTinh], [ngaySinh], [ngayVaoLam], [cCCD], [email], [soDienThoai], [chucVu], [taiKhoan], [maCa], [hinhAnh]) VALUES (N'NV0001', N'Phạm Văn Thành', N'Gò Xoài', N'Nam', CAST(N'2003-01-01' AS Date), CAST(N'2023-01-01' AS Date), N'206381313', N'phamtrung21112003@gmail.com', N'0934004524', N'Quản lý', N'NV0001', N'C01', N'/image/NhanVien/PhamVanThanh.png')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [diaChi], [gioiTinh], [ngaySinh], [ngayVaoLam], [cCCD], [email], [soDienThoai], [chucVu], [taiKhoan], [maCa], [hinhAnh]) VALUES (N'NV0002', N'Trần Thanh Tâm', N'Bùi Đình Túy', N'Nam', CAST(N'2003-01-01' AS Date), CAST(N'2023-10-29' AS Date), N'077203005398', N'phamtrung21112003@gmail.com', N'0934004524', N'Bán hàng', N'NV0002', N'C01', N'/image/NhanVien/TranThanhTam.png')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [diaChi], [gioiTinh], [ngaySinh], [ngayVaoLam], [cCCD], [email], [soDienThoai], [chucVu], [taiKhoan], [maCa], [hinhAnh]) VALUES (N'NV0003', N'Mai Lưu Hữu Vinh', N'Lê Lai', N'Nam', CAST(N'2003-01-01' AS Date), CAST(N'2023-10-29' AS Date), N'072030062412', N'phamtrung21112003@gmail.com', N'0934004524', N'Bán hàng', N'NV0003', N'C01', N'/image/NhanVien/MaiLuuHuuVinh.png')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [diaChi], [gioiTinh], [ngaySinh], [ngayVaoLam], [cCCD], [email], [soDienThoai], [chucVu], [taiKhoan], [maCa], [hinhAnh]) VALUES (N'NV0004', N'Đàm Ngọc Sơn', N'Hà Nội', N'Nam', CAST(N'2003-01-01' AS Date), CAST(N'2023-11-12' AS Date), N'347582572375', N'bachtran246@gmail.com', N'0823715461', N'Bán hàng', N'NV0004', N'C01', N'/image/NhanVien/DamNgocSon.png')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [diaChi], [gioiTinh], [ngaySinh], [ngayVaoLam], [cCCD], [email], [soDienThoai], [chucVu], [taiKhoan], [maCa], [hinhAnh]) VALUES (N'NV0005', N'Nguyễn Ngọc Anh', N'Hà Nội', N'Nữ', CAST(N'2003-01-01' AS Date), CAST(N'2023-12-12' AS Date), N'372352737542', N'anhNguyen246@gmail.com', N'0982662346', N'Bán hàng', N'NV0005', N'C01', N'/image/NhanVien/NguyenNgocAnh.png')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [diaChi], [gioiTinh], [ngaySinh], [ngayVaoLam], [cCCD], [email], [soDienThoai], [chucVu], [taiKhoan], [maCa], [hinhAnh]) VALUES (N'NV0006', N'Nguyễn Thanh Tài', N'Hà Nội', N'Nam', CAST(N'2003-01-01' AS Date), CAST(N'2023-12-12' AS Date), N'726526346332', N'taiNguyen@gmail.com', N'0876782366', N'Bán hàng', N'NV0006', N'C01', N'/image/NhanVien/NguyenThanhTai.png')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [diaChi], [gioiTinh], [ngaySinh], [ngayVaoLam], [cCCD], [email], [soDienThoai], [chucVu], [taiKhoan], [maCa], [hinhAnh]) VALUES (N'NV0007', N'Phan Mỹ Tâm', N'Đà Nẵng', N'Nữ', CAST(N'2003-01-01' AS Date), CAST(N'2023-12-12' AS Date), N'626417471284', N'Tam@gmail.com', N'0927652634', N'Bán hàng', N'NV0007', N'C01', N'/image/NhanVien/PhanMyTam.png')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [diaChi], [gioiTinh], [ngaySinh], [ngayVaoLam], [cCCD], [email], [soDienThoai], [chucVu], [taiKhoan], [maCa], [hinhAnh]) VALUES (N'NV0008', N'Hồ Văn Tài', N'TPHCM', N'Nam', CAST(N'2003-01-01' AS Date), CAST(N'2023-12-12' AS Date), N'727238423857', N'taiHo@gmail.com', N'0963642732', N'Bán hàng', N'NV0008', N'C01', N'/image/NhanVien/HoVanTai.jpg')
GO
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [tenNhaXuatBan], [diaChi], [soDienThoai], [email]) VALUES (N'NXB0001', N'Trẻ', N'161B Lý Chính Thắng, Võ Thị Sáu, Quận 3, Thành phố Hồ Chí Minh', N'0273924198', N'chinhanhdongnambo@nxbtre.com.vn')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [tenNhaXuatBan], [diaChi], [soDienThoai], [email]) VALUES (N'NXB0002', N'Kim Đồng', N'Số 55 Quang Trung, Nguyễn Du, Hai Bà Trưng, Hà Nội', N'0283931628', N'cskh_online@nxbkimdong.com.vn')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [tenNhaXuatBan], [diaChi], [soDienThoai], [email]) VALUES (N'NXB0003', N'Hội Nhà Văn', N'SỐ 65 NGUYỄN DU, QUẬN HAI BÀ TRƯNG, HÀ NỘI', N'0438222135', N'nxbhoinhavan65@gmail.com')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [tenNhaXuatBan], [diaChi], [soDienThoai], [email]) VALUES (N'NXB0004', N'Tri Thức', N'ngõ 19, phố Duy Tân, phường Dịch Vọng Hậu, quận Cầu Giấy, Hà Nội, Việt Nam.', N'0838323839', N'lienhe@nxbtrithuc.com.vn')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [tenNhaXuatBan], [diaChi], [soDienThoai], [email]) VALUES (N'NXB0005', N'Tổng Hợp TPHCM', N'62 Nguyễn Thị Minh Khai, phường Đa Kao, quận 1, TPHCM', N'0838256804', N'tonghop@nxbhcm.com.vn')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [tenNhaXuatBan], [diaChi], [soDienThoai], [email]) VALUES (N'NXB0006', N'Dân Trí', N'Công ty cổ phần Vận tải biển và Thương mại Phương Đông, số 278 Tôn Đức Thắng, Hàng Bột, Đống Đa, Hà Nội.', N'0466860751', N'nxbdantri@gmail.com')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [tenNhaXuatBan], [diaChi], [soDienThoai], [email]) VALUES (N'NXB0007', N'Arrow Books', N'5270 N Park PL NE Ste 114 Cedar Rapids, IA, 52402 ', N'3193957833', N'orders@arrowbookstore.com')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [tenNhaXuatBan], [diaChi], [soDienThoai], [email]) VALUES (N'NXB0008', N'Thế Giới', N'46 Trần Hưng Đạo, Hoàn Kiếm, Hanoi, Vietnam', N'0438253841', N'thegioi@thegioipublishers.vn')
GO
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00001', N'Bút chì 2B', N'Việt Nam', 2000, 4000, 1, N'/image/DungCuHocTap/butChi.png', NULL, NULL, NULL, 0, 0, N'NCC0001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00002', N'Vở', N'Việt Nam', 5000, 7000, 45, N'/image/DungCuHocTap/sotay.jpg', NULL, NULL, NULL, 0, 0, N'NCC0004')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00003', N'Thước kẻ', N'Việt Nam', 3000, 5000, 17, N'/image/DungCuHocTap/thuocdai.png', NULL, NULL, NULL, 0, 0, N'NCC0001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00004', N'Sách ghi chú', N'Việt Nam', 3000, 5000, 20, N'/image/DungCuHocTap/sghichu.jpg', NULL, NULL, NULL, 0, 0, N'NCC0002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00005', N'Bút màu', N'Việt Nam', 5000, 7000, 18, N'/image/DungCuHocTap/butmau.jpg', NULL, NULL, NULL, 0, 0, N'NCC0002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00006', N'Bảng đen', N'Việt Nam', 60000, 70000, 19, N'/image/DungCuHocTap/banhden.jpg', NULL, NULL, NULL, 0, 0, N'NCC0001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00007', N'Thước dây', N'Việt Nam', 3000, 6000, 18, N'/image/DungCuHocTap/thuocDay.jpg', NULL, NULL, NULL, 0, 0, N'NCC0002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00008', N'Kẹp giấy', N'Việt Nam', 3000, 7000, 18, N'/image/DungCuHocTap/kẹp giấy.jpg', NULL, NULL, NULL, 0, 0, N'NCC0002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00009', N'Máy tính bỏ túi Casio 580', N'Việt Nam', 550000, 720000, 18, N'/image/DungCuHocTap/fx580.jpg', NULL, NULL, NULL, 0, 0, N'NCC0001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00010', N'Bút mực 0.5 mm - Mực xanh', N'Việt Nam', 2500, 5000, 18, N'/image/DungCuHocTap/Bút mực 0.5 mm - Mực xanh.jpg', NULL, NULL, NULL, 0, 0, N'NCC0001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00011', N'Cặp xách học sinh', N'Việt Nam', 190000, 250000, 19, N'/image/DungCuHocTap/caphs.jpg', NULL, NULL, NULL, 0, 0, N'NCC0002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00012', N'Máy tính cá nhân Casio fx-570VN PLUS NEW', N'Việt Nam', 520000, 627000, 17, N'/image/DungCuHocTap/maytinh570.jpg', NULL, NULL, NULL, 0, 0, N'NCC0001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00013', N'Giấy màu thủ công', N'Việt Nam', 3000, 8000, 20, N'/image/DungCuHocTap/giaymaythucong.jpg', NULL, NULL, NULL, 0, 0, N'NCC0002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00014', N'Sổ Tay', N'Việt Nam', 15000, 25000, 20, N'/image/DungCuHocTap/sotay.jpg', NULL, NULL, NULL, 0, 0, N'NCC0001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00015', N'Bút Lông Cừu', N'Việt Nam', 20000, 28000, 18, N'/image/DungCuHocTap/butlongcuu.jpg', NULL, NULL, NULL, 0, 0, N'NCC0004')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00016', N'Thước Dài', N'Việt Nam', 10000, 14000, 20, N'/image/DungCuHocTap/thuocdai.png', NULL, NULL, NULL, 0, 0, N'NCC0001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00017', N'Kéo Cắt Giấy', N'Việt Nam', 15000, 20000, 20, N'/image/DungCuHocTap/keocatgiay.jpg', NULL, NULL, NULL, 0, 0, N'NCC0002')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00018', N'Hộp Màu Nước', N'Việt Nam', 20000, 35000, 20, N'/image/DungCuHocTap/hopmaunuoc.jpg', NULL, NULL, NULL, 0, 0, N'NCC0001')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'DCHT00019', N'Thước Đo Góc', N'Việt Nam', 7000, 10000, 18, N'/image/DungCuHocTap/thuocdodo.jpg', NULL, NULL, NULL, 0, 0, N'NCC0004')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'S00001', N'Trên Đường Băng', N'Việt Nam', 50000, 70000, 166, N'/image/Sach/trenduongbang.jpg', N'NXB0001', N'TL0002', N'Tony Buổi Sáng', 200, 2024, NULL)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'S00002', N'Đắc Nhân Tâm', N'Việt Nam', 80000, 100000, 22, N'/image/Sach/dacnhantam.jpg', N'NXB0005', N'TL0002', N'Dale Carnegie', 500, 2023, NULL)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'S00003', N'Nhà Giả Kim (Tái Bản 2020)', N'Nước Ngoài', 50000, 63000, 12, N'/image/Sach/nhagiakim.jpg', N'NXB0003', N'TL0003', N'Paulo Coelho', 227, 2020, NULL)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'S00004', N'Harry Potter', N'Nước Ngoài', 230000, 250000, 34, N'/image/Sach/rybotter.jpg', N'NXB0001', N'TL0003', N'J. K. Rowling', 366, 1997, NULL)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'S00005', N'Lược sử loài người', N'Nước Ngoài', 170000, 200000, 35, N'/image/Sach/luocsuloainguoi.jpg', N'NXB0004', N'TL0007', N' Nguyễn Thủy Chung', 554, 2011, NULL)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'S00006', N'Clean Code', N'Nước Ngoài', 270000, 310000, 27, N'/image/Sach/cleancode.jpg', N'NXB0006', N'TL0004', N'Robert C. Martin', 596, 2023, NULL)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'S00007', N'The Catcher in the Rye', N'Hoa Kỳ', 170000, 220000, 24, N'/image/Sach/catcher in the rye.png', N'NXB0004', N'TL0005', N'J.D. Salinger', 160, 1951, NULL)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'S00008', N'To Kill a Mockingbird', N'Nước Ngoài', 100000, 160000, 36, N'/image/Sach/to kill a Mockingbird.png', N'NXB0007', N'TL0005', N'Harper Lee', 180, 1960, NULL)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'S00009', N'The Great Gatsby', N'Nước Ngoài', 100000, 150000, 38, N'/image/Sach/thr great gatsby.png', N'NXB0008', N'TL0005', N'F. Scott Fitzgerald', 190, 1925, NULL)
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [xuatXu], [giaNhap], [giaBan], [soLuongTon], [hinhAnh], [maNXB], [maTheLoaiSach], [tacGia], [soTrang], [namXuatBan], [maNhaCungCap]) VALUES (N'S00010', N'Dế Mèn Phiêu Lưu Ký', N'Việt Nam', 30000, 40000, 36, N'/image/Sach/demen.jpg', N'NXB0002', N'TL0006', N'Tô Hoài', 200, 2020, NULL)
GO
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'NV0001', N'NV0001')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'NV0002', N'NV0002')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'NV0003', N'NV0003')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'NV0004', N'NV0004')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'NV0005', N'NV0005')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'NV0006', N'NV0006')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'NV0007', N'NV0007')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'NV0008', N'NV0008')
GO
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0001', N'Tâm lý')
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0002', N'Phát triển bản thân')
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0003', N'Phiêu lưu')
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0004', N'Lập trình')
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0005', N'Tiểu thuyết')
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0006', N'Thiếu nhi')
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0007', N'Lịch sử')
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuDat_PhieuDat] FOREIGN KEY([maPhieuDatHang])
REFERENCES [dbo].[PhieuDatHang] ([maPhieuDatHang])
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang] CHECK CONSTRAINT [FK_ChiTietPhieuDat_PhieuDat]
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuDat_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang] CHECK CONSTRAINT [FK_ChiTietPhieuDat_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_Ca] FOREIGN KEY([maCa])
REFERENCES [dbo].[Ca] ([maCa])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_Ca]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan1] FOREIGN KEY([taiKhoan])
REFERENCES [dbo].[TaiKhoan] ([taiKhoan])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan1]
GO
ALTER TABLE [dbo].[PhieuDatHang]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDat_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[PhieuDatHang] CHECK CONSTRAINT [FK_PhieuDat_KhachHang]
GO
ALTER TABLE [dbo].[PhieuDatHang]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDat_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuDatHang] CHECK CONSTRAINT [FK_PhieuDat_NhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaCungCap] FOREIGN KEY([maNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([maNhaCungCap])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaCungCap]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NXB] FOREIGN KEY([maNXB])
REFERENCES [dbo].[NhaXuatBan] ([maNhaXuatBan])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NXB]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_TheLoaiSach] FOREIGN KEY([maTheLoaiSach])
REFERENCES [dbo].[TheLoaiSach] ([maTheLoaiSach])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_TheLoaiSach]
GO
USE [master]
GO
ALTER DATABASE [BookStores] SET  READ_WRITE 
GO
