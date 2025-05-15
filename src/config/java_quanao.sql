-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2025 at 08:13 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_quanao`
--

-- --------------------------------------------------------

--
-- Table structure for table `ao`
--

CREATE TABLE `ao` (
  `MALOAI` int(11) NOT NULL,
  `TENAO` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cthd`
--

CREATE TABLE `cthd` (
  `MAHD` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `MAPB` int(11) NOT NULL,
  `SL` int(11) NOT NULL,
  `DONGIA` int(11) NOT NULL,
  `THANHTIEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctkm`
--

CREATE TABLE `ctkm` (
  `MACTKM` int(11) NOT NULL,
  `NGAYBD` varchar(20) NOT NULL,
  `NGAYKT` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `ctkm`
--

INSERT INTO `ctkm` (`MACTKM`, `NGAYBD`, `NGAYKT`) VALUES
(16, '01/05/2025', '31/05/2025'),
(17, '01/04/2025', '30/04/2025');

-- --------------------------------------------------------

--
-- Table structure for table `ctkmhd`
--

CREATE TABLE `ctkmhd` (
  `MACTKMHD` int(11) NOT NULL,
  `MACTKM` int(11) NOT NULL,
  `TONGTIENHD` int(11) NOT NULL,
  `PTGG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `ctkmhd`
--

INSERT INTO `ctkmhd` (`MACTKMHD`, `MACTKM`, `TONGTIENHD`, `PTGG`) VALUES
(5, 16, 100000, 5),
(6, 16, 200000, 10),
(7, 16, 300000, 15),
(8, 17, 100000, 50);

-- --------------------------------------------------------

--
-- Table structure for table `ctkmsp`
--

CREATE TABLE `ctkmsp` (
  `MACTKM` int(11) NOT NULL,
  `MACTKMSP` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `PTGG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `ctkmsp`
--

INSERT INTO `ctkmsp` (`MACTKM`, `MACTKMSP`, `MASP`, `PTGG`) VALUES
(16, 1, 1, 12),
(16, 2, 2, 10),
(17, 3, 5, 12),
(16, 4, 3, 30),
(16, 5, 4, 5),
(16, 6, 6, 24);

-- --------------------------------------------------------

--
-- Table structure for table `ctpn`
--

CREATE TABLE `ctpn` (
  `MAPN` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `MAPB` int(11) NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `DONGIA` int(11) NOT NULL,
  `THANHTIEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctpn`
--

INSERT INTO `ctpn` (`MAPN`, `MASP`, `MAPB`, `SOLUONG`, `DONGIA`, `THANHTIEN`) VALUES
(1, 1, 1, 20, 150000, 3000000),
(1, 1, 2, 30, 150000, 4500000),
(1, 1, 3, 15, 150000, 2250000),
(1, 2, 4, 25, 300000, 7500000),
(1, 2, 5, 20, 300000, 6000000),
(1, 3, 6, 35, 350000, 12250000),
(1, 3, 7, 25, 350000, 8750000),
(1, 4, 8, 40, 400000, 16000000),
(1, 4, 9, 30, 400000, 12000000),
(1, 5, 10, 45, 380000, 17100000),
(1, 5, 11, 35, 380000, 13300000),
(2, 6, 12, 30, 120000, 3600000),
(2, 6, 13, 40, 120000, 4800000),
(2, 6, 14, 25, 120000, 3000000),
(2, 7, 15, 35, 180000, 6300000),
(2, 7, 16, 45, 180000, 8100000),
(2, 7, 17, 20, 180000, 3600000),
(2, 8, 18, 50, 150000, 7500000),
(2, 8, 19, 60, 150000, 9000000),
(2, 8, 20, 40, 150000, 6000000),
(2, 9, 21, 20, 200000, 4000000),
(2, 9, 22, 30, 200000, 6000000),
(2, 9, 23, 25, 200000, 5000000),
(2, 10, 24, 35, 220000, 7700000),
(2, 10, 25, 40, 220000, 8800000),
(2, 10, 26, 28, 220000, 6160000);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MAHD` int(11) NOT NULL,
  `NGAYLAP` varchar(20) NOT NULL,
  `MANV` int(11) NOT NULL,
  `MAKH` int(11) NOT NULL,
  `TONGTIEN` int(11) NOT NULL,
  `TRANGTHAI` int(11) DEFAULT 0,
  `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKH` int(11) NOT NULL,
  `HOKH` varchar(50) NOT NULL,
  `TENKH` varchar(50) NOT NULL,
  `SDT` varchar(11) NOT NULL,
  `DIACHI` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MAKH`, `HOKH`, `TENKH`, `SDT`, `DIACHI`, `EMAIL`, `is_deleted`) VALUES
(1, 'Smith', 'John', '0932456781', '123 Main St, Springfield, IL', 'john.smith@example.com', 0),
(2, 'Johnson', 'Emily', '0943678210', '456 Elm St, Austin, TX', 'emily.johnson@example.com', 0),
(3, 'Williams', 'Michael', '0965843212', '789 Oak Ave, Denver, CO', 'michael.williams@example.com', 0),
(4, 'Brown', 'Sarah', '0912457693', '321 Pine Rd, Portland, OR', 'sarah.brown@example.com', 0),
(5, 'Jones', 'David', '0982345611', '654 Cedar St, Miami, FL', 'david.jones@example.com', 0),
(6, 'Garcia', 'Laura', '0901123456', '987 Birch Blvd, Seattle, WA', 'laura.garcia@example.com', 0),
(7, 'Miller', 'James', '0934567890', '159 Maple Ln, Boston, MA', 'james.miller@example.com', 0),
(8, 'Davis', 'Olivia', '0978563412', '753 Cherry Dr, Chicago, IL', 'olivia.davis@example.com', 0),
(9, 'Rodriguez', 'Robert', '0911765432', '852 Willow St, Atlanta, GA', 'robert.rodriguez@example.com', 0),
(10, 'Martinez', 'Sophia', '0965432187', '951 Aspen Way, Dallas, TX', 'sophia.martinez@example.com', 0),
(11, 'Hernandez', 'Daniel', '0956743128', '135 Hickory St, Phoenix, AZ', 'daniel.hernandez@example.com', 0),
(12, 'Lopez', 'Grace', '0943210987', '246 Palm Blvd, Charlotte, NC', 'grace.lopez@example.com', 0),
(13, 'Gonzalez', 'William', '0901234567', '369 Cypress Rd, San Diego, CA', 'william.gonzalez@example.com', 0),
(14, 'Wilson', 'Chloe', '0919238475', '147 Redwood Ave, Tampa, FL', 'chloe.wilson@example.com', 0),
(15, 'Anderson', 'Benjamin', '0978123456', '258 Spruce St, Las Vegas, NV', 'benjamin.anderson@example.com', 0),
(16, 'Thomas', 'Lily', '0932187654', '369 Magnolia Ln, Salt Lake City, UT', 'lily.thomas@example.com', 0),
(17, 'Taylor', 'Christopher', '0982345678', '147 Poplar St, Baltimore, MD', 'chris.taylor@example.com', 0),
(18, 'Moore', 'Zoe', '0956784321', '753 Oakwood Dr, Cincinnati, OH', 'zoe.moore@example.com', 0),
(19, 'Jackson', 'Nathan', '0921435678', '951 River Rd, Kansas City, MO', 'nathan.jackson@example.com', 0),
(20, 'Martin', 'Ella', '0945654321', '852 Sunset Blvd, Orlando, FL', 'ella.martin@example.com', 0);

-- --------------------------------------------------------

--
-- Table structure for table `loaisp`
--

CREATE TABLE `loaisp` (
  `MALOAI` int(11) NOT NULL,
  `TENLOAI` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `loaisp`
--

INSERT INTO `loaisp` (`MALOAI`, `TENLOAI`, `is_deleted`) VALUES
(1, 'Áo Thun', 0),
(2, 'Áo Sơ Mi', 0),
(3, 'Áo Hoodie', 0),
(4, 'Áo Polo', 0),
(5, 'Áo Khoác', 0),
(6, 'Quần Jean', 0),
(7, 'Quần Tây', 0),
(8, 'Quần Short', 0),
(9, 'Quần Jogger', 0),
(10, 'Quần Kaki', 0);

-- --------------------------------------------------------

--
-- Table structure for table `ncc`
--

CREATE TABLE `ncc` (
  `MANCC` int(11) NOT NULL,
  `TENNCC` varchar(50) NOT NULL,
  `SDTNCC` varchar(11) NOT NULL,
  `DIACHI` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `ncc`
--

INSERT INTO `ncc` (`MANCC`, `TENNCC`, `SDTNCC`, `DIACHI`, `is_deleted`) VALUES
(1, 'Công ty May Mặc Bình Minh', '0912345678', '12 Nguyễn Trãi, Q.1, TP.HCM', 0),
(2, 'Thời Trang Hoàng Gia', '0987654321', '45 Lê Lợi, Q.3, TP.HCM', 0),
(3, 'Vải Sợi Phú Cường', '0901122334', '78 Hai Bà Trưng, Q.5, TP.HCM', 0),
(4, 'Quần Áo Trẻ Em Sao Mai', '0933445566', '23 Lý Thường Kiệt, Hà Nội', 0),
(5, 'Công ty TNHH VinaWear', '0977889900', '90 Trần Hưng Đạo, Đà Nẵng', 0),
(6, 'Dệt May Thành Công', '0944112233', '56 Nguyễn Văn Cừ, Q.Ninh Kiều, Cần Thơ', 0),
(7, 'FashionHub Việt Nam', '0922334455', '66 Phạm Văn Đồng, TP. Hải Phòng', 0),
(8, 'Đồng Phục Ánh Dương', '0966554433', '88 Pasteur, Q.1, TP.HCM', 0),
(9, 'Công ty TNHH BlueStyle', '0932111222', '33 Cách Mạng Tháng 8, TP. Vũng Tàu', 0),
(10, 'Thời Trang Hàn Quốc KStyle', '0988111222', '99 Lạc Long Quân, TP. Huế', 0);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` int(11) NOT NULL,
  `HO` varchar(50) NOT NULL,
  `TEN` varchar(10) NOT NULL,
  `LUONG` int(11) NOT NULL,
  `SDT` varchar(11) NOT NULL,
  `DIACHI` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `HO`, `TEN`, `LUONG`, `SDT`, `DIACHI`, `EMAIL`, `is_deleted`) VALUES
(1, 'Sử Việt', 'Nam', 30000000, '0933447453', 'Quận 3, TPHCM', 'sunamvi98@gmail.com', 0),
(2, 'Nguyễn Thu', 'H', 24000000, '0933451234', 'Tánh Linh, Bình Thuận', 'nguyenthuh@gmail.com', 0),
(3, 'Võ', 'K', 15600000, '0933451567', 'Quận 5, TPHCM', 'vok@gmail.com', 0),
(4, 'Hoàng', 'S', 19800000, '0956734234', 'Quận 8, TPHCM', 'hoangs@gmail.com', 0),
(5, 'Phan Văn', 'T', 16000000, '0331234567', 'Quận Bình Tân, TPHCM', 'phanvant@gmail.com', 0),
(6, 'Nguyễn Thị', 'H', 14000000, '0778765432', 'Quận 7, TPHCM', 'nguyenthih@gmail.com', 0),
(7, 'Võ Thị', 'M', 12800000, '0388445566', 'Đà Lạt, Lâm Đồng', 'vothim@gmail.com', 0),
(8, 'Trần Văn', 'A', 12000000, '0965748723', 'TP Thủ Đức, TPHCM', 'tranvana@gmail.com', 0),
(9, 'Bùi Thu', 'L', 23000000, '0867923457', 'Cần Giuộc, Long An', 'buithul@gmail.com', 0),
(10, 'Lương Văn', 'N', 13900000, '0989845634', 'TP Phan Thiết, Bình Thuận', 'luongvann@gmail.com', 0),
(11, 'Nguyễn', 'An', 15500000, '0911223344', 'Đồng Nai', 'nguyenan@gmail.com', 0),
(12, 'Lê Thị', 'B', 13000000, '0909123456', 'Bình Dương', 'lethib@gmail.com', 0),
(13, 'Phạm Văn', 'C', 18000000, '0912345678', 'TPHCM', 'phamvanc@gmail.com', 0),
(14, 'Đỗ', 'D', 17500000, '0987766554', 'Nha Trang', 'dod@gmail.com', 0),
(15, 'Ngô Thị', 'E', 16000000, '0977888999', 'TPHCM', 'ngothie@gmail.com', 0),
(16, 'Trịnh', 'F', 17000000, '0922334455', 'Hà Nội', 'trinhf@gmail.com', 0),
(17, 'Mai Văn', 'G', 19000000, '0933225566', 'TPHCM', 'maivang@gmail.com', 0),
(18, 'Đinh Thị', 'H', 15000000, '0977332211', 'Đồng Nai', 'dinhthih@gmail.com', 0),
(19, 'Lý', 'I', 14000000, '0944556677', 'TPHCM', 'lyi@gmail.com', 0),
(20, 'Hồ Quang', 'J', 21000000, '0911667788', 'Cần Thơ', 'hoquangj@gmail.com', 0),
(21, 'Phạm Thị', 'K', 16000000, '0901234567', 'TPHCM', 'phamthik@gmail.com', 0),
(22, 'Trần', 'L', 14500000, '0912345670', 'Bình Dương', 'tranl@gmail.com', 0),
(23, 'Nguyễn Văn', 'M', 18500000, '0922334466', 'Hà Nội', 'nguyenvanm@gmail.com', 0),
(24, 'Đoàn Thị', 'N', 17000000, '0933445566', 'TPHCM', 'doanthin@gmail.com', 0),
(25, 'Trịnh Văn', 'O', 15000000, '0944556678', 'Đồng Nai', 'trinhvano@gmail.com', 0);

-- --------------------------------------------------------

--
-- Table structure for table `phienbansp`
--

CREATE TABLE `phienbansp` (
  `MAPB` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `SIZE` varchar(11) NOT NULL,
  `MAU` varchar(11) NOT NULL,
  `SLPB` int(11) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phienbansp`
--

INSERT INTO `phienbansp` (`MAPB`, `MASP`, `SIZE`, `MAU`, `SLPB`, `is_deleted`) VALUES
(1, 1, 'S', 'Trắng', 50, 0),
(2, 1, 'M', 'Trắng', 50, 0),
(3, 1, 'L', 'Đen', 30, 0),
(4, 2, 'M', 'Trắng', 40, 0),
(5, 2, 'L', 'Trắng', 35, 0),
(6, 3, 'M', 'Đen', 60, 0),
(7, 3, 'L', 'Xanh', 45, 0),
(8, 4, 'M', 'Xanh', 50, 0),
(9, 4, 'L', 'Xanh', 40, 0),
(10, 5, 'M', 'Đen', 55, 0),
(11, 5, 'L', 'Đen', 50, 0),
(12, 6, 'S', 'Đen', 30, 0),
(13, 6, 'M', 'Trắng', 40, 0),
(14, 6, 'L', 'Xám', 25, 0),
(15, 7, 'M', 'Xanh đen', 35, 0),
(16, 7, 'L', 'Đen', 45, 0),
(17, 7, 'XL', 'Xám', 20, 0),
(18, 8, 'M', 'Be', 50, 0),
(19, 8, 'L', 'Đen', 60, 0),
(20, 8, 'XL', 'Xanh navy', 40, 0),
(21, 9, 'S', 'Xám', 20, 0),
(22, 9, 'M', 'Đen', 30, 0),
(23, 9, 'L', 'Xám đậm', 25, 0),
(24, 10, 'M', 'Nâu', 35, 0),
(25, 10, 'L', 'Be', 40, 0),
(26, 10, 'XL', 'Đen', 28, 0);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MAPN` int(11) NOT NULL,
  `MANV` int(11) NOT NULL,
  `MANCC` int(11) NOT NULL,
  `TONGTIEN` int(15) NOT NULL,
  `NGAYNHAP` varchar(20) NOT NULL,
  `TRANGTHAI` int(11) NOT NULL,
  `is_deleted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MAPN`, `MANV`, `MANCC`, `TONGTIEN`, `NGAYNHAP`, `TRANGTHAI`, `is_deleted`) VALUES
(1, 3, 1, 88650000, '2025-05-15', 1, 0),
(2, 1, 1, 89560000, '2025-05-15', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `quan`
--

CREATE TABLE `quan` (
  `MALOAI` int(11) NOT NULL,
  `TENQUAN` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MASP` int(11) NOT NULL,
  `TENSP` varchar(50) NOT NULL,
  `DONGIA` int(11) NOT NULL,
  `DONVITINH` varchar(10) NOT NULL,
  `CHATLIEU` varchar(20) NOT NULL,
  `MOTA` varchar(200) NOT NULL,
  `MALOAI` int(11) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MASP`, `TENSP`, `DONGIA`, `DONVITINH`, `CHATLIEU`, `MOTA`, `MALOAI`, `is_deleted`) VALUES
(1, 'Áo Thun Cổ Tròn', 150000, 'VNĐ', 'Cotton', 'Áo thun cotton mềm mại, thoáng mát', 1, 0),
(2, 'Áo Sơ Mi Trắng', 300000, 'VNĐ', 'Polyester', 'Áo sơ mi trắng công sở thanh lịch', 2, 0),
(3, 'Áo Hoodie Nỉ', 350000, 'VNĐ', 'Nỉ', 'Áo hoodie dày dặn, giữ ấm tốt', 3, 0),
(4, 'Quần Jean Xanh', 400000, 'VNĐ', 'Denim', 'Quần jean xanh trẻ trung, phù hợp mọi lứa tuổi', 6, 0),
(5, 'Quần Tây Đen', 380000, 'VNĐ', 'Vải', 'Quần tây đen lịch sự, phù hợp công sở', 7, 0),
(6, 'Áo Polo Nam', 280000, 'VNĐ', 'Cotton', 'Áo polo trẻ trung, lịch sự, dễ phối đồ', 4, 0),
(7, 'Áo Khoác Gió', 450000, 'VNĐ', 'Vải dù', 'Áo khoác nhẹ, chắn gió tốt, phù hợp thời tiết se lạnh', 5, 0),
(8, 'Quần Short Nam', 250000, 'VNĐ', 'Vải dù', 'Quần short thoải mái, thích hợp đi chơi, thể thao', 8, 0),
(9, 'Quần Jogger Thể Thao', 320000, 'VNĐ', 'Thun co giãn', 'Jogger co giãn tốt, phù hợp vận động', 9, 0),
(10, 'Quần Kaki Trơn', 370000, 'VNĐ', 'Kaki', 'Kaki trơn, dễ phối đồ, phù hợp công sở và dạo phố', 10, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ao`
--
ALTER TABLE `ao`
  ADD PRIMARY KEY (`MALOAI`,`TENAO`);

--
-- Indexes for table `cthd`
--
ALTER TABLE `cthd`
  ADD PRIMARY KEY (`MAHD`,`MASP`,`MAPB`),
  ADD KEY `MAPB` (`MAPB`),
  ADD KEY `MASP` (`MASP`);

--
-- Indexes for table `ctkm`
--
ALTER TABLE `ctkm`
  ADD PRIMARY KEY (`MACTKM`);

--
-- Indexes for table `ctkmhd`
--
ALTER TABLE `ctkmhd`
  ADD PRIMARY KEY (`MACTKMHD`,`MACTKM`),
  ADD KEY `MACTKM` (`MACTKM`);

--
-- Indexes for table `ctkmsp`
--
ALTER TABLE `ctkmsp`
  ADD PRIMARY KEY (`MACTKMSP`,`MACTKM`),
  ADD KEY `MACTKM` (`MACTKM`),
  ADD KEY `MASP` (`MASP`);

--
-- Indexes for table `ctpn`
--
ALTER TABLE `ctpn`
  ADD PRIMARY KEY (`MAPN`,`MASP`,`MAPB`),
  ADD KEY `MAPB` (`MAPB`),
  ADD KEY `MASP` (`MASP`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHD`),
  ADD KEY `hoadon_ibfk_1` (`MANV`),
  ADD KEY `hoadon_ibfk_2` (`MAKH`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MAKH`);

--
-- Indexes for table `loaisp`
--
ALTER TABLE `loaisp`
  ADD PRIMARY KEY (`MALOAI`);

--
-- Indexes for table `ncc`
--
ALTER TABLE `ncc`
  ADD PRIMARY KEY (`MANCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`);

--
-- Indexes for table `phienbansp`
--
ALTER TABLE `phienbansp`
  ADD PRIMARY KEY (`MAPB`),
  ADD KEY `phienbansp_ibfk_1` (`MASP`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MAPN`),
  ADD KEY `phieunhap_ibfk_1` (`MANV`),
  ADD KEY `phieunhap_ibfk_2` (`MANCC`);

--
-- Indexes for table `quan`
--
ALTER TABLE `quan`
  ADD PRIMARY KEY (`MALOAI`,`TENQUAN`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MASP`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cthd`
--
ALTER TABLE `cthd`
  MODIFY `MAHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `ctkm`
--
ALTER TABLE `ctkm`
  MODIFY `MACTKM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `ctkmhd`
--
ALTER TABLE `ctkmhd`
  MODIFY `MACTKMHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `ctkmsp`
--
ALTER TABLE `ctkmsp`
  MODIFY `MACTKMSP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MAHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MAKH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `loaisp`
--
ALTER TABLE `loaisp`
  MODIFY `MALOAI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `ncc`
--
ALTER TABLE `ncc`
  MODIFY `MANCC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MANV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `phienbansp`
--
ALTER TABLE `phienbansp`
  MODIFY `MAPB` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MAPN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MASP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ao`
--
ALTER TABLE `ao`
  ADD CONSTRAINT `ao_ibfk_1` FOREIGN KEY (`MALOAI`) REFERENCES `loaisp` (`MALOAI`) ON DELETE CASCADE;

--
-- Constraints for table `cthd`
--
ALTER TABLE `cthd`
  ADD CONSTRAINT `cthd_ibfk_1` FOREIGN KEY (`MAHD`) REFERENCES `hoadon` (`MAHD`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cthd_ibfk_2` FOREIGN KEY (`MAPB`) REFERENCES `phienbansp` (`MAPB`),
  ADD CONSTRAINT `cthd_ibfk_3` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`);

--
-- Constraints for table `ctkmhd`
--
ALTER TABLE `ctkmhd`
  ADD CONSTRAINT `ctkmhd_ibfk_1` FOREIGN KEY (`MACTKM`) REFERENCES `ctkm` (`MACTKM`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ctkmsp`
--
ALTER TABLE `ctkmsp`
  ADD CONSTRAINT `ctkmsp_ibfk_1` FOREIGN KEY (`MACTKM`) REFERENCES `ctkm` (`MACTKM`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctkmsp_ibfk_2` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ctpn`
--
ALTER TABLE `ctpn`
  ADD CONSTRAINT `ctpn_ibfk_1` FOREIGN KEY (`MAPN`) REFERENCES `phieunhap` (`MAPN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctpn_ibfk_2` FOREIGN KEY (`MAPB`) REFERENCES `phienbansp` (`MAPB`),
  ADD CONSTRAINT `ctpn_ibfk_3` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `phienbansp`
--
ALTER TABLE `phienbansp`
  ADD CONSTRAINT `phienbansp_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MANCC`) REFERENCES `ncc` (`MANCC`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `quan`
--
ALTER TABLE `quan`
  ADD CONSTRAINT `quan_ibfk_1` FOREIGN KEY (`MALOAI`) REFERENCES `loaisp` (`MALOAI`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
