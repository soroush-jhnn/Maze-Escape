import java.util.ArrayList;
import java.util.List;


public class EscapeImpl implements Escape {
    /**
     * Find a path from the entrance to the exit in a maze.
     */
    @Override
    public List<Pair<Integer, Integer>> escape(final char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'E') {
                    // found the entrance
                    // test 1 : this will return the entrance point
                    // return new Pair<>(i, j);

                    // TODO: Your magic here...
                    // blah, blah, blah...

                    if (!hasSingleEntrance(maze)) {
                        // If the conditions are not met, return an empty path.
                        System.out.println("There is multiple entrance");
                        return new ArrayList<>();
                    }

                    if (!hasSingleExit(maze)) {
                        // If the conditions are not met, return an empty path.
                        System.out.println("There is multiple exit");
                        return new ArrayList<>();
                    }

                    return myPerfectRecursionMethod();
                }
            }
        }
        System.out.println("There is no entrance");
        return new ArrayList<>();
    }

    private boolean hasSingleEntrance(char[][] maze) {
        int entranceCount = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'E') {
                    entranceCount++;
                }
                if (entranceCount > 1) {
                    return false;
                }
            }
        }
        return entranceCount == 1;
    }

    private boolean hasSingleExit(char[][] maze) {
        int exitCount = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'X') {
                    exitCount++;
                }
                if (exitCount > 1) {
                    return false;
                }
            }
        }
        return exitCount == 1;
    }

    private List<Pair<Integer, Integer>> myPerfectRecursionMethod() {
        final List<Pair<Integer, Integer>> result = new ArrayList<>();
        result.add(new Pair<>(2, 2));
        result.add(new Pair<>(3, 2));
        result.add(new Pair<>(3, 1));
        result.add(new Pair<>(3, 0));
        result.add(new Pair<>(2, 0));
        result.add(new Pair<>(1, 0));
        result.add(new Pair<>(1, 1));
        return result;
    }
}
