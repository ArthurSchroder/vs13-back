package br.com.dbc.vemser.pessoaapi.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RelatorioPersonalizado {

    private EntityManager entityManager;

    public RelatorioPersonalizado(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Pessoa> gerarRelatorioPersonalizado() {
        String dados = "SELECT p.id, p.nome, p.email, c.numero, e.cep, e.cidade, e.estado, e.pais, pet.nome " +
                "FROM PESSOA p " +
                "JOIN p.CONTATO c " +
                "JOIN p.ENDERECO_PESSOA e " +
                "LEFT JOIN p.PET pet";;

        Query dadosPessoais = entityManager.createQuery(dados);

        return dadosPessoais.getResultList();
    }
}
