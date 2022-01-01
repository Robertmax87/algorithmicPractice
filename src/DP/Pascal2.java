package DP;

import java.util.ArrayList;
import java.util.List;

public class Pascal2 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> answer = new ArrayList<>();
        rowIndex++;
        List<Integer> intList = new ArrayList<>();

        if(rowIndex == 1){
            intList.add(1);
            return intList;

        }
        else if(rowIndex == 2){
            intList.add(1);
            answer.add(intList);
            ArrayList<Integer> listerr = new ArrayList<>();
            listerr.add(1);
            listerr.add(1);
            answer.add(listerr);
            return answer.get(answer.size() - 1);
        }
        else{
            intList.add(1);
            answer.add(intList);
            ArrayList<Integer> lister = new ArrayList<>();
            lister.add(1);
            lister.add(1);
            answer.add(lister);

            rowIndex-=2;
            while(rowIndex!=0){
                ArrayList<Integer>list = new ArrayList<>();
                list.add(1);
                for(int i = 0; i < answer.get(answer.size() - 1).size() - 1; i++){
                    list.add(answer.get(answer.size() - 1).get(i) + answer.get(answer.size() - 1).get(i + 1));
                }
                list.add(1);
                answer.add(list);

                rowIndex--;
            }
            return answer.get(answer.size() - 1);
        }
    }

}
