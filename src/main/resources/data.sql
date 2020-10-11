insert into cliente (cnh, data_de_nascimento, email, estado, nome, sobrenome) values ('1111111111', '2000-01-01', 'oliveiramatheus11@gmail.com', 'COM_DADOS_BASICOS', 'Matheus', 'Oliveira');
insert into cliente (cnh, data_de_nascimento, email, estado, nome, sobrenome) values ('2222222222', '2000-02-02', 'vivianecristina@gmail.com', 'COM_DADOS_BASICOS', 'Viviane', 'Cristina');
insert into cliente (cnh, data_de_nascimento, email, estado, nome, sobrenome) values ('3333333333', '2000-03-03', 'josericardo@gmail.com', 'COM_DADOS_BASICOS', 'José', 'Ricardo');
insert into cliente (cnh, data_de_nascimento, email, estado, nome, sobrenome) values ('4444444444', '2000-04-04', 'joaoriberto@gmail.com', 'COM_DADOS_BASICOS', 'João', 'Riberto');

insert into endereco (bairro, cep, cidade, complemento, estado, rua) values ('Centro', '12630-000', 'Cachoeira Paulista', 'casa', 'SP', 'Rua 1');
insert into endereco (bairro, cep, cidade, complemento, estado, rua) values ('Pitéu', '12630-000', 'Cachoeira Paulista', 'Apt. 40', 'SP', 'Rua 5');
insert into endereco (bairro, cep, cidade, complemento, estado, rua) values ('Vila Carmem', '12630-000', 'Cachoeira Paulista', '', 'SP', 'Rua 10');

update cliente set endereco_id=1, estado='COM_ENDERECO' where id=2;
update cliente set endereco_id=2, estado='COM_ENDERECO' where id=3;
update cliente set endereco_id=2, estado='COM_ENDERECO' where id=4;

insert into log_de_aprovacao (cliente_id, data_de_alteracao, estado) values (3, '2020-10-11 17:34:34.774', 'ACEITE');
insert into log_de_aprovacao (cliente_id, data_de_alteracao, estado) values (4, '2020-08-11 10:34:34.774', 'ACEITE');

update cliente set estado='ACEITE' where id=3;
update cliente set estado='ACEITE' where id=4;

insert into conta_corrente (agencia, cliente_id, codigo_do_banco, conta, log_de_aprovacao_id, saldo) values ('9711', '3', '777', '12044205', '1', '0.00');
insert into conta_corrente (agencia, cliente_id, codigo_do_banco, conta, log_de_aprovacao_id, saldo) values ('9711', '4', '777', '22252525', '2', '0.00');

update conta_corrente set saldo='-500.00' where id=1;
update conta_corrente set saldo='500.00' where id=2;
insert into transferencia_interna (conta_de_destino_id, conta_de_origem_id, dataehora_do_pedido, valor) values ('1', '2', '2020-10-11T17:48:36.796', '500');

insert into transferencia_externa (agencia_de_destino, codigo_do_banco_de_destino, conta_de_destino, conta_de_origem_id, data_da_solicitacao, descricao, documento, favoritado, nome_do_banco_de_destino, nome_do_favorecido, tipo_de_conta, valor) values ('7777', '01', '77777777', '2', '2020-12-10', 'Descrição', '44.547.893-1', 'true', 'Banco do Brasil', 'Viviane', 'CORRENTE', '300');

update conta_corrente set saldo=saldo-300 where id='2';
