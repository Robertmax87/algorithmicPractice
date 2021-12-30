package DFS;

import java.util.ArrayList;
import java.util.List;

public class ReturnForest {
    /**
     * Given the root of a binary tree, each node in the tree has a distinct value.
     * After deleting all nodes with a value in to_delete, we are left with a forest(a disjoint union of trees).
     * Return the roots of the trees in the remaining forest. You may return the result in any order.
     */
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
  //this is a post order traversal, we are going up the tree chopping closer to the source
    List<TreeNode> answer = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        //add the nodes to be deleted to a new list in order to use the contains method
        //we could also use a set
        List<Integer> list = new ArrayList<>();
        for(int i: to_delete){
            list.add(i);
        }
        //call our recursive method
        inOrderRemoval(root, list);
        //add the top of the tree because we set the nodes we didn't want to null
        if(!list.contains(root.val))
            answer.add(root);
        return answer;

    }
    public void inOrderRemoval(TreeNode root, List<Integer> list){
        //this is a postorder traversal
        if(root == null)return;
        inOrderRemoval(root.left,list);
        inOrderRemoval(root.right,list);
        //if the root.left or root.right is in the list of values then set them equal to null so we can potentially return the top of the tree;
        if(root.right != null && list.contains(root.right.val)){

            root.right = null;
        }

        if(root.left != null && list.contains(root.left.val)){

            root.left = null;
        }
        //return the subtrees from the target nodes
        if(list.contains(root.val)){

            if(root.right!= null)answer.add(root.right);
            if(root.left != null)answer.add(root.left);

        }

    }
}
