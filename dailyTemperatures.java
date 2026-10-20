
import java.util.*;

/*
stack.push(i);       // add to top
stack.pop();         // remove and return top
stack.peek();        // look at top
stack.isEmpty();
 */

public class dailyTemperatures {

    public static int[] dailyTemps(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int day = stack.pop();
                result[day] = i - day;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temps = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(dailyTemps(temps)));
    }

}
