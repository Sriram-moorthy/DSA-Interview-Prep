class Solution {
    public static ArrayList<Integer> primeFac(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2 ; i*i <= n ;i++){
            if(n%i == 0){
                if(isPrime(i)){
                    list.add(i);
                    while(n%i == 0){
                        n = n/i;
                    }
                } 
            }
        }
        if(n != 1) list.add(n);
        return list;
        
    }
    private static boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2 || n== 3) return true;
        if(n % 2 == 0 || n %3 == 0) return false;
        for(int i = 5 ; i*i <= n ; i+=6){
            if(n %i == 0 || n%(i+2) == 0) return false;
        }
        return true;
    }
}
