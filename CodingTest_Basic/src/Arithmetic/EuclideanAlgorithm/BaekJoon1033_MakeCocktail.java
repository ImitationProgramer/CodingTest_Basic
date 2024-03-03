package Arithmetic.EuclideanAlgorithm;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon1033_MakeCocktail {
	static ArrayList<cNode>[] A;
	static long lcm;
	static boolean visited[];
	static long D[];

	public static void main(String[] args) {
		/*
		 * N(재료 개수) A(인접 리스트) lcm(최소공배수) D(각 노드값 저장 배열) visited(DFS를 탐색할 때 탐색 여부 저장 배열)
		 * 변수 초기화 수행하기 for(에지 개수) // 재료 개수 - 1 { 인접 리스트 배열에 이 에지 정보를 저장하기 최소 공배수 업데이트하기
		 * } 0번 노드에 최소 공배수 저장하기 0번에서 DFS 탐색 수행하기 DFS를 이용해 업데이트된 D 배열의 값들의 최대 공약수 계산하기 D
		 * 배열의 각 값들을 최대 공약수로 나눠 정답 출력하기
		 * 
		 * // 최대 공약수 gcd() 함수 구현하기 gcd{ if(b가 0이면) a가 최대 공약수 else{ // 재귀 함수 형태로 구현하기
		 * gcd(작은 수, 큰 수 % 작은 수) } } // 탐색 함수 구현하기 DFS{ visisted 배열에 현재 노드 방문 기록하기 현재
		 * 노드의 연결 노드 중 방문하지 않은 노드로 다음 노드의 값 = 현재 노드의 값 * 비율로 저장하기 DFS 실행하기(재귀 형태) } //
		 * 노드 클래스 선언하기 c 노드{ 다음 노드, 비율 1, 비율 2 }
		 */
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		A = new ArrayList[N];
		visited = new boolean[N];
		D = new long[N];
		lcm = 1;
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<cNode>();
		}
		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			A[a].add(new cNode(b, p, q));
			A[b].add(new cNode(a, q, p));
			lcm *= (p * q / gcd(p, q));// 최소 공배수는 두 수의 곱을 최대 공약수로 나눈 것
		}
		D[0] = lcm;
		DFS(0);
		long mgcd = D[0];
		for (int i = 1; i < N; i++) {
			mgcd = gcd(mgcd, D[i]);
		}
		for (int i = 0; i < N; i++) {
			System.out.print(D[i] / mgcd + " ");
		}
	}

	public static long gcd(long a, long b) { // 최대공약수 함수 구현하기
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void DFS(int Node) { // DFS 구현하기
		visited[Node] = true;
		for (cNode i : A[Node]) {
			int next = i.getB();
			if (!visited[next]) {
				D[next] = D[Node] * i.getQ() / i.getP();
				DFS(next);
			}
		}

	}
}

class cNode {
	int b;
	int p;
	int q;

	public cNode(int b, int p, int q) {
		super();
		this.b = b;
		this.p = p;
		this.q = q;
	}

	public int getB() {
		return b;
	}

	public int getP() {
		return p;
	}

	public int getQ() {
		return q;
	}
}
