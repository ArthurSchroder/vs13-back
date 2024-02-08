package br.com.dbc.vemser.pessoaapi.entity;

public enum TipoPet {

    CACHORRO(1),
    GATO(2),
    GUAXINIM(3);

    private Integer tipo;

    TipoPet(Integer id){
        this.tipo=id;
    }

    public Integer getTipo(){
        return tipo;
    }
}
