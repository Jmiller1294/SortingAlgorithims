//import java.util.Arrays;

public class InsertionSort implements SortInterface{
	public static void main(String[] args) {
		//Integer[] array = new Integer[] {5,1,4,2,3,9,10,1,0};
		//InsertionSort example = new InsertionSort();
		//System.out.print(example.sort(array));
	}
	
	
	
	public void sort(Integer[] arrayToSort) {
		
		for(int i = 0; i < arrayToSort.length; i++) {
			int indexSmallest = i;
			
			for(int j = i + 1;j < arrayToSort.length; j++) {
				
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
