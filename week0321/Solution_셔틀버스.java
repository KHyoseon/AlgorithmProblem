package week0321;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_셔틀버스 {

	public static void main(String[] args) {
		// 09:00부터 총 n회 t분 간격으로 역에 도착. 한 셔틀에 탈 수 있는 최대 크루 수 m
		int n = 2;
		int t = 10;
		int m = 2;
		String[] timetable = {
				"09:10", "09:09", "08:00"
		};
		
		System.out.println(solution(n, t, m, timetable));

	}

	public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        Arrays.sort(timetable);
        HashMap<String, Integer> crew = new HashMap<String, Integer>();
        
        int i=0;
        int sum=0;
        for(; i<m-1; i++) {
        	if(crew.containsKey(timetable[i])) {
        		crew.put(timetable[i], crew.get(timetable[i])+1);
        	} else {
        		crew.put(timetable[i], 1);
        	}
        }
        
        String[] pool = (String[]) crew.keySet().toArray();
        if(timetable[i-1]==timetable[i]) {
        	return pool[pool.length-2];
        }
        
        return answer;
    }

}
