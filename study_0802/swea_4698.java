package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4698 {
    public static void main(String[] args) throws Exception {
        // 입력 범위 내의 소수를 판별하는 에라토스테네스의 채 필요 // isPrime[] 배열 만들기
        int[] isPrime = new int[1000001];
        isPrime[0] = 1;
        isPrime[1] = 1;
        // 해당 인덱스가 소수면 1인 배열로 만들기
        for (int i = 2; i < isPrime.length; i++) {
            for (int j = i; j < isPrime.length; j+=i) {
                if (j == i) continue;
                if (j % i == 0) isPrime[j] = 1;
            }
        }
        //        System.out.println(Arrays.toString(isPrime)); // 소수채 정상 확인 완료
            // isPrime[i] == 1이면 소수;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // testcase 입력
        for (int test_case = 1; test_case <= T; test_case++) {
            int D, A, B;    // 입력 받기 D, A, B
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // 입력 확인 System.out.println(D +" "+ A +" "+ B);

            // D를 포함하고 있는 수 중에서 소수 찾기 == 소수중에서 D를 포함하는 수 찾기
                // ㄴD 포함 == true && isPrime[i] == 1인 경우 찾기

            int cnt = 0; // 조건을 만족하는 소수 개수 설정

            for (int k = A; k <= B; k++) {
                if ( isPrime[k] == 0 && Integer.toString(k).contains(Integer.toString(D)) ) {
                    cnt++;
                }
            }
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}



//2
//3 10 30
//7 1 1000000
