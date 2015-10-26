package me.treymoore.interview.dynamicprogramming.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Efficient data compression using prefix codes and character frequency
public class HuffmanEncoding {

    public static class Node implements Comparable<Node>{
        private char character;
        private double freq;
        private Node lChild;
        private Node rChild;


        public Node(double freq, Node lChild, Node rChild){
            this.freq = freq;
            this.lChild = lChild;
            this.rChild = rChild;
        }

        public Node(char character, double freq, Node lChild, Node rChild){
            this.character = character;
            this.freq = freq;
            this.lChild = lChild;
            this.rChild = rChild;
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public double getFreq() {
            return freq;
        }

        public void setFreq(double freq) {
            this.freq = freq;
        }

        public Node getlChild() {
            return lChild;
        }

        public void setlChild(Node lChild) {
            this.lChild = lChild;
        }

        public Node getrChild() {
            return rChild;
        }

        public void setrChild(Node rChild) {
            this.rChild = rChild;
        }

        public int compareTo(Node o) {
            if(this.freq < o.freq) return -1;
            if(this.freq > o.freq) return 1;
            return 0;
        }
    }

    public static Node huffmanCode(HashMap<Character, Double> freqs) {
        int n = freqs.size();
        PriorityQueue<Node> queue = new PriorityQueue<Node>(n);
        //Initialize the queue to contain all the character frequencies. No nodes currently have children
        for(Map.Entry<Character, Double> entry : freqs.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue(),null, null);
            queue.add(node);
        }

        while(queue.size() > 1){
            Node x = queue.poll();
            Node y = queue.poll();
            //Do not need to worry about either being null
            //An optimal code is always represented by a full binary tree
            //If this weren't the case, we could save space by making the
            //Node with only one child a leaf node itself
            Node encodedNode = new Node(x.getFreq() + y.getFreq(), x, y);
            queue.add(encodedNode);
        }


        return queue.poll();
    }

    public static void main(String[] args) {
        HashMap<Character, Double> charFreqs = new HashMap<Character, Double>(6);
        charFreqs.put('a', .45);
        charFreqs.put('b', .13);
        charFreqs.put('c', .12);
        charFreqs.put('d', .16);
        charFreqs.put('e', .09);
        charFreqs.put('f', .05);
        Node hEncond = huffmanCode(charFreqs);
    }
}
