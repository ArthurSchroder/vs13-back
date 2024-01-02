package entities;

public class Conta implements Movimentacao{
    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;

    public Cliente getCliente () {
        return cliente;
    }

    public void setCliente (Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta () {
        return numeroConta;
    }

    public void setNumeroConta (String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia () {
        return agencia;
    }

    public void setAgencia (int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo () {
        return saldo;
    }

    public void setSaldo (double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(double saque) {
        if (saque > 0 && this.saldo>= saque){
            System.out.println("Saque pode ser realizado!");
            return true;
        }else{
            System.out.println("Por favor, digite um valor válido para continuar");
            return false;

        }
    }

    @Override
    public boolean depositar(double deposito) {
        return false;
    }

    @Override
    public boolean transferir(String numConta, double valor) {
        return false;
    }
}
