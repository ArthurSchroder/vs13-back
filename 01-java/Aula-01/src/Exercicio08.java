import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o salário do funcionário: ");
        float sal = scanner.nextFloat();
        System.out.println("Digite o código do cargo do funcionário: ");
        int cargo = scanner.nextInt();
        if (cargo == 101){
            System.out.println("Cargo gerente. \n Salário atual: " + sal + " reais"+ "\n Salário atualizado: " +(sal * 1.1)+ " reais");
        } else if (cargo == 102) {
            System.out.println("Cargo engenheiro. \n Salário atual: " + sal + " reais"+ "\n Salário atualizado: " +(sal * 1.2)+ " reais");

        } else if (cargo == 103) {
            System.out.println("Cargo tecnico. \n Salário atual: " + sal + " reais"+ "\n Salário atualizado: " +(sal * 1.3)+ " reais");

        }else{
            System.out.println("\n Salário atual: " + sal + " reais"+ "\n Salário atualizado: " +(sal * 1.4) + " reais");

        }

    }
}
