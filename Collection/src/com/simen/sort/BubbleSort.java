package com.simen.sort;

import java.util.Arrays;
import java.util.List;
import java.lang.Comparable;


public class BubbleSort {
	
	static int comparisons=0;
	
	public static void main(String[] args) {
		int[] input = new int[] {1,3,6,5,4,9,10,2,7,8};
		Integer[] input2 = new Integer[input.length];
		for(int i=0;i<input.length;i++) {
			input2[i] = (Integer)input[i];
		}
		sortAscending(input2);
		//System.out.println("total comparisons: "+comparisons);
		System.out.println(Arrays.toString(input2));
	}
	
	public static <T extends Comparable<T>> void sortAscending(T[] input) {
		for (int j = 0; j < input.length; j++) {
			boolean swaped = false;
			for (int i = 0; i < input.length-1-j; i++) {
				T first = input[i];
				T second = input[i + 1];
				if (first.compareTo(second)>0) {
					input[i + 1] = first;
					input[i] = second;
					swaped = true;
				}
				comparisons++;
			}
			if(!swaped) {
				break;
			}
		}
	}
	
	public static <T extends Comparable<T>> void sortDescending(T[] input) {
		for (int j = 0; j < input.length; j++) {
			boolean swaped = false;
			for (int i = 0; i < input.length-1-j; i++) {
				T first = input[i];
				T second = input[i + 1];
				if (first.compareTo(second)<0) {
					input[i + 1] = first;
					input[i] = second;
					swaped = true;
				}
				comparisons++;
			}
			if(!swaped) {
				break;
			}
		}
	}
	
	public static <T extends Comparable<T>> void sortAscending(List<T> list) {
		Object[] arr = list.toArray();
		sortAscending(arr);
		for(int i=0;i<arr.length;i++) {
			list.set(i, (T)arr[i]);
		}
	}
	
	public static <T extends Comparable<T>> void sortDescending(List<T> list) {
		Object[] arr = list.toArray();
		sortAscending(arr);
		for(int i=0;i<arr.length;i++) {
			list.set(i, (T)arr[i]);
		}
	}
	
	public static void sortAscending(Object[] input) {
		for (int j = 0; j < input.length; j++) {
			boolean swaped = false;
			for (int i = 0; i < input.length-1-j; i++) {
				Object first = input[i];
				Object second = input[i + 1];
				if (((Comparable)first).compareTo(second)>0) {
					input[i + 1] = first;
					input[i] = second;
					swaped = true;
				}
				comparisons++;
			}
			if(!swaped) {
				break;
			}
		}
	}
	
	public static void sortDescending(Object[] input) {
		for (int j = 0; j < input.length; j++) {
			boolean swaped = false;
			for (int i = 0; i < input.length-1-j; i++) {
				Object first = input[i];
				Object second = input[i + 1];
				if (((Comparable)first).compareTo(second)<0) {
					input[i + 1] = first;
					input[i] = second;
					swaped = true;
				}
				comparisons++;
			}
			if(!swaped) {
				break;
			}
		}
	}

}
