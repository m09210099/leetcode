/* leetcode #200 Number of Islands
 * mark visited position
 */
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    result++;
                    markgrid(grid,i,j);
                }
            }
        }
        return result;
    }
    
    public void markgrid(char[][] grid,int x,int y){
        if (x < 0 || x >= grid.length) return;
        if (y < 0 || y >= grid[0].length) return;
        if(grid[x][y] == '1'){
            grid[x][y] = '0';
        }else{
            return;
        }
        markgrid(grid,x-1,y);
        markgrid(grid,x+1,y);
        markgrid(grid,x,y-1);
        markgrid(grid,x,y+1);
    }
}