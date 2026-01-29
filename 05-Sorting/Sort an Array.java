class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public void mergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    public void merge(int[] arr,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int[] l1=new int[n1];
        int[] l2=new int[n2];
        for(int i=0;i<n1;i++){
            l1[i]=arr[left+i];
        }
        for(int j=0;j<n2;j++){
            l2[j]=arr[mid+1+j];
        }
        int i=0,j=0,ctr=left;
        while(i<n1 && j<n2){
            if(l1[i]<l2[j]){
                arr[ctr]=l1[i];
                i++;
            }else{
                arr[ctr]=l2[j];
                j++;
            }
            ctr++;
        }
        while(i<n1){
            arr[ctr]=l1[i];
            i++;
            ctr++;
        }
        while(j<n2){
            arr[ctr]=l2[j];
            j++;
            ctr++;
        }
    }
}
