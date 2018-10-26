create database sistemacorporativo;
use sistemacorporativo;

create table funcionario_perfil(
	perfil_id integer not null,
    perfil_descricao varchar(50) not null,
    constraint pk_perfil primary key(perfil_id)
);

create table funcionario (
	fun_id integer not null auto_increment,
    fun_nome varchar(100) not null,
    fun_senha varchar(15) not null,
    fun_login varchar(20) not null,
    fun_rg varchar(15) not null,
    fun_cpf varchar(15) not null,
    fun_data_cadastro datetime not null,
	fun_responsavel integer not null,
    fun_perfil integer not null,
    
    constraint pf_funcionario primary key(fun_id),
    constraint fk_funcionario_perfil foreign key(fun_perfil)
		references funcionario_perfil(perfil_id)
);

create table status_conta(
	status_id integer not null,
    status_descricao varchar(50) not null,
    constraint pk_status primary key(status_id)
);

create table presta_conta(
	conta_id integer not null auto_increment,
    conta_cartao varchar(15),
    conta_mes date,
    fun_id integer not null,
    status_id integer not null,
    
    constraint pk_conta primary key(conta_id),
    constraint fk_funcionario_conta foreign key(fun_id)
		references funcionario(fun_id),
	constraint fk_status_conta foreign key(status_id)
		references status_conta(status_id)
);

create table despesa_categoria(
	categoria_id integer not null,
    categoria_descricao varchar(50) not null,
    constraint pk_despesa primary key(categoria_id)
);

create table conta_despesa(
	despesa_id integer not null auto_increment,
    despesa_data date,
    despesa_valor decimal(10,2) not null,
    despesa_descricao varchar(75),
    despesa_conta_id integer not null,
    categoria_id integer not null, 
    
    constraint pk_consta_despesa primary key(despesa_id),
	constraint fk_conta_despesa foreign key(despesa_conta_id)
		references presta_conta(conta_id),
	constraint fk_conta_categoria foreign key(categoria_id)
		references despesa_categoria(categoria_id)
);

