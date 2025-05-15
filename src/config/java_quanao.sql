-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2025 at 04:45 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

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

--
-- Dumping data for table `ao`
--

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

--
-- Dumping data for table `cthd`
--

INSERT INTO `cthd` (`MAHD`, `MASP`, `MAPB`, `SL`, `DONGIA`, `THANHTIEN`) VALUES
(11, 2, 4, 2, 1000, 0);

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
(1, '09/01/2025', '25/05/2025'),
(2, '14/01/2025', '27/04/2025'),
(3, '31/03/2025', '23/12/2025'),
(4, '09/04/2025', '24/05/2025'),
(5, '06/02/2025', '27/08/2025'),
(6, '14/02/2025', '27/07/2025'),
(7, '02/04/2025', '14/10/2025'),
(8, '03/02/2025', '28/04/2025'),
(9, '16/02/2025', '20/04/2025'),
(10, '06/02/2025', '25/09/2025'),
(11, '01/04/2025', '14/08/2025'),
(12, '22/03/2025', '14/07/2025'),
(13, '06/02/2025', '13/10/2025'),
(14, '10/02/2025', '21/09/2025'),
(15, '09/01/2025', '31/10/2025');

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
(11, 1, 1, 1, 1111, 1111),
(11, 2, 3, 1, 2222, 2222),
(12, 1, 1, 1, 2222, 2222),
(13, 1, 1, 1, 2222, 2222);

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

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MAHD`, `NGAYLAP`, `MANV`, `MAKH`, `TONGTIEN`, `TRANGTHAI`, `is_deleted`) VALUES
(1, '01/04/2025', 1, 19, 0, 0, 0),
(2, '05/04/2025', 6, 3, 0, 0, 0),
(3, '13/04/2025', 10, 17, 0, 0, 0),
(4, '02/04/2025', 5, 19, 0, 0, 0),
(5, '30/04/2025', 2, 5, 0, 0, 0),
(6, '07/04/2025', 9, 20, 0, 0, 0),
(7, '01/04/2025', 4, 18, 0, 0, 0),
(8, '05/04/2025', 3, 19, 0, 0, 0),
(9, '04/04/2025', 2, 20, 0, 0, 0),
(10, '05/04/2025', 10, 3, 0, 0, 0),
(11, '15/05/2025', 7, 9, 0, 0, 0),
(12, '15/05/2025', 6, 7, 0, 0, 0);

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
(1, 'Áo', 0),
(2, 'Quần', 0);

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
(1, 1, 'M', 'Đỏ', 11, 0),
(2, 1, 'XXL', 'Xanh', 10, 0),
(3, 2, 'L', 'Trắng', 5, 0),
(4, 2, 'XXL', 'Xanh', 8, 0),
(5, 5, '1', '1', 0, 1),
(6, 5, '2', '2', 0, 0),
(7, 5, '3', '3', 0, 0);

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
(1, 2, 3, 4320000, '15/03/2025', 0, 0),
(2, 1, 4, 6850000, '22/01/2025', 0, 0),
(3, 3, 2, 7895000, '07/02/2025', 0, 0),
(4, 4, 5, 2345000, '10/12/2024', 0, 0),
(5, 5, 1, 9100000, '02/03/2025', 0, 0),
(6, 2, 2, 5600000, '11/04/2025', 0, 0),
(7, 3, 3, 7400000, '08/01/2025', 0, 0),
(8, 4, 4, 3100000, '20/02/2025', 0, 0),
(9, 1, 5, 8450000, '14/03/2025', 0, 0),
(10, 5, 1, 6550000, '17/04/2025', 0, 0),
(11, 1, 1, 3333, '2025-05-14 17:09:56', 1, 0),
(12, 1, 1, 2222, '2025-05-14', 0, 0),
(13, 1, 1, 2222, '14/05/2025', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `quan`
--

CREATE TABLE `quan` (
  `MALOAI` int(11) NOT NULL,
  `TENQUAN` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `quan`
--



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
(1, 'a', 1000, 'VND', 'vải', 'adfàdàdà', 1, 0),
(2, 'b', 1000, 'VND', 'vải', 'ádfádfàdà', 2, 0),
(3, '123', 0, 'VNĐ', '123', '123', 1, 0),
(4, 'test', 0, 'VNĐ', 'test', 'test', 1, 1),
(5, 'test', 0, 'VNĐ', 'test', '', 1, 0);

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
  MODIFY `MACTKM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `ctkmhd`
--
ALTER TABLE `ctkmhd`
  MODIFY `MACTKMHD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ctkmsp`
--
ALTER TABLE `ctkmsp`
  MODIFY `MACTKMSP` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `MALOAI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
  MODIFY `MAPB` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MAPN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MASP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
