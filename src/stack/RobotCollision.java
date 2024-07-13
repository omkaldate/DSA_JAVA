package stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class RobotCollision {
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<>();
        List<int[]> robots = new ArrayList<>(); // pairs vector

        for (int i = 0; i < healths.length; i++){
            robots.add(new int[] { positions[i], i });
        }
        robots.sort(Comparator.comparingInt(a -> a[0])); // sorting according to position
        Stack<Integer> st = new Stack<>();
        for (int[] r : robots) {
            int pos = r[0];
            int i = r[1];
            if (directions.charAt(i) == 'R') // if goes right push it
                st.push(i);
            else {
                while (!st.isEmpty() && healths[i] > 0) { // if left goes until stack empty or it destroyed
                    int cur = st.peek(); // right side moving robot
                    int d = healths[cur] - healths[i]; // difference in health
                    if (d > 0) { // cur robot is stronger
                        healths[cur]--;
                        healths[i] = 0;
                    } else if (d < 0) { // left side moving robot is stronger
                        healths[i]--;
                        healths[cur] = 0;
                        st.pop();
                    } else { // both are equal
                        healths[i] = 0;
                        healths[cur] = 0;
                        st.pop();
                    }
                }
            }
        }
// returning health of remaining robots
        for (int i : healths){
            if (i > 0) ans.add(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[]position = {1,2,5,6};
        int[]health = {10,10,11,11};
        String directions = "RLRL";

        System.out.println(survivedRobotsHealths(position,health,directions));
    }
}
