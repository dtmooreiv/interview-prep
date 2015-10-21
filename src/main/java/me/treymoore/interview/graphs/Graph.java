package me.treymoore.interview.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//From https://codereview.stackexchange.com/questions/48518/depth-first-search-breadth-first-search-implementation/48530#48530
public class Graph {

    private Map<String, List<String>> edges = new HashMap<String, List<String>>();

    public void addEdge(String src, String dest) {
        List<String> srcNeighbors = this.edges.get(src);
        if (srcNeighbors == null) {
            this.edges.put(src,
                    srcNeighbors = new ArrayList<String>()
            );
        }
        srcNeighbors.add(dest);
    }

    public Iterable<String> getNeighbors(String vertex) {
        List<String> neighbors = this.edges.get(vertex);
        if (neighbors == null) {
            return Collections.emptyList();
        } else {
            return Collections.unmodifiableList(neighbors);
        }
    }
}