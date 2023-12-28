import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {

        System.out.println("""
        ================================
        ----PAPELARIA PREÇO EM FOLHA----
        ================================
        """);

        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite o nome do produto: ");
        String produto = scanner.next();
        System.out.println("Digite o valor do produto: ");
        float valor = scanner.nextFloat();

        System.out.println("Produto.: " + produto + "\nPreço R$.: " + valor + "\nPromoção: " + produto + "\n------------");

        for (int quantidade = 1; quantidade <= 10; quantidade++) {
            float desconto = valor * (quantidade * 0.05f);
            float valorComDesconto = valor - desconto;
            float valorFinal = valorComDesconto * quantidade;

            System.out.printf("%d x R$ %.2f = R$ %.2f\n", quantidade, valorComDesconto, valorFinal);
        }   

    }
}