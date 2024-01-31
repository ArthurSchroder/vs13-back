package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Validated
@Data
@Email
@Entity(name = "PESSOA")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa2")
    @SequenceGenerator(name = "seq_pessoa2", sequenceName = "seq_pessoa2", allocationSize = 1)
    private Integer idPessoa;
    @Schema(description = "Nome da Pessoa", required = true, example = "Rafael Lazzari")
    @NotBlank(message = "O nome não pode ser vazio")
    @Pattern(regexp = "^[a-zA-Z ]*$")
    @Column(name = "nome")
    private String nome;
    @Past
    @Schema(description = "Data de nascimento da pessoa", required = true, example = "1999-02-26")
    @NotNull(message = "A data não pode ser vazia")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @NotBlank(message = "O CPF não pode ser vazio")
    @Size(min = 11, max = 11)
    @Schema(description = "CPF da pessoa", required = true, example = "06624789558")
    @Pattern(regexp = "\\d+")
    @Column(name = "cpf")
    private String cpf;
    @NotBlank
    @Schema(description = "Email da pessoa", required = true, example = "teste123@dbccompany.com.br")
    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Pessoa_X_Pessoa_Endereco",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
    private Set<Endereco> enderecos;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contato> contatos;
}
