CREATE TABLE IF NOT EXISTS grupo (
	id SERIAL PRIMARY KEY,
	nome varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS time (
	id SERIAL PRIMARY KEY,
	nome varchar(50) NOT NULL,
	nome_time varchar(30),
	slug varchar(30),
	time_id INT
);