package week0328;

public class Solution_프렌즈4블록 {

	public static void main(String[] args) {
		int m = 6;	//높이
		int n = 6; 	//너비
		String[] board = {
				"TTTANT",
				"RRFACC",
				"RRRFCC",
				"TRRRAA",
				"TTMMMF",
				"TMMTTJ"
		};
		
		System.out.println(solution(m, n, board));
	}

	private static int solution(int m, int n, String[] board) {
		String vertical[] = new String[n];
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<n; j++) {
			sb.setLength(0);
			for(int i=m-1; i>=0; i--)
				sb.append(board[j].charAt(i));
			vertical[j] = sb.toString();
		}
		
		String[] block = {"RR", "MM", "AA", "FF", "NN", "TT", "JJ", "CC"};
		for(int j=0; j<n-1; j++) {
			// 각 블록에 대해 삭제할 수 있는지 검색
			for(int i=0; i<8; i++) {
				// j=0~n-2까지, 내 오른쪽의 열 문자열에 같은
				if(vertical[j].contains(block[i]) && vertical[j+1].contains(block[i])) {
					
					int h = vertical[j].indexOf(block[i]);
				}
			}
		}
		
		return 0;
	}

}
