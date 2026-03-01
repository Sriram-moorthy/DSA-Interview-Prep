class Solution {
    public int minCost(int x) {
        int cost = 0;
        int a = 0 , b=0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(x);
        while(!st.isEmpty()){
            int num = st.pop();
            if(num ==1) continue;
            a = num/2;
            b = num-a;
            cost += (a*b);

            if(a>1) st.push(a);
            if(b>1) st.push(b);
        }
        return cost;
    }
}
