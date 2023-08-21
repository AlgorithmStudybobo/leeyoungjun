import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_야구공 {

	static int N;
	static int[][] ining;
	static boolean[] isSelected;
	static int[] hitOrder;
	static int[] player;
	static int maxScore;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// ining 개수	
		
		player = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};		// 9명의 선수
		hitOrder = new int[9];		// 타순
		isSelected = new boolean[9]; // 0 부터 8까지의 선수 선택여부
		
		// 이닝 정보 받기
		StringTokenizer st;
		ining = new int[N][9];
		for ( int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				ining[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 순열로 결정된 타순의 경우에서 나오는 총득점 결과 구하기
		maxScore = 0;
		perm(0);	
		System.out.println(maxScore);
	
	}

	
	// 처음 경기 시작전 타순 순서(순열) 구하기
		private static void perm(int cnt) {
			if (cnt == 9) {
//				System.out.println(Arrays.toString(hitOrder));
				// 지금 타순에서 전체 이닝 득점 구하기
				scoreCal();
				return;
			}
			
			if (cnt == 3) {	// 고정 타순
				hitOrder[cnt] = player[0];
				isSelected[0] = true;
				perm(cnt + 1);
			} else {
				for (int i = 1; i < 9; i++) {		// idx == 0번 선수는 무조건 순서 4번이다.를 생각. 따라서 1부터 시작
					if(isSelected[i]) continue;
					hitOrder[cnt] = player[i];
					isSelected[i] = true;
					perm(cnt + 1);
					isSelected[i] = false;
				}
			}
		}
		
		
		
//		static Queue<Integer> hitOrderQ; 
		private static void scoreCal() {
			int hitNow = 0;
			int score = 0; 
			// hitOrder에 있는 순으로 치게하기
			for (int i = 0; i < N; i++) { // 각 이닝
				int outCnt = 0;					// outCnt는 이닝마다 초기화
				boolean[] base = new boolean[4];	// {f, f, f, f} : 0 1 2 3 루   // 이닝마다 베이스 초기화
				
				///////////// outCnt가 3이 될때까지 이닝은 계속된다.
				while (true) {
					for ( ; hitNow < hitNow + 9; hitNow++) {	// 타자 기억하기..
//					System.out.print(ining[i][hitOrder[j]] + " ");
						
						///*///////////////////////////////////////////
						// 이닝 정보로 점수 내보기
						// ining[i][hitOrder[i]] == 이게 정보
						if (ining[i][hitOrder[hitNow%9]] == 0) {	// 아웃
							outCnt++;
							if (outCnt == 3) break;
							
						} else if (ining[i][hitOrder[hitNow%9]] == 4) {	// 홈런
							score++;
							for (int k = 1; k <= 3; k++) {
								if(base[k]) {
									base[k] = false;
									score++;
								}
							}
							
						} else {	// 1, 2, 3 루타 
							// 존재하는 주자 옮겨주기 
							for (int k = 3; k >= 1; k--) {	// 3루부터 달려줘야 안꼬인다.
								if (base[k]) {	// 주자 있는 경우
									int nk = k + ining[i][hitOrder[hitNow%9]]; // 주자 달려보고
									if (nk > 3) { 			// 홈 돌아온 경우면
										score++;
									} else { 				// 홈 아직 안돈경우, nk <= 3이면 옮기기
										base[nk] = true;
									}
									base[k] = false; // 이전 베이스 주자 없애기
								}
							}
							// 방금친 타자 옮기기
							base[ining[i][hitOrder[hitNow%9]]] = true;
						}
						//*///////////////////////////////////////////
					}
					if (outCnt == 3) {
						hitNow++;
						break;
					}
				}
				
			}
			maxScore = Math.max(maxScore, score);
//			System.out.println(score);	
		}
		
	
}
