package leetCodeContest.Weekly416;

import java.util.HashSet;

public class ReportSpamMessage {
    public static boolean reportSpam(String[] message, String[] bannedWords) {

        HashSet<String> mp2 = new HashSet<>();

        for(int i =0; i<bannedWords.length; i++){
            mp2.add(bannedWords[i]);
        }

        int cnt =0;
        for(int i=0; i<message.length; i++){
            if(mp2.contains(message[i])) cnt++;
            if(cnt >=2) return true;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
