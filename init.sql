---- Create the wattwise database
--CREATE DATABASE casahouse;

-- Connect to the casahouse database
\c casahouse;

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
