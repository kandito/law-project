-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 01 Jun 2015 pada 11.38
-- Versi Server: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `law`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `nama_lengkap` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `nomor_anggota` varchar(13) NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `nama_lengkap`, `password`, `email`, `nomor_anggota`) VALUES
(1, 'kandito', 'Kandito A. W', '123123', 'kanditoaw@gmail.com', '123123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `alat`
--

CREATE TABLE IF NOT EXISTS `alat` (
  `id_alat` int(11) NOT NULL AUTO_INCREMENT,
  `kode_alat` varchar(20) NOT NULL,
  `nama` varchar(160) NOT NULL,
  `spesifikasi` text NOT NULL,
  `keterangan` text NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `biaya` bigint(20) NOT NULL,
  `gambar` varchar(255) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `jumlah_tersedia` int(11) NOT NULL,
  PRIMARY KEY (`id_alat`),
  KEY `id_kategori` (`id_kategori`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data untuk tabel `alat`
--

INSERT INTO `alat` (`id_alat`, `kode_alat`, `nama`, `spesifikasi`, `keterangan`, `id_kategori`, `biaya`, `gambar`, `jumlah`, `jumlah_tersedia`) VALUES
(2, '1111', 'Tenda', 'Bahan bagus', 'Tenda tenda', 6, 50000, 'tenda.png', 10, 3),
(3, '1212121', 'Tongkat', 'Stenless', 'Cocok untuk naik gunung bersalju.', 6, 10000, 'tongkat.jpg', 20, 20),
(7, 'A123', 'Sepatu Gunung', '', '', 6, 10000, 'sepatu-gunung.jpg', 0, 0),
(8, 'A124', 'Kompor', 'Kompor baru', 'Kompor paling keren', 6, 5000, 'kompor.jpg', 10, 10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE IF NOT EXISTS `kategori` (
  `id_kategori` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  PRIMARY KEY (`id_kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama`) VALUES
(1, 'Climbing'),
(2, 'Caving'),
(3, 'Rafting'),
(4, 'Diving'),
(5, 'Paralayang'),
(6, 'Mountaineering'),
(7, 'Rescue'),
(8, 'Other');

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE IF NOT EXISTS `peminjaman` (
  `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT,
  `total_biaya` bigint(20) NOT NULL,
  `keterangan` text NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_balik` date NOT NULL,
  `status` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_admin` int(11) NOT NULL,
  PRIMARY KEY (`id_peminjaman`),
  KEY `id_user` (`id_user`),
  KEY `id_admin` (`id_admin`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `total_biaya`, `keterangan`, `tanggal_pinjam`, `tanggal_balik`, `status`, `id_user`, `id_admin`) VALUES
(3, 300000, 'Buat naik gunung fuji', '2015-04-26', '2015-04-30', 1, 5, 1),
(9, 350000, '', '0006-12-06', '0006-12-06', 2, 7, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman_item`
--

CREATE TABLE IF NOT EXISTS `peminjaman_item` (
  `id_peminjaman_item` int(11) NOT NULL AUTO_INCREMENT,
  `id_alat` int(11) NOT NULL,
  `id_peminjaman` int(11) NOT NULL,
  `keterangan` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL,
  PRIMARY KEY (`id_peminjaman_item`),
  KEY `id_alat` (`id_alat`),
  KEY `id_peminjaman` (`id_peminjaman`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data untuk tabel `peminjaman_item`
--

INSERT INTO `peminjaman_item` (`id_peminjaman_item`, `id_alat`, `id_peminjaman`, `keterangan`, `jumlah`) VALUES
(1, 2, 3, '', 0),
(2, 7, 3, '', 0),
(11, 2, 9, '', 7);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `nama_lengkap` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `organisasi` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `nomor_telepon` varchar(13) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `nama_lengkap`, `password`, `email`, `organisasi`, `alamat`, `nomor_telepon`) VALUES
(5, 'kandito.agung', 'Kandito', '', 'kanditoaw@gmail.com', 'Fasilkom', 'Bekasi', '085697111580'),
(7, 'kandito12', 'Kandito', '123123', 'kanditoaw@gmail.com', 'Fasilkom', '', '085697111580'),
(8, 'satria.ramadhan', 'Satria Ramadhan', 'satria', 'satria.ramadhan@ui.ac.id', 'Mapala UI', 'Depok', '08995419392');

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `alat`
--
ALTER TABLE `alat`
  ADD CONSTRAINT `alat_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`);

--
-- Ketidakleluasaan untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `peminjaman_item`
--
ALTER TABLE `peminjaman_item`
  ADD CONSTRAINT `peminjaman_item_ibfk_1` FOREIGN KEY (`id_alat`) REFERENCES `alat` (`id_alat`),
  ADD CONSTRAINT `peminjaman_item_ibfk_2` FOREIGN KEY (`id_peminjaman`) REFERENCES `peminjaman` (`id_peminjaman`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
