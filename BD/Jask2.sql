create database Jask;

use Jask;

create table Usuario(
nome varchar(60) not null,
email varchar(200) not null unique,
telefone varchar(20),
apelido varchar(20) primary key not null unique,
senha varchar(100) not null,
foto longblob
);

create table Projeto(
id_projeto serial,
nome varchar(30),
fk_apelido_proprietario varchar(20),
foreign key (fk_apelido_proprietario) references Usuario(apelido)
);

create table Item_usuario_projeto(
id_item_usuario_projeto serial,
fk_apelido_usuario varchar(20),
fk_id_projeto bigint,
foreign key (fk_apelido_usuario) references Usuario(apelido),
foreign key (fk_id_projeto) references Projeto(id_projeto)
);

create table Mensagem(
id_mensagem serial,
fk_apelido_remetente varchar(20),
fk_apelido_destinatario varchar(20),
texto varchar(600),
data_hora_envio datetime,
data_hora_visualizacao datetime,
estado_visualizacao boolean,
foreign key (fk_apelido_remetente) references Usuario(apelido),
foreign key (fk_apelido_destinatario) references Usuario(apelido)
);

create table Tarefa(
id_tarefa serial,
fk_id_projeto bigint,
fk_apelido_atribuicao varchar(20),
fk_apelido_proprietario varchar(20),
estado varchar(30),
titulo varchar(20),
descricao varchar(250),
foreign key (fk_id_projeto) references Projeto(id_projeto),
foreign key (fk_apelido_atribuicao) references Usuario(apelido),
foreign key (fk_apelido_proprietario) references Usuario(apelido)
);

create table Item_usuario_tarefa(
id_item_usuario_tarefa serial,
fk_apelido_usuario varchar(20),
fk_id_tarefa bigint,
foreign key (fk_apelido_usuario) references Usuario(apelido),
foreign key(fk_id_tarefa) references Tarefa(id_tarefa)
);

/*drop database Jask;*/