-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 17, 2025 lúc 09:31 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `java_quanao`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ao`
--

CREATE TABLE `ao` (
  `MALOAI` int(11) NOT NULL,
  `TENAO` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cthd`
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
-- Cấu trúc bảng cho bảng `ctkm`
--

CREATE TABLE `ctkm` (
  `MACTKM` int(11) NOT NULL,
  `NGAYBD` varchar(20) NOT NULL,
  `NGAYKT` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `ctkm`
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
-- Cấu trúc bảng cho bảng `ctkmhd`
--

CREATE TABLE `ctkmhd` (
  `MACTKMHD` int(11) NOT NULL,
  `MACTKM` int(11) NOT NULL,
  `TONGTIENHD` int(11) NOT NULL,
  `PTGG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctkmsp`
--

CREATE TABLE `ctkmsp` (
  `MACTKM` int(11) NOT NULL,
  `MACTKMSP` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `PTGG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctpn`
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
-- Cấu trúc bảng cho bảng `hoadon`
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
-- Cấu trúc bảng cho bảng `khachhang`
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
-- Cấu trúc bảng cho bảng `loaisp`
--

CREATE TABLE `loaisp` (
  `MALOAI` int(11) NOT NULL,
  `TENLOAI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ncc`
--

CREATE TABLE `ncc` (
  `MANCC` int(11) NOT NULL,
  `TENNCC` varchar(50) NOT NULL,
  `SDTNCC` varchar(11) NOT NULL,
  `DIACHI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
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

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `HO`, `TEN`, `LUONG`, `SDT`, `DIACHI`, `EMAIL`) VALUES
(1, 'Sử Việt', 'Nam', 30000000, '0933447453', 'Quận 3, TPHCM', 'sunamvi98@gmail.com'),
(2, 'Nguyễn Thu', 'H', 24000000, '0933451234', 'Tánh Linh, Bình Thuận', 'nguyenthuh@gmail.com'),
(3, 'Võ', 'K', 15600000, '0933451567', 'Quận 5, TPHCM', 'vok@gmail.com'),
(4, 'Hoàng', 'S', 19800000, '0956734234', 'Quận 8, TPHCM', 'hoangs@gmail.com'),
(5, 'Phan Văn', 'T', 16000000, '0331234567', 'Quận Bình Tân, TPHCM', 'phanvant@gmail.com'),
(6, 'Nguyễn Thị', 'H', 14000000, '0778765432', 'Quận 7, TPHCM', 'nguyenthih@gmail.com'),
(7, 'Võ Thị', 'M', 12800000, '0388445566', 'Đà Lạt, Lâm Đồng', 'vothim@gmail.com'),
(8, 'Trần Văn', 'A', 12000000, '0965748723', 'TP Thủ Đức, TPHCM', 'tranvana@gmail.com'),
(9, 'Bùi Thu', 'L', 23000000, '0867923457', 'Cần Giuộc, Long An', 'buithul@gmail.com'),
(10, 'Lương Văn', 'N', 13900000, '0989845634', 'TP Phan Thiết, Bình Thuận', 'luongvann@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phienbansp`
--

CREATE TABLE `phienbansp` (
  `MASP` int(11) NOT NULL,
  `SIZE` int(11) NOT NULL,
  `MAU` int(11) NOT NULL,
  `SLSP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
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
-- Cấu trúc bảng cho bảng `quan`
--

CREATE TABLE `quan` (
  `MALOAI` int(11) NOT NULL,
  `TENQUAN` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
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
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ao`
--
ALTER TABLE `ao`
  ADD PRIMARY KEY (`MALOAI`,`TENAO`);

--
-- Chỉ mục cho bảng `cthd`
--
ALTER TABLE `cthd`
  ADD PRIMARY KEY (`MAHD`),
  ADD KEY `MASP` (`MASP`);

--
-- Chỉ mục cho bảng `ctkm`
--
ALTER TABLE `ctkm`
  ADD PRIMARY KEY (`MACTKM`);

--
-- Chỉ mục cho bảng `ctkmhd`
--
ALTER TABLE `ctkmhd`
  ADD PRIMARY KEY (`MACTKMHD`,`MACTKM`),
  ADD KEY `MACTKM` (`MACTKM`);

--
-- Chỉ mục cho bảng `ctkmsp`
--
ALTER TABLE `ctkmsp`
  ADD PRIMARY KEY (`MACTKMSP`,`MACTKM`),
  ADD KEY `MACTKM` (`MACTKM`),
  ADD KEY `MASP` (`MASP`);

--
-- Chỉ mục cho bảng `ctpn`
--
ALTER TABLE `ctpn`
  ADD PRIMARY KEY (`MACTPN`),
  ADD KEY `MASP` (`MASP`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHD`,`NGAYLAP`),
  ADD KEY `MANV` (`MANV`),
  ADD KEY `MAKH` (`MAKH`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MAKH`);

--
-- Chỉ mục cho bảng `loaisp`
--
ALTER TABLE `loaisp`
  ADD PRIMARY KEY (`MALOAI`);

--
-- Chỉ mục cho bảng `ncc`
--
ALTER TABLE `ncc`
  ADD PRIMARY KEY (`MANCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`);

--
-- Chỉ mục cho bảng `phienbansp`
--
ALTER TABLE `phienbansp`
  ADD PRIMARY KEY (`MASP`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MAPN`),
  ADD KEY `phieunhap_ibfk_1` (`MANV`),
  ADD KEY `phieunhap_ibfk_2` (`MANCC`);

--
-- Chỉ mục cho bảng `quan`
--
ALTER TABLE `quan`
  ADD PRIMARY KEY (`MALOAI`,`TENQUAN`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MASP`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cthd`
--
ALTER TABLE `cthd`
  MODIFY `MAHD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ctkm`
--
ALTER TABLE `ctkm`
  MODIFY `MACTKM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `ctkmhd`
--
ALTER TABLE `ctkmhd`
  MODIFY `MACTKMHD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ctkmsp`
--
ALTER TABLE `ctkmsp`
  MODIFY `MACTKMSP` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ctpn`
--
ALTER TABLE `ctpn`
  MODIFY `MACTPN` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MAHD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MAKH` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `loaisp`
--
ALTER TABLE `loaisp`
  MODIFY `MALOAI` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ncc`
--
ALTER TABLE `ncc`
  MODIFY `MANCC` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MANV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MAPN` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MASP` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ao`
--
ALTER TABLE `ao`
  ADD CONSTRAINT `ao_ibfk_1` FOREIGN KEY (`MALOAI`) REFERENCES `loaisp` (`MALOAI`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `cthd`
--
ALTER TABLE `cthd`
  ADD CONSTRAINT `cthd_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `ctkmhd`
--
ALTER TABLE `ctkmhd`
  ADD CONSTRAINT `ctkmhd_ibfk_1` FOREIGN KEY (`MACTKM`) REFERENCES `ctkm` (`MACTKM`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ctkmsp`
--
ALTER TABLE `ctkmsp`
  ADD CONSTRAINT `ctkmsp_ibfk_1` FOREIGN KEY (`MACTKM`) REFERENCES `ctkm` (`MACTKM`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctkmsp_ibfk_2` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ctpn`
--
ALTER TABLE `ctpn`
  ADD CONSTRAINT `ctpn_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `phienbansp`
--
ALTER TABLE `phienbansp`
  ADD CONSTRAINT `phienbansp_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MANCC`) REFERENCES `ncc` (`MANCC`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `quan`
--
ALTER TABLE `quan`
  ADD CONSTRAINT `quan_ibfk_1` FOREIGN KEY (`MALOAI`) REFERENCES `loaisp` (`MALOAI`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
