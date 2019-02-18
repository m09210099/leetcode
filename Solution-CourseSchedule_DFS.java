/*leedcode #207 course schedule
**DFS解法
**记录每个课程的访问状态，0为未访问，1为访问中，2为访问结束
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] arr) {
        if(numCourses<=1){
            return true;
        }
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i] == 2){
                continue;
            }
            if(!DFS(visited,i,arr)){
                return false;
            }
        }
        return true;
    }
    
    public boolean DFS(int[] visited,int startPoint,int[][]arr){
        visited[startPoint] = 1;
        for(int i=0;i<arr.length;i++){
            if(arr[i][0] == startPoint){
                if(visited[arr[i][1]] == 1){
                    return false;
                }else if(visited[arr[i][1]] == 0){
                    visited[arr[i][1]] = 1;
                    if(!DFS(visited,arr[i][1],arr)){
                        return false;
                    }
                }
            }
        }
        visited[startPoint] = 2;
        return true;
    }
}