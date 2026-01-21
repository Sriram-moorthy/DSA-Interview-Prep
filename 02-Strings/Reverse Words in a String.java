class Solution {
    public String reverseWords(String s) {
        int n=s.length()-1;
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i<=n){
            while(i<=n && s.charAt(i)==' '){
                i++;
            }
            if(i>n) break;
            int j=i+1;
            while(j<=n && s.charAt(j)!=' '){
                j++;
            }
            String str=s.substring(i,j);
            if(sb.length()==0){
                sb.append(str);
            }else{
                sb.insert(0,str+" ");
            }
            i=j+1;
        }
        return sb.toString();
    }
}
