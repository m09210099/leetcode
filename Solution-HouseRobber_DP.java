/*leetcode #198 House Robber
**动态规划算法
**记DP[i]为到第i个房子时能抢到的最大金额
**有DP[i]=max(DP[i-2]+nums[i],DP[i-1])
**初始:DP[0]=nums[0],DP[1]=max(nums[0],nums[1])
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int tmp = b;
            b = Math.max(a+nums[i],b);
            a = tmp;
        }
        return b;
    }
}