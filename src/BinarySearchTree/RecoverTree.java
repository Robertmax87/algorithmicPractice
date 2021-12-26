package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

public class RecoverTree {

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
     public void recoverTree(TreeNode root) {
          ArrayList<Integer> array = new ArrayList<>();
          inOrderSearcher(array, root);
          ArrayList<Integer> two = new ArrayList<>();
          //find the two numbers
          ArrayList<Integer> arrayTwo = new ArrayList<>(array);
          Collections.sort(arrayTwo);
          for(int i = 0; i < array.size(); i++){
               if(two.size() == 2)break;
               if(array.get(i) != arrayTwo.get(i))two.add(array.get(i));

          }

          //repopulate the tree and swap them;
          int x = two.get(0);
          int y = two.get(1);
          inOrderSwapper(x,y,root);


     }
     public void inOrderSearcher(ArrayList<Integer> values, TreeNode root){
          if (root == null)return;
          inOrderSearcher(values, root.left);
          values.add(root.val);
          inOrderSearcher(values,root.right);
     }
     public void inOrderSwapper(int x, int y, TreeNode root){
          if(root == null)return;

          inOrderSwapper(x,y,root.left);
          if(root.val == x) root.val = y;
          else if(root.val == y) root.val =x;

          inOrderSwapper(x,y,root.right);

     }
}


