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
        return dfs(root, "");
    }
    
    private String dfs(TreeNode root, String str) {
        if(root == null) {
            str+="null,";
        }
        else {
            str += String.valueOf(root.val) + ",";
            str = dfs(root.left, str);
            str = dfs(root.right, str);
        }
        return str;
    } 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArr));
        return deserializeHelper(dataList);
    }
    
    private TreeNode deserializeHelper(List<String> dataList) {
        if(dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }
        
        int currRootVal = Integer.valueOf(dataList.get(0));
        TreeNode root = new TreeNode(currRootVal);
        dataList.remove(0);
        root.left = deserializeHelper(dataList);
        root.right = deserializeHelper(dataList);
        
        
        return root;
    }
    
    // private 
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));