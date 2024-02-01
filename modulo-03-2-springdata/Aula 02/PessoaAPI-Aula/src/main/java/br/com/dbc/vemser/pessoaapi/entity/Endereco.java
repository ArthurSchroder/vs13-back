package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import java.util.Set;

@Validated
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity (name = "ENDERECO_PESSOA")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco_contato")
    @SequenceGenerator(name = "seq_endereco_contato", sequenceName = "seq_endereco_contato", allocationSize = 1)
    private Integer idEndereco;

    @NotBlank(message = "O id da pessoa não pode ser vazio")
    @Schema(description = "Id do responsável pelo endereço", required = true, example = "3")
    @NotNull(message = "O id da pessoa não pode ser nulo")
    private Integer idPessoa;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Pessoa_X_Pessoa_Endereco",
            joinColumns = @JoinColumn(name = "ID_ENDERECO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PESSOA")
    )
    private Set<Pessoa> pessoas;

    @NotBlank(message = "O tipo de endereço não pode ser vazio")
    @Schema(description = "Tipo de endereço a ser cadastrado\n1-Residencial\n2-Comercial", required = true, example = "1")
    @NotNull
    @Column(name = "tipo")
    private TipoEndereco tipo;

    @NotBlank(message = "O logradouro não pode ser vazio")
    @Schema(description = "Logradouro do endereço", required = true, example = "Avenida y, Rua x")
    @NotNull
    @Column(name = "logradouro")
    private String logradouro;

    @NotBlank(message = "O número não pode ser vazio")
    @Schema(description = "Numero da residência", required = true, example = "31")
    @NotNull
    @Column(name = "numero")
    private Integer numero;

    @NotBlank(message = "Complemento não pode ser vazio")
    @Schema(description = "Complemento do endereço", required = true, example = "Bloco z, apto")
    @NotNull
    @Column(name = "complemento")
    private String complemento;

    @NotBlank(message = "CEP não pode ser vazio")
    @Pattern(regexp = "\\d+")
    @Size(max = 8, min = 8)
    @Schema(description = "CEP do endereço", required = true, example = "75065031")
    @NotNull
    @Column(name = "cep")
    private String cep;

    @NotBlank(message = "Cidade não pode ser vazia")
    @Schema(description = "Cidade onde se localiza o endereço", required = true, example = "Criciúma")
    @NotNull
    @Column(name = "cidade")
    private String cidade;

    @NotBlank(message = "Estado não pode ser vazio")
    @Schema(description = "Estado onde se localiza o endereço", required = true, example = "MG")
    @NotNull
    @Column(name = "estado")
    private String estado;

    @NotBlank(message = "País não pode ser vazio")
    @Schema(description = "País onde se localiza o endereço", required = true, example = "Brasil")
    @NotNull
    @Column(name = "pais")
    private String pais;
}
