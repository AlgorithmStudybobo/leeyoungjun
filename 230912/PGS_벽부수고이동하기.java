package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class PGS_벽부수고이동하기 {

	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int answer;
	
	static class Node {
		int r;
		int c;
		boolean hammer;
		int cnt;
		public Node(int r, int c, int cnt, boolean hammer) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.hammer = hammer;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", hammer=" + hammer + ", cnt=" + cnt + "]";
		}
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		visited = new boolean[N][M][2];	
		
//		bfs( );	
		answer = -1;
		bfs(0, 0, new Node(0, 0, 1, false));
		
		System.out.println(answer);
		
	}

	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0 ,-1, 0, 1};
	private static void bfs(int i, int j, Node node) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			node = queue.poll();

			if (node.r == N-1 && node.c == M-1) {
//				System.out.println(node.cnt);
				answer = node.cnt;
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue; 
				int nextCnt = node.cnt + 1;
				
				
				if (map[nr][nc] == 0) {
					if (!node.hammer && !visited[nr][nc][0]) {
						queue.offer(new Node(nr, nc, nextCnt, false));
						visited[nr][nc][0] = true;
					} else if (node.hammer && !visited[nr][nc][1]) {
						queue.offer(new Node(nr, nc, nextCnt, true));
						visited[nr][nc][1] = true;
					}
					
				} else if (map[nr][nc] == 1) {
					if (!node.hammer) {
						queue.offer(new Node(nr, nc, nextCnt, true));
						visited[nr][nc][1] = true;
					}
				}
			}
			
		}		
	}
	
}
	