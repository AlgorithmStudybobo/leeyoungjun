package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3499 {

    public static void main(String args[]) throws Exception
    {

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] deque = new String[N];
            for (int i = 0; i < N; i++) {
                deque[i] = st.nextToken();
            }

            System.out.print("#"+test_case);
            ////////////   짝, 홀 경우 나누기   ////////////
            if (N%2 == 0) { // 짝수 경우
                for (int i = 0; i < N/2; i++) {
                    System.out.print(" "+deque[i]);
                    System.out.print(" "+deque[i+(N/2)]);
                }
            } else { // 홀수 경우
                for (int i = 0; i < N/2; i++) {
                    System.out.print(" "+deque[i]);
                    System.out.print(" "+deque[i+(N/2)+1]);
                }
                System.out.print(" "+ deque[(N/2)]);
            }
            System.out.println();
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}



/*
        3
        6
        A B C D E F
        4
        JACK QUEEN KING ACE
        5
        ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA

 */
