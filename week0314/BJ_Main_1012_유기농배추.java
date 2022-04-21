package week0314;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_Main_1012_유기농배추 {

	static String str = "2\r\n" + 
			"10 8 17\r\n" + 
			"0 0\r\n" + 
			"1 0\r\n" + 
			"1 1\r\n" + 
			"4 2\r\n" + 
			"4 3\r\n" + 
			"4 5\r\n" + 
			"2 4\r\n" + 
			"3 4\r\n" + 
			"7 4\r\n" + 
			"8 4\r\n" + 
			"9 4\r\n" + 
			"7 5\r\n" + 
			"8 5\r\n" + 
			"9 5\r\n" + 
			"7 6\r\n" + 
			"8 6\r\n" + 
			"9 6\r\n" + 
			"10 10 1\r\n" + 
			"5 5"; 
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new StringReader(str));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		boolean[][] ground;
		int baechoo[][];
		int M, N, K;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			ground = new boolean[M][N];
			baechoo = new int[K][2];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				baechoo[i][0] = Integer.parseInt(st.nextToken());
				baechoo[i][1] = Integer.parseInt(st.nextToken());
				ground[baechoo[i][0]][baechoo[i][1]] = true;
			}
			
			bfsAll(ground, baechoo, M, N, K);
		}

		bw.write(sb.toString());
		bw.flush();

	}
	
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	private static void bfsAll(boolean[][] ground, int[][] baechoo, int M, int N, int K) {
		for(int k=0; k<K; k++) {
			if(ground[baechoo[k][0]][baechoo[k][1]]) {
				bfs(ground, baechoo[k], M, N, K);
			}
		}
	}

	private static void bfs(boolean[][] ground, int[] baechoo, int M, int N, int K) {
		Queue<int[]> q = new LinkedList<>();
		q.add(baechoo);
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int m=0; m<4; m++) {
				
			}
		}
	}

}
