package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupAnagrams {
    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     */

        public List<List<String>> groupAnagrams(String[] strs) {
            //instantiate a list of character lists
            List<List<Character>> example = new ArrayList();
            //run a loop and populate the list of lists with char arrays
            for(int i = 0; i < strs.length; i++){

                ArrayList<Character> list = new ArrayList();

                for(int j = 0; j < strs[i].length(); j++){

                    char[] array = strs[i].toCharArray();

                    list.add(strs[i].charAt(j));
                }
                example.add(list);
            }
            List<List<Character>> comparator = new ArrayList();
            //sort the char arrays
            for(List<Character> lists : example){
                Collections.sort(lists);
                comparator.add(lists);

            }
            System.out.print(comparator);
            //here is our answer list
            List<List<String>> answer = new ArrayList<>();
            //loop through again comparing lists and populating answer, if the lists are the same, populate
            for(int i = 0; i < example.size(); i++){

                List<String> sList = new ArrayList<>();

                for(int j = 0; j < comparator.size(); j++){

                    if(example.get(i).equals(comparator.get(j))){

                        sList.add(strs[j]);
                    }

                }
                //don't populate the answer with the same lists
                if(!answer.contains(sList))
                    answer.add(sList);
            }
            return answer;



        }
    }

