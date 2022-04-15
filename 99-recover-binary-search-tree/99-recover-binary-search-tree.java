/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> paths = new ArrayList<>();
    private int x = 0;
    private int y = 0;
    
    public void recoverTree(TreeNode root) {
        //  TreeNode curr -left subtree 는 모두 curr 보다 작아야 한다는 생각을 
        // 
        //  
        // 1. inOrder Traverse -> binary search tree
        // 2. -> 잘못정렬된 pair를 찾는다. 
        // 3. pair 를 swap.
        TreeNode curr = root;
        inOrder(curr);

        // [1,5(x),3,4,2(y),6] 
        // 배열을 순회하면서, 뒤바뀐 연속된 원소를 한번 만나면, x,y 로 마킹, 두번째 만났을때 , y -> 새로운 감소가 시작한 원소로 마킹. 
        // 

        int prevVal = paths.get(0);
        boolean firstUnsortedMeet = false;
        for(int i = 1; i < paths.size();  i++) {
            int currVal = paths.get(i);
            if(prevVal > currVal) {
                y = currVal;
                if(!firstUnsortedMeet) {   
                    x = prevVal;
                    firstUnsortedMeet = true;
                }
            }
            prevVal = currVal;
        }
        
        //다시 원래 트리를 순회하면서, swap을 해준다.
        curr = root;
        traverseRecover(curr);
    }
    
    private void traverseRecover(TreeNode curr) {
        
        
        if(curr != null) {
            // x를 만났으면 -> y
            
            traverseRecover(curr.left);
            if(curr.val == x) curr.val = y;
            else if(curr.val == y) curr.val = x;
            traverseRecover(curr.right);
            // y를 만났으면 -> x
        }
    }
    
    
    //1.inOrder
    private void inOrder(TreeNode curr) {
        if(curr != null) {
            inOrder(curr.left);
            paths.add(curr.val);
            inOrder(curr.right);
        }
    }
}