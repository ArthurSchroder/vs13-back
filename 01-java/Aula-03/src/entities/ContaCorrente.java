package entities;

public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;


    public void imprimirContaCorrente(){
        System.out.println("cliente= " + cliente.nome +
                ", numero da Conta= '" + numeroConta + '\'' +
                ", agencia= " + agencia +
                ", saldo= " + saldo +
                ", chequeEspecial= " + chequeEspecial);
        System.out.println("-------------------------------");
    }
    public boolean sacar(double saque){
        if (saque <= retornarSaldoComChequeEspecial()){
            saldo = saldo - saque;
            return true;
        }else{
            return false;
        }
    }

    public boolean depositar (double deposito){
        if(deposito > 0) {
            saldo += deposito;
            return true;
        }else{
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial(){
        return saldo + chequeEspecial;
    }

    public boolean transeferir(ContaCorrente contaCorrente, double valor){
        if (retornarSaldoComChequeEspecial() >= valor){
            this.sacar(valor);
            contaCorrente.depositar(valor);
            return true;
        } else{
            return false;
        }
    }
}

