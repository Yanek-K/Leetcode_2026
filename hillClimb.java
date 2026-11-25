//
public class hillClimb {

    static final char[] colours = { 'b', 'o', 'r', 'j' };

    // main loop
    // decides which successor to pick
    // decide when to stop (two situations, could be good or bad)
    // Do we keep a running total of the action cost along the way.
    public static void hillClimbSearch(int[][] matrix, char[] state) {
        System.out.println("Hill Climb Start");

        // While current state is not a goal state

        // Get the successors
        // Find the one with the lowest h. If none are lower, we are in a valley/plateau
        // so stop
        // Otherwise make it a current state

        // After loop, print each province with its final colour in order plus the cost.
    }

    public static char[][] successors(char[] state) {
        char[][] result = new char[state.length * (colours.length - 1)][state.length];
        int counter = 0;
        // loop through each province
        for (int i = 0; i < state.length; i++) {
            char currentColour = state[i];
            // for each of the four colours
            for (int j = 0; j < colours.length; j++) {
                if (colours[j] == currentColour) {
                    continue;
                } else {
                    char[] newState = state.clone();
                    newState[i] = colours[j];
                    result[counter] = newState;
                    counter++;
                }
            }
        }
        return result;
    }

    public static boolean isGoal(int[][] matrix, char[] state) {
        return (heuristic(matrix, state) == 0);
    }

    // Returns the number of adjacent regions that share the same colour
    public static int heuristic(int[][] matrix, char[] state) {
        int matrixLength = matrix[0].length;
        int count = 0;
        for (int i = 0; i < matrixLength; i++) {
            for (int j = i + 1; j < matrixLength; j++) {
                if (matrix[i][j] == 1) {
                    // System.out.println("New Neighbour for: " + i + ": " + j);
                    if (state[i] == state[j]) {
                        count++;
                        // System.out.println("Matching colour found, count increased: " + count);
                    }
                }
            }
        }
        return count;
    }

    public static int cost(char[] state) {
        int total = 0;
        for (int i = 0; i < state.length; i++) {
            total += costConversion(state[i]);
        }
        return total;
    }

    public static int costConversion(char colour) {
        switch (colour) {
            case 'r':
                return 2;
            case 'b':
                return 1;
            case 'o':
                return 3;
            case 'j':
                return 5;
            default:
                throw new IllegalArgumentException("This input is not allowed: " + colour);
        }
    }

    public static void stateToString(char[] state) {
        System.out.print("{");
        for (char c : state) {
            System.out.print(c + ", ");
        }
        System.out.print("}");
        System.out.println("End");
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                // BCAB.SK.MB.ON.QC.NB.NS.PE.NL.NU.NT.YT
                { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 }, // BC
                { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, // AB
                { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, // SK
                { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0 }, // MB
                { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 }, // ON
                { 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0 }, // QC
                { 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 }, // NB
                { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 }, // NS
                { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 }, // PEI
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, // NL
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0 }, // NU
                { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 }, // NT
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 } // YT
        };
        // BC AB SK MB ON QC NB NS PEI NL NU NT YT
        char[] initialState = { 'b', 'o', 'o', 'o', 'r', 'r', 'j', 'j', 'j', 'j', 'j', 'j', 'j' };

        System.out.println(heuristic(adjacencyMatrix, initialState));

        successors(initialState);
    }
}
