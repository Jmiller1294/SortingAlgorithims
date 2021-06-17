//import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		//Integer[] array = new Integer[] {5,1,4,2,3,9,10,1,0};
		//BubbleSort example = new BubbleSort();
	}
	
	
	
	public Integer[] sort(Integer[] arrayToSort) {
		
		boolean swapped = true;
		
		while(swapped) {
			swapped = false;
			for(int i = 1; i < arrayToSort.length; i++) {
				
				int j = i - 1;
				
				if(arrayToSort[j] > arrayToSort[i]) {
			
					int temp = arrayToSort[i];
					arrayToSort[i] = arrayToSort[j];
					arrayToSort[j] = temp;
					swapped = true;
				}
			}
			
		}
		return arrayToSort;
	}
}
	

