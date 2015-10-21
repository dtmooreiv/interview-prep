package me.treymoore.interview.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Bubblesort {

    //Gross
    public static void bubblesort(ArrayList<Integer> array) {
        int n = array.size();
        while(n > 0) {
            int newn = 0;
            for(int i = 1; i < n; i++) {
                if(array.get(i-1) > array.get(i)) {
                    Utils.swap(array, i, i -1);
                    newn = i;
                }
            }
            n = newn;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = Utils.getIntList(100);
        System.out.println("Before: " + Arrays.toString(intList.toArray()));
        bubblesort(intList);
        System.out.println("After: " + Arrays.toString(intList.toArray()));
        System.out.println("Is sorted: " + Utils.isSorted(intList));
    }
}
