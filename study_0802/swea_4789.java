package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_4789 {
    public static void main(String args[]) throws Exception {
    /////////////////////////////////////////////////////////////////////////////////////////////
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] arr =  br.readLine().split("");
            int nowClab = Integer.parseInt(arr[0]);
            int needPerson = 0;
//            System.out.println(nowClab);

            for (int i = 1; i< arr.length; i++) {
//                System.out.println(i);

                if (nowClab >= i) {
                    nowClab += Integer.parseInt(arr[i]);
                } else {
                    needPerson += (i - nowClab);
//                    nowClab += needPerson;    // 이거 왜 안되는지 이해가 안간다
                    nowClab = i + Integer.parseInt(arr[i]); // 해당 부분이 나오는 이유는?
                                                                // 이유 == 조건을 만족하는 최소 nowClab 수는 i(앞에 존재해야하는 인원수)명
                                                                        // + i번째에 해당하는 인원수 추가 이므로 다음과 같은 결론이 나옴
                }
//                System.out.println(nowClab);
//                System.out.println(needPerson);
            }
            System.out.println("#" + test_case + " " + needPerson);
        }
    /////////////////////////////////////////////////////////////////////////////////////////////
    }
}
