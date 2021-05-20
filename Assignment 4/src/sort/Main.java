package sort;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	
	public static void main (String[] args) {
		int size = 500000;
		int arr [] = new int [size];
		int tmpArr[] = new int[size];
		int hArr[] = new int[size];
		int mArr[] = new int[size];
		int qArr[] = new int[size];
		HeapSort hsort = new HeapSort();
		MergeSort msort = new MergeSort();
		QuickSort qsort = new QuickSort();
		
		long startTime = 0; 
		long totalTime = 0;
		boolean flag = true;
		Scanner input = new Scanner(System.in);

		//part a.
		for (int i = 0; i < size; i++)
			arr[i] = i;
		//part b.
		shuffleArray(arr);
		//part c.
		for (int i = 0; i < size; i++) {
			hArr[i] = arr[i];
			mArr[i] = arr[i];
			qArr[i] = arr[i];
		}
		
		//part d.
		while (flag) {
			//heapsort
			startTime = System.nanoTime();
			hsort.heapsort(hArr);
			System.out.printf("It took %d ms to heapSort "
					+ "the array\n", (System.nanoTime() 
							- startTime) / 100);
			//mergesort
			startTime = System.nanoTime();
			msort.mergeSort(mArr,tmpArr, 0, mArr.length - 1);
			System.out.printf("It took %d ms to mergeSort "
					+ "the array\n", (System.nanoTime() 
							- startTime) / 100);
			//quicksort
			startTime = System.nanoTime();
			qsort.quickSort(qArr, qArr[0], qArr.length-1);
			System.out.printf("It took %d ms to quickSort "
					+ "the array\n", (System.nanoTime() 
							- startTime) / 100);
			System.out.println( "Press any key to start the next round!");
			input.nextLine();
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