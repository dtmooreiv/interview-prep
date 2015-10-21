package me.treymoore.interview.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Quicksort {

    public static void quicksort(ArrayList<Integer> array) {
        quicksort(array, 0, array.size()-1);
    }

    public static void quicksort(ArrayList<Integer> array, int low, int high) {
        if(low < high) {
            int pivot = partition(array, low, high);
            quicksort(array,low, pivot);
            quicksort(array, pivot + 1, high);
        }
    }

    public static int partition(ArrayList<Integer> array, int low, int high) {
        int pivot = array.get(low);
        int i = low - 1;
        int j = high + 1;
        while(true) {
            do {
                j--;
            } while(array.get(j) > pivot);

            do {
                i++;
            } while(array.get(i) < pivot);

            if(i < j) {
                Utils.swap(array, i, j);
            } else {
                return j;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = Utils.getIntList(1000, 5000);
        System.out.println("Before: " + Arrays.toString(intList.toArray()));
        quicksort(intList);
        System.out.println("After: " + Arrays.toString(intList.toArray()));
        System.out.println("Is sorted: " + Utils.isSorted(intList));

    }
}
