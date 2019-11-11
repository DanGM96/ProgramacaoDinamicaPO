package progDinamica;
import java.util.Scanner;
public class Fibonacci {
	// Programacao Linear
	public static long fibonacciRuim(long x) {
		if (x <= 2) {
			return 1;
		}
		return fibonacciRuim(x - 1) + fibonacciRuim(x - 2);
	}
	// Programacao Dinamica com recursao
	public static long vetorMemorizacao[] = new long[9999];
	public static long fibonacciMemo(long n) {
		long fibValor = 0;
		
		if (n == 0) {
			return 0;
			
		} else if (n == 1) {
			return 1;
			
		} else if (vetorMemorizacao[(int) n] != 0) {
			return vetorMemorizacao[(int) n];
			
		} else {
			fibValor = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
			vetorMemorizacao[(int) n] = fibValor;
			return fibValor;
		}
	}
	// Programacao Dinamica sem recursao
	public static long fibonacciMemoSimples(long n) {
		long fnMin2 = 0;
		long fnMin1 = 1;
		long sum = 0;
		
		for (int i = 2; i <= n; i++) {
			sum = fnMin1 + fnMin2;
			fnMin2 = fnMin1;
			fnMin1 = sum;
		}
		return sum;
	}
	public static void main(String[] args) {
		vetorMemorizacao[0] = 1;
		vetorMemorizacao[1] = 1;
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Quantas casas de Fibonacci?");
		long casaFib = scan.nextLong();
		long preTime= System.currentTimeMillis();
		// fibonacciRuim // fibonacciMemo // fibonacciMemoSimples
		System.out.println("Valor de Fibonacci na casa " + casaFib + ": " + fibonacciRuim(casaFib));
		long postTime= System.currentTimeMillis();
		System.out.println("Tempo de execucao: " + (postTime - preTime) + "ms");
		scan.close();
	}
}

// TESTES

//fibonacciRuim
//Quantas casas de Fibonacci?
//45
//Valor de Fibonacci na casa 45: 1134903170
//Tempo de execucao: 2608ms

//fibonacciMemo
//Quantas casas de Fibonacci?
//45
//Valor de Fibonacci na casa 45: 1134903170
//Tempo de execucao: 0ms

//fibonacciMemoSimples
//Quantas casas de Fibonacci?
//45
//Valor de Fibonacci na casa 45: 1134903170
//Tempo de execucao: 0ms
