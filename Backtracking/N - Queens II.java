class Solution {
    public int totalNQueens(int n) {
        boolean[] rflag = new boolean[n];
        boolean[] d1flag = new boolean[(2*n)-1];
        boolean[] d2flag = new boolean[(2*n)-1];

        char[][] board = new char[n][n];
        for(char[] row : board) Arrays.fill(row,'.');
        
        int count = setQueens(rflag,d1flag,d2flag,board,n,0);
        return count;
    }

     public int setQueens(boolean[] rflag, boolean[] d1flag, boolean[] d2flag, char[][] board, int n, int col){

        if(col == n){
            return 1;
        }
        int count = 0;
        for(int row = 0 ; row < n ; row++){

            if(rflag[row] == false && d1flag[row + col] == false && d2flag[(n-1)+(row-col)] == false){

                board[row][col] = 'Q';
                rflag[row] = true;
                d1flag[row + col] = true;
                d2flag[(n-1)+(row - col)] = true;

                count += setQueens(rflag,d1flag,d2flag,board,n,col+1);

                board[row][col] = '.';
                rflag[row] = false;
                d1flag[row + col] = false;
                d2flag[(n-1)+(row - col)] = false;   
            }
        }

        return count;

    }
}
