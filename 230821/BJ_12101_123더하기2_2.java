import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ_12101_123더하기2_2 {
	
	static int target;
	static int K;
	static int[] input = {1, 2, 3};
	static int[] numbers;
	static ArrayList<String> targetList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		target = sc.nextInt();
		K = sc.nextInt();
		targetList = new ArrayList<>();
		int R = target;
		
		for (int r = R; r >= 1; r--) {
			numbers = new int[r];
			perm(0, 0, r);
		}

		Collections.sort(targetList);
		
//		for (int i = 0; i < targetList.size(); i++) {
//			System.out.println(targetList.get(i));
//		}
		
		if (K > targetList.size()) {
			System.out.println(-1);
		} else {
			// K-1꺼를 주어야한다.
			for (int i = 0; i < targetList.get(K-1).length()-1; i++) {
				System.out.print( targetList.get(K-1).charAt(i) + "+");
			}
			System.out.print(targetList.get(K-1).charAt(targetList.get(K-1).length()-1));

		}
		
	}

	private static void perm(int cnt, int sum, int r) {
		if (cnt == r) {
			if (sum == target) {
//				System.out.println(Arrays.toString(numbers));
				String temp = "";
				for (int number : numbers) temp += number;
				targetList.add(temp);
			}
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			numbers[cnt] = input[i];
			perm(cnt + 1, sum + input[i], r);
		}
	}


}
