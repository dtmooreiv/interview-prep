package me.treymoore.interview.dynamicprogramming;

//Solution to the 0/1 Knapsack problem
//TODO
public class BinaryKnapsack {

    //Returns the maximum value achievable from a set of items
    //Values is each item's value
    //Weights is each item's weight
    //n in the number of distinct items
    //capacity is how much weight the knapsack can carry
    public static int binaryKnapsack(int[] values, int[] weights, int n, int capacity){
        int[][] m = new int[n+1][capacity+1];
        for(int i = 0; i <= capacity; i++){
            m[0][i] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= capacity; j++){
                if(i == 0 || j == 0) {
                    m[i][j] = 0;
                }
                //If we can use the newly visible item
                else if(weights[i-1] <= j) {
                    //Find if we are better off not using the item
                    m[i][j] = Math.max(m[i-1][j], m[i-1][j-weights[i-1]] + values[i-1]);
                } else {
                    m[i][j] = m[i-1][j];
                }
            }
        }

        return m[n][capacity];
    }

    public static void main(String[] args) {
        int[] values = {60,100,120};
        int[] weights = {10,20,30};
        int n = 3;
        int capacity = 50;
        System.out.println("The maximum value is: " + binaryKnapsack(values, weights, n, capacity));
    }
}
