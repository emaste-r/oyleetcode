/**
 * Created by ouyang on 2019/5/27.
 * 198. House Robber
 *  
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *  
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *  
 * Example 1:
 *  
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *  
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *  
 * 简单的dp：
 *      dp[i] = max(dp[i-1], dp[i-2]+nums[i])
 */
public class Leetcode198_HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 34, 4}));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        // 初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        // 开始动态规划
        for (int i = 2; i < n; i++) {
            // 要么要考察i，要么放弃对i的考察，只用dp[i-1]就够了
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}

