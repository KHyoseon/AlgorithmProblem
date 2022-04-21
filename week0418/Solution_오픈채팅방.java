package week0418;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_오픈채팅방 {

	public static void main(String[] args) {
		String record[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
	}
	
	private static String[] solution(String[] record){
		String enter = "님이 들어왔습니다.";
		String leave = "님이 나갔습니다.";
		
		// 채팅방 입퇴장 기록 저장
		ArrayList<String[]> list = new ArrayList<>();
		
		// 유저 아이디별 닉네임 저장할 map
		Map<String, String> map = new HashMap<>();
		
		StringBuilder sb = new StringBuilder();
		for(String rcd: record) {
			String token[] = rcd.split(" ");
			
			// 명령어 보고 유저 아이디별 닉네임 저장, 입퇴장 기록(유저 아이디, 입퇴장 정보) 저장
			switch(token[0]) {
			case "Enter":
				map.put(token[1], token[2]);
				list.add(new String[] {token[1], enter});
				break;
			case "Leave":
				sb.append(token[1]).append(leave);
				list.add(new String[] {token[1], leave});
				break;
			case "Change":
				map.replace(token[1], token[2]);
				break;
			}
		}
		
		String[] answer = new String[list.size()];
		
		int i=0;
		// list의 유저 아이디 값을 닉네임으로 변경, 한글 문자열로 바꿔서 answer 배열에 저장
		for(String[] info: list) {
			sb.setLength(0);
			sb.append(map.get(info[0]));
			if(info[1].equals(enter)) {
				sb.append(enter);
			} else {
				sb.append(leave);
			}
			answer[i++] = sb.toString();
		}
		
        return answer;
	}
}
