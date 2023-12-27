import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        System.out.println("Escolha entre um desses estados: \n 1-Rio de Janeiro \n 2- São Paulo \n 3- Bahia");
        Scanner scanner = new Scanner(System.in);
        int state = scanner.nextInt();
        if (state == 1){
            System.out.println("Escolha uma cidade: \n 1- Rio de Janeiro \n 2- Valença");
            int city = scanner.nextInt();
            if (city == 1){
                System.out.println("Rio de Janeiro");
            }else{
                System.out.println("Valença");
            }

        }else if (state == 2){
            System.out.println("Escolha uma cidade: \n 1- Sâo Paulo \n 2- Santos");
            int city = scanner.nextInt();
            if (city == 1){
                System.out.println("Rio de Janeiro");
            }else{
                System.out.println("Valença");
            }
        }else if (state == 3){
            System.out.println("Escolha uma cidade: \n 1- Salvador \n 2- Ilhéus");
            int city = scanner.nextInt();
            if (city == 1){
                System.out.println("Rio de Janeiro");
            }else{
                System.out.println("Valença");
            }
        }else{
            System.out.println("Estado não identificado");
        }
    }
}
