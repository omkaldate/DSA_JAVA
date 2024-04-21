package string;

public class CheckprefixWord {
    public static void main(String[] args){
        String sentence= "i love eating burger";
        String searchWord = "burg";
        int ans =isPrefixOfWord(sentence,searchWord);
        System.out.println(ans);
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] word= sentence.split(" ");
        int len = searchWord.length();

        for(int i=0; i<word.length; i++){
            if(word[i].length() >= len){
                String cmp = word[i].substring(0,len);
                if(searchWord.equals(cmp)){
                    return i+1;
                }
            }
        }
        return -1;

    }
}
