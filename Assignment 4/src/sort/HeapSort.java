package sort;

public class HeapSort {
	private int leftChild;
	private int rightChild;
	
	public HeapSort() {}
	
	public int leftChild(int i) {
		return (i*2);
	}
	
	public int rightChild(int i) {
		return (i*2 + 1);
	}
	
	public void heapsort(int a[]) {
		for (int j = a.length/2; j>=0; j--)
			percDown(a, j, a.length);
		for (int k = a.length - 1; k>0; k--)
		{
			int tmp = a[0];
			a[0] = a[k];
			a[k] = tmp;
			percDown(a, 0, k);
		}
	}

	private void percDown(int[] a, int i, int n) {
		int child;
		int tmp;
		for (tmp = a[i]; leftChild(i) < n; i = child)
		{
			child = leftChild(i);
			if (child!= n-1 && a[child] < a[child+1])
				child++;
			if(tmp<a[child])
				a[i] = a[child];
			else break;
		}
		a[i] = tmp;
	}
}
