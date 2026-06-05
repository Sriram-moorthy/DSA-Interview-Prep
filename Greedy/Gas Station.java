class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0;
        for(int i = 0 ; i < gas.length ; i++){
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(costSum > gasSum) return -1;

        int startIndex = 0, totalGas = 0;
        for(int i = 0 ; i < gas.length ; i++){
            totalGas += (gas[i] - cost[i]);
            if(totalGas < 0){
                startIndex = i+1;
                totalGas = 0;
            }
        }
        return startIndex;
    }
}
