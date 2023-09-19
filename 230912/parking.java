import java.util.*;

class Solution {
    static class CarInfo {
        String carNum;
        int charge;
        int nujuc;
        
        CarInfo (String carNum, int charge, int nujuc) {
            this.carNum = carNum;
            this.charge = charge;
            this.nujuc = nujuc;
        }
        @Override
		public String toString() {
			return "CarInfo [carNum=" + carNum + ", charge=" + charge + ", nujuc=" + nujuc + "]";
		}
    }
    
    static ArrayList<CarInfo> list;
    public int[] solution(int[] fees, String[] records) {
        
        list = new ArrayList<> ();
        
        // 해당 차번호의 입출차 기록 구현
        String inTime = " ";
        String inNumber =  " ";
        String in =  " ";
        
        for (int i = 0; i < records.length; i++) {
            StringTokenizer st1 = new StringTokenizer(records[i]);
            inTime = st1.nextToken();
            inNumber = st1.nextToken();
            in = st1.nextToken();
            
            // 찾은 경우는 0 0 0 으로 변경되므로 이 경우는 탐색하지 않기,
            if (inTime.equals("0")) continue; 
            
            String outTime ="23:59";                  
            String outNumber=inNumber;
            String out="OUT"
		    
            for (int j = i; j < records.length; j++) {
                if (j == i) continue; // 같은 위치 건너뛰기
                StringTokenizer st2 = new StringTokenizer(records[j]);
                outTime = st2.nextToken();
                outNumber = st2.nextToken();
                out = st2.nextToken();
               
                if (outNumber.equals(inNumber)) {   // in - out 페어 찾은 경우!
                    records[j] = "0 0 0";           // 페어찾기 처리하기
                    break;                  // 찾은 경우 바로 빠져나오기
                }
                // 이거 한 이유 : 마지막까지 못찾으면 나간시간을 23:59로 해주고 번호도 inNumber로 해주어야하는데, 설정할 방법을 모르겠어서 하드코딩한것..
                outTime = "23:59";
                outNumber = inNumber;
                out = "OUT";
            }
          
            // 지금 주차 시간 계산하기
            int total = 0;
            StringTokenizer it = new StringTokenizer(inTime, ":");
            StringTokenizer ot = new StringTokenizer(outTime, ":");
            total += Integer.parseInt(ot.nextToken()) * 60 + Integer.parseInt(ot.nextToken());
            total -= Integer.parseInt(it.nextToken()) * 60 + Integer.parseInt(it.nextToken());
            
            // 지금 나온 경우에서 list,탐색하기 
            int listIndex = check(inNumber);
            
            if (listIndex == -1) { // list안에 차번호 없는경우..
                list.add(new CarInfo(outNumber, 0, total));
            } else {
                list.get(listIndex).nujuc += total;
            }
               
        }
	    
        for (CarInfo carInfo : list) {
                carInfo.charge = cal(carInfo.nujuc, fees);
        }
        
        list.sort((x1, x2) -> x1.carNum.compareTo(x2.carNum)) ;
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++) {
            answer[i] = list.get(i).charge;
        }
        
        return answer;
    }
    private static int check(String inNumber) {     // i = 이미 존재한다, 해당위치 인덱스리턴   ,, -1 : 같은 번호 없다. 또는 비어있다.
        for (int i = 0 ; i < list.size(); i++) {
            if (list.get(i).carNum.equals(inNumber)) {
                return i;      
            }
        }
        return -1;
    }
    
    private static int cal(int total, int[] fees) {   // 요금 계산함수
        if (total <= fees[0]) {
            return fees[1];
        } else {
            return
                fees[1] 
                +  (int) Math.ceil( ( total - (double) fees[0]  ) / fees[2] )  
                * fees[3];
        }
    }
    
}
