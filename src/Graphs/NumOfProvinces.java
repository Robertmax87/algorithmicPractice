package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumOfProvinces {
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
