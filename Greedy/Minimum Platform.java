class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count = 0, maxCount = 0;
        int i = 0, j = 0;
        while(i < arr.length){
            if(arr[i] <= dep[j]){
                count++;
                i += 1;
            }else{
                count--;
                j+=1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
        
    }
}
