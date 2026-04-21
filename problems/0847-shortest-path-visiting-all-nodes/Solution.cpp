#include <vector>
#include <queue>
#include <tuple>

class Solution {
public:
    int shortestPathLength(std::vector<std::vector<int>>& graph) {
        int n = graph.size();
        if (n == 1) return 0;

        int finalState = (1 << n) - 1;
        std::queue<std::pair<int, int>> q;
        std::vector<std::vector<bool>> visited(n, std::vector<bool>(1 << n, false));

        for (int i = 0; i < n; i++) {
            q.push({i, 1 << i});
            visited[i][1 << i] = true;
        }

        int steps = 0;
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                auto [u, mask] = q.front();
                q.pop();

                if (mask == finalState) return steps;

                for (int v : graph[u]) {
                    int nextMask = mask | (1 << v);
                    if (!visited[v][nextMask]) {
                        visited[v][nextMask] = true;
                        q.push({v, nextMask});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
};