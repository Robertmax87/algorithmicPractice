package DFS;

import java.util.ArrayList;

public class TreeToLinkedList {
    /**
     * Given the root of a binary tree, flatten the tree into a "linked list":
     *The "linked list" should use the same TreeNode class where the right child pointer
     * points to the next node in the list and the left child pointer is always null.
     * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
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

    ArrayList<Integer> rootList = new ArrayList<>();

    public void flatten(TreeNode root) {
        //Do an in order traversal to populate an array and then make a tree populated with
        //the nodes, left will be set to null always, right will be the next node in the list

        preOrder(root);
        int iterator = 0;
        TreeNode returner = new TreeNode();
        while(iterator < rootList.size()){



            root.val = rootList.get(iterator);
            root.left = null;
            iterator++;
            if(iterator == rootList.size())break;
            root.right = new TreeNode();
            root = root.right;

        }

    }

    public void preOrder(TreeNode root){
        if(root == null)return;
        rootList.add(root.val);
        preOrder(root.left);

        preOrder(root.right);

    }
}
