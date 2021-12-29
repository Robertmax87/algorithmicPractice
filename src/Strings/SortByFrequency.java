package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFrequency {
    /**Given a string s, sort it in decreasing order based on the frequency of the characters.
     *  The frequency of a character is the number of times it appears in the string.
     Return the sorted string. If there are multiple answers, return any of them.
     **/
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        queue.addAll(map.entrySet());
        String answer = "";
        while(!queue.isEmpty()){
            int i = 0;
            Map.Entry e = queue.poll();
            char c = (char)e.getKey();
            while(i != map.get(c)){
                answer+= c;
                i++;
            }
        }
        return answer;
    }
}
