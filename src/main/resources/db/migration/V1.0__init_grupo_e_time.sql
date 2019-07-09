CREATE TABLE IF NOT EXISTS grupo (
	id SERIAL PRIMARY KEY,
	nome varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS time (
	id SERIAL PRIMARY KEY,
	nome varchar(100) NOT NULL,
	nome_time varchar(100),
	slug varchar(50),
	time_id INT
);

CREATE TABLE IF NOT EXISTS grupo_time (
	id_grupo int REFERENCES grupo (id) ON UPDATE CASCADE ON DELETE CASCADE,
	id_time int REFERENCES time (id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT grupo_time_pkey PRIMARY KEY (id_grupo, id_time)
);