import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        System.out.println("Digite o código do produto: ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.next();
        System.out.println("Digite a quantidade: ");
        int qnt = scanner.nextInt();
        if ("ABCD".equals(code)) {
            System.out.println("O valor devido é " + (qnt * 5.3f) + " reais");
        }else if ("XYPK".equals(code)){
            System.out.println("O valor devido é " + (qnt * 6f) + " reais");
        }else if ("KLMP".equals(code)){
            System.out.println("O valor devido é " + (qnt * 3.2f) + " reais");
        } else if ("QRST".equals(code)) {
            System.out.println("O valor devido é " + (qnt * 2.5f) + " reais");
        }else{
            System.out.println("Código Inválido");
        }
    }
}
