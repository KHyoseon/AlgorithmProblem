package week0411;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_실패율 {

	public static void main(String[] args) {
		int N = 4;
		int[] stage = {4,4,4,4,4};
		
		System.out.println(Arrays.toString(solution(N, stage)));
	}
	
	// 스테이지 정보를 저장하는 클래스
	static class Stage {
		int id;				// 단계
		long user, pass;	// 현재 이 단계에 머물고 있는 유저 수, 도달한 유저 수

		public Stage() {
			super();
		}
		
		public void addUser() {
			this.user++;
		}
		
		public void addPass() {
			this.pass++;
		}
	}

	private static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		
		Stage[] stgs = new Stage[N+1];

		// 스테이지 단계 저장
		for(int i=0; i<N+1; i++) {
			stgs[i] = new Stage();
			stgs[i].id = i+1;
		}
		
		// 각 단계마다 머무르고 있는 유저 카운트
		for(int stage: stages) {
			stgs[stage-1].addUser();
		}
		
		stgs[N].pass = stgs[N].user;
		// 각 단계에 도달했던 유저 수 카운트
		for(int i=N-1; i>=0; i--) {
			stgs[i].pass = stgs[i].user + stgs[i+1].pass;
		}
		
		// 실패율 = (머물고 있는 유저 수 / 도달했던 유저 수)
		Arrays.sort(stgs, new Comparator<Stage>() {
			@Override
			public int compare(Stage o1, Stage o2) {
				float ratio1 = o1.pass==0? (float)0: (float)o1.user/o1.pass;
				float ratio2 = o2.pass==0? (float)0: (float)o2.user/o2.pass;
				
				float cha = ratio2 - ratio1;
				return cha==0.0? o1.id-o2.id: (cha>0? 1: -1);
			}
		});
		
		int i=0;
		// 1~N단계만 따로 저장
		for(Stage stage: stgs) {
			if(stage.id > N)	continue;
			answer[i] = stage.id;
			i++;
		}
		
		return answer;
	}
	
}
