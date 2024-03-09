package Tree.KnowAboutTree;

import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon11725_FindTreesParent {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer> tree[];
    static int answer[];
    public static void main(String[] args) {
        /*
         * N(노드 개수)
         * tree(트리 데이터 저장 인접 리스트)
         * visited(방문 기록 저장 배열)
         * answer(부모 노드 저장 정답 배열)
         * for(N의 개수만큼 반복하기){
         *   tree 인접 리스트의 각 ArrayList 초기화하기
         * }
         * for(N - 1의 개수만큼 반복하기){
         *   tree 인접 리스트에 트리 데이터 저장하기
         * }
         * 1번 노드부터 DFS 실행하기
         * for(2 ~ N 반복하기){
         *   answer 배열 출력하기
         * }
         * // DFS 구현하기
         * DFS{
         *   visited 배열에 현재 노드 방문 기록하기
         *   if(현재 노드의 연결 노드 중 방문하지 않은 노드){
         *       부모 노드 저장하기
         *       DFS 실행하기(재귀 함수 형태)
         *   }
         * }
         * */
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        answer = new int[N + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i=1;i<N;i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        DFS(1);     // 부모 노드부터 DFS 시작
        for(int i=2;i<=N;i++){
            System.out.println(answer[i]);
        }
    }
    static void DFS(int number){
        visited[number]=true;
        for(int i:tree[number]){
            if(!visited[i]){
                answer[i]=number;       // DFS를 탐색하면서 부모 노드를 정답 배열에 저장
                DFS(i);
            }
        }
    }
}
