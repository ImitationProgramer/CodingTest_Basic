package Greedy.GreedyAlgorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon1715_CardSort {

	public static void main(String[] args) {
		/*
		 * N(카드 묶음 개수) pq(우선순위 큐) for(N만큼 반복하기){ 우선순위 큐에 데이터 저장하기 } // 자동 정렬에 따라 작은 카드
		 * 묶음 2개를 쉽게 뽑을 수 있음 while(우선순위 큐 크기가 1이 될 때까지){ 2개 카드 묶음을 큐에서 뽑음(remove 연산) 2개
		 * 카드 묶음을 합치는 데 필요한 비교 횟수를 결괏값에 더함 2개 카드 묶음의 합을 우선순위 큐에 다시 넣음(add 연산) } // 누적된
		 * 비교 횟수 출력하기
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 카드 묵음의 수 저장
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int data = sc.nextInt();
			pq.add(data);
		}
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		while (pq.size() != 1) {
			data1 = pq.remove();
			data2 = pq.remove();
			sum += data1 + data2;
			pq.add(data1 + data2);
		}
		System.out.println(sum);
	}

}
