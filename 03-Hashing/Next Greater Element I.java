class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        int max=0,index=0;
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        for(int i=0;i<nums1.length;i++){
            index=map.get(nums1[i]);
            max=nums1[i];
            for(int j=index+1;j<nums2.length;j++){
                max=Math.max(max,nums2[j]);
                if(max!=nums1[i]){
                    arr[i]=max;
                    break;
                }
            }
            if(max==nums1[i]){
                arr[i]=-1;
            }
        }
        return arr;
    }
}
