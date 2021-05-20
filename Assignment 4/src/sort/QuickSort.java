package sort;

public class QuickSort {
	
	public void quickSort(int[] arr, int min, int max){
		int pi = 0;
		if (min < max)
		{
			pi = partition(arr, min, max);
			if (pi - min <= max-(pi+1)){
				quickSort(arr, min, pi);
				min = pi+1;
			}
			else {
				quickSort(arr, pi+1, max);
				max = pi;
			}
		}
	}
	
	public int partition (int[] arr, int min, int max) {
		int pivot = arr[max];
		int i = min -1;
		
		for (int j = min; j <= max-1; j++) {
			if (arr[j] < pivot)
			{
				i++;
				swap(arr, i , j);
				
			}
			
		}
		swap(arr, i+1, max);
		return i+1;
	}
	static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}

}
