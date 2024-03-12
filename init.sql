-- Criar database
CREATE DATABASE IF NOT EXISTS casahouse;

-- Conectar ao database
\c casahouse;

-- Criar tabela de serviços
CREATE TABLE IF NOT EXISTS tb_service(
    id UUID primary key,
    nome VARCHAR(255) not null,
    valor double not null
);