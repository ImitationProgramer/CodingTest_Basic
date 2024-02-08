package DataStructure.TwoPointer;

import java.util.Scanner;

public class BaekJoon2018_ContinueSum {

	public static void main(String[] args) {
		/*
		 * N 변수 저장 사용 변수 초기화(count = 1,start_index=1,end_index=1,sum=1)
		 * while(end_index!=N){ if(sum==N) count 증가, end_index 증가, sum값 변경 else
		 * if(sum>N) sum값 변경, start_index 증가 else if(sum<N) end_index증가, sum값 변경 } count
		 * 출력하기
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1;
		int start_index = 1;
		int end_index = 1;
		int sum = 1;
		while (end_index != N) {
			if (sum == N) { // 현재 연속 합이 N과 같은 경우
				count++;
				end_index++;
				sum = sum + end_index;
			} else if (sum > N) { // 현재 연속 합이 N보다 더 큰 경우
				sum = sum - start_index;
				start_index++;
			}
		}
	}

}
