import java.util.*;
class ClosestComparator implements Comparator<Integer>{
    int x;
    public ClosestComparator(int x){
        this.x = x;
    }
    public int compare(Integer a, Integer b){
        int diff = Math.abs(b-x) - Math.abs(a-x);
        if(diff == 0){
            return b-a;
        }
        return diff;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new ClosestComparator(x));
        for(int num : arr){
            q.add(num);
            if(q.size()>k){
                q.poll();
            }
        }
        List<Integer> res = new ArrayList<>(q);
        Collections.sort(res);
        return res;
    }
    
}
