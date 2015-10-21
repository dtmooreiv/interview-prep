package me.treymoore.interview.sorting;

import java.util.Arrays;

public class Countingsort {

    //Requires array only have positive numbers
    public static int[] countingSort(int[] array) {
        Integer max = Utils.findMax(array);
        int[] counts = new int[max + 1];

        for(int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        int total = 0;

        for(int i = 0; i <= max; i++) {
            int oldCount = counts[i];
            counts[i] = total;
            total+=oldCount;
        }

        int[] output = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            output[counts[array[i]]] = array[i];
            counts[array[i]]++;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] intList =  Utils.toIntArray(Utils.getPosIntList(10, 5));
        System.out.println("Before: " + Arrays.toString(intList));
        System.out.println("After: " + Arrays.toString(countingSort(intList)));
    }
}
