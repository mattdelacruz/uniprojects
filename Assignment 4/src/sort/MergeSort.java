package sort;

public class MergeSort {
	public MergeSort() {}
	
	
	public void mergeSort(int a[], int tmpArr[], int l, int r) {
		if (l < r) {
			int m = (l + r)/2;
			mergeSort(a,tmpArr,l,m);
			mergeSort(a,tmpArr,m+1,r);
			merge(a,tmpArr,l,m+1,r);
		}
	
	}
	
	void merge (int arr[], int tmpArr[], int l, int r, int rightEnd) {
		int leftEnd = r-1;
		int tmpPos = l;
		int numElements = rightEnd-l+1;
		while(l <= leftEnd && r <= rightEnd) {
			if (arr[l] <= arr[r]) {
				tmpArr[tmpPos++] = arr[l++];
			}
			else
				tmpArr[tmpPos++] = arr[r++];
		}
		
		while(l<=leftEnd)
			tmpArr[tmpPos++] = arr[l++];
		while(r<=rightEnd)
			tmpArr[tmpPos++] = arr[r++];
		for(int j = 0; j<numElements; j++,rightEnd--)
			arr[rightEnd] = tmpArr[rightEnd];
		
		}
	}
	
	
