package week0425;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_순위_검색 {

	public static void main(String[] args) {
		String info[] = { 
				"java backend junior pizza 150", 
				"python frontend senior chicken 210",
				"python frontend senior chicken 150", 
				"cpp backend senior pizza 260", 
				"java backend junior chicken 80",
				"python backend senior chicken 50" };
		
		String query[] = { 
				"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", 
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", 
				"- and - and - and chicken 100", 
				"- and - and - and - 150" };

		System.out.println(Arrays.toString(solution(info, query)));
	}

	public static int[] solution(String[] info, String[] query) {
		
		int[] answer = new int[query.length];

		// 언어, 직군, 연차, 소울푸드, 점수
		
		// cpp, 자바, 파이썬
		// 백, 프론트
		// 주니어, 시니어
		// 치킨 피자
		Lang[] lang = new Lang[3];
		
		for (String str : info) {
			String data[] = str.split(" ");
			
			int l, d, a, f;
			
			if(data[0].equals("cpp")) 			l=0;
			else if (data[0].equals("java"))	l=1;
			else 								l=2;
			
			if(data[1].equals("backend"))		d=0;
			else								d=1;
			
			if(data[2].equals("junior"))		a=0;
			else								a=1;
			
			if(data[3].equals("chicken"))		f=0;
			else								f=1;
			
			lang[l].dev[d].age[a].food[f].score.add(Integer.parseInt(data[4]));
			
		}
		
		int j = 0;
		for (String qry : query) {
			//"cpp and - and senior and pizza 250"
			qry.replace(" and", "");
//			qry.replace(" ", "");
			
			// 언어, 직군, 연차, 소울푸드, 점수
			String data[] = qry.split(" ");
			
			int[] l, d, a, f;
			
			if(data[0].equals("cpp")) 			l = new int[] {0};
			else if (data[0].equals("java"))	l = new int[] {1};
			else if (data[0].equals("python"))	l = new int[] {2};
			else 								l = new int[] {0,1,2};
			
			if(data[1].equals("backend"))		d = new int[] {0};
			else if(data[1].equals("frontend"))	d = new int[] {1};
			else								d = new int[] {0, 1};
			
			if(data[2].equals("junior"))		a = new int[] {0};
			else if(data[2].equals("senior"))	a = new int[] {1};
			else								a = new int[] {0, 1};
			
			if(data[3].equals("chicken"))		f = new int[] {0};
			else if(data[3].equals("pizza"))	f = new int[] {1};
			else								f = new int[] {0, 1};

			int i=0;
			for(int d1: l) {
				for(int d2: d) {
					for(int d3: a) {
						for(int d4: f) {
							int[] arr = lang[d1].dev[d2].age[d3].food[d4].score.stream().mapToInt(n -> n).toArray();
							answer[i++] = binarySearch(arr, 0, arr.length, Integer.parseInt(data[4]));
						}
					}
				}
			}
		}
		
		return answer;
	}

	// target보다 작은 애들 중 최대값을 반환
	public static int binarySearch(int[] arr, int start, int end, int target) {
		if(start==end)	return start;
		
		int mid = (start+end) >> 1;
		
		if(arr[mid] <= target)	return binarySearch(arr, mid, end, target);
		return binarySearch(arr, start, mid+1, target);
	}
}

class Lang{
	Dev[] dev;
	public Lang() {
		this.dev = new Dev[2];
	}
}

class Dev{
	Age[] age;
	public Dev() {
		this.age = new Age[2];
	}
}

class Age{
	Food[] food;
	public Age() {
		this.food = new Food[2];
	}
}

class Food{
	ArrayList<Integer> score;
	public Food() {
		this.score = new ArrayList<>();
	}
}
