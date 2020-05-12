package mathOne.baekjoon;

// 1193 �м�ã��
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class SearchingFraction {
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        
        int i = 0; // �ش�ĭ�� �����ϴ� �и� or ���� �� (ex i = 3 �̸� 1/3 �Ǵ� 1/3)
        int sum = 0; // n - sum�� n��ġ�� �и� or ���� ��.
        while (i + sum < n) { 
            sum += i++;
        }
        // ���� + �и� ���� i + 1
        int a = 0;
        if (i % 2 == 0) { // ¦���� a / b
            a = n - sum;
        } else {
            a= i + 1 - (n - sum); // Ȧ���� b / a
        }
        
        int b = i + 1 - a;
        
        System.out.println(a + "/" + b);
        br.close();
       
    }
}

/* 1. Ȧ�� , ¦�� ĭ�϶� ���� ���������� ���ΰ����� ��Ģ ���Ⱑ��
 * 2. �� ĭ�� �и� + ������ ���� �����ϴٴ� ��Ģ ���� ����
 * 3. n��°�� ���� �Ǵ� �и��� ���� n - n��° ���� ĭ�� �� ���� ����*/

