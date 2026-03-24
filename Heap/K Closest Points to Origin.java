class Triplet{
    int x, y;
    double root;
    Triplet(int x, int y, double root){
        this.root = root;
        this.x = x;
        this.y = y;
    }
}
class TripletComparator implements Comparator<Triplet>{
    public int compare(Triplet a, Triplet b){
        if(a.root > b.root) return 1;
        else if(b.root > a.root) return -1;
        return 0;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Triplet> q = new PriorityQueue<>(new TripletComparator());
        for(int[] arr : points){
            double dist = Math.sqrt((arr[0] * arr[0]) + (arr[1] * arr[1]));
            q.add(new Triplet(arr[0],arr[1],dist));
        }
        int res[][] = new int[k][2];
        int index = 0;
        while(k > 0){
            res[index][0] = q.peek().x;
            res[index][1] = q.peek().y;
            index++;
            k--;
            q.remove();
        }
        return res; 
    }
}
