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
        if (saque > 0 && getSaldo()>= saque){
            System.out.println("O saque pode ser realizado");
            return true;
        }else{
            System.out.println("O saque não pode ser realizado");
            return false;
        }
    }

    public double getChequeEspecial(){
        return chequeEspecial;
    }



    @Override
    public void imprimir() {
        System.out.println("Cliente: " + getCliente().getNome() + "\nAgência:" + getAgencia() + "\nNúmero da Conta: "+ getNumeroConta() + "\nSaldo: " + getSaldo() + " reais" + "\n----------------------------------------------------");
    }
}

