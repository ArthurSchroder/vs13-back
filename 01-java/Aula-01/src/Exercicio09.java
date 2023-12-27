import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a hora de início do jogo:");
        int startH = scanner.nextInt();
        System.out.println("Informe o minuto de início do jogo:");
        int startM = scanner.nextInt();

        System.out.println("Informe a hora de término do jogo:");
        int endH = scanner.nextInt();
        System.out.println("Informe o minuto de término do jogo:");

        int endM = scanner.nextInt();

        int durH = endH - startH;
        int durM = endM - startM;

        if (durM < 0) {
            durM += 60;
            durH--;
        }
        if (durH < 0) {
            durH += 24;
        }

        System.out.println("A duração do jogo é de " + durH + " horas e " + durM + " minutos.");
    }
}
