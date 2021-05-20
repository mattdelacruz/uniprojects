/*Matthew Dela Cruz*/
import java.util.Scanner; 

public class main {
	public static long fib (int n) {
		if (n <= 1)
			return n;
		else
			return fib(n-1) + fib(n-2);
	}
	
	public static void main(String[] args) {
		long num1 = 0, num2 = 0;
		int n = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		n = input.nextInt();
		input.close();
		
		long f1 = 0, f2 = 1, sum = 0, startTime = System.nanoTime(), totalTime = 0;
		for (int i = 2; i <= n; i++) {
			sum = f1 + f2;
			f1 = f2;
			f2 = sum;
		}
		
		long endTime = System.nanoTime();
		totalTime = (endTime - startTime)/100;
		if (sum < (2^31)) {
			num2 = sum;
			System.out.println("fibonacci number: " + num2 + " runtime: " + totalTime + "ms");
		}
		else {
			num1 = sum;
			System.out.println("fibonacci number: " + num1 + " runtime: " + totalTime + "ms");
		}
		startTime = System.nanoTime();
		sum = fib(n);
		endTime = System.nanoTime();
		totalTime = (endTime - startTime)/100;
		System.out.println("using recursive: " + sum + " runtime: " + totalTime + "ms\n");
				
	}
	
}
