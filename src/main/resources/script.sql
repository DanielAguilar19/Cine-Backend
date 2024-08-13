/* 


CREATE DATABASE cine;
USE cine;

CREATE TABLE TipoSala (
    codigoTipoSala BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Sala (
    codigoSala BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigoTipoSala BIGINT,
    FOREIGN KEY (codigoTipoSala) REFERENCES TipoSala(codigoTipoSala)
);

CREATE TABLE Asiento (
    codigoAsiento BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigoSala BIGINT,
    disponible BOOLEAN NOT NULL DEFAULT TRUE,
    numeroAsiento VARCHAR(10) NOT NULL,
    FOREIGN KEY (codigoSala) REFERENCES Sala(codigoSala)
);

CREATE TABLE Pelicula (
    codigoPelicula BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    duracion TIME NOT NULL,
    disponible BOOLEAN NOT NULL DEFAULT TRUE,
    descripcion TEXT,
    imagen VARCHAR(255)
);

CREATE TABLE Evento (
    codigoEvento BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigoPelicula BIGINT,
    codigoSala BIGINT,
    disponible BOOLEAN NOT NULL DEFAULT TRUE,
    horaInicio TIME NOT NULL,
    fechaEvento DATE NOT NULL,
    idioma VARCHAR(50) NOT NULL,
    formato VARCHAR(50) NOT NULL,
    FOREIGN KEY (codigoPelicula) REFERENCES Pelicula(codigoPelicula),
    FOREIGN KEY (codigoSala) REFERENCES Sala(codigoSala)
);

CREATE TABLE Cliente (
    codigoCliente BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombreCompleto VARCHAR(255) NOT NULL,
    clienteFrecuente BOOLEAN NOT NULL DEFAULT FALSE,
    fechaNacimiento DATE,
    telefono VARCHAR(20),
    correo VARCHAR(255) UNIQUE,
    contrasenia VARCHAR(255) NOT NULL
);

CREATE TABLE Factura (
    codigoFactura BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigoCliente BIGINT,
    numeroTarjeta VARCHAR(20) NOT NULL,
    fechaCompra DATE NOT NULL,
    descuento DECIMAL(10, 2) DEFAULT 0,
    totalCompra DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (codigoCliente) REFERENCES Cliente(codigoCliente)
);

CREATE TABLE DetalleFactura (
    codigoDetalleFactura BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigoFactura BIGINT,
    cantidadBoletos INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (codigoFactura) REFERENCES Factura(codigoFactura)
);

CREATE TABLE Boleto (
    codigoBoleto BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigoEvento BIGINT,
    codigoAsiento BIGINT,
    codigoDetalleFactura BIGINT,
    FOREIGN KEY (codigoEvento) REFERENCES Evento(codigoEvento),
    FOREIGN KEY (codigoAsiento) REFERENCES Asiento(codigoAsiento),
    FOREIGN KEY (codigoDetalleFactura) REFERENCES DetalleFactura(codigoDetalleFactura)
);

-- Nueva tabla para gestionar la disponibilidad de los asientos por función
CREATE TABLE AsientoFuncion (
    codigoAsiento BIGINT,
    codigoFuncion BIGINT,
    disponible BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (codigoAsiento, codigoFuncion),
    FOREIGN KEY (codigoAsiento) REFERENCES Asiento(codigoAsiento),
    FOREIGN KEY (codigoFuncion) REFERENCES Funcion(codigoFuncion)
);



 */