class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, rightSum = 0, maxSum = 0;
        for(int i = 0 ;i < k ;i++){
            leftSum += cardPoints[i];
            maxSum = Math.max(maxSum, leftSum);
        }
        int leftPointer = k-1, rightPointer = cardPoints.length - 1;
        while(k > 0){
            leftSum = leftSum - cardPoints[leftPointer];
            rightSum = rightSum + cardPoints[rightPointer];
            maxSum = Math.max(maxSum, (leftSum + rightSum));
            leftPointer--;
            rightPointer--;
            k--;
        }
        return maxSum;
    }
}
