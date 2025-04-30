package JUSPAY.HackethonAElemination;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PersonWithHeighstScore {

    public static void function(HashMap<String, Integer>mpp, ArrayList<String[]>list, int maxi){
        HashMap<String , Integer> finalmpp = new HashMap<>();

        for(String []  x: list){
            String name = x[0];
            int num = Integer.parseInt(x[1]);
             finalmpp.put(name, finalmpp.getOrDefault(name, 0)+num);

             if(finalmpp.get(name) == maxi){
                 System.out.println(name + " "+ maxi);
                 return;
             }
        }
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        HashMap <String ,Integer> mpp = new HashMap<>();
        ArrayList<String[]> list = new ArrayList<>();
        int maxi = 0;

        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; i++) {
            String[] obj = sc.nextLine().split(" ");
            String name = obj[0];
            int number = Integer.parseInt(obj[1]);

            mpp.put(name, mpp.getOrDefault(name, 0) + number);
            maxi = Math.max(maxi, mpp.get(name));


            list.add(obj);
        }

        function(mpp, list, maxi);
    }
}
