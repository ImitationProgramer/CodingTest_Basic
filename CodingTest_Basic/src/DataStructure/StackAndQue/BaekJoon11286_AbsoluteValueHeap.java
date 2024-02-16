package DataStructure.StackAndQue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BaekJoon11286_AbsoluteValueHeap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * N(질의 요청 개수) 우선 순위 큐 선언 - 절댓값 기준으로 정렬되도록 설정하기 - 단, 절댓값이 같으면 음수 우선 정렬하기 for(N만큼
		 * 반복) { 요청이 0일 때: 큐가 비어 있으면 0 , 비어 있지 않으면 큐의 front값 출력하기(poll()) 요청이 1일 때: 새로운
		 * 데이터를 우선순위 큐에 더하기(add()) }
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> MyQueue = new PriorityQueue<Integer>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if (first_abs == second_abs)
				return o1 > o2 ? 1 : -1; // 절댓값이 같으면 음수 우선 정렬하기
			else
				return first_abs - second_abs; // 절댓값을 기준으로 정렬하기
			// 만약 절댓값이 큰 기준으로 정렬을 한다면 return second_abs - first_abs;로 설정을 해야한다.
		});
		for (int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			if (request == 0) {
				if (MyQueue.isEmpty())
					System.out.println("0");
				else
					System.out.println(MyQueue.poll());
			} else {
				MyQueue.add(request);
			}
		}
	}

}
