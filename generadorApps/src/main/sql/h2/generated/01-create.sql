--
-- AQUI SE ESCRIBEN LAS TABLAS QUE CREARÁ LA APLICACION
--
DROP ALL objects;


-- =================================
-- TABLE USER 
-- =================================

CREATE TABLE USER (
	ID INTEGER(10) not null,
	USERNAME VARCHAR(100) not null,
	PASSWORD VARCHAR(100) not null,
	IS_ENABLED BOOLEAN(1) not null default 'TRUE',
	VERSION INTEGER(10) default 0);

CREATE UNIQUE INDEX IF NOT EXISTS USER_UNIQUE_1_INDEX_2 ON USER (USERNAME);
ALTER TABLE USER ALTER COLUMN ID IDENTITY;

-- =================================
-- TABLE PRODUCTO 
-- =================================

CREATE TABLE PRODUCTO (
	ID INTEGER(10) not null,
	nombre VARCHAR(100) not null,
	marca VARCHAR(100) not null,
	IS_ENABLED BOOLEAN(1) not null default 'TRUE',
	VERSION INTEGER(10) default 0);

CREATE UNIQUE INDEX IF NOT EXISTS PRODUCTO_UNIQUE_1_INDEX_2 ON PRODUCTO (PRODUCTO);
ALTER TABLE USER ALTER COLUMN ID IDENTITY;
