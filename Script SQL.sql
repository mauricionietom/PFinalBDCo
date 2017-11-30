create table colmena(

idColmena serial,
nombre VARCHAR(50),
PRIMARY key (idColmena))

insert into colmena values (1,'xxxx');
insert into colmena values (2,'yyyy');
insert into colmena values (3,'zzzzz');

create table visitaTecnica(

idVisita serial,
canridad INTEGER,
calidad VARCHAR(50),
pReina VARCHAR(50),
pMiel VARCHAR(50),
pCera INTEGER,
pAlimento INTEGER,
pCria INTEGER,
pVacios INTEGER,
idColmena INTEGER,

PRIMARY KEY (idVisita),
FOREIGN key (idColmena) REFERENCES colmena (idColmena))

INSERT INTO visitaTecnica  VALUES (1,100,'alta','si','si',10,9,7,8,1)
INSERT INTO visitaTecnica  VALUES (2,100,'media','si','no',9,8,7,6,2)
INSERT INTO visitaTecnica  VALUES (3,100,'baja','no','si',7,4,1,5,3)

create table fabrica(

idFabrica serial,
nombre VARCHAR(50),
PRIMARY KEY (idFabrica))

insert into fabrica VALUES (1,'Rio Rayo')
insert into fabrica VALUES (2,'La leyenda')

create table cajon(

idCajon serial,
idFabrica INTEGER,
PRIMARY key (idCajon),
FOREIGN KEY (idFabrica) REFERENCES fabrica (idFabrica))

insert into cajon values (1,1)
insert into cajon values (2,1)
insert into cajon values (3,2)


create table familia (

idFamilia serial,
nombre VARCHAR (50),
ubicacion VARCHAR(50),
PRIMARY KEY (idFamilia))

insert into familia values (1,'Rodriguez','caucasia')
insert into familia values (2,'Roddddd','Zaragoza')
insert into familia values (3,'Rodriguez','Elbagre')

create table colmenahija (

idColmenaH serial,
idColmena integer,
idFamilia integer,
idCajon INTEGER,
PRIMARY key (idColmenaH),
FOREIGN key (idColmena) REFERENCES colmena (idColmena),
FOREIGN key (idFamilia) REFERENCES familia (idFamilia),
FOREIGN key (idCajon) REFERENCES cajon (idCajon)) 

insert into colmenahija values (5,2,3,1)
insert into colmenahija values (6,3,2,2)
insert into colmenahija values (7,1,1,1)

CREATE table trabajador(

idTrabajador serial,
nombre VARCHAR(45),
PRIMARY key (idTrabajador))

insert into trabajador values (123456,'juan')
insert into trabajador values (546789,'Pdero')
insert into trabajador values (378941,'Lucas')

create table Registro(

idRegistro serial,
idTrabajador integer,
kilos integer,
fecha VARCHAR,
idColmenaH integer,
PRIMARY KEY (idRegistro),
FOREIGN KEY (idTrabajador) REFERENCES trabajador (idTrabajador),
FOREIGN KEY (idColmenaH) REFERENCES colmenahija (idColmenaH))


INSERT INTO registro Values (1,1,50,'1-10-2017',7)
INSERT INTO registro Values (2,2,50,'15-11-2017',6)
INSERT INTO registro Values (3,3,50,'1-15-2017',5)

select colmenahija.idColmenaH, colmena.idcolmena, familia.ubicacion, cajon.idFabrica,sum (registro.kilos) as SumaKilos from colmenahija,colmena,
familia,cajon,registro,trabajador where familia.idFamilia = colmenahija.idFamilia and registro.idColmenaH = colmenahija.idColmenaH and 
Registro.idTrabajador = trabajador.idTrabajador 
and colmena.idColmena = colmenahija.IdColmena and trabajador.idTrabajador != 123456 GROUP BY cajon.idFabrica, colmenahija.idColmenaH, colmena.idcolmena, familia.ubicacion
having sum(registro.kilos)>2 order by sum(registro.kilos) asc limit 10



