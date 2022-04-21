package week0321;

import java.util.Arrays;

public class Solution_비밀지도 {

	public static void main(String[] args) {
//		int n=5;
//		int arr1[] = {9, 20, 28, 18, 11};
//		int arr2[] = {30, 1, 21, 17, 28};
		int n=6;
		int arr1[] = {46, 33, 33 ,22, 31, 50};
		int arr2[] = {27 ,56, 19, 14, 14, 10};
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));

	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int map[] = new int[n];
        for(int i=0; i<n; i++) {
        	map[i] = arr1[i] | arr2[i];
        	answer[i] = toStringMap(map[i], n);
        }
        
        return answer;
    }

	private static String toStringMap(int integer, int n) {
		StringBuilder sb = new StringBuilder();
		
		int i=0, flag = 1;
		for(i=0; flag <= integer; i++) {
			if((integer&flag) == 0)
				sb.append(" ");
			else
				sb.append("#");
			flag = flag << 1;
		}
		
		for(; i<n; i++)
			sb.append(" ");
		
		return sb.reverse().toString();
	}

}
