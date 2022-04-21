package week0404;

public class Solution_방금그곡 {

	public static void main(String[] args) {
		String m = "CC#BCC#BCC#";
		String[] musicinfos = {"03:00,03:08,FOO,CC#B"};
		System.out.println(solution(m, musicinfos));
	}
	
	private static String solution(String m, String[] musicinfos) {
		String title = null;
		int time = Integer.MIN_VALUE;
		m = removeSharp(m);
		
		String[] token, s, e;
		int playTime;
		String note;
		for(String info: musicinfos) {
			/* token
			 * [0] : start time
			 * [1] : end time
			 * [2] : title
			 * [3] : notes
			 */
			token = info.split(",");
			
			// s: start time의 시각[0], 분[1]
			// e: end time의 시각[0], 분[1]
			s = token[0].split(":");
			e = token[1].split(":");
			// playTime(재생시간) = start time ~ end time 을 분으로 나타냄..
			playTime = (Integer.parseInt(e[0]) - Integer.parseInt(s[0])) * 60;
			playTime += (Integer.parseInt(e[1]) - Integer.parseInt(s[1]));
			
			note = removeSharp(token[3]);
			String temp = note;
			
			if(note.length() > playTime) {
				note = note.substring(0, playTime);
			}
			else {
				// note 길이를 m이 포함될 수 있을만큼 늘려줌
				if(note.length() < m.length()) {
					int div = m.length()/note.length();
					for(int i=0; i<div; i++)		note += temp;
				}
				note += note;
			}
			
			if (note.contains(m) && playTime > time) {
				title = token[2];
				time = playTime;
			}
		}
		
        return title==null?"(None)":title;
	}
	
	private static String removeSharp(String m) {
		m = m.replace("C#", "c");
		m = m.replace("D#", "d");
		m = m.replace("F#", "f");
		m = m.replace("G#", "g");
		m = m.replace("A#", "a");
		return m;
	}
}
