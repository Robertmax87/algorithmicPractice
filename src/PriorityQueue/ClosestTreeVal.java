package PriorityQueue;

import java.util.*;

public class ClosestTreeVal {

     //Definition for a binary tree node.
      public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
         }
     }

    /**Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are closest to the target. You may return the answer in any order.
     You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
     **/
    class Solution {
        ArrayList<Integer> array = new ArrayList<>();
        Map<Double, ArrayList<Integer>> compare = new HashMap<>();
        ArrayList<Double> difference = new ArrayList<>();
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            List<Integer> answer = new ArrayList<>();
            traversal(root);
            //if(array.size() == 1 && k == 1)return array;

            for (Integer integer : array) {

                if (compare.containsKey(Math.abs(target - integer))) {
                    compare.get(Math.abs(target - integer)).add(integer);
                    if (!difference.contains(Math.abs(target - integer)))
                        difference.add(Math.abs(target - integer));
                } else {
                    compare.put(Math.abs(target - integer), new ArrayList<Integer>());
                    compare.get(Math.abs(target - integer)).add(integer);
                    if (!difference.contains(Math.abs(target - integer)))
                        difference.add(Math.abs(target - integer));
                }

            }
            Collections.sort(difference);
            int j = 0;
            while(answer.size()< k){

                for(int a : compare.get(difference.get(j))){
                    answer.add(a);
                }
                // compare.remove(difference.get(j));
                j++;
            }
            System.out.print(difference);
            System.out.print(array);

            return answer;
        }

        public void traversal(TreeNode root){
            if(root == null)return;
            array.add(root.val);
            traversal(root.left);
            traversal(root.right);
        }
    }

}
