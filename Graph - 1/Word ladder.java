class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int depth = 1;

        while(!q.isEmpty()){
            int size = q.size();
            while(size--> 0){
                String curr = q.poll();
                char[] arr = curr.toCharArray();

                for(int i = 0; i < arr.length; i++){
                    char original = arr[i];
                    for(char j = 'a'; j<='z'; j++){
                        if(j == original) continue;
                        arr[i] = j;
                        String next = new String(arr);
                        if(next.equals(endWord)) return depth +1;
                        if(set.contains(next)){
                            q.offer(next);
                            set.remove(next);
                        }
                    }
                    arr[i] = original;
                }
                
            }
            depth++;
        }
        return 0;
    }
}
