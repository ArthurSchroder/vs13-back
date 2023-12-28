import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de identificação do aluno: ");
        int id = scanner.nextInt();
        System.out.println("Digite a nota do primeiro exercício do aluno: ");
        float ex01 = scanner.nextFloat();
        System.out.println("Digite a nota do segundo exercício do aluno: ");
        float ex02 = scanner.nextFloat();
        System.out.println("Digite a nota do terceiro exercício do aluno: ");
        float ex03 = scanner.nextFloat();
        System.out.println("Digite a média de notas de exercícios do aluno: ");
        float me = scanner.nextFloat();

        float ma = (ex01 + (ex02 * 2) + (ex03 * 3) + me)/7;
        String conceito;
        String result;
        if(ma > 9f){
            conceito = "A";
            result = " 12Aprovado";
        }else if(ma > 7.5f){
            conceito = "B";
            result = " Aprovado";
        }else if(ma > 6f){
            conceito = "C";
            result = " Aprovado";
        }else if(ma > 4f){
            conceito = "D";
            result = " Reprovado";
        }else{
            conceito = "E";
            result = " Reprovado";
        }

        System.out.println("Identificação do Aluno: " + id);
        System.out.println("Nota 01: " + ex01 + "\nNota 02: " + ex02 +"\nNota 03: " + ex03 +
                "\nMédia dos exercícios: " + me + "\nMédia de aproveitamento: " + ma + "\nConceito: " + conceito
        +"-"+ result);
    }
}
