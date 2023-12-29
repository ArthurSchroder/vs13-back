package entities;

import java.util.Arrays;

public class Cliente {

    public String nome;
    public String cpf;
    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos  = new Endereco[2];


    public void imprimirContatos(){
        for (Contato contato : contatos){
            contato.imprimirContato();
        }
    }

    public void imprimirEnderecos(){
        for (Endereco endereco : enderecos){
            endereco.imprimirEndereco();
        }

    }
    public void imprimirClientes (){
        System.out.println("Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' + '}');
    }

}
