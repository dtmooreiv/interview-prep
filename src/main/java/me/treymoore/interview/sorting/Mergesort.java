package me.treymoore.interview.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Mergesort {

    //Simplistic implementation of mergesort
    //Uses lots of extra space.
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
        if(array.size() <= 1) {
            return array;
        }

        int middle = array.size() / 2;
        ArrayList<Integer> left = new ArrayList<Integer>((array.size()/2) + 1);
        ArrayList<Integer> right = new ArrayList<Integer>((array.size()/2) + 1);
        for(int i = 0; i < middle; i++) {
            left.add(array.get(i));
        }

        for(int i = middle; i < array.size(); i++) {
            right.add(array.get(i));
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left,right);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> merged = new ArrayList<Integer>(left.size() + right.size());
        while(left.size() > 0 && right.size() > 0) {
            if(left.get(0) <= right.get(0)) {
                merged.add(left.remove(0));
            } else {
                merged.add(right.remove(0));
            }
        }

        //One of the lists is now empty
        while(left.size() > 0) {
            merged.add(left.remove(0));
        }

        while(right.size() > 0) {
            merged.add(right.remove(0));
        }

        return merged;
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = Utils.getIntList(100);
        System.out.println("Before: " + Arrays.toString(intList.toArray()));
        System.out.println("After: " + Arrays.toString(mergeSort(intList).toArray()));
        System.out.println("Is Sorted: " + Utils.isSorted(mergeSort(intList)));
    }
}
