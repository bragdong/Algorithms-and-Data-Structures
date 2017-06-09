package algorithmandDataStructures;

import java.util.Arrays;

public class Sorting {

	public static int min(int[] arr, int len) {
		int minIdx = 0;
		int min = arr[0];
		;
		for (int i = 0; i < len; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minIdx = i;
			}
		}
		return minIdx;
	}

	public static int[] selectionSort(int[] arr) {
		int[] sorted = new int[arr.length];
		int len = arr.length;

		for (int i = 0; i < arr.length; i++) {
			int minIdx = min(arr, len);
			sorted[i] = arr[minIdx];
			arr[minIdx] = arr[len - 1];
			len--;
		}
		return sorted;
	}

	public static int[] bubbleSort(int[] arr) {
		// do a pass for length of the array minus one
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] myArray = new int[] { 10, -2, 3, -1, 0 };
		int[] myArray2 = new int[] { 10, -2, 3, -1, 0 };	
		System.out.println("input = "+Arrays.toString(myArray));
		 myArray = selectionSort(myArray);
		System.out.println("SelectionSort output = "+Arrays.toString(myArray));
		myArray2 = bubbleSort(myArray2);
		System.out.println("BubbleSort output = "+Arrays.toString(myArray2));

	}
}
