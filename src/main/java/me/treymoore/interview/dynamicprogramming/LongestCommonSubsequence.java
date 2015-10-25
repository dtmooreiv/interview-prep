package me.treymoore.interview.dynamicprogramming;

public class LongestCommonSubsequence {

    //This method computes a longest common subsequence in the strings a and b
    public static String lcs(String a, String b) {
        String[][] calculated = new String[a.length()+1][b.length()+1];
        //Initialize the lcs of a string and the empty string
        for(int i = 0; i < calculated.length; i++) {
            calculated[i][0] = "";
        }
        //Initialize the lcs of b string and the empty string
        for(int i = 0; i < calculated[0].length; i++) {
            calculated[0][i] = "";
        }

        //Build the calculated array of arrays
        for(int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++){
                //If these two characters are equal, then an lcs can be made
                //From the lcs of their prefixes appended to this char
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    calculated[i][j] = calculated[i-1][j-1] + a.charAt(i-1);
                } else {
                    //We need to find which previous calculated lcs is longer
                    //If they are the same, arbitrarily choose calculated[i-1][j]
                    calculated[i][j] =  calculated[i-1][j].length() > calculated[i][j-1].length() ? calculated[i-1][j] : calculated[i][j-1];
                }
            }
        }
        return calculated[a.length()][b.length()];
    }

    public static void main(String[] args) {
        System.out.println(lcs("DCABCA", "DADCAC"));
        System.out.println(lcs("nematode knowledge", "empty bottle"));
    }
}
