class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] indegree = new int[n];
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            list.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int[] res = new int[n];
        int ind = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            res[ind] = node;
            for(int neighbour : list.get(node)){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }  
            ind++;          
        }
        return ind == n ? res : new int[0];
    }
}
