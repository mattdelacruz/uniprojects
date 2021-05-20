package heap;

public class BinaryHeap {
	private int[] Heap;
	private int currentSize;
	private int maxSize;
	
	public BinaryHeap (int maxSize) {
		this.maxSize = maxSize;
		this.currentSize = 0;
		Heap = new int[this.maxSize+1];
		
	}
	
	int parent (int pos) {
		return (pos-1)/2;
	}
	
	int left(int pos) {
		return (2*pos);
	}
	
	int right (int pos) {
		return (2*pos + 1);
	}
	
	void insert (int a) {
		int hole = ++currentSize;
		for (;hole > 1 && a < Heap[hole/2]; hole /=2)
			Heap[hole] = Heap[hole/2];
		Heap[hole] = a;	
	}
	
	int deleteMin () {

		int minItem = Heap[1];
		Heap[1] = Heap[currentSize--];
		percolateDown(1);
		return minItem;
	}
	
	void percolateDown(int hole) {
		int child;
		int tmp = Heap[hole];
		for (;hole*2 <= currentSize; hole = child) {
			child = hole*2;
			if (child != currentSize && Heap[child+1] < Heap[child])
				child++;
			if (Heap[child] < tmp)
				Heap[hole] = Heap[child];
			else
				break;
		}
		Heap[hole] = tmp;
	}
	
	boolean isLeaf(int pos) {
		if (pos >= (currentSize / 2) && pos <= currentSize)
			return true;
		return false;
	}
	
	boolean isEmpty() {
		if (currentSize == 0)
			return true;
		return false;
	}
	
	public void print()
    {
        for (int i = 1; i <= currentSize / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                             + " LEFT CHILD : " + Heap[2 * i]
                             + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }
	
}
