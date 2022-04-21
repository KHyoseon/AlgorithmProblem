package week0418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_후보키 {

	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},
								{"200","apeach","math","2"},
								{"300","tube","computer","3"},
								{"400","con","computer","4"},
								{"500","muzi","music","3"},
								{"600","apeach","music","2"}};
		System.out.println((solution(relation)));
	}

	private static int solution(String[][] relation) {
		int answer = 0;
		int col = relation[0].length;
		int row = relation.length / col;
		
		
		
        return answer;
	}

}
