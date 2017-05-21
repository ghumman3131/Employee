-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2017 at 06:30 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employeedetails`
--

-- --------------------------------------------------------

--
-- Table structure for table `employlogin`
--

CREATE TABLE `employlogin` (
  `Pkey` int(11) NOT NULL,
  `E_id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Employee Login';

--
-- Dumping data for table `employlogin`
--

INSERT INTO `employlogin` (`Pkey`, `E_id`, `password`) VALUES
(1, 'e001', 'newpassword'),
(2, 'e002', 'charan'),
(8, 'e003', 'aditya');

-- --------------------------------------------------------

--
-- Table structure for table `healthdetails`
--

CREATE TABLE `healthdetails` (
  `E_id` varchar(20) NOT NULL,
  `Ename` varchar(20) NOT NULL,
  `Bgroup` varchar(10) NOT NULL,
  `Height` varchar(10) NOT NULL,
  `Weight` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `healthdetails`
--

INSERT INTO `healthdetails` (`E_id`, `Ename`, `Bgroup`, `Height`, `Weight`) VALUES
('e001', 'Mr. SK', 'B+', '5\'2"', 48);

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `Leave_id` varchar(20) NOT NULL,
  `L_type` varchar(20) NOT NULL,
  `date_from` date NOT NULL,
  `date_to` date NOT NULL,
  `day_half` varchar(20) NOT NULL,
  `no_days` varchar(20) NOT NULL,
  `E_id` varchar(20) NOT NULL,
  `reason` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`Leave_id`, `L_type`, `date_from`, `date_to`, `day_half`, `no_days`, `E_id`, `reason`) VALUES
('1', 'academic', '2017-04-12', '2017-04-21', 'full_day', '9', 'e001', ' hsjs'),
('2', 'bdh', '2017-04-05', '2017-04-07', 'full-day', '2', 'e001', ' j');

-- --------------------------------------------------------

--
-- Table structure for table `leave_apply`
--

