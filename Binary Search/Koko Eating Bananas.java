class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxElement=Integer.MIN_VALUE;
        for(int num:piles){
            maxElement=Math.max(maxElement,num);
        }
        int low=1,high=maxElement;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(belowThreshold(piles,mid,h)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public boolean belowThreshold(int[] piles,int num, int h){
        long totalHours=0;
        for(int i=0;i<piles.length;i++){
           totalHours+= piles[i]/num + (piles[i]%num!=0 ? 1:0); 
        }
        return totalHours <= h;
    }
}
