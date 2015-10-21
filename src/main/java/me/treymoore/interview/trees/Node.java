package me.treymoore.interview.trees;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    public Node(T val) {
        this.value = val;
        this.parent = null;
        this.distance = Double.POSITIVE_INFINITY;
        this.children = new ArrayList<Node<T>>();
    }

    private T value;

    public static void resetTree(Node root) {
        root.setDistance(Double.POSITIVE_INFINITY);
        root.setParent(null);
        List<Node> children = root.getChildren();
        for(Node node: children) {
            resetTree(node);
        }
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    private double distance;

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    private Node<T> parent;
    private List<Node<T>> children;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> addChild(T child) {
        Node<T> childNode = new Node(child);
        this.children.add(childNode);
        return childNode;
    }

    @Override
    public String toString(){
        return this.value.toString();
    }

    public static Node<String> getTree(){
        Node<String> prez = new Node<String>("Prez");
        Node<String> vp = prez.addChild("VP");
        Node<String> treasurer = prez.addChild("Treasurer");
        Node<String> judge = prez.addChild("Judge");

        Node<String> rock = vp.addChild("Rock");
        Node<String> frank = vp.addChild("Frank");
        Node<String> milly = vp.addChild("Milly");

        Node<String> joe = treasurer.addChild("Joe");
        Node<String> cat = treasurer.addChild("Cat");

        Node<String> pop = joe.addChild("Pop");

        Node<String> rand = judge.addChild("Rand");
        Node<String> oj = judge.addChild("Oj");
        Node<String> jim = judge.addChild("Jim");

        return prez;
    }
}
