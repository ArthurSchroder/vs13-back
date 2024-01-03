import entities.Cliente;
import entities.ContaCorrente;
import entities.ContaPagamento;
import entities.ContaPoupanca;

public class MetodoMainClientes {
    public static void main(String[] args) {
        Cliente clovis = new Cliente ();
        Cliente cornelia = new Cliente();

        ContaPoupanca contaPoupanca = new ContaPoupanca(cornelia);
        ContaPagamento contaPagamento = new ContaPagamento(clovis);
        ContaCorrente contaCorrente = new ContaCorrente(clovis);

        contaPagamento.depositar(500);
        contaPagamento.imprimir();
        contaPagamento.transferir(contaPoupanca, 300);
        System.out.println("_____________________________");
        contaPoupanca.imprimirSaldo();
        contaPoupanca.transferir(contaCorrente,150);
        System.out.println("-----------------------------");
        contaCorrente.imprimirSaldo();
        contaCorrente.sacar(50);
        System.out.println("-----------------------------");
        contaCorrente.imprimirSaldo();
    }
}
