import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guess;
        System.out.println("""
                ********************************************************************
                Seja bem vindo(a) ao Aposta Ganha!!!
                Todos os dias, um número é sorteado e o primeiro usuário a acertar
                esse número é o grande ganhador do prêmio de R$ 100.000,00 em barras
                de ouro, que valem mais que dinheiro!!!
                *********************************************************************
                
                Vamos começar?
                _____________________________________________________________________
                """);
        System.out.println("Tente acertar o número da sorte: ");
        do {
            guess = scanner.nextInt();
            if (guess > 16){
                System.out.println("Infelizmente, não foi dessa vez que você conseguiu.\nTente um número menor!");
            }else if (guess < 16){
                System.out.println("Infelizmente, não foi dessa vez que você conseguiu.\nTente um número maior");
            }else{
                System.out.println("VOCÊ É O GRANDE VENCEDOR DO PRÊMIO DE R$ 100.000,00 EM BARRAS DE OURO, QUE VALEM MAIS DO QUE DINHEIRO!!!");
            }

        }while (guess != 16);

    }
}
