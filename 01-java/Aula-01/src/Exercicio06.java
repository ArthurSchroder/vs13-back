import java.util.Scanner;
public class Exercicio06 {
    public static void main(String[] args) {
        System.out.println("Eleições 2024!");
        System.out.println("Digite o total de eleitores do Município");
        Scanner scanner = new Scanner(System.in);
        float totalEleitores = scanner.nextInt();
        System.out.println("Digite o total de votos brancos: ");
        float totalBrancos = scanner.nextInt();
        System.out.println("Digite o total de votos nulos: ");
        float totalNulos = scanner.nextInt();
        System.out.println("Digite o total de votos válidos: ");
        float totalValidos = scanner.nextInt();


        System.out.println("Percentual de votos Brancos: " + (totalBrancos / totalEleitores) * 100 + "%");
        System.out.println("Percentual de votos Nulos: " + (totalNulos / totalEleitores)  * 100 + "%");
        System.out.println("Percentual de votos Válidos: " + (totalValidos / totalEleitores) * 100 + "%");


    }
}
