package line;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class test05 {
	public String[] solution(String[][] dataSource, String[] tags) {
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		Set<Doc> list = new TreeSet<>(new Comparator<Doc>() {
			@Override
			public int compare(Doc o1, Doc o2) {
				if (o1.count == o2.count) {
					return o1.name.compareTo(o2.name);
				}
				return o1.count - o2.count;
			}
		});
		for (int i = 0; i < dataSource.length; i++) {
			list.add(new Doc(dataSource[i][0]));
			Set<String> set = new HashSet<String>();
			for (int j = 1; j < dataSource[i].length; j++) {
				set.add(dataSource[i][j]);
			}
			map.put(dataSource[i][0], set);
		}
		for (int i = 0; i < tags.length; i++) {
			for (String key : map.keySet()) {
				if (map.get(key).contains(tags[i])) {
				}
			}
		}

		String[] answer = {};
		return answer;
	}

	public class Doc {
		String name;
		int count;

		public Doc(String name) {
			super();
			this.name = name;
			this.count = 0;
		}
	}
}
