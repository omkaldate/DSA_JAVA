package RECURSION_REVISION;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }


    private static void Helper(String res,String digits,int idx,String[] phoneMap,List<String> ans){
        if(idx >= digits.length()){
            ans.add(res);
            return ;
        }

        String letters = phoneMap[digits.charAt(idx) - '0'];
        for(char ch:letters.toCharArray()){
            // res = res+ch;
            Helper(res + ch,digits,idx+1,phoneMap,ans);
            // res =res.substring(0,res.length()-1);
        }
    }


    public static List<String> letterCombinations(String digits) {

        String[] phoneMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0)return ans;

        Helper("",digits,0,phoneMap,ans);
        return ans;
    }
}
