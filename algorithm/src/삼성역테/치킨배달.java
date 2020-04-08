package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<xy> chiken = new ArrayList<>();
		List<xy> home = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 2) {
					chiken.add(new xy(i, j));
				} else if (tmp == 1) {
					home.add(new xy(i, j));
				}
			}
		}
		answer = Integer.MAX_VALUE;
		dfs(chiken, new ArrayList(), 0, home, M);
		
		System.out.println(answer);
	}

	public static void dfs(List<xy> chiken, List<xy> choose, int d, List<xy> home, int M) {
		if (choose.size() == M) {
			int chikenDistance = 0;
			for (int i = 0; i < home.size(); i++) {
				int tmp = Integer.MAX_VALUE;
				xy xy1 = home.get(i);
				for (int j = 0; j < choose.size(); j++) {
					xy xy2 = choose.get(j);
					int tmpDistance = dis(xy1, xy2);
					if (tmp > tmpDistance) {
						tmp = tmpDistance;
					}
				}
				chikenDistance += tmp;
			}
			if (answer > chikenDistance) {
				answer = chikenDistance;
			}
			return;
		}
		if (d == chiken.size()) {
			return;
		}

		choose.add(chiken.get(d));
		dfs(chiken, choose, d + 1, home, M);
		choose.remove(choose.size() - 1);
		dfs(chiken, choose, d + 1, home, M);
	}

	public static int dis(xy xy1, xy xy2) {
		return Math.abs(xy1.x - xy2.x) + Math.abs(xy1.y - xy2.y);
	}

	public static class xy {
		int x;
		int y;

		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
