package Greedy.GreedyAlgorithm;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon1744_BiggestNumTie {

	public static void main(String[] args) {
		/*
		 * N(카드 묶음 개수) plusPq(양수 우선순위 큐) minusPq(음수 우선순위 큐) one(1의 개수 카운트) zero(0의 개수
		 * 카운트) for(N만큼 반복하기){ 데이터를 4개의 그룹에 분리 저장하기 } while(양수 우선순위 큐 크기가 2보다 작을 때까지){ 수
		 * 2개를 큐에서 뽑음(remove 연산) 2개의 수를 곱한 값을 결괏값에 더함 } 양수 우선순위 큐에 데이터가 남아 있으면 이 데이터를
		 * 결괏값에 더함
		 * 
		 * while(음수 우선순위 큐 크기가 2보다 작을 때까지){ 수 2개를 큐에서 뽑음(remove 연산) 2개의 수를 곱한 값을 결괏값에 더함
		 * } 음수 우선순위 큐에 데이터가 남아 있고, 데이터 0이 1개도 없으면 이 데이터를 결괏값에 더함
		 * 
		 * 숫자 1의 개수를 결괏값에 더함 결괏값 출력
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 카드 묶음의 수 저장하기
		// 양수는 내림차순 정렬하기
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusPq = new PriorityQueue<>();
		int one = 0;
		int zero = 0;
		for (int i = 0; i < N; i++) { // 4개의 그룹으로 분리해 저장하기
			int data = sc.nextInt();
			if (data > 1) {
				plusPq.add(data);
			} else if (data == 1) {
				one++;
			} else if (data == 0) {
				zero++;
			} else {
				minusPq.add(data);
			}
		}
		int sum = 0;
		// 양수 처리하기
		while (plusPq.size() > 1) {
			int first = plusPq.remove();
			int second = plusPq.remove();
			sum = sum + first * second;
		}
		if (!plusPq.isEmpty()) {
			sum = sum + plusPq.remove();
		}
		// 음수 처리하기
		while (minusPq.size() > 1) {
			int first = minusPq.remove();
			int second = minusPq.remove();
			sum = sum + first * second;
		}
		if (!minusPq.isEmpty()) {
			if (zero == 0) {
				sum = sum + minusPq.remove();
			}
		}
		// 1 처리하기
		sum = sum + one;
		System.out.println(sum);
	}

}
