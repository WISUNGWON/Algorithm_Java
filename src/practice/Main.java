package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

class Node {
    int s, e ,v;
    public Node (int s, int e, int v) { // �� ��� ������ Ŭ������ ǥ��
        super();
        this.s = s;
        this.e = e;
        this.v = v;
    }
}

public class Main {
        
        static int N; // ����� ��
        static int E; // ������ �� 
        static ArrayList<Node>[] nodeList;
        static boolean visit[];
        static int ans;
        static ArrayList<Node> array = new ArrayList<Node>();
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ans = 0;
            N = Integer.valueOf(br.readLine()); // ����� ����
            E = Integer.valueOf(br.readLine()); // ������ ����
            visit = new boolean[N + 1]; // �湮üũ�� �迭
            
            nodeList = new ArrayList[N + 1];
            // �� ����� ������� �����ϴ� ArrayList;
            
            for (int i = 1; i <= N; i++) {
                nodeList[i] = new ArrayList<Node>();
            }
            
            // �� ���� ����Ϸ� 
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
            Comp cp = new Comp();
            PriorityQueue<Node> pq = new PriorityQueue<>(cp);
            Deque<Integer> dq = new ArrayDeque<>();
            dq.add(1); // �������� 1������ ����
            ArrayList<Node> tempList;
            Node tempNode;
            while (!dq.isEmpty()) {
                int currentNode = dq.poll();
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
                        System.out.println(tempNode.e);
                        ans += tempNode.v;
                        dq.add(tempNode.e);
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
        

 
}

class Comp implements Comparator<Node> {
    @Override
    public int compare(Node arg0, Node arg1) {
        return arg0.v > arg1.v ? 1 : -1;
    }
}


