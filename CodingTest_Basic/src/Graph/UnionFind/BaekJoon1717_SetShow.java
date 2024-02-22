package Graph.UnionFind;

import java.util.Scanner;

public class BaekJoon1717_SetShow {
	public static int[] parent;

	public static void main(String[] args) {
		/*
		 * N(원소 개수) M(질의 개수) parent(대표 노드 저장 배열) for(N만큼 반복하기){ 대표 노드를 자기 자신으로 초기화하기 }
		 * for(M만큼 반복하기){ if(0이면) 집합 합치기 -> union 연산 else와 같은 집합 원소인지 확인하고 결괏값 출력하기 } //
		 * union 연산 union(a, b){ a와 b의 대표 노드 찾기 두 원소의 대표 노드끼리 연결하기 } //find 연산 find(a){
		 * a가 대표 노드면 리턴 아니면 a의 대표 노드값을 find(parent[a]) 값으로 저장 -> 재귀 함수 형태 } //
		 * checkSame-> 두 원소가 같은 집합인지 확인 checkSame(a, b){ a와 b의 대표 노드 찾기 두 대표 노드가 같으면
		 * true 아니면 false return }
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) { // 대표 노드를 자기 자신으로 초기화하기
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			int question = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (question == 0) { // 집합 합치기
				union(a, b);
			} else { // 같은 집합의 원소인지 확인하기
				if (checkSame(a, b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	public static void union(int a, int b) { // union 연산: 대표 노드끼리 연결하기
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}

	}

	public static int find(int a) { // find 연산
		if (a == parent[a])
			return a;
		else
			return parent[a] = find(parent[a]); // 재귀 함수의 형태로 구현 -> 경로 압축 부분
	}

	public static boolean checkSame(int a, int b) { // 두 원소가 같은 집합인지 확인하기
		a = find(a);
		b = find(b);
		if (a == b) {
			return true;
		}
		return false;
	}
}
