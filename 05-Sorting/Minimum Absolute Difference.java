class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        ArrayList<List<Integer>> list = new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            int currMin=arr[i]-arr[i-1];
            if(currMin<min){
                list=new ArrayList<>();
                min=currMin;
            }
            if(currMin==min){
                list.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return list;
    }
}
