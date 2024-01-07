-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Jan 2024 pada 14.22
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gudang_lapar`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbarang`
--

CREATE TABLE `tbarang` (
  `id_barang` varchar(10) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `kategori_barang` varchar(30) NOT NULL,
  `satuan_barang` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbarang`
--

INSERT INTO `tbarang` (`id_barang`, `nama_barang`, `kategori_barang`, `satuan_barang`) VALUES
('B01', 'Tepung Segi Lima', 'bubuk bumbu', 'gram'),
('B02', 'Bawang Putih bubuk', 'bubuk bumbu', 'gram'),
('B03', 'Bawang Bombai Bubuk', 'bubuk bumbu', 'gram'),
('B04', 'Paper Bag Carte', 'bungkus produk', 'pcs'),
('B05', 'Kotak Combo', 'bungkus produk', 'pcs');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tpemasok`
--

CREATE TABLE `tpemasok` (
  `id_pemasok` varchar(10) NOT NULL,
  `nama_pemasok` varchar(30) NOT NULL,
  `alamat_pemasok` varchar(40) NOT NULL,
  `telepon_pemasok` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tpemasok`
--

INSERT INTO `tpemasok` (`id_pemasok`, `nama_pemasok`, `alamat_pemasok`, `telepon_pemasok`) VALUES
('P01', 'CV. Shaufi Sejahtera Persada', 'Jl. Batu Ginjal No. 5 Kab. Balangan', '08225545311'),
('P02', 'PT. Bima Hindia', 'Jl. Prindavan No. 14 Kota Mumbai', '08721234542'),
('P03', 'CV. Ceria Pack', 'Jl. Sukamara No.12 Kota Pekalongan', '05114675'),
('P04', 'Mama Ghani', 'Jl. Sungai Kalut No. 11 Kota Banjarmasin', '081245679811'),
('P05', 'Bobby Farm', 'Jl. Riam Kanan Komplek Peternakan Ayam', '05172244');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ttransaksi`
--

CREATE TABLE `ttransaksi` (
  `id_transaksi` int(10) NOT NULL,
  `id_barang` varchar(10) NOT NULL,
  `id_pemasok` varchar(10) NOT NULL,
  `jumlah` int(30) NOT NULL,
  `satuan_barang` varchar(10) NOT NULL,
  `jenis_transaksi` varchar(10) NOT NULL,
  `waktu_transaksi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `ttransaksi`
--

INSERT INTO `ttransaksi` (`id_transaksi`, `id_barang`, `id_pemasok`, `jumlah`, `satuan_barang`, `jenis_transaksi`, `waktu_transaksi`) VALUES
(11, 'B02', 'P02', 500, 'gram', 'Masuk', '2024-01-07'),
(13, 'B01', 'P04', 4000, 'gram', 'Masuk', '2024-01-07');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbarang`
--
ALTER TABLE `tbarang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indeks untuk tabel `tpemasok`
--
ALTER TABLE `tpemasok`
  ADD PRIMARY KEY (`id_pemasok`);

--
-- Indeks untuk tabel `ttransaksi`
--
ALTER TABLE `ttransaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_barang` (`id_barang`),
  ADD KEY `id_pemasok` (`id_pemasok`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `ttransaksi`
--
ALTER TABLE `ttransaksi`
  MODIFY `id_transaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
