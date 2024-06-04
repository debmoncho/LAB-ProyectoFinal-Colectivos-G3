-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2024 at 04:57 AM
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
-- Database: `empresadecolectivos-g3`
--
CREATE DATABASE IF NOT EXISTS `empresadecolectivos-g3` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `empresadecolectivos-g3`;

-- --------------------------------------------------------

--
-- Table structure for table `colectivos`
--

CREATE TABLE `colectivos` (
  `idColectivo` int(11) NOT NULL,
  `matricula` varchar(30) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `horarios`
--

CREATE TABLE `horarios` (
  `idHorario` int(11) NOT NULL,
  `idRuta` int(11) NOT NULL,
  `horaSalida` time NOT NULL,
  `horaLlegada` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pasajeros`
--

CREATE TABLE `pasajeros` (
  `idPasajero` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `telefono` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pasajes`
--

CREATE TABLE `pasajes` (
  `idPasaje` int(11) NOT NULL,
  `idPasajero` int(11) NOT NULL,
  `idColectivo` int(11) NOT NULL,
  `idRuta` int(11) NOT NULL,
  `fechaViaje` date NOT NULL,
  `horaViaje` time NOT NULL,
  `asiento` int(11) NOT NULL,
  `precio` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rutas`
--

CREATE TABLE `rutas` (
  `idRuta` int(11) NOT NULL,
  `origen` varchar(30) NOT NULL,
  `destino` varchar(30) NOT NULL,
  `duracionEstimada` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `colectivos`
--
ALTER TABLE `colectivos`
  ADD PRIMARY KEY (`idColectivo`);

--
-- Indexes for table `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`idHorario`),
  ADD KEY `idRuta` (`idRuta`);

--
-- Indexes for table `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`idPasajero`),
  ADD UNIQUE KEY `dni` (`dni`,`correo`);

--
-- Indexes for table `pasajes`
--
ALTER TABLE `pasajes`
  ADD PRIMARY KEY (`idPasaje`),
  ADD KEY `idPasajero` (`idPasajero`),
  ADD KEY `idColectivo` (`idColectivo`),
  ADD KEY `idRuta` (`idRuta`);

--
-- Indexes for table `rutas`
--
ALTER TABLE `rutas`
  ADD PRIMARY KEY (`idRuta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `colectivos`
--
ALTER TABLE `colectivos`
  MODIFY `idColectivo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `horarios`
--
ALTER TABLE `horarios`
  MODIFY `idHorario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `idPasajero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pasajes`
--
ALTER TABLE `pasajes`
  MODIFY `idPasaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rutas`
--
ALTER TABLE `rutas`
  MODIFY `idRuta` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`idRuta`) REFERENCES `rutas` (`idRuta`);

--
-- Constraints for table `pasajes`
--
ALTER TABLE `pasajes`
  ADD CONSTRAINT `pasajes_ibfk_1` FOREIGN KEY (`idPasajero`) REFERENCES `pasajeros` (`idPasajero`),
  ADD CONSTRAINT `pasajes_ibfk_2` FOREIGN KEY (`idColectivo`) REFERENCES `colectivos` (`idColectivo`),
  ADD CONSTRAINT `pasajes_ibfk_3` FOREIGN KEY (`idRuta`) REFERENCES `rutas` (`idRuta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
