class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        if(word.length()==0) return "";
        int count=0,index=0;
        char[] arr=word.toCharArray();
        for(int i=0;i<arr.length;i++){
            count++;
            if(i+1==arr.length || arr[i+1]!=arr[i] || count>=9){
                if(count<10){
                    sb.append(String.valueOf(count)).append(arr[i]);
                }
                count=0;
            }
        }
        return sb.toString();
    }
}
