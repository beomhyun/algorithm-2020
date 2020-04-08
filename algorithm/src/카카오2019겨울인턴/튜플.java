package 카카오2019겨울인턴;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 튜플 {
	public static int[] solution(String s) {
		List<List<Integer>> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder(s.substring(1, s.length() - 1));
		String[] strs = sb.toString().split("},");
		for (int i = 0; i < strs.length; i++) {
			String tmp = strs[i].replace("{", "");
			tmp = tmp.replace("}", "");
			String[] nums = tmp.split(",");
			List<Integer> tmpList = new ArrayList<Integer>();
			for (int j = 0; j < nums.length; j++) {
				tmpList.add(Integer.parseInt(nums[j]));
			}
			list.add(tmpList);
		}
		list.sort(new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.size() - o2.size();
			}
		});
		int[] answer = new int[list.size()];
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				int tmp = list.get(i).get(j);
				if (set.contains(tmp)) {
					continue;
				} else {
					set.add(tmp);
					answer[i] = tmp;
					break;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		System.out.println(solution(s));
	}
}
