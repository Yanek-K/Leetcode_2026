//                       0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19
//  0 Arad              0   0   0   0   0   0   0   0   0   0   0   0   0   0   0 140 118   0   0  75
//  1 Bucharest         0   0   0   0   0 211  90   0   0   0   0   0   0 101   0   0   0  85   0   0
//  2 Craiova           0   0   0 120   0   0   0   0   0   0   0   0   0 138 146   0   0   0   0   0
//  3 Dobreta           0   0 120   0   0   0   0   0   0   0  75   0   0   0   0   0   0   0   0   0
//  4 Eforie            0   0   0   0   0   0   0  86   0   0   0   0   0   0   0   0   0   0   0   0
//  5 Fagaras           0 211   0   0   0   0   0   0   0   0   0   0   0   0   0  99   0   0   0   0
//  6 Giurgiu           0  90   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
//  7 Hirsova           0   0   0   0  86   0   0   0   0   0   0   0   0   0   0   0   0  98   0   0
//  8 Iasi              0   0   0   0   0   0   0   0   0   0   0  87   0   0   0   0   0   0  92   0
//  9 Lugoj             0   0   0   0   0   0   0   0   0   0  70   0   0   0   0   0 111   0   0   0
// 10 Mehadia           0   0   0  75   0   0   0   0   0  70   0   0   0   0   0   0   0   0   0   0
// 11 Neamt             0   0   0   0   0   0   0   0  87   0   0   0   0   0   0   0   0   0   0   0
// 12 Oradea            0   0   0   0   0   0   0   0   0   0   0   0   0   0   0 151   0   0   0  71
// 13 Pitesti           0 101 138   0   0   0   0   0   0   0   0   0   0   0  97   0   0   0   0   0
// 14 Rimnicu Vilcea    0   0 146   0   0   0   0   0   0   0   0   0   0  97   0  80   0   0   0   0
// 15 Sibiu           140   0   0   0   0  99   0   0   0   0   0   0 151   0  80   0   0   0   0   0
// 16 Timisoara       118   0   0   0   0   0   0   0   0 111   0   0   0   0   0   0   0   0   0   0
// 17 Urziceni          0  85   0   0   0   0   0  98   0   0   0   0   0   0   0   0   0   0 142   0
// 18 Vaslui            0   0   0   0   0   0   0   0  92   0   0   0   0   0   0   0   0 142   0   0
// 19 Zerind           75   0   0   0   0   0   0   0   0   0   0   0  71   0   0   0   0   0   0   0

import java.util.*;

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
                System.out.println("neighbour:" + cities[j] + " " + neighbours[row][j]);
            }
        }
    }

    static List<Integer> getNeighbours(int row) {
        List<Integer> result = new ArrayList<>();

        for (int j = 0; j < neighbours.length; j++) {
            if (neighbours[row][j] != 0) {
                result.add(j);
            }
        }

        return result;
    }

    static List<Integer> dfs(String startString, String goalString) {
        int start = indexOf(startString);
        int goal = indexOf(goalString);

        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int nextVisit = stack.pop();
            result.add(nextVisit);

            if (nextVisit == goal) {
                return result;
            }

            for (Integer neighbour : getNeighbours(nextVisit)) {
                stack.push(neighbour);
            }

        }

        return result;
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

        myNeighbour("Arad");

        dfs("Arad", "Bucharest");

    }
}