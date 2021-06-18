import java.util.Arrays;
import java.util.Random;

public class SortDriver implements SortDriverInterface {
	
	
	public static void main(String[] args) {
		SortDriver s = new SortDriver();
		s.runSort(SortType.BubbleSort, ArrayType.Equal, 1000, 10);
		System.out.println(Arrays.deepToString(s.runSort(SortType.BubbleSort, ArrayType.Decreasing, 1000, 2)));
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
		
		Object[] objArr = new Object[(numberOfTimes * 2) + 1];
		SortDriver sort = new SortDriver();
		TestTimes testTime = new TestTimes();
		
		for(int i = 0; i < numberOfTimes * 2; i += 2) {
			Integer[] unsortedArr = sort.createArray(arrayType, arraySize);
			Integer[] copyArr = sort.createArray(arrayType, arraySize);
			objArr[i] = copyArr;
			long startTime = System.nanoTime();
				switch(sortType) {
			      case BubbleSort:
			    	  BubbleSort bubbleSort = new BubbleSort();
			    	  bubbleSort.sort(unsortedArr);
			        break;
			      case InsertionSort:
			    	  InsertionSort insertionSort = new InsertionSort();
			    	  insertionSort.sort(unsortedArr);
			        break;
			      case SelectionSort:
			    	SelectionSort selectionSort = new SelectionSort();
			    	selectionSort.sort(unsortedArr);
			        break;
			    }
			long endTime = System.nanoTime();
			long time = (endTime - startTime);
			testTime.addTestTime(time);
			objArr[i + 1] = unsortedArr;
		}
		objArr[numberOfTimes * 2] = testTime;
		return objArr;
	}

}
