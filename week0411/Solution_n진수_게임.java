package week0411;

public class Solution_n진수_게임 {

	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 1;
		System.out.println(solution(n, t, m, p));
	}

	private static String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		int minLength = m*(t-1) + p;
		
		sb.append("0");
		for(int i=1; ; i++) {
			sb.append(mod(n, i));
			if(sb.length() >= minLength)	break;
		}
		
		String str = sb.toString();
		sb.setLength(0);
		
		for(int i=0; i<t; i++) {
			sb.append(str.charAt(m*i+p-1));
		}
		
		return sb.toString();
	}
	
	private static String mod(int n, int num) {
		StringBuilder sb = new StringBuilder();

		int p = 'A'-10;
		
		while(num>0) {
			int bit = num%n;
			if(bit>9) {
				sb.append((char)(bit+p));
			} else {
				sb.append(num%n);
			}
			num /= n;
		}
		return sb.reverse().toString();
	}
	
}
