/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

  List<TreeNode> pTrace = new ArrayList<>();
  List<TreeNode> qTrace = new ArrayList<>();
  Set<Integer> pTrace2 = new HashSet<>();

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if(root == null) return null;
    List<TreeNode> trace = new ArrayList<>();

    trace.add(root);
    dfs(root, p, q, trace);


//    for(int i = 0; i< pTrace.size(); i++) {
//      System.out.println("ptrace is " + pTrace.get(i));
//    }
//
//    for(int j = 0; j < qTrace.size(); j++) {
//      System.out.println("qTrace is " + qTrace.get(j));
//    }

    for(int k = qTrace.size()-1; k>=0; k--) {
      if(pTrace2.contains(qTrace.get(k).val)) {
        return qTrace.get(k);
      }
    }
    return null;
  }

  private void dfs(TreeNode currNode, TreeNode p, TreeNode q, List<TreeNode> trace) {

    if(currNode.val == p.val) {
      pTrace = List.copyOf(trace);
      for(TreeNode ancestorq : trace) {
        pTrace2.add(ancestorq.val);
      }
    }
    else if(currNode.val == q.val) {
      qTrace = List.copyOf(trace);
    }

    if(currNode.left != null) {
      trace.add(currNode.left);
      dfs(currNode.left, p, q, trace);
      trace.remove(trace.size()-1);
    }

    if(currNode.right != null) {
      trace.add(currNode.right);
      dfs(currNode.right, p, q, trace);
      trace.remove(trace.size()-1);
    }
    return;
  }
}