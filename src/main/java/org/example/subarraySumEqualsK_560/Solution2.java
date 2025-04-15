package subarraySumEqualsK_560;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
	public int subarraySum(int[] nums, int k) {
		int result = 0;

		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (sum == k) {
				result++;
			}

			if (sumMap.containsKey(sum - k)) {
				result += sumMap.get(sum - k);
			}

			if (sumMap.containsKey(sum)) {
				sumMap.put(sum, sumMap.get(sum) + 1);
			} else {
				sumMap.put(sum, 1);
			}

		}

		return result;

	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();

		int[] nums = new int[] { 1, -1, 0, 0, 0 };

		System.out.println(s.subarraySum(nums, 0));
	}
}
