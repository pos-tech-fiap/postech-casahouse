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

CREATE TABLE tb_reserva (
    id SERIAL PRIMARY KEY,
    id_cliente INTEGER NOT NULL,
    data_entrada DATE NOT NULL,
    data_saida DATE NOT NULL,
    quartos TEXT[],
    servicos TEXT[],
    itens TEXT[],
    quantidade_pessoas INTEGER NOT NULL,
    valor_total NUMERIC(7, 2) NOT NULL
);

INSERT INTO tb_reserva (id_cliente, data_entrada, data_saida, quartos, servicos, itens, quantidade_pessoas, valor_total)
VALUES
    (50, '2024-04-01', '2024-04-02', '{"Quarto especial 1", "Double boy"}', '{"Spa", "Sauna"}', '{"TV LED", "Ar Condicionado"}', 2, 500.30),
    (100, '2024-05-20', '2024-05-22', '{"Quarto simples"}', '{"Camareira"}', '{"TV LED"}', 1, 150.00);


INSERT INTO tb_localidade (id, nome, amenidades, rua, cep, cidade, estado)
VALUES
    ('21f3dc7c-3b24-4c97-9314-7e61a2bc8944', 'Localidade 1', '{"PISCINA_ADULTO_AQUECIDA_COBERTA", "RESTAURANTE_A_LA_CARTE"}', 'Rua A', '12345-678', 'Cidade A', 'Estado A'),
    ('b9fc9628-5d5d-4e17-81e5-08f36bc474b1', 'Localidade 2', '{"AREA_KIDS_BRINQUEDOTECA", "SALA_DE_JOGOS"}', 'Rua B', '54321-876', 'Cidade B', 'Estado B');
