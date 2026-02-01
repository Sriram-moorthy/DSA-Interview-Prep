class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0,right=n-1,maxArea=-1;
        while(left<=right){
            int currHeight=Math.min(height[left],height[right]);
            int width=right-left;
            int area=currHeight*width;
            maxArea=Math.max(maxArea,area);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
