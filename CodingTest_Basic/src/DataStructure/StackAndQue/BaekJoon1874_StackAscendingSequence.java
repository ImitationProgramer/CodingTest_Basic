package DataStructure.StackAndQue;

import java.util.Scanner;
import java.util.Stack;

public class BaekJoon1874_StackAscendingSequence {

	public static void main(String[] args) {
		/*
		 * N(수열 개수) A[](수열 배열) 수열 배열 채우기 for(N만큼 반복) { if(현재 수열 값 >= 오름차순 자연수) {
		 * while(값이 같아질 때까지) { push() (+)저장 } pop() (-)저장 } else(현재 수열 값 < 오름차순 자연수){
		 * pop() if(스택 pop 결괏값 > 수열의 수) NO 출력 else(-) 저장 } } if(NO 값을 출력한 적이 없으면) 저장한 값
		 * 출력
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		StringBuffer bf = new StringBuffer();
		int num = 1; // 오름차순 수
		boolean result = true;
		for (int i = 0; i < A.length; i++) {
			int su = A[i]; // 현재 수열의 수
			if (su >= num) { // 현재 수열 값 >= 오름차순 자연수: 값이 같아질 때 까지 push() 수행
				while (su >= num) { // push()
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			} else { // 현재 수열 값 < 오름차순 자연수: pop()을 수행해 수열 원소를 꺼냄
				int n = stack.pop();
				// 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
				if (n > su) {
					System.out.println("NO");
					result = false;
					break;
				} else {
					bf.append("-\n");
				}
			}
		}
		if (result)
			System.out.println(bf.toString());
	}

}
