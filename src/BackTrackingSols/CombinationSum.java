package BackTrackingSols;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /**
     * Given an array of distinct integers candidates and a target integer target,
     * return a list of all unique combinations of candidates where the chosen numbers sum to target.
     * You may return the combinations in any order.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //instantiate an answer list that we will return;
        List<List<Integer>> answer = new ArrayList();


        ArrayList<Integer> array = new ArrayList();
        Arrays.sort(candidates);
        dfs(0, candidates, answer, new ArrayList<Integer>(), target);
        return answer;
    }
    public void dfs(int i,int[] candidates, List<List<Integer>> answer, List<Integer> array,  int target){

        if(target == 0){
            answer.add(new ArrayList<>(array));
        }
        if (target < 0) return;

        for(int j = i; j < candidates.length; j++){

            array.add(candidates[j]);
            dfs(j, candidates, answer, array, target - candidates[j]);
            array.remove(array.size() - 1);

        }
    }
}
