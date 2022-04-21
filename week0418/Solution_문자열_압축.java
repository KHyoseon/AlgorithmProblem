package week0418;

public class Solution_문자열_압축 {

	public static void main(String[] args) {
		String s = "xababcdcdababcdcd";
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		StringBuilder sb = new StringBuilder();
        int N = s.length();
        int answer = N;
        
        // fragment: 반복되는지 확인할 문자열, temp: 비교 문자열
        String fragment = "", temp = "";
        // fragment 등장 횟수
        int cnt;
        for(int offset=1; offset<N; offset++) {
        	sb.setLength(0);
        	
        	// start번째(0부터 시작) 위치에서 offset 길이만큼의 부분 문자열(fragment)을 만듦
        	int start = 0;
        	while(start+offset<=N) {
        		// fragment가 나타나는 횟수
        		cnt = 1;
        		fragment = s.substring(start, start+offset);
        		// start+offset번째 위치에서 offset 길이만큼의 부분 문자열(temp)을 만듦
        		for(int next=start+offset; next+offset<=N; next+=offset) {
        			temp = s.substring(next, next+offset);
        			// fragment와 temp가 같으면 (문자열이 반복된다면)	cnt 카운트,
        			// 다르다면 카운팅 종료
        			if(!fragment.equals(temp))		break;
        			++cnt;
        		}
        		// fragment 반복 횟수 + fragment sb에 넣기
        		sb.append(cnt==1?"":cnt).append(fragment);
        		start += cnt*offset;
        	}
        	// 남은 문자열이 있으면 sb에 붙여 줌
        	if(start < N)
        		sb.append(s.substring(start, N));
        	
        	// sb의 길이가 min보다 작으면 갱신
        	int sbl = sb.toString().length();
        	answer = answer > sbl? sbl: answer;
        }
        
        return answer;
    }

}
