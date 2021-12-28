package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ConnectedComponents {
    /**
     * You have a graph of n nodes. You are given an integer n and an array edges where
     * edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
     * Return the number of connected components in the graph.
     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {
        //our answer that we will be returning
        int answer = 0;
        //set up adjacency list
        Map<Integer, LinkedList<Integer>> edgeMap = new HashMap();
        for(int i = 0; i < n; i++ ){
            edgeMap.put(i, new LinkedList<Integer>());

        }
        //undirected so add edges to both
        for(int[] edge: edges){
            edgeMap.get(edge[1]).add(edge[0]);
            edgeMap.get(edge[0]).add(edge[1]);
        }
        //create a boolean array that will allow us to visit if there is a false in the array;
        boolean[] array = new boolean[n];
        for(int a = 0; a<n; a++ ){
            if(array[a] == false){
                answer++;
                dfs(edgeMap, a, array);
            }
        }
        return answer;

    }
    //dfs method recursively calls itself

    public void dfs(Map<Integer, LinkedList<Integer>> edgeMap, int a, boolean[] array){

        array[a] = true;

        for(int j: edgeMap.get(a)){
            if(array[j] == false)
                dfs(edgeMap, j, array);
        }
    }
}
