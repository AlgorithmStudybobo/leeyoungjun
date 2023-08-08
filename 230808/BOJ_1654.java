package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1654 {
    // 시작 시간 8시 10분
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(arr).max().getAsInt();  // 가장 큰 숫자 : 가장 큰 숫자로 나누기 시작해서 구하려 시도.
                                                            // 이 부분에서 시작하는 것으로 시간초과 발생
        int answer = 0;
        int cnt;
        while (true) {
            cnt = 0;
            // 반복해서 자르기
            for (int i = 0; i < K; i++) {                   // 2중 반복문으로 시간초과 발생
                cnt += arr[i] / max;
            }

            // N개와 같거나 많을 때, 정답
            if (cnt >= N) {
                answer = max;
                break;
            }
            max--;
        }

        System.out.println(answer);
    }
}
