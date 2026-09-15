import java.util.*;

class Solution {
    // Helper class to track original edge indices
    static class Edge {
        int to, weight, id;
        Edge(int to, int weight, int id) {
            this.to = to;
            this.weight = weight;
            this.id = id;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        List<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            adj[u].add(new Edge(v, w, i));
            adj[v].add(new Edge(u, w, i));
        }

        // 1. Find standard MST weight
        int baseMstWeight = getMstWeight(n, adj, -1, null);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        // 2. Evaluate each edge
        for (int i = 0; i < m; i++) {
            // Check Critical: exclude edge i
            int weightWithout = getMstWeight(n, adj, i, null);
            if (weightWithout > baseMstWeight) {
                critical.add(i);
            } else {
                // Check Pseudo-Critical: force include edge i
                int weightWith = getMstWeight(n, adj, -1, edges[i]);
                if (weightWith == baseMstWeight) {
                    pseudoCritical.add(i);
                }
            }
        }

        return Arrays.asList(critical, pseudoCritical);
    }

    private int getMstWeight(int n, List<Edge>[] adj, int ignoreEdgeId, int[] forcedEdge) {
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [weight, node]
        
        int totalWeight = 0;
        int visitedCount = 0;

        // If an edge is forced, mark both endpoints as visited immediately
        if (forcedEdge != null) {
            int u = forcedEdge[0], v = forcedEdge[1], w = forcedEdge[2];
            visited[u] = true;
            visited[v] = true;
            totalWeight += w;
            visitedCount = 2;

            // Add all outgoing edges from both endpoints
            addEdges(u, adj, visited, pq, ignoreEdgeId);
            addEdges(v, adj, visited, pq, ignoreEdgeId);
        } else {
            // Standard start from node 0
            visited[0] = true;
            visitedCount = 1;
            addEdges(0, adj, visited, pq, ignoreEdgeId);
        }

        while (!pq.isEmpty() && visitedCount < n) {
            int[] curr = pq.poll();
            int w = curr[0], u = curr[1];

            if (visited[u]) continue;

            visited[u] = true;
            totalWeight += w;
            visitedCount++;

            addEdges(u, adj, visited, pq, ignoreEdgeId);
        }

        // Return Integer.MAX_VALUE if graph cannot be fully connected
        return visitedCount == n ? totalWeight : Integer.MAX_VALUE;
    }

    private void addEdges(int u, List<Edge>[] adj, boolean[] visited, PriorityQueue<int[]> pq, int ignoreEdgeId) {
        for (Edge e : adj[u]) {
            if (e.id != ignoreEdgeId && !visited[e.to]) {
                pq.offer(new int[]{e.weight, e.to});
            }
        }
    }
}