package week0404;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution_압축 {

	public static void main(String[] args) {
		String msg = "ABABABABABABABAB";
		System.out.println(Arrays.toString(solution(msg)));
	}

	private static int[] solution(String msg) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		HashMap<String, Integer> dict = new HashMap<>();
		for(int i=0; i<26; i++) {
			char alpha = (char)('A'+i);
			dict.put(alpha+"", i+1);
		}
		
		for(int i=0, n=msg.length(); i<n;) {
			String w = msg.charAt(i)+"";
			int ans = dict.get(w);

			for(int j=1; j<=n-i; j++) {
				if(i+j >= n) {
					i = n;
					break;
				}
				w += msg.charAt(i+j);
				if (dict.containsKey(w)) {
					ans = dict.get(w);
				} else {
					i += j;
					break;
				}
			}
			dict.put(w, dict.size()+1);
			answer.add(ans);
		}
		
		int[] a = answer.stream().mapToInt(i -> i).toArray();
		return a;
	}
	
}
