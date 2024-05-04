package TwoPointers;

import java.util.Arrays;

public class boatsToSavePeople {
    public static void main(String[] args){
        int[]people = {3,2,2,1};
        int limit = 3;
        System.out.println(numRescueBoats(people , limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);
        int s = 0;
        int e = people.length - 1;

        while (s <= e) {
            while ((s <= e) && people[s] == limit) {
                boat++;
                s++;
            }
            while ((s <= e) && (people[e] == limit)) {
                boat++;
                e--;
            }
            if ((s != e) && (people[s] + people[e]) <= limit) {
                boat++;
                s++;
                e--;
            } else {
                e--;
                boat++;
            }

        }
        return boat;
    }
}
