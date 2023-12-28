import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        int[][] tabela = new int[5][4];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Informe a matrícula do "+ (i + 1) + "º aluno: ");
            tabela[i][0] = scanner.nextInt();

            System.out.println("Informe a média das provas do " + (i + 1) + "º aluno: ");
            tabela[i][1] = scanner.nextInt();

            System.out.println("Informe a média dos trabalhos do "+ (i + 1) + "º aluno: ");
            tabela[i][2] = scanner.nextInt();

            tabela[i][3] = (int) ((tabela[i][1] * 0.6) + (tabela[i][2] * 0.4));
        }

        int maiorNota = tabela[0][3];
        int matriculaMelhor = tabela[0][0];

        for (int i = 1; i < 5; i++) {
            if (tabela[i][3] > maiorNota) {
                maiorNota = tabela[i][3];
                matriculaMelhor = tabela[i][0];
            }
        }

        System.out.println("Matrícula com a maior nota final: " + matriculaMelhor);

        int somaNotasFinais = 0;
        for (int i = 0; i < 5; i++) {
            somaNotasFinais += tabela[i][3];
        }
        float mediaNotasFinais = (float) somaNotasFinais / 5;

        System.out.println("Média das notas finais: " + mediaNotasFinais);
    }
}
