package 프로그래머스.dfs;

import java.util.ArrayList;
import java.util.List;

public class 여행경로 {
	static List<String> answer;
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		solution(tickets);
	}
	public static String[] solution(String[][] tickets) {
		String begin = "ICN";
		List<String> travel = new ArrayList<String>();
		boolean[] used = new boolean[tickets.length];
		travel.add(begin);
		answer = new ArrayList<String>();
		dfs(tickets, used, travel, 0);
		System.out.println(answer);
		return answer.stream().toArray(size -> new String[size]);
	}

	static void dfs(String[][] tickets, boolean[] used, List<String> travel, int d) {
		if (d == tickets.length) {
			if (answer.size() == 0) {
				travel.forEach(str -> answer.add(str));
			} else {
				System.out.println(answer);
				System.out.println(travel);
				System.out.println();
				for (int i = 0; i < travel.size(); i++) {
					if (answer.get(i).equals(travel.get(i)))
						continue;
					else {
						String str1 = answer.get(i);
						String str2 = travel.get(i);
						for (int j = 0; j < str1.length(); j++) {
							if (str1.charAt(j) > str2.charAt(j)) {
								answer = new ArrayList<String>();
								travel.forEach(str -> answer.add(str));
								return;
							}
						}
					}
				}
			}
			return;
		}
		for (int i = 0; i < used.length; i++) {
			if (used[i])
				continue;
			if (travel.get(travel.size() - 1).equals(tickets[i][0])) {
				used[i] = true;
				travel.add(tickets[i][1]);
				dfs(tickets, used, travel, d + 1);
				used[i] = false;
				travel.remove(travel.size() - 1);
			}
		}
	}
}
