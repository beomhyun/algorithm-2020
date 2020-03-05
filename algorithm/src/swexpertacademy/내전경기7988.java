package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 내전경기7988 {
	static boolean answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int K = Integer.parseInt(br.readLine());
			Map<String, Set<String>> map = new HashMap<>();
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String temp1 = st.nextToken();
				String temp2 = st.nextToken();

				if (map.containsKey(temp1)) {
					map.get(temp1).add(temp2);
				} else {
					Set<String> list = new HashSet();
					list.add(temp2);
					map.put(temp1, list);
				}
				if (map.containsKey(temp2)) {
					map.get(temp2).add(temp1);
				} else {
					Set<String> list = new HashSet();
					list.add(temp1);
					map.put(temp2, list);
				}
			}
			answer = false;
			boolean[] team = new boolean[map.size()];
			team[0] = true;
			dfs(map, map.keySet().stream().collect(Collectors.toList()), team, 1);

			if (answer)
				System.out.println("#" + testCase + " Yes");
			else
				System.out.println("#" + testCase + " No");

		}
	}

	static void dfs(Map<String, Set<String>> map, List<String> list, boolean[] team, int k) {
		if (answer)
			return;
		if (k == list.size()) {
			boolean check = team[0];
			boolean isCan = false;
			for (int i = 1; i < team.length; i++) {
				if (check != team[i]) {
					isCan = true;
				}
			}
			if (isCan)
				answer = true;
			return;
		}
		Set<String> set = map.get(list.get(k));
		boolean check = false;

		for (int i = 0; i < k; i++) {
			if (map.get(list.get(i)).contains(list.get(k))) {
				if (check && team[k] == team[i])
					return;
				else {
					check = true;
					team[k] = !team[i];
				}
			}
		}
		if(!check) {
			dfs(map, list, team, k+1);
			team[k] = true;
			dfs(map, list, team, k+1);
		} else {
			dfs(map, list, team, k+1);
		}
	}
}
