class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int left = 0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=s){
                ans = Math.min(ans,i+1-left);
                sum -= nums[left];
                left++;
            }
        }
        return (ans != Integer.MAX_VALUE)?ans:0;
    }
}