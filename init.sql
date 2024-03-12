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
    amenidades TEXT[], -- Array de texto para armazenar os valores das amenidades
    rua VARCHAR(255),
    cep VARCHAR(10),
    cidade VARCHAR(255),
    estado VARCHAR(255)
);

INSERT INTO tb_localidade (id, nome, amenidades, rua, cep, cidade, estado)
VALUES
    ('21f3dc7c-3b24-4c97-9314-7e61a2bc8944', 'Localidade 1', '{"PISCINA_ADULTO_AQUECIDA_COBERTA", "RESTAURANTE_A_LA_CARTE"}', 'Rua A', '12345-678', 'Cidade A', 'Estado A'),
    ('b9fc9628-5d5d-4e17-81e5-08f36bc474b1', 'Localidade 2', '{"AREA_KIDS_BRINQUEDOTECA", "SALA_DE_JOGOS"}', 'Rua B', '54321-876', 'Cidade B', 'Estado B');
