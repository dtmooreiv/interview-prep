package me.treymoore.interview.sorting;

import java.util.ArrayList;
import java.util.Random;

public class Utils {
    static Random rand = new Random();

    public static void swap(ArrayList<Integer> array, int ind1, int ind2) {
        Integer tmp = array.get(ind1);
        array.set(ind1, array.get(ind2));
        array.set(ind2, tmp);
    }

    public static ArrayList<Integer> getIntList(int size) {
        return getIntList(size, Integer.MAX_VALUE);
    }

    public static ArrayList<Integer> getIntList(int size, int bound) {
        ArrayList<Integer> ints = new ArrayList<Integer>(size);

        for(int i = 0; i < size; i++) {
            ints.add(rand.nextInt(bound));
        }

        return ints;
    }

    public static ArrayList<Integer> getPosIntList(int size, int bound) {
        ArrayList<Integer> ints = getIntList(size, bound);
        for(int i = 0; i < ints.size(); i++) {
            if(ints.get(i) < 0) {
                ints.set(i, Math.abs(ints.get(i)));
            }
        }

        return ints;
    }

    public static Integer findMax(int[] array) {
        Integer max = Integer.MIN_VALUE;
        for(Integer i: array) {
            if(i > max) {
                max = i;
            }
        }

        return max;
    }

    public static int[] toIntArray(ArrayList<Integer> array) {
        int[] arr = new int[array.size()];
        for(int i = 0; i < array.size(); i++) {
            arr[i] = array.get(i);
        }

        return arr;
    }
}
