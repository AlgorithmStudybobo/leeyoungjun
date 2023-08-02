package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class swea_4047 {
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            /////////////////////////////////////////////////////////////////////////////////////////////
            String[] Arr = br.readLine().split("");
            int[] S = new int[14];
            int[] D = new int[14];
            int[] H = new int[14];
            int[] C = new int[14];
//            System.out.println(Arrays.toString(Arr));
//            System.out.println(Arr.length);   // 길이 확인 코드

            boolean isError = false;

            System.out.print("#"+T+" ");
            for (int i = 2; i < Arr.length; i += 3) {
//                System.out.println(i);    // 인덱스 확인 코드
                int start = i - 2;    // start가 문자인 경우에만 뒤 2개를 묶어서 파스인트하고 해당 배열의 인덱스 위치가 0이라면 +1 하고싶어
                int middle = i - 1;
                int end = i;

                int cNum = Integer.parseInt(Arr[middle] + Arr[end]);
                switch (Arr[start]) {
                    case "S":
                        if (S[cNum] != 0) isError = true;
                        else S[cNum] = 1;
                        break;
                    case "D":
                        if (D[cNum] != 0) isError = true;
                        else D[cNum] = 1;
                        break;
                    case "H":
                        if (H[cNum] != 0) isError = true;
                        else H[cNum] = 1;
                        break;
                    case "C":
                        if (C[cNum] != 0) isError = true;
                        else C[cNum] = 1;
                        break;
                }
            }
            if (isError) {
                System.out.println("ERROR");
                break; // 중간에 겹치는거 존재경우 에러 발생 + 다음케이스로 이동
            }
            // 각 경우 결과 출력
            System.out.print(13-Arrays.stream(S).sum() + " ");
            System.out.print(13-Arrays.stream(D).sum()+ " ");
            System.out.print(13-Arrays.stream(H).sum()+ " ");
            System.out.print(13-Arrays.stream(C).sum());

        }
        System.out.println();
    }
}



//3
//S01D02H03H04
//H02H10S11H02
//S10D10H10C01

//1
//H02H10S11H02