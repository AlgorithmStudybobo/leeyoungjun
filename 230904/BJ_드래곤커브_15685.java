package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_드래곤커브_15685 {

	static int N;
	static int[][] map = new int[101][101];	// 0 부터 100까지의 맵
	static int answer = 0;
	static ArrayList<Integer> dList;	// 이동방향이 담긴 리스트
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) { // 각 행을 입력 받을 때 마다 구현하기
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());	// 열
			int y = Integer.parseInt(st.nextToken());	// 행 	
			int d = Integer.parseInt(st.nextToken());	// 시작 방향
			int g = Integer.parseInt(st.nextToken());	// 세대 번호 : 좌표 개수를 알려주는 단서
			
			dList = new ArrayList<>();
			// c를 단서로 이동방향을 만들어 리스트에 넣기 : 매개변수 시작방향인 
			
			makeCurve(d, g);	// 시작 방향 , 세대번호
//			System.out.println(dList);
			simul(x, y);		//만들어진 리스트 기준으로 좌표 찍기;
		}
		
		// 모두 구현하고 나서, 조건에 맞는 정사각형 개수 구하기 + 출력하기
		countMap();
		System.out.println(answer);

	}

	private static void countMap() {
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (map[i-1][j]==1 && map[i][j-1]==1 && map[i][j]==1 && map[i-1][j-1]==1)
					answer++;
			}
		}
		
		
	}

	static int[] dy = {0, -1, 0, 1}; // 우 상 좌 상 순서
	static int[] dx = {1, 0, -1, 0};
	
	private static void simul(int x, int y) {	// 시작점을 기준을 좌표 찍기 
		int ny = y;
		int nx = x;
		
		map[y][x] = 1;	// 시작점 먼저 찍기
		for (int i = 0; i < dList.size(); i++) {  // 리스트에 있는 방향 따라가면서 1찍기
			int d = dList.get(i);
			
			ny += dy[d];
			nx += dx[d]; 
			map[ny][nx] = 1;  
		}
	}

	private static void makeCurve(int d, int g) {
		dList.add(d);	// 처음 방향 넣기
		// 세대 번호만큼 반복해서 리스트를 채워넣는다.
		for (int i = 0; i < g; i++) {
			int size = dList.size();
			
			// 역순의 +1 을 넣어준다.
			for (int j = 1 ; j <= size; j++) {
				dList.add( (dList.get(size - j) + 1) % 4);	/// 4가 되면 다시 맨앞의 경우의 방향으로 돌아와야하므로 %4하기
			}
		}
		
	}

	
	
}
