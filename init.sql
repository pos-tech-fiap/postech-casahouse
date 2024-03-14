-- Criar database
-- CREATE DATABASE casahouse;

-- Conectar ao database
\c casahouse;

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

CREATE TABLE tb_localidade (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    amenidades TEXT[],
    rua VARCHAR(255),
    cep VARCHAR(10),
    cidade VARCHAR(255),
    estado VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS tb_tipo_quarto (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    rua INT,
    tot_camas INT,
    tot_pessoas INT,
    tot_banheiros INT,
    valor_diaria DECIMAL(10, 2),
    descricao TEXT[]
);

CREATE TABLE IF NOT EXISTS tb_predio (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    localidade_id UUID,
    FOREIGN KEY (localidade_id) REFERENCES tb_localidade(id)
);

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

--CONSTRAINT fk_quarto FOREIGN KEY (quartos) REFERENCES tb_quarto(id)
--INSERT INTO tb_localidade (id, nome, amenidades, rua, cep, cidade, estado)
--VALUES
--    ('21f3dc7c-3b24-4c97-9314-7e61a2bc8944', 'Localidade 1', '{"PISCINA_ADULTO_AQUECIDA_COBERTA", "RESTAURANTE_A_LA_CARTE"}', 'Rua A', '12345-678', 'Cidade A', 'Estado A'),
--    ('b9fc9628-5d5d-4e17-81e5-08f36bc474b1', 'Localidade 2', '{"AREA_KIDS_BRINQUEDOTECA", "SALA_DE_JOGOS"}', 'Rua B', '54321-876', 'Cidade B', 'Estado B');
--
--
--
--INSERT INTO tb_predio (id, nome, localidade_id) VALUES
--('f47ac10b58cc4372a5670e02b2c3d479', 'Prédio A', '21f3dc7c-3b24-4c97-9314-7e61a2bc8944'),
--('4f6b9a909e654aa9a88c3a68a37375a2', 'Prédio B', '21f3dc7c-3b24-4c97-9314-7e61a2bc8944'),
--('4f6b9a909e654aa9a88c3a68a37375a2', 'Prédio C', 'b9fc9628-5d5d-4e17-81e5-08f36bc474b1');
--
--
--
--INSERT INTO tb_quarto (nome, predio_id, tipo_quarto_id) VALUES
--('8l6b9a909e654aa9a88c3a68a37375a3','Quarto 101', 'f47ac10b58cc4372a5670e02b2c3d479', 'f47ac10b58cc4372a5670e02b2c3d480'),
--('5g6b9a909e654aa9a88c3a68a37375a3', '4f6b9a909e654aa9a88c3a68a37375a2', '4f6b9a909e654aa9a88c3a68a37375a3'),
--('9l6b9a909e654aa9a88c3a68a37375a3', '7e3a3a3975194c349b1e3187a6fbb8e9', '7e3a3a3975194c349b1e3187a6fbb8e8');
--
--
--
--INSERT INTO tb_tipo_quarto (nome, rua, tot_camas, tot_pessoas, tot_banheiros, valor_diaria, descricao) VALUES
--('8a6b9a909e654aa9a88c3a68a37375a3','Quarto Simples', 1, 1, 1, 1, 100.00, 'SIMPLES'),
--('7q6b9a909e654aa9a88c3a68a37375a3','Quarto Padrão', 2, 2, 2, 1, 150.00, 'PADRAO'),
--('6s6b9a909e654aa9a88c3a68a37375a3','Quarto de Luxo', 3, 3, 3, 2, 250.00, 'LUXO'),
--('2r6b9a909e654aa9a88c3a68a37375a3','Suíte Familiar', 4, 4, 4, 2, 300.00, 'LUXO'),
--('1j6b9a909e654aa9a88c3a68a37375a3','Suíte Presidencial', 5, 5, 6, 3, 500.00, 'LUXO');
