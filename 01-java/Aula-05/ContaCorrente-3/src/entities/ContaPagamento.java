package entities;

public class ContaPagamento extends Conta implements Impressao{
    public static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente) {
    }

    public void imprimirSaldo(){
        System.out.println("Saldo: " + this.getSaldo());
    }
    @Override
    public void imprimir() {
        System.out.println("Cliente: " + this.getCliente() + "\nAgência:" + getAgencia() + "\nNúmero da Conta: "+ getNumeroConta() + "\nSaldo: " + getSaldo() + " reais" + "\n----------------------------------------------------");

    }
}
