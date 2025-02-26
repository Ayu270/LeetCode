class Solution {
  public int maxAbsoluteSum(int[] nums) {
    int x = Integer.MIN_VALUE;
    int a = 0;
    int b = 0;
    for (final int num : nums) {
      a = Math.max(num, a + num);
      b = Math.min(num, b + num);
      x = Math.max(x, Math.max(a, -b));
    }
    return x;
  }
}