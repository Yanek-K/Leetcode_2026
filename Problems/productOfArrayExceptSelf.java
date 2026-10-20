package Problems;

import java.util.Arrays;

public class productOfArrayExceptSelf {

    public static int[] productArrayExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int total = 1;
            if (i == count) {
                continue;
            } else {
                total *= nums[i];
                result[i] = total;
            }
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(productArrayExceptSelf(nums)));
    }

}
