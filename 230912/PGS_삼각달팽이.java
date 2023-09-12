package com.ssafy.algo;
import java.util.*;


public class PGS_삼각달팽이  {
    
    static int N;
    static int[][] triMap;
    static int[] dr = {1, 0, -1};
    static int[] dc = {0, 1, -1};
        
    public int[] solution(int n) {
        int k = 0;
        for (int i = 1; i <= n; i++) {
            k += i;
        }
        int[] answer = new int[k];
         
        N = n;
        triMap = new int[N][N];
        
        // 0 , 0,  1, 0
        bangle (0, 0, 1, 0);
    
        // for (int i = 0 ; i < n; i++ ) {
        //     System.out.println(Arrays.toString(triMap[i]));
        // }
        int idx = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (triMap[i][j] == 0) continue;
                answer[idx] = triMap[i][j];
                idx++;
            }
        }
        
        return answer;
    }

    private static void bangle (int r, int c, int start, int cnt) {
        triMap[r][c] = start;
        for (int d = 0; d < 3; d++) {
            while (true) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N-cnt || nc >= nr+1-cnt) break;
                if (triMap[nr][nc] != 0) {
                    // r, c에는 남아있다. r,c +1, 0 시킨상태로 넘겨주던지 해야한다.
                    r = r + 1;
                    c = c;
                    if (r < 0 || c < 0 || r >= N || c >= N ) break;
                    if (triMap[r][c] != 0) break; //할당값이 있는 것이니 취소
                    bangle(r, c, start + 1, cnt + 1);
                    break;
                }
                triMap[nr][nc] = ++start;
                r = nr;
                c = nc;
            }
        }
    }
    
    
}