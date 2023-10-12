import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class EscapeTest202388893 {

    @Test
    public void EscapeTest202388893() {
        // Define a valid maze with an escape route
        char[][] maze = {
                {'-', '-', 'W', '-', '-'},
                {'-', 'E', 'W', '-', '-'},
                {'-', 'W', 'X', '-', '-'},
                {'-', '-', '-', '-', '-'}
        };

        // Call the MazeEscape.escape method
        List<int[]> path = EscapeImpl.escape(maze);
        // Verify that a valid path is found
        assertNotNull(path);

        // Define the expected path coordinates (from exit to exit)
        int[][] expectedPath = {{1, 1}, {0, 1}, {0, 0}, {1, 0}, {2, 0}, {3, 0}, {3, 1}, {3, 2}, {2, 2}};

        // Verify that the actual path matches the expected path
        assertEquals(expectedPath.length, path.size());
        for (int i = 0; i < expectedPath.length; i++) {
            assertArrayEquals(expectedPath[i], path.get(i));
        }
        System.out.println("[(2, 2), (3, 2), (3, 1), (3, 0), (2, 0), (1, 0), (0, 0), (0, 1), (1,1)]");
    }

    @Test
    public void testEscapeValid2Maze() {
        // Define a valid maze with an escape route
        char[][] maze = {
                {'-', '-', 'W', '-', '-'},
                {'-', 'E', 'W', '-', '-'},
                {'-', 'W', '-', 'W', '-'},
                {'-', '-', '-', '-', 'X'}
        };

        List<int[]> path = EscapeImpl.escape(maze);

        // Verify that a valid path is found
        assertNotNull(path);

        // Define the expected path coordinates (from exit to exit)
        int[][] expectedPath = {{1, 1}, {0, 1}, {0, 0}, {1, 0}, {2, 0}, {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}};

        // Verify that the actual path matches the expected path
        assertEquals(expectedPath.length, path.size());
        for (int i = 0; i < expectedPath.length; i++) {
            assertArrayEquals(expectedPath[i], path.get(i));
        }
        System.out.println("[(3, 4), (3, 3), (3, 2), (3, 1), (3, 0), (2, 0), (1, 0), (0, 0), (0, 1), (1,1)]");

    }

    @Test
    public void testNoEscape() {
        // Define a maze with no escape route
        char[][] maze = {
                {'-', '-', 'W', '-', '-'},
                {'-', 'E', 'W', 'X', '-'},
                {'-', 'W', 'W', '-', '-'},
                {'-', '-', 'W', '-', '-'}
        };

        // Call the MazeEscape.escape method
        List<int[]> path = EscapeImpl.escape(maze);

        // Verify that no valid path is found (should be null)
        assertNull(path);

        System.out.println("There is no way to exit");

    }

}
