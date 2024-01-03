package entities;

public class Contato {
    private String descricao;
    private String telefone;
    private int tipo;

    public void imprimirContato(){
        System.out.printf("Descrição: %s \nTelefone %s \nTipo de telefone: %d", descricao, telefone, tipo);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
