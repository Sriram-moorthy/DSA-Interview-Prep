class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        if(intervals.length == 0 || intervals == null) return new int[][]{};
        
        // Sorted based on first element
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] curr : intervals){
            if(curr[0] <= end){
                end = Math.max(end, curr[1]);
            }
            else{
                list.add(new int[]{start, end});
                start = curr[0];
                end = curr[1];
            }
        }
        list.add(new int[] {start, end});
        return list.toArray(new int[list.size()][]);

        
    }
}
