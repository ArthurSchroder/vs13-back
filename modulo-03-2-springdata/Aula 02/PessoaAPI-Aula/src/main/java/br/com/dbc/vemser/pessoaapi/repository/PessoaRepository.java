package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import org.apache.catalina.LifecycleState;
import org.bouncycastle.asn1.dvcs.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    public List<Pessoa> findAllByNomeContainingIgnoreCase(String nome);
    
    public List<Pessoa> findAllByCpfContainingIgnoreCase(String cpf);

    public List<Pessoa> findAllByDataNascimentoIsBetween(LocalDate data, LocalDate dataDois);
}
