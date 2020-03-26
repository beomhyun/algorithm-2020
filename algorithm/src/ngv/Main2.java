package ngv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		Node[] node = new Node[N];
		for (int i = 0; i < node.length; i++) {
			node[i] = new Node();

		}
		for (int i = 0; i < N; i++) {
			int j = sc.nextInt() - 1;
			if (j == -1)
				continue;
			node[i].parent = j;
			node[j].son.add(i);
		}
		HashSet<Integer>[] sons = new HashSet[N];
		for (int i = 0; i < sons.length; i++) {
			sons[i] = new HashSet<Integer>();
			int index = i;
			while (true) {
				boolean check = false;
				for (int son : node[index].son) {
					index = son;
					check = true;
					sons[i].add(index);
				}
				if (!check)
					break;
			}
		}

		int answer = 0;
		for (int i = 0; i < M; i++) {
			int l = sc.nextInt() - 1;
			int k = sc.nextInt() - 1;
			for (int nodeIndex : sons[l]) {
				if (!sons[k].contains(k)) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	public static class Node {
		int parent;
		ArrayList<Integer> son;

		public Node() {
			super();
			this.son = new ArrayList<Integer>();
		}

	}
}
