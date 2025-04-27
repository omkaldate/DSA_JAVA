package JUSPAY.HackethonA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class byGraph {

    public void makeGraph(ArrayList<ArrayList<Integer>> belowG, ArrayList<ArrayList<Integer>>aboveG, int n, int childs){
        for(int a=0; a<n; a++){
            belowG.add(new ArrayList<>());
            aboveG.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=i; j<childs; j++){
                belowG.get(i).add(j);
                aboveG.get(j).add(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lenOfTree = sc.nextInt();
        int childs = sc.nextInt();
        int lenIfQuerys = sc.nextInt();

        HashMap<String , Integer> mppsToI = new HashMap<>();
        HashMap<Integer , String> mppiToS = new HashMap<>();

        for(int i=0; i<lenOfTree; i++){
            String s = sc.next();
            mppsToI.put(s, i);
            mppiToS.put(i,s);
        }

        int[][] que= new int [lenIfQuerys][3];
        for(int i=0; i<lenIfQuerys; i++){
            String []ss = sc.nextLine().split(" ");
            que[i][0] = Integer.parseInt(ss[0]);
            que[i][1] = mppsToI.get(ss[1]);
            que[i][2] = Integer.parseInt(ss[2]);
        }

        ArrayList<ArrayList<Integer>> belowG = new ArrayList<>();
        ArrayList<ArrayList<Integer>> aboveG = new ArrayList<>();

        makeGraph(belowG,aboveG, lenOfTree, childs);

    }
}
