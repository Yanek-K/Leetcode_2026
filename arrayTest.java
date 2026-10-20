
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arrayTest {
    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        res.add(Arrays.asList(nums[0], nums[1], nums[2]));

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}