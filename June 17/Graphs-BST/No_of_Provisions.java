import java.util.*;

public class No_of_Provisions {
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int city = 0; city < n; city++) {
            if (!visited[city]) {
                dfs(isConnected, visited, city);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;

        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        No_of_Provisions solution = new No_of_Provisions();

        // Input number of cities
        System.out.print("Enter number of cities: ");
        int n = scanner.nextInt();

        // Input adjacency matrix
        int[][] isConnected = new int[n][n];
        System.out.println("Enter the adjacency matrix (" + n + "x" + n + "):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isConnected[i][j] = scanner.nextInt();
            }
        }

        // Find and display number of provinces
        int result = solution.findCircleNum(isConnected);
        System.out.println("\nNumber of provinces: " + result);

        scanner.close();
    }
}
