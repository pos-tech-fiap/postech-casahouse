-- Criar database
-- CREATE DATABASE casahouse;

-- Conectar ao database
\c casahouse;

CREATE TABLE tb_usuario (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(14),
    origem VARCHAR(255),
    passaporte VARCHAR(20),
    data_nascimento DATE,
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    email VARCHAR(255)
);

INSERT INTO tb_usuario (id, nome, cpf, origem, passaporte, data_nascimento, endereco, telefone, email) VALUES
    ('6b14cc27-9ea3-4671-b515-1352231830aa', 'João da Silva', '16077319082', 'Brasil', NULL, '1990-01-01', 'Rua A, 123', '(11) 1234-5678', 'postechcasahousefiap+joao@gmail.com');

CREATE TABLE tb_servico(
    id UUID primary key,
    nome VARCHAR(255) not null,
    valor double precision not null
);

INSERT INTO tb_servico (id, nome, valor)
VALUES
    ('21f3dc7c-3b24-4c97-9314-7e61a2bc8941', 'Café da Manhã', 65.00),
    ('b9fc9628-5d5d-4e17-81e5-08f36bc474b2', 'Almoço', 65.00),
    ('21f3dc7c-3b24-4c97-9314-7e61a2bc8943', 'Jantar', 85.00),
    ('b9fc9628-5d5d-4e17-81e5-08f36bc474b4', 'Massagem Completa', 250.00),
    ('b9fc9628-5d5d-4e17-81e5-08f36bc474b5', 'Manicure', 85.00);

CREATE TABLE tb_item(
   id UUID primary key,
   nome VARCHAR(255) not null,
   valor double precision not null
);

INSERT INTO tb_item (id, nome, valor)
VALUES
    ('21f3dc7c-3b24-4c97-9314-7e61a2bc8941', 'Refrigerante', 9.00),
    ('b9fc9628-5d5d-4e17-81e5-08f36bc474b2', 'Suco', 13.00),
    ('21f3dc7c-3b24-4c97-9314-7e61a2bc8943', 'Cerveja nacional', 15.00),
    ('b9fc9628-5d5d-4e17-81e5-08f36bc474b4', 'Cerveja importada', 250.00),
    ('b9fc9628-5d5d-4e17-81e5-08f36bc474b5', 'Caipirinha', 35.00);


CREATE TABLE tb_localidade (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    amenidades TEXT[],
    rua VARCHAR(255),
    cep VARCHAR(10),
    cidade VARCHAR(255),
    estado VARCHAR(255)
);

INSERT INTO tb_localidade (id, nome, amenidades, rua, cep, cidade, estado)
VALUES
    ('21f3dc7c-3b24-4c97-9314-7e61a2bc8944', 'Localidade 1', '{"PISCINA_ADULTO_AQUECIDA_COBERTA", "RESTAURANTE_A_LA_CARTE"}', 'Rua A', '12345-678', 'Cidade A', 'Estado A'),
    ('b9fc9628-5d5d-4e17-81e5-08f36bc474b1', 'Localidade 2', '{"AREA_KIDS_BRINQUEDOTECA", "SALA_DE_JOGOS"}', 'Rua B', '54321-876', 'Cidade B', 'Estado B');

CREATE TABLE IF NOT EXISTS tb_tipo_quarto (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    tot_camas INT,
    tot_pessoas INT,
    tot_banheiros INT,
    valor_diaria DECIMAL(10, 2),
    descricao TEXT[]
);

INSERT INTO tb_tipo_quarto (id, nome, tot_camas, tot_pessoas, tot_banheiros, valor_diaria, descricao) VALUES
   ('f47ac10b58cc4372a5670e02b2c3d480','Quarto Simples', 1, 1, 1, 100.00, '{SOFA, TV, BANHEIRO_SIMPLES, CAMA_SOLTEIRO}'),
   ('f47ac10b58cc4372a5670e02b2c3d481','Quarto Padrão', 2, 2, 2, 150.00, '{AR_CONDICIONADO, CAMA_CASAL}'),
   ('f47ac10b58cc4372a5670e02b2c3d482','Quarto de Luxo', 3, 3, 3, 250.00, '{CAMA_CASAL, CAMA_SOLTEIRO}'),
   ('f47ac10b58cc4372a5670e02b2c3d483','Suíte Familiar', 4, 4, 4, 300.00, '{CAMA_CASAL, CAMA_SOLTEIRO, CAMA_SOLTEIRO, CAMA_SOLTEIRO, BANHEIRA, TV, AR_CONDICIONADO}'),
   ('f47ac10b58cc4372a5670e02b2c3d484','Suíte Presidencial', 5, 5, 6, 500.00, '{CAMA_CASAL, CAMA_SOLTEIRO, CAMA_SOLTEIRO, CAMA_SOLTEIRO, TV, AR_CONDICIONADO}');

