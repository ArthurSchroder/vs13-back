import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {

        int vetor[] = {1, 4, 3, 4, 5, 9, 7, 11, 9, 10};
        int iguais = 0, menores=0, maiores=0;

        System.out.println("Vamos tentar adivinhar os números de uma lista secreta? ");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, digite um número: ");
        int numero = scanner.nextInt();
        for (int analise : vetor){
            if (analise == numero){
                iguais++;
            }else if (analise < numero){
                menores++;
            }else{
                maiores++;
            }
        }
        System.out.println("Quantidade de vezes que o número digitado ocorre: " + iguais);
        System.out.println("Quantidade de números menores que o número digitado: " + menores);
        System.out.println("Quantidade de números maiores que o número digitado: " + maiores);
    }
}
