import java.util.Arrays;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    if (nums.length < 1) {
      return new int[0];
    } else if (nums.length < 2) {
      if (nums[0] == target)
        return nums;
    }

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target)
          return new int[] { i, j };
      }
    }

    return new int[0];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] case1Results = solution.twoSum(new int[] { 2, 7, 11, 15 }, 9);
    int[] case2Results = solution.twoSum(new int[] { 3, 2, 4 }, 6);
    int[] case3Results = solution.twoSum(new int[] { 3, 3 }, 6);
    int[] case4Results = solution.twoSum(new int[] { 3, 2, 3 }, 6);

    System.out.println(Arrays.toString(case1Results));
    System.out.println(Arrays.toString(case2Results));
    System.out.println(Arrays.toString(case3Results));
    System.out.println(Arrays.toString(case4Results));
  }
}
