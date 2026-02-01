class Solution {
    public String capitalizeTitle(String title) {
        char[] arr = title.toCharArray();
        for(int i=0;i<arr.length;i++){
            int firstIndex=i;
            while(i<arr.length && arr[i]!=' '){
                arr[i]=Character.toLowerCase(arr[i]);
                i++;
            }
            if(i-firstIndex >2){
               arr[firstIndex]=Character.toUpperCase(arr[firstIndex]);
            }
        }
        return String.valueOf(arr);
    }
}
