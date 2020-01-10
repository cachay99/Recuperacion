CREATE TABLE IF NOT EXISTS raza(
	id IDENTITY,
	especie VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS personaje(
	id IDENTITY,
	nombre VARCHAR(255),
	portador VARCHAR(3),
	codRaza INT,
	FOREIGN KEY (codRaza) REFERENCES raza(id)
);