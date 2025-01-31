class Solution {
public: vector<pair<int, int>> dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int n;

    void calculateIsland(vector<vector<int>>& grid, int i, int j, vector<vector<bool>>& visited, int& area, int islandID) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) return;
        
        visited[i][j] = true;
        grid[i][j] = islandID; // Mark the island with an ID
        area++;

        for (auto [dx, dy] : dir) {
            int ni = i + dx, nj = j + dy;
            calculateIsland(grid, ni, nj, visited, area, islandID);
        }
    }

    int largestIsland(vector<vector<int>>& grid) {
        n = grid.size();
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        unordered_map<int, int> islandAreas; // islandID -> area
        int islandID = 2; // Start IDs from 2
        bool hasZero = false;

        // Step 1: Compute all island areas and assign unique IDs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) hasZero = true; // Check if at least one zero exists
                if (!visited[i][j] && grid[i][j] == 1) {
                    int area = 0;
                    calculateIsland(grid, i, j, visited, area, islandID);
                    islandAreas[islandID] = area;
                    islandID++; // Increment ID for the next island
                }
            }
        }

        // Edge case: If the grid is all 1s, return total grid size
        if (!hasZero) return n * n;

        int maxArea = 0;

        // Step 2: Try converting each 0 to 1 and compute the new area
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    set<int> seenIslands;

                    for (auto [dx, dy] : dir) {
                        int ni = i + dx, nj = j + dy;
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] > 1) {
                            int islandID = grid[ni][nj];
                            if (seenIslands.find(islandID) == seenIslands.end()) {
                                area += islandAreas[islandID]; // Get full island area
                                seenIslands.insert(islandID);
                            }
                        }
                    }
                    maxArea = max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
};