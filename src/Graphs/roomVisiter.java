package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class roomVisiter {
    /**
     * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
     * Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
     * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it,
     * denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
     * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
     * return true if you can visit all the rooms, or false otherwise.
     * @param rooms
     * @return
     */

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int i = 0; i < rooms.size(); i++){
            graph.put(i, new ArrayList<Integer>());

        }
        for(int j = 0; j < rooms.size(); j++){
            for(int b = 0; b < rooms.get(j).size(); b++){
                graph.get(j).add(rooms.get(j).get(b));
            }

        }
        boolean[] visit = new boolean[rooms.size()];

        //call dfs on the first room, if all rooms can be visited then no index in the visited array
        //will return false so return true; otherwise if all rooms can't be visited return false;
        dfs(0, visit, graph);
        for(int x = 0; x < visit.length; x++){
            if(visit[x] == false)return false;
        }


        return true;
    }
    public void dfs(int c, boolean[] visit, Map<Integer, ArrayList<Integer>> graph){

        visit[c] = true;
        for(int d: graph.get(c)){
            if(visit[d] == false)dfs(d, visit, graph);
        }
    }
}
