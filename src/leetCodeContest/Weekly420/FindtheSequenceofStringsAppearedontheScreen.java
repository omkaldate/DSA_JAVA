package leetCodeContest.Weekly420;

import java.util.ArrayList;
import java.util.List;

public class FindtheSequenceofStringsAppearedontheScreen {

    public static List<String> stringSequence(String target) {
        List<String> list = new ArrayList<>();
        int n = target.length();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            ans.append('a');
            list.add(ans.toString());

            while (ans.charAt(i) != target.charAt(i)) {
                ans.setCharAt(i, (char)(ans.charAt(i) + 1));
                list.add(ans.toString());
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
