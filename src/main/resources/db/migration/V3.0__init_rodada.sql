CREATE TABLE IF NOT EXISTS rodada (
	id INTEGER IDENTITY PRIMARY KEY,
	nome varchar(100) NOT NULL,
	numero int,
	rodada_atual int	
);

CREATE TABLE IF NOT EXISTS rodada_time (
	id INTEGER IDENTITY PRIMARY KEY,
	pontos DECIMAL,
	rodada_id int,
	time_id int
);

ALTER TABLE rodada_time ADD CONSTRAINT fk_rodada_time_rodada FOREIGN KEY (rodada_id) REFERENCES rodada (id);
ALTER TABLE rodada_time ADD CONSTRAINT fk_rodada_time_time FOREIGN KEY (time_id) REFERENCES time (id);
