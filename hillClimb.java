//
public class hillClimb {

    // public static void toString(province){

    // }

    // main loop
    // decides which successor to pick
    // decide when to stop (two situations, could be good or bad)
    // Do we keep a running total of the action cost along the way.
    public static void hillClimbSearch(int[][] matrix, char[] state) {
        System.out.println("Hill Climb Start");
    }

    // builds every state reachable with one action
    // RESULT returns a copy that we can change
    public static void successors(char[] state) {

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
                    System.out.println("New Neighbour for: " + i + ": " + j);
                    if (state[i] == state[j]) {
                        count++;
                        System.out.println("Matching colour found, count increased: " + count);
                    }
                }
            }
        }
        return count;
    }

    public static int cost(char colour) {
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
                return 0;
        }
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
    }
}
