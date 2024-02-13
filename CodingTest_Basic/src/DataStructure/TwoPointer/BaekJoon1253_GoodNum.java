package DataStructure.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1253_GoodNum {
	// 수의 개수
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * N(수의 개수) A(수 데이터 저장 배열) for(N만큼 반복하기) { A 배열에 데이터 저장하기 } A 배열 정렬하기
		 * 
		 * for(k를 0부터 N까지 반복) { 변수 초기화하기(찾고자 하는 값 find, 포인터 i, 포인터 j) while(i<j) {
		 * if(A[i] + A[j]==찾고자 하는 값) { 두 포인터 i,j가 k가 아닐 때 결괏값에 반영 및 while 문 종료하기 두 포인터
		 * i,j가 k가 맞을 때 포인터 변경 및 계속 수행하기 } else if(A[i]+A[j] < 찾고자 하는 값) 포인터 i 증가 else
		 * 포인터 j 감소 } } 좋은 수의 개수 출력하기
		 */
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int Result = 0;
		long A[] = new long[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(A);
		for (int k = 0; k < N; k++) {
			long find = A[k];
			int i = 0;
			int j = N - 1;
			// 투 포인터 알고리즘
			while (i < j) {
				if (A[i] + A[j] == find) {
					// find는 서로다른 두 수의 합이어야 함을 체크
					if (i != k && j != k) {
						Result++;
						break;
					} else if (i == k) {
						i++;
					} else if (j == k) {
						j--;
					}
				} else if (A[i] + A[j] < find) {
					i++;
				} else {
					j--;
				}
			}
		}
		System.out.println(Result);
		bf.close();
	}

}
