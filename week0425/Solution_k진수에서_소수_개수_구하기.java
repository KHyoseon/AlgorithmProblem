package week0425;

import java.util.ArrayList;

public class Solution_k진수에서_소수_개수_구하기 {

	public static void main(String[] args) {
		int n = 1103011;
		int k = 9;
		System.out.println((solution(n, k)));
	}

	private static int solution(int n, int k) {
		int answer=0;
		
		String ret = convert(n, k);
		String[] tokens = ret.split("0");
		
		ArrayList<Long> list = new ArrayList<>();

		long max = 0;
		for(String token: tokens) {
			if(token.equals(""))		continue;
			max = max<Long.parseLong(token)? Long.parseLong(token): max;
			list.add(Long.parseLong(token));
		}
		
		for(long num: list) {
			if(isPrime(num))
				++answer;
		}
		
		return answer;
		
	}

	private static boolean isPrime(long num) {
		if(num==1)	return false;
		if(num==2)	return true;
		long N = (long)Math.sqrt(num);
		for(long i=2; i<=N; i++) {
			if(num%i == 0)	return false;
			long temp = num;
			while(num%i == 0) {
				temp = num;
				num /= i;
			}
			num = temp;
		}
		return true;
	}

	private static String convert(int n, int k) {
		StringBuilder sb = new StringBuilder();
		while(n>0) {
			sb.append(n%k);
			n/=k;
		}
		return sb.reverse().toString();
	}

}
