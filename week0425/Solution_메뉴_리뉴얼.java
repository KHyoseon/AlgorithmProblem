package week0425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution_메뉴_리뉴얼 {

	public static void main(String[] args) {
		String orders[] = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int course[] = {2, 3, 4};
		
		System.out.println(Arrays.toString(solution(orders, course)));
	}

	private static String[] solution(String[] orders, int[] course) {
		ArrayList<String> result = new ArrayList<>();
		
		int N = orders.length;
		
		StringBuilder sb = new StringBuilder();
		String[] sorted = new String[N];
		
		for(int i=0; i<N; i++) {
			char[] sort = orders[i].toCharArray();
			Arrays.sort(sort);
			
			sb.setLength(0);
			for (char ch : sort) {
				sb.append(ch);
			}
			sorted[i] = sb.toString();
		}
		
		for(int c: course) {
			map = new HashMap<>();
			
			for(String order: sorted)
				Comb(order, 0, c, "");
			
			int max = 1;
			ArrayList<String> ret = new ArrayList<>();
			
			for(String key: map.keySet()) {
				if(max < map.get(key)) {
					max = map.get(key);
					ret = new ArrayList<>();
					ret.add(key);
				} else if(max > 1 && max == map.get(key)) {
					ret.add(key);
				}
			}
			
			if(!ret.isEmpty())
				result.addAll(ret);
		}
		
		Collections.sort(result);
		String answer[] = new String[result.size()]; 
		return result.toArray(answer);
	}
	
	public static Map<String, Integer> map; 
	
	private static void Comb(String str, int start, int cnt, String selected) {
		if(cnt==0) {
			if(map.containsKey(selected)) {
				map.replace(selected, map.get(selected)+1);
			} else {
				map.put(selected, 1);
			}
			return;
		}
		
		for(int s=start; s<str.length(); s++) {
			String temp = selected + str.charAt(s);
			Comb(str, s+1, cnt-1, temp);
		}
	}

}
