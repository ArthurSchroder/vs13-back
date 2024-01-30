package br.com.dbc.vemser.pessoaapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Validated
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "CONTATO")

public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contato")
    @SequenceGenerator(name = "seq_contato", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;
    @NotNull
    @NotBlank(message = "O nome da pessoa não pode estar vazio")
    @Schema(description = "Id do responsável pelo contato", required = true, example = "2")
    @Column(name = "id_pessoa")
    private Integer idPessoa;
    @NotNull
    @NotBlank(message = "O tipo de contato não pode ser vazio")
    @Schema (description = "1- Residencial   2- Comercial", required = true, example = "2")
    @Column(name = "tipo")
    private TipoContato tipoContato;
    @NotBlank(message = "O numero do contato não pode ser vazio")
    @Schema (description = "Numero do contato", required = true, example = "61999977584")
    @Column(name = "numero")
    private String numero;
    @NotBlank (message = "A descrição do contato não pode ser vazia")
    @Schema (description = "Descrição do contato", required = true, example = "WhatsApp")
    @Column(name = "descricao")
    private String descricao;


}
