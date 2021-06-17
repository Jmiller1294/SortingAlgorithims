import java.util.Arrays;
import java.util.Random;

public class SortDriver implements SortDriverInterface {
	

	public static void main(String[] args) {
		SortDriver s = new SortDriver();
		//s.runSort(SortType.BubbleSort, ArrayType.Equal, 1000, 10);
		s.runSort(SortType.BubbleSort, ArrayType.IncreasingAndRandom, 1000, 10);
		//s.runSort(SortType.BubbleSort, ArrayType.Increasing, 1000, 10);
		//s.runSort(SortType.InsertionSort, ArrayType.Equal, 1000, 10);
		//s.runSort(SortType.SelectionSort, ArrayType.Equal, 1000, 10);
		//TestTimes testTime = new TestTimes();
		
	}
	
	public Integer[] createArray(ArrayType arrayType, int arraySize) {
		Integer[] array = new Integer[arraySize];
		Random rand = new Random();
		int upperBound = 1000000;
		int sum = 0;
		switch(arrayType) {
			case Equal:
				for(int i = 0; i < array.length; i++) {
					array[i] = 1;
				}
				break;
			case Random:
				for(int i = 0; i < array.length; i++) {
					array[i] = rand.nextInt(upperBound);
				}
				break;
			case Increasing:
				for(int i = 0; i < array.length; i++) {
					array[i] = sum += 1;
				}
				break;
			case Decreasing:
				for(int i = 0; i < array.length; i++) {
					array[i] = arraySize -=1;
				}  
				break;
			case IncreasingAndRandom:
				double percent = 0.90 * arraySize;
				int value = (int)percent;
				for(int i = 0; i < value; i++) {
					array[i] = sum += 1;
				}
				for(int i = value; i < array.length; i++) {
					array[i] = rand.nextInt(upperBound);
				}
				break;
		}
		
		return array;
	}
	

	public Object[] runSort(SortDriverInterface.SortType sortType, SortDriverInterface.ArrayType arrayType,
			int arraySize, int numberOfTimes) {
		
		SortDriver sort = new SortDriver();
		TestTimes testTime = new TestTimes();
		Integer[] arr = sort.createArray(arrayType, arraySize);
		System.out.println(Arrays.deepToString(arr));
		
		while(numberOfTimes > 0 ) {
			long startTime = System.nanoTime();
				switch(sortType) {
			      case BubbleSort:
			    	  BubbleSort bubbleSort = new BubbleSort();
			    	  bubbleSort.sort(arr);
			    	  System.out.println("bubble");
			        break;
			      case InsertionSort:
			    	  InsertionSort insertionSort = new InsertionSort();
			    	  insertionSort.sort(arr);
			    	  System.out.println("insertion");
			        break;
			      case SelectionSort:
			    	SelectionSort selectionSort = new SelectionSort();
			    	selectionSort.sort(arr);
			        System.out.println("selection");
			        break;
			    }
			long endTime = System.nanoTime();
			long time = (endTime - startTime);
			testTime.addTestTime(time);
			System.out.println(Arrays.toString(testTime.getTestTimes()));
			numberOfTimes--;
			
		}
		return null;
	}

}
