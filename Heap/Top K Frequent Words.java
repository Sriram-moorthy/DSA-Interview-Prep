class WordFreqComparator implements Comparator<Map.Entry<String,Integer>>{
    public int compare(Map.Entry<String,Integer> a ,Map.Entry<String,Integer> b){
        if(a.getValue().equals(b.getValue())){
            return b.getKey().compareTo(a.getKey());
        }
        return a.getValue() - b.getValue();
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> maxHeap = new PriorityQueue<>(new WordFreqComparator());
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            res.add(0,maxHeap.poll().getKey());
        }
        return res;
    }
}
