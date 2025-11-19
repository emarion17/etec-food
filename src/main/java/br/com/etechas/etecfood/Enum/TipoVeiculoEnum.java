package br.com.etechas.etecfood.Enum;

public enum TipoVeiculoEnum {
    MOTO,
    CARRO,
    BICICLETA,
    OUTRO

    private String descricao;
    TipoVeiculoEnum(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}
