/*leetcode #228 Summary Ranges
*/
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int i=0;
        while(i<nums.length){
            i = solution(result,nums,nums[i],nums[i],i+1);
        }
        return result;
    }
    
    public int solution(List<String> result,int[] nums,int start,int current,int pos){
        if(pos>=nums.length || nums[pos] != current+1){
            if(current == start){
                result.add(String.valueOf(start));
            }else{
                result.add(String.valueOf(start)+"->"+String.valueOf(current));
            }
            return pos;
        }
        return solution(result,nums,start,current+1,pos+1);
    }
}