package line;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class test06 {
	public static String[] solution(String[] directory, String[] command) {
		Dir root = new Dir("");
		for (int i = 0; i < directory.length; i++) {
			String[] dirs = directory[i].split("/");
			Dir tmp = root;
			for (int j = 1; j < dirs.length; j++) {
				if (tmp.child.containsKey(dirs[j])) {
					tmp = tmp.child.get(dirs[j]);
				} else {
					tmp.child.put(dirs[j], new Dir(dirs[j]));
				}
			}
		}

		for (int i = 0; i < command.length; i++) {
			String[] comm = command[i].split(" ");
			if (comm[0].equals("mkdir")) {
				mkdir(root, comm[1]);
			} else if (comm[0].equals("cp")) {
				cp(root, comm[1], comm[2]);
			} else {
				rm(root, comm[1]);
			}
		}
		answerList = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				o1.replaceAll("/", "a");
				o2.replaceAll("/", "a");
				return o1.compareTo(o2);
			}
		});
		answerList.add("/");
		dfs(root, "");
		System.out.println(answerList);
		String[] answer = {};
		return answer;
	}

	static Set<String> answerList;

	public static void dfs(Dir dir, String name) {
		if (dir.child.size() == 0) {
			return;
		}

		for (String key : dir.child.keySet()) {
			answerList.add(name + "/" + key);
			dfs(dir.child.get(key), name + "/" + key);
		}
	}

	public static void cp(Dir root, String dir1, String dir2) {
		Dir tmp1 = root;
		String[] dirs1 = dir1.split("/");
		for (int j = 1; j < dirs1.length; j++) {
			if (tmp1.child.containsKey(dirs1[j])) {
				tmp1 = tmp1.child.get(dirs1[j]);
			}
		}

		Dir tmp2 = root;
		String[] dirs2 = dir2.split("/");
		for (int j = 1; j < dirs2.length - 1; j++) {
			if (tmp2.child.containsKey(dirs2[j])) {
				tmp2 = tmp2.child.get(dirs2[j]);
			}
		}

		tmp1.child.put(dirs2[dirs2.length - 1], tmp2);
	}

	public static void mkdir(Dir root, String dir) {
		Dir tmp = root;
		String[] dirs = dir.split("/");
		for (int j = 1; j < dirs.length; j++) {
			if (tmp.child.containsKey(dirs[j])) {
				tmp = tmp.child.get(dirs[j]);
			} else {
				tmp.child.put(dirs[j], new Dir(dirs[j]));
			}
		}
	}

	public static void rm(Dir root, String dir) {
		Dir tmp = root;
		String[] dirs = dir.split("/");
		for (int j = 1; j < dirs.length - 1; j++) {
			if (tmp.child.containsKey(dirs[j])) {
				tmp = tmp.child.get(dirs[j]);
			}
		}
		tmp.child.remove(dirs[dirs.length - 1]);
	}

	public static class Dir {
		String name;
		Map<String, Dir> child;

		public Dir(String name) {
			super();
			this.name = name;
			this.child = new HashMap<>();
		}

		@Override
		public String toString() {
			return this.name;
		}

	}

	public static void main(String[] args) {
		String[] directory = { "/", "/hello", "/hello/tmp", "/root", "/root/abcd", "/root/abcd/etc",
				"/root/abcd/hello" };
		String[] command = { "mkdir /root/tmp", "cp /hello /root/tmp", "rm /hello" };

		solution(directory, command);

	}
}
