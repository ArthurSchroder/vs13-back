import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        System.out.println("Seja bem vindo ao Translator2000! \n Para começarmos, por favor, digite a palavra que deseja traduzir. ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        switch (word){
            case "Tempo":
                System.out.println("Time");
                break;
            case "Time":
                System.out.println("Tempo");
                break;
            case "Cachorro":
                System.out.println("Dog");
                break;
            case "Dog":
                System.out.println("Cachorro");
                break;
            case "Amor":
                System.out.println("Love");
                break;
            case "Love":
                System.out.println("Amor");
                break;
            case "City":
                System.out.println("Cidade");
                break;
            case "Cidade":
                System.out.println("City");
                break;
            case "Feliz":
                System.out.println("Happy");
                break;
            case "Happy":
                System.out.println("Feliz");
                break;
            case "Sad":
                System.out.println("Triste");
                break;
            case "Triste":
                System.out.println("Sad");
                break;
            case "Deveria":
                System.out.println("Should");
                break;
            case "Should":
                System.out.println("Deveria");
                break;
            case "Could":
                System.out.println("Poderia");
                break;
            case "Poderia":
                System.out.println("Could");
                break;
            default:
                System.out.println("Essa palavra não é válida");
        }
    }
}
