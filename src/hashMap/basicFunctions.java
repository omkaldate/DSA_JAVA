package hashMap;
import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;

public class basicFunctions {
    public static void main(String[] args){

        HashMap<String , Integer> mp = new HashMap<>();

        mp.put("a" , 100);
        mp.put("b" , 200);
        mp.put("c" , 300);

        System.out.println(mp);
        System.out.println(mp.getOrDefault("a", -1));

       System.out.println(mp.containsKey("a"));

        for(Map.Entry<String ,Integer> i : mp.entrySet()){
         System.out.println(i.getKey());
         System.out.println(i.getValue());
         System.out.println(i);
       }

        mp.remove("a");
        System.out.println(mp);



    }
}
