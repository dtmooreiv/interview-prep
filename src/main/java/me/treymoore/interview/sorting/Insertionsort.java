package me.treymoore.interview.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Insertionsort {

    //In place sorting
    public static void insertionSort(ArrayList<Integer> array) {
        for(int i = 1; i < array.size(); i++) {
            int j = i;
            while(j > 0 && array.get(j-1) > array.get(j)) {
                Utils.swap(array, j-1, j);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = Utils.getIntList(100);
        System.out.println("Before: " + Arrays.toString(intList.toArray()));
        insertionSort(intList);
        System.out.println("After: " + Arrays.toString(intList.toArray()));
        System.out.println("Is sorted: " + Utils.isSorted(intList));

    }
}
