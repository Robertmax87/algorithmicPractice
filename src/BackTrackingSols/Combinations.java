package BackTrackingSols;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    /**
     * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
     *You may return the answer in any order.
     */
    public List<List<Integer>> combine(int n, int k) {
        //instantiate our answer List of Lists
        List<List<Integer>> answer = new ArrayList();
        // from 1 to n so start with 1 instead of a starting index of zero

        combinations(1, answer, new LinkedList<Integer>(), k, n);

        //return our answer List of Lists

        return answer;

    }
    public void combinations(int index, List<List<Integer>> answer, LinkedList<Integer> list, int k, int n){
        //if the size of the list is k, add the list to the List of Lists
        if(list.size() == k)answer.add(new LinkedList<Integer>(list));
        //iterate from our index until the last number n + 1 because we want n included
        for(int i = index ; i < n + 1; i++){

            list.add(i);
            combinations(i + 1, answer, list, k, n);
            list.removeLast();

        }
    }
}
