package Tree.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10868_FindMin2 {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        /*
        * tree(세그먼트 트리 배열)
        * N(수의 개수), M(최솟값을 구하는 횟수)
        * treeSize 구하기 -> Math.pow(2, 트리의 높이 + 1)
        * leftNodeStartIndex 구하기 -> treeSize / 2 - 1    // 리프 노드 시작 인덱스
        * 트리 초기화하기(모든 값을 Max값으로 초기화)
        * tree 배열의 리프 노드 영역에 데이터 입력받기
        * setTree(트리의 크기)     // 초기 트리를 생성하는 함수
        * for(M만큼 반복하기){
        *   getMin(tree에서 시작 인덱스, tree에서 종료 인덱스)    // 최솟값을 구하는 함수 호출 및 출력하기
        * }
        *
        * // 범위의 최솟값을 구하는 함수
        * getMin(시작 인덱스, 종료 인덱스){
        *   Min(범위의 최솟값을 나타내는 변수, MAX_VALUE로 초기화)
        *   while(시작 인덱스와 종료 인덱스가 교차될 때까지){
        *       if(시작 인덱스 % 2 == 1){
        *           Min과 현재 인덱스의 트리값을 비교해 작은 값을 Min 변수에 저장
        *           시작 인덱스 증가
        *       }
        *       if(종료 인덱스 % 2 == 0){
        *           Min과 현재 인덱스의 트리값을 비교해 작은 값을 Min 변수에 저장
        *           종료 인덱스 감소
        *       }
        *       시작 인덱스 = 시작 인덱스 / 2
        *       종료 인덱스 = 종료 인덱스 / 2
        *   }
        *   Min 값 리턴하기
        * }
        *
        * // 초기 트리 생성 함수 구현하기
        * setTree(트리의 마지막 인덱스){
        *   while(인덱스가 루트가 아닐 때까지 반복하기){
        *       트리의 인덱스 / 2 부분(부모 노드)의 값과 현재의 값을 비교해 현재의 값이 더 작을 때
        *       해당 값을 트리의 인덱스 / 2 부분(부모 노드)에 저장하기
        *       index 1개 감소
        *   }
        * }
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 수의 개수
        int M = Integer.parseInt(st.nextToken());   // 구간의 최솟값을 구하는 횟수
        int treeHeight = 0;
        int length = N;
        while(length !=0){
            length /=2;
            treeHeight++;
        }
        int treeSize = (int)Math.pow(2,treeHeight+1);
        int leftNodeStartIndex = treeSize /2-1;
        // 트리 초기화하기
        tree = new long[treeSize+1];
        for(int i=0; i<tree.length;i++)
            tree[i]=Integer.MAX_VALUE;
        // 데이터 입력받기
        for(int i = leftNodeStartIndex +1;i<=leftNodeStartIndex +N;i++)
            tree[i] = Long.parseLong(br.readLine());
        setTree(treeSize-1);        // tree 만들기
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s = s + leftNodeStartIndex;
            e = e + leftNodeStartIndex;
            System.out.println(getMin(s,e));
        }
        br.close();
    }
    private static long getMin(int s, int e){ // 범위의 최솟값을 구하는 함수
        long Min = Long.MAX_VALUE;
        while(s<=e){
            if(s%2==1){
                Min = Math.min(Min,tree[s]);
                s++;
            }
            s = s/2;
            if(e%2 == 0){
                Min = Math.min(Min,tree[e]);
                e--;
            }
            e = e/2;
        }
        return Min;
    }
    private static void setTree(int i){     // 초기 트리 생성 함수 구현하기
        while(i!=1){
            if(tree[i/2]>tree[i])
                tree[i/2]=tree[i];
            i--;
        }
    }
}
