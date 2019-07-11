CREATE TABLE IF NOT EXISTS campeonato (
	id INTEGER IDENTITY PRIMARY KEY,
	nome varchar(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS campeonato_grupo (
	id_campeonato int REFERENCES campeonato (id) ON UPDATE CASCADE ON DELETE CASCADE,
	id_grupo int REFERENCES grupo (id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT campeonato_grupo_pkey PRIMARY KEY (id_campeonato, id_grupo)
);