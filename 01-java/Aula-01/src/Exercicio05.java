import java.util.Scanner;
public class Exercicio05 {
    public static void main(String[] args) {
        System.out.println("Seja bem vindo à calculadora de àrea do retângulo! \n Para começarmos, por favor digite o tamanho da base, em centímetros: ");
        Scanner scanner = new Scanner(System.in);
        float base = scanner.nextFloat();
        System.out.println("Ótimo, agora preciso que você digite a altura, também em centímetros:");
        float alt = scanner.nextFloat();
        System.out.println(" A área do retângulo informado é " + base * alt + " cm²");


    }

}
