package entities;

public interface Movimentacao {
    public boolean sacar(double saque);
    public boolean depositar (double deposito);
    public boolean transferir (String numConta, double valor);
}
