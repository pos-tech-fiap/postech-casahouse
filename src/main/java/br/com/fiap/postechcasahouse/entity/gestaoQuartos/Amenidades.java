package br.com.fiap.postechcasahouse.entity.gestaoQuartos;

public enum Amenidades {
    PISCINA_ADULTO_AQUECIDA_COBERTA("Piscina Adulto aquecida e coberta"),
    PISCINA_ADULTO_NAO_AQUECIDA_ABERTA("Piscina Adulto não aquecida em área aberta"),
    PISCINA_INFANTIL_AQUECIDA_COBERTA("Piscina Infantil aquecida e coberta"),
    PISCINA_INFANTIL_NAO_AQUECIDA_ABERTA("Piscina Infantil não aquecida em área aberta"),
    RESTAURANTE_SELF_SERVICE_1("Restaurante no estilo Self Service"),
    RESTAURANTE_SELF_SERVICE_2("Restaurante no estilo Self Service"),
    RESTAURANTE_A_LA_CARTE("Restaurante a La Carte"),
    AREA_KIDS_BRINQUEDOTECA("Área Kids com brinquedoteca"),
    AREA_KIDS_VIDEOGAMES("Área Kids com vídeo games"),
    AREA_KIDS_BIBLIOTECA("Área Kids com biblioteca"),
    EQUIPE_ENTRETENIMENTO_INFANTIL("Equipe de Entretenimento Infantil (diversas idades)"),
    EQUIPE_ENTRETENIMENTO_ADULTO("Equipe de Entretenimento Adulto"),
    SPA("Spa"),
    ACADEMIA("Academia"),
    SALA_DE_CINEMA("Sala de Cinema"),
    SALA_DE_JOGOS("Sala de Jogos"),
    SALAO_DE_EVENTOS("Salão de Eventos"),
    MINI_CAMPO_DE_GOLFE("Mini campo de golfe"),
    QUADRAS_DE_ESPORTES("Quadras de Esportes"),
    SERVICO_DE_PRAIA("Serviço de Praia"),
    CENTRO_DE_NEGOCIOS("Centro de Negócios"),
    CONCIERGE_24_HORAS("Concierge 24 horas");

    private final String descricao;

    Amenidades(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}