package me.treymoore.interview.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class BreadthFirstSearchTree {
    public static void main(String[] args) {
        Node<String> prez = Node.getTree();

        List<Node> reachable = BFS(prez);
        System.out.println(reachable.size());
        for(Node node: reachable) {
            System.out.println("Node: " + node + " distance from root: " + node.getDistance());
        }

        //This is fragile, and might break if Node.getTree() changes.
        Node<String> pop = prez.getChildren().get(1).getChildren().get(0).getChildren().get(0);

        List<Node> path = BFS2(prez, pop);
        System.out.println(path.size());
        for(Node node: path) {
            System.out.println("Node: " + node + " distance from root: " + node.getDistance());
        }
    }

    //Breadth first search
    //Returns a list of all reachable nodes in the order visited
    public static List<Node> BFS(Node root) {
        Node.resetTree(root);
        List<Node> reachable = new ArrayList<Node>();
        LinkedList<Node> queue = new LinkedList<Node>();

        root.setDistance(0);
        queue.add(root);

        reachable.add(root);

        while(queue.size() > 0) {
            Node cur = queue.remove();
            List<Node> children = cur.getChildren();
            for(Node node : children) {
                if(node.getDistance() == Double.POSITIVE_INFINITY) {
                    node.setDistance(cur.getDistance() + 1);
                    node.setParent(cur);
                    queue.add(node);
                    reachable.add(node);
                }
            }
        }

        return reachable;
    }

    //Uses above BFS implementation to find a path from root to find.
    //Returns empty list if no path exists.
    public static List<Node> BFS(Node root, Node find){
        List<Node> path = new ArrayList<Node>();

        //After this runs, all reachable nodes have their parents
        List<Node> reachable = BFS(root);
        if(reachable.contains(find)) {
            Node cur = find;
            while(cur != root) {
                path.add(0, cur);
                cur = cur.getParent();
            }

            path.add(0, root);

            return path;
        } else {
            return Collections.emptyList();
        }
    }

    //Another BFS path-finding implementation
    //This one doesn't rely on getting all reachable nodes through BFS
    //Instead, it stops once it finds the node during BFS.
    //Also, the queue keeps track of paths instead of individual nodes
    public static List<Node> BFS2(Node root, Node find) {
        Node.resetTree(root);

        LinkedList<ArrayList<Node>> queue = new LinkedList<ArrayList<Node>>();
        root.setDistance(0);

        ArrayList<Node> path = new ArrayList<Node>();
        path.add(root);

        queue.add(path);

        while(queue.size() > 0) {
            ArrayList<Node> curPath = queue.remove();
            Node endNode = curPath.get(curPath.size() - 1);
            if(endNode == find) {
                return curPath;
            } else {
                List<Node> endNodeChildren = endNode.getChildren();
                for (Node node : endNodeChildren) {
                    if(node.getDistance() == Double.POSITIVE_INFINITY) {
                        node.setDistance(endNode.getDistance() + 1);
                        node.setParent(endNode);
                        ArrayList<Node> newPath = new ArrayList<Node>(curPath);
                        newPath.add(node);
                        queue.add(newPath);
                    }
                }
            }
        }

        return Collections.emptyList();
    }
}
