package BackTrackingSols;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    /**
     * Given an array nums of distinct integers,
     * return all the possible permutations. You can return the answer in any order.
     */
    public List<List<Integer>> permute(int[] nums) {
        //turn the array into an arrayList
        ArrayList<Integer> numss = new ArrayList<>();
        for(int n : nums){
            numss.add(n);
        }
        //make an answer list
        List<List<Integer>> answer = new ArrayList();
        //sort the arrayList
        Collections.sort(numss);
        //call the backTracking function
        permutations(0, answer, numss);
        return answer;
    }

    public void permutations(int index, List<List<Integer>> answer, ArrayList<Integer> numss){
        // the arrayList is always the size of the mother arrayList
        if(index == numss.size())
            answer.add(new ArrayList<>(numss));

        //for the size of the mother arrayList
        for(int i = index; i < numss.size(); i++){
            //swap the numbers going up, this is a backtracking function
            Collections.swap(numss, index, i);
            //swap the index and last with an increasing index
            permutations(index + 1, answer, numss);

            Collections.swap(numss, index, i);


        }
    }
}
