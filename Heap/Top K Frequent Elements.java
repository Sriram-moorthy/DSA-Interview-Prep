class FreqComparator implements Comparator<Map.Entry<Integer, Integer>>{
    public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){
        return a.getValue() - b.getValue();
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap= new PriorityQueue<>(new FreqComparator());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int ind = 0;
        while(!minHeap.isEmpty()){
            res[ind] = minHeap.poll().getKey();
            ind++;
        }
        return res;
    }
}
