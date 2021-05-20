package heap;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	
	public static void main (String[] args) {
		int size = 5000;
		int arr [] = new int [size];
		long startTime = 0; 
		long totalTime = 0;
		boolean flag = true;
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < size; i++)
			arr[i] = i;
		
		shuffleArray(arr);
		
		BinaryHeap heap1 = new BinaryHeap(arr.length);
		
		for (int j = 0; j < arr.length - 1; j++)
			heap1.insert(arr[j]);
		
		BinaryHeap heap2 = new BinaryHeap(arr.length);
		int pos = 0;
		int min = 0;
		while(flag) {
			pos = 0;
			min = 0;
			startTime = System.nanoTime();
			while (!heap1.isEmpty())
			{
				min = heap1.deleteMin();
				System.out.printf("The process with a priority of %d is now " 
				+ "scheduled to run!%n", min);
				
				min = arr[pos];
				heap2.insert(min);
				
				System.out.printf("The process with a priority of %d has "
				+ "run out of its timeslice!%n", min);
				pos++;
			}
			totalTime = (System.nanoTime() - startTime) / 100;
			
			System.out.printf("It took %dms for all processes to run out "
					+ "of their timeslices.%n" + "Please press enter to " 
					+ "start the next round!%n", totalTime);
			
			input.nextLine();
			BinaryHeap temp = heap1;
			heap1 = heap2;
			heap2 = temp;
		}
		input.close();
		
	}
	
	static void shuffleArray(int[] arr)
	{
		Random rnd = ThreadLocalRandom.current();
		
		for (int i = arr.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			int a = arr[index];
			arr[index] = arr[i];
			arr[i] = a;
		}
	}
}
