package week0307;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int A, B, weight;
	
	public Edge(int A, int B, int weight) {
		super();
		this.A = A;
		this.B = B;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class BJ_Main1197 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[E];
		int flag = 0;
		
		int a, b, c;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, c);
		}
		
		Arrays.sort(edges);
		
		int sum=0;
		int addEdge=0;
		for(Edge e: edges) {
			// 엣지의 간선들 중 하나라도 이미 방문했다면 스킵
			if(addEdge == V)	break;
			if((flag&1<<(e.A-1))!= 0 && (flag&1<<(e.B-1))!=0)	continue;
			flag |= (1<<(e.A-1));
			flag |= (1<<(e.B-1));
			sum += e.weight;
		}

		bw.write(sum+"");
		bw.flush();

	}
}
