import java.util.*;
import java.io.*;

/**
 * 백준 삼성 기출 문제 140503번 '로봇 청소기'
 * https://www.acmicpc.net/problem/14503
 **/

public class robotVacuum {

    static int[][] map = new int[50][50];
    static boolean[][] cleaned = new boolean[50][50];
    static int N,M,r,c,d;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens;
        tokens = bf.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        M = Integer.parseInt(tokens[1]);

        tokens = bf.readLine().split(" ");
        r = Integer.parseInt(tokens[0]);
        c = Integer.parseInt(tokens[1]);
        d = Integer.parseInt(tokens[2]);

        for (int i = 0; i < N; i++) {
            tokens = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
               map[i][j]= Integer.parseInt(tokens[j]);
            }
        }

        int current_status = 1;
        int clean_trial = 0;
        boolean stuck = false;
        while (!stuck) {
            //1
            cleaned[r][c] = true;
            //2
            if (clean_trial == 4) {
                if (d == 0) {
                    if (r < (N-1) && map[r+1][c] != 1) {
                        clean_trial = 0;
                        r += 1;
                    }
                    else {
                        stuck = true;
                        break;
                    }
                }
                else if (d == 1) {
                    if (c != 0 && map[r][c-1] != 1) {
                        clean_trial = 0;
                        c -= 1;
                    }
                    else {
                        stuck = true;
                        break;
                    }
                }
                else if (d == 2) {
                    if (r != 0 && map[r-1][c] != 1) {
                        clean_trial = 0;
                        r -= 1;
                    }
                    else {
                        stuck = true;
                        break;
                    }
                }
                else {
                    if (c < (M-1) && map[r][c+1] != 1) {
                        clean_trial = 0;
                        c += 1;
                    }
                    else {
                        stuck = true;
                        break;
                    }
                }
            }
            if (d == 0) {
                if (c != 0 && cleaned[r][c-1] == false && map[r][c-1] != 1) {
                    d = 3;
                    c -= 1;
                    clean_trial = 0;
                    //call 1;
                }
                else {
                    d = 3;
                    clean_trial ++;
                    //call 2
                }
            }
            else if (d == 1) {
                if (r != 0 && cleaned[r-1][c] == false && map[r-1][c] != 1) {
                    d = 0;
                    r -= 1;
                    clean_trial = 0;
                    //call 1;
                }
                else {
                    d = 0;
                    clean_trial ++;
                    //call 2
                }
            }
            else if (d == 2) {
                if (c < (M-1) && cleaned[r][c+1] == false && map[r][c+1] != 1) {
                    d = 1;
                    c += 1;
                    clean_trial = 0;
                    //call 1;
                }
                else {
                    d = 1;
                    clean_trial ++;
                    //call 2
                }
            }
            else {
                if (r < (N-1) && cleaned[r+1][c] == false && map[r+1][c] != 1) {
                    d = 2;
                    r += 1;
                    clean_trial = 0;
                    //call 1;
                }
                else {
                    d = 2;
                    clean_trial ++;
                    //call 2
                }
            }
        }
        int clean_sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cleaned[i][j])
                    clean_sum +=1;
            }
        }
        System.out.println(clean_sum);
    }
}
