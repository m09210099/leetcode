/*leetcode #221 Maximal Square
**动态规划算法
**从左上开始遍历，对于每一个正方形，只需看其右边与下边是否全为1
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int arrLen = matrix.length;
        int result = 0;
        for(int i=0;i<arrLen;i++){
            int len = matrix[i].length;
            for(int j=0;j<len;j++){
                if(matrix[i][j] == '1'){
                    int tmp = solution(matrix,j,j,i,i);
                    if(tmp > result){
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }
    
    public int solution(char[][] matrix,int ls,int le,int us,int ue){
        if(ue >= matrix.length-1 || le >= matrix[0].length-1){
            return (le-ls+1)*(le-ls+1);
        }
        for(int i=us;i<=ue+1;i++){
            if(matrix[i][le+1] == '0'){
                return (le-ls+1)*(le-ls+1);
            }
        }
        for(int i=ls;i<=le;i++){
            if(matrix[ue+1][i] == '0'){
                return (le-ls+1)*(le-ls+1);
            }
        }
        return solution(matrix,ls,le+1,us,ue+1);
    }
}