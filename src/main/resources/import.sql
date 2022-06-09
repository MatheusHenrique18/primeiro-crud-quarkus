-- INSERINDO VALORES AO INICIAR O BANCO (A CADA NOVA INICIALIZAÇÃO O BANCO É DROPADO E CRIADO NOVAMENTE)
insert into Produto(id, nome, valor, dataCriacao, dataAtualizacao) values
(nextval('hibernate_sequence'), 'Caderno', 25, '2022-06-06 12:09:25-07', '2022-06-06 12:09:25-07'),
(nextval('hibernate_sequence'), 'Caneta', 2, '2022-06-06 12:09:25-07', '2022-06-06 12:09:25-07'),
(nextval('hibernate_sequence'), 'Lápis', 1, '2022-06-06 12:09:25-07', '2022-06-06 12:09:25-07'),
(nextval('hibernate_sequence'), 'Borracha', 5, '2022-06-06 12:09:25-07', '2022-06-06 12:09:25-07'),
(nextval('hibernate_sequence'), 'Apontador', 4, '2022-06-06 12:09:25-07', '2022-06-06 12:09:25-07'),
(nextval('hibernate_sequence'), 'Agenda', 15, '2022-06-06 12:09:25-07', '2022-06-06 12:09:25-07');
