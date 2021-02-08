-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2020 a las 00:39:16
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `futbol5`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `FinalizarReservas` ()  NO SQL
UPDATE reservas

SET Estado_Res = 'Finalizado'

WHERE Estado_Res = 'Reservado'
    
      AND DiaPartido_Res < CURRENT_DATE$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canchas`
--

CREATE TABLE `canchas` (
  `ID_Can` int(100) NOT NULL,
  `ID_Comp` int(100) NOT NULL,
  `Nombre_Can` varchar(50) NOT NULL,
  `Tamaño_Can` int(2) NOT NULL,
  `Precio_Can` int(10) NOT NULL,
  `Observaciones_Can` varchar(1000) NOT NULL,
  `Estado_Can` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `canchas`
--

INSERT INTO `canchas` (`ID_Can`, `ID_Comp`, `Nombre_Can`, `Tamaño_Can`, `Precio_Can`, `Observaciones_Can`, `Estado_Can`) VALUES
(55, 6245, 'Cancha 1', 5, 1100, 'Cancha Techada.', 'Activo'),
(56, 6246, 'Cancha 6', 5, 1100, 'Cancha Techada.', 'Activo'),
(57, 6251, 'Cancha 5', 5, 2000, 'Aire Acondicionado.', 'Activo'),
(58, 6245, 'Cancha 2', 5, 1500, 'Piso de Parque.', 'Activo'),
(59, 6251, 'Cancha 4', 5, 1000, 'Cancha al Aire Libre.', 'Activo'),
(60, 6246, 'Cancha 3', 5, 1100, 'Cancha Techada.', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `complejos`
--

CREATE TABLE `complejos` (
  `ID_Comp` int(100) NOT NULL,
  `ID_Usu` int(100) NOT NULL,
  `Nombre_Comp` varchar(50) NOT NULL,
  `Ciudad_Comp` varchar(50) NOT NULL,
  `Direccion_Comp` varchar(50) NOT NULL,
  `Foto_Comp` varchar(1000) NOT NULL,
  `Observaciones_Comp` varchar(1000) NOT NULL,
  `Estado_Comp` varchar(8) NOT NULL,
  `AcumCalf_Comp` int(10) NOT NULL,
  `ContCalf_Comp` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `complejos`
--

INSERT INTO `complejos` (`ID_Comp`, `ID_Usu`, `Nombre_Comp`, `Ciudad_Comp`, `Direccion_Comp`, `Foto_Comp`, `Observaciones_Comp`, `Estado_Comp`, `AcumCalf_Comp`, `ContCalf_Comp`) VALUES
(6245, 2, 'La Rosarina', 'Rosario', 'Maipu 1585', 'https://ventas.fa-sol-la.com.ar/iconos/sin_imagen.jpg', 'Sin observaciones', 'Activo', 13, 3),
(6246, 2, 'Futbol Funes', 'Funes', 'Suipacha 123', 'https://pbs.twimg.com/profile_images/1243179726522535936/qdoyHuIV_400x400.jpg', 'Sin observaciones', 'Activo', 0, 0),
(6248, 2, 'PSG', 'Funes', 'Alberdi 1235', 'https://ventas.fa-sol-la.com.ar/iconos/sin_imagen.jpg', 'Sin observaciones', 'Activo', 0, 0),
(6249, 2, 'Gladiador', 'Rosario', 'SanteFe 2141', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Escudo_del_Club_Atl%C3%A9tico_Boca_Juniors.svg/512px-Escudo_del_Club_Atl%C3%A9tico_Boca_Juniors.svg.png', 'Sin observaciones', 'Activo', 0, 0),
(6250, 2, 'Heroes', 'Roldan', 'Francia 3100', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Escudo_del_Club_Atl%C3%A9tico_Boca_Juniors.svg/512px-Escudo_del_Club_Atl%C3%A9tico_Boca_Juniors.svg.png', 'Sin observaciones', 'Activo', 0, 0),
(6251, 2, 'Boca Juniors', 'Rosario', 'Montevideo 1154', 'https://i.pinimg.com/originals/3a/72/01/3a72010bf124cee8f5616d7b61e22800.jpg', 'Sin observaciones', 'Activo', 4, 2),
(6252, 2, 'El Templo', 'Rosario', '9 De Julio 3450', 'https://ventas.fa-sol-la.com.ar/iconos/sin_imagen.jpg', 'Sin observaciones', 'Activo', 0, 0),
(6261, 2, 'La Previa', 'Funes', 'Moreno 1233', 'https://ventas.fa-sol-la.com.ar/iconos/sin_imagen.jpg', 'Sin observaciones', 'Activo', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dias`
--

