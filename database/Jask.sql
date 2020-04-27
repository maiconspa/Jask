CREATE DATABASE Jask;

USE Jask;

CREATE TABLE Usuario(
nome varchar(60) not null, 
email varchar(200) not null unique, 
telefone varchar(20),
apelido varchar(20) primary key unique,
senha varchar(100) not null,
foto longblob
);

CREATE TABLE Projeto(
id_projeto serial,
nome varchar(30),
fk_apelido_proprietario varchar(20),
foreign key (fk_apelido_proprietario) references Usuario(apelido)
);

CREATE TABLE Item_usuario_projeto(
	id_item_usuario_projeto serial,
    fk_apelido_usuario varchar(20),
    fk_id_projeto bigint unsigned,
    foreign key (fk_apelido_usuario) references Usuario(apelido),
    foreign key (fk_id_projeto) references Projeto(id_projeto)
);

CREATE TABLE Mensagem(
	id_mensagem serial,
    fk_apelido_remetente varchar(20),
    fk_apelido_destinatario varchar(20),
    texto varchar(600),
    data_hora_envio datetime,
    data_hora_visualizacao datetime,
    estado_visualizacao enum('1','2','3'),
    foreign key (fk_apelido_remetente) references Usuario(apelido),
    foreign key (fk_apelido_destinatario) references Usuario(apelido)
);

CREATE TABLE Tarefa(
	id_tarefa serial,
    fk_id_projeto bigint unsigned,
    fk_apelido_proprietario varchar(20),
    estado enum('1' , '2' , '3'),
    titulo varchar(20),
    descricao varchar(250),
    prioridade enum('1' , '2', '3'),
    foreign key (fk_id_projeto) references Projeto(id_projeto),
    foreign key (fk_apelido_proprietario) references Usuario(apelido)
);


## INSERÇÕES

# Cadastro dos usuários
INSERT INTO Usuario VALUES
("Larissa", "larissa@gmail.com", "91234-5678", "Lari", "senha", ""),
("Rafael","rafael@gmail.com", "98765-4321", "Rafa", "semsenha", "");


# Cadastro dos Projetos
INSERT INTO Projeto VALUES
(null, "Banco de Dados", "Lari"),
(null, "Java", "Lari"),
(null, "Git", "Rafa"),
(null, "LPI", "Rafa"),
(null, "Docker", "Lari");


# Cadastro das tarefas
INSERT INTO Tarefa VALUES
(null, 1, "Lari", 1, "Update", "Aprender como atualizar uma linha de dados do banco", 1),
(null, 1, "Lari", 2, "Drop Database", "Apaga toda a estrutura do banco de dados do sistema", 1),
(null, 1, "Lari", 3, "Select From", "Aprender como exibir dados do banco na tela", 1),
(null, 2, "Lari", 1, "DAO", "Aprender como utilizar o DAO para acessar os dados do BD", 1),
(null, 2, "Lari", 2, "Objetos", "Criação de Objetos que representam figuras do mundo real em Java", 1),
(null, 2, "Lari", 3, "Main", "Aprender a criar uma estrutura Main básica", 1),
(null, 3, "Rafa", 1, "Commit e Push", "Aprender a enviar uma alteração em um diretório com um comentário", 1),
(null, 3, "Rafa", 2, "Pull", "Fazer o download do diretório mais recente", 1),
(null, 3, "Rafa", 3, "Criar diretório", "Criar um diretório", 1),
(null, 4, "Rafa", 1, "DAO", "Fazer o acesso do Java aos dados do BD", 1),
(null, 4, "Rafa", 2, "Banco de Dados", "Criar o BD e estruturar as classes", 1),
(null, 4, "Rafa", 3, "Interface", "Montar interfaces gráficas para a aplicação", 1);


INSERT INTO Item_usuario_projeto VALUES
(null, "Rafa", 3),
(null, "Rafa", 4);


## ÁREA DE TESTES
-- select * from Tarefa;
-- select nome from Projeto;
-- SELECT * FROM Item_usuario_projeto where fk_apelido_usuario = "Lari";
-- select * from Projeto where id_projeto = 2;

# Utilizado para retirar os efeitos do Horário de Verão)/
-- SET @@GLOBAL.time_zone = '+3:00';

## formato de data: aaaa-dd-mm

/*
Select a.apelido, b.nome, c.titulo
from Usuario as a
inner join  Projeto as b
				on a.apelido = b.fk_apelido_proprietario
inner join Tarefa as c 
				on b.id_projeto = c.fk_id_projeto;
*/

-- Select * from Usuario;
-- Select * from Projeto;
-- Select * from Tarefa;
-- Select id_tarefa, titulo, descricao from Tarefa where fk_id_projeto = 1 and fk_apelido_proprietario = 'Lari'; 
-- desc Tarefa;
-- Select * from Item_usuario_projeto;

-- drop database Jask;