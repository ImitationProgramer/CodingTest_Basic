package DataStructure.SumOfSections;

import java.util.Scanner;

public class BaekJoon10986_SumLeftOver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * N 입력받기(수열의 개수) M 입력받기(나누어떨어져야 하는 수) S 선언하기(합 배열) C 선언하기(같은 나머지의 인덱스를 카운트하는
		 * 배열) for(i->1~N){ S[i]=S[i-1]+A[i] // 합 배열 저장 } for(i->0~N){ remainder =
		 * S[i]%M // 합 배열을 M으로 나눈 나머지 값 if(remainder==0)정답을 1 증가시키기 C[remainder]의 값을 1
		 * 증가시키기 } for(i->0~M){ C[i](i가 나머지인 인덱스의 개수)에서 2가지를 뽑는 경우의 수를 정답에 더하기 // C[i]개
		 * 중 2개를 뽑는 경우의 수 계산 공식 C[i]*(C[i]-1) / 2 } 결괏값 출력
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] S = new long[N];
		long[] C = new long[M];
		long answer = 0;
		S[0] = sc.nextInt();
		for (int i = 1; i < N; i++) { // 수열 합 배열 만들기
			S[i] = S[i - 1] + sc.nextInt();
		}
		for (int i = 0; i < N; i++) { // 합 배열의 모든 값에 % 연산 수행하기
			int remainder = (int) (S[i] % M);
			// 0 ~ i까지의 구간 합 자체가 0일 때 정답에 더하기
			if (remainder == 0)
				answer++;
			// 나머지가 같은 인덱스의 개수 카운팅하기
			C[remainder]++;
		}
		for (int i = 0; i < M; i++) {
			if (C[i] > 1) {
				// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		System.out.println(answer);
	}

}
