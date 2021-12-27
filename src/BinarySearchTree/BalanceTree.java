package BinarySearchTree;

import java.util.ArrayList;

public class BalanceTree {

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
    ArrayList<TreeNode> array = new ArrayList();
    public TreeNode balanceBST(TreeNode root) {

        helper(array, root);
        //call the zero indexed mid because we are populating the root from the arraylist
        return treeBalance(0, array.size() - 1);


    }
    //do an inOrder population of an array with the treeNode values
    public void helper(ArrayList<TreeNode> array, TreeNode root){
        if(root == null)return;

        helper(array, root.left);
        array.add(root);
        helper(array, root.right);
    }
    //make a new tree starting at the middle of the array and populating outwards.
    public TreeNode treeBalance( int start, int end){
        if(end < start)return null;
        //instantiate the mid
        int mid = (start + (end - start) / 2);
        //staple the root
        TreeNode root = array.get(mid);
        //its left and rights are with new restraints
        root.left = treeBalance(start, mid - 1);
        root.right = treeBalance(mid + 1, end);
        return root;



    }
}


