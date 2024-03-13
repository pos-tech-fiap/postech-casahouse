package br.com.fiap.postechcasahouse.entity.gestaoQuartos;

public enum Descricao {
    SOFA("1 x Sofá"),
    POLTRONAS("2 x Poltronas"),
    FRIGOBAR("1 x Frigobar"),
    TV("1 x TV LED 62 pols."),
    MESA_ESCRITORIO("1 x Mesa de Escritório"),
    CADEIRA_ESCRITORIO("1 x Cadeira de Escritório"),

    BANHEIRO_PREMIUM("Banheiro Premium (Box com Ducha, Privada, Ducha higiênica, pia dupla com espelho e Sauna)"),
    BANHEIRO_LUXO("Banheiro de Luxo (Box com Ducha, Privada, Ducha higiênica e pia dupla com espelho)"),
    BANHEIRO_SIMPLES("Banheiro Simples (Box com Ducha, Privada, Ducha higiênica e pia com espelho)"),
    CAMA_CASAL("1 x Cama de Casal"),
    CAMA_SOLTEIRO("1 x Cama de Solteiro"),
    ARMARIO("1 x Armário"),
    TELEFONE("1 x Telefone"),
    AR_CONDICIONADO("1 x Ar-condicionado"),
    AQUECEDOR("1 x Aquecedor"),
    VENTILADOR("1 x Ventilador"),
    MINIBAR("1 x Minibar"),
    COFRE("1 x Cofre"),
    SECADOR_CABELO("1 x Secador de Cabelo"),
    BANHEIRA("1 x Banheira"),
    CHUVEIRO("1 x Chuveiro"),
    BIDETE("1 x Bidê"),
    TOALHAS("Toalhas"),
    ROUPAO("1 x Roupão"),
    CHINELO("1 x Chinelo"),
    ESPELHO("1 x Espelho"),
    SHAMPOO("1 x Shampoo"),
    CONDICIONADOR("1 x Condicionador"),
    GEL_DE_BANHO("1 x Gel de Banho"),
    LOCAO_HIDRATANTE("1 x Loção Hidratante"),
    ESCOVA_DE_DENTES("1 x Escova de Dentes"),
    PASTA_DE_DENTES("1 x Pasta de Dentes"),
    TOALHAS_DE_BANHO("Toalhas de Banho"),
    TOALHAS_DE_ROSTO("Toalhas de Rosto"),
    TOALHAS_DE_LAVABO("Toalhas de Lavabo"),
    TOALHAS_DE_PISO("Toalhas de Piso"),
    LENÇO_DE_BANHO("1 x Lenço de Banho"),
    TOUCAS("Toucas"),
    CHUVEIRINHO("1 x Chuveirinho"),
    KIT_COSTURA("1 x Kit Costura"),
    KIT_HIGIENE("1 x Kit Higiene"),
    CAIXA_DE_TECIDOS("1 x Caixa de Tecidos"),
    SABONETES("Sabonetes"),
    ESCOVA_DE_CABELO("1 x Escova de Cabelo"),
    PENTE("1 x Pente"),
    ESPELHO_DE_AUMENTO("1 x Espelho de Aumento"),
    BANDEJA("1 x Bandeja"),
    KIT_DE_BEM_VINDO("1 x Kit de Bem-vindo"),
    BANDEJA_DE_CAFE_DA_MANHA("1 x Bandeja de Café da Manhã"),
    RODO_DE_LIMPEZA("1 x Rodo de Limpeza"),
    BALDE("1 x Balde"),
    VASSOURA("1 x Vassoura"),
    ASPIRADOR_DE_PO("1 x Aspirador de Pó"),
    PANO_DE_LIMPEZA("1 x Pano de Limpeza"),
    SACO_DE_LIXO("1 x Saco de Lixo"),
    DESINFETANTE("1 x Desinfetante"),
    SABAO_EM_PO("1 x Sabão em Pó"),
    AMACIANTE_DE_ROUPA("1 x Amaciante de Roupa"),
    LAVA_ROUPA("1 x Lava-roupa"),
    SABAO_LIQUIDO("1 x Sabão Líquido"),
    KIT_DE_LIMPEZA("1 x Kit de Limpeza"),
    ESCOVA_DE_LAVAR_ROUPA("1 x Escova de Lavar Roupa"),
    CESTO_DE_ROUPA_SUJA("1 x Cesto de Roupa Suja"),
    VARAL_DE_ROUPAS("1 x Varal de Roupas"),
    FERRO_DE_PASSAR("1 x Ferro de Passar"),
    TAPETE("1 x Tapete"),
    LUMINARIA("1 x Luminária"),
    CORTINA("1 x Cortina"),
    RADIO("1 x Rádio");

    private final String descricao;

    Descricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
