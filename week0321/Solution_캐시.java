package week0321;

import java.util.ArrayList;

public class Solution_캐시 {

	public static void main(String[] args) {
		int cacheSize = 2;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(cacheSize, cities));

	}

	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<String>();
        int refer[] = new int[cacheSize];
        int r=0;
        for(String city: cities)
        {
        	answer += LRU(++r, cacheSize, city.toLowerCase(), cache, refer);
        }
        return answer;
    }

	private static int LRU(int r, int cacheSize, String city, ArrayList<String> cache, int refer[]) {
		if(cacheSize == 0)	return 5;
		for(int i=0, n=cache.size(); i<n; i++) {
			if(cache.get(i).equals(city)) {
				refer[i]=r;
				return 1;
			}
		}
		
		if(cache.size() < cacheSize) {
			cache.add(city);
			refer[cache.size()-1] = r;
			return 5;
		}
		
		int min = r;
		int minIdx = 0;
		for(int i=0; i<cacheSize; i++) {
			if(min > refer[i]) {
				min = refer[i];
				minIdx = i;
			}
		}
		cache.set(minIdx, city);
		refer[minIdx] = r;
		return 5;
	}

}
