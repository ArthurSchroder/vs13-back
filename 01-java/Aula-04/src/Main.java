import entities.Cliente;
import entities.ContaCorrente;
import entities.Contato;

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