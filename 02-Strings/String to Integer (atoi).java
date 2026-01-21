class Solution {
    public int myAtoi(String s) {
        int i=0,sign=1,result=0;
        int n=s.length();
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if(i<n && s.charAt(i)=='-'){
            sign=-1;
            i++;
        }else if(i<n && s.charAt(i)=='+'){
            i++;
        }
        while(i<n && (s.charAt(i)>='0' && s.charAt(i)<='9')){
            if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && s.charAt(i)-'0'>Integer.MAX_VALUE%10)){
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            result=result*10+s.charAt(i)-'0';
            i++;
        }
        return result*sign;
       
    }
}
