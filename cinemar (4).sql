-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-07-2022 a las 22:39:30
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cinemar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `butaca`
--

CREATE TABLE `butaca` (
  `idButaca` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `idSala` int(11) NOT NULL,
  `Modelo` varchar(30) NOT NULL,
  `idEstado_Butaca` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuento`
--

CREATE TABLE `descuento` (
  `idDescuento` int(11) NOT NULL,
  `Dias` varchar(30) NOT NULL,
  `Porcentaje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domicilio`
--

CREATE TABLE `domicilio` (
  `idDomicilio` int(11) NOT NULL,
  `Calle` varchar(30) NOT NULL,
  `Numero` varchar(30) NOT NULL,
  `Ciudad` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_butaca`
--

CREATE TABLE `estado_butaca` (
  `idEstado_Butaca` int(11) NOT NULL,
  `Estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_reserva`
--

CREATE TABLE `estado_reserva` (
  `idEstado_Reserva` int(11) NOT NULL,
  `Estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion`
--

CREATE TABLE `funcion` (
  `idFuncion` int(11) NOT NULL,
  `idSala` int(11) NOT NULL,
  `Fecha` int(11) NOT NULL,
  `Hora` int(11) NOT NULL,
  `idPelicula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `idPago` int(11) NOT NULL,
  `Tipo_Pago` varchar(30) NOT NULL,
  `Precio` double NOT NULL,
  `idReserva` int(11) NOT NULL,
  `idDescuento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `idPelicula` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Genero` varchar(30) NOT NULL,
  `Director` varchar(30) NOT NULL,
  `Reparto` varchar(30) NOT NULL,
  `Duracion` varchar(30) NOT NULL,
  `idTipo_Pelicula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `Codigo` varchar(30) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idEstado_Reserva` int(11) NOT NULL,
  `Fecha` varchar(30) NOT NULL,
  `Hora` varchar(30) NOT NULL,
  `idFuncion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva_x_butaca`
--

CREATE TABLE `reserva_x_butaca` (
  `idReserva` int(11) NOT NULL,
  `idButaca` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL,
  `Tipo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `idSala` int(11) NOT NULL,
  `Numero` int(11) NOT NULL,
  `Capacidad` int(11) NOT NULL,
  `idTipo_Sala` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_pelicula`
--

CREATE TABLE `tipo_pelicula` (
  `idTipo_Pelicula` int(11) NOT NULL,
  `Formato` varchar(30) NOT NULL,
  `Idioma` varchar(30) NOT NULL,
  `Subtitulado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_sala`
--

CREATE TABLE `tipo_sala` (
  `idTipo_Sala` int(11) NOT NULL,
  `Formato` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `dni` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL,
  `fechadenacimiento` varchar(30) NOT NULL,
  `Descuento` int(11) NOT NULL,
  `idRol` int(11) NOT NULL,
  `idDomicilio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `butaca`
--
ALTER TABLE `butaca`
  ADD PRIMARY KEY (`idButaca`),
  ADD KEY `fk_idSala` (`idSala`),
  ADD KEY `fk_idEstado_Butaca` (`idEstado_Butaca`);

--
-- Indices de la tabla `descuento`
--
ALTER TABLE `descuento`
  ADD PRIMARY KEY (`idDescuento`);

--
-- Indices de la tabla `domicilio`
--
ALTER TABLE `domicilio`
  ADD PRIMARY KEY (`idDomicilio`);

--
-- Indices de la tabla `estado_butaca`
--
ALTER TABLE `estado_butaca`
  ADD PRIMARY KEY (`idEstado_Butaca`);

--
-- Indices de la tabla `estado_reserva`
--
ALTER TABLE `estado_reserva`
  ADD PRIMARY KEY (`idEstado_Reserva`);

--
-- Indices de la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD PRIMARY KEY (`idFuncion`),
  ADD KEY `fk_idSala` (`idSala`),
  ADD KEY `fk_idPelicula` (`idPelicula`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`idPago`),
  ADD KEY `idReserva` (`idReserva`),
  ADD KEY `idDescuento` (`idDescuento`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`idPelicula`),
  ADD KEY `fk_idTipo_Pelicula` (`idTipo_Pelicula`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `fk_idUsuario` (`idUsuario`),
  ADD KEY `fk_idEstado_Reserva` (`idEstado_Reserva`),
  ADD KEY `fk_idFuncion` (`idFuncion`);

--
-- Indices de la tabla `reserva_x_butaca`
--
ALTER TABLE `reserva_x_butaca`
  ADD PRIMARY KEY (`idReserva`,`idButaca`),
  ADD KEY `idButaca` (`idButaca`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`idSala`),
  ADD KEY `fk_idTipo_Sala` (`idTipo_Sala`);

--
-- Indices de la tabla `tipo_pelicula`
--
ALTER TABLE `tipo_pelicula`
  ADD PRIMARY KEY (`idTipo_Pelicula`);

--
-- Indices de la tabla `tipo_sala`
--
ALTER TABLE `tipo_sala`
  ADD PRIMARY KEY (`idTipo_Sala`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `idRol` (`idRol`),
  ADD KEY `idDomicilio` (`idDomicilio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `butaca`
--
ALTER TABLE `butaca`
  MODIFY `idButaca` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `descuento`
--
ALTER TABLE `descuento`
  MODIFY `idDescuento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `domicilio`
--
ALTER TABLE `domicilio`
  MODIFY `idDomicilio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado_butaca`
--
ALTER TABLE `estado_butaca`
  MODIFY `idEstado_Butaca` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estado_reserva`
--
ALTER TABLE `estado_reserva`
  MODIFY `idEstado_Reserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `funcion`
--
ALTER TABLE `funcion`
  MODIFY `idFuncion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `idPago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `idPelicula` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `idSala` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_pelicula`
--
ALTER TABLE `tipo_pelicula`
  MODIFY `idTipo_Pelicula` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_sala`
--
ALTER TABLE `tipo_sala`
  MODIFY `idTipo_Sala` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `butaca`
--
ALTER TABLE `butaca`
  ADD CONSTRAINT `fk_idEstado_Butaca` FOREIGN KEY (`idEstado_Butaca`) REFERENCES `butaca` (`idButaca`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD CONSTRAINT `fk_idPelicula` FOREIGN KEY (`idPelicula`) REFERENCES `funcion` (`idFuncion`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `idDescuento` FOREIGN KEY (`idDescuento`) REFERENCES `pago` (`idPago`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD CONSTRAINT `fk_idTipo_Pelicula` FOREIGN KEY (`idTipo_Pelicula`) REFERENCES `pelicula` (`idPelicula`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_idFuncion` FOREIGN KEY (`idFuncion`) REFERENCES `reserva` (`idReserva`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `reserva_x_butaca`
--
ALTER TABLE `reserva_x_butaca`
  ADD CONSTRAINT `reserva_x_butaca_ibfk_1` FOREIGN KEY (`idReserva`) REFERENCES `reserva` (`idReserva`),
  ADD CONSTRAINT `reserva_x_butaca_ibfk_2` FOREIGN KEY (`idButaca`) REFERENCES `butaca` (`idButaca`);

--
-- Filtros para la tabla `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `fk_idTipo_Sala` FOREIGN KEY (`idTipo_Sala`) REFERENCES `sala` (`idSala`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `idDomicilio` FOREIGN KEY (`idDomicilio`) REFERENCES `usuario` (`idUsuario`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
