-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2025 at 03:01 PM
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
  `TENAO` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cthd`
--

CREATE TABLE `cthd` (
  `MAHD` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
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
  `MACTPN` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `SL` int(11) NOT NULL,
  `DONGIA` int(11) NOT NULL,
  `THANHTIEN` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MAHD` int(11) NOT NULL,
  `NGAYLAP` varchar(20) NOT NULL,
  `MANV` int(11) NOT NULL,
  `MAKH` int(11) NOT NULL,
  `TONGTIEN` int(11) NOT NULL
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
  `EMAIL` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loaisp`
--

CREATE TABLE `loaisp` (
  `MALOAI` int(11) NOT NULL,
  `TENLOAI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ncc`
--

CREATE TABLE `ncc` (
  `MANCC` int(11) NOT NULL,
  `TENNCC` varchar(50) NOT NULL,
  `SDTNCC` varchar(11) NOT NULL,
  `DIACHI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

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
  `EMAIL` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phienbansp`
--

CREATE TABLE `phienbansp` (
  `MASP` int(11) NOT NULL,
  `SIZE` int(11) NOT NULL,
  `MAU` int(11) NOT NULL,
  `SLSP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MAPN` int(11) NOT NULL,
  `MANV` int(11) NOT NULL,
  `MANCC` int(11) NOT NULL,
  `TONGTIEN` int(15) NOT NULL,
  `NGAYNHAP` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `quan`
--

CREATE TABLE `quan` (
  `MALOAI` int(11) NOT NULL,
  `TENQUAN` varchar(50) NOT NULL
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
  `MALOAI` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

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
  ADD PRIMARY KEY (`MAHD`),
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
  ADD PRIMARY KEY (`MACTPN`),
  ADD KEY `MASP` (`MASP`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHD`,`NGAYLAP`),
  ADD KEY `MANV` (`MANV`),
  ADD KEY `MAKH` (`MAKH`);

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
  ADD PRIMARY KEY (`MASP`);

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
  MODIFY `MAHD` int(11) NOT NULL AUTO_INCREMENT;

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
-- AUTO_INCREMENT for table `ctpn`
--
ALTER TABLE `ctpn`
  MODIFY `MACTPN` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MAHD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MAKH` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loaisp`
--
ALTER TABLE `loaisp`
  MODIFY `MALOAI` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ncc`
--
ALTER TABLE `ncc`
  MODIFY `MANCC` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MANV` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MAPN` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MASP` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `cthd_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`) ON DELETE NO ACTION ON UPDATE NO ACTION;

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
  ADD CONSTRAINT `ctpn_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`) ON DELETE CASCADE ON UPDATE CASCADE;

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
