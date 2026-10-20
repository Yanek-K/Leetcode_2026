import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class test {
    public static void main(String[] args) {

        // Declare a HashMap and count how many times each
        // number appears.
        //
        int[] nums = new int[10];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create a priority queue that orders by lowest count on top
        // Add each of the values in the HashMap to the PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e.getKey());
        }

    }

}
