package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			que.add(i);
		}

		while (que.size() > 1) {
			int temp1 = que.poll();
			if (que.size() == 1) {
				break;
			}
			int temp2 = que.poll();
			que.add(temp2);
		}
		
		System.out.println(que.poll());
	}
}
