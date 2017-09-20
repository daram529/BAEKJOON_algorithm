import java.io.*;
import java.util.*;

public class Virus {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //String[] inputs = bf.readLine().split(" ");
        int computer = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int edges[][] = new int[computer+1][computer+1];

        for (int i = 0; i < n; i++)
        {
            String[] inputs = bf.readLine().split(" ");
            int c1 = Integer.parseInt(inputs[0]);
            int c2 = Integer.parseInt(inputs[1]);

            edges[c1][c2] = 1;
            edges[c2][c1] = 1;
        }

        boolean[] visited = new boolean[computer+1];
        //BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int virus = 0;
        
        while (!queue.isEmpty())
        {
            int node = queue.poll();
            if (visited[node]) continue;
            // System.out.println(node);
            virus++;
            visited[node] = true;

            int[] edgeFromNode = edges[node];
            for (int i = 0; i < edgeFromNode.length; i++)
            {
                if (edgeFromNode[i] == 1 && !visited[i])
                {
                    queue.add(i);
                }
            }
        }
        virus --;
        System.out.println(virus);
    }
}
