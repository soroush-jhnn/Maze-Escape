import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;


public class EscapeTest202388893 {
    private final Escape escape = new EscapeImpl();

    final char[][] maze1 = new char[][] {
        {' ', ' ', ' ', ' ', ' '},
        {' ', 'E', 'W', 'W', ' '},
        {' ', 'W', 'X', ' ', ' '},
        {' ', ' ', ' ', ' ', ' '},
    };

    @Test
    public void testCase1() {
        final List<Pair<Integer, Integer>> result = escape.escape(maze1);
        assertEquals(true, testPath(result, maze1));
    }

    // test 2: I've added a new test method named testSingleEntrance.
    // This method iterates through the maze1 and counts the number of entrance points ('E').
    // It then uses the assertEquals method to verify that the entrance count is equal to 1,
    // ensuring that there's only one entrance in the maze.
    @Test
    public void testSingleEntrance() {
        int entranceCount = 0;
        for (int i = 0; i < maze1.length; i++) {
            for (int j = 0; j < maze1[0].length; j++) {
                if (maze1[i][j] == 'E') {
                    entranceCount++;
                }
            }
        }
        assertEquals(1, entranceCount);
    }

    // I've added a new test method named testSingleExit.
    // This method counts the number of exit points ('X') in the maze1
    // and uses assertEquals to ensure that there's only one exit in the maz
    @Test
    public void testSingleExit() {
        int exitCount = 0;
        for (int i = 0; i < maze1.length; i++) {
            for (int j = 0; j < maze1[0].length; j++) {
                if (maze1[i][j] == 'X') {
                    exitCount++;
                }
            }
        }
        assertEquals(1, exitCount);
    }

    private boolean testPath(List<Pair<Integer, Integer>> path, char[][] maze) {
        final Pair<Integer, Integer> exitCoordinate = path.remove(0);
        if (maze[exitCoordinate.first][exitCoordinate.second] != 'X') {
            return false;
        }
        while(path.size() > 1) {
            final Pair<Integer, Integer> coordinate = path.remove(0);
            if (maze[coordinate.first][coordinate.second] != ' ') {
                return false;
            }
        }
        final Pair<Integer, Integer> entranceCoordinate = path.remove(0);
        if (maze[entranceCoordinate.first][entranceCoordinate.second] != 'E') {
            return false;
        }
        return true;
    }
}
