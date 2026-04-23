class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < edges.length; i++) {
            int rootU = find(parent, edges[i][0]);
            int rootV = find(parent, edges[i][1]);
            
            if (rootU != rootV) {
                parent[rootU] = rootV;
            }
        }
        
        return find(parent, source) == find(parent, destination);
    }
    
    private int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        
        parent[node] = find(parent, parent[node]);
        return parent[node];
    }
}
