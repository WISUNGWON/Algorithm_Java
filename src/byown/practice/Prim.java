package byown.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

// 최소신장트리 Prim 알고리즘
/*
 * 입력값
 * 7 정점 수
 * 11 간선 수
 * 1 2 2 1번 정점과 2번 정점이 2의 비용으로 연결
 * 2 3 5
 * 1 3 20
 * 1 4 10
 * 4 5 1
 * 5 6 23
 * 3 6 3
 * 3 5 6
 * 7 6 9
 * 7 3 2
 * 2 7 7
 */

class Node {
    int s, e, v;
    public Node(int s, int e, int v) {
        super();
        this.s = s;
        this.e = e;
        this.v = v;
    }
}



public class Prim {
    static int N;
    static int E;
    static ArrayList<Node>[] nodeList;
    static boolean visit[];
    static int ans;
    static ArrayList<Node> array = new ArrayList<Node>();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ans = 0; //최종 최소 비용 출력을 위한 변수
            N = Integer.valueOf(br.readLine()); // 정점의 개수
            E = Integer.valueOf(br.readLine()); // 간선의 개수
            visit = new boolean[N + 1]; //방문체크용 배열 
            
            nodeList = new ArrayList[N + 1]; // 각 노드의 연결상태를 저장하는 ArrayList;
            
            for (int i = 1; i <= N; i++) {
                nodeList[i] = new ArrayList<Node>();
            }
            
            String[] tempStr;
            int start;
            int end;
            int value;
            for (int i = 0; i < E; i++) {
                tempStr = br.readLine().split(" ");
                start = Integer.valueOf(tempStr[0]);
                end = Integer.valueOf(tempStr[1]);
                value = Integer.valueOf(tempStr[2]);
                nodeList[start].add(new Node(start, end, value));
                nodeList[end].add(new Node(end, start, value));
            }
            
            MST();
            System.out.println();
    }
    
    public static void MST() {
        Comp cp = new Comp(); // 우선순위 큐를 활용해서 Min Heap을 구현
        PriorityQueue<Node> pq = new PriorityQueue<>(cp); // 비용이 가장 작은 간선을 바로 뽑기 위한 우선순위 큐
        Deque<Integer> dq = new ArrayDeque<>(); //정점 모두를 방문하는데 쓸 큐
        dq.add(1); //시작점을 1번으로 지정
        ArrayList<Node> tempList;
        Node tempNode;
        while (!dq.isEmpty()) {
            // 큐에서 하나 빼서 주변의 노드를 다 넣음
            int currentNode = dq.poll(); //최초 currentNode는 1
            visit[currentNode] = true;
            tempList = nodeList[currentNode];
            for (int i = 0; i < tempList.size(); i++) {
                if (!visit[tempList.get(i).e]) {
                    pq.add(tempList.get(i));
                }
            }
        
            while (!pq.isEmpty()) {
                tempNode = pq.poll();
                if (!visit[tempNode.e]) {
                    visit[tempNode.e] = true;
                    ans = ans + tempNode.v;
                    dq.add(tempNode.e);
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
class Comp implements Comparator<Node> { //비용에 대한 Min Heap을 만들기 위한 우선순위 큐의 Comparator
    @Override
    public int compare(Node arg0, Node arg1) {
        return arg0.v > arg1.v ? 1 : -1;
    }
}
