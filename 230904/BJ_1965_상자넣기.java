package boj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BJ_1965_상자넣기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		int answer = 0;
		
		for (int i = 1; i < N; i++) {	// 인덱스 0 (첫번째 원소는 계산 필요 x )
			for (int j = 0; j < i; j++) {	// 처음부터 i까지 확인하는 경우가 필요.
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			answer = Math.max(dp[i], answer);
			
		}
		
		System.out.println(answer);
	}

}
