package 프로그래머스.dfs;

public class 네트워크 {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		int[] parent = new int[n];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 1) {
					union(parent, i, j);
				}
			}
		}
		for (int i = 0; i < parent.length; i++) {
			if(parent[i] == i) answer++;
		}
		return answer;
	}

	static void union(int[] parent, int a, int b) {
		if (findParent(parent, a) > findParent(parent, b)) {
			parent[b] = findParent(parent, a);
		} else {
			parent[a] = findParent(parent, b);
		}
	}

	static int findParent(int[] parent, int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = findParent(parent, parent[a]);
	}
}
