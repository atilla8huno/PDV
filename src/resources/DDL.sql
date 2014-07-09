CREATE SCHEMA pdv;

CREATE TABLE pdv.unidade_medida (
  id_unidade_medida SERIAL NOT NULL PRIMARY KEY,
  descricao CHARACTER VARYING(45) NOT NULL,
  sigla CHARACTER VARYING(3) NOT NULL
);

CREATE TABLE pdv.produto (
  id_produto SERIAL NOT NULL PRIMARY KEY,
  nome CHARACTER VARYING(45) NOT NULL,
  codigo INT NOT NULL UNIQUE,
  valor NUMERIC(8,2) NOT NULL,
  status BOOLEAN NOT NULL DEFAULT TRUE,
  id_unidade_medida INT NOT NULL,
  FOREIGN KEY (id_unidade_medida) REFERENCES pdv.unidade_medida (id_unidade_medida)
);

CREATE TABLE pdv.cargo (
  id_cargo SERIAL NOT NULL PRIMARY KEY,
  nome CHARACTER VARYING(45) NOT NULL,
  perfil CHARACTER VARYING(20) NOT NULL
);

CREATE TABLE pdv.terminal (
  id_terminal SERIAL NOT NULL PRIMARY KEY,
  numero SMALLINT NOT NULL UNIQUE,
  status BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE pdv.venda (
  id_venda SERIAL NOT NULL PRIMARY KEY,
  data_cadastro TIMESTAMP NOT NULL,
  entrega_domicilio BOOLEAN DEFAULT FALSE,
  nome_cliente CHARACTER VARYING(45),
  endereco_cliente CHARACTER VARYING(200),
  contato_cliente CHARACTER VARYING(45),
  valor_total NUMERIC(8,2) NOT NULL,
  valor_pago NUMERIC(8,2) NOT NULL,
  valor_troco NUMERIC(8,2) NOT NULL,
  id_terminal INT NOT NULL,
  FOREIGN KEY (id_terminal) REFERENCES pdv.terminal (id_terminal)
);

CREATE TABLE pdv.funcionario (
  id_funcionario SERIAL NOT NULL PRIMARY KEY,
  nome CHARACTER VARYING(45) NOT NULL,
  data_admissao DATE,
  status BOOLEAN NOT NULL DEFAULT TRUE,
  cpf CHARACTER VARYING(14) NOT NULL UNIQUE,
  senha CHARACTER VARYING(32) NOT NULL,
  id_cargo INT NOT NULL,
  FOREIGN KEY (id_cargo) REFERENCES pdv.cargo (id_cargo)
);

CREATE TABLE pdv.venda_produto (
  id_venda_produto SERIAL NOT NULL PRIMARY KEY,
  id_venda INT NOT NULL,
  id_produto INT NOT NULL,
  quantidade NUMERIC(6,3) NOT NULL,
  valor NUMERIC(8,2) NOT NULL,
  FOREIGN KEY (id_venda) REFERENCES pdv.venda (id_venda),
  FOREIGN KEY (id_produto) REFERENCES pdv.produto (id_produto)
);

CREATE TABLE pdv.forma_pagamento (
  id_forma_pagamento SERIAL NOT NULL PRIMARY KEY,
  descricao CHARACTER VARYING(45) NOT NULL
);

CREATE TABLE pdv.venda_forma_pagamento (
  id_venda_forma_pagamento SERIAL NOT NULL PRIMARY KEY,
  id_forma_pagamento INT NOT NULL,
  id_venda INT NOT NULL,
  valor NUMERIC(8,2),
  FOREIGN KEY (id_forma_pagamento) REFERENCES pdv.forma_pagamento (id_forma_pagamento),
  FOREIGN KEY (id_venda) REFERENCES pdv.venda (id_venda)
);

CREATE TABLE pdv.movimento_caixa (
  id_movimento_caixa SERIAL NOT NULL PRIMARY KEY,
  id_terminal INT NOT NULL,
  id_funcionario INT NOT NULL,
  data_hora_abertura TIMESTAMP NOT NULL,
  data_hora_fechamento TIMESTAMP,
  fundo_abertura NUMERIC(8,2) NOT NULL,
  fundo_fechamento NUMERIC(8,2),
  FOREIGN KEY (id_terminal) REFERENCES pdv.terminal (id_terminal),
  FOREIGN KEY (id_funcionario) REFERENCES pdv.funcionario (id_funcionario)
);

CREATE USER administrador WITH PASSWORD '123456';
CREATE USER supervisor WITH PASSWORD '123456';
CREATE USER atendente WITH PASSWORD '123456';
CREATE USER desenvolvedor WITH PASSWORD '123456';

GRANT ALL ON DATABASE desenvolvimento TO administrador;
GRANT ALL ON SCHEMA pdv TO administrador;
GRANT ALL ON TABLE pdv.cargo TO administrador;
GRANT ALL ON TABLE pdv.funcionario TO administrador;
GRANT ALL ON TABLE pdv.forma_pagamento TO administrador;
GRANT ALL ON TABLE pdv.movimento_caixa TO administrador;
GRANT ALL ON TABLE pdv.produto TO administrador;
GRANT ALL ON TABLE pdv.terminal TO administrador;
GRANT ALL ON TABLE pdv.unidade_medida TO administrador;
GRANT ALL ON TABLE pdv.venda TO administrador;
GRANT ALL ON TABLE pdv.venda_forma_pagamento TO administrador;
GRANT ALL ON TABLE pdv.venda_produto TO administrador;
GRANT ALL ON SEQUENCE pdv.cargo_id_cargo_seq TO administrador;
GRANT ALL ON SEQUENCE pdv.funcionario_id_funcionario_seq TO administrador;
GRANT ALL ON SEQUENCE pdv.forma_pagamento_id_forma_pagamento_seq TO administrador;
GRANT ALL ON SEQUENCE pdv.movimento_caixa_id_movimento_caixa_seq TO administrador;
GRANT ALL ON SEQUENCE pdv.produto_id_produto_seq TO administrador;
GRANT ALL ON SEQUENCE pdv.terminal_id_terminal_seq TO administrador;
GRANT ALL ON SEQUENCE pdv.unidade_medida_id_unidade_medida_seq TO administrador;
GRANT ALL ON SEQUENCE pdv.venda_id_venda_seq TO administrador;
GRANT ALL ON SEQUENCE pdv.venda_forma_pagamento_id_venda_forma_pagamento_seq TO administrador;
GRANT ALL ON SEQUENCE pdv.venda_produto_id_venda_produto_seq TO administrador;

GRANT ALL ON DATABASE desenvolvimento TO desenvolvedor;
GRANT ALL ON SCHEMA pdv TO desenvolvedor;
GRANT ALL ON TABLE pdv.cargo TO desenvolvedor;
GRANT ALL ON TABLE pdv.funcionario TO desenvolvedor;
GRANT ALL ON TABLE pdv.forma_pagamento TO desenvolvedor;
GRANT ALL ON TABLE pdv.movimento_caixa TO desenvolvedor;
GRANT ALL ON TABLE pdv.produto TO desenvolvedor;
GRANT ALL ON TABLE pdv.terminal TO desenvolvedor;
GRANT ALL ON TABLE pdv.unidade_medida TO desenvolvedor;
GRANT ALL ON TABLE pdv.venda TO desenvolvedor;
GRANT ALL ON TABLE pdv.venda_forma_pagamento TO desenvolvedor;
GRANT ALL ON TABLE pdv.venda_produto TO desenvolvedor;
GRANT ALL ON SEQUENCE pdv.cargo_id_cargo_seq TO desenvolvedor;
GRANT ALL ON SEQUENCE pdv.funcionario_id_funcionario_seq TO desenvolvedor;
GRANT ALL ON SEQUENCE pdv.forma_pagamento_id_forma_pagamento_seq TO desenvolvedor;
GRANT ALL ON SEQUENCE pdv.movimento_caixa_id_movimento_caixa_seq TO desenvolvedor;
GRANT ALL ON SEQUENCE pdv.produto_id_produto_seq TO desenvolvedor;
GRANT ALL ON SEQUENCE pdv.terminal_id_terminal_seq TO desenvolvedor;
GRANT ALL ON SEQUENCE pdv.unidade_medida_id_unidade_medida_seq TO desenvolvedor;
GRANT ALL ON SEQUENCE pdv.venda_id_venda_seq TO desenvolvedor;
GRANT ALL ON SEQUENCE pdv.venda_forma_pagamento_id_venda_forma_pagamento_seq TO desenvolvedor;
GRANT ALL ON SEQUENCE pdv.venda_produto_id_venda_produto_seq TO desenvolvedor;

GRANT ALL ON DATABASE desenvolvimento TO atendente;
GRANT ALL ON SCHEMA pdv TO atendente;
GRANT SELECT ON TABLE pdv.cargo TO atendente;
GRANT SELECT ON TABLE pdv.funcionario TO atendente;
GRANT SELECT ON TABLE pdv.forma_pagamento TO atendente;
GRANT SELECT, UPDATE, INSERT ON TABLE pdv.movimento_caixa TO atendente;
GRANT SELECT ON TABLE pdv.produto TO atendente;
GRANT SELECT ON TABLE pdv.terminal TO atendente;
GRANT SELECT ON TABLE pdv.unidade_medida TO atendente;
GRANT SELECT, INSERT ON TABLE pdv.venda TO atendente;
GRANT SELECT, INSERT ON TABLE pdv.venda_forma_pagamento TO atendente;
GRANT SELECT, INSERT ON TABLE pdv.venda_produto TO atendente;
GRANT ALL ON SEQUENCE pdv.cargo_id_cargo_seq TO atendente;
GRANT ALL ON SEQUENCE pdv.funcionario_id_funcionario_seq TO atendente;
GRANT ALL ON SEQUENCE pdv.forma_pagamento_id_forma_pagamento_seq TO atendente;
GRANT ALL ON SEQUENCE pdv.movimento_caixa_id_movimento_caixa_seq TO atendente;
GRANT ALL ON SEQUENCE pdv.produto_id_produto_seq TO atendente;
GRANT ALL ON SEQUENCE pdv.terminal_id_terminal_seq TO atendente;
GRANT ALL ON SEQUENCE pdv.unidade_medida_id_unidade_medida_seq TO atendente;
GRANT ALL ON SEQUENCE pdv.venda_id_venda_seq TO atendente;
GRANT ALL ON SEQUENCE pdv.venda_forma_pagamento_id_venda_forma_pagamento_seq TO atendente;
GRANT ALL ON SEQUENCE pdv.venda_produto_id_venda_produto_seq TO atendente;

GRANT ALL ON DATABASE desenvolvimento TO supervisor;
GRANT ALL ON SCHEMA pdv TO supervisor;
GRANT SELECT ON TABLE pdv.cargo TO supervisor;
GRANT SELECT ON TABLE pdv.funcionario TO supervisor;
GRANT SELECT ON TABLE pdv.forma_pagamento TO supervisor;
GRANT SELECT, UPDATE, INSERT ON TABLE pdv.movimento_caixa TO supervisor;
GRANT SELECT ON TABLE pdv.produto TO supervisor;
GRANT SELECT ON TABLE pdv.terminal TO supervisor;
GRANT SELECT ON TABLE pdv.unidade_medida TO supervisor;
GRANT SELECT, INSERT ON TABLE pdv.venda TO supervisor;
GRANT SELECT, INSERT ON TABLE pdv.venda_forma_pagamento TO supervisor;
GRANT SELECT, INSERT ON TABLE pdv.venda_produto TO supervisor;
GRANT ALL ON SEQUENCE pdv.cargo_id_cargo_seq TO supervisor;
GRANT ALL ON SEQUENCE pdv.funcionario_id_funcionario_seq TO supervisor;
GRANT ALL ON SEQUENCE pdv.forma_pagamento_id_forma_pagamento_seq TO supervisor;
GRANT ALL ON SEQUENCE pdv.movimento_caixa_id_movimento_caixa_seq TO supervisor;
GRANT ALL ON SEQUENCE pdv.produto_id_produto_seq TO supervisor;
GRANT ALL ON SEQUENCE pdv.terminal_id_terminal_seq TO supervisor;
GRANT ALL ON SEQUENCE pdv.unidade_medida_id_unidade_medida_seq TO supervisor;
GRANT ALL ON SEQUENCE pdv.venda_id_venda_seq TO supervisor;
GRANT ALL ON SEQUENCE pdv.venda_forma_pagamento_id_venda_forma_pagamento_seq TO supervisor;
GRANT ALL ON SEQUENCE pdv.venda_produto_id_venda_produto_seq TO supervisor;

ALTER TABLE pdv.venda_produto ADD COLUMN desconto NUMERIC(6,2) DEFAULT '0.00';
