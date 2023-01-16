create database bdvehiculos;
use bdvehiculos;

create table tipolicencia
(
idtipolicencia INT not null primary key AUTO_INCREMENT,
claselicencia varchar(100) null,
categorialicencia varchar(100) null
);

create table tipovehiculo(
idtipovehiculo int not null primary key AUTO_INCREMENT,
clasecategoriavehiculo varchar(100) null,
descripcioncategoriavehiculo varchar(100) null
);

create table vehiculo(
idvehiculo int not null primary key AUTO_INCREMENT,
placavehiculo	varchar(100) not null,
partidaregistralvehiculo varchar(100) null,
idtipovehiculo int,
FOREIGN KEY (idtipovehiculo) REFERENCES tipovehiculo(idtipovehiculo)
);

create table conductor(
idconductor 	int NOT NULL PRIMARY key auto_increment,
dniconductor		varchar(9),
nombreconductor	varchar(100),
apellidoconductor varchar(100),
direccionconductor varchar(100),
telefonoconductor varchar(15),
sexoconductor char(1),
distritoconductor varchar(100),
estadoconductor tinyint,
idtipolicencia int,
idvehiculo int,
FOREIGN KEY (idtipolicencia) REFERENCES tipolicencia(idtipolicencia),
FOREIGN KEY (idvehiculo) REFERENCES vehiculo(idvehiculo)
);

INSERT INTO `bdvehiculos`.`tipolicencia` (`claselicencia`, `categorialicencia`) VALUES ('A1', 'CAT A1');
INSERT INTO `bdvehiculos`.`tipolicencia` (`claselicencia`, `categorialicencia`) VALUES ('A2', 'CAT A2');

INSERT INTO `bdvehiculos`.`tipovehiculo` (`clasecategoriavehiculo`, `descripcioncategoriavehiculo`) VALUES ('CAMION', 'GRANDE');
INSERT INTO `bdvehiculos`.`tipovehiculo` (`clasecategoriavehiculo`, `descripcioncategoriavehiculo`) VALUES ('DEPORTIVO', '-');

INSERT INTO `bdvehiculos`.`vehiculo` (`placavehiculo`, `partidaregistralvehiculo`, `idtipovehiculo`) VALUES ('A0001', 'RG01', '1');

INSERT INTO `bdvehiculos`.`conductor` (`dniconductor`, `nombreconductor`, `apellidoconductor`, `direccionconductor`, `telefonoconductor`, `sexoconductor`, `distritoconductor`, `estadoconductor`, `idtipolicencia`, `idvehiculo`) VALUES ('71717171', 'Pedro', 'Ramoz', 'por ahi', '12345', 'M', 'VES', '1', '1', '1');
