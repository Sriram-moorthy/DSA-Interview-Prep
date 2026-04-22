class Solution {
        public List<List<Integer>> primeFactors(int[] queries) {
            List<List<Integer>> ans = new ArrayList<>();
            for(int num : queries){
                ArrayList<Integer> temp = new ArrayList<>();
               
                    
                    for(int i = 2 ; i*i <= num ; i++){
                        while(num % i == 0){
                            temp.add(i);
                            num = num/i;
                            
                        }
                    }
                    if(num != 1) temp.add(num);
                    ans.add(temp);
                
            }
            return ans;
        }
        
}
