package Medium;
import java.util.*;
public class SubSequenceString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = "abc";
        subSeq("",s);
        System.out.println(subSeqRet("",s));
    }
    public static void subSeq(String p,String s){
        if(s.isEmpty()){
            System.out.println(p);
            return;
        }
        subSeq(p+s.charAt(0),s.substring(1));
        subSeq(p,s.substring(1));
    }
    public static ArrayList subSeqRet(String p , String s){
        if(s.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> left = subSeqRet(p+s.charAt(0),s.substring(1));
        ArrayList<String> right = subSeqRet(p,s.substring(1));
        left.addAll(right);
        return left;
    }
}
