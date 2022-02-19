-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2022 at 05:51 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carsalesystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `addadmin`
--

CREATE TABLE `addadmin` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `Username` varchar(500) NOT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `addadmin`
--

INSERT INTO `addadmin` (`id`, `name`, `Username`, `password`) VALUES
(1, 'ahmed gamal', 'ag12', '1234'),
(3, 'ahmed osama', 'ao123', '1234'),
(4, 'ahmed ismaiel', 'ahmedismaiel', 'ahmedismaiel'),
(5, 'ahmed mohamed gabr', 'ahmed_gabr', '123456789'),
(6, 'mohamed12', 'mo12', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `addcar`
--

CREATE TABLE `addcar` (
  `id` int(11) NOT NULL,
  `model` varchar(100) NOT NULL,
  `manufacture_type` varchar(100) NOT NULL,
  `year_of_purchase` varchar(50) NOT NULL,
  `availablecolor` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `addcar`
--

INSERT INTO `addcar` (`id`, `model`, `manufacture_type`, `year_of_purchase`, `availablecolor`, `price`, `code`, `image`) VALUES
(4, 'Nissan', 'nissan', '2020', 'Red , White , Black , Silver', '01A1', '01A1', 'E:\\Project\\CarsSalesSystem\\src\\image\\nissan01B.jpg'),
(5, 'BMW', 'bmw', '2021', 'White , Black , Red , Gray ', '750000', '02A1', 'E:\\Project\\CarsSalesSystem\\src\\image\\bmwX3_03A.png'),
(6, 'BMW12A', 'bmw', '2022', 'White , Black', '022A', '022A', 'E:\\Project\\CarsSalesSystem\\src\\image\\BMWX1_02A.png'),
(7, 'Toyota', 'toyota', '2021', 'Red , White , Black , Blue , Gray , BLUEPRINT', '3,500,000', '10CA', 'E:\\Project\\CarsSalesSystem\\src\\image\\toyota.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `addadmin`
--
ALTER TABLE `addadmin`
  ADD PRIMARY KEY (`id`,`Username`);

--
-- Indexes for table `addcar`
--
ALTER TABLE `addcar`
  ADD PRIMARY KEY (`id`,`code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `addadmin`
--
ALTER TABLE `addadmin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `addcar`
--
ALTER TABLE `addcar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
