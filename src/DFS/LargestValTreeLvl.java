package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValTreeLvl {
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
  //do bfs and add the max in each row to a list that we will return
 public List<Integer> largestValues(TreeNode root) {
 List<Integer> answer = new ArrayList();
        if(root == null)return answer;
 Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()){
  int size = queue.size();
  int max = Integer.MIN_VALUE;
  for(int i = 0; i < size; i++){
   TreeNode curr = queue.poll();

   if(curr.val > max)max = curr.val;




   if(curr.left != null)queue.offer(curr.left);
   if(curr.right != null)queue.offer(curr.right);

  }

  answer.add(max);
 }
        return answer;
}
}
