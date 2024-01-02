package entities;

public class Contato {
    public String descricao;
    public String telefone;
    public int tipo;

    public void imprimirContato(){
        System.out.printf("Descrição: %s \nTelefone %s \nTipo de telefone: %d\n ------------------------------------------------\n", descricao, telefone, tipo);
    }
}
