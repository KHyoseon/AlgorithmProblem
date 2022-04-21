package week0307;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewelry {
	int m, v;

	public Jewelry(int m, int v) {
		super();
		this.m = m;
		this.v = v;
	}
}

public class BJ_Main_1202_보석도둑 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 보석 개수
		int K = Integer.parseInt(st.nextToken()); // 가방 개수

		Jewelry jewelries[] = new Jewelry[N];
		int backpackes[] = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < K; i++) {
			backpackes[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(jewelries, new Comparator<Jewelry>() {
			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				return o1.m-o2.m;
			}
		});
		Arrays.sort(backpackes);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int j=-1;
		long money=0;
		for(int i=0; i<K; i++) {
			while(j+1 < N && jewelries[j+1].m <= backpackes[i]) {
				pq.add(jewelries[++j].v);
			}
			if(pq.isEmpty())	continue;
			money += pq.poll();
		}

		bw.write(money+"");
		bw.flush();

	}

}
