class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    String row=board[i][j]+"row"+i;
                    String col=board[i][j]+"col"+j;
                    String box=board[i][j]+"box"+i/3+"and"+j/3;

                    map.put(row,map.getOrDefault(row,0)+1);
                    map.put(col,map.getOrDefault(col,0)+1);
                    map.put(box,map.getOrDefault(box,0)+1);

                    if(map.get(row)>1 || map.get(col)>1 || map.get(box)>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
