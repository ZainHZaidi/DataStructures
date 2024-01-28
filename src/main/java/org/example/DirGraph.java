package com.company;
import java.util.*;

public class DirGraph {
    private int[][] graph;

    public DirGraph(int[][] g) {
        this.graph = g;
    }

    public boolean hasCycle() {
        // instantiating the visited array and current path array
        ArrayList<Boolean> visited = new ArrayList<>();
        ArrayList<Boolean> path = new ArrayList<>();
        // setting all to false compared to the traditional approach of containing the nodes we have visited
        // or are in our current path a true false list will be used
        for (int i =0; i < graph.length; i++) {
            visited.add(false);
            path.add(false);
        }
        //starting a DFS from each node to check for cycles as that as a starting point
        for (int i = 0; i < graph.length; i++) {
            if (!visited.get(i) && helper(i, visited, path)) {
                return true;
            }
        }
        return false;
    }
    //Helper function which does the actual DFSing for each node
    private boolean helper(int curr, ArrayList<Boolean> visited, ArrayList<Boolean> path) {
        //if our current isnt visited set it to visited and add it to current path
        if (!visited.get(curr)) {
            visited.set(curr, true);
            path.set(curr, true);
            // do the same for the connected nodes if we hit something in our path return true
            for (int con = 0; con < graph.length; con++) {
                if (graph[curr][con] != 0) {
                    if (!visited.get(con) && helper(con, visited, path)) {
                        return true;
                    } else if (path.get(con)) {
                        return true;
                    }
                }
            }
        }
        //if we've hit nothing in our path reset path and return false
        path.set(curr, false);
        return false;
    }

    public static void main(String[] args) {
        //Creating graphs then creating dirGraphs then printing their hasCycle
        int[][] graph1 ={{0, 4, 0, 5, 0},
                {0, 0, 1, 0, 6},
                {2, 0, 0, 3, 0},
                {0, 1, 0, 2, 0},
                {1, 0, 0, 4, 0}}

                ;



        int[][] graph2 = {{0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}};


        int[][] graph3 = {{0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 0}};



        DirGraph dirGraph1 = new DirGraph(graph1);
        DirGraph dirGraph2 = new DirGraph(graph2);
        DirGraph dirGraph3 = new DirGraph(graph3);

        System.out.println(dirGraph1.hasCycle());
        System.out.println(dirGraph2.hasCycle());
        System.out.println(dirGraph3.hasCycle());
    }
}
