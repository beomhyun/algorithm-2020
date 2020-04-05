package line;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class test04 {
	public String[][] solution(String[][] snapshots, String[][] transactions) {
		final String save = "SAVE";
		Map<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < snapshots.length; i++) {
			map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}

		for (int i = 0; i < transactions.length; i++) {
			if (set.contains(Integer.parseInt(transactions[i][0])))
				continue;
			set.add(Integer.parseInt(transactions[i][0]));
			if (map.containsKey(transactions[i][2])) {
				if (transactions[i][1].equals(save)) {
					map.put(transactions[i][2], map.get(transactions[i][2]) + Integer.parseInt(transactions[i][3]));
				} else {
					map.put(transactions[i][2], map.get(transactions[i][2]) - Integer.parseInt(transactions[i][3]));
				}
			} else {
				if (transactions[i][1].equals(save)) {
					map.put(transactions[i][2], Integer.parseInt(transactions[i][3]));
				} else {
					map.put(transactions[i][2], -1 * Integer.parseInt(transactions[i][3]));
				}
			}
		}

		String[][] answer = new String[map.size()][2];
		int index = 0;
		for (String key : map.keySet()) {
			answer[index][0] = key;
			answer[index][1] = "" + map.get(key);
			index++;
		}
		return answer;
	}
}
