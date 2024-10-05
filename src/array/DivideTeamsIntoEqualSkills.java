package array;

import java.util.Arrays;

public class DivideTeamsIntoEqualSkills {

    public static long dividePlayers(int[] skill) {
        int n = skill.length;

        Arrays.sort(skill);
        int i=0;
        int j = skill.length-1;

        int prev =  skill[i] + skill[j];
        long ans = 0;
        while(i < j){
            int sum = skill[i] + skill[j];
            if(sum != prev) return -1;

            ans += (long) skill[i] * skill[j];
            i++;
            j--;
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
