import java.util.ArrayList;
//import java.util.Arrays;

public class TestTimes {
	
	ArrayList<Long> myList = new ArrayList<Long>();
	
	public static void main(String[] args) {
		
	}
	
	public long getLastTestTime() {
		return myList.get(myList.size() - 1);
	}
		
	public long[] getTestTimes() {
		final long[] arr = new long[myList.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = myList.get(i);
		}
		return arr;
	}
	
	public void resetTestTimes() {
		myList.clear();
	}
	
		
	public void addTestTime(long testTime) {
		if(myList.size() < 10) {
			myList.add(testTime);
			//System.out.println(Arrays.toString(myList.toArray()));
			//System.out.println(myList.size());
		}
		else {
			myList.remove(0);
			myList.add(testTime);
		}
	}
		
		
	public double getAverageTestTime() {
		double sum = 0.0;
		for(int i = 0; i < myList.size(); i++) {
			sum += myList.get(i);
		}
		return sum / myList.size();
	}
}
