package week0307;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_Main_1946_신입사원 {
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			int[][] people = new int[N][2]; 
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				people[i][0] = Integer.parseInt(st.nextToken());
				people[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(people, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
				
			});
			
			int pass=1;
			int cutLine = people[0][1];
			for(int i=1; i<N; i++) {
				if(cutLine > people[i][1]) {
					++pass;
					cutLine = people[i][1];
				}
			}
			sb.append(pass+"\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}
}