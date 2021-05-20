package AVLTrees;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
	int arr[] = new int[5000];
	AVLTree tree1 = new AVLTree();
	Scanner input = new Scanner(System.in);
	

	for (int i = 0; i < 5000; i++)
		arr[i] = i;
	
	shuffleArray(arr);
	
	for (int i = 0; i < arr.length; i++)
		tree1.root = tree1.insert(tree1.root, arr[i]);
	
	AVLTree tree2 = new AVLTree();
	AVLTree swap = new AVLTree();
	boolean forever = true;
	int minVal = 0;
	long startTime = 0; 
	long totalTime = 0;
	while (forever)
	{
		while(tree1.root != null) {
			minVal = tree1.findMin(tree1.root).value;
			startTime = System.nanoTime();
			tree1.root = tree1.remove(tree1.root, minVal);
			System.out.printf("The process with a priority of %d is now scheduled to run%n", minVal );
			
			minVal = arr[minVal];
			
			tree2.root = tree2.insert(tree2.root, minVal);
			System.out.printf("The process with a priority of %d has run out of its timeslice!%n", minVal);
		}
		
		totalTime = (System.nanoTime() - startTime)/100;
		System.out.printf("Total time to run: %dms%n", totalTime);
		System.out.println("Every process has got a chance to run. Please press “Enter” to start the next round!");
		input.nextLine();
		swap = tree2;
		tree2 = tree1;
		tree1 = swap;			
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
