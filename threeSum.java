
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class threeSum {

    public static List<List<Integer>> three(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // loop through the array
        // have a left pointer and a right pointer
        // check that the left + right = i,
        // if it is add it to the List of Integer Lists as a result

        // loop through the array with one number fixed
        // making it a two-pointer problem
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = nums[i] * -1;

            while (left < right) {

                if (nums[left] + nums[right] == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        continue;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                }
            }
        }
        return result;
    }

    // public static void main(String[] args) {
    // int[] nums = { -1, 0, 1, 2, -1, -4 };
    // System.out.println(threeSum(nums));

    // }
}
