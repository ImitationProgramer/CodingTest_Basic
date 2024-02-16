package DataStructure.StackAndQue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BaekJoon17298_OhBigNum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * N(수열 개수) A[](수열 배열) ans[](정답 배열) 수열 배열 채우기 최초 스택 초기화 하기 for(N만큼 반복){
		 * while(스택이 비어 있지 않고, 현재 수열 값ㅇ이 top에 해당하는 수열보다 클 때까지){ pop() 정답 배열에 오큰수를 현재 수열로
		 * 저장하기 } 현재 수열을 스택에 push() } while(스택이 빌 때까지){ 스택에 있는 인덱스의 정답 배열에 -1 저장하기 } 정답
		 * 배열 출력하기
		 */
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] A = new int[n]; // 수열 배열 생성
		int[] ans = new int[n]; // 정답 배열 생성
		String[] str = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(str[i]);
		}
		Stack<Integer> myStack = new Stack<>();
		myStack.push(0); // 처음에는 항상 스택이 비어 있으므로 최초 값을 push해 초기화
		for (int i = 1; i < n; i++) {
			// 스택이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리ㅣ는 수열보다 클 경우
			while (!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
				ans[myStack.pop()] = A[i]; // 정답 배열에 오큰수를 현재 수열로 저장하기
			}
			myStack.push(i); // 신규 데이터 push
		}
		while (!myStack.empty()) {
			// 반복문을 다 돌고 나왔는데 스택이 비어 있지 않다면 빌 때까지
			ans[myStack.pop()] = -1;
			// 스택에 쌓인 index에 -1을 넣고
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			bw.write(ans[i] + " ");
			// 출력한다.
		}
		bw.write("\n");
		bw.flush();
	}

}
