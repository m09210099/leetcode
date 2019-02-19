class Solution {
    public int[] findOrder(int numCourses, int[][] arr) {
        int[] result = new int[numCourses];
        if(arr.length == 0){
            for(int i=0;i<numCourses;i++){
                result[i] = i;
            }
            return result;
        }
        int[] depends = new int[numCourses];
        
        List<Integer> temp = new ArrayList<Integer>();
        Queue<Integer> freeCourses = new LinkedList<Integer>();
        for(int i=0;i<arr.length;i++){
            depends[arr[i][0]]++;
        }
        for(int i=0;i<depends.length;i++){
            if(depends[i] == 0){
                freeCourses.offer(i);
            }
        }
        while(!freeCourses.isEmpty()){
            int course = freeCourses.poll();
            temp.add(course);
            for(int i=0;i<arr.length;i++){
                if(arr[i][1]==course){
                    depends[arr[i][0]]--;
                    if(depends[arr[i][0]] == 0){
                        freeCourses.offer(arr[i][0]);
                    }
                }
            }
        }
        if(temp.size() == numCourses){
            for(int i=0;i<numCourses;i++){
                result[i] = temp.get(i);
            }
        }else{
            return new int[0];
        }
        return result;
    }
}