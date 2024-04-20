package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args){
        String s = "aabb";

        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        funk(0,s,path,res);
        System.out.println(res);
    }

    public static void funk(int ind ,String s, List<String>path , List<List<String>>res){
        if(ind == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=ind ;i<s.length() ; i++){
            if(isPalindrom(s,ind,i)){
                path.add(s.substring(ind,i+1));
                funk(i+1,s,path,res);
                path.remove(path.size()-1);
            }
        }
    }

    public static boolean isPalindrom(String s , int start , int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
