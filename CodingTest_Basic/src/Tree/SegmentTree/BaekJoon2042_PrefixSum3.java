package Tree.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2042_PrefixSum3 {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        /*
        * tree(세그먼트 트리 배열)
        * N(수의 개수), M(변경이 일어나는 개수), K(구한 합을 구하는 개수)
        * treeSize 구하기 -> Math.pow(2, 트리의 높이 + 1)
        * leftNodeStartIndex 구하기 -> treeSize / 2 - 1 // 리프 노드 시작 인덱스
        * tree 배열의 리프 노드 영역에 데이터 입력받기
        * setTree(트리의 크기)               // 초기 트리를 생성하는 함수
        * for(M+K만큼 반복하기){
        *   a(질의 유형), s(시작 인덱스), e(변경값 또는 종료 인덱스)
        *   a가 1일 때 -> changeVal(tree에서 시작 인덱스, e(변경값))     // 데이터 변경 함수
        *   a가 2일 때 -> getsum(tree에서 시작 인덱스, tree에서 종료 인덱스) // 구간 합 함수 호출 및 출력하기
        * }
        * // 구간 합을 구하는 함수 구현하기
        * getsum(시작 인덱스, 종료 인덱스){
        *   while(시작 인덱스와 종료 인덱스가 교차될 때까지){
        *       if(시작 인덱스 % 2 == 1) 해당 노드의 값을 구간 합에 추가하거나 시작 인덱스 증가
        *       if(종료 인덱스 % 2 == 0) 해당 노드의 값을 구간 합에 추가하거나 종료 인덱스 감소
        *           시작 인덱스 = 시작 인덱스 / 2
        *           종료 인덱스 = 종료 인덱스 / 2
        *   }
        *   구간 합 결과 리턴하기
        * }
        *
        * // 값 변경 함수 구현하기
        * changeVal(시작 인덱스, 변경값){
        *   diff(현재 노드의 값과 변경된 값의 차이)
        *   while(시작 인덱스가 0보다 크다){
        *       시작 인덱스의 트리값에 diff값을 더함
        *       시작 인덱스 = 시작 인덱스 / 2
        *   }
        * }
        *
        * // 초기 트리 생성 함수 구현하기
        * setTree(트리의 마지막 인덱스){
        *   while(인덱스가 루트가 아닐 때까지 반복하기){
        *       트리의 인덱스 / 2 부분(부모 노드)에 현재 index의 트리값 더하기
        *       index 1개 감소
        *   }
        * }
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 수의 개수
        int M = Integer.parseInt(st.nextToken());   // 변경이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken());   // 구간 합을 구하는 횟수
        int treeHeight = 0;
        int length = N;
        while(length != 0){
            length /=2;
            treeHeight++;
        }
        int treeSize = (int)Math.pow(2,treeHeight+1);
        int leftNodeStartIndex = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        // 데이터를 리프 노드에 입력받기
        for(int i = leftNodeStartIndex + 1; i<=leftNodeStartIndex + N;i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize-1);        // tree 만들기
        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if(a==1){       // 변경
                changeVal(leftNodeStartIndex + s,e);
            }else if(a==2){     // 구간 합
                s = s + leftNodeStartIndex;
                e = e + leftNodeStartIndex;
                System.out.println(getSum(s,(int)e));
            }else{
                return;
            }
        }
        br.close();
    }
    private static long getSum(int s, int e){   // 구간 합을 구하는 함수
        long partSum = 0;
        while(s<=e){
            if(s%2==1){
                partSum = partSum + tree[s];
                s++;
            }
            if(e%2==0){
                partSum = partSum + tree[e];
                e--;
            }
            s = s/2;
            e = e/2;
        }
        return partSum;
    }
    private static void changeVal(int index, long val){ // 값을 변경하는 함수
        long diff = val - tree[index];
        while(index > 0) {
            tree[index] = tree[index]+diff;
            index = index/2;
        }
    }

    private static void setTree(int i){
        while(i != 1){
            tree[i/2]+=tree[i];
            i--;
        }
    }
}
