package entities;

public class ContaPoupanca extends Conta implements Impressao{
    private static double JUROS_MENSAL = 1.01;

    public void creditarTaxa(){
        setSaldo(getSaldo() * JUROS_MENSAL);
    }


    public ContaPoupanca(Cliente cliente) {
    }

    public void imprimirSaldo(){
        System.out.println("Saldo: " + this.getSaldo());
    }
    @Override
    public void imprimir() {
        System.out.printf("Cliente: " + getCliente() + "\nAgência:" + getAgencia() + "\nNúmero da Conta: "+ getNumeroConta() + "\nSaldo: " + getSaldo());
    }
}
