package entities;
public class ContaCorrente extends Conta implements Impressao{
    private double chequeEspecial;

    public double retornarSaldoComChequeEspecial(){
        this.setSaldo(this.getSaldo() + chequeEspecial);
        System.out.println("Saldo atual: " + this.getSaldo());
        double saldo = this.getSaldo();
        return saldo;
    }

    public void setChequeEspecial (double chequeEspecial){
        this.chequeEspecial = chequeEspecial;
    }

    public boolean sacar(double saque){

    }


    @Override
    public void imprimir() {

    }
}

