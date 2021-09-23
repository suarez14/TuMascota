-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 23, 2021 at 04:51 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tumascotacorregida`
--

-- --------------------------------------------------------

--
-- Table structure for table `clientes`
--

CREATE TABLE `clientes` (
  `Identificacion_cliente` varchar(12) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellidos` varchar(20) NOT NULL,
  `direccion` varchar(20) NOT NULL,
  `telefono` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clientes`
--

INSERT INTO `clientes` (`Identificacion_cliente`, `nombre`, `apellidos`, `direccion`, `telefono`) VALUES
('123456', 'Sebastian', 'Suarez Becerra', 'cra 75 # 86 97', 852963),
('98765', 'Sergio', 'Ramos', 'cra85', 6585);

-- --------------------------------------------------------

--
-- Table structure for table `mascota`
--

CREATE TABLE `mascota` (
  `codigo_mascota` int(11) NOT NULL,
  `nombre_mascota` varchar(20) NOT NULL,
  `edad` int(2) DEFAULT 0,
  `peso` float DEFAULT NULL,
  `especie` varchar(20) DEFAULT NULL,
  `Identificacion_cliente` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mascota`
--

INSERT INTO `mascota` (`codigo_mascota`, `nombre_mascota`, `edad`, `peso`, `especie`, `Identificacion_cliente`) VALUES
(647, 'Rag', 2, 7.1, 'felino', '98765'),
(924, 'Roger', 1, 7.1, 'felino', '98765'),
(951, 'Gerry', 3, 7.1, 'felino', '98765'),
(9517, 'Pacho', 7, 80.1, 'felino', '98765'),
(9876, 'checho', 4, 5.1, 'canino', '123456'),
(44875, 'Max', 10, 7.2, 'canino', '123456'),
(951787, 'Mostro', 3, 6.1, 'felino', '98765');

-- --------------------------------------------------------

--
-- Table structure for table `pago`
--

CREATE TABLE `pago` (
  `codigo_pago` int(10) NOT NULL,
  `abono` double DEFAULT NULL,
  `saldo` double DEFAULT NULL,
  `ctd_cuotas` int(2) DEFAULT NULL,
  `fecha_pago` varchar(20) DEFAULT NULL,
  `plan_afiliacion` varchar(15) DEFAULT NULL,
  `codigo_mascota` int(11) NOT NULL,
  `codigo_plan` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pago`
--

INSERT INTO `pago` (`codigo_pago`, `abono`, `saldo`, `ctd_cuotas`, `fecha_pago`, `plan_afiliacion`, `codigo_mascota`, `codigo_plan`) VALUES
(98, 56000, 2000, 1, '17 Ago 2021', 'Diamante', 647, 1234);

-- --------------------------------------------------------

--
-- Table structure for table `plan`
--

CREATE TABLE `plan` (
  `codigo_plan` int(10) NOT NULL,
  `nombre_plan` varchar(15) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `plan`
--

INSERT INTO `plan` (`codigo_plan`, `nombre_plan`, `descripcion`, `precio`) VALUES
(1234, 'ORO', 'Bacano', 456);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`Identificacion_cliente`);

--
-- Indexes for table `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`codigo_mascota`),
  ADD KEY `FK_Identificacion_cliente` (`Identificacion_cliente`) USING BTREE;

--
-- Indexes for table `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`codigo_pago`),
  ADD KEY `FK_codigo_mascota` (`codigo_mascota`),
  ADD KEY `codigo_plan` (`codigo_plan`);

--
-- Indexes for table `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`codigo_plan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mascota`
--
ALTER TABLE `mascota`
  MODIFY `codigo_mascota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=951788;

--
-- AUTO_INCREMENT for table `pago`
--
ALTER TABLE `pago`
  MODIFY `codigo_pago` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98746;

--
-- AUTO_INCREMENT for table `plan`
--
ALTER TABLE `plan`
  MODIFY `codigo_plan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6542;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `FK_Identificacion_cliente` FOREIGN KEY (`Identificacion_cliente`) REFERENCES `clientes` (`Identificacion_cliente`);

--
-- Constraints for table `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `FK_codigo_mascota` FOREIGN KEY (`codigo_mascota`) REFERENCES `mascota` (`codigo_mascota`),
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`codigo_plan`) REFERENCES `plan` (`codigo_plan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
