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
                System.out.println("Rio de Janeiro, com aproximadamente 6,748 milhões de habitantes, é muito conhecido por seu Carnaval, praias e monumentos");
            }else{
                System.out.println("Valença é um município brasileiro localizado no sul do estado do Rio de Janeiro. Está a uma altitude de 560 metros e em 2021 sua população foi estimada em 77 202 habitantes, segundo o IBGE");
            }

        }else if (state == 2){
            System.out.println("Escolha uma cidade: \n 1- Sâo Paulo \n 2- Santos");
            int city = scanner.nextInt();
            if (city == 1){
                System.out.println("São Paulo, centro financeiro do Brasil, está entre as cidades mais populosas do mundo, com diversas instituições culturais e uma rica tradição arquitetônica. Há prédios simbólicos como a catedral neogótica, o Edifício Martinelli, um arranha-céu inaugurado em 1929, e o Edifício Copan, com suas linhas curvas projetadas pelo arquiteto modernista Oscar Niemeyer.");
            }else{
                System.out.println("Localizada no litoral paulista e a 72 quilômetros da Capital, a cidade ostenta o 5º lugar no ranking de qualidade de vida dos municípios brasileiros, conforme Índice de Desenvolvimento Humano (IDH) aferido pela Organização das Nações Unidas (ONU) com base nos níveis de expectativa de vida, educação e PIB per capita.");
            }
        }else if (state == 3){
            System.out.println("Escolha uma cidade: \n 1- Salvador \n 2- Ilhéus");
            int city = scanner.nextInt();
            if (city == 1){
                System.out.println("Salvador é a capital e maior cidade da Bahia. O município foi fundado em 1549 como sendo a primeira capital do Brasil \n A cidade é uma das mais populosas e economicamente desenvolvidas do país, com destaque para o setor terciário da economia local, notadamente marcado pelo turismo. Conta também com uma boa oferta de infraestrutura de transportes e comunicações, mas possui uma elevada desigualdade de renda entre a sua população. ");
            }else{
                System.out.println("Ilhéus é um município brasileiro do litoral sul do estado da Bahia, Nordeste do Brasil. Conta com o mais extenso litoral do estado. Ilhéus foi fundada em 1534, como Vila de São Jorge dos ilheos e elevada à cidade em 188. \n Com 157 639 habitantes em 2021, segundo o IBGE, é o décimo município mais populoso da Bahia.");
            }
        }else{
            System.out.println("Estado não identificado");
        }
    }
}
