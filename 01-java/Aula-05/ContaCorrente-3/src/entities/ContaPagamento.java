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

    @Override
    public boolean sacar(double saque) {
        if (saque > 0 && this.getSaldo() >= saque) {
            setSaldo(getSaldo() - (saque + ContaPagamento.TAXA_SAQUE));
            System.out.println("Saque realizado com sucesso!");
            return true;
        } else {
            System.out.println("Por favor, digite um valor válido para continuar");
            return false;

        }
    }
}
