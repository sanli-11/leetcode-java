public class SearchInsertPosition {
  public int searchInsert(int[] nums, int target) {
    if (nums.length < 1)
      return 0;

    if (target < nums[0])
      return 0;
    else if (target > nums[nums.length - 1])
      return nums.length;

    int left = 0;
    int mid = 0;
    int right = nums.length - 1;

    while (left <= right) {
      mid = left + (right - left) / 2;

      if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else
        return mid;
    }

    return left;
  }

  public static void main(String[] args) {
    SearchInsertPosition sip = new SearchInsertPosition();

    int case1Result = sip.searchInsert(new int[] { 1, 3, 5, 6 }, 0);
    int case2Result = sip.searchInsert(new int[] { 1, 3, 5, 6 }, 1);
    int case3Result = sip.searchInsert(new int[] { 1, 3, 5, 6 }, 2);
    int case4Result = sip.searchInsert(new int[] { 1, 3, 5, 6 }, 3);
    int case5Result = sip.searchInsert(new int[] { 1, 3, 5, 6 }, 4);
    int case6Result = sip.searchInsert(new int[] { 1, 3, 5, 6 }, 5);
    int case7Result = sip.searchInsert(new int[] { 1, 3, 5, 6 }, 6);
    int case8Result = sip.searchInsert(new int[] { 1, 3, 5, 6 }, 7);

    System.out.println(case1Result);
    System.out.println(case2Result);
    System.out.println(case3Result);
    System.out.println(case4Result);
    System.out.println(case5Result);
    System.out.println(case6Result);
    System.out.println(case7Result);
    System.out.println(case8Result);
  }
}
