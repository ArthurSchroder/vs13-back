package br.com.dbc.vemser.pessoaapi.controller.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Validated
public class ContatoDTO {

    @NotNull
    @NotEmpty
    private Integer idPessoa;
    @NotNull
    @NotEmpty
    private Integer tipoContato;
    @NotNull @Max(13)
    private String numero;
    @NotEmpty
    @NotNull
    private String descricao;

    public ContatoDTO( Integer idPessoa, Integer tipoContato, String numero, String descricao) {
        this.idPessoa = idPessoa;
        this.tipoContato = tipoContato;
        this.numero = numero;
        this.descricao = descricao;
    }


    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(Integer tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
