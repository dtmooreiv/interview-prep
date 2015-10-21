package me.treymoore.interview.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayDeque;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Node<String> prez = Node.getTree();

        List<Node> reachable = DFS(prez);
        System.out.println(reachable.size());
        for(Node node: reachable) {
            System.out.println("Node: " + node + " distance from root: " + node.getDistance());
        }

        //This is fragile, and might break if Node.getTree() changes.
        Node<String> pop = prez.getChildren().get(1).getChildren().get(0).getChildren().get(0);

        List<Node> path = DFS(prez, pop);
        System.out.println("Path.size " + path.size());
        for(Node node: path) {
            System.out.println("Node: " + node);
        }
    }

    //Depth First Search
    //Returns a list of all reachable nodes in the order visited
    public static List<Node> DFS(Node root) {
        Node.resetTree(root);
        ArrayDeque<Node> stack = new ArrayDeque<Node>();

        List<Node> reachable = new ArrayList<Node>();

        root.setDistance(0);

        stack.push(root);

        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            reachable.add(cur);
            List<Node> children = cur.getChildren();
            for(Node node: children) {
                if(node.getDistance() == Double.POSITIVE_INFINITY) {
                    node.setDistance(cur.getDistance() + 1);
                    node.setParent(cur);
                    stack.push(node);
                }
            }
        }

        return reachable;
    }

    //Returns path from root to find if it exists,
    //Returns empty list if no path exists.
    //If root equals find, a list of just the root is returned
    public static List<Node> DFS(Node root, Node find) {
        Node.resetTree(root);
        ArrayDeque<ArrayList<Node>> stack = new ArrayDeque<ArrayList<Node>>();

        ArrayList<Node> path = new ArrayList<Node>();
        path.add(root);
        stack.push(path);

        while(!stack.isEmpty()) {
            ArrayList<Node> curPath = stack.pop();
            Node endNode = curPath.get(curPath.size() -1 );
            if(endNode == find) {
                return curPath;
            } else {
                List<Node> children = endNode.getChildren();
                for(Node node: children) {
                    if(node.getDistance() == Double.POSITIVE_INFINITY) {
                        node.setDistance(endNode.getDistance() + 1);
                        node.setParent(endNode);
                        ArrayList<Node> newPath = new ArrayList<Node>(curPath);
                        newPath.add(node);
                        stack.push(newPath);
                    }
                }
            }
        }

        return Collections.emptyList();
    }
}
