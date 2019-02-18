/*leedcode #207 course schedule
**BFS解法
**判断每个节点的入度，首先记录入度为0的点，即初始起点
**从起点出发，其可直接到达的节点入度减一，如果节点入度为0，记为下一轮的起点
**判断依据:如果存在环，则遍历到最后必然有节点入度不为0
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] arr) {
        if(numCourses==0){
            return true;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] depCount = new int[numCourses];
        for(int i=0;i<arr.length;i++){
            depCount[arr[i][1]]++;
        }
        for(int i=0;i<numCourses;i++){
            if(depCount[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int i=0;i<arr.length;i++){
                if(arr[i][0] == x){
                    depCount[arr[i][1]]--;
                }
                if(depCount[arr[i][1]] == 0){
                    queue.offer(depCount[arr[i][1]]);
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(depCount[i] != 0){
                return false;
            }
        }
        return true;
    }
}