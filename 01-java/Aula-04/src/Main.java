import entities.Cliente;
import entities.ContaCorrente;
import entities.Contato;

public class Main {
    public static void main(String[] args) {


        Contato contato = new Contato();
        contato.setDescricao("Contato 01");
        contato.setTipo(1);
        contato.setTelefone("61994656223");
        Contato contata = new Contato();
        contata.setDescricao("Contato 02");
        contata.setTipo(2);
        contata.setTelefone("6135688954");

        Cliente maria = new Cliente();
        maria.setNome("Maria das Dores");
        maria.setCpf("22266699965");
        maria.setContatos(new Contato[]{contato, contata});
        Cliente joao = new Cliente();

        maria.imprimirContatos();


        ContaCorrente contaCorrente1 = new ContaCorrente();
        ContaCorrente contaCorrente2 = new ContaCorrente();

        contaCorrente1.transferir(contaCorrente2, 300);



        contaCorrente1.setCliente(maria);
        contaCorrente1.setNumeroConta("123456-7");
        contaCorrente1.setAgencia(1234);
        contaCorrente2.setCliente(joao);
        contaCorrente2.setNumeroConta("765432-1");
        contaCorrente2.setAgencia(4321);



        contaCorrente2.imprimir();
        System.out.println("\n-------------------------------");
        contaCorrente1.imprimir();
    }
}