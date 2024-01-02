package entities;

public class Endereco {
    public int tipo;
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;


    public void imprimirEndereco(){
        System.out.printf("Endereço:  \nTipo: %d \nLogradouro: %s \nNumero: %d \nComplemento:  %s \nCep:  %s \nCidade:  %s \nEstado:  %s \nPaís:  %s\n---------------------------------------\n", tipo, logradouro, numero, complemento, cep, cidade, estado, pais);
    }
}
