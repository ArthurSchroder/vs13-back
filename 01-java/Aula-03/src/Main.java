import entities.Cliente;
import entities.ContaCorrente;

public class Main {
    public static void main(String[] args) {
        Cliente maria = new Cliente();
        maria.nome = "Maria das Dores";
        maria.cpf = "22266699965";
        Cliente joao = new Cliente();



        ContaCorrente contaCorrente1 = new ContaCorrente();
        ContaCorrente contaCorrente2 = new ContaCorrente();

        contaCorrente1.cliente = maria;
        contaCorrente2.cliente = joao;

        contaCorrente2.depositar(300);

        contaCorrente2.transeferir(contaCorrente1, 200);

        contaCorrente2.imprimirContaCorrente();
        contaCorrente1.imprimirContaCorrente();
    }
}