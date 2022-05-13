package week0512;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_카카오프렌즈_컬러링북 {

	public static void main(String[] args) {
		int m = 6;
		int n = 7;
		int[][] picture = { 
				{ 0, 4, 0, 20, 20, 0, 3 }, 
				{ 0, 4, 10, 20, 0, 11, 1 }, 
				{ 4, 0, 10, 2, 2, 0, 0 },
				{ 0, 0, 0, 20, 0, 0, 1 }, 
				{ 0, 0, 20, 10, 2, 1, 0 }, 
				{ 0, 20, 10, 10, 2, 0, 1 } };
//		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] array = new Solution().solution(m, n, picture);
		System.out.println(Arrays.toString(array));
	}

	static class Solution {
		public int[] solution(int m, int n, int[][] picture) {
			int numberOfArea = 0;
			int maxSizeOfOneArea = 0;

			int[] start = new int[2];
			
			map = new int[m][n];
			for(int i=0; i<m; i++) {
				map[i] = Arrays.copyOf(picture[i], picture[i].length);
			}
			
			while ((start = newArea(m, n)) != null) {
				int ret = bfs(start, m, n);
				numberOfArea++;
				maxSizeOfOneArea = (maxSizeOfOneArea < ret ? ret : maxSizeOfOneArea);
			}

			int[] answer = new int[2];
			answer[0] = numberOfArea;
			answer[1] = maxSizeOfOneArea;
			return answer;
		}

		private int[] newArea(int m, int n) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0)
						return new int[] { i, j };
				}
			}
			return null;
		}

		int[][] map;
		int dr[] = { 0, -1, 0, 1 };
		int dc[] = { -1, 0, 1, 0 };

		public int bfs(int[] start, int m, int n) {
			Queue<int[]> queue = new LinkedList<>();

			int color = map[start[0]][start[1]];

			int area = 1;
			map[start[0]][start[1]] = 0;
			queue.add(start);

			while (!queue.isEmpty()) {
				int cur[] = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];

					if (nr < 0 || nr >= m || nc < 0 || nc >= n || color != map[nr][nc])
						continue;

					area++;
					map[nr][nc] = 0;
					queue.add(new int[] { nr, nc });
				}
			}
			return area;
		}
	}
}
