package subarraySumEqualsK_560;

public class Solution {
	public int subarraySum(int[] nums, int k) {
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			int j = i + 1;
			while (j <= nums.length) {
				if (sum == k) {
					n++;
				}

				if (j < nums.length) {
					sum += nums[j];
				}
				j++;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		int[] nums = new int[] { 1, -1, 0 };

		System.out.println(s.subarraySum(nums, 0));
	}
}
