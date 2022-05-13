package week0512;

import java.util.Stack;

public class Solution_수식_최대화 {

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(new Solution().solution(expression));
	}

	static class Solution {
		public long solution(String expression) {
			// +, -, *
			int[][] priority = {
					{1,2,3},
					{1,3,2},
					{2,1,3},
					{2,3,1},
					{3,1,2},
					{3,2,1}};
			
			for(int[] p: priority) {
				long result = doProc(p, expression);
			}
			
			long answer = 0;
	        return answer;
	    }
		private long doProc(int[] p, String expression) {
			long result = 0;
			
			Stack<Integer> operand = new Stack<>();
			Stack<Character> operator = new Stack<>();
			
			String num = "";
			for(int i=0, n=expression.length(); i<n; i++) {
				char temp = expression.charAt(i);
				switch(temp) {
				case'+':
					operand.add(Integer.parseInt(num));
					num="";
					
					break;
				case'-':
					operand.add(Integer.parseInt(num));
					num="";
					break;
				case'*':
					operand.add(Integer.parseInt(num));
					num="";
					break;
				default:
					num += temp;
				}
			}
			
			
			
			return result;
		}
	}
	
}
