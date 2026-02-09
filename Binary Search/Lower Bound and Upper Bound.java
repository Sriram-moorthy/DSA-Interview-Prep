import java.util.*;
public class LowerBound {
    public static void main(String[] args) {
        // Lower bound means find the element which is grater than or equal to target
        // Upper bound means find the greater element than target with smallest index;
        int[] nums={1,1,2,4,5,5};
        int x=1;
        int n=nums.length;
        int res1=binarySearch(nums,x,n);
        int res2=binarySearch1(nums,x,n);
        System.out.println("Lower bound: "+res1);
        System.out.println("Upper bound: "+res2);
    }
    public static int binarySearch(int[] arr,int target,int n){
        int ans=n;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int binarySearch1(int[] arr,int target,int n){
        int ans=n;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

}
