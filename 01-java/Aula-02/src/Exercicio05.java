public class Exercicio05 {
    public static void main(String[] args) {
        double[][] precos = {

                {2.0, 3.0, 2.5},
                {1.5, 2.0, 1.5},
                {4.0, 3.0, 3.5},
                {2.0, 2.5, 2.0},
                {1.5, 1.0, 1.8},
                {3.0, 3.5, 4.0},
                {2.0, 1.5, 1.8},
                {3.0, 2.5, 3.0},
                {2.5, 2.0, 2.5},
                {1.0, 1.0, 1.0}
        };

        int mercadoMaisBarato = mercadoMaisBarato(precos);

        System.out.println("O mercado mais barato para compras é o Mercado " + (mercadoMaisBarato + 1));
    }

    public static int mercadoMaisBarato(double[][] precos) {
        int numMercados = precos[0].length;

        double[] custoMedioPorMercado = new double[numMercados];

        for (int i = 0; i < numMercados; i++) {
            double soma = 0.0;
            for (double[] precoItem : precos) {
                soma += precoItem[i];
            }
            custoMedioPorMercado[i] = soma / precos.length;
        }

        int mercadoMaisBarato = 0;
        double menorCustoMedio = custoMedioPorMercado[0];

        for (int j = 1; j < numMercados; j++) {
            if (custoMedioPorMercado[j] < menorCustoMedio) {
                menorCustoMedio = custoMedioPorMercado[j];
                mercadoMaisBarato = j;
            }
        }

        return mercadoMaisBarato;
    }
}
