PRAGMA Foreing_key=ON;

DROP TABLE IF EXISTS comercio;
CREATE TABLE comercio (
	id					INTEGER PRIMARY KEY,
	establecimiento		TEXT,
	actividad	 		TEXT,
	cod_CIIU			INTEGER,
	clasificacion_Act	TEXT,
	direccion			TEXT,
	telefono			INTEGER	
);

DROP VIEW IF EXISTS datosComercio;
CREATE VIEW datosComercio AS 
select id, establecimiento, actividad, direccion, telefono
from comercio;
