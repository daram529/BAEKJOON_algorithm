import java.util.*;
import java.io.*;


/**
 * 백준 삼성 기출 문제 14502번 '퇴사'
 * https://www.acmicpc.net/problem/14501
 */


public class resignation {

    static int N;
    static int[] P = new int[16];
    static int[] T = new int[16];
    static int[] dp = new int[30];
    static final int INF = 100000000;

    static {
        Arrays.fill(dp, 0);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        String[] tokens;

        for (int i = 0; i < N; i ++)
        {
            tokens = bf.readLine().split(" ");
            T[i] = Integer.parseInt(tokens[0]);
            P[i] = Integer.parseInt(tokens[1]);
        }
        
        int final_profit = 0;
        for (int i = 0; i < N; i ++)
        {
            // take consult
            int next1 = i + T[i];
            // not take consult
            int next2 = i + 1;

            if (next1 <= N) dp[next1] = Math.max(dp[next1], dp[i] + P[i]);
            if (next2 <= N) dp[next2] = Math.max(dp[next2], dp[i]);

            final_profit = Math.max(Math.max(final_profit, dp[next1]), dp[next2]);
        }
        //System.out.println("---------------");
        //for (int i = 0; i < N+1; i ++)
        System.out.println(dp[N]);
        System.out.println(final_profit);

        
    }
}
