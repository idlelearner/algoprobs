package code;

import java.util.HashMap;
import java.util.Map;

public class LongSeqSumZero {

	public static void main(String[] args) {
		Integer arr[] = { 1, 1, -1, 4, -4 };
		printMaxSeqSumZero(arr);
	}

	private static void printMaxSeqSumZero(Integer[] arr) {
		// Check if array if empty
		if (arr.length == 0)
			return;

		// sumArry to hold the incremental sum value of elements in arr
		int[] sumArr = new int[arr.length];
		sumArr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sumArr[i] = sumArr[i - 1] + arr[i];
		}

		// map to hold the sum --> index ref of elements from sumArr
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(sumArr[0], 0);
		Integer maxLength = 0;
		Integer maxIndex = 0;
		for (int i = 1; i < sumArr.length; i++) {
			if (map.containsKey(sumArr[i])) {
				Integer prevIndex = map.get(sumArr[i]);
				if (maxLength < i - prevIndex) {
					maxLength = i - prevIndex;
					maxIndex = prevIndex;
				}
			} else
				map.put(sumArr[i], i); // push only new sums
		}
		printArray(arr, maxIndex, maxIndex + maxLength);
	}

	// helper function to print the array elements
	private static void printArray(Integer arr[], int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
