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

  List<TreeNode> qTrace = new ArrayList<>();
  Set<Integer> pTraceSet = new HashSet<>();

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> trace = new ArrayList<>();
    TreeNode commonAncestor = null;
    trace.add(root);
    dfs(root, p, q, trace);
    for(int k = qTrace.size()-1; k>=0; k--) {
      if(pTraceSet.contains(qTrace.get(k).val)) {
        commonAncestor = qTrace.get(k); break;
      }
    }
    return commonAncestor;
  }

  private void dfs(TreeNode currNode, TreeNode p, TreeNode q, List<TreeNode> trace) {
    if(!qTrace.isEmpty() && !pTraceSet.isEmpty()) return;
    else if(currNode.val == p.val) {
      for(TreeNode node : trace) {
        pTraceSet.add(node.val);
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