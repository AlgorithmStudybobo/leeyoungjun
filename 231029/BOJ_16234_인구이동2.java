package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동2 {

	static int N , L, R;
	static int[][] Map;
	static boolean[][] visited;
	static List<int[]> unionList;
	static boolean flag;
	/*
	 	
2 20 50
50 30
20 40
	 	
3 5 10
10 15 20
20 30 25
40 22 10
	 
	 */
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		Map = new int[N][N];
		
		for (int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 풀이
		int answer = 0;
		while (true) {
			// 매턴 방문배열 초기화
			visited = new boolean[N][N];
			flag = false;
			for (int i = 0 ; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// list 초기화
					unionList = new ArrayList<>();
					
					int pop = bfs(i, j);			// 리스트 담기
					// 담긴 리스트 계산하기
//					System.out.println(unionList);
					if (unionList.size() != 1) {
						popMove(pop);
					}
					
				}
			}
			// 탈출조건
			if (!flag) break;
			answer++;
//			break;
		}
		
		System.out.println(answer);
	}

	private static void popMove(int pop) {
		int div = pop / unionList.size();
		//System.out.println(div);
		for (int[] cell : unionList) {
			Map[cell[0]][cell[1]] = div;
		}
		
	}

	static int[] dr = new int[] {-1, 1 , 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	public static int bfs(int r, int c) {
		int pop = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		unionList.add(new int[] {r, c}); // 좌표 r, c, p 현재좌표 인구수
		pop += Map[r][c];
		queue.offer(new int[] {r, c});		
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] v = queue.poll();
			r = v[0];
			c = v[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;
				// 현재와 다음 좌표 인구차이 L<= 인구차 <=R 이라면  리스트에 넣기
				int gap = Math.abs(Map[r][c] - Map[nr][nc]);
				if ( L <= gap && gap <= R) {
					flag = true;
					unionList.add(new int[] {nr, nc});  // 좌표 nr, nc, np 현재좌표 인구수
					pop += Map[nr][nc];
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}

		return pop;
	}


}
