package entities;

public class ContaPoupanca extends Conta implements Impressao{
    private static double JUROS_MENSAL = 1.01;

    public void creditarTaxa(){

    }

    @Override
    public void imprimir() {
        setSaldo(getSaldo() * JUROS_MENSAL);
    }
}
