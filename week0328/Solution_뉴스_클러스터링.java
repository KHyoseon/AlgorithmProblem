package week0328;

import java.util.HashMap;
import java.util.Set;

public class Solution_뉴스_클러스터링 {
	
	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";
		System.out.println(Solution(str1, str2));
	}

	private static int Solution(String str1, String str2) {
		HashMap<String, Integer> map1 = parseIntoMap(str1);
		HashMap<String, Integer> map2 = parseIntoMap(str2);
		if(map1.size()==0 && map2.size()==0)	return 65536;
		return J(map1, map2);
	}
	
	private static HashMap<String, Integer> parseIntoMap(String str){
		HashMap<String, Integer> map = new HashMap<>();
		str = str.toLowerCase();
		for(int i=0, n=str.length()-1; i<n; i++) {
			String temp = str.substring(i, i+2);
			if('a'>temp.charAt(0)||temp.charAt(0)>'z' ||
					'a'>temp.charAt(1)||temp.charAt(1)>'z')	continue;
			if(map.containsKey(temp)) {
				map.replace(temp, map.get(temp)+1);
			} else {
				map.put(temp, 1);
			}
		}
		return map;
	}

	private static int J(HashMap<String, Integer> list1, HashMap<String, Integer> list2) {
		final int MUL = 65536;
		
		// list1이 더 작은 맵
		if(list1.size() > list2.size()) {
			HashMap<String, Integer> temp = list1;
			list1 = list2;
			list2 = temp;
		}
		
		int hap=0, gyo=0;
		
		Set<String> keys = list1.keySet();
		for(String key: keys) {
			if(list2.containsKey(key)) {
				if(list1.get(key)>list2.get(key)) {
					hap += list1.get(key);
					gyo += list2.get(key);
				} else {
					hap += list2.get(key);
					gyo += list1.get(key);
				}
				list2.remove(key);
			} else {
				hap += list1.get(key);
			}
		}
		
		if(list2.size() != 0) {
			keys = list2.keySet();
			for(String key: keys) {
				hap += list2.get(key);
			}
		}
		
		return (int)(gyo*MUL/hap);
	}
	
}
