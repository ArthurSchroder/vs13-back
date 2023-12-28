import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        String jogador= null, maisVelho = null, maisPesado= null;
        float altura= 0, maiorAltura= 0, peso= 0, maiorPeso= 0, somaAltura= 0, mediaAltura = 0f;
        int idade= 0, maiorIdade= 0, contador = 0;


        System.out.println("""
                ---------------------
                BANCO DE TALENTOS
                ---------------------
                """);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nDigite o nome do jogador: ");
            jogador = scanner.next();

            if(!jogador.toLowerCase().equals("sair")) {
                contador += 1;
                System.out.println("Digite a altura do jogador: ");
                altura = scanner.nextFloat();
                somaAltura += altura;
                if(altura > maiorAltura){
                    maiorAltura = altura;
                }
                System.out.println("Digite a idade do jogador: ");
                idade = scanner.nextInt();
                if(maiorIdade<idade){
                    maiorIdade = idade;
                    maisVelho = jogador;
                }
                System.out.println("Digite o peso do jogador: ");
                peso = scanner.nextFloat();
                if (peso > maiorPeso){
                    maiorPeso = peso;
                    maisPesado = jogador;
                }
                mediaAltura = somaAltura/contador;

                System.out.printf("Quantidade de Jogadores cadastrados: %d \nAltura do maior jogador: %.2f \nJogador mais velho: %s \nJogador mais pesado: %s Kgs \nMédia de altura dos jogadores: %.2f", contador, maiorAltura, maisVelho, maisPesado, mediaAltura);
            }else{
            }
            }while (!jogador.toLowerCase().equals("sair"));
        System.out.printf("Cadastros finalizados com sucesso. Até a próxima! \nForam cadastrados %d novos jogadores", contador);
    }
}
