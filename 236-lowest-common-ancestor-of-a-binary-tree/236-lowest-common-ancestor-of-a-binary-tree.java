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
    private int foundCount;
    private boolean allFound;
    private List<Integer> pathP = new ArrayList<>();
    private List<Integer> pathQ = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        foundCount = 0;
        allFound = false;
        TreeNode curr = root;
        findNode(curr, p, new ArrayList<>(), pathP);
        findNode(curr, q, new ArrayList<>(), pathQ);
        
        Set<Integer> pVisit = new HashSet<>(pathP);
        int ancestorValue = 0;
        for(int i = pathQ.size() - 1; i >= 0; i--) {
            int qItem = pathQ.get(i);
            if(pVisit.contains(qItem)){
                ancestorValue = qItem;
                break;
            }
        }
        return getNodeByVal(curr, ancestorValue);
    }
    
    private TreeNode getNodeByVal(TreeNode curr, int value) {
        if(curr == null) return null;
        if(curr.val == value) return curr;
        TreeNode leftNodeToReturn = getNodeByVal(curr.left, value);
        TreeNode rightNodeToReturn = getNodeByVal(curr.right, value);
        if(leftNodeToReturn != null) return leftNodeToReturn;
        else return rightNodeToReturn;
    }
    
    private void findNode(TreeNode curr, TreeNode target, List<Integer> tempPath, List<Integer> path) {
        if(curr == null) return;
        tempPath.add(curr.val);
        if(curr.val == target.val) {
            path.addAll(tempPath);
            return;
        }
        findNode(curr.left, target, tempPath, path);
        findNode(curr.right, target, tempPath, path);
        tempPath.remove(tempPath.size() - 1);
    }
}