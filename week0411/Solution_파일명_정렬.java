package week0411;

import java.util.Arrays;

public class Solution_파일명_정렬 {

	public static void main(String[] args) {
		String files[] = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		System.out.println(Arrays.toString(solution(files)));
	}
	
	private static String[] solution(String files[]){
		class File implements Comparable<File>{
			String header;
			String number;
			String tail;
			
			public File(String[] token) {
				super();
				this.header = token[0];
				this.number = token[1];
				this.tail = token[2];
			}
			
			@Override
			public String toString() {
				return header+number+tail;
			}

			// 1차로 header 문자열 오름차로 정렬, 2차로 number 정수의 오름차로 정렬
			@Override
			public int compareTo(File o) {
				if(this.header.toLowerCase().equals(o.header.toLowerCase())) {
					return Integer.parseInt(this.number)-Integer.parseInt(o.number);
				}
				return this.header.toLowerCase().compareTo(o.header.toLowerCase());
			}
		}
		
		
		int n = files.length;
		
		String answer[] = new String[n];
		File f[] = new File[n];

		for(int i=0; i<n; i++) {
			// 각 파일을 파싱해서 File이란 객체에 따로 저장
			f[i] = new File(parseString(files[i]));
		}
		
		// 소팅
		Arrays.sort(f);
		
		// 분해한 문자열을 합처서 다시 반환할 배열에 넣어줌
		for(int i=0; i<n; i++) {
			answer[i] = f[i].toString();
		}
		
		return answer;
	}
	
	public static String[] parseString(String str) {
		String[] token = new String[3];
		
		int n = str.length();
		
		StringBuilder sb = new StringBuilder();
		int i=0;
		// 아라비아 숫자가 나올 때까지 header로 넣어줌 
		for(; i<n; i++) {
			if('0'<=str.charAt(i) && str.charAt(i)<='9')	break;
			sb.append(str.charAt(i));
		}
		token[0] = sb.toString();
		
		sb.setLength(0);
		// 뒤에 따르는 숫자들을 최대 5개 담아서 number로 넣어줌
		for(int j=0; i<n && j<5; i++, j++) {
			if('0'>str.charAt(i) || str.charAt(i)>'9')		break;
			sb.append(str.charAt(i));
		}
		token[1] = sb.toString();
		
		// 나머지는 tail로 넣어줌
		token[2] = str.substring(i, n);
		
		return token;
	}
	
}
