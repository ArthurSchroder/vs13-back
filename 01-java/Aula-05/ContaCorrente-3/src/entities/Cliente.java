package entities;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String cpf;
    private ArrayList <Contato> contatos  = new ArrayList<>();
    private ArrayList <Endereco> enderecos  = new ArrayList<>();


    public void imprimirContatos(){
        for (Contato contato : contatos){
            contato.imprimirContato();
            System.out.println("\n-----------------------------");
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
