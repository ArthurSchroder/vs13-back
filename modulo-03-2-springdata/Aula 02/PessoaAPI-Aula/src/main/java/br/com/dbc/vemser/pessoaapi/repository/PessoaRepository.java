package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    public List<Pessoa> findAllByNomeContainingIgnoreCase(String nome);
    
    public List<Pessoa> findAllByCpfContainingIgnoreCase(String cpf);

    public List<Pessoa> findAllByDataNascimentoIsBetween(LocalDate data, LocalDate dataDois);

    @Query("Select p FROM PESSOA p WHERE p.cpf = :cpf")
    Pessoa procurarPorCpf(@Param("cpf") String cpf);

    @Query(value = "select * from vem_ser.PESSOA p" +
        "   left join vem_ser.PESSOA_X_PESSOA_ENDERECO pxpe"+
        "           on p.id_pessoa = pxpe.id_pessoa"+
        "   where pxpe.id_pessoa is null", nativeQuery = true)
    List<Pessoa> procurarPessoasSemEndereco();

    @Query(value= "SELECT p FROM vem_ser.PESSOA p " +
            "LEFT JOIN vem_ser.PESSOA_X_PESSOA_ENDERECO pxpe "+
            "on p.id_pessoa = pxpe.id_pessoa "+
            "LEFT JOIN vem_ser.CONTATO c "+
            "on p.id_pessoa = c.id_pessoa "+
            "LEFT JOIN vem_ser.PET pt "+
            "on p.id_pessoa = pt.id_pessoa " +
            "WHERE p.id_pessoa = :idPessoa", nativeQuery = true )
    List<Pessoa> procurarPessoaPorIdCompleto(@Param("idPessoa")Integer idPessoa);

    @Query(value= "SELECT p FROM vem_ser.PESSOA p " +
            "LEFT JOIN vem_ser.PESSOA_X_PESSOA_ENDERECO pxpe "+
            "on p.id_pessoa = pxpe.id_pessoa "+
            "LEFT JOIN vem_ser.CONTATO c "+
            "on p.id_pessoa = c.id_pessoa "+
            "LEFT JOIN vem_ser.PET pt "+
            "on p.id_pessoa = pt.id_pessoa ", nativeQuery = true)
    List<Pessoa> procurarPessoaCompleto();

//    @Query("Select p FROM PESSOA p WHERE p.")

}
