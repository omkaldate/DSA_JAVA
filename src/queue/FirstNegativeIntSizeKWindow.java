package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeIntSizeKWindow {
    public static int[] printFirstNegativeInteger(int[] A, int N, int K) {

        int[] ans = new int[N - K + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            if (A[i] < 0) {
                dq.addLast(i);
            }
        }

        int index = 0;
        if (!dq.isEmpty()) {
            ans[index++] = A[dq.peekFirst()];
        } else {
            ans[index++] = 0;
        }

            for (int i = K; i < N; i++) {
                if (!dq.isEmpty() && (i - dq.peekFirst()) >= K) {
                    dq.pollFirst();
                }
                if (A[i] < 0) {
                    dq.addLast(i);
                }
                if (!dq.isEmpty()) {
                    ans[index++] = A[dq.peekFirst()];
                }
                else {
                    ans[index++] = 0;
                }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {-8, 2, 3, -6, 10};
        int N = 5;
        int K = 2;
        int[] result = printFirstNegativeInteger(A, N, K);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
