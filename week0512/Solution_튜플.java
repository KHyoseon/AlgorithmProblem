package week0512;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_튜플 {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] array = new Solution().solution(s);
		System.out.println(Arrays.toString(array));
	}

	static class Solution {
		public int[] solution(String s) {
	    	s = s.replace("{", "");
	    	s = s.substring(0, s.length()-2);
	    	String[] sets = s.split("},");
	    	
	    	Arrays.sort(sets, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.length() - o2.length();
				}
	    	});
	    	
	    	List<Integer> answer = new ArrayList<>();
	    	
	    	Set<String> el = new HashSet<>();
	    	for(String set: sets) {
	    		String[] elements = set.split(",");
	    		for(String e: elements) {
	    			if(el.contains(e))	continue;
	    			el.add(e);
	    			answer.add(Integer.parseInt(e));
	    		}
	    	}
	    	
	        return answer.stream().mapToInt(x->x).toArray();
	    }
	}
}
