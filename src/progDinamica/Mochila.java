package progDinamica;

public class Mochila {

	public static int calcula(int capacidade, int[] pesos, int[] valores) {

		int n = pesos.length;

		int[][] memoria = new int[n + 1][capacidade + 1];

		for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= capacidade; j++) {

				if ((i == 0) || (j == 0))// condição inicial
					memoria[i][j] = 0;

				else
				// ainda da para tentar inserir o item na mochila

				if (pesos[i - 1] <= j)
					// 2 condições: ainda tem espaço ou tentamos retirar um item
					memoria[i][j] = Math.max(valores[i - 1] + memoria[i - 1][j - pesos[i - 1]], memoria[i - 1][j]);

				else
					// mochila já está cheia
					memoria[i][j] = memoria[i - 1][j];
			}
		}

		// imprime matriz

		for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= capacidade; j++)

				System.out.printf("%3d ", memoria[i][j]);

			System.out.println();
		}

		return memoria[n][capacidade];
	}

	public static void main(String[] args) {

		int[] valores = { 60, 100, 120 };

		int[] pesos = { 10, 20, 30 };

		int capacidade = 50;

		System.out.printf("Valor maximo conseguido na mochila - %d\n", calcula(capacidade, pesos, valores));

	}

}

