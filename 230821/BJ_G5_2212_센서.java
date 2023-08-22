package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_G5_2212_센서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> censorList = new ArrayList<>();		/// 센서의 위치를 순차적으로 보기 위해서 리스트로 선언
		for (int i = 0; i < N; i++)		// 센서 위치 리스트 입력
			censorList.add(Integer.parseInt(st.nextToken()));
		Collections.sort(censorList);							/// 센서를 순자척으로 정렬
		
		ArrayList<Integer> distList = new ArrayList<>();		// 순차적 정렬을 통해서 각 센서 사이 거리를 저장하기위한 리스트 : 마친가지로 가장 큰 사이 거리를 알아내기위해 리스트로 선언
		for (int i = 1; i < N; i++)
			distList.add(censorList.get(i) - censorList.get(i - 1));	// 센서 사이 거리 구하기
		Collections.sort(distList);								// 가장 큰 사이 거리를 알아내기 위해 정렬.
		
		int answer = 0;
		for (int i = 0; i < N - 1 - (K - 1); i++)		// K-1개의 차이 거리를 계산에 포함시키지 않고 나머지 거리들 총합구하기
			answer += distList.get(i);
	}
}
