package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_5356 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            System.out.print("#" + tc + " " );
            String[][] Arr = new String[5][16];
            // 5단어 입력 + 2차원 배열에 저장
            for (int i = 0; i < 5; i++) {
                String[] wordArr = br.readLine().split(""); // 각 단어 한줄씩 받아서 배열로 저장
                for (int j = 0; j < wordArr.length; j++) {
                    Arr[i][j] = wordArr[j];// 저장된 단어를 2차월배열에 재 할당
                }
//                System.out.println(Arrays.toString(Arr[i])); // 2차원 배열 각 라인 확인 코드
            }

            // 2차원 배열 새로로 재출력
            for (int j = 0; j < 16; j++) {
                for (int i = 0; i < 5; i++) {
                    if ( Arr[i][j] != null) System.out.print(Arr[i][j]);
                }
            }
            System.out.println();
        }
    }
}

//2
//ABCDE
//abcde
//01234
//FGHIJ
//fghij
//AABCDD
//afzz
//09121
//a8EWg6
//P5h3kx

