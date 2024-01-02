import entities.Cliente;
import entities.ContaCorrente;
import entities.Contato;
import entities.Endereco;

public class Main {
    public static void main(String[] args) {


        Contato contato = new Contato();
        contato.descricao = "Contato 01";
        contato.tipo = 1;
        contato.telefone = "61994656223";
        Contato contata = new Contato();
        contata.descricao = "Contato 02";
        contata.tipo = 2;
        contata.telefone = "6135688954";

        Cliente maria = new Cliente();
        maria.nome = "Maria das Dores";
        maria.cpf = "22266699965";
        maria.contatos = new Contato[]{contato, contata};
        Cliente joao = new Cliente();
        joao.nome = "João dos Santos";
        joao.cpf = "11122233356";



        Endereco endereco1 = new Endereco();
        endereco1.pais = "Brasil";
        endereco1.estado = "DF";
        endereco1.cidade = "Brasília";
        endereco1.cep = "71005-098";
        endereco1.complemento = "vazio";
        endereco1.tipo = 1;
        endereco1.logradouro = "Casa";
        Endereco endereco2 = new Endereco();
        endereco2.pais = "Brasil";
        endereco2.estado = "BA";
        endereco2.cidade = "Salvador";
        endereco2.cep = "72345-067";
        endereco2.complemento = "vazio";
        endereco2.tipo = 2;
        endereco2.logradouro = "Prédio";

        joao.enderecos = new Endereco[]{endereco1, endereco2};


        joao.imprimirEnderecos();
        maria.imprimirContatos();

        ContaCorrente contaCorrente1 = new ContaCorrente();
        ContaCorrente contaCorrente2 = new ContaCorrente();

        contaCorrente1.cliente = maria;
        contaCorrente1.numeroConta= "123456-7";
        contaCorrente1.agencia = 1234;
        contaCorrente2.cliente = joao;
        contaCorrente2.numeroConta= "765432-1";
        contaCorrente2.agencia = 4321;



        contaCorrente2.depositar(300);

        contaCorrente2.transeferir(contaCorrente1, 200);

        contaCorrente2.imprimirContaCorrente();
        contaCorrente1.imprimirContaCorrente();
    }
}