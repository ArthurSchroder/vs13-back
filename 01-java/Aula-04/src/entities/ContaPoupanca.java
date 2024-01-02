package entities;

public class ContaPoupanca extends Conta implements Impressao{
    private static double JUROS_MENSAL = 1.01;

    public void creditarTaxa(){
        setSaldo(getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.printf("Cliente: " + getCliente() + "\nAgência:" + getAgencia() + "\nNúmero da Conta: "+ getNumeroConta() + "\nSaldo: " + getSaldo());
    }
}
