import java.util.ArrayList;
import java.util.List;

public class EscapeImpl {

    public static List<int[]> escape(char[][] maze) {
        int numRows = maze.length;
        int numCols = maze[0].length;

        // Find the entrance and exit coordinates
        int[] entrance = null;
        int[] exit = null;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (maze[i][j] == 'E') {
                    entrance = new int[]{i, j};
                } else if (maze[i][j] == 'X') {
                    exit = new int[]{i, j};
                }
            }
        }

        // If entrance or exit is not found, return null
        if (entrance == null || exit == null) {
            return null;
        }

        List<int[]> path = new ArrayList<>();
        boolean[][] visited = new boolean[numRows][numCols];

        // Call the recursive EscapeImpl function
        if (EscapeImpl(maze, entrance[0], entrance[1], exit[0], exit[1], visited, path)) {
            // Print the path
            printPath(path);
            return path;
        } else {
            // No escape route found
            return null;
        }
    }

    // we can show the path here too
    private static void printPath(List<int[]> path) {

//        System.out.println("Path from exit to entrance:");
//        for (int[] coord : path) {
//            System.out.println("(" + coord[0] + ", " + coord[1] + ")");
//        }
    }

    private static boolean EscapeImpl(char[][] maze, int row, int col, int exitRow, int exitCol,
                               boolean[][] visited, List<int[]> path) {
        int numRows = maze.length;
        int numCols = maze[0].length;

        // Check if the current cell is out of bounds or a wall or already visited
        if (row < 0 || row >= numRows || col < 0 || col >= numCols
                || maze[row][col] == 'W' || visited[row][col]) {
            return false;
        }

        // Add the current cell to the path
        path.add(new int[]{row, col});
        visited[row][col] = true;

        // Check if the exit is reached
        if (row == exitRow && col == exitCol) {
            return true;
        }

        // Try moving in all four directions
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            if (EscapeImpl(maze, newRow, newCol, exitRow, exitCol, visited, path)) {
                return true; // If a valid path is found, return true
            }
        }

        // If none of the directions lead to the exit, backtrack
        path.remove(path.size() - 1);
        return false;
    }
}
