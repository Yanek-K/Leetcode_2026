public class romania {

    static String[] cities = { "Arad", "Bucharest", "Craiova", "Dobreta", "Eforie", "Fagaras", "Giurgiu", "Hirsova",
            "Iasi", "Lugoj", "Mehadia", "Neamt", "Oradea", "Pitesti", "Rimnicu Vilcea", "Sibiu",
            "Timisoara", "Urziceni", "Vaslui", "Zerind" };

    static int[][] neighbours = new int[20][20];

    static void addRoad(String a, String b, int dist) {
        int i = indexOf(a);
        int j = indexOf(b);
        neighbours[i][j] = dist;
        neighbours[j][i] = dist;
    }

    static int indexOf(String a) {
        for (int i = 0; i < cities.length; i++) {
            if (a.equals(cities[i])) {
                return i;
            }
        }
        return -1;
    }

    static void myNeighbour(String a) {
        int row = indexOf(a);

        for (int j = 0; j < neighbours.length; j++) {
            if (neighbours[row][j] != 0) {
                System.out.println("neighbour:" + cities[j] + neighbours[row][j]);
            }
        }
    }

    public static void main(String[] args) {
        addRoad("Arad", "Zerind", 75);
        addRoad("Arad", "Sibiu", 140);
        addRoad("Arad", "Timisoara", 118);
        addRoad("Zerind", "Oradea", 71);
        addRoad("Oradea", "Sibiu", 151);
        addRoad("Timisoara", "Lugoj", 111);
        addRoad("Lugoj", "Mehadia", 70);
        addRoad("Mehadia", "Dobreta", 75);
        addRoad("Dobreta", "Craiova", 120);
        addRoad("Craiova", "Rimnicu Vilcea", 146);
        addRoad("Craiova", "Pitesti", 138);
        addRoad("Sibiu", "Fagaras", 99);
        addRoad("Sibiu", "Rimnicu Vilcea", 80);
        addRoad("Rimnicu Vilcea", "Pitesti", 97);
        addRoad("Fagaras", "Bucharest", 211);
        addRoad("Pitesti", "Bucharest", 101);
        addRoad("Bucharest", "Giurgiu", 90);
        addRoad("Bucharest", "Urziceni", 85);
        addRoad("Urziceni", "Hirsova", 98);
        addRoad("Hirsova", "Eforie", 86);
        addRoad("Urziceni", "Vaslui", 142);
        addRoad("Vaslui", "Iasi", 92);
        addRoad("Iasi", "Neamt", 87);

    }
}