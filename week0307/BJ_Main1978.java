package week0307;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_Main1978 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean notPrime[] = new boolean[1001];
		notPrime[0] =notPrime[1] = true;
		for(int j=2; j<1001; j++) {
			if(notPrime[j]==true)		continue;
			for(int i=2*j; i<1001; i+=j) {
				notPrime[i] = true;
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		String nums[] = br.readLine().split(" ");
		
		int p=0;
		for (String n: nums) {
			int target = Integer.parseInt(n);
			if(!notPrime[target]) {
				System.out.print(target+" ");
				p++;
			}
			System.out.println();
		}

		bw.write(p+"");
		bw.flush();

	}

}
