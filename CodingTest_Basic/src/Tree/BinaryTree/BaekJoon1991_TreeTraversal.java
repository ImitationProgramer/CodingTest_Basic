package Tree.BinaryTree;

import java.util.Scanner;

public class BaekJoon1991_TreeTraversal {
    static int[][] tree;
    public static void main(String[] args) {
        /*
        * N(노드 개수), tree(tree 데이터 저장 2차원 배열)
        * for(N의 개수만큼 반복하기){
        *   if(왼쪽 자식 노드가 없을 때)
        *       tree 배열에 -1 저장하기
        *   else
        *       tree 배열에 왼쪽 자식 노드 인덱스 저장하기
        *   if(오른쪽 자식 노드가 없을 때)
        *       tree 배열에 -1 저장하기
        *   else
        *       tree 배열에 오른쪽 자식 노드 인덱스 저장하기
        * }
        * preOrder 실행하기 -> inOrder 실행하기 -> postOrder 실행하기
        * preOrder{ // preOrder 구현하기 : 중간-왼쪽-오른쪽    (전위 순회)
        *   현재값이 -1이면 리턴(자식 노드가 없으면)
        *   1. 현재 노드 출력하기
        *   2. 왼쪽 자식 노드 탐색하기
        *   3. 오른쪽 자식 노드 탐색하기
        * }
        * inOrder{  // inOrder 구현하기 : 왼쪽-중간-오른쪽     (중위 순회)
        *   현재값이 -1이면 리턴하기(자식 노드가 없으면)
        *   1. 왼쪽 자식 노드 탐색하기
        *   2. 현재 노드 출력하기
        *   3. 오른쪽 자식 노드 탐색하기
        * }
        * postOrder{    // postOrder 구현하기 : 왼쪽-오른쪽-중간   (후위 순회)
        *   현재 값이 -1이면 리턴하기(자식 노드가 없으면)
        *   1. 왼쪽 자식 노드 탐색하기
        *   2. 오른쪽 자식 노드 탐색하기
        *   3. 현재 노드 출력하기
        * }
        * */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        tree = new int[26][2];  // 0 -> 왼쪽 자식 노드(1) -> 오른쪽 자식 노드(2)
        for(int i=0;i<n;i++){
            String[] temp = sc.nextLine().split(" ");
            int node = temp[0].charAt(0)-'A';   // index로 변환하기 위해 A 문자 빼기
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);
            // 자식 노드가 없을 때 -1을 저장하기
            if(left =='.'){
                tree[node][0]=-1;
            }else{
                tree[node][0] = left -'A';
            }
            if(right == '.'){
                tree[node][1]=-1;
            }else{
                tree[node][1]=right-'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
    public static void preOrder(int now){
        if(now==-1)
            return;
        System.out.print((char)(now+'A'));      // 1. 현재 노드
        preOrder(tree[now][0]);                 // 2. 왼쪽 탐색하기
        preOrder(tree[now][1]);                 // 3. 오른쪽 탐색하기
    }
    public static void inOrder(int now){
        if(now==-1)
            return;
        inOrder(tree[now][0]);                  // 1. 왼쪽 탐색하기
        System.out.print((char)(now+'A'));      // 2. 현재 노드
        inOrder(tree[now][1]);                  // 3. 오른쪽 탐색하기
    }
    public static void postOrder(int now){
        if(now==-1)
            return;
        postOrder(tree[now][0]);                // 1. 왼쪽 탐색하기
        postOrder(tree[now][1]);                // 2. 오른쪽 탐색하기
        System.out.print((char)(now +'A'));     // 3. 현재 노드
    }
}
