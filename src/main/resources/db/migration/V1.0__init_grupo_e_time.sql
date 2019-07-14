CREATE TABLE IF NOT EXISTS grupo (
    id INTEGER IDENTITY PRIMARY KEY,
	nome varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS time (
	id INTEGER IDENTITY PRIMARY KEY,
	nome varchar(100) NOT NULL,
	nome_time varchar(100),
	slug varchar(50),
	time_id INT
);

CREATE TABLE IF NOT EXISTS grupo_time (
	grupo_id int REFERENCES grupo (id) ON UPDATE CASCADE ON DELETE CASCADE,
	time_id int REFERENCES time (id) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT grupo_time_pkey PRIMARY KEY (grupo_id, time_id)
);