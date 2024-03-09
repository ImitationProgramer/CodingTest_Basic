package Tree.Trie;

import java.util.Scanner;

public class BaekJoon14425_FindString {
    public static void main(String[] args) {
        /*
        * n(집합 S의 문자열 개수) m(검사할 문자열 개수)
        * while(n만큼 반복하기){  // 트라이 자료구조 구축하기
        *   text(집합 S의 문자열)
        *   현재 노드를 루트 노드로 설정하기
        *   for(i를 text 문자열 길이 만큼 반복하기){
        *       c(i번째 문자)
        *       if(c 변수에 해당하는 다음 노드가 null) 신규 노드 생성하기
        *           현재 노드를 c 변수 노드로 변경하기
        *       if(i가 문자열의 마지막이면) isEnd 변수를 true로 설정하기
        *   }
        * }
        * count(정답 변수)
        * while(m만큼 반복하기){  // 트라이 자료구조 검색하기
        *   text(검색 문자열)
        *   현재 노드를 루트 노드로 설정하기
        *   for(i를 text 문자열 길이 만큼 반복하기){
        *       c(i번째 문자)
        *       if(c 변수에 해당하는 다음 노드가 null) 이 문자열 검색 종료
        *           현재 노드를 c 변수 노드로 변경하기
        *       if(i가 문자열의 마지막이고, 현재 노드의 isEnd값이 true이면) count값 올리기
        *   }
        * }
        * count 출력하기
        * // 트라이 자료구조를 위한 t노드 class 구현하기
        * class t 노드{
        *   next(다음 노드 배열) //26size 배열로 선언하기
        *   isEnd(마지막 문자열 여부 표시하기)
        * }
        * */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        tNode root = new tNode();
        while(n>0){ // 트라이 자료구조 구축하기
            String text = sc.next();
            tNode now = root;
            for(int i=0;i<text.length();i++){
                char c = text.charAt(i);
                // 26개 알파벳의 위치를 배열 index로 나타내기 위해 -'a' 수행하기
                if(now.next[c-'a']==null)
                    now.next[c-'a']=new tNode();
                now = now.next[c-'a'];
                if(i==text.length()-1)
                    now.isEnd = true;
            }
            n--;
        }
        int count =0;
        while(m>0){ // 트라이 자료구조 검색하기
            String text = sc.next();
            tNode now =root;
            for(int i=0;i<text.length();i++){
                char c = text.charAt(i);
                if(now.next[c-'a']==null)   // 공백 노드라면 이 문자열을 포함하지 않음]
                    break;
                now = now.next[c-'a'];
                if(i==text.length()-1 && now.isEnd) // 문자열의 끝이고 현재까지 모두 일치하면
                    count++;                        // S 집합에 포함되는 문자열
            }
            m--;
        }
        System.out.println(count);
    }
}
class tNode{
    tNode[] next = new tNode[26];
    boolean isEnd;      // 문자열의 마지막 유무를 표시하기
}