CREATE TABLE `leave_apply` (
  `leave_id` int(11) NOT NULL,
  `l_type` varchar(20) NOT NULL,
  `date_from` varchar(20) NOT NULL,
  `date_to` varchar(20) NOT NULL,
  `day_half` varchar(10) NOT NULL,
  `no_days` int(11) NOT NULL,
  `E_id` varchar(10) NOT NULL,
  `reason` varchar(50) NOT NULL,
  `status` varchar(1) DEFAULT 'P'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leave_apply`
--

INSERT INTO `leave_apply` (`leave_id`, `l_type`, `date_from`, `date_to`, `day_half`, `no_days`, `E_id`, `reason`, `status`) VALUES
(1, 'Academic', '5/5/2017', '29/4/2017', 'full day', 4, 'e001', 'gs', 'A'),
(2, 'Casual', '29/4/2017', '29/4/2017', 'full day', 2, 'e001', 'gs', 'C'),
(3, 'Casual', '29/4/2017', '29/4/2017', 'full day', 2, 'e001', 'gs', 'C'),
(4, 'Casual', '5/5/2017', '3/5/2017', 'full day', 2, 'e003', 'gtgugdeyg', 'C'),
(6, 'Academic', '7/5/2017', '7/5/2017', 'full day', 1, 'e001', 'Urgent ', 'A'),
(7, 'Medical', '8/5/2017', '8/5/2017', 'full day', 1, 'e001', 'Fever', 'C'),
(8, 'Academic', '19/5/2017', '19/5/2017', 'full day', 3, 'e001', 'xyz', 'P'),
(9, 'Select Type of Leave', '25/5/2017', '25/5/2017', 'full day', 4, 'e001', 'oda e', 'P'),
(10, 'Academic', '21/5/2017', '23/5/2017', 'full day', 2, 'e001', 'vaise e', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `personaldetails`
--

CREATE TABLE `personaldetails` (
  `ID` int(11) NOT NULL,
  `E_id` varchar(20) NOT NULL,
  `E_Name` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `Father` varchar(20) NOT NULL,
  `Mother` varchar(20) NOT NULL,
  `MaritalStatus` varchar(10) NOT NULL,
  `Spouse` varchar(20) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Contact` bigint(20) NOT NULL,
  `image_id` longtext
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personaldetails`
--

INSERT INTO `personaldetails` (`ID`, `E_id`, `E_Name`, `DOB`, `Father`, `Mother`, `MaritalStatus`, `Spouse`, `Address`, `Contact`, `image_id`) VALUES
(1, 'e001', 'Mr. S.K', '1994-01-05', 'Surinder Kumar', 'Shashi', 'Single', 'Nil', 'Amritsar', 7837313134, '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');

-- --------------------------------------------------------

--
-- Table structure for table `profdetails`
--

CREATE TABLE `profdetails` (
  `E_id` varchar(20) NOT NULL,
  `Department` varchar(20) NOT NULL,
  `Designation` varchar(20) NOT NULL,
  `Matric` varchar(20) NOT NULL,
  `HighSchool` varchar(20) NOT NULL,
  `Graduation` varchar(20) NOT NULL,
  `PostGraduation` varchar(20) NOT NULL,
  `Rewards` varchar(20) NOT NULL,
  `Exp` varchar(20) NOT NULL,
  `FieldOfSp` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profdetails`
--

INSERT INTO `profdetails` (`E_id`, `Department`, `Designation`, `Matric`, `HighSchool`, `Graduation`, `PostGraduation`, `Rewards`, `Exp`, `FieldOfSp`) VALUES
('e001', 'CS', 'Student', '70', '70', '69', '7.56', 'nil', 'nil', 'nil');

-- --------------------------------------------------------

--
-- Table structure for table `sanctioner_details`
--

CREATE TABLE `sanctioner_details` (
  `ID` int(11) NOT NULL,
  `S_id` varchar(20) NOT NULL,
  `E_Name` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `Father` varchar(20) NOT NULL,
  `Mother` varchar(20) NOT NULL,
  `MaritalStatus` varchar(10) NOT NULL,
  `Spouse` varchar(20) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Contact` bigint(20) NOT NULL,
  `image_id` longtext
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sanctioner_details`
--

INSERT INTO `sanctioner_details` (`ID`, `S_id`, `E_Name`, `DOB`, `Father`, `Mother`, `MaritalStatus`, `Spouse`, `Address`, `Contact`, `image_id`) VALUES
(1, 's001', 'Mr. D.K', '1994-01-05', 'Surinder', 'Shashi', 'Married', 'kudi', 'Amritsar', 7837313134, '/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhUSEhIVFhUVFxcYFhgWGBUYFxcYFRgWFxgXFhcYHSggGBolHRUVITEhJSkrLi4uFx8zODMsNygtLisBCgoKDg0OGhAQGi0lHSUrLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLf/AABEIAMABBwMBIgACEQEDEQH/xAAcAAABBQEBAQAAAAAAAAAAAAAEAQIDBQYHAAj/xABBEAABAwIDBQUGBAUDAgcAAAABAAIRAyEEEjEFQVFhcQYigZGhEzKxwdHwFEJS4QcVI2KSM3LxU6IWQ2OCk6Oy/8QAGgEAAgMBAQAAAAAAAAAAAAAAAgMAAQQFBv/EAC0RAAICAgEDAgUDBQEAAAAAAAABAhEDIRIEMUETUQUiMmGBQnGhI1KRwfAU/9oADAMBAAIRAxEAPwDDAp8qIFPlYkASBeKaXJuZMQIsJwao8ykYUSIPDUpapGJCEfghE1qeaaNwuFzU3OBu3dyQ7gqi07IwYsUbgi3hDPUbBZClhOcF6EDIRkJy8QlASmiDSpaRTCErWqJFE7mqMqZjpCYWpyIQELykIRmycF7SoLd0XKu6IGYan7Ggah952iy2KeSSTvWt7Uv7rQPdFlj62qVjy+orXYgPKVLCWETZBkJYT14hDZCNavshQ7pPNZQroX8PKtNjCa1MPY4EH9TRPvMO5whVLZH2KTa1OanRZvatWX9F0Lb3Zus2owUAa7K5/oPYLP5H9LheZ4E7rZ3tNTwmFpOwjAzEYtxBxGI1bRLTPscPz1Dnb7jk1PTYnFWy4J9jJgryZK8toZflycHqEuSFyQQILk0uUQepWRCJAHgVK0qAm6la9Ei0FMcnSh6ZUqKyy02QTmy/qEKDFU8ri3gU7Y74qs6oztFhsrw7cfklcqy17oq9lNVKhUz0M4pjIKU0lNcUxxQ2UOLk/MhwVJKqi6JQUmZWOBwmemSNVWOEFWimPlOFRS4fCl2iTFYZzNfNTkronF9yB1VaXYTiymY/MsxTZmcBxK2mFoAADksXXZJRhUX3FzdFdtGmTTqOIsNOqyVULd9oCG4Zw4rBlH0q4woNO0iKEuVPDUsJzZCKEhUhCQhQgO8Lo/ZHBOfSbTptJc6wA56zwHNc9yrp+waj6dE+zcW5m5XRvHDl4KOmgZB20e0dHZrPwzQ6s15P4p7HuaQHNLSMOQbOE+9viOnM+0/Zr8NkrUX+2wla9GsB/wDXVH5Kg0IOsdQNZj8GHtPJYmpjK1JlXCtqOFGo5pfTsWuLDLTcWMgXETAmYRwlqgoTvRUwvKQtXkdh2H5l7MmQvQgIPzJweo4XlCmSNKmplDBTNKlkCGuU7XoRhUmZSyB2ErQ9p4ELT9pGTSzcCD52WOa5bPEHPh+rEjK6nFgy00ZDMp8BgXVqjabRdxA6J+ztnuqxA3x5a/ELsvYTsqyhTbUc3+oWtmdxG9a0rDUbMTtD+F1dlLO14c4XLdLLnuIplpLXCCNV9R1sUxo7zguXdueyTK1Q1qO8XA4ypOKSsP02+xyqlSJIHHT1+inq4J7YkXM+i3mzuyTaeRzxpmzg77CIJ4FHVdm0qsngdbbosP8AFZZZlF0aodHKUbMR2er5amQ707buyyH5mix15c1tKOwaLXZgL2PSIgDkjcXsynUbkNhw+9UPrq7QL6Ga2croV3NPd/5VjSxPtbOEFarE9jmx3HCb8BruHDd9lVGP7O1Kb5EnLBsIaBe3Ow0HHej9SLdi5dPkiir2fs4+2Fu6LrQOqwbKPZVJ+Quc0g8CneyM3ssXVScpxSMU013KntVipY1nErNhqtO0D81SBuCjobOe5mYCVpg6Ww4xbWgEsSezWy7Odg8TiSSWljBYOdaTrblC6T2c7A4fDNHtYq1NZIAAJ4D0T1jbCUGzgbqRBiDPDemvpEagjddfSh7NYQuLvYsLjvgSBwHBDYrsphCLUxadNSTfU70fpfcL02fOVId5vULpWCdFIdEva7sZlLqzGspsZeNXO0uTuGtt+p1UIdlw/ggace4nIqKfZ+0JquaVS9p8HDs4QrK5bWzc1pdp0RVoyOCXEHsYYtXlM5sWK8mchpIkhPhehGXY2E0qWE1zVKIRhPaUwhOQlolYVMAkwLA54afzGB1NgpsRRNNzmO1aYKlrsShgW22U6aDOkLFU3Cb6b10nsbsJ1Wk0OsLweI+4QTi5VQMouXYL/hlsifaF7fdqHLO+R/wukVqsCBZVuFpMoMyNEADd6lC18YYF9fnon8uKo2Qx9iDHOta+kTxUFd8OgHjPK0fUqsq4p8xu1B5mRHpPgnGoYLnHXz0JWOeU3xxg20cS50ge7Zred9eJQMOYCXA2mGxcmY0VwKjW94D6zrICjouMXHeJzHSQCSNd37LPw5bY9T46B8PTfYv7s6C+pvfopsOO8TOhidbncpAPaBzgYEiJ4C+vMR4Ep5phuneIgAaQTffaYj1R+kC8oOa3dm2vHUazK8cTIOh1F9ByneU7EYXOSCRA8ra5idTrysFEzD0yQ1pzRuvGvDeNTzQuDXYJTVbGfitLRzj1CHrYZhB3HifvVS4zCuDszj3dLa9JP2Fndp44gAye86B0ES5FGNypgZMWLItoG/kzTVucxJMACSeS6h2W7KUsOwPqgOdEgHQTfzWd7C7IcYxNVsNy9wHWD+Y/fFazHYwgSDot8IpK2YMkIp8YFlidpsYIFuAEKnxG1pNnLI7V2y8FxNmAXJ1MrPntE51mWnf9J16pU8zDhiSOlU9rbpk8kfh8XK57szFzGub7uVqNn1eaqGRtknBItNsbPbWZD5IF44ncTuIHArm3aH+m1zRYbui6RUxLspIMADr5Bcn7Y4sSYMyZ80zM/kOfnWzHOuSVpdhYjMzIVm4RmzMRkeDuSU6FNaG7Yw2WoeBukV1tvD52hwXlctMi7GeypC1SgL2VaAiMNXnNU2VRvUIQuC8zmErk1AyyTSCONirHHy8Nrfqs7qFWtWq7IbO/EB1EkQSNfglytNNFhXZDsmcQQ58gCTfQ7vmfJdbwrGUWNptAAgfQ/BQYDCikwgcZ6FDe1lxtabf8/ei0fSascAiq+TrqL/H6oB9Am26/hGnzRjLy7e2Afn6QkqW1E6+qVN6NESsxRuYEiY9PqhKtCXNn3W+c3DRbnCtmU5O4gTPjx8VBjWANsJ5DrPgLpHpeWO9TwAsAaGvc2Sc0cO6DAA3m7vNLUaXNObugjK42kx3ZHCTdF4otAaNTNvGL+KizjePdNuu4DoD5hOUUgHJsbXJa3uw20yfyNFhPA6eSU1RqPdbJzG1zqeusch5qwmqcrvdF3wLG5hl90iT+6Su5xBIAHAethvJ3q3FFWB1qUNyzL3wSQIDQNAAeA3nj4KXZrWsBDS7dfeeTdx63Q1auZymMxHeAguvuJ9Y+ChGZwiS3Na93Eb53SZFhoIGpCRKrHK6LnFh1QZGFoAPeMTr+VvPmeSo8D2fFWoHPuxjvOOHJWuE09m06ak8+W7xv0VrszKwQL8TuHIJsYJtSEym4xcSweO6GiwjwtuVbi3yOXxRtV0iAbHU/RB4lgNgbDUrU1ZmTMptvZ7qrSBYaydOsfXyWS/lraRkuLju3T6eunPct9tWpbKJA9SPH4LKY4kGwgE3O8+PyWfKkkOx22F7JEQCtfgHhY/ZlMnotZsq9gFmw22Ny0kP2/jmMpHNJJtA+u5cf2zis9Q8At72lx4dXNMaNEcYPRc62g0Co4Dijnl5T4exy8jshShNBSyoKNHs6tnpxwSqp2XicruS8mxmq2AyDKnAJxapKbE0YRZE11JGZU17VdEoCfSUXske5iZkQ0QEaw6Qun/w/2H7IOqPBzOALeEEbud1itgYQPrsaWZxNwNeMjnZdmNJtOk3KIaBpvCuMfI7ErGV609xpv6g/NGYbB9wzob33Qq3ZlHPUD9wdHWRv5rQ4l+VqNRtWzTKVOkV1URJ+5QXtZvuIty+4KfVqEk9P2Qzz5XnxSXsYhzKmsWl30HyUFdrjlmYuXeDT84VhgqHEbx9/FOxTO7bmjULRXOmZ1z3Nh51d7oP5bWCH9uYa27iCLDeSZ8ifgjMThjIc4TlbYdP3J8gq4VQ2pvm2mp0vbjCzyTiaItSLqlYBu83IBsJiBPlpzUWMrTDWuynQGxIH5iAbTaJOirW4gvzZTE750AuTPlfkNyeykYBDczdMxuBF7A+84+Q572J2gHGhxqUyctMExYkyZN9Sb8boTNeznT+YxFuAOoF9B5pf5gDZvdvE6k8SAPLjcptTEh0sbMjWItuG4wT0SZbGRVFlg8sWBJ4aR4fMqyAcB3vQA/BZ/AUiO84ZQNG7+RN7nqVJ/OyLOlvKBMcSJ7viUeKQvJGy7/FTxA/7j5aJWSROg3ToqcbRDoLCSN+hHpb1Uo2m06viOk+E6JyyIU8b8BWJpMEkjMd5+gVLUwOczkgc4k/ToFaNxjD7oPUmT5CwCJFVkXn0+KGTUkXFOLKRuBIsAQPBH7VxX4agYzZ3CBDZjnO5HYXDtc7uuB5XWV7YuqOqZZMN3ND4t4XKCMeEXIXnyaoodmSXuLpLrkk8VQbVH9VyvdiD3yeapdpOmobLNFfOc7yAhLKflUbgnlk1BhNxuXlNhCWtJ4leQOy9EwClamtCkAWxBUKzVI4JzV4hWQdUw9pF0JCOw9XKb6Iirs+XNLdCQluVMhs/4fbIaG+0ME6tIB8DJsVots1joPvipezmBNOi0DQgeCfi8N3xK0KPyj46GbEdlpgEXzX596x+IR21K4DROpQbozGOR9RI8wq7HY/O+BeIj5/FSTqIUFcgmo6ybhRmgcp8PuFBjcQGtEqLZWKGbNOoASV9VD/02aTDtiSfuy9WeCQ0XIv56dP2Q1KqCCT92GnwUNfE5RDBc6nr9/BaOxm7ge1Xxb3jwGkD59VkcXVIcYc0OeYufAmOAAt1Ru2qlaZEgak+cX4Kga9oqFz25nOgAGS4jnwEkD0WXNtm3CqRb4VzQAB7rbuMiHRMTa5m8fZWtji9xDicrRoD/wDtw06RKFc92mYCOAAuf0tBseZ0+BmAwrWmA24MnR0ch/dxdumyrhoJyQLXFNwNiOYMNA/SBbKPFeothuWm6Gg/kaRrqC6PNW1atbK2943BojpohH4B9Qw978guGNGRsczcu38EEoMuM1QGyheBNTXvOeQ0dAJJPl4K6w4DQGl0Dc0NgeANyecILDOAJDaRt+YkSeh3N3cFHWxLj3Rl5hhLiergLevRLSaCbsftinnBygOO4FrjEbzlv4FZXEiq2O9THHVvpPorVu2aglp7oJjSZ494R81W43ZwkvDu9r7hj4H1IVSknoKMWi52FXtd4nx+i0lBgdeZ8/nC5vh8e9joc4dBAPjH1W32Lj+6CpB+Aci8mmwmDbwssx2r2FSaxzmuynWSCR4nctPhMUDG6V7beC9pTOUuaY3XB6hbIpOJgyKzk+yG5cw+zzVNjB3ytR+BNNzgSTM6iPIBZzGU4eVk/WYpR4yoFhGbN2a6q4ACxUFKnJyjUrf7EwraVOSBIVymlJR9ydil7RbObTpsY0aa+C8oO0W1c5yjivK272iWVTHKQFCi3xUwctCYwlaU+FC1yka7irssRxV32WIe/wBk+7TxEj9lR1GwVp/4dsBxImZAtwI3ghVxtoqjrezaDadMMGgFunVUnabEAMe4OLS0WI48L2KuK1WAdNNPosd2kaamGqxBNyL/ABT5OtD4RszGwO0lT8QaNV7HS2zmnuyCDHIx8Fq8HhIM7zc+a5JsDZtR2MpNptsHHM4OBtzvI0GvBd6pYOxKBLkG3Rndqtn5KsweKLXnNoQI9THwWkxuHuqTaFCGEgXU4bstT1Q+v2hY2nJcABv++KrKfbKkXR7Vjf8AcbrmfafaTzDCSCHGfr8UjK7WUiz2NFwInORLzPP1UcvcrhWkdjw+0aVdvdeHTvBlV1XZDQ7ukiTJi5PVxuue9kKDhXZlJyvuWhx912kcLX10IXY9n4elmAy38z5qOnotXHaKvA4BrRIad5kiCT43UowJ9yBG+JDR/uj3jy85Wo/DsAs2UDVwnEkDgIHnG5FQPOyqGFYNegGg8A0SfNOLjBa1um67vG/zRsNEluu9x+SHrAO0cT8J6b0LRaYBXpOYwvqMd0uT/hoquvi2uH+kIM+8xzSI4ayPJXGNz2hpcNTuOh0v8lmdsY2oQQ5rGDfmknyBA81nydjTj2UOPxRa8wHt4Bpc5vU2I9UNiatU0BVLnAF5bYxAix85UL2kuDWhxzGM2V0Sec+qv9q0W/hnUmj3GyOrbz8fNYMuT05RXu/4Dz5lj4r3MpSxLp96eBMLRbD2k5pAn76rJNI4ieYCJw1aDaQRula+FbHXapnTdnbbZnyE5SdxstThsZILXHxvI8VxXEY92QPMloIF7xO77utBsXtR3Mr3SW2Dp1H6XH4GIO9aYNJGPJjd6NRtprc1xM7+fhr1WK2lg5qWbJIt9Voqm1m1BBMG9yIBj9UaHmE6mBFwCdLQs80lOwc2C4cvIDsfYrWNL3XciNrYrJR5lFvO5Z7tDXBc1nBKnuaf4OV3ZSii51wF5arYWCY5nMLyao2hlGSoVRo4SNxGo6cRyRrcMHe49hPCcpPg7f0JVYxSBNGBVWi5hh7S08x8OKQFLQxr2iA6W/pPeb/ibKdmNpH36A603Fvo6R8FZCJtTcR9R0XQf4bUWZiQWk8O8HeINljWNw79Kj2n/wBQBw82wtr2Ls6A2mTuex4II/2nvA8kcO5aNP2hxjWsP3/wqXYeZ7S0szA6HjPEKLtbVILc0AA6mJEdVfdmtpU3gNYIOug87KVymzU3wxon2P2ap0QTlGbkLBWdUgCBuQHaDbzKAAJu7huCrdn7bbVuLp6VIQ227YfXwhNyqjaGALmuA5geKs6mKcSQTEJ+FaHQZ4n6KyrOS7W7HwMxkgl0gtFpMzoqX/wXWcZYKWWd2Yf9pcQu816TSMroM7lQY/YY1Y63C4+aVNS8Doyg/q7mT2Pg6OCZ3n5nnU8I1KO2FtnPWdGm7iR5IDbGx6jcxALpFhmJ8SVn8BtY0ahzNuSLwY8ol2izOUovZqUYyTo7AMXaT8/RQ1Md5qp2bjxUAg+U/Y6I+m1oOhk84+C0p3tGNqhaxP5rjgfl+6iqMOoDPU+R0T3ZG3bJJO82HigC65lwcfAgeGqjIgbGlsGd+68uPCPqYVK+nUe0wWs5XB8YsrjFYox3csjiQPS0BVeMZmbFRzRPI894gcEqSHQbKNlKuK1Njy0szScsCIE3EnN1Vjiaeo4j4qn2XRazFBszAcQRwg8LHVXWLd9+a4XXP+sl9jL1krkjmtVhDotI4mPFTUXHSPMSeV0zDUX1XljWk3OujRO8nQLQ4bBtwbHVpzVPdYdAwutLRrIE3XXyZYwqPl+DY88YtK9sqjWdFiQ7Qi1xwM2PRC4Z8O136aKQPmcxJ3jiTvv5lS4PZ9Sse43TVzrAf7jx6JrkoxuTGOST5MNpVN++1x96rTYEljQ95iSA0O94843DqgdnbLp0Rnec7miZNmtjeB8yq/D4irWeXhjiN3ACbX9fFY45lkbr6V5Jj6mM3S7Luza1KgLMwWMxzszy6ei1OFJyQ8gbombeCD/l9KZJJ5QAEufUY4vbOf1CxRlcWgfs7i3BxbqCNRyXlZUSxnutCVIXXQXuZvViYsNRn8uqx/pvPMAkeYUOVEMB3T4LtKI0jGBqf9N/+LvoicFsms4wKLz/AO11vHd4oplU09XOc79OZwa3/dBlx5aKUVqtQjM4ngBYeDQrUCBuE7Oke8T0DXO84Eeqv9i0G0agLaTuElr/AIAfNU2F2a46t84HxVjh8CR+keKYohIt+0VZwAIIHCQI6GUTg8eaNGpXqBoLWWiYJOnyQopONOA+40y5voqvbmzcRW2fVYKgzsd7QCCM7Wtd3N0G9uiqKakOk7ijObQ297V5LnEk6/e4J+A257Bw4E6cenNc0/HO4lSO2tUfAuY04zxTrQs+gMNtA1RuAt1P0RdPHhsZiAdAB9OKwXY5tQUQ+u8kmIi0+Q08FpKQOoaGC2up+iEhoDjs2gI5kKE4h5NxPPMFHReMt79YIUdXEE8ABzHwhUyAG16joPu9C6PMxouebbw2hAAM/qJPEkAwY8CtztPFACSym4jSXZfjCwmOxFCo4g4cgzc0qzXHqBNxyuk5Ypo04JNM03ZrHjIBlNudz0WkZWkakTuuD6LL7CwwAmm90axVbkIjfLZB9FesE3sfEO8il400qCytNhDz0j+4gz5n5KLEYzQEeTbdePkq3E1Wi4cTFu6Z8OCpNodohTkCXEzwi24jijbFJWX2Iex18pDv1NDZtugkH4rN7WyOa85i7LqBIPSWRx/dUuI7TGpm7w00MA+DhM9FR19rPIub6SdemkekqtsZFJdy17M12jEMykgEOEEk/lJ33Gm4rVYx/PcVzvAYrLVZVEDK4FwHA2PoStnjsRMQZBiOYXJ67E/VjL7GLqvqTEwOHbTaGNFvUniVS9qsXLmUhu7x4SRYeXxR2M2gKLC83P5RxP0Quw8MP9ar33uOYT+Wd/X4KYVwbzT/AB92JwafqSF2TsZxh9Qlrf0x3j14DnqrvG7Rp0AGgX3MbHmeC82pJgXKosdjKIrXLnO/MQ0uE6ZQh+fqJ/N2XhBTyTzP7Ez+0Jky1pHCLePFMqdpKh0IA4ABTt2hup4Vzubmho8oJUFd+MJ7lJlMf2tZPm6SnRwwfeKX7sBYZPu6/Ig23ViZPkPolbtup+rzhSYXD15l4qE84ctJgQcsZL82onhxL2NK6GLjamrKChtx+8B3h9F5SY+rVzlpBHIfsvJT6eD8GV4aENO6Lw7YM7wCR1hRDVEUzBldpIeMoUbq6wzdwEDlv6nUoCiyPkrnCMsmJERPh2Rw8gjKebd9E2iY4eKm9oeKIInoFw58ZJ+FgnUqraZcTADtdN2+ygZxJQG16IqCXEmNAAYEct+ipotHP+1/ZaKrqtEjK/vFtoBd+mNOMFVewNkT/UeRY2BiO6ZMjeVsqbBUqFsC8AD3jHgYaqbHYD2JdTf3cuY8JkgzzFh5INjoY1LRq8HtBrYJcSYB3QOG7r5Itu22tvIuYE38OWi5ThdqvzTNs2nFjj3h1EyOpSMfVNgXOAJG+SLeosZ5K7FtHW8R2haLuMO/uNvRB4vtMNMhI35IcRzgXXOsNhaj25Xk5psTw1E8W8t08gn4TAODsrtJs10nKR+l2rTzBS3linQHJJ0aXae0mPYXsOYaHLLXDq0/uqCmKDnZmgNOpBtfmQNfBDbXoEOGYmY7rvz2/vHvRcQVROJImdLWt4xuPRSSUjRGTidHw+OYxouLaZTM87fRJU23Vc4BthuNp8gJXNmYogzJ6EnVEv2wYiPvx1QKLI5I2u0tvtAu/M4ai4fbWJEO8ZWUx+2RUddrXDUSC1wPVpCHwOArVjnJLWnVzpMjkD7y0mC2ZSp3Dczv1OuR03BKy9RDFp7YmWaMSnw2yzW75Y+k118xcMvOGkZj4IDF+zbLWPc4jVxgNMcG3PjK0m2KlQtLKYLnOET+kcZO9VeH7MOPvPa3kO99Agx9QmuWR17IGOfVspC9aCnjHmhT9mCX+5AE2adfKB4qww3Z2gzUFx/uNvIWV1QphoytaGgbgIHkFnz9ZjdUroXk6hPwZZmwMRVOaq4Dde5joLBaPBbKa0Bpe50DdA+qlxOIZTE1Hho5mFndqdq7FtAcs5t5D6rPy6jqdRVL9tCuU8mvBpcbicNRGQ5S43hxn/JBHbLNPbMAiIDmgRwhc8fXLiXOJJOpOp6pBC2Q+GxS3J2N9L7nRBtCl/1af+Tfqp6eIYdHt8HN+q5wAnC33ZW/hkP7mC8C9zpzJPPon5TzC5zhNZHw+i0ezcY8aPd0kxzSZ/C3Vxl/AUel5OkzS5jx815e2fXzjvAA/fBeWJ9NlToa/hubw0V7VMQoGaqVzl6JMUFYd+7crvBGyztN11cYGsjTCTLWqyRYwQZH0ReWwcNDryPBCU6ibUquaczbj8zeI5KSbW0FegtQY6mC0yY5BLSxDHtzNNt43hNr1LWj5olJNWikzHurvpVAKbcjJuXHlqdxOsSQORiFf1q1HGUSxxa5zbSePC+h5cxKqu0FIPZeQAe8W6x1JgdfsZF20DTHd7tNpEAEgHeGNOsfmc7U+IQhplxQ2EylUhzbTF+s/JXWz8PSZ3gBwPMxElZLaHadxa0uvMjNEEzdxHAAZR48kuH24YAB3mztCAGTfxQNtFmr2hQbY5dDaNR9UPUgjO0XbrHx6LP4ztGAAM3dc3MOlx5iEHgu0AbU9p3i3So0fpP5gPXw5pE4OW0BOCewrbOJc4ENuG3IHnIi4/e6ytY7xIn1Rm3ans6pbTcSwgOY6dWuEi/jHgql1QnVOinQ1ztCspkuDWiSdI3rQbP2Sxl6kOdw/K36oPZDgxpf+YyOg5KarVceQKXlk38qM85N6Rb1totbbU8AoW4uo+wsOX1VR+Jpt1Mnlc/RPpbVcTFMBgGrnXgceCy/+f2X5YHp2afCYcxJUeJ2tQZOaoCeDe8fRUNTHvMhn9QQA575a3nlOYBo8ioGsw0gPdkM60cz2jrn+RKFdGu83/gtYF5ZbHtPLgylTMkgAuPHkPqoK22ahzPfUIpy4U2sgGpBt3tQ3STzgX0dnw2cBjARF3tLJHH+mLx0RVXZTTldDXCBlNnAt3RyR8MWP9H+y2oQe0ZTFYt1Rxc8yfQchwUAK2D8LWg+yeGkbvZ048w2R6qnxm08ZTdlfVe0+AkcRAuFshPkvl/7+BsZRl2ZVCk79LvIohmDqHSlU8GO+ik/nWIOtep/kUv81rj/AM+r/wDI/wCqP5g9ArmefA2I5KWjUUJqEmTcnfvlOARAhLahBV5gqpEXtx1HRU1A7tFYYUxu6EfNF4Cg6ZqMFXgyR5aJEFSJAF929eWCcNnYhLR//9k=');

-- --------------------------------------------------------

--
-- Table structure for table `sanction_login`
--

CREATE TABLE `sanction_login` (
  `employ_id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='santion login ';

--
-- Dumping data for table `sanction_login`
--

INSERT INTO `sanction_login` (`employ_id`, `password`) VALUES
('S001', 'abcd'),
('S002', 'abc');

-- --------------------------------------------------------

--
-- Table structure for table `security`
--

CREATE TABLE `security` (
  `Q_id` int(11) NOT NULL,
  `E_id` varchar(20) NOT NULL,
  `ques` varchar(200) NOT NULL,
  `answer` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `security`
--

INSERT INTO `security` (`Q_id`, `E_id`, `ques`, `answer`) VALUES
(1, 'e001', 'What time of the day were you born?', 'a'),
(3, 'e001', 'What was the name of your elementary / primary school?', 'little');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employlogin`
--
ALTER TABLE `employlogin`
  ADD PRIMARY KEY (`Pkey`),
  ADD UNIQUE KEY `employee_id` (`E_id`);

--
-- Indexes for table `healthdetails`
--
ALTER TABLE `healthdetails`
  ADD PRIMARY KEY (`E_id`);

--
-- Indexes for table `leave_apply`
--
ALTER TABLE `leave_apply`
  ADD PRIMARY KEY (`leave_id`);

--
-- Indexes for table `personaldetails`
--
ALTER TABLE `personaldetails`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sanctioner_details`
--
ALTER TABLE `sanctioner_details`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sanction_login`
--
ALTER TABLE `sanction_login`
  ADD PRIMARY KEY (`employ_id`);

--
-- Indexes for table `security`
--
ALTER TABLE `security`
  ADD PRIMARY KEY (`Q_id`,`E_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employlogin`
--
ALTER TABLE `employlogin`
  MODIFY `Pkey` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `leave_apply`
--
ALTER TABLE `leave_apply`
  MODIFY `leave_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `personaldetails`
--
ALTER TABLE `personaldetails`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `sanctioner_details`
--
ALTER TABLE `sanctioner_details`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `security`
--
ALTER TABLE `security`
  MODIFY `Q_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
