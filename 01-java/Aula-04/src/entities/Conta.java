package entities;

public class Conta {
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
}
