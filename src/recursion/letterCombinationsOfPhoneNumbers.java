package recursion;

import java.util.ArrayList;
import java.util.List;

public class letterCombinationsOfPhoneNumbers {
    private static void Helper(String res,String digits,int idx,String[] phoneMap,List<String> ans){
        if(idx >= digits.length()){
            ans.add(res);
            return ;
        }
        String letters = phoneMap[digits.charAt(idx) - '0'];
        for(int i=0;  i<letters.length();i++){
            res = res+letters.charAt(i);
            Helper(res,digits,idx+1,phoneMap,ans);
           res =res.substring(0,res.length()-1);
        }
    }


    public static List<String> letterCombinations(String digits) {
        String[] phoneMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0)return ans;

        Helper("",digits,0,phoneMap,ans);
        return ans;
    }

    public static void main(String[] args){
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
