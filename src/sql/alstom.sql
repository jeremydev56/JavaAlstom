drop database if exists alstom ; 
create database alstom; 
use alstom;

create table admin (
	idadmin int(3) not null auto_increment, 
	nom varchar(50),
	prenom varchar(50),
	qualification varchar(50),
	tel varchar(20),
	anciennete int(10),
	primary key(idadmin)
);

create table employe (
	idemploye int(3) not null auto_increment, 
	nom varchar(50),
	prenom varchar(50),
	qualification varchar(50),
	tel varchar(20),
	anciennete int(10),
	primary key(idemploye)
);

create table vehicule (
	idvehicule int(3) not null auto_increment, 
	matricule varchar(50),
	marque varchar(50),
	nbkm int(10),
	energie enum("diesel","gazol","essence","electrique","hybride","autre"),
	anciennete int(10),
	primary key(idvehicule)
);

create table bus (
	idbus int(3) not null auto_increment, 
	matricule varchar(50),
	marque varchar(50),
	nbkm int(10),
	energie enum("diesel","gazol","essence","electrique","hybride","autre"),
	anciennete int(10),
	primary key(idbus)
);

create table metro (
	idmetro int(3) not null auto_increment, 
	matricule varchar(50),
	marque varchar(50),
	nbkm int(10),
	energie enum("diesel","gazol","essence","electrique","hybride","autre"),
	anciennete int(10),
	primary key(idmetro)
);

create table tgv (
	idtgv int(3) not null auto_increment, 
	matricule varchar(50),
	marque varchar(50),
	nbkm int(10),
	energie enum("diesel","gazol","essence","electrique","hybride","autre"),
	anciennete int(10),
	primary key(idtgv)

);

create table user (
	iduser int(3) not null auto_increment,
	email varchar(50),
	mdp varchar(50),
	nom varchar(50),
	prenom varchar(50),
	droits enum ("admin", "user", "autre"),
	primary key(iduser)
);


insert into admin values (null,"Benjamin", "franklin", "Maintenance",
 "0101010101", 10), (null,"Juliette", "romeo", "Réparation Moteur", "0202020202",15);

insert into bus values (null, "23az23", "Peugeot", 20000, "autre", 10), 
	(null, "56rt56", "Citroen", 30000, "essence", 15); 

insert into employe values (null,"macron", "jean", "Président", "0101010101",10), 
	(null,"jake", "spence", "Directeur", "0202020202",15);

insert into metro values (null, "23az23", "Citroën", 20000, "gazol", 10), 
	(null, "56rt56", "Alstom", 30000, "electrique", 15);

insert into tgv values (null, "23az23", "France", 20000, "gazol", 10), 
	(null, "56rt56", "Alstom", 30000, "electrique", 15);

insert into vehicule values (null, "23az23", "Peugeot", 20000, "gazol", 10), 
	(null, "56rt56", "Volswagen", 30000, "essence", 15); 

insert into user values (null, "a@gmail.com", "123", "Sarah", "Bilel", "admin"), (null, "b@gmail.com", "456", "Justin", "Kylian", "user"), (null, "c@gmail.com", "789", "Moulin", "Jean", "admin");






