CREATE TABLE IF NOT EXISTS tb_predio (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    localidade_id UUID,
    FOREIGN KEY (localidade_id) REFERENCES tb_localidade(id)
);

INSERT INTO tb_predio (id, nome, localidade_id) VALUES
                                                    ('f47ac10b58cc4372a5670e02b2c3d479', 'Prédio A', '21f3dc7c-3b24-4c97-9314-7e61a2bc8944'),
                                                    ('4f6b9a909e654aa9a88c3a68a37375a2', 'Prédio B', '21f3dc7c-3b24-4c97-9314-7e61a2bc8944'),
                                                    ('4f6b9a909e654aa9a88c3a68a37375a3', 'Prédio C', 'b9fc9628-5d5d-4e17-81e5-08f36bc474b1');

CREATE TABLE IF NOT EXISTS tb_quarto (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    predio_id UUID,
    tipo_quarto_id UUID
);

INSERT INTO tb_quarto (id, nome, predio_id, tipo_quarto_id) VALUES
    ('627a32e3-7680-4854-8c25-6dd96b5db113','Quarto 101', 'f47ac10b58cc4372a5670e02b2c3d479', 'f47ac10b58cc4372a5670e02b2c3d480');

CREATE TABLE IF NOT EXISTS tb_reserva (
    id UUID PRIMARY KEY,
    id_cliente UUID NOT NULL,
    data_entrada DATE NOT NULL,
    data_saida DATE,
    quantidade_pessoas INTEGER NOT NULL,
    valor_total NUMERIC(7, 2),
    itens TEXT[]
);

INSERT INTO  tb_reserva (id, id_cliente, data_entrada, data_saida, quantidade_pessoas, valor_total) VALUES
    ('6c5a64da-9b6f-431d-b4aa-b2e633a5d633', '6b14cc27-9ea3-4671-b515-1352231830aa','2024-04-01', '2024-04-02', 2, 220.00);

CREATE TABLE IF NOT EXISTS tb_reserva_quarto(
    reserva_id UUID,
    quarto_id UUID,
    foreign key(reserva_id) references tb_reserva(id) on delete cascade,
    foreign key(quarto_id) references tb_quarto(id) on delete cascade
);

INSERT INTO tb_reserva_quarto (reserva_id, quarto_id) VALUES ('6c5a64da-9b6f-431d-b4aa-b2e633a5d633', '627a32e3-7680-4854-8c25-6dd96b5db113');

CREATE TABLE IF NOT EXISTS tb_reserva_servico(
    reserva_id UUID not null,
    servico_id UUID not null,
    primary key(reserva_id, servico_id),
    foreign key(reserva_id) references tb_reserva(id) on delete cascade,
    foreign key(servico_id) references tb_servico(id) on delete cascade
);

INSERT INTO tb_reserva_servico (reserva_id, servico_id) VALUES ('6c5a64da-9b6f-431d-b4aa-b2e633a5d633', '21f3dc7c-3b24-4c97-9314-7e61a2bc8941');

CREATE TABLE IF NOT EXISTS tb_reserva_item(
    reserva_id UUID,
    item_id UUID,
    foreign key(reserva_id) references tb_reserva(id) on delete cascade,
    foreign key(item_id) references tb_item(id) on delete cascade
);

INSERT INTO tb_reserva_item (reserva_id, item_id) VALUES ('6c5a64da-9b6f-431d-b4aa-b2e633a5d633', 'b9fc9628-5d5d-4e17-81e5-08f36bc474b4');
