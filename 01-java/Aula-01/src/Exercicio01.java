import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o seu nome: ");
        String name = scanner.nextLine();
        System.out.print("Digite sua idade: ");
        int age = scanner.nextInt();
        System.out.print("Cidade: ");
        String city = scanner.next();
        System.out.print("Estado: ");
        String state = scanner.next();
        System.out.println("Olá! Seu nome é " + name + ", você tem " + age + " anos, é da cidade de " + city + " no estado de " + state);

    }
}