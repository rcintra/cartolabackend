drop table if exists Campeonato;
drop table if exists Time;
drop table if exists Grupo;
drop table if exists Grupo_Time;
drop table if exists Rodada;
drop table if exists Rodada_Time;
drop table if exists Camp_Grupo;

CREATE TABLE "Campeonato" (
	"id" serial NOT NULL,
	"nome" varchar(20),
	CONSTRAINT "Campeonato_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Time" (
	"id" serial NOT NULL,
	"nome" varchar(20),
	"slug" VARCHAR(255) NOT NULL,
	"time_id" integer NOT NULL,
	"nome_cartola" VARCHAR(255) NOT NULL,
	CONSTRAINT "Time_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Grupo" (
	"id" serial NOT NULL,
	"nome" varchar(255) NOT NULL,
	CONSTRAINT "Grupo_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Grupo_Time" (
	"id_grupo" integer NOT NULL,
	"id_time" integer NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Rodada" (
	"id" serial NOT NULL,
	"numero" integer NOT NULL,
	"rodada_atual" integer NOT NULL,
	"nome" varchar(255) NOT NULL,
	CONSTRAINT "Rodada_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Rodada_Time" (
	"id_rodada" integer NOT NULL,
	"id" serial NOT NULL,
	"pontos" FLOAT NOT NULL,
	"id_time" integer NOT NULL,
	CONSTRAINT "Rodada_Time_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Camp_Grupo" (
	"id_campeonato" BINARY NOT NULL,
	"id_grupo" integer NOT NULL
) WITH (
  OIDS=FALSE
);






ALTER TABLE "Grupo_Time" ADD CONSTRAINT "Grupo_Time_fk0" FOREIGN KEY ("id_grupo") REFERENCES "Grupo"("id");
ALTER TABLE "Grupo_Time" ADD CONSTRAINT "Grupo_Time_fk1" FOREIGN KEY ("id_time") REFERENCES "Time"("id");


ALTER TABLE "Rodada_Time" ADD CONSTRAINT "Rodada_Time_fk0" FOREIGN KEY ("id_rodada") REFERENCES "Rodada"("id");
ALTER TABLE "Rodada_Time" ADD CONSTRAINT "Rodada_Time_fk1" FOREIGN KEY ("id_time") REFERENCES "Time"("id");

ALTER TABLE "Camp_Grupo" ADD CONSTRAINT "Camp_Grupo_fk0" FOREIGN KEY ("id_campeonato") REFERENCES "Campeonato"("id");
ALTER TABLE "Camp_Grupo" ADD CONSTRAINT "Camp_Grupo_fk1" FOREIGN KEY ("id_grupo") REFERENCES "Grupo"("id");

