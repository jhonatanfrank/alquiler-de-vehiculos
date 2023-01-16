use bdvehiculos;

-- -------------------- Tipo de Licencias ------------------------------
DELIMITER $$
CREATE PROCEDURE sp_MantListarTipoLicencia()
begin
    SELECT		tp.tipolicencia,tp.claselicencia,tp.categorialicencia
	FROM		tipolicencia tp
	ORDER BY	tp.idtipolicencia DESC;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE sp_MantRegistrarTipoLicencia(
in _claselicencia		VARCHAR(100),
in _categorialicencia		VARCHAR(100)
)
begin
	INSERT INTO tipolicencia ( claselicencia,categorialicencia) 
	VALUES (_claselicencia,_categorialicencia);
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE sp_MantActualizarTipoLicencia(
in _idtipolicencia	INT,
in _claselicencia		VARCHAR(100),
in _categorialicencia		VARCHAR(100)
)
begin
	UPDATE	tipolicencia 
	SET		claselicencia = _claselicencia,
			categorialicencia = _categorialicencia
	WHERE	idtipolicencia = _idtipolicencia;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_MantEliminarTipoLicencia(
in _idtipolicencia	INT
)
begin
	delete from tipolicencia where idtipolicencia = _idtipolicencia;
END$$
DELIMITER ;

-- -------------------- Tipo de vehiculos ------------------------------
DELIMITER $$
CREATE PROCEDURE sp_MantListarTipoVehiculo()
begin
    SELECT		tv.idtipovehiculo,tv.clasecategoriavehiculo,tv.descripcioncategoriavehiculo
	FROM		tipovehiculo tv
	ORDER BY	tv.idtipovehiculo DESC;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE sp_MantRegistrarTipoVehiculo(
in _clasecategoriavehiculo		VARCHAR(100),
in _descripcioncategoriavehiculo		VARCHAR(100)
)
begin
	INSERT INTO tipovehiculo ( clasecategoriavehiculo,descripcioncategoriavehiculo) 
	VALUES (_clasecategoriavehiculo,_descripcioncategoriavehiculo);
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE sp_MantActualizarTipoVehiculo(
in _idtipovehiculo	INT,
in _clasecategoriavehiculo		VARCHAR(100),
in _descripcioncategoriavehiculo		VARCHAR(100)
)
begin
	UPDATE	tipovehiculo 
	SET		clasecategoriavehiculo = _clasecategoriavehiculo,
			descripcioncategoriavehiculo = _descripcioncategoriavehiculo
	WHERE	idtipovehiculo = _idtipovehiculo;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_MantEliminarTipoVehiculo(
in _idtipovehiculo	INT
)
begin
	delete from tipovehiculo where idtipovehiculo = _idtipovehiculo;
END$$
DELIMITER ;

-- -------------------- Conductor ------------------------------
DELIMITER $$
CREATE PROCEDURE sp_MantListarConductor()
begin
    SELECT		c.idconductor,c.dniconductor,c.nombreconductor,c.apellidoconductor,c.direccionconductor,c.telefonoconductor,c.sexoconductor,c.distritoconductor,c.estadoconductor,c.idtipolicencia,tp.claselicencia,c.idvehiculo,v.placavehiculo
	FROM		conductor c
    INNER JOIN tipolicencia tp ON tp.idtipolicencia = c.idtipolicencia
    INNER JOIN vehiculo v ON v.idvehiculo = c.idvehiculo
	ORDER BY	c.idconductor DESC;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE sp_MantRegistrarConductor(
in _dniconductor varchar(9),
in _nombreconductor 	varchar(100),
in _apellidoconductor varchar(100),
in _direccionconductor varchar(100),
in _telefonoconductor varchar(15),
in _sexoconductor char(1),
in _distritoconductor varchar(100),
in _estadoconductor tinyint,
in _idtipolicencia int,
in _idvehiculo int 
)
begin

	INSERT INTO conductor ( dniconductor, nombreconductor,apellidoconductor,direccionconductor,telefonoconductor,sexoconductor,distritoconductor,estadoconductor,idtipolicencia,idvehiculo) 
	VALUES (_dniconductor,_nombreconductor,_apellidoconductor,_direccionconductor,_telefonoconductor,_sexoconductor,_distritoconductor,_estadoconductor,_idtipolicencia,_idvehiculo);
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE sp_MantActualizarConductor(
in _idconductor int,
in _dniconductor varchar(9),
in _nombreconductor 	varchar(100),
in _apellidoconductor varchar(100),
in _direccionconductor varchar(100),
in _telefonoconductor varchar(15),
in _sexoconductor char(1),
in _distritoconductor varchar(100),
in _estadoconductor tinyint,
in _idtipolicencia int,
in _idvehiculo int 
)
begin
	UPDATE	conductor 
	SET		dniconductor = _dniconductor,
			nombreconductor = _nombreconductor,
            apellidoconductor = _apellidoconductor,
            direccionconductor = _direccionconductor,
            telefonoconductor = _telefonoconductor,
            sexoconductor = _sexoconductor,
            distritoconductor = _distritoconductor,
            estadoconductor = _estadoconductor,
            idtipolicencia = _idtipolicencia,
            idvehiculo = _idvehiculo
	WHERE	idconductor = _idconductor;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_MantEliminarConductor(
in _idconductor	INT
)
begin
	delete from conductor where idconductor = _idconductor;
END$$
DELIMITER ;

-- -------------- vehiculo -------------------


DELIMITER $$
CREATE PROCEDURE sp_ManteListarVehiculo()
begin
	SELECT	idvehiculo,placavehiculo,partidaregistralvehiculo,v.idtipovehiculo,tv.clasecategoriavehiculo
	FROM		vehiculo v
	INNER JOIN	tipovehiculo tv on v.idtipovehiculo = tv.idtipovehiculo
	ORDER BY	idvehiculo DESC;
END$$
DELIMITER ;



DELIMITER $$
CREATE PROCEDURE sp_MantRegistrarVehiculo(
in _placavehiculo		VARCHAR(100),
in _partidaregistralvehiculo		VARCHAR(100),
in _idtipovehiculo			int
)
begin
	INSERT INTO VEHICULO (placavehiculo, partidaregistralvehiculo,idtipovehiculo) 
	VALUES (_placavehiculo, _partidaregistralvehiculo,_idtipovehiculo);
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_MantActualizarVehiculo(
in _idvehiculo			int,
in _placavehiculo		VARCHAR(100),
in _partidaregistralvehiculo		VARCHAR(100),
in _idtipovehiculo			int
)
begin
	UPDATE	vehiculo
	SET		placavehiculo = _placavehiculo, 
			partidaregistralvehiculo = _partidaregistralvehiculo,
			idtipovehiculo = _idtipovehiculo
	WHERE	idvehiculo = _idvehiculo;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE sp_MantEliminarVehiculo(
in _idvehiculo		int
)
begin
	delete from vehiculo where idvehiculo = _idvehiculo;
END$$
DELIMITER ;

