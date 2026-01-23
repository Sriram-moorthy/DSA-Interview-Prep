class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int left=0,right=col-1;
        int top=0,bottom=row-1;
        int dir=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(top<=bottom && left<=right){
            switch(dir){
                case 0 ->{
                    for(int i=left;i<=right;i++){
                        list.add(matrix[top][i]);
                    }
                    top++;
                }
                case 1 ->{
                    for(int i=top;i<=bottom;i++){
                        list.add(matrix[i][right]);
                    }
                    right--;
                }
                case 2 ->{
                    for(int i=right;i>=left;i--){
                        list.add(matrix[bottom][i]);
                    }
                    bottom--;
                }
                case 3 ->{
                    for(int i=bottom;i>=top;i--){
                        list.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            dir=(dir+1)%4;
        }
        return list;

    }
}
