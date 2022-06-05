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
    public Node cloneGraph(Node node) {

        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> visited = new HashMap<>();
        
        q.add(node);
    
        visited.put(node, new Node(node.val, new ArrayList<>()));        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            for(Node neighborNode : curr.neighbors) {
                if(!visited.containsKey(neighborNode)) {
                    visited.put(neighborNode, new Node(neighborNode.val, new ArrayList<>()));
                    q.add(neighborNode);
                }
                visited.get(curr).neighbors.add(visited.get(neighborNode));
            }
        }
        return visited.get(node);
    }
    
    
}