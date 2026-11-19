//
public class hillClimb {

    // public static void toString(province){

    // }
    // public static void change_colour(province, newColour){}

    // public static void cost(state, action, newState) {}

    public static void heuristic() {

    }

    public static int cost(Character colour) {
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
        int[][] adjacency_matrix = {
                // BCABSKMBONQCNBNSPEINLNUNTYT
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
        Character[] initialState = { 'b', 'o', 'o', 'o', 'r', 'r', 'j', 'j', 'j', 'j', 'j', 'j', 'j' };

    }
}
