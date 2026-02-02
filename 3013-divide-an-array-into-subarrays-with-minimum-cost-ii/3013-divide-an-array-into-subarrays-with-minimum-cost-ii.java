class Multiset {
  public void add(int num) {
    map.merge(num, 1, Integer::sum);
    ++sz;
  }

  public void remove(int num) {
    map.merge(num, -1, Integer::sum);
    if (map.get(num) == 0)
      map.remove(num);
    --sz;
  }

  public int min() {
    return map.firstEntry().getKey();
  }

  public int max() {
    return map.lastEntry().getKey();
  }

  public int size() {
    return sz;
  }

  public boolean contains(int num) {
    return map.containsKey(num);
  }

  private TreeMap<Integer, Integer> map = new TreeMap<>();
  private int sz = 0;
}

class Solution {
  public long minimumCost(int[] nums, int k, int dist) {
    long windowSum = 0;
    Multiset selected = new Multiset();
    Multiset candidates = new Multiset();

    for (int i = 1; i <= dist + 1; ++i) {
      windowSum += nums[i];
      selected.add(nums[i]);
    }

    windowSum = balance(windowSum, selected, candidates, k);
    long minWindowSum = windowSum;

    for (int i = dist + 2; i < nums.length; ++i) {
      final int outOfScope = nums[i - dist - 1];
      if (selected.contains(outOfScope)) {
        windowSum -= outOfScope;
        selected.remove(outOfScope);
      } else {
        candidates.remove(outOfScope);
      }
      if (nums[i] < selected.max()) { 
        windowSum += nums[i];
        selected.add(nums[i]);
      } else {
        candidates.add(nums[i]);
      }
      windowSum = balance(windowSum, selected, candidates, k);
      minWindowSum = Math.min(minWindowSum, windowSum);
    }

    return nums[0] + minWindowSum;
  }

  private long balance(long windowSum, Multiset selected, Multiset candidates, int k) {
    while (selected.size() < k - 1) {
      final int minCandidate = candidates.min();
      windowSum += minCandidate;
      selected.add(minCandidate);
      candidates.remove(minCandidate);
    }
    while (selected.size() > k - 1) {
      final int maxSelected = selected.max();
      windowSum -= maxSelected;
      selected.remove(maxSelected);
      candidates.add(maxSelected);
    }
    return windowSum;
  }
}