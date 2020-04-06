package algorithm.dongbin.sort;

public class HeapSort {
    
    // 1. 완전이진트리의 데이터 삽입 순서대로 배열에 담기
    static int[] heap = {7, 6, 5, 8, 3, 5, 9, 1, 6};
    
    public static void main(String[] args) {
        
        // 2. 전체 트리를 최대 Heap구조로 바꾸기 (하향식)
        for (int i = 1; i < heap.length; i++) {
            int c = i;
            do {
                int root = (c - 1) / 2; 
                if (heap[root] < heap[c]) {
                    int temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                c = root;
            } while (c != 0);
        }
        
        // 3. 크기를 줄여가며 반복적으로 힙을 구성
        for (int i = heap.length - 1; i >= 0; i--) {
            // 1) 최대값을 가장 마지막 노드와 교체
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            // 2) 마지막 값을 제외한 트리구조를 heap정렬
            int root = 0;
            int c = 1;
            do {
                c = 2 * root + 1;
                // 자식 중에 더 큰 값을 찾기
                if (c < i - 1 && heap[c] < heap[c + 1] ) {
                    c++;
                }
                // 루트보다 자식이 더 크다면 교환
                if (c < i && heap[root] < heap[c]) {
                    temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                root = c;
            } while (c < i);
        }
        for (int i = 0; i < heap.length; i++) {
            System.out.printf("%d ", heap[i]);
        }
       

    }
}