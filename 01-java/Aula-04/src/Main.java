import entities.Cliente;
import entities.ContaCorrente;
import entities.ContaPoupanca;
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
        maria.setNome("Maria das Dores");
        maria.setCpf("22266699965");
        maria.setContatos(new Contato[]{contato, contata});
        Cliente joao = new Cliente();
        joao.setNome("João dos Santos");
        maria.setCpf("333777999-00");
        joao.setContatos(new Contato[]{contato, contata});




        maria.imprimirContatos();


        ContaCorrente contaCorrente1 = new ContaCorrente();
        ContaCorrente contaCorrente2 = new ContaCorrente();
        ContaPoupanca contaPoupanca = new ContaPoupanca();



        contaCorrente1.transferir(contaCorrente2, 300);
        contaCorrente2.sacar(100);
        contaCorrente2.depositar(150);
        contaCorrente2.transferir(contaPoupanca, 90);
        contaPoupanca.creditarTaxa();





        contaCorrente1.setCliente(maria);
        contaCorrente1.setNumeroConta("123456-7");
        contaCorrente1.setAgencia(1234);
        contaCorrente2.setCliente(joao);
        contaCorrente2.setNumeroConta("765432-1");
        contaCorrente2.setAgencia(4321);



        contaCorrente2.imprimir();
        contaCorrente1.imprimir();
    }
}