package DP;

import java.util.ArrayList;
import java.util.List;

public class Pascal {
    // ex numRows3 == [[1],[1,1],[1,2,1],[1,3,3,1]]
    public List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> intList = new ArrayList<>();

        if (numRows == 1) {
            intList.add(1);
            answer.add(intList);
            return answer;

        } else if (numRows == 2) {
            intList.add(1);
            answer.add(intList);
            ArrayList<Integer> listerr = new ArrayList<>();
            listerr.add(1);
            listerr.add(1);
            answer.add(listerr);
            return answer;
        } else {
            intList.add(1);
            answer.add(intList);
            ArrayList<Integer> lister = new ArrayList<>();
            lister.add(1);
            lister.add(1);
            answer.add(lister);

            numRows -= 2;
            while (numRows != 0) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                for (int i = 0; i < answer.get(answer.size() - 1).size() - 1; i++) {
                    list.add(answer.get(answer.size() - 1).get(i) + answer.get(answer.size() - 1).get(i + 1));
                }
                list.add(1);
                answer.add(list);

                numRows--;
            }
            return answer;

        }

    }
}

