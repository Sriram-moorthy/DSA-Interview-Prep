class Solution {
    public int[] JobScheduling(int[][] Jobs) {
        Arrays.sort(Jobs, (a,b) -> Integer.compare(b[2],a[2]));
        int maxDeadline = 0, maxProfit = 0, jobs =0;
        
        for(int[] arr : Jobs){
            maxDeadline= Math.max(maxDeadline, arr[1]);
        }
        int[] hash = new int[maxDeadline+1];
        Arrays.fill(hash,-1);

        for(int[] job : Jobs){
            int deadLine = job[1];
            int profit = job[2];

            for(int i = deadLine ; i > 0 ; i--){
                if(hash[i] == -1){
                    hash[i] = job[0];
                    maxProfit += profit;
                    jobs++;
                    break;
                }
            }
        }
        return new int[] {jobs,maxProfit};
    }
}
