
public class SelectionSort implements SortInterface{
	
	public void sort(Integer[] arrayToSort) {
		for(int i = 0; i < arrayToSort.length; i++) {
			
			int indexSmallest = i;
			for(int j = i + 1; j < arrayToSort.length; j++) {
				if(arrayToSort[j] < arrayToSort[indexSmallest]) {
					indexSmallest = j;
				}
			}
			
			int temp = arrayToSort[i];
			arrayToSort[i] = arrayToSort[indexSmallest];
			arrayToSort[indexSmallest] = temp;
		}
	}
}
