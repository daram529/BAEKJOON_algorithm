import java.util.*;
import java.io.*;

/**
 * 백준 삼성 기출 문제 14502번 '퇴사'
 * https://www.acmicpc.net/problem/14501
 */

public class tetromino {

    static int N,M;
    static int[][] map = new int[500][500];
    static int maxSum = 0;

    static int[] x1 = {0, 1, 0, 1};
    static int[] y1 = {0, 0, 1, 1};

    static int[] x2 = {0, 0, 1, 2};
    static int[] y2 = {0, -1, -1, -1};
    static int[] x3 = {0, 1, 1, 1};
    static int[] y3 = {0, 0, 1, 2};
    static int[] x4 = {0, 0, -1, -2};
    static int[] y4 = {0, 1, 1, 1};
    static int[] x5 = {0, -1, -1, -1};
    static int[] y5 = {0, 0, -1, -2};

    static int[] x16 = {0, 0, 1, 2};
    static int[] y16 = {0, 1, 1, 1};
    static int[] x17 = {0, -1, -1, -1};
    static int[] y17 = {0, 0, 1, 2};
    static int[] x18 = {0, 0, -1, -2};
    static int[] y18 = {0, -1, -1, -1};
    static int[] x19 = {0, 1, 1, 1};
    static int[] y19 = {0, 0, -1, -2};

    static int[] x6 = {0, 1, 1, 2};
    static int[] y6 = {0, 0, -1, 0};
    static int[] x7 = {0, 0, 1, 0};
    static int[] y7 = {0, 1, 1, 2};
    static int[] x8 = {0, -1, -1, -2};
    static int[] y8 = {0, 0, 1, 0};
    static int[] x9 = {0, 0, -1, 0};
    static int[] y9 = {0, -1, -1, -2};

    static int[] x10 = {0, 1, 2, 3};
    static int[] y10 = {0, 0, 0, 0};
    static int[] x11 = {0, 0, 0, 0};
    static int[] y11 = {0, 1, 2, 3};

    static int[] x12 = {0, 0, 1, 1};
    static int[] y12 = {0, 1, 1, 2};
    static int[] x13 = {0, -1, -1, -2};
    static int[] y13 = {0, 0, 1, 1};
    static int[] x14 = {0, 0, -1, -1};
    static int[] y14 = {0, -1, -1, -2};
    static int[] x15 = {0, 1, 1, 2};
    static int[] y15 = {0, 0, -1, -1};

    static int[] x20 = {0, 0, -1, -1};
    static int[] y20 = {0, 1, 1, 2};
    static int[] x21 = {0, 1, 1, 2};
    static int[] y21 = {0, 0, 1, 1};
    static int[] x22 = {0, 0, 1, 1};
    static int[] y22 = {0, -1, -1, -2};
    static int[] x23 = {0, -1, -1, -2};
    static int[] y23 = {0, 0, -1, -1};

    public static int map_num(int i, int j) {
        if (i < 0 || i > (N-1) || j < 0 || j > (M-1))
            return -100;
        else
            return map[i][j];
    }

    public static void single_sum(int i, int j) {
        int[] sum = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int z = 0; z < 4; z++) {
            sum[0] += map_num(i + y1[z], j + x1[z]);
            sum[1] += map_num(i + y2[z], j + x2[z]);
            sum[2] += map_num(i + y3[z], j + x3[z]);
            sum[3] += map_num(i + y4[z], j + x4[z]);
            sum[4] += map_num(i + y5[z], j + x5[z]);
            sum[5] += map_num(i + y6[z], j + x6[z]);
            sum[6] += map_num(i + y7[z], j + x7[z]);
            sum[7] += map_num(i + y8[z], j + x8[z]);
            sum[8] += map_num(i + y9[z], j + x9[z]);
            sum[9] += map_num(i + y10[z], j + x10[z]);
            sum[10] += map_num(i + y11[z], j + x11[z]);
            sum[11] += map_num(i + y12[z], j + x12[z]);
            sum[12] += map_num(i + y13[z], j + x13[z]);
            sum[13] += map_num(i + y14[z], j + x14[z]);
            sum[14] += map_num(i + y15[z], j + x15[z]);
            sum[15] += map_num(i + y16[z], j + x16[z]);
            sum[16] += map_num(i + y17[z], j + x17[z]);
            sum[17] += map_num(i + y18[z], j + x18[z]);
            sum[18] += map_num(i + y19[z], j + x19[z]);
            sum[19] += map_num(i + y20[z], j + x20[z]);
            sum[20] += map_num(i + y21[z], j + x21[z]);
            sum[21] += map_num(i + y22[z], j + x22[z]);
            sum[22] += map_num(i + y23[z], j + x23[z]);
        }
        int tmp_sum = 0;
        for (int k = 0; k < 23; k++)
            tmp_sum = Math.max(tmp_sum, sum[k]);
        maxSum = Math.max(maxSum, tmp_sum);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = bf.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        M = Integer.parseInt(tokens[1]);

        for (int i = 0; i < N; i++) {
            tokens = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                single_sum(i,j);
            }
        }
        System.out.println(maxSum);
    }
}
