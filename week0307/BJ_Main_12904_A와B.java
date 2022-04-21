package week0307;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_Main_12904_A와B {
	
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String t = br.readLine();
		
		for(int i=t.length()-1; i>=0; i--) {
			if(s.length() == t.length())	break;
			if(t.charAt(i)=='A') {
				t = rollBackA(t);
			} else {
				t = rollBackB(t);
			}
		}

		bw.write(s.equals(t)?"1":"0");
		bw.flush();

	}

	public static String rollBackA(String str) {
		return str.substring(0, str.length()-1);
	}
	
	public static String rollBackB(String str) {
		String tmp = "";
		for(int j=str.length()-2; j>=0; j--) {
			tmp += str.charAt(j);
		}
		return tmp;
	}
	
}
