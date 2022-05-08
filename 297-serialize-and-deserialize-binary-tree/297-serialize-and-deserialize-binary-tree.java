/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            // int qSize = q.size();
            // for(int i = 0; i < qSize; i++) {
                TreeNode currNode = q.poll();
                Integer currVal = currNode == null ? null : currNode.val;
                arr.add(currVal);
                
                if(currNode != null) {
                    q.add(currNode.left);
                    q.add(currNode.right);
                }
            // }
        }
        return arr.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() -1);
        
        String[] arr = data.split(", ");
        if(arr.length == 0 || arr[0].equals("null")) return null;
        List<Integer> list = new ArrayList<>();
        for(String item : arr) {
            if(item.equals("null")) list.add(null);
            else list.add(Integer.valueOf(item));
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int index = 1;
        
        while(index < arr.length && !q.isEmpty()) {
            TreeNode curr = q.poll();
            if(list.get(index) != null && index < arr.length) {
                TreeNode left = new TreeNode(list.get(index));
                curr.left = left;
                q.add(left);
            }
            index++;
            if(list.get(index) != null && index < arr.length) {
                TreeNode right = new TreeNode(list.get(index));
                curr.right = right;
                q.add(right);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));