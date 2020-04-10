package 카카오2019겨울인턴;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 불량사용자 {
	public static int solution(String[] user_id, String[] banned_id) {
		List<Set<Integer>> list = new ArrayList<Set<Integer>>();
		for (int i = 0; i < banned_id.length; i++) {
			list.add(new HashSet<Integer>());
		}
		for (int i = 0; i < banned_id.length; i++) {
			String banId = banned_id[i];
			int count = 0;
			for (int j = 0; j < user_id.length; j++) {
				String userId = user_id[j];
				if (banId.length() != userId.length()) {
					continue;
				}
				boolean check = true;
				for (int k = 0; k < banId.length(); k++) {
					char c1 = banId.charAt(k);
					char c2 = userId.charAt(k);

					if (c1 == '*') {
						continue;
					}
					if (c1 != c2) {
						check = false;
						break;
					}
				}
				if (check) {
					list.get(i).add(j);
				}
			}
		}
		set = new HashSet<String>();
		dfs(list, new boolean[user_id.length], new HashSet(), 0);
		return set.size();
	}

	static Set<String> set;

	public static void dfs(List<Set<Integer>> list, boolean[] used, Set<Integer> choose, int d) {
		if (choose.size() == list.size()) {
			StringBuilder tmp = new StringBuilder();
			for (int i = 0; i < used.length; i++) {
				if(used[i]) {
					tmp.append(i);
				}
			}
			set.add(tmp.toString());
		}
		if (d == list.size()) {
			return;
		}
		for (int num : list.get(d)) {
			if (used[num]) {
				continue;
			}
			used[num] = true;
			choose.add(num);
			dfs(list, used, choose, d + 1);
			used[num] = false;
			choose.remove(num);
		}
	}

	public static void main(String[] args) {
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] baned_id = { "*rodo", "*rodo", "******" };
		System.out.println(solution(user_id, baned_id));

	}
}
