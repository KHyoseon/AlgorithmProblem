package week0404;

import java.util.Stack;

public class Solution_다트_게임 {

	public static void main(String[] args) {
		String dartResult = "1D2S#10S";
		System.out.println(solution(dartResult));
	}

	private static int solution(String dartResult) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		int cur = 0;
		for(int i=0, n=dartResult.length(); i<n; i++) {
			char c = dartResult.charAt(i);
			switch (c) {
			case 'S':
				break;
			case 'D':
				cur = stack.pop();
				cur = (int)Math.pow(cur, 2);
				stack.add(cur);
				break;
			case 'T':
				cur = stack.pop();
				cur = (int)Math.pow(cur, 3);
				stack.add(cur);
				break;
			case '*':
				cur = stack.pop();
				if(!stack.isEmpty()) {
					int prev = stack.pop();
					stack.add(2*prev);
				}
				stack.add(2*cur);
				break;
			case '#':
				cur = stack.pop();
				stack.add((-1)*cur);
				break;
			default :
				char next = dartResult.charAt(i+1);
				if('0'<=next&&next<='9') {
					stack.add((c-'0')*10+(next-'0'));
					++i;
				} else {
					stack.add(c-'0');
				}
			}
		}
		
		for(Integer i: stack) {
			sum += i;
		}
		
		return sum;
	}
	
}
