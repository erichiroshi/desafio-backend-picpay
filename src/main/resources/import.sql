insert into tb_wallet_type(id, description) values (1, "user")
insert into tb_wallet_type(id, description) values (2, "merchant")

insert into tb_wallet(balance, cpf_cnpj, email, full_name, password, wallet_type_id) values (50.0, "111.111.111-11", "bob@gmail", 'Bob Brown', '123', 1);
insert into tb_wallet(balance, cpf_cnpj, email, full_name, password, wallet_type_id) values ('50.0', '222.222.222-22', 'maria@gmail.com', 'Maria Brown', '123', 2);
