import java.io.*;
import java.util.*;

/**
 * 백준 삼성 기출 문제 14502번 '연구소'
 * https://www.acmicpc.net/problem/14502
 */

public class lab {
    public static void main (String[] args) throws IOException {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = bf.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]);
    int M = Integer.parseInt(inputs[1]);
    int[][] map = new int[N][M];

    for (int i = 0; i < N; i++)
    {
        inputs = bf.readLine().split(" ");
        for (int j = 0; j < M; j++)
            map[i][j] = Integer.parseInt(inputs[j]);
    }

    /**
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
            System.out.print(map[i][j]+" ");
        System.out.println();
    }
    */


    // 그냥 시발 다 N^3으로 돌면서 1을 추가해보고,
    // method 하나 만들어서 바이러스 퍼지는거 테스트 해보면 안되냐?
    int max_safe = 0;
    int[][] tmp_map = new int[N][M];
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (map[i][j] != 0) continue;
            for (int k = i; k < N; k++)
            {
                for (int l = 0; l < M; l++)
                {
                    if (k == i && j < (M-1)) l = i +1;
                    if (map[k][l] != 0) continue;
                    for (int q = k; q < N; q++)
                    {
                        for (int p = 0; p < M; p++)
                        {
                            if (q == k && l < (M-1)) p = l+1;
                            if (map[q][p] != 0) continue;
                            tmp_map = map;
                            tmp_map[i][j] = 1;
                            tmp_map[k][l] = 1;
                            tmp_map[q][p] = 1;
                            max_safe = BFS_virus(tmp_map);
                        }
                    }
                }
            }
        }
    }

    System.out.println(max_safe);

    }
    
    int BFS_vrius(int[][] tmp_map)
    {


    }
}

