class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] indegree = new int[n];

        for(int[] prerequisite : prerequisites){
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int[] prerequisite : prerequisites){
                if(node == prerequisite[1]){
                    indegree[prerequisite[0]]--;

                    if(indegree[prerequisite[0]] == 0){
                        q.offer(prerequisite[0]);
                    }
                }
                
            }            
        }
        return count == n;
    }
}
