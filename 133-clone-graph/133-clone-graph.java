/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Integer, Node> cloneMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(cloneMap.containsKey(node.val)) return cloneMap.get(node.val);
        Node newNode = new Node(node.val, new ArrayList<>());
        cloneMap.put(node.val, newNode);
        List<Node> neighbors = node.neighbors;
        
        for(Node neighbor : neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return newNode;
    }
}