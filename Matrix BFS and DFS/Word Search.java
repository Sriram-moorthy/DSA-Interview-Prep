class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int[][] visited = new int[row][col];
         for(int i=0 ;i<row;i++){
            for(int j=0 ; j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    if(wordSearch(board ,visited , i , j, row , col ,word,0)){
                        return true;
                    }
                }
            }
         }
         return false;
    }
    public boolean wordSearch(char[][] board, int[][] visited , int i , int j, int row , int col,String word, int ind){
        if (i < 0 || i >= row || j < 0 || j >= col ||
            visited[i][j] == 1 ||
            board[i][j] != word.charAt(ind)) {
            return false;
        }
        if(ind == word.length()-1) return true;
        visited[i][j] = 1;
        int[] rowX = {1,-1,0,0};
        int[] colY = {0,0,1,-1};

        for(int k=0 ; k<4 ;k++){
            int nr = i+rowX[k];
            int nc = j+colY[k];
            
            if(nr >=0 && nr < row && nc >= 0 && nc < col && visited[nr][nc] != 1 && board[nr][nc] == word.charAt(ind +1 )){
               if( wordSearch(board, visited, nr, nc, row,col,word,ind+1)){
                return true;
               }
            }
        }
        visited[i][j] = 0;
        return false;
        
    }
}
