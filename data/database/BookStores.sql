USE [master]
GO
/****** Object:  Database [BookStores]    Script Date: 26/09/2023 13:33:00 ******/
CREATE DATABASE [BookStores]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookStores', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\BookStores.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
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
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 26/09/2023 13:33:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHoaDon] [nvarchar](6) NOT NULL,
	[maSach] [nvarchar](5) NULL,
	[maDungCuHocTap] [nvarchar](8) NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DungCuHocTap]    Script Date: 26/09/2023 13:33:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DungCuHocTap](
	[maDungCuHocTap] [nvarchar](8) NOT NULL,
	[tenDungCuHocTap] [nvarchar](20) NOT NULL,
	[gia] [float] NOT NULL,
	[nhaCungCap] [nvarchar](20) NOT NULL,
	[soLuong] [int] NOT NULL,
	[hinhAnh] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_DungCuHocTap] PRIMARY KEY CLUSTERED 
(
	[maDungCuHocTap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 26/09/2023 13:33:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nvarchar](6) NOT NULL,
	[maNhanVien] [nvarchar](6) NOT NULL,
	[maKhachHang] [nvarchar](6) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[tienKhachDua] [float] NOT NULL,
	[thanhTien] [float] NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 26/09/2023 13:33:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nvarchar](6) NOT NULL,
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
/****** Object:  Table [dbo].[LoaiSach]    Script Date: 26/09/2023 13:33:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSach](
	[maLoaiSach] [nvarchar](6) NOT NULL,
	[tenLoaiSach] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_LoaiSach] PRIMARY KEY CLUSTERED 
(
	[maLoaiSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 26/09/2023 13:33:00 ******/
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
	[luong] [float] NOT NULL,
	[ca] [int] NOT NULL,
	[hinhAnh] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NXB]    Script Date: 26/09/2023 13:33:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NXB](
	[maNXB] [nvarchar](7) NOT NULL,
	[tenNXB] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](120) NULL,
	[soDienThoai] [nvarchar](10) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_NXB] PRIMARY KEY CLUSTERED 
(
	[maNXB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sach]    Script Date: 26/09/2023 13:33:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[maSach] [nvarchar](5) NOT NULL,
	[maNXB] [nvarchar](7) NOT NULL,
	[maLoaiSach] [nvarchar](6) NOT NULL,
	[tenSach] [nvarchar](100) NOT NULL,
	[xuatXu] [nvarchar](20) NULL,
	[giaNhap] [float] NOT NULL,
	[tacGia] [nvarchar](50) NOT NULL,
	[soTrang] [int] NULL,
	[gia] [float] NOT NULL,
	[soLuong] [int] NOT NULL,
	[hinhAnh] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Sach] PRIMARY KEY CLUSTERED 
(
	[maSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 26/09/2023 13:33:00 ******/
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
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [diaChi], [gioiTinh], [ngaySinh], [ngayVaoLam], [cCCD], [email], [soDienThoai], [chucVu], [taiKhoan], [luong], [ca], [hinhAnh]) VALUES (N'NV0001', N'Pham Van Thanh', N'Go Xoai', N'Nam', CAST(N'2003-01-01' AS Date), CAST(N'2023-01-01' AS Date), N'274849348023', N'thanh@gmail.com', N'0934004524', N'Quản lý', N'NV0001', 10000000, 1, N'a')
GO
INSERT [dbo].[NXB] ([maNXB], [tenNXB], [diaChi], [soDienThoai], [email]) VALUES (N'NXB001', N'Nhà Xuất Bản Trẻ', N'161B Lý Chính Thắng, phường Võ Thị Sáu, Quận 3, TP. Hồ Chí Minh', N'0239316289', N'hopthubandoc@nxbtre.com.vn 
')
INSERT [dbo].[NXB] ([maNXB], [tenNXB], [diaChi], [soDienThoai], [email]) VALUES (N'NXB002', N'Nhà Xuất Bản Kim Đồng', N'55 Quang Trung, Hà Nội, Việt Nam ', N'0239434730', N'info@nxbkimdong.com.vn ')
INSERT [dbo].[NXB] ([maNXB], [tenNXB], [diaChi], [soDienThoai], [email]) VALUES (N'NXB003', N'Nhà xuất bản Tổng hợp thành phố Hồ Chí Minh', N'62 Nguyễn Thị Minh Khai, Phường Đa Kao, Quận 1, TP. HCM ', N'0238256804', N'nstonhop@gmail.com ')
INSERT [dbo].[NXB] ([maNXB], [tenNXB], [diaChi], [soDienThoai], [email]) VALUES (N'NXB004', N'Nhà xuất bản Hội Nhà Văn', N'65 Nguyễn Du - Hà Nội', N'0243222135', N'nxbhoinhavan65@gmail.com')
GO
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau]) VALUES (N'NV0001', N'NV0001')
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_DungCuHocTap] FOREIGN KEY([maDungCuHocTap])
REFERENCES [dbo].[DungCuHocTap] ([maDungCuHocTap])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_DungCuHocTap]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_Sach] FOREIGN KEY([maSach])
REFERENCES [dbo].[Sach] ([maSach])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_Sach]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_ChiTietHoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[ChiTietHoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_ChiTietHoaDon]
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
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([taiKhoan])
REFERENCES [dbo].[TaiKhoan] ([taiKhoan])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FK_Sach_LoaiSach] FOREIGN KEY([maLoaiSach])
REFERENCES [dbo].[LoaiSach] ([maLoaiSach])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FK_Sach_LoaiSach]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FK_Sach_NXB] FOREIGN KEY([maNXB])
REFERENCES [dbo].[NXB] ([maNXB])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FK_Sach_NXB]
GO
USE [master]
GO
ALTER DATABASE [BookStores] SET  READ_WRITE 
GO
