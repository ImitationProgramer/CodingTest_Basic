package Tree.KnowAboutTree;

import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon1068_FindLeafNode {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer =0;
    static int deleteNode =0;
    public static void main(String[] args) {
        /*
        * N(노드 개수)
        * tree(트리 데이터 저장 인접 리스트)
        * visited(방문 기록 저장 배열)
        * answer(리프 노드 개수 저장 변수)
        * deleteNode(삭제 노드)
        * for(N의 개수만큼 반복하기){
        *   tree 인접 리스트의 각 ArrayList 초기화하기
        * }
        * for(N의 개수만큼 반복하기){
        *   if(루트 노드가 아닌 경우)
        *       tree 인접 리스트에 트리 데이터 저장하기
        *   else
        *       루트 노드값 저장하기
        * }
        * 삭제 노드값 저장하기
        * if(삭제 노드값이 0) 모두 삭제되므로 0을 출력하고 프로세스 끝냄
        * else DFS(root)    // 루트 노드부터 DFS 실행하기
        *   answer 출력하기
        * // DFS 구현하기
        * DFS{
        *   방문 배열에 현재 노드 방문 기록하기
        *   for(연결 노드 탐색하기){
        *       현재 노드의 연결 노드 중 방문하지 않은 노드이고 삭제 노드가 아닐때
        *           자식 노드 개수 증가
        *       DFS 실행하기(재귀 함수 형태)
        *   }
        *   만약 자식 노드 개수가 0이면 answer 변수 증가
        * }
        * */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N];
        visited = new boolean[N];
        int root =0;
        for(int i=0;i<N;i++)
            tree[i]=new ArrayList<Integer>();
        for(int i=0;i<N;i++){
            int p = sc.nextInt();
            if(p!=-1){
                tree[i].add(p);
                tree[p].add(i);
            }else
                root=i;
        }
        deleteNode = sc.nextInt();
        if(deleteNode==root)
            System.out.println(0);
        else{
            DFS(root);
            System.out.println(answer);
        }
    }
    static void DFS(int number){
        visited[number] = true;
        int cNode =0;
        for(int i : tree[number]){
            if(!visited[i] && i != deleteNode){   // 삭제 노드가 아닐때도 탐색 중지
                cNode++;
                DFS(i);
            }
        }
        if(cNode==0)
            answer++;   // 자식 노드가 아닐 때 리프 노드로 간주하고 정답값 증가
    }
}