CREATE TABLE `dias` (
  `ID_Dia` int(100) NOT NULL,
  `ID_Comp` int(100) NOT NULL,
  `Dia_Dia` varchar(10) NOT NULL,
  `Estado_Dia` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `dias`
--

INSERT INTO `dias` (`ID_Dia`, `ID_Comp`, `Dia_Dia`, `Estado_Dia`) VALUES
(22, 6245, '1', 'Activo'),
(23, 6245, '2', 'Activo'),
(24, 6245, '3', 'Activo'),
(25, 6245, '4', 'Activo'),
(26, 6245, '5', 'Activo'),
(27, 6245, '6', 'Activo'),
(28, 6245, '0', 'Activo'),
(29, 6246, '1', 'Activo'),
(30, 6246, '2', 'Activo'),
(31, 6246, '3', 'Activo'),
(32, 6246, '4', 'Activo'),
(33, 6246, '5', 'Activo'),
(34, 6246, '6', 'Activo'),
(35, 6246, '0', 'Activo'),
(36, 6247, '1', 'Activo'),
(37, 6247, '2', 'Activo'),
(38, 6247, '3', 'Activo'),
(39, 6247, '4', 'Activo'),
(40, 6248, '1', 'Activo'),
(41, 6248, '2', 'Activo'),
(42, 6248, '0', 'Activo'),
(43, 6249, '1', 'Activo'),
(44, 6249, '3', 'Activo'),
(45, 6249, '0', 'Activo'),
(46, 6250, '1', 'Activo'),
(47, 6250, '3', 'Activo'),
(48, 6251, '1', 'Activo'),
(49, 6251, '2', 'Activo'),
(50, 6251, '3', 'Activo'),
(51, 6251, '4', 'Activo'),
(52, 6251, '5', 'Activo'),
(53, 6251, '6', 'Activo'),
(54, 6251, '0', 'Activo'),
(55, 6252, '1', 'Activo'),
(56, 6252, '2', 'Activo'),
(57, 6252, '3', 'Activo'),
(58, 6255, '1', 'Activo'),
(59, 6257, '2', 'Activo'),
(60, 6258, '2', 'Activo'),
(61, 6261, '2', 'Activo'),
(62, 6262, '1', 'Activo'),
(63, 6263, '1', 'Activo'),
(64, 6264, '1', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `ID_Hor` int(11) NOT NULL,
  `ID_Comp` int(100) NOT NULL,
  `Horarios_Hor` time NOT NULL,
  `Estado_Hor` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`ID_Hor`, `ID_Comp`, `Horarios_Hor`, `Estado_Hor`) VALUES
(42, 6245, '07:00:00', 'Activo'),
(43, 6245, '08:00:00', 'Activo'),
(44, 6245, '09:00:00', 'Activo'),
(45, 6245, '10:00:00', 'Activo'),
(46, 6245, '11:00:00', 'Activo'),
(47, 6245, '12:00:00', 'Activo'),
(48, 6245, '13:00:00', 'Activo'),
(49, 6245, '14:00:00', 'Activo'),
(50, 6245, '15:00:00', 'Activo'),
(51, 6245, '16:00:00', 'Activo'),
(52, 6245, '17:00:00', 'Activo'),
(53, 6245, '18:00:00', 'Activo'),
(54, 6245, '19:00:00', 'Activo'),
(55, 6245, '20:00:00', 'Activo'),
(56, 6245, '21:00:00', 'Activo'),
(57, 6245, '22:00:00', 'Activo'),
(58, 6246, '12:00:00', 'Activo'),
(59, 6246, '13:00:00', 'Activo'),
(60, 6246, '14:00:00', 'Activo'),
(61, 6246, '15:00:00', 'Activo'),
(62, 6246, '16:00:00', 'Activo'),
(63, 6246, '17:00:00', 'Activo'),
(64, 6246, '18:00:00', 'Activo'),
(65, 6246, '19:00:00', 'Activo'),
(66, 6246, '20:00:00', 'Activo'),
(67, 6246, '21:00:00', 'Activo'),
(68, 6246, '22:00:00', 'Activo'),
(69, 6246, '23:00:00', 'Activo'),
(70, 6247, '08:00:00', 'Activo'),
(71, 6247, '09:00:00', 'Activo'),
(72, 6247, '14:00:00', 'Activo'),
(73, 6247, '15:00:00', 'Activo'),
(74, 6247, '16:00:00', 'Activo'),
(75, 6248, '08:00:00', 'Activo'),
(76, 6248, '09:00:00', 'Activo'),
(77, 6248, '14:00:00', 'Activo'),
(78, 6248, '15:00:00', 'Activo'),
(79, 6248, '16:00:00', 'Activo'),
(80, 6249, '12:00:00', 'Activo'),
(81, 6249, '13:00:00', 'Activo'),
(82, 6249, '14:00:00', 'Activo'),
(83, 6249, '15:00:00', 'Activo'),
(84, 6250, '12:00:00', 'Activo'),
(85, 6250, '13:00:00', 'Activo'),
(86, 6250, '14:00:00', 'Activo'),
(87, 6250, '15:00:00', 'Activo'),
(88, 6251, '12:00:00', 'Activo'),
(89, 6251, '13:00:00', 'Activo'),
(90, 6251, '14:00:00', 'Activo'),
(91, 6251, '15:00:00', 'Activo'),
(92, 6252, '12:00:00', 'Activo'),
(93, 6252, '13:00:00', 'Activo'),
(94, 6252, '14:00:00', 'Activo'),
(95, 6252, '15:00:00', 'Activo'),
(96, 6255, '12:00:00', 'Activo'),
(97, 6255, '13:00:00', 'Activo'),
(98, 6255, '14:00:00', 'Activo'),
(99, 6255, '15:00:00', 'Activo'),
(100, 6255, '16:00:00', 'Activo'),
(101, 6257, '12:00:00', 'Activo'),
(102, 6257, '13:00:00', 'Activo'),
(103, 6257, '00:00:00', 'Activo'),
(104, 6258, '12:00:00', 'Activo'),
(105, 6258, '13:00:00', 'Activo'),
(106, 6258, '00:00:00', 'Activo'),
(107, 6261, '12:00:00', 'Activo'),
(108, 6261, '13:00:00', 'Activo'),
(109, 6261, '18:00:00', 'Activo'),
(110, 6261, '19:00:00', 'Activo'),
(111, 6262, '12:00:00', 'Activo'),
(112, 6262, '13:00:00', 'Activo'),
(113, 6262, '14:00:00', 'Activo'),
(114, 6262, '15:00:00', 'Activo'),
(115, 6263, '12:00:00', 'Activo'),
(116, 6263, '13:00:00', 'Activo'),
(117, 6263, '18:00:00', 'Activo'),
(118, 6263, '19:00:00', 'Activo'),
(119, 6263, '19:00:00', 'Activo'),
(120, 6264, '12:00:00', 'Activo'),
(121, 6264, '13:00:00', 'Activo'),
(122, 6264, '25:00:00', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `ID_Res` int(100) NOT NULL,
  `ID_Usu` int(100) NOT NULL,
  `ID_Hor` int(100) NOT NULL,
  `ID_Can` int(100) NOT NULL,
  `Dia_Res` date NOT NULL,
  `DiaPartido_Res` date NOT NULL,
  `Precio_Res` int(10) NOT NULL,
  `Observaciones_Res` varchar(1000) NOT NULL,
  `Estado_Res` varchar(10) NOT NULL,
  `Calificacion_Res` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`ID_Res`, `ID_Usu`, `ID_Hor`, `ID_Can`, `Dia_Res`, `DiaPartido_Res`, `Precio_Res`, `Observaciones_Res`, `Estado_Res`, `Calificacion_Res`) VALUES
(74, 3, 47, 55, '2020-09-01', '2020-09-27', 200, 'Sin Observaciones', 'Finalizado', 3),
(75, 3, 47, 60, '2020-09-13', '2020-09-13', 350, 'A nombre de Lucas', 'Finalizado', 4),
(76, 3, 47, 59, '2020-09-13', '2020-09-13', 350, 'A nombre de Giselle', 'Finalizado', 9),
(77, 3, 47, 58, '2020-09-13', '2020-09-13', 350, 'A nombre de JONH', 'Finalizado', 5),
(80, 3, 47, 55, '2020-09-20', '2020-09-28', 200, 'A nombre de Pedro', 'Finalizado', 9),
(81, 2, 47, 58, '2020-09-20', '2020-10-01', 350, 'Sin Observaciones', 'Reservado', 0),
(82, 5, 55, 55, '2020-09-27', '2020-09-27', 200, 'Sin Observaciones', 'Finalizado', 0),
(83, 3, 47, 55, '2020-09-30', '2020-09-30', 200, 'Sin Observaciones', 'Suspendido', 0),
(84, 2, 47, 55, '2020-11-02', '2020-11-02', 200, 'A nombre de Christian', 'Reservado', 0),
(85, 3, 47, 58, '2020-11-02', '2020-11-02', 350, 'Sin Observaciones', 'Suspendido', 0),
(86, 5, 55, 55, '2020-11-10', '2020-11-10', 900, 'Sin Observaciones', 'Reservado', 0),
(87, 3, 47, 55, '2020-11-11', '2020-11-11', 1100, 'Sin Observaciones', 'Suspendido', 0),
(88, 3, 47, 58, '2020-11-11', '2020-11-11', 800, 'Sin Observaciones', 'Suspendido', 0),
(89, 3, 47, 55, '2020-11-11', '2020-11-11', 1100, 'Sin Observaciones', 'Suspendido', 0),
(90, 3, 47, 55, '2020-11-11', '2020-11-11', 1100, 'Sin Observaciones', 'Suspendido', 0),
(91, 3, 47, 55, '2020-11-11', '2020-11-13', 1100, 'Sin Observaciones', 'Suspendido', 0),
(92, 3, 47, 55, '2020-11-11', '2020-11-13', 1100, 'Sin Observaciones', 'Suspendido', 0),
(93, 3, 47, 55, '2020-11-11', '2020-11-13', 1100, 'Sin Observaciones', 'Finalizado', 9),
(94, 3, 47, 55, '2020-11-11', '2020-11-11', 1100, 'Sin Observaciones', 'Suspendido', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID_Usu` int(100) NOT NULL,
  `Usuario_Usu` varchar(50) NOT NULL,
  `Contraseña_Usu` varchar(50) NOT NULL,
  `Correo_Usu` varchar(50) NOT NULL,
  `Nivel_Usu` varchar(10) NOT NULL,
  `Estado_Usu` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_Usu`, `Usuario_Usu`, `Contraseña_Usu`, `Correo_Usu`, `Nivel_Usu`, `Estado_Usu`) VALUES
(1, 'admin', 'admin', 'admin@admin.com', 'Admin', '1'),
(2, 'Pedro', 'dueño', 'lucas_25_94@hotmail.com', 'Dueño', '1'),
(3, 'Alfonso', 'jugador', 'zoelalucas@gmail.com', 'Jugador', '1'),
(5, 'Geronimo', 'Geronimo', 'geropeppers@hotmail.com', 'Jugador', '1'),
(6, 'Fer', 'prueba123', 'fernandoesco18@gmail.com', 'Jugador', '1'),
(7, 'Virginia', 'virginia', 'virginia.zoela@gmail.com', 'Jugador', '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `canchas`
--
ALTER TABLE `canchas`
  ADD PRIMARY KEY (`ID_Can`);

--
-- Indices de la tabla `complejos`
--
ALTER TABLE `complejos`
  ADD PRIMARY KEY (`ID_Comp`);

--
-- Indices de la tabla `dias`
--
ALTER TABLE `dias`
  ADD PRIMARY KEY (`ID_Dia`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`ID_Hor`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`ID_Res`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID_Usu`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `canchas`
--
ALTER TABLE `canchas`
  MODIFY `ID_Can` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `complejos`
--
ALTER TABLE `complejos`
  MODIFY `ID_Comp` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6265;

--
-- AUTO_INCREMENT de la tabla `dias`
--
ALTER TABLE `dias`
  MODIFY `ID_Dia` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `ID_Hor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `ID_Res` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=95;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID_Usu` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

DELIMITER $$
--
-- Eventos
--
CREATE DEFINER=`root`@`localhost` EVENT `Job Finalizar Reservas` ON SCHEDULE EVERY 1 DAY STARTS '2020-09-28 00:00:00' ENDS '2020-09-30 00:00:00' ON COMPLETION PRESERVE ENABLE DO call FinalizarReservas()$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
