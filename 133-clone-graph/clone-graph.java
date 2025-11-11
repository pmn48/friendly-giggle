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
        if (node == null) return null;
        if (node.neighbors.isEmpty()) return new Node(node.val);

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        // add the root node to queue
        queue.add(node);
        // add the clone of the root to visited map
        Node cloneRoot = new Node(node.val);
        visited.put(node, cloneRoot);

        // BFS
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // find the clone of current node in Map
            Node clone = visited.get(cur);

            // traverse neighbor lists
            for (Node nei: cur.neighbors) {
                // make clone for each neighbor and put it in map if not existed
                // or take from Map
                // if not visited, add to queue so it can be inspected later
                if (!visited.containsKey(nei)) {
                    queue.add(nei);
                    visited.put(nei, new Node(nei.val));
                }
                // add to neighbors list of clone
                clone.neighbors.add(visited.get(nei));
            }
        }
        return visited.get(node); // return the clone of root node
    }
}

// each node comes with a list of neighbors
// Implement a VISTED map: can call for cloned node
//  BFS: 
// from node v, make a clone node v' and put it to VISITED MAP
// pop node v from queue
// traverse v's list of neighbor, put them in a queue if NOT visited. at the same time clone the neighbors, put them to VISITED MAP if not exist yet
// put the cloned neighbors to neighbor list of cloned v'
//  repeat until queue is empty and return cloned root