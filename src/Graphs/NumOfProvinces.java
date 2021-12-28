package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumOfProvinces {
    /**
     * There are n cities. Some of them are connected, while some are not.
     * If city a is connected directly with city b, and city b is connected directly with city c,
     * then city a is connected indirectly with city c.
     * A province is a group of directly or indirectly connected cities
     * and no other cities outside of the group.
     * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city
     * and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
     * Return the total number of provinces.
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;

        Map<Integer, ArrayList<Integer>> graph = new HashMap();
        for(int i = 0; i<isConnected.length; i++){
            graph.put(i, new ArrayList<Integer>());
        }

        for(int a = 0; a < graph.size(); a++){
            for(int b = 0; b < isConnected[a].length; b++){
                if(isConnected[a][b] == 1 && b != a){
                    graph.get(a).add(b);
                }
            }
        }
        boolean[] array = new boolean[isConnected.length];
        for(int c = 0; c < array.length; c++){
            if(array[c] == false){
                provinces++;
                dfs(c,graph,array);
            }
        }

        return provinces;

    }
    public void dfs(int a, Map<Integer, ArrayList<Integer>> graph, boolean[] array){

        array[a] = true;
        for(int z : graph.get(a)){
            if(array[z] == false)dfs(z,graph,array);
        }
    }
}
